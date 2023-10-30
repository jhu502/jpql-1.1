package com.ptc.xworx.pql;

import com.ptc.xworx.util.XException;

import wt.query.CloneableStatementSpec;
import wt.query.QueryException;
import wt.query.QuerySpec;
import wt.util.WTException;
import wt.util.WTPropertyVetoException;

/**
 * 通过PQL解析器构建出来的QuerySpec对象，将自动存放进PQLCache管理器中，在下次重复调用同样的PQL时就不需要重复解析:
 * 1. PQLCache管理器从缓存列表找到重用的PQLQuerySpec，并返回副本PQLQuerySpec;
 * 2. 由于OOTB的QuerySpec不支持对DescendantQuery属性进行复制；
 */
public class PQLQuerySpec extends QuerySpec {
	private boolean descendantQuery;

	public PQLQuerySpec() throws QueryException {
		super();
	}

	public boolean isDescendantQuery() {
		return descendantQuery;
	}

	public void setDescendantQuery(boolean descendantQuery) {
		this.descendantQuery = descendantQuery;
		try {
			super.setDescendantQuery(descendantQuery);
		} catch (WTPropertyVetoException e) {
			throw new XException(e);
		}
	}
	
	public CloneableStatementSpec clone() {
		try {
			PQLQuerySpec target = new PQLQuerySpec();
			clone(target, this, true);
			target.setDescendantQuery(this.isDescendantQuery());
			return target;
		} catch (WTException e) {
			throw new XException(e);
		}
	}
}
