package com.ptc.xworx.pql;

import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.ptc.xworx.pql.logic.QLanguageParser;
import com.ptc.xworx.pql.logic.QLanguageParser.ConstantContext;
import com.ptc.xworx.pql.logic.QLanguageParser.FunctionContext;
import com.ptc.xworx.pql.logic.QLanguageParser.InsertClauseContext;
import com.ptc.xworx.pql.logic.QLanguageParser.InsertStatementContext;
import com.ptc.xworx.pql.logic.QLanguageParser.TableNameContext;
import com.ptc.xworx.pql.logic.QLanguageParser.ValuesClauseContext;
import com.ptc.xworx.pql.logic.QLanguageParserBaseListener;
import com.ptc.xworx.util.XException;

public class PQLanguageInsertListener extends QLanguageParserBaseListener {
	private StringBuffer strbuf = new StringBuffer();
	private Map<Integer, Object> params = new LinkedHashMap<Integer, Object>();

	public String getSQLStatement() {
		return this.strbuf.toString();
	}

	public Map<Integer, Object> getParameterMap() {
		return this.params;
	}

	public void enterStartPQLStatement(QLanguageParser.StartPQLStatementContext ctx) {
		if (ctx.getChildCount() == 0)
			throw new XException("please input correct sql clause.");
		ParseTree statement = ctx.getChild(0);
		if (!(statement instanceof InsertStatementContext)) {
			throw new XException("please input an correct insert clause.");
		}
	}

	public void enterInsertStatement(InsertStatementContext ctx) {
		int iCount = 1;
		for (ParseTree child : ctx.children) {
			if (child instanceof InsertClauseContext) {
				for (ParseTree _child : ((InsertClauseContext) child).children) {
					if (_child instanceof TerminalNode) {
						String _t = _child.getText().toUpperCase();
						if ("(".equalsIgnoreCase(_t)) {
							strbuf.append(_t);
						} else
							strbuf.append(_t).append(" ");
					} else {
						strbuf.append(_child.getText());
					}
				}
			} else if (child instanceof ValuesClauseContext) {
				for (ParseTree _child : ((ValuesClauseContext) child).children) {
					if (_child instanceof TerminalNode) {
						String _t = _child.getText().toUpperCase();
						if ("(".equalsIgnoreCase(_t)) {
							strbuf.append(_t);
						} else
							strbuf.append(_t).append(" ");
					} else if (_child instanceof ConstantContext) {
						this.params.put(iCount++, this.getConstant((ConstantContext) _child));
						strbuf.append("?");
					} else if (_child instanceof FunctionContext) {
						for (ParseTree item : ((FunctionContext) _child).children) {
							if (item instanceof ConstantContext) {
								this.params.put(iCount++, this.getConstant((ConstantContext) item));
								strbuf.append("?");
							} else {
								strbuf.append(item.getText().toUpperCase());
							}
						}
					}
				}
			} else if (child instanceof TableNameContext) {
				strbuf.append(child.getText()).append(" ");
			}
		}
	}

	private Object getConstant(ConstantContext context) {
		String constant = context.getText();

		if (constant.startsWith("'") && constant.endsWith("'") && constant.length() > 1) {
			return constant.substring(1, constant.length() - 1);
		}

		return constant;
	}
}
