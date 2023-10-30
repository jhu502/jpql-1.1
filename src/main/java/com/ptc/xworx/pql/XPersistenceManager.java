package com.ptc.xworx.pql;

import java.util.List;
import java.util.Map;

import wt.fc.QueryResult;
import wt.method.RemoteInterface;

@RemoteInterface
public interface XPersistenceManager extends java.io.Serializable {
	public QueryResult find(String sql);

	public QueryResult find(String sql, Map<String, Object> arguments);

	public QueryResult find(String sql, Map<String, Object> arguments, boolean cached);

	public QueryResult query(String sql);

	public QueryResult query(String sql, Map<String, Object> arguments);

	public QueryResult nQuery(String sql, Object[] params);

	public int nUpdate(String sql);

	public boolean nInsert(String sql);

	public boolean nInsert(List<String> sqls);

	public boolean nExecute(String sql, Object[] params);

	public boolean nExecute(String sql, List<Object[]> params);
}
