package com.ptc.xworx.pql;

import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheItemParseTree extends AbstractCacheItem {
	protected static final Logger LOGGER = LoggerFactory.getLogger(CacheItemParseTree.class);
	private ParseTree parseTree;

	public static CacheItemParseTree newItem(String pql, ParseTree parseTree) {
		CacheItemParseTree cacheItem = new CacheItemParseTree(pql);
		cacheItem.setParseTree(parseTree);

		return cacheItem;
	}

	public CacheItemParseTree(String pql) {
		super(pql);
	}

	public ParseTree getParseTree() {
		return this.parseTree;
	}

	public void setParseTree(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
}
