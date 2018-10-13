package com.alban.calculator.client;

//import java.util.ArrayList;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;

/**
 * Used in association with Calculator class to evaluate the expressions given
 * and return them to the textbox.
 * 
 * @author MAMI
 * 
 */
public class CalculateExp extends Calculator {
	private final String MATH_SYMBOLS = "+-/*";

	/**
	 * blank constructor
	 */
	public CalculateExp() {

	}

	public String calculate(String firstExp, String secondExp, String modifier) {

		double firstEx = Double.parseDouble(firstExp);
		double secondEx = Double.parseDouble(secondExp);
		if (firstExp.equals("600613")) {
			goToGoogle();
			return "Google...";
		}
		if (modifier.equals("+")) {
			double addNum = firstEx + secondEx;
			return numFormatter(addNum);
		} else if (modifier.equals("-")) {
			double subNum = firstEx - secondEx;
			return numFormatter(subNum);
		} else if (modifier.equals("/")) {
			double divNum = (double) firstEx / secondEx;
			return numFormatter(divNum);
		} else if (modifier.equals("*")) {
			double multNum = (double) firstEx * secondEx;
			String sMult = multNum + "";
			if (sMult.substring(0,2).equals("711"))
				return "get a slurpee cause you just scored 711!"; //TODO: 711
			return numFormatter(multNum);
		} else {
			clearText();
			throw new RuntimeException("INVALID ENTRY");
		}

	}


	private void goToGoogle() {
		// Auto-generated method stub
		Window.open("http://www.google.com", "_blank", "");
	}

	public boolean isValidExpression(String text) {
		String s = text + "";
		boolean first = false;
		for (int i = 0; i < s.length(); i++) {
			if (MATH_SYMBOLS.contains(s.charAt(i) + "") && !first) {
				s.replace(s.charAt(i), ' ');
				first = true;
				continue;
			}
			if (MATH_SYMBOLS.contains(s.charAt(i) + "") && first) {
				return false;
			}
		}
		return true;
	}

	/**
	 * format the answer from the calculate method
	 * 
	 * @param num
	 *            the number to be formatted.
	 * @return a formatted number in the form of a String.
	 */
	private String numFormatter(double num) {
		String formattedNum = NumberFormat.getFormat("#,###.0000").format(num);
		return formattedNum;
	}

}
