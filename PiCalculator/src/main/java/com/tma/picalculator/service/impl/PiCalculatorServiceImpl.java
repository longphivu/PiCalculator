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
	public int getError(String piResult) {
		String Pi = String.valueOf(Math.PI);
		int cnt = 0;
		for(int i = 0 ; i<piResult.length() && i<Pi.length(); i++){
			if(piResult.charAt(i) != Pi.charAt(i))
				break;
			if(piResult.charAt(i) != '.')
				cnt++;
		}
		return cnt;
	}

	@Override
	public void getPi(PiModel piModel) throws Exception {
		long start = System.currentTimeMillis();
		String piResult = getPi(piModel.getFormula(), piModel.getTerms());
		long end =  System.currentTimeMillis();
		String time = String.valueOf((end - start)+"ms");
		String javaPi = String.valueOf(Math.PI);
		int digit = getError(piResult);

		piModel.setPi(piResult);
		piModel.setTime(time);
		piModel.setCorrectDigit(digit);
		piModel.setJavaPi(javaPi);
	}

}
