package com.tma.picalculator.formula;

import java.util.concurrent.ExecutionException;

import junit.framework.TestCase;

import org.junit.Test;

public class LeibnizPiCalculatorTest extends TestCase {

	private LeibnizPiCalculator piCal = new LeibnizPiCalculator();

	@Test
	public void testBasicTerms() throws InterruptedException, ExecutionException {
		long terms = 0;
		assertEquals(-1, piCal.calculate(terms));
		terms = 1;
		assertEquals(4, piCal.calculate(terms));
		terms = 2;
		assertEquals(2.666666666666667, piCal.calculate(terms));
	}

}
