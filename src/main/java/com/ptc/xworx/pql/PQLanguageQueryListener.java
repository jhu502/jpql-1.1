package com.ptc.xworx.pql;

import com.ptc.xworx.pql.logic.QLanguageParser;
import com.ptc.xworx.pql.logic.QLanguageParser.*;
import com.ptc.xworx.pql.logic.QLanguageParserBaseListener;
import com.ptc.xworx.util.XException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import wt.fc.Persistable;
import wt.introspection.ClassInfo;
import wt.introspection.WTIntrospectionException;
import wt.introspection.WTIntrospector;
import wt.pds.BindParameterUtil;
import wt.pds.QuerySpecStatementBuilder;
import wt.pds.StatementBuilder;
import wt.pds.StatementSpec;
import wt.query.*;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author hujin
 * @date 2014-01-08
 */
public class PQLanguageQueryListener extends QLanguageParserBaseListener {
	private static final Pattern DIGISET_PATTERN = Pattern.compile("[0-9]*");
	private static final Pattern NUMERIC_PATTERN = Pattern.compile("[0-9]+(\\.[0-9]+)?");
	private static final Pattern INTEGER_PATTERN = Pattern.compile("[0-9]+(\\.0+)?");
	private static final ThreadLocal<String> KEY_THREAD_LOCAL = new ThreadLocal<>();
	private char aliasGen = 'A';
	private static final String UNION = "UNION";
	private static final String UNIONALL = "UNIONALL";
	private Stack<SelectContext> selectStacks = new Stack<SelectContext>();
	private List<ConstantExpression> constList = new ArrayList<ConstantExpression>();
	private Map<String, Object> arguments = Collections.emptyMap();
	/**
	 * 记录传入的参数名和绑定的位置：Map<Integer, String>;
	 */
	private Map<Integer, String> bindings = new LinkedHashMap<>();
	private StatementSpec querySpec = null;

	static class FromBean {
		public String alias;
		public int index;
		public Object oName;

		public static FromBean newBean(String alias, int index, Object oName) {
			FromBean itemBean = new FromBean();
			itemBean.setAlias(alias);
			itemBean.setIndex(index);
			itemBean.setOName(oName);

			return itemBean;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public Object getOName() {
			return oName;
		}

		public void setOName(Object oName) {
			this.oName = oName;
		}

		public Class<?> getOClass() {
			if (oName instanceof Class<?>) {
				return (Class<?>) oName;
			} else {
				throw new XException("类型转换错误:" + oName + "无法转换成类.");
			}
		}
	}

	static class SelectContext {
		public SelectContext parent;
		public StatementSpec querySpec = null;
		public Set<String> selectItem = new HashSet<String>();
		public Map<String, FromBean> aliasMapping = new HashMap<>(); // Map<JPQL-Alias, {PQLQuerySpec-Alias, PQLQuerySpec-Index}>
		public SelectClauseContext selectClauseContext = null;
		public Stack<Object> conditionStack = new Stack<Object>();
		public Stack<Object> fromItemStack = new Stack<Object>();

		public SelectContext(SelectContext parent) {
			this.parent = parent;
		}

		/**
		 * 为PQLQuerySpec写入选择、条件、子查询条件时，有时候需要指定PQLQuerySpec生成的别名；
		 * 该方法就是通过JPQL指定的别名，找到对应生成的PQLQuerySpec别名；
		 *
		 * @param name
		 * @return
		 */
		public FromBean pickAlias(String name) {
			FromBean fromBean = getAlias(name);

			if (fromBean != null)
				return fromBean;

			if (this.parent == null)
				return null;
			else
				return pickAlias(this.parent, name);
		}

		public FromBean getAlias(String name) {
			return this.aliasMapping.get(name);
		}

		private FromBean pickAlias(SelectContext selectContext, String name) {
			FromBean formBean = selectContext.aliasMapping.get(name);

			if (formBean != null)
				return formBean;

			if (selectContext.parent == null)
				return null;
			else
				return pickAlias(selectContext.parent, name);
		}
	}

	public PQLanguageQueryListener() {
	}

	public PQLanguageQueryListener(Map<String, Object> arguments) {
		if (arguments != null) {
			this.arguments = arguments;
		}
	}

	private Stack<SelectContext> getSelectStack() {
		return this.selectStacks;
	}

	public StatementSpec getStatementSpec() throws WTException {
		if (!this.querySpec.isAdvancedQueryEnabled() && this.querySpec.isAdvancedQuery()) {
			this.querySpec.setAdvancedQueryEnabled(true);
		}

		return this.querySpec;
	}

	public Map<Integer, String> getBindings() {
		return this.bindings;
	}

	@Override
	public void enterStartPQLStatement(QLanguageParser.StartPQLStatementContext ctx) {
		for (ParseTree child : ctx.children) {
			if (child instanceof UnionContext) {
				UnionContext unionContext = (UnionContext) child;
				String key = unionContext.getText();
				if (UNION.equalsIgnoreCase(key)) {
					SelectContext selectContext = new SelectContext(null);
					selectContext.querySpec = new CompoundQuerySpec();
					try {
						((CompoundQuerySpec) selectContext.querySpec).setSetOperator(SetOperator.UNION);
					} catch (WTPropertyVetoException e) {
						XException.throwException(e);
					}

					this.getSelectStack().push(selectContext);

					if (this.querySpec == null)
						this.querySpec = selectContext.querySpec;
				} else if (UNIONALL.equalsIgnoreCase(key)) {
					SelectContext selectContext = new SelectContext(null);
					selectContext.querySpec = new CompoundQuerySpec();
					try {
						((CompoundQuerySpec) selectContext.querySpec).setSetOperator(SetOperator.UNION_ALL);
					} catch (WTPropertyVetoException e) {
						XException.throwException(e);
					}

					this.getSelectStack().push(selectContext);

					if (this.querySpec == null)
						this.querySpec = selectContext.querySpec;
				}
				break;
			}
		}
	}

	@Override
	public void exitStartPQLStatement(QLanguageParser.StartPQLStatementContext ctx) {
		if (!this.getSelectStack().isEmpty())
			this.getSelectStack().pop();
	}

	@Override
	public void enterSelectStatement(QLanguageParser.SelectStatementContext ctx) {
		ParserRuleContext parent = ctx.getParent();
		if (parent instanceof StartPQLStatementContext) {
			if (this.getSelectStack().isEmpty()) {
				SelectContext selectContext = new SelectContext(null);
				try {
					selectContext.querySpec = new PQLQuerySpec();
					((PQLQuerySpec) selectContext.querySpec).getFromClause().setAliasPrefix(this.riseAlias());
					if (this.querySpec == null)
						this.querySpec = selectContext.querySpec;
				} catch (WTPropertyVetoException | QueryException e) {
					XException.throwException(e);
				}

				this.getSelectStack().push(selectContext);
			} else {
				SelectContext parentContext = this.getSelectStack().peek();
				if (parentContext.querySpec instanceof CompoundQuerySpec) {
					SelectContext selectContext = new SelectContext(parentContext);
					try {
						selectContext.querySpec = new PQLQuerySpec();
						((QuerySpec) selectContext.querySpec).getFromClause().setAliasPrefix(this.riseAlias());
						((CompoundQuerySpec) parentContext.querySpec).addComponent(selectContext.querySpec);
						if (this.querySpec == null)
							this.querySpec = parentContext.querySpec;
					} catch (WTPropertyVetoException | QueryException e) {
						XException.throwException(e);
					}

					this.getSelectStack().push(selectContext);
				}
			}
		} else if (parent instanceof SubQueryContext) {
			SelectContext parentContext = this.getSelectStack().peek();
			SubSelectExpression subSelectExpress = (SubSelectExpression) parentContext.conditionStack.pop();
			SelectContext subSelectContext = new SelectContext(parentContext);
			subSelectContext.querySpec = subSelectExpress.getSubSelect();

			this.getSelectStack().push(subSelectContext);
		} else if (parent instanceof QueryFromContext) {
			SelectContext parentContext = this.getSelectStack().peek();
			SubSelectExpression subSelectExpress = (SubSelectExpression) parentContext.fromItemStack.pop();
			SelectContext subSelectContext = new SelectContext(parentContext);
			subSelectContext.querySpec = subSelectExpress.getSubSelect();

			this.getSelectStack().push(subSelectContext);
		}
	}

	@Override
	public void exitSelectStatement(QLanguageParser.SelectStatementContext ctx) {
		try {
			KEY_THREAD_LOCAL.set("SELECT");
			SelectContext selectContext = this.getSelectStack().peek();
			for (ParseTree child : selectContext.selectClauseContext.children) {
				if (child instanceof FieldItemContext) {
					FieldItemContext itemContext = (FieldItemContext) child;
					FieldContext fieldContext = itemContext.field();
					AliasContext aliasContext = itemContext.alias();
					try {
						ColumnExpression tableColumn = this.toColumnExpression(selectContext, fieldContext);
						if (this.isEmpty(aliasContext)) {
							((PQLQuerySpec) selectContext.querySpec).appendSelect(tableColumn, false);
						} else {
							tableColumn.setColumnAlias(aliasContext.getText());
							((PQLQuerySpec) selectContext.querySpec).appendSelect(tableColumn, true);
						}
					} catch (QueryException | WTPropertyVetoException e) {
						XException.throwException(e);
					}
				} else if (child instanceof ConstItemContext) {
					ConstItemContext itemContext = (ConstItemContext) child;
					ConstantContext constContext = itemContext.constant();
					AliasContext aliasContext = itemContext.alias();
					String object = this.trim(constContext.getText());
					try {
						ConstantExpression constExpression = new ConstantExpression(object);
						if (!isEmpty(aliasContext)) {
							((PQLQuerySpec) selectContext.querySpec).appendSelect(constExpression, false);
						} else {
							constExpression.setColumnAlias(aliasContext.getText());
							((PQLQuerySpec) selectContext.querySpec).appendSelect(constExpression, true);
						}
					} catch (QueryException | WTPropertyVetoException e) {
						XException.throwException(e);
					}
				} else if (child instanceof FuncItemContext) {
					try {
						FuncItemContext itemContext = (FuncItemContext) child;
						FunctionContext funcContext = itemContext.function();
						AliasContext aliasContext = itemContext.alias();
						SQLFunction sqlFunction = this.toSQLFunction(selectContext, funcContext);
						if (isEmpty(aliasContext)) {
							((PQLQuerySpec) selectContext.querySpec).appendSelect(sqlFunction, false);
						} else {
							sqlFunction.setColumnAlias(aliasContext.getText());
							((PQLQuerySpec) selectContext.querySpec).appendSelect(sqlFunction, true);
						}
					} catch (QueryException | WTPropertyVetoException e) {
						XException.throwException(e);
					}
				} else if (child instanceof DistinctContext) {
					try {
						((PQLQuerySpec) selectContext.querySpec).setDistinct(true);
					} catch (WTPropertyVetoException e) {
						XException.throwException(e);
					}
				} else if (child instanceof OverItemContext) {
					OverItemContext itemContext = (OverItemContext) child;
					ColumnExpression[] funcParam = null;
					ColumnExpression[] partParam = null;
					OrderBy[] orderBy = null;
					String funcName = "";

					for (ParseTree node : itemContext.children) {
						if (node instanceof FunctionContext) {
							try {
								SQLFunction sqlFunc = this.toSQLFunction(selectContext, (FunctionContext) node);
								funcName = sqlFunc.getName();
								Vector<?> vector = sqlFunc.getArguments();
								int size = vector.size();
								if (size > 0) {
									funcParam = new ColumnExpression[vector.size()];
									for (int i = 0; i < size; i++) {
										funcParam[i] = sqlFunc.getArgumentAt(i);
									}
								}
							} catch (QueryException e) {
								XException.throwException(e);
							}
						} else if (node instanceof PartitionClauseContext) {
							PartitionClauseContext clauseContext = (PartitionClauseContext) node;
							Vector<ColumnExpression> vector = new Vector<ColumnExpression>();
							for (FieldContext fieldNode : clauseContext.field()) {
								if (!this.isEmpty(fieldNode)) {
									vector.add(this.toColumnExpression(selectContext, fieldNode));
								}
							}
							int size = vector.size();
							if (size > 0) {
								partParam = new ColumnExpression[size];
								for (int i = 0; i < size; i++) {
									partParam[i] = vector.get(i);
								}
							}

						} else if (node instanceof OrderClauseContext) {
							OrderClauseContext orderClause = (OrderClauseContext) node;
							Vector<OrderBy> vector = new Vector<OrderBy>();
							for (OrderItemContext orderItem : orderClause.orderItem()) {
								try {
									vector.add(this.toOrderBy(selectContext, orderItem));
								} catch (QueryException e) {
									XException.throwException(e);
								}
							}
							int size = vector.size();
							if (size > 0) {
								orderBy = new OrderBy[size];
								for (int i = 0; i < size; i++) {
									orderBy[i] = vector.get(i);
								}
							}
						}
					}
					try {
						AnalyticFunction analyticFunc = AnalyticFunction.newAnalyticFunction(funcName, funcParam, partParam, orderBy);

						AliasContext aliasContext = itemContext.alias();
						if (this.isEmpty(aliasContext)) {
							((PQLQuerySpec) selectContext.querySpec).appendSelect(analyticFunc, false);
						} else {
							analyticFunc.setColumnAlias(aliasContext.getText());
							((PQLQuerySpec) selectContext.querySpec).appendSelect(analyticFunc, true);
						}
					} catch (QueryException | WTPropertyVetoException e) {
						XException.throwException(e);
					}
				}
			}

			this.getSelectStack().pop();
		} finally {
			KEY_THREAD_LOCAL.remove();
		}
	}

	@Override
	public void enterSelectClause(QLanguageParser.SelectClauseContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		selectcontext.selectClauseContext = ctx;
		for (ParseTree child : ctx.children) {
			if (child instanceof QLanguageParser.ObjectItemContext || child instanceof QLanguageParser.FieldItemContext) {
				selectcontext.selectItem.add(child.getText());
			}
		}
	}

	@Override
	public void enterWhereClause(QLanguageParser.WhereClauseContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		WhereClause whereClause = ((PQLQuerySpec) selectcontext.querySpec).getWhereClause();
		selectcontext.conditionStack.push(whereClause);
	}

	@Override
	public void exitWhereClause(QLanguageParser.WhereClauseContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		selectcontext.conditionStack.pop();
	}

	@Override
	public void enterClassFrom(QLanguageParser.ClassFromContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();
		try {
			ClassNameContext classContext = ctx.className();
			AliasContext aliasContext = ctx.alias();
			String className = classContext.getText();
			String aliasName = aliasContext.getText();
			if (selectContext.selectItem.contains(aliasName)) {
				Class<?> clazz = Class.forName(className);
				int a = ((PQLQuerySpec) selectContext.querySpec).appendClassList(clazz, true);
				String A = ((PQLQuerySpec) selectContext.querySpec).getFromClause().getAliasAt(a);
				if (selectContext.aliasMapping.containsKey(aliasName)) {
					throw new XException("alias " + aliasName + " is duplicated, please choose alias.");
				} else {
					selectContext.aliasMapping.put(aliasName, FromBean.newBean(A, a, clazz));
				}
			} else {
				Class<?> clazz = Class.forName(className);
				int a = ((PQLQuerySpec) selectContext.querySpec).appendClassList(clazz, false);
				String A = ((PQLQuerySpec) selectContext.querySpec).getFromClause().getAliasAt(a);
				if (selectContext.aliasMapping.containsKey(aliasName)) {
					throw new XException("alias " + aliasName + " is duplicated, please choose alias.");
				} else {
					selectContext.aliasMapping.put(aliasName, FromBean.newBean(A, a, clazz));
				}
			}
		} catch (QueryException | ClassNotFoundException e) {
			XException.throwException(e);
		}
	}

	@Override
	public void enterTableFrom(QLanguageParser.TableFromContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();
		TableNameContext tableContext = ctx.tableName();
		AliasContext aliasContext = ctx.alias();
		String tableName = tableContext.getText();
		String aliasName = aliasContext.getText();
		int a = ((PQLQuerySpec) selectContext.querySpec).appendFrom(new ExternalTableExpression(tableName));
		String A = ((PQLQuerySpec) selectContext.querySpec).getFromClause().getAliasAt(a);
		if (selectContext.aliasMapping.containsKey(aliasName)) {
			throw new XException("alias " + aliasName + " is duplicated, please choose alias.");
		} else {
			selectContext.aliasMapping.put(aliasName, FromBean.newBean(A, a, tableName));
		}
	}

	@Override
	public void enterQueryFrom(QLanguageParser.QueryFromContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();
		AliasContext aliasContext = ctx.alias();
		String aliasName = aliasContext.getText();

		try {
			PQLQuerySpec qs = new PQLQuerySpec();
			qs.getFromClause().setAliasPrefix(this.riseAlias());
			/** 设置为高级查询 */
			qs.setAdvancedQueryEnabled(true);
			SubSelectExpression subSelectExpress = new SubSelectExpression(qs);
			int a = ((PQLQuerySpec) selectContext.querySpec).appendFrom(subSelectExpress);
			String A = ((PQLQuerySpec) selectContext.querySpec).getFromClause().getAliasAt(a);

			if (selectContext.aliasMapping.containsKey(aliasName)) {
				throw new XException("alias " + aliasName + " is duplicated, please choose alias.");
			} else {
				selectContext.aliasMapping.put(aliasName, FromBean.newBean(A, a, qs));
			}
			selectContext.fromItemStack.push(subSelectExpress);
		} catch (WTPropertyVetoException | QueryException e) {
			XException.throwException(e);
		}
	}

	@Override
	public void enterXCondition(QLanguageParser.XConditionContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		Object where = selectcontext.conditionStack.peek();
		if (where instanceof WhereClause) {
			WhereClause whereClause = (WhereClause) where;
			LogicOpContext logicContext = ctx.logicOp();
			String logic = logicContext.getText();
			if ("AND".equalsIgnoreCase(logic)) {
				whereClause.appendAnd();
			} else if ("OR".equalsIgnoreCase(logic)) {
				whereClause.appendOr();
			}
		} else if (where instanceof CompositeWhereExpression) {
			CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
			LogicOpContext logicContext = ctx.logicOp();
			String logic = logicContext.getText();
			if ("AND".equalsIgnoreCase(logic)) {
				whereExpression.setOperator(LogicalOperator.AND);
			} else if ("OR".equalsIgnoreCase(logic)) {
				whereExpression.setOperator(LogicalOperator.OR);
			}
		}
	}

	@Override
	public void enterXComplex(QLanguageParser.XComplexContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		Object where = selectcontext.conditionStack.peek();
		if (where instanceof WhereClause) {
			WhereClause whereClause = (WhereClause) where;
			LogicOpContext logicContext = ctx.logicOp();
			String logict = logicContext.getText();
			if ("AND".equalsIgnoreCase(logict)) {
				whereClause.appendAnd();
			} else if ("OR".equalsIgnoreCase(logict)) {
				whereClause.appendOr();
			}
		} else if (where instanceof CompositeWhereExpression) {
			CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
			LogicOpContext logicContext = ctx.logicOp();
			String logict = logicContext.getText();
			if ("AND".equalsIgnoreCase(logict)) {
				whereExpression.setOperator(LogicalOperator.AND);
			} else if ("OR".equalsIgnoreCase(logict)) {
				whereExpression.setOperator(LogicalOperator.OR);
			}
		}
	}

	@Override
	public void enterComplex(QLanguageParser.ComplexContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		Object where = selectcontext.conditionStack.peek();
		if (where instanceof WhereClause) {
			WhereClause whereClause = (WhereClause) where;
			whereClause.appendOpenParen();
		}
	}

	public void _enterConditionComplex(QLanguageParser.ComplexContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		Object where = selectcontext.conditionStack.peek();
		CompositeWhereExpression compositeWhere = new CompositeWhereExpression();
		selectcontext.conditionStack.push(compositeWhere);
		if (where instanceof WhereClause) {
			WhereClause whereClause = (WhereClause) where;
			try {
				whereClause.append(compositeWhere, null, ((PQLQuerySpec) selectcontext.querySpec).getFromClause());
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if (where instanceof CompositeWhereExpression) {
			CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
			whereExpression.append(compositeWhere);
		}
	}

	@Override
	public void exitComplex(QLanguageParser.ComplexContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		Object where = selectcontext.conditionStack.peek();
		if (where instanceof WhereClause) {
			WhereClause whereClause = (WhereClause) where;
			whereClause.appendCloseParen();
		}
	}

	public void _exitConditionComplex(QLanguageParser.ComplexContext ctx) {
		SelectContext selectcontext = this.getSelectStack().peek();
		selectcontext.conditionStack.pop();
	}

	@Override
	public void enterCondition(QLanguageParser.ConditionContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();
		Object where = selectContext.conditionStack.peek();

		ParseTree left = ctx.getChild(0);
		String opt = ctx.getChild(1).getText().toUpperCase();
		switch (opt) {
		case "NOTLIKE":
			opt = "NOT LIKE";
			break;
		case "NOTIN":
			opt = "NOT IN";
			break;
		}
		ParseTree right = ctx.getChild(2);

		if ((left instanceof FieldContext) && (right instanceof FieldContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			FieldContext fieldR = (FieldContext) right;
			String nameR = fieldR.getChild(0).getText();

			FromBean fromR = selectContext.pickAlias(nameR);
			if (fromR == null) {
				throw new XException("alias " + nameR + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, toColumnExpression(selectContext, fieldR));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex(), fromR.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex(), fromR.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof XFieldContext) && (right instanceof FieldContext)) {
			XFieldContext fieldL = (XFieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			FieldContext fieldR = (FieldContext) right;
			String nameR = fieldR.getChild(0).getText();
			FromBean fromR = selectContext.pickAlias(nameR);
			if (fromR == null) {
				throw new XException("alias " + nameR + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, toColumnExpression(selectContext, fieldR));
				searchCondition.setOuterJoin(1);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex(), fromR.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex(), fromR.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			} catch (WTPropertyVetoException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof XFieldContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			XFieldContext fieldR = (XFieldContext) right;
			String nameR = fieldR.getChild(0).getText();
			FromBean fromR = selectContext.pickAlias(nameR);
			if (fromR == null) {
				throw new XException("alias " + nameR + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, toColumnExpression(selectContext, fieldR));
				searchCondition.setOuterJoin(PQLSearchCondition.RIGHT_OUTER_JOIN);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex(), fromR.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromR.getIndex(), fromR.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			} catch (WTPropertyVetoException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof NilContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			String R = "";
			if ("=".equals(opt)) {
				R = PQLSearchCondition.IS_NULL;
			} else if ("!=".equals(opt)) {
				R = PQLSearchCondition.NOT_NULL;
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), R);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof ConstantContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, this.toConstantExpression((ConstantContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof QMarkContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			ConstantExpression contExpr = new ConstantExpression();
			constList.add(contExpr);
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, contExpr);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof ConstantContext) && (right instanceof FieldContext)) {
			FieldContext fieldR = (FieldContext) right;
			String nameR = fieldR.getChild(0).getText();
			FromBean fromR = selectContext.pickAlias(nameR);
			if (fromR == null) {
				throw new XException("alias " + nameR + " don't exist.");
			}
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toConstantExpression((ConstantContext) left), opt, toColumnExpression(selectContext, fieldR));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromR.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromR.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof FunctionContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, this.toSQLFunction(selectContext, (FunctionContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof FieldContext)) {
			FieldContext fieldR = (FieldContext) right;
			String nameR = fieldR.getChild(0).getText();
			FromBean fromR = selectContext.pickAlias(nameR);
			if (fromR == null) {
				throw new XException("alias " + nameR + " don't exist.");
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, toColumnExpression(selectContext, fieldR));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromR.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromR.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof ConstantContext)) {
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, this.toConstantExpression((ConstantContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof ConstantContext) && (right instanceof FunctionContext)) {
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toConstantExpression((ConstantContext) left), opt, this.toSQLFunction(selectContext, (FunctionContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof FunctionContext)) {
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, this.toSQLFunction(selectContext, (FunctionContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof SubQueryContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			try {
				PQLQuerySpec qs = new PQLQuerySpec();
				qs.getFromClause().setAliasPrefix(this.riseAlias());
				/** 设置为高级查询 */
				qs.setAdvancedQueryEnabled(true);
				SubSelectExpression subSelect = new SubSelectExpression(qs);
				selectContext.conditionStack.push(subSelect);
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, subSelect);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (WTPropertyVetoException | QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof SubQueryContext)) {
			try {
				PQLQuerySpec qs = new PQLQuerySpec();
				qs.getFromClause().setAliasPrefix(this.riseAlias());
				/** 设置为高级查询 */
				qs.setAdvancedQueryEnabled(true);
				SubSelectExpression subSelect = new SubSelectExpression(qs);
				selectContext.conditionStack.push(subSelect);
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, subSelect);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (WTPropertyVetoException | QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof ArrayContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			List<Object> list = new ArrayList<Object>();
			ArrayContext arrayContext = (ArrayContext) right;
			for (ParseTree child : arrayContext.children) {
				String constant = child.getText();
				if (!("(".equalsIgnoreCase(constant) || ",".equalsIgnoreCase(constant) || ")".equalsIgnoreCase(constant))) {
					list.add(this.trim(constant));
				}
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(toColumnExpression(selectContext, fieldL), opt, new ArrayExpression(list.toArray()));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof ArrayContext)) {
			List<Object> list = new ArrayList<Object>();
			ArrayContext arrayContext = (ArrayContext) right;
			for (ParseTree child : arrayContext.children) {
				String constant = child.getText();
				if (!("(".equalsIgnoreCase(constant) || ",".equalsIgnoreCase(constant) || ")".equalsIgnoreCase(constant))) {
					list.add(this.trim(constant));
				}
			}

			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, new ArrayExpression(list.toArray()));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof RowNumContext) && (right instanceof ConstantContext)) {
			try {
				@SuppressWarnings("deprecation")
				PQLSearchCondition searchCondition = new PQLSearchCondition(new KeywordExpression("ROWNUM"), opt, this.toConstantExpression((ConstantContext) right));
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { -1 }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { -1 });
				}
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FieldContext) && (right instanceof ArgumentContext)) {
			FieldContext fieldL = (FieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			try {
				String argument = right.getChild(1).getText();
				Object value = PropertyUtils.getProperty(this.arguments, argument);
				PQLSearchCondition searchCondition = null;
				RelationalExpression expression = this.toRelationalExpression(value);
				if (expression instanceof ArrayExpression) {
					if ("=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), PQLSearchCondition.IN, expression);
					} else if ("!=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), PQLSearchCondition.NOT_IN, expression);
					} else if ("IN".equals(opt) || "NOT IN".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
						this.fixPQLSearchConditionIssue(searchCondition, opt, (ArrayExpression) expression);
					} else {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
					}
				} else {
					searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
				}
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj, argument);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (Exception e) {
				XException.throwException(e);
			}
		} else if ((left instanceof FunctionContext) && (right instanceof ArgumentContext)) {
			try {
				String argument = ((ArgumentContext) right).getChild(1).getText();
				Object value = PropertyUtils.getProperty(this.arguments, argument);

				PQLSearchCondition searchCondition = null;
				RelationalExpression expression = this.toRelationalExpression(value);
				if (expression instanceof ArrayExpression) {
					if ("=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), PQLSearchCondition.IN, expression);
					} else if ("!=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), PQLSearchCondition.NOT_IN, expression);
					} else {
						searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, expression);
					}
				} else {
					searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) left), opt, expression);
				}
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] {}, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj, argument);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] {});
				}
			} catch (Exception e) {
				XException.throwException(e);
			}
		} else if ((left instanceof XFieldContext) && (right instanceof ArgumentContext)) {
			XFieldContext fieldL = (XFieldContext) left;
			String nameL = fieldL.getChild(0).getText();
			FromBean fromL = selectContext.pickAlias(nameL);
			if (fromL == null) {
				throw new XException("alias " + nameL + " don't exist.");
			}

			try {
				String argument = ((ArgumentContext) right).getChild(1).getText();
				Object value = PropertyUtils.getProperty(this.arguments, argument);
				PQLSearchCondition searchCondition = null;
				RelationalExpression expression = this.toRelationalExpression(value);
				if (expression instanceof ArrayExpression) {
					if ("=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), PQLSearchCondition.IN, expression);
					} else if ("!=".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), PQLSearchCondition.NOT_IN, expression);
					} else if ("IN".equals(opt) || "NOT IN".equals(opt)) {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
						this.fixPQLSearchConditionIssue(searchCondition, opt, (ArrayExpression) expression);
					} else {
						searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
					}
					this.fixPQLSearchConditionIssue(searchCondition, opt, (ArrayExpression) expression);
				} else {
					searchCondition = new PQLSearchCondition(this.toColumnExpression(selectContext, fieldL), opt, expression);
				}
				searchCondition.setOuterJoin(PQLSearchCondition.LEFT_OUTER_JOIN);
				if (where instanceof WhereClause) {
					WhereClause whereClause = (WhereClause) where;
					Object obj = whereClause.append(searchCondition, new int[] { fromL.getIndex() }, ((PQLQuerySpec) selectContext.querySpec).getFromClause());
					this.bindParameters(searchCondition, obj, argument);
				} else if (where instanceof CompositeWhereExpression) {
					CompositeWhereExpression whereExpression = (CompositeWhereExpression) where;
					whereExpression.append(searchCondition, new int[] { fromL.getIndex() });
				}
			} catch (Exception e) {
				XException.throwException(e);
			}
		}
	}

	@Override
	public void enterParameter(QLanguageParser.ParameterContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();

		ParseTree left = ctx.getChild(0);
		ParseTree right = ctx.getChild(2);
		if ((left instanceof ParamContext) && (right instanceof BoolContext)) {
			ParamContext paramL = (ParamContext) left;
			String nameL = paramL.getText();
			BoolContext boolR = (BoolContext) right;
			if (selectContext.querySpec instanceof PQLQuerySpec) {
				PQLQuerySpec querySpec = (PQLQuerySpec) selectContext.querySpec;
				boolean bool = Boolean.parseBoolean(boolR.getText());
				this.setPQLParameter(querySpec, nameL, bool);
			}

		} else if ((left instanceof ParamContext) && (right instanceof ConstantContext)) {
			ParamContext paramL = (ParamContext) left;
			String nameL = paramL.getText();
			ConstantContext constantR = (ConstantContext) right;
			PQLQuerySpec querySpec = (PQLQuerySpec) selectContext.querySpec;
			String value = constantR.getText();
			if (value == null) {
				this.setPQLParameter(querySpec, nameL, null);
			} else {
				if (isInteger(value)) {
					this.setPQLParameter(querySpec, nameL, Integer.parseInt(value));
				} else if (isNumeric(value)) {
					this.setPQLParameter(querySpec, nameL, Double.parseDouble(value));
				} else {
					this.setPQLParameter(querySpec, nameL, value.substring(1, value.length() - 1));
				}
			}
		}
	}

	@Override
	public void enterXParameter(QLanguageParser.XParameterContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();

		ParseTree left = ctx.getChild(0);
		ParseTree right = ctx.getChild(2);
		if ((left instanceof ParamContext) && (right instanceof BoolContext)) {
			ParamContext paramL = (ParamContext) left;
			String nameL = paramL.getText();
			BoolContext boolR = (BoolContext) right;
			if (selectContext.querySpec instanceof PQLQuerySpec) {
				PQLQuerySpec querySpec = (PQLQuerySpec) selectContext.querySpec;
				boolean bool = Boolean.parseBoolean(boolR.getText());
				this.setPQLParameter(querySpec, nameL, bool);
			}

		} else if ((left instanceof ParamContext) && (right instanceof ConstantContext)) {
			ParamContext paramL = (ParamContext) left;
			String nameL = paramL.getText();
			ConstantContext constantR = (ConstantContext) right;
			PQLQuerySpec querySpec = (PQLQuerySpec) selectContext.querySpec;
			String value = constantR.getText();
			if (value == null) {
				this.setPQLParameter(querySpec, nameL, null);
			} else {
				if (isInteger(value)) {
					this.setPQLParameter(querySpec, nameL, Integer.parseInt(value));
				} else if (isNumeric(value)) {
					this.setPQLParameter(querySpec, nameL, Double.parseDouble(value));
				} else {
					this.setPQLParameter(querySpec, nameL, value.substring(1, value.length() - 1));
				}
			}
		}
	}

	@Override
	public void enterOrderClause(QLanguageParser.OrderClauseContext ctx) {
		ParserRuleContext parent = ctx.getParent();
		if (!(parent instanceof SelectStatementContext))
			return;

		SelectContext selectContext = this.getSelectStack().peek();
		if (ctx.getChildCount() > 1) {
			for (OrderItemContext orderItem : ctx.orderItem()) {
				FieldContext fieldContext = (FieldContext) orderItem.getChild(0);
				AliasContext aliasContext = fieldContext.alias();
				String aliasName = aliasContext.getText();
				FromBean from = selectContext.pickAlias(aliasName);
				if (from == null)
					throw new XException("alias " + aliasName + " don't exist.");

				try {
					OrderBy orderBy = this.toOrderBy(selectContext, orderItem);
					if (selectContext.querySpec instanceof PQLQuerySpec) {
						((PQLQuerySpec) selectContext.querySpec).appendOrderBy(orderBy, new int[] { from.getIndex() });
					} else if (selectContext.querySpec instanceof CompoundQuerySpec) {
						((CompoundQuerySpec) selectContext.querySpec).appendOrderBy(orderBy);
					}
				} catch (QueryException e) {
					XException.throwException(e);
				}
			}
		}
	}

	@Override
	public void enterGroupClause(QLanguageParser.GroupClauseContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();

		for (FieldContext field : ctx.field()) {
			String tname = field.getChild(0).getText();
			FromBean from = selectContext.pickAlias(tname);

			if (selectContext.querySpec instanceof PQLQuerySpec) {
				try {
					((PQLQuerySpec) selectContext.querySpec).appendGroupBy(toColumnExpression(selectContext, field), new int[] { from.getIndex() }, false);
				} catch (QueryException e) {
					XException.throwException(e);
				}
			}
		}
	}

	@Override
	public void enterHavingClause(QLanguageParser.HavingClauseContext ctx) {
		SelectContext selectContext = this.getSelectStack().peek();

		ParseTree treeL = ctx.getChild(1);
		String opt = ctx.getChild(2).getText();
		ParseTree treeR = ctx.getChild(3);

		if ((treeL instanceof FunctionContext) && (treeR instanceof ConstantContext)) {
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toSQLFunction(selectContext, (FunctionContext) treeL), opt, this.toConstantExpression((ConstantContext) treeR));
				((PQLQuerySpec) selectContext.querySpec).appendHaving(searchCondition, new int[] {});
			} catch (QueryException e) {
				XException.throwException(e);
			}
		} else if ((treeL instanceof ConstantContext) && (treeR instanceof FunctionContext)) {
			try {
				PQLSearchCondition searchCondition = new PQLSearchCondition(this.toConstantExpression((ConstantContext) treeL), opt, this.toSQLFunction(selectContext, (FunctionContext) treeR));
				((PQLQuerySpec) selectContext.querySpec).appendHaving(searchCondition, new int[]{});
			} catch (QueryException e) {
				XException.throwException(e);
			}
		}
	}

	/**
	 * 当ArrayExpression的长度为1时, PQLSearchCondition自动将IN语句转换成=语句, ArrayExpression自动转换成ConstantExpression, 就会导致setBindingParameter时出错
	 *
	 * @param condition
	 * @param expression
	 */
	private void fixPQLSearchConditionIssue(PQLSearchCondition condition, String opt, ArrayExpression expression) {
		if (condition == null || StringUtils.isBlank(opt) || expression == null)
			return;

		if (expression.getSize() == 1 && ("IN".equals(opt) || "NOT IN".equals(opt))) {
			try {
				Field operator = SearchCondition.class.getDeclaredField("operator");
				operator.setAccessible(true);
				operator.set(condition, opt);
				operator.setAccessible(false);
				Field rightHandSide = SearchCondition.class.getDeclaredField("rightHandSide");
				rightHandSide.setAccessible(true);
				rightHandSide.set(condition, expression);
				rightHandSide.setAccessible(false);
			} catch (Exception e) {
				XException.throwException(e);
			}
		}
	}

	private void bindParameters(PQLSearchCondition condition, Object obj) {
		if (this.querySpec instanceof CompoundQuerySpec) {
			SelectContext selectContext = this.selectStacks.get(1);
			StatementBuilder statementBuilder = selectContext.querySpec.getStatementBuilder();
			if (statementBuilder instanceof QuerySpecStatementBuilder) {
				Vector<?> vector = ((QuerySpecStatementBuilder) statementBuilder).getSingleBindParameters();
				if (obj != null) {
					int i = vector != null ? vector.size() : 0;
					condition.setBindParameterIndicies(i);
				}
				BindParameterUtil.appendBindParameter(obj, vector);
			}
		} else {
			StatementBuilder statementBuilder = this.querySpec.getStatementBuilder();
			if (statementBuilder instanceof QuerySpecStatementBuilder) {
				Vector<?> vector = ((QuerySpecStatementBuilder) statementBuilder).getSingleBindParameters();
				if (obj != null) {
					int i = vector != null ? vector.size() : 0;
					condition.setBindParameterIndicies(i);
				}
				BindParameterUtil.appendBindParameter(obj, vector);
			}
		}
	}

	private void bindParameters(PQLSearchCondition condition, Object obj, String name) {
		if (this.querySpec instanceof CompoundQuerySpec) {
			SelectContext selectContext = this.selectStacks.get(1);
			StatementBuilder statementBuilder = selectContext.querySpec.getStatementBuilder();
			if (statementBuilder instanceof QuerySpecStatementBuilder) {
				Vector<?> vector = ((QuerySpecStatementBuilder) statementBuilder).getSingleBindParameters();
				if (obj != null) {
					int i = vector != null ? vector.size() : 0;
					condition.setBindParameterIndicies(i);
				}
				BindParameterUtil.appendBindParameter(obj, vector);
			}
		} else {
			StatementBuilder statementBuilder = this.querySpec.getStatementBuilder();
			if (statementBuilder instanceof QuerySpecStatementBuilder) {
				Vector<?> vector = ((QuerySpecStatementBuilder) statementBuilder).getSingleBindParameters();
				if (obj != null) {
					int i = vector != null ? vector.size() : 0;
					condition.setBindParameterIndicies(i);
					condition.setParamName(name);
					this.bindings.put(i, name);
				}
				BindParameterUtil.appendBindParameter(obj, vector);
			}
		}
	}

	private ColumnExpression toColumnExpression(SelectContext selectContext, FieldContext context) {
		AliasContext aliasContext = (AliasContext) context.getChild(0);
		RuleContext ruleContext = (RuleContext) context.getChild(2);
		String aliasName = aliasContext.getText();
		FromBean from = null;
		if ("SELECT".equals(KEY_THREAD_LOCAL.get())) {
			from = selectContext.getAlias(aliasName);
		} else {
			from = selectContext.pickAlias(aliasName);
		}
		if (from == null) {
			throw new XException("alias " + aliasName + " isn't found in " + context.getText() + ".");
		}
		String alias = (String) from.getAlias();
		if (ruleContext instanceof ColumnContext) {
			ColumnContext columnContext = (ColumnContext) ruleContext;
			String columnName = columnContext.getText();
			Object oName = from.getOName();
			if (oName instanceof String) { // 说明是表名
				return new TableColumn(alias, columnName);
			} else if (oName instanceof PQLQuerySpec) { // 说明是子查询
				return new TableColumn(alias, columnName);
			} else if (oName instanceof Class<?>) { // 说明是类名
				Class<?> oClazz = from.getOClass();
				if (columnName != null && columnName.toUpperCase().equals(columnName)) {
					return new TableColumn(alias, columnName);
				} else {
					if (Persistable.class.isAssignableFrom(oClazz)) {
						try {
							ClassInfo classInfo = WTIntrospector.getClassInfo(oClazz);
							PropertyDescriptor descriptor = classInfo.getPropertyDescriptor(columnName);
							Object derived = descriptor.getValue("DerivedFrom");
							if (derived == null) {
								String attrName = descriptor.getName();
								return new ClassAttribute(oClazz, attrName);
							} else {
								if (derived instanceof String) {
									return new ClassAttribute(oClazz, (String) derived);
								} else {
									return new TableColumn(alias, columnName);
								}
							}
						} catch (WTIntrospectionException e) {
							return new TableColumn(alias, columnName);
						} catch (QueryException e) {
							throw new XException(e);
						}
					}
				}
			}

			return new TableColumn(alias, columnName);
		} else if (ruleContext instanceof PropertyContext) {
			PropertyContext propertyContext = (PropertyContext) ruleContext;
			String attributeName = propertyContext.getText();

			try {
				return new ClassAttribute(from.getOClass(), attributeName);
			} catch (QueryException e) {
				throw new XException(e);
			}
		} else if (ruleContext instanceof MasterAttContext) {
			MasterAttContext masterContext = (MasterAttContext) ruleContext;
			String attributeName = masterContext.getText();

			try {
				return new ClassAttribute(from.getOClass(), trim(attributeName));
			} catch (QueryException e) {
				throw new XException(e);
			}
		}

		return null;
	}

	private ColumnExpression toColumnExpression(SelectContext selectContext, XFieldContext context) {
		AliasContext aliasContext = context.alias();
		ColumnContext columnContext = context.column();
		String aliasName = aliasContext.getText();
		String columnName = columnContext.getText();
		FromBean from = selectContext.pickAlias(aliasName);
		if (from == null) {
			throw new XException("alias " + aliasName + " don't exist.");
		}

		return new TableColumn(from.getAlias(), columnName);
	}

	private ConstantExpression toConstantExpression(ConstantContext context) {
		String constant = context.getText();
		Object object;

		if (constant.startsWith("'") && constant.endsWith("'") && constant.length() > 1) {
			object = constant.substring(1, constant.length() - 1);
		} else {
			object = constant;
		}

		return new ConstantExpression(object);
	}

	private RelationalExpression toRelationalExpression(Object constant) {
		if (constant instanceof Object[]) {
			Object[] array = (Object[]) constant;
			return new ArrayExpression(array);
		} else if (constant instanceof Timestamp) {
			return new ConstantExpression(constant);
		} else if (constant instanceof Date) {
			Timestamp timestamp = new Timestamp(((Date) constant).getTime());
			return new ConstantExpression(timestamp);
		} else if (constant instanceof String) {
			String string = (String) constant;
			if (string.startsWith("'") && string.endsWith("'") && string.length() > 1) {
				String object = string.substring(1, string.length() - 1);
				return new ConstantExpression(object);
			}
			return new ConstantExpression(string);
		} else {
			return new ConstantExpression(constant);
		}
	}

	private SQLFunction toSQLFunction(SelectContext selectContext, FunctionContext context) throws QueryException {
		FuncNameContext nameContext = context.funcName();
		String funcName = nameContext.getText();
		List<ParserRuleContext> list = new ArrayList<ParserRuleContext>();
		for (ParseTree func : context.children) {
			if ((func instanceof FieldContext) || (func instanceof ConstantContext)) {
				list.add((ParserRuleContext) func);
			}
		}

		if (list.size() > 0) {
			ColumnExpression[] params = new ColumnExpression[list.size()];
			int i = 0;
			for (ParserRuleContext item : list) {
				if (item instanceof FieldContext) {
					params[i] = this.toColumnExpression(selectContext, (FieldContext) item);
				} else if (item instanceof ConstantContext) {
					params[i] = this.toConstantExpression((ConstantContext) item);
				}
				i = i + 1;
			}

			return SQLFunction.newSQLFunction(funcName, params);
		} else {
			return SQLFunction.newSQLFunction(funcName);
		}
	}

	private OrderBy toOrderBy(SelectContext selectContext, OrderItemContext orderItem) throws QueryException {
		FieldContext fieldContext = orderItem.field();
		SortsContext sortsContext = orderItem.sorts();

		boolean sorting = true;
		if (!this.isEmpty(sortsContext)) {
			if ("DESC".equalsIgnoreCase(sortsContext.getText())) {
				sorting = true;
			} else if ("ASC".equalsIgnoreCase(sortsContext.getText())) {
				sorting = false;
			}
		}
		return new OrderBy(toColumnExpression(selectContext, fieldContext), sorting);
	}

	/**
	 * 通过ParamContext给PQLQuerySpec设置参数，例如：select a from wt.part.WTPart a where
	 * $DescendantQuery=false and a.[master>number]='WWWWW001'
	 * PQL解析器解析到$DescendantQuery参数时，自动调用PQLQuerySpec的setDescendantQuery()方法，并传入参数值false
	 * 
	 * @param querySpec
	 * @param name
	 * @param value
	 */
	private void setPQLParameter(PQLQuerySpec querySpec, String name, Object value) {
		try {
			if (value == null) {
				Method method = PQLQuerySpec.class.getMethod("set" + name.substring(1));
				if (method != null) {
					method.invoke(querySpec);
				}
			} else {
				if (Boolean.class.isAssignableFrom(value.getClass())) {
					Method method = PQLQuerySpec.class.getMethod("set" + name.substring(1), boolean.class);
					if (method != null) {
						method.invoke(querySpec, value);
					}
				} else if (Double.class.isAssignableFrom(value.getClass())) {
					Method method = PQLQuerySpec.class.getMethod("set" + name.substring(1), double.class);
					if (method != null) {
						method.invoke(querySpec, value);
					}
				} else if (Float.class.isAssignableFrom(value.getClass())) {
					Method method = PQLQuerySpec.class.getMethod("set" + name.substring(1), float.class);
					if (method != null) {
						method.invoke(querySpec, value);
					}
				} else if (Integer.class.isAssignableFrom(value.getClass())) {
					Method method = PQLQuerySpec.class.getMethod("set" + name.substring(1), int.class);
					if (method != null) {
						method.invoke(querySpec, value);
					}
				}
			}
		} catch (Exception e) {
			throw new XException(e);
		}
	}

	/**
	 * PQLQuerySpec在有子查询的情况下，会出现别名相同的情况
	 * 
	 * @return
	 */
	private String riseAlias() {
		return String.valueOf(this.aliasGen++);
	}

	private boolean isEmpty(ParserRuleContext context) {
		if (context == null || context.isEmpty())
			return true;
		else
			return false;
	}

	private String trim(String str) {
		if (str == null)
			return "";

		if (str.startsWith("'") && str.endsWith("'") && str.length() > 1) {
			str = str.substring(1, str.length() - 1);
		} else if (str.startsWith("[") && str.endsWith("]") && str.length() > 1) {
			str = str.substring(1, str.length() - 1);
		}

		return str;
	}

	public static boolean isDigist(String str) {
		Matcher isNum = DIGISET_PATTERN.matcher(str);
		return isNum.matches();
	}

	public static boolean isNumeric(String str) {
		Matcher isNum = NUMERIC_PATTERN.matcher(str);
		return isNum.matches();
	}

	public static boolean isInteger(String str) {
		Matcher isNum = INTEGER_PATTERN.matcher(str);
		return isNum.matches();
	}

	public static boolean isBlank(String value) {
		if (value == null) {
			return true;
		}

		return (value.isEmpty() || value.trim().isEmpty());
	}
}
