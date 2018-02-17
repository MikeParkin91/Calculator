package com.mike.parkin.calculators;

import java.util.ArrayList;
import java.util.List;

public class Calculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static double getCalculation(String sum) {
		
		String[] splitSum = sum.split(" ");
		ArrayList<String> sumList = new ArrayList<String>();

		int hasBracket = 0;
		int gotOne = 0;
		int add = 0;
		double retResult = 0;
		hasBracket = getBracketStatus(splitSum);
		
		//Loop for the brackets
		while(1 == hasBracket) {
			gotOne = 0;
			add = 0;	
			sumList.clear();
			
			for(int i = 0; i < splitSum.length; i++) {
				if(!splitSum[i].equals("") && 0 == gotOne) {
					if(splitSum[i].equals("(")) {
						add = 1;		
						splitSum[i] = "addHere";
					}else if(splitSum[i].equals(")")) {
						add = 0;
						gotOne = 1;
						splitSum[i] = "";
					}else if(1 == add) {
						sumList.add(splitSum[i]);
						splitSum[i] = "";
					}
				}
			}
			
			retResult = doSum(sumList);
			
			for(int i = 0; i < splitSum.length; i++) {
				if(splitSum[i].equals("addHere")) {
					splitSum[i] = String.valueOf(retResult);
				}
			}
			hasBracket = getBracketStatus(splitSum);
		}
		
		splitSum = clearBlanks(splitSum);
		
		if(1 == splitSum.length) {
			return Double.parseDouble(splitSum[0]);
		}
			
		//Check Divisions and Multiplications
		int hasDivision = checkOperand(splitSum, "/", "*");
			
		if(1 == hasDivision) {
			splitSum = completeSums(splitSum, "/", "*");
		}
		
		if(1 == splitSum.length) {
			return Double.parseDouble(splitSum[0]);
		}

		//Check Additions and subtractions
		int hasAddition = checkOperand(splitSum, "+", "-");
		

		if(1 == hasAddition) {
			splitSum = completeSums(splitSum, "+", "-");
		}

		return Double.parseDouble(splitSum[0]);
	}

	private static String[] completeSums(String[] splitSum, String operand1, String operand2) {
		for(int i = 0; i < splitSum.length; i++) {
			if(splitSum[i].equals(operand1) || splitSum[i].equals(operand2)) {
				ArrayList<String> divList = new ArrayList<String>();
				double retResult = 0;
				divList.clear();
				
				divList.add(splitSum[i - 1]);
				divList.add(splitSum[i]);
				divList.add(splitSum[i + 1]);
				
				retResult = doSum(divList);

				splitSum[i - 1] = "";
				splitSum[i] = "";
				splitSum[i + 1] = String.valueOf(retResult);
			}
		}
		
		splitSum = clearBlanks(splitSum);
		
		return splitSum;
	}

	private static String[] clearBlanks(String[] splitSum) {
		List<String> tempList = new ArrayList<String>();
		
		for(String item : splitSum) {
			if(!item.equals("")) {
				tempList.add(item);
			}
		}
		
		return tempList.toArray(new String[tempList.size()]);
	}

	private static int checkOperand(String[] splitSum, String operand1, String operand2) {
		for(int i=0; i < splitSum.length; i++) {
			if(splitSum[i].equals(operand1) || splitSum[i].equals(operand2)) {
				return 1;			 
			}
		}
		return 0;
	}

	private static int getBracketStatus(String[] splitSum) {
		for(int i=0; i < splitSum.length; i++) {
			if(splitSum[i].equals("(")) {
				return 1;			 
			}
		}
		return 0;
	}

	private static double doSum(ArrayList<String> sumList) {
		//Sum will come into this method with 2 numbers and an operand e.g. '1 + 2'
		
		double num1, num2;
		String operand;
		
		num1 = Double.parseDouble(sumList.get(0));
		num2 = Double.parseDouble(sumList.get(2));
		operand = sumList.get(1);
		
		switch (operand) {
			case "+": return num1 + num2;
			case "-": return num1 - num2;
			case "*": return num1 * num2;
			case "/": return num1 / num2;
		}
		
		
		return 0;
	}

}
