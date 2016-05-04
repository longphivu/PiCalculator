package com.tma.picalculator.formula;

import java.util.concurrent.Callable;

public class LeibnizCalculationThread implements Callable<Double> {
	private long startPoint;
	private long endPoint;
	private double result = 0d;


	public LeibnizCalculationThread(long startPoint, long endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Double call() {
		double d;
		for (long i = this.startPoint; i < this.endPoint; i++) {
			d = 1d/(2*i + 1);
			if ((i & 1) == 0) {
				result += d;
			} else {
				result -= d;
			}
		}
		return result*4d;
	}

}
