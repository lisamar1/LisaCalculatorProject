package com.lmig.gfc.calculator.models;

public class Calculator {

	private double result = 0;

	public void addNumbers(int fnumber, int snumber) {
		result = fnumber + snumber;

	}

	public void subtractNumbers(int fnumber, int snumber) {
		result = fnumber - snumber;
	}

	public void multiplyNumbers(int fnumber, int snumber) {
		result = fnumber * snumber;

	}

	public void divideNumbers(int fnumber, int snumber) {
		result = fnumber / snumber;
	}

	public void exponentNumbers(int fnumber, int snumber) {
		result = Math.pow(fnumber, snumber);
	}

	public String getTotal() {
		String s = Double.toString(result);
		return s;
	}
}
