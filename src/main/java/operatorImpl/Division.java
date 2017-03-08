package operatorImpl;

import operatorInterface.Operator;

/**
 * This class implements the Division operation
 * 
 * @author Revanth
 *
 */
public class Division implements Operator {

	/**
	 * Constructor
	 */
	public Division() {
	}

	/**
	 * Do the division operation between two operators.
	 * 
	 * @param operator1
	 *            Operator 1
	 * @param operator2
	 *            Operator 2
	 * @return Division between two operators.
	 */
	public int operation(int operator1, int operator2) throws UnsupportedOperationException {
		return operator1 / operator2;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPriority() {
		return 4;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getOperator() {
		return "/";
	}

}
