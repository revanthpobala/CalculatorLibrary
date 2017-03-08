package mainCalculator;

import java.util.Scanner;

import calculator.Token;
import calculatorException.CustomCalculatorException;

/**
 * This is the main class.
 * 
 * @author Revanth
 *
 */
public class Main {

	public static void main(String[] args) {
		Token token = new Token();
		System.out.println("Please provide an expression for ex (2+3) or (5/2*3) only integers allowed");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.nextLine();
		try {
			int result = token.entryPoint(expression);
			System.out.println("The result of the expression '" + expression + "' is " + result);
		} catch (CustomCalculatorException | NumberFormatException e) {
			System.out.println("Error in the input provided. The error message is: " + e);
		}

	}

}
