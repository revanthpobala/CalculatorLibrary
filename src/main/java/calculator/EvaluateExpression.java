package calculator;

import java.util.ArrayList;
import java.util.List;

import calculatorException.CustomCalculatorException;
import operatorInterface.Operator;

/**
 * This class will evaluate the given postfix expression
 * 
 * @author Revanth
 *
 */
public class EvaluateExpression {

	/**
	 * This method will evaluate the given expression
	 * 
	 * @param evaluateListStrings
	 *            A {@link List} of strings
	 * @return The result of the provided expression
	 * @throws CustomCalculatorException
	 *             When something goes wrong
	 * @throws NumberFormatException
	 *             When it is unable to convert the string to an integer
	 */
	public int eval(List<String> evaluateListStrings) throws CustomCalculatorException, NumberFormatException {
		OperatorFactory op = new OperatorFactory();
		List<String> pending = new ArrayList<String>();
		for (int i = 0; i < evaluateListStrings.size(); i++) {
			String token = evaluateListStrings.get(i);
			Operator operator = op.getOperator(token);
			if (operator == null) {
				pending.add(token);
			} else {
				int operand2 = Integer.valueOf(pending.remove(pending.size() - 1));
				int operand1 = Integer.valueOf(pending.remove(pending.size() - 1));
				int value = 0;
				value = operator.operation(operand1, operand2);
				pending.add(String.valueOf(value));
			}
		}
		return Integer.parseInt(pending.get(0));
	}
}
