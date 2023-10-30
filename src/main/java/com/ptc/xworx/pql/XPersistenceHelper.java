package com.ptc.xworx.pql;

import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ptc.xworx.pql.logic.QLanguageLexer;
import com.ptc.xworx.pql.logic.QLanguageParser;
import com.ptc.xworx.pql.repo.Repository;
import com.ptc.xworx.util.XException;

import wt.method.RemoteAccess;

public class XPersistenceHelper implements RemoteAccess {
	private static final Logger LOGGER = LoggerFactory.getLogger(XPersistenceHelper.class);
	public static XPersistenceManager manager = (XPersistenceManager) PQLProxyFactory.getInterfaceObject(XPersistenceManager.class);

	public static <T extends Repository> T getRepositoryObject(Class<T> interType) {
		return PQLProxyFactory.getRepositoryObject(interType);
	}

	public static ParseTree parseStatement(String statement, boolean inspect) {
		LOGGER.trace("SQL:" + statement);
		PQLBaseErrorListener errorListener = new PQLBaseErrorListener();
		CharStream stream = new ANTLRInputStream(statement);
		QLanguageLexer lexer = new QLanguageLexer(stream);
		lexer.removeErrorListeners();
		lexer.addErrorListener(errorListener);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		QLanguageParser parser = new QLanguageParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(errorListener);
		parser.setBuildParseTree(true);

		ParseTree parseTree = parser.startPQLStatement();
		Set<String> errorSet = errorListener.getErrorSet();
		if (errorSet.size() > 0) {
			StringBuffer strbuf = new StringBuffer();
			for (String error : errorSet) {
				if (strbuf.length() > 0)
					strbuf.append("\n").append(error);
				else
					strbuf.append(error);
			}
			throw new XException(strbuf.toString());
		}
		if (inspect) {
			org.antlr.v4.gui.Trees.inspect(parseTree, parser);
			/**
			 * ((QLanguageParser.StartPQLStatementContext) tree).inspect(parser);
			 */
			System.out.println(parseTree.toStringTree(parser));
		}

		return parseTree;
	}

	public static String convert2InClause(String fname, Object[] objs) {
		if (fname == null || fname.trim().length() == 0 || objs == null || objs.length == 0)
			return "";

		StringBuffer strbuf = new StringBuffer();
		if (objs.length == 1) {
			Object obj = objs[0];
			strbuf.append(fname).append("='").append(obj).append("'");
		} else {
			int i = 0;
			strbuf.append(fname).append(" in (");
			for (Object obj : objs) {
				if (i == 0) {
					strbuf.append("'").append(obj).append("'");
				} else {
					strbuf.append(",'").append(obj).append("'");
				}
				i = i + 1;
			}
			strbuf.append(")");
		}
		return strbuf.toString();
	}

	public static void main(String[] args) throws Exception {
		String xx = "select a from wt.part.WTPart a where $DescendantQuery=false and a.latestiterationinfo=1 and a.oneOffVersionInfo.identifier.oneOffVersionId=null and a.@field=:value and a.versionsortida2versioninfo in " //
				+ "(select MAX(b.versionsortida2versioninfo) from wt.part.WTPart b where $DescendantQuery=false and a.ida3masterreference=b.ida3masterreference and b.oneoffversionida2oneoffversi=null)";

		XPersistenceHelper.parseStatement(xx, true);
	}
}
