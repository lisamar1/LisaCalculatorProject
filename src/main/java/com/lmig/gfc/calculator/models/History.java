package com.lmig.gfc.calculator.models;

import java.util.ArrayList;

public class History {

	private ArrayList<String> al = new ArrayList<String>();

	public void addToHistory(String quote) {
		al.add(quote);
	}

	public ArrayList<String> getHistory() {
		return al;
	}
}
