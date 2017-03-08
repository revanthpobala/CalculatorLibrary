package calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

import calculatorException.CustomCalculatorException;
import operatorInterface.Operator;

/**
 * This class will take the expression string and provides the result for the
 * expression
 * 
 * @author Revanth
 *
 */
public class Token {

	private static final String EXPRESSION_IS_INVALID = "Please check the input you provided";
	private static OperatorFactory operatorFactory = new OperatorFactory();
	private EvaluateExpression evaluateExpression = new EvaluateExpression();

	/**
	 * This method will Sanitize the input expression
	 * 
	 * @param expression
	 *            Expression string to be sanitized
	 * @return Sanitized expression String.
	 * @throws CustomCalculatorException
	 */
	private String sanitizeInput(String expression) throws CustomCalculatorException {
		String newExpression = expression.replaceAll("\\s+", "");
		if (newExpression.charAt(0) == '-') {
			throw new CustomCalculatorException("  Currently we do not support these kind of negative expressions yet. ");
		}
		return newExpression;
	}

	/**
	 * This method will take the expression string and the allowed operators and
	 * returns the result
	 * 
	 * @param expression
	 *            An expression string
	 * @return The calculated value of the final expression.
	 * @throws CustomCalculatorException
	 * @throws NumberFormatException
	 */
	public int entryPoint(String expressionString) throws CustomCalculatorException, NumberFormatException {
		Preconditions.checkArgument(StringUtils.isNotBlank(expressionString), EXPRESSION_IS_INVALID);
		String expression = sanitizeInput(expressionString);
		ArrayList<String> symbols = operatorFactory.getAvailableOperatorsFromOperatorClasses();
		int len = expression.length();
		List<String> tokens = new ArrayList<String>();
		int offset = 0;
		for (int i = 0; i < len; i++) {
			char c = expression.charAt(i);
			if (symbols.contains(Character.toString(c).trim())) {
				tokens.add(expression.substring(offset, i));
				offset = i + 1;
				tokens.add(String.valueOf(c));
			}
		}
		tokens.add(expression.substring(offset, expression.length()));
		List<String> done = new ArrayList<String>();
		List<String> buffer = new ArrayList<String>();
		for (String token : tokens) {
			Operator op = operatorFactory.getOperator(token);
			if (op == null) {
				done.add(token);
			} else {
				flush(buffer, done, op.getPriority());
				buffer.add(token);
			}
		}
		flush(buffer, done, 0);
		return evaluateExpression.eval(done);
	}

	/**
	 * This method will take two lists and does the operator precedence and add
	 * the operators to another list.
	 * 
	 * @param buffer
	 *            A list of strings extracted expression
	 * @param done
	 *            A list of strings extracted from the expression
	 * @param priority
	 *            Priority of the operators
	 * @throws CustomCalculatorException
	 */
	private static void flush(List<String> buffer, List<String> done, int priority) throws CustomCalculatorException {
		while (buffer.size() > 0) {
			Operator op = operatorFactory.getOperator(buffer.get(buffer.size() - 1));
			if (op.getPriority() >= priority) {
				done.add(op.getOperator());
				buffer.remove(buffer.size() - 1);
			} else {
				break;
			}
		}
	}

}
