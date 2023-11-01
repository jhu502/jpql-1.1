package com.ptc.xworx.pql;

/**
 * 缓存ParseTree，下次执行同样的pql时，直接从缓存中获取pql对应的ParseTree，然后使用ParseTreeWalker去walker，生成
 * 出一个新的QuerySpec去执行查询，减少pql的分析过程，以提高性能；
 * 
 * @author hujin
 */
public class LRUCacheParseTree extends AbstractLRUCache<CacheItemParseTree> {
	private static final long serialVersionUID = 1L;

	public LRUCacheParseTree(int wateLine) {
		super(wateLine);
	}
}
