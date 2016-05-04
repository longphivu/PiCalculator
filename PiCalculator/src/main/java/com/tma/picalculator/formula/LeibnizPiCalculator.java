package com.tma.picalculator.formula;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.tma.picalculator.common.Constant;

public class LeibnizPiCalculator implements PiCalculatorStrategy {

	public String calculate(long terms) throws InterruptedException, ExecutionException {
		int numberOfThread = Constant.NO_MAXTHREADS;

		List<Long> listData = getList(terms, numberOfThread);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numberOfThread);
		Set<Future<Double>> set = new HashSet<Future<Double>>();

		for (int i = 0; i < listData.size() - 1; i++) {
			LeibnizCalculationThread callable = new LeibnizCalculationThread(listData.get(i), listData.get(i + 1));
			Future<Double> temp = executor.submit(callable);
			set.add(temp);
		}
		
		double result = 0D;
		for (Future<Double> future : set) {
			result += future.get();
		}
		executor.shutdown();
		return String.valueOf(result);
	}

	private List<Long> getList(long terms, int numberOfThread) {
		long temp = terms / numberOfThread;
		List<Long> listData = new ArrayList<Long>();
		listData.add((long) 0);
		if (temp > 0) {
			if (terms>Constant.BOUND_TERM) {
				temp = Constant.RANGE;
			}
			for (long i = temp; i < terms; i += temp) {
				if ((i % temp) == 0) {
					listData.add(i);
				}
			}
		}
		listData.add((long) terms+1);
		return listData;
	}
	
	public double toDouble(String result) {
		return Double.valueOf(result);
	}
}
