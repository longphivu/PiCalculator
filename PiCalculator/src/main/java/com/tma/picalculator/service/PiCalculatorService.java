package com.tma.picalculator.service;

import com.tma.picalculator.domain.PiModel;

public interface PiCalculatorService {
	/**
	 * @return Finds PI base on the formula and number of terms.
     * Returns {@code String} of PI number.
	 */
	String getPi(String formula, long terms) throws Exception;
	
	/**
	 * @return Finds the difference between calculated PI and defined PI
     * Returns {@code String}.
	 */
	String getError(String piResult);
	
	void getPi(PiModel piModel) throws Exception;
}
