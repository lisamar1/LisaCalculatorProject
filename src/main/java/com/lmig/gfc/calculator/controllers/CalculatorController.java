package com.lmig.gfc.calculator.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.calculator.models.Calculator;
import com.lmig.gfc.calculator.models.History;

@Controller
public class CalculatorController { // Declaring CalculatorController class

	private Calculator calcClass = new Calculator(); // Declaring a variable named calcClass and instantiating it as a
														// Calculator.java class
	private History historyClass = new History();

	@RequestMapping("/") // Bridging gap between Calculator.java and calculator.html
	public ModelAndView defaultPage() { // Declaring a method named default page of ModelAndView type

		ModelAndView calc = new ModelAndView(); // Declaring a variable named calc and instantiating it as a
												// ModelAndView.java class
		calc.setViewName("calculator"); // Calling the setViewName method in the ModelAndView Java.class - this is tying
										// it to calculator.html
		return calc; // Returning ModelAndView

	}

	@RequestMapping("/calculate") // Created "/calculate" as a part of the URL to gain access to total.html
	public ModelAndView calculate(int firstNumber, int secondNumber, String operator) { // Creating a method to perform
																						// arithmetic function
		String quote;
		ArrayList<String> ar;

		if (operator.equals("+")) {
			calcClass.addNumbers(firstNumber, secondNumber);
		}

		if (operator.equals("-")) {
			calcClass.subtractNumbers(firstNumber, secondNumber);
		}
		if (operator.equals("*")) {
			calcClass.multiplyNumbers(firstNumber, secondNumber);
		}

		if (operator.equals("/")) {
			calcClass.divideNumbers(firstNumber, secondNumber);
		}
		if (operator.equals("^")) {
			calcClass.exponentNumbers(firstNumber, secondNumber);
		}

		quote = firstNumber + " " + operator + " " + secondNumber + " = " + calcClass.getTotal();
		historyClass.addToHistory(quote);

		ModelAndView calc = new ModelAndView(); // Declaring a variable named calm and instantiating it as a
												// ModelAndView.java class
		calc.setViewName("calculator"); // Calling the setViewName method in the ModelandView Java.class - this is tying
		// it to total.html
		calc.addObject("cal", calcClass); // Adding a java object to the totoal.html and passing the calcClass
											// Calculator.java to the the total.html page.
		ar = historyClass.getHistory();

		calc.addObject("quotes", ar);

		return calc; // Returning ModelandView

	}

}
