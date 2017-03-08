package operatorImpl;

import operatorInterface.Operator;

/**
 * This class implements the subtraction operator
 * 
 * @author Revanth
 *
 */

public class Subtraction implements Operator {

	/**
	 * Constructor
	 */
	public Subtraction() {
	}

	/**
	 * This method will do the subtraction operation
	 * 
	 * @param operator1 
	 */
	public int operation(int operator1, int operator2) {
		return operator1 - operator2;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPriority() {
		return 2;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return "-";
	}

}
