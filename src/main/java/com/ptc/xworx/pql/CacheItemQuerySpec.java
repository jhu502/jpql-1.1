package com.ptc.xworx.pql;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wt.pds.StatementSpec;

public class CacheItemQuerySpec extends AbstractCacheItem {
	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheItemQuerySpec.class);
	private StatementSpec spec;
	private Map<Integer, String> bindings = new HashMap<>();

	public static CacheItemQuerySpec newItem(String pql, StatementSpec spec, Map<Integer, String> bindings) {
		CacheItemQuerySpec cacheItem = new CacheItemQuerySpec(pql);
		cacheItem.setSpec(spec);
		cacheItem.setBindings(bindings);

		return cacheItem;
	}
	
	public CacheItemQuerySpec(String pql) {
		super(pql);
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
				if (this.spec instanceof PQLQuerySpec) {
					PQLQuerySpec querySpec = (PQLQuerySpec) this.spec;
					return querySpec.clone();
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
				if (this.spec instanceof PQLQuerySpec) {
					PQLQuerySpec querySpec = (PQLQuerySpec) this.spec;
					
					return querySpec.clone();
				}
				return this.spec;
			} finally {
				PQLSearchCondition.ARGUMENTS.remove();
				LOGGER.trace("Clone time:" + (System.currentTimeMillis() - s) + "ms");
			}
		}
	}
}
