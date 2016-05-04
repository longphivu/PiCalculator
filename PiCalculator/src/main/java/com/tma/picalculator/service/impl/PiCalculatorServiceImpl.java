package com.tma.picalculator.service.impl;

import org.springframework.stereotype.Service;

import com.tma.picalculator.common.Constant;
import com.tma.picalculator.domain.PiModel;
import com.tma.picalculator.formula.LeibnizPiCalculator;
import com.tma.picalculator.formula.PiCalculatorStrategy;
import com.tma.picalculator.service.PiCalculatorService;

@Service
public class PiCalculatorServiceImpl implements PiCalculatorService {

	public String getPi(String formula, long terms) throws Exception {
		PiCalculatorStrategy piStrategy = null;

		if (Constant.LEIBNIZ_PI_FORMULA.equals(formula)) {
			piStrategy = new LeibnizPiCalculator();
		}

		return piStrategy.calculate(terms);
	}

	@Override
	public String getError(String piResult) {
		double error = Double.parseDouble(piResult) - Math.PI;
		return String.valueOf(error);
	}

	@Override
	public void getPi(PiModel piModel) throws Exception {
		long start = System.currentTimeMillis();
		String piResult = getPi(piModel.getFormula(), piModel.getTerms());
		long end =  System.currentTimeMillis();
		String time = String.valueOf((end - start)+"ms");
		String javaPi = String.valueOf(Math.PI);
		String error = getError(piResult);

		piModel.setPi(piResult);
		piModel.setTime(time);
		piModel.setError(error);
		piModel.setJavaPi(javaPi);
	}

}
