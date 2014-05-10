package com.sin.java.dsp.util;

final public class XLog {
	public static void l(Object l) {
		System.out.println("log: " + (l == null ? "null" : l.toString()));
	}

	public static void l(String format, Object... args) {
		l(String.format(format, args));
	}

	public static void i(Object i) {
		System.out.println("inf: " + (i == null ? "null" : i.toString()));
	}

	public static void i(String format, Object... args) {
		i(String.format(format, args));
	}

	public static void e(Object e) {
		System.err.println("err: " + (e == null ? "null" : e.toString()));
	}

	public static void e(String format, Object... args) {
		e(String.format(format, args));
	}
	
	public static void w(Object e) {
		System.out.println("wrn: " + (e == null ? "null" : e.toString()));
	}

	public static void w(String format, Object... args) {
		w(String.format(format, args));
	}
}
