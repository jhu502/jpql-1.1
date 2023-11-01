package com.ptc.xworx.pql;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wt.pds.StatementSpec;

public class CacheItemQuerySpec implements Cloneable {
	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheItemQuerySpec.class);
	private String pql;
	private StatementSpec spec;
	private Map<Integer, String> bindings = new HashMap<>();

	public static CacheItemQuerySpec newItem(String pql, StatementSpec spec, Map<Integer, String> bindings) {
		CacheItemQuerySpec cacheItem = new CacheItemQuerySpec();
		cacheItem.setPql(pql);
		cacheItem.setSpec(spec);
		cacheItem.setBindings(bindings);

		return cacheItem;
	}

	public String getPql() {
		return pql;
	}

	public void setPql(String pql) {
		this.pql = pql;
	}

	public StatementSpec getSpec() {
		return spec;
	}

	public void setSpec(StatementSpec spec) {
		this.spec = spec;
	}

	public Map<Integer, String> getBindings() {
		return bindings;
	}

	public void setBindings(Map<Integer, String> bindings) {
		this.bindings = bindings;
	}

	public StatementSpec cloneSpec() {
		synchronized (this) {
			long s = System.currentTimeMillis();
			try {
				/**
				 * StatementSpec会被并发使用，若直接并发的对StatementSpec设置setBindParameterAt()将导致一系列的问题；
				 * 因此需要从缓存PQLCacheItem的QuerySpec中获取一个副本
				 */
				if (this.spec instanceof PQLQuerySpec) {
					PQLQuerySpec querySpec = (PQLQuerySpec) this.spec;
					return (PQLQuerySpec) querySpec.clone();
				}
				return this.spec;
			} finally {
				LOGGER.trace("Clone time:" + (System.currentTimeMillis() - s) + "ms");
			}
		}
	}

	public StatementSpec cloneSpec(Map<String, Object> arguments) {
		synchronized (this) {
			long s = System.currentTimeMillis();
			try {
				PQLSearchCondition.ARGUMENTS.set(arguments);
				/**
				 * StatementSpec会被并发使用，若直接并发的对StatementSpec设置setBindParameterAt()将导致一系列的问题；
				 * 因此需要从缓存PQLCacheItem的QuerySpec中获取一个副本
				 */
				if (this.spec instanceof PQLQuerySpec) {
					PQLQuerySpec querySpec = (PQLQuerySpec) this.spec;
					return (PQLQuerySpec) querySpec.clone();
				}
				return this.spec;
			} finally {
				PQLSearchCondition.ARGUMENTS.remove();
				LOGGER.trace("Clone time:" + (System.currentTimeMillis() - s) + "ms");
			}
		}
	}
}
