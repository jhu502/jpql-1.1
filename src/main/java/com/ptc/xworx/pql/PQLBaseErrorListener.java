package com.ptc.xworx.pql;

import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class PQLBaseErrorListener extends BaseErrorListener {
	private Set<String> errorSet = new LinkedHashSet<String>();
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
		String errorInfo = "line " + line + ":" + charPositionInLine + ": " + msg;
		errorSet.add(errorInfo);
	}
	
	public Set<String> getErrorSet() {
		return this.errorSet;
	}
}