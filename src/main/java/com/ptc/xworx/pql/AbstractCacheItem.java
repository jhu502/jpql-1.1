package com.ptc.xworx.pql;

public class AbstractCacheItem {
	private String pql;
	private long hitCount = 0;
	
	public AbstractCacheItem(String pql) {
		this.pql = pql;
	}

	public String getPql() {
		return pql;
	}

	public long getHitCount() {
		return hitCount;
	}

	public void hitted() {
		this.hitCount++;
	}
	
}
