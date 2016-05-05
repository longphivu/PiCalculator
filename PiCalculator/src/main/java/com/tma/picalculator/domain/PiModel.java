package com.tma.picalculator.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PiModel {
	@NotNull
	private String formula;
	@NotNull @Min(1)
	private long terms;
	private String pi;
	private int correctDigit;
	private String javaPi;
	private String time;

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public long getTerms() {
		return terms;
	}

	public void setTerms(long terms) {
		this.terms = terms;
	}

	public String getPi() {
		return pi;
	}

	public void setPi(String pi) {
		this.pi = pi;
	}

	public String getJavaPi() {
		return javaPi;
	}

	public void setJavaPi(String javaPi) {
		this.javaPi = javaPi;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCorrectDigit() {
		return correctDigit;
	}

	public void setCorrectDigit(int correctDigit) {
		this.correctDigit = correctDigit;
	}
}
