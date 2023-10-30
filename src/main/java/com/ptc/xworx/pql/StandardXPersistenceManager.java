package com.ptc.xworx.pql;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ptc.xworx.util.XException;

import wt.fc.ObjectSetVector;
import wt.fc.ObjectVectorIfc;
import wt.fc.PersistenceHelper;
import wt.fc.PersistenceServerHelper;
import wt.fc.QueryResult;
import wt.method.MethodContext;
import wt.pds.StatementSpec;
import wt.pom.PersistenceException;
import wt.pom.Transaction;
import wt.pom.WTConnection;
import wt.query.ArrayExpression;
import wt.services.ManagerException;
import wt.services.StandardManager;
import wt.util.WTException;
import wt.util.WTProperties;

public class StandardXPersistenceManager extends StandardManager implements XPersistenceManager {
	static final long serialVersionUID = 1;
	private static final Logger LOGGER = LoggerFactory.getLogger(StandardXPersistenceManager.class);
	private XPQLCacheLRU PQL_CACHE_LRU = new XPQLCacheLRU(500);

	public StandardXPersistenceManager() {
	}

	public static StandardXPersistenceManager newStandardXPersistenceManager() throws WTException {
		StandardXPersistenceManager services = new StandardXPersistenceManager();
		services.initialize();
		return services;
	}

	class XPQLCacheLRU extends LinkedHashMap<String, PQLCacheItem> {
		private static final long serialVersionUID = 1L;
		private int wateLine;

		public XPQLCacheLRU(int wateLine) {
			super((int) Math.ceil(wateLine / 0.75) + 1, 0.75f, true); // accessOrder为true，维护访问顺序
			this.wateLine = wateLine;
		}

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, PQLCacheItem> eldest) {
			return size() > wateLine;
		}

		public void setWateLine(int wateLine) {
			this.wateLine = wateLine;
		}
	}

	protected void performStartupProcess() throws ManagerException {
		try {
			WTProperties properties = WTProperties.getLocalProperties();
			String cacheCount = properties.getProperty("com.ptc.xworx.pql.cache.count");
			if (StringUtils.isNoneBlank(cacheCount)) {
				PQL_CACHE_LRU.setWateLine(Integer.parseInt(cacheCount));
			}
		} catch (NumberFormatException e) {
			throw new ManagerException(e.getLocalizedMessage());
		} catch (IOException e) {
			throw new ManagerException(e.getLocalizedMessage());
		}
	}

	private PQLCacheItem generateQuerySpec(String statement, Map<String, Object> arguments, boolean cached) throws WTException {
		if (cached) {
			PQLCacheItem cacheItem = PQL_CACHE_LRU.get(statement);
			if (cacheItem != null) {
				return cacheItem;
			} else {
				long l0 = System.currentTimeMillis();
				ParseTreeWalker treeWalker = new ParseTreeWalker();
				PQLanguageQueryListener listener = new PQLanguageQueryListener(arguments);
				ParseTree parseTree = XPersistenceHelper.parseStatement(statement, false);
				treeWalker.walk(listener, parseTree);
				StatementSpec querySpec = listener.getStatementSpec();
				cacheItem = PQLCacheItem.newItem(statement, querySpec, listener.getBindings());
				PQL_CACHE_LRU.put(statement, cacheItem);
				long l1 = System.currentTimeMillis();
				LOGGER.trace("Script walker spents time: " + (l1 - l0) + "ms");
				return cacheItem;
			}
		} else {
			long l0 = System.currentTimeMillis();
			ParseTreeWalker treeWalker = new ParseTreeWalker();
			PQLanguageQueryListener listener = new PQLanguageQueryListener(arguments);
			ParseTree parseTree = XPersistenceHelper.parseStatement(statement, false);
			treeWalker.walk(listener, parseTree);
			StatementSpec querySpec = listener.getStatementSpec();
			PQLCacheItem cacheItem = PQLCacheItem.newItem(statement, querySpec, listener.getBindings());
			long l1 = System.currentTimeMillis();
			LOGGER.trace("Script walker spents time: " + (l1 - l0) + "ms");
			return cacheItem;
		}
	}

	private String processPlaceHolder(String statement, Map<String, Object> arguments) {
		if (StringUtils.isBlank(statement) || arguments == null || arguments.isEmpty())
			return statement;

		String pql = statement;
		for (Entry<String, Object> entry : arguments.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			/**
			 * 处理PQL中的@占位符，以放便拼凑出完整的pql，主要用来进行pql拼凑
			 */
			if (key != null && key.trim().length() > 0 && value instanceof String) {
				pql = pql.replace("@" + key + " ", value + " ").replace("@" + key + ",", value + ",").replace("@" + key + "=", value + "=") //
						.replace("@" + key + ")", value + ")").replace("@" + key + ">", value + ">").replace("@" + key + "<", value + "<");
			}
		}

		return pql;
	}

	@Override
	public QueryResult query(String pql) {
		try {
			PQLCacheItem cacheItem = this.generateQuerySpec(pql, null, true);
			StatementSpec querySpec = cacheItem.cloneSpec();
			LOGGER.trace("StatementSpec script:" + querySpec.toString());
			return PersistenceServerHelper.manager.query(querySpec);
		} catch (Exception e) {
			XException.throwException(e);
		}
		return new QueryResult();
	}

	@Override
	public QueryResult query(String pql, Map<String, Object> arguments) {
		String statement = this.processPlaceHolder(pql, arguments);
		try {
			PQLCacheItem cacheItem = this.generateQuerySpec(statement, arguments, true);
			Map<Integer, String> bindings = cacheItem.getBindings();
			StatementSpec querySpec = cacheItem.cloneSpec(arguments);
			if (arguments != null) {
				for (Entry<Integer, String> entry : bindings.entrySet()) {
					int i = entry.getKey();
					String name = entry.getValue();
					Object value = null;
					if (arguments.containsKey(name)) {
						value = arguments.get(name);
					} else if (name.indexOf(".") > -1) {
						value = BeanUtils.getProperty(arguments, name);
					} else {
						throw new WTException("missing argument:" + name);
					}
					if (value instanceof Date) {
						if (value instanceof Timestamp) {
							querySpec.setBindParameterAt(value, i);
						} else {
							Timestamp time = new Timestamp(((Date) value).getTime());
							querySpec.setBindParameterAt(time, i);
						}
					} else if (value instanceof Object[]) {
						querySpec.setBindParameterAt(new ArrayExpression((Object[]) value), i);
					} else {
						querySpec.setBindParameterAt(value, i);
					}
				}
			}
			LOGGER.trace("StatementSpec script:" + querySpec.toString());
			return PersistenceServerHelper.manager.query(querySpec);
		} catch (Exception e) {
			XException.throwException(e);
		}
		return new QueryResult();
	}

	@Override
	public QueryResult find(String pql) {
		try {
			PQLCacheItem cacheItem = this.generateQuerySpec(pql, null, true);
			StatementSpec querySpec = cacheItem.cloneSpec();
			LOGGER.trace("StatementSpec script:" + querySpec.toString());
			return PersistenceHelper.manager.find(querySpec);
		} catch (Exception e) {
			XException.throwException(e);
		}
		return new QueryResult();
	}

	@Override
	public QueryResult find(String pql, Map<String, Object> arguments) {
		return this.find(pql, arguments, true);
	}

	@Override
	public QueryResult find(String pql, Map<String, Object> arguments, boolean cached) {
		String statement = this.processPlaceHolder(pql, arguments);
		LOGGER.trace("PQL script:" + statement);
		LOGGER.trace("PQL arguments:" + arguments);
		try {
			PQLCacheItem cacheItem = this.generateQuerySpec(statement, arguments, cached);
			Map<Integer, String> bindings = cacheItem.getBindings();
			StatementSpec querySpec = cacheItem.cloneSpec(arguments);
			if (arguments != null) {
				for (Entry<Integer, String> entry : bindings.entrySet()) {
					int i = entry.getKey();
					String name = entry.getValue();
					Object value = null;
					if (arguments.containsKey(name)) {
						value = arguments.get(name);
					} else if (name.indexOf(".") > -1) {
						value = BeanUtils.getProperty(arguments, name);
					} else {
						throw new WTException("missing argument:" + name);
					}
					if (value instanceof Date) {
						if (value instanceof Timestamp) {
							querySpec.setBindParameterAt(value, i);
						} else {
							Timestamp time = new Timestamp(((Date) value).getTime());
							querySpec.setBindParameterAt(time, i);
						}
					} else if (value instanceof Object[]) {
						querySpec.setBindParameterAt(new ArrayExpression((Object[]) value), i);
					} else {
						querySpec.setBindParameterAt(value, i);
					}
				}
			}
			LOGGER.trace("StatementSpec script:" + querySpec.toString());
			return PersistenceHelper.manager.find(querySpec);
		} catch (Exception e) {
			XException.throwException(e);
		}
		return new QueryResult();
	}

	public QueryResult nQuery(String sql, Object[] params) {
		LOGGER.trace("query input:" + sql);
		try {
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconnection = (WTConnection) methodContext.getConnection();
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				statement = wtconnection.prepareStatement(sql);
				int i = 1;
				for (Object param : params) {
					statement.setObject(i++, param);
				}
				resultSet = statement.executeQuery();
				ResultSetMetaData metaData = resultSet.getMetaData();
				int colnum = metaData.getColumnCount();
				ObjectVectorIfc objvector = new ObjectSetVector();
				while (resultSet.next()) {
					Object[] objs = new Object[colnum];
					for (int j = 0; j < colnum; j++) {
						objs[j] = resultSet.getObject(j + 1);
					}
					objvector.addElement(objs);
				}
				return new QueryResult(objvector);
			} finally {
				try {
					if (resultSet != null)
						resultSet.close();
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			}
		} catch (Exception e) {
			XException.throwException(e);
		}
		return new QueryResult();
	}

	@Override
	public int nUpdate(String sql) {
		LOGGER.trace("update input:" + sql);
		int result = 0;
		try {
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconnection = (WTConnection) methodContext.getConnection();
			Transaction tran = new Transaction();
			PreparedStatement statement = null;
			try {
				tran.start();
				statement = wtconnection.prepareStatement(sql);
				result = statement.executeUpdate();
				tran.commit();
				tran = null;
			} finally {
				try {
					if (tran != null)
						tran.rollback();
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			}
		} catch (Exception e) {
			XException.throwException(e);
		}

		return result;
	}

	public boolean nInsert(String sql) {
		LOGGER.trace("insert input:" + sql);
		boolean result = false;
		try {
			PQLanguageInsertListener listener = new PQLanguageInsertListener();
			ParseTreeWalker walker = new ParseTreeWalker();
			ParseTree parseTree = XPersistenceHelper.parseStatement(sql, false);
			walker.walk(listener, parseTree);

			Transaction transaction = new Transaction();
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconn = (WTConnection) methodContext.getConnection();
			PreparedStatement statement = null;
			try {
				transaction.start();
				String psql = listener.getSQLStatement();
				statement = wtconn.prepareStatement(psql);
				Map<Integer, Object> paramMap = listener.getParameterMap();
				for (Entry<Integer, Object> entry : paramMap.entrySet()) {
					int i = entry.getKey();
					Object obj = entry.getValue();
					statement.setObject(i, obj);
				}
				result = statement.execute();
				transaction.commit();
				transaction = null;
			} finally {
				try {
					if (transaction != null)
						transaction.rollback();
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			}
		} catch (Exception e) {
			XException.throwException(e);
		}

		return result;
	}

	public boolean nInsert(List<String> sqls) {
		LOGGER.trace("execute sql:" + sqls);
		boolean result = false;
		try {
			Map<String, PreparedStatement> preparedMap = new HashMap<String, PreparedStatement>();
			Transaction tran = new Transaction();
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconnection = (WTConnection) methodContext.getConnection();
			try {
				tran.start();
				for (String sql : sqls) {
					PQLanguageInsertListener listener = new PQLanguageInsertListener();
					ParseTreeWalker walker = new ParseTreeWalker();
					ParseTree parseTree = XPersistenceHelper.parseStatement(sql, false);
					walker.walk(listener, parseTree);

					String psql = listener.getSQLStatement();
					PreparedStatement _statement = preparedMap.get(psql);
					if (_statement == null) {
						_statement = wtconnection.prepareStatement(psql);
						preparedMap.put(psql, _statement);
					} else {
						_statement.addBatch();
					}
					Map<Integer, Object> paramMap = listener.getParameterMap();
					for (Entry<Integer, Object> entry : paramMap.entrySet()) {
						int i = entry.getKey();
						Object obj = entry.getValue();
						_statement.setObject(i, obj);
					}
				}

				if (preparedMap.size() > 0) {
					for (PreparedStatement statement : preparedMap.values()) {
						statement.executeBatch();
					}
				}
				tran.commit();
				tran = null;
			} finally {
				SQLException excep = null;
				try {
					if (tran != null) {
						tran.rollback();
					}
				} finally {
					if (preparedMap.size() > 0) {
						for (PreparedStatement statement : preparedMap.values()) {
							try {
								statement.close();
							} catch (SQLException e) {
								excep = e;
							}
						}
					}
				}

				if (excep != null)
					throw excep;
			}
		} catch (Exception e) {
			XException.throwException(e);
		}
		return result;
	}

	public boolean nExecute(String sql, Object[] params) {
		LOGGER.trace("execute sql:" + sql);
		boolean result = false;
		try {
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconnection = (WTConnection) methodContext.getConnection();
			Transaction tran = new Transaction();
			PreparedStatement statement = null;
			try {
				tran.start();
				statement = wtconnection.prepareStatement(sql);
				int i = 1;
				for (Object param : params) {
					statement.setObject(i++, param);
				}
				result = statement.execute();
				tran.commit();
				tran = null;
			} finally {
				try {
					if (tran != null)
						tran.rollback();
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			}
		} catch (Exception e) {
			XException.throwException(e);
		}

		return result;
	}

	public boolean nExecute(String sql, List<Object[]> params) {
		LOGGER.trace("execute sql:" + sql);
		boolean result = false;
		try {
			MethodContext methodContext = MethodContext.getContext();
			WTConnection wtconnection = (WTConnection) methodContext.getConnection();
			Transaction tran = new Transaction();
			PreparedStatement statement = null;
			try {
				tran.start();
				statement = wtconnection.prepareStatement(sql);
				for (Object[] objs : params) {
					int i = 1;
					for (Object param : objs) {
						statement.setObject(i++, param);
					}
					statement.addBatch();
				}
				result = statement.execute();
				tran.commit();
				tran = null;
			} catch (PersistenceException e) {
				XException.throwException(e);
			} finally {
				try {
					if (tran != null)
						tran.rollback();
				} finally {
					if (statement != null) {
						statement.close();
					}
				}
			}
		} catch (Exception e) {
			XException.throwException(e);
		}

		return result;
	}
}
