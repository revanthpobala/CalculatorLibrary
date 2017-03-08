package operatorImpl;

import operatorInterface.Operator;

/**
 * This class implements the Division operation
 * 
 * @author Revanth
 *
 */
public class Multiplication implements Operator {

	/**
	 * Constructor
	 */
	public Multiplication() {
	}

	/**
	 * Do the multiplication operation between two operators.
	 * 
	 * @param operator1
	 *            Operator 1
	 * @param operator2
	 *            Operator 2
	 * @return Division between two operators.
	 */
	public int operation(int operator1, int operator2) {
		return operator1 * operator2;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPriority() {
		return 3;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return "*";
	}
}
