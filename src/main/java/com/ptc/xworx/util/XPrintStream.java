package com.ptc.xworx.util;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XPrintStream extends PrintStream {
	private static Logger LOGGER = LoggerFactory.getLogger("System.out");

	public XPrintStream(PrintStream out) {
		super(out);
	}

	public void println() {
		super.println();
		LOGGER.debug("");
	}

	public void println(boolean x) {
		super.println(x);
		LOGGER.debug(Boolean.toString(x));
	}

	public void println(char x) {
		super.println(x);
		LOGGER.debug(String.valueOf(x));
	}

	public void println(int x) {
		super.println(x);
		LOGGER.debug(Integer.toString(x));
	}

	public void println(long x) {
		super.println(x);
		LOGGER.debug(Long.toString(x));
	}

	public void println(float x) {
		super.println(x);
		LOGGER.debug(Float.toString(x));
	}

	public void println(double x) {
		super.println(x);
		LOGGER.debug(Double.toString(x));
	}

	public void println(char x[]) {
		super.println(x);
		LOGGER.debug(String.valueOf(x));
	}

	public void println(String x) {
		super.println(x);
		LOGGER.debug(x);
	}

	public void println(Object x) {
		super.println(x);
		LOGGER.debug(x.toString());
	}
}
