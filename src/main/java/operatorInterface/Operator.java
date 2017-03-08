package operatorInterface;

/**
 * This is an interface for the operator
 * 
 * @author Revanth
 *
 */

public interface Operator {

	/**
	 * Do the operation based on the operand provided
	 * 
	 * @param operator1
	 *            value of the parameter1
	 * @param operator2
	 *            value of the parameter2
	 * @return result of the operation
	 */
	public int operation(int operator1, int operator2);

	/**
	 * Provide the priority for the operand
	 * 
	 * @return value of the operand
	 */
	public int getPriority();

	/**
	 * Get the current operator
	 * 
	 * @return get the current operator
	 */
	public String getOperator();

}
