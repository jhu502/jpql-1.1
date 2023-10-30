package com.ptc.xworx.pql;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import com.ptc.xworx.util.XException;

public class PQLDefaultErrorStrategy extends DefaultErrorStrategy {
	public void reportNoViableAlternative(Parser parser, NoViableAltException e) throws RecognitionException {
		String msg = "can't choose between alternatives";
		parser.notifyErrorListeners(e.getOffendingToken(), msg, e);
	}

	public void recover(Parser recognizer, RecognitionException e) {
		throw new XException(e);
	}

	public Token recoverInline(Parser recognizer) throws RecognitionException {
		throw new XException(new InputMismatchException(recognizer));
	}

	public void sync(Parser recognizer) {
		super.sync(recognizer);
	}
}
