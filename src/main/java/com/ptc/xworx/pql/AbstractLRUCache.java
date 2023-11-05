package com.ptc.xworx.pql;

import java.util.LinkedHashMap;
import java.util.Map;

public class AbstractLRUCache<T extends AbstractCacheItem> extends LinkedHashMap<String, T> {
	private static final long serialVersionUID = 1L;
	private int wateLine;
	private long hit = 0;
	private long uhit = 0;

	public AbstractLRUCache(int wateLine) {
		super((int) Math.ceil(wateLine / 0.75) + 1, 0.75f, true);
		this.wateLine = wateLine;
	}

	@Override
	public T get(Object statement) {
		T t = super.get(statement);
		if (t == null) {
			uhit = uhit + 1;
		} else {
			t.hitted();
			hit = hit + 1;
		}
		return t;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<String, T> eldest) {
		return size() > wateLine;
	}

	public void setWateLine(int wateLine) {
		this.wateLine = wateLine;
	}

	public double getHitRate() {
		if (this.hit == 0 && this.uhit == 0) {
			return 0;
		} else {
			return (double) this.hit / (double) (this.hit + this.uhit);
		}
	}
}
