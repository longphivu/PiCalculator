package com.tma.picalculator.formula;

public interface PiCalculatorStrategy {
	/**
	 * @return Finds PI base on number of terms.
     * Returns {@code String} of PI number.
	 */
	public String calculate(long terms)
			throws Exception;
}
