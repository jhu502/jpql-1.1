/**
 * 
 */
package com.ptc.xworx.util;

/**
 * @author hujin
 * @category util
 * @date 2009.9.15
 * 
 */
public class XException extends RuntimeException {
	private static final long serialVersionUID = 7960570627997714421L;

	public XException(String s) {
		super(s);
	}

	public XException(Throwable throwable) {
		super(throwable);
	}

	public XException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public static void throwException(String s) {
		throw new XException(s);
	}

	public static void throwException(Throwable throwable) {
		if (throwable instanceof RuntimeException) {
			throw (RuntimeException) throwable;
		} else if (throwable instanceof Error) {
			throw (Error) throwable;
		} else {
			throw new XException(throwable);
		}
	}
}
