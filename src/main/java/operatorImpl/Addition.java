package operatorImpl;

import operatorInterface.Operator;

/**
 * This class implements the Addition operation
 * 
 * @author Revanth
 *
 */

public class Addition implements Operator {

	/**
	 * Constructor
	 */
	public Addition() {
	}

	/**
	 * Do the addition operation between two operators.
	 * 
	 * @param operator1
	 *            Operator 1
	 * @param operator2
	 *            Operator 2
	 * @return Addition between two operators.
	 */
	public int operation(int operator1, int operator2) {
		return operator1 + operator2;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPriority() {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return "+";
	}

}
