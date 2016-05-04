package com.tma.picalculator.common;

public class Constant {
	/**
	 * Stored the name using for initialize singleton pattern.
	 */
	public static final String LEIBNIZ_PI_FORMULA = "LeibnizPiFormula";
	/**
	 * Stored the number of test case.
	 */
	public static final Integer NO_TESTCASES = 8;
	
	/**
	 * Optimize number of threads = number of CPUs + 1.
	 */
	public static final Integer NO_MAXTHREADS = Runtime.getRuntime().availableProcessors()+1;
	
	public static final Long BOUND_TERM = 8000000000L;
	
	public static final Long RANGE = 1000000000L;
}
