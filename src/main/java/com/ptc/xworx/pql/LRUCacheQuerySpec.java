package com.ptc.xworx.pql;

/**
 * 缓存QuerySpec，下次执行同样的pql时，直接从缓存中的QuerySpec复制出一个新的QuerySpec进行数据库查询；
 * 问题：Windchill中新复制的QuerySpec，在进行高并发查询总出现各种各样的异常信息；
 * 
 * @author hujin
 */
public class LRUCacheQuerySpec extends AbstractLRUCache<CacheItemQuerySpec> {
	private static final long serialVersionUID = 1L;

	public LRUCacheQuerySpec(int wateLine) {
		super(wateLine);
	}
}
