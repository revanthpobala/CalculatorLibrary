package calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.mockito.internal.stubbing.answers.Returns;
import org.reflections.Reflections;

import calculatorException.CustomCalculatorException;
import operatorInterface.Operator;

/**
 * This method will use reflection to match the operator and call the respective
 * class
 * 
 * @author Revanth
 *
 */
public class OperatorFactory {

	/**
	 * Get all the class under the provided class or interface.
	 * 
	 * @param operatorClass A {@link Class} for which we need to find the child classes
	 * @return A {@link Set} of the class names
	 */
	private Set<Class<? extends Operator>> getAllTheClassesUnderTheInterface(String operatorClass) {
		Reflections reflections = new Reflections(operatorClass);
		Set<Class<? extends Operator>> classes = reflections.getSubTypesOf(Operator.class);
		return classes;
	}

	/**
	 * Collect the operators from the interface. This can be used in validating
	 * the input if some unknown character is passed.
	 * 
	 * @throws CustomCalculatorException
	 *             If something goes wrong.
	 * @return operatorList A list of valid operators.
	 */

	public ArrayList<String> getAvailableOperatorsFromOperatorClasses() throws CustomCalculatorException {
		ArrayList<String> operatorList = new ArrayList<>();
		Iterator<Class<? extends Operator>> it = getAllTheClassesUnderTheInterface("operatorImpl").iterator();
		try {
			while (it.hasNext()) {
				Class<?> cls = Class.forName((String) it.next().toString().replace("class ", ""));
				Object op = cls.newInstance();
				Method m = cls.getDeclaredMethod("getOperator", null);
				operatorList.add((String) m.invoke(op, null));
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | InvocationTargetException e) {
			throw new CustomCalculatorException(
					"Something is wrong with the input provided. The error message is: " + e);
		}
		return operatorList;
	}

	/**
	 * This method will provide the instance based on the operator provided
	 * 
	 * @param operator An operator 
	 * @return an instance of the extended class.
	 * @throws CustomCalculatorException
	 */
	public Operator getOperator(String operator) throws CustomCalculatorException {
		Iterator<Class<? extends Operator>> it = getAllTheClassesUnderTheInterface("operatorImpl").iterator();
		Operator ops = null;
		try {
			while (it.hasNext()) {
				Class<?> cls = Class.forName((String) it.next().toString().replace("class ", ""));
				Object op = cls.newInstance();
				Method m = cls.getDeclaredMethod("getOperator", null);
				if (operator.equals(m.invoke(op, null))) {
					ops = (operatorInterface.Operator) op.getClass().newInstance();
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | InvocationTargetException | NumberFormatException e) {
			throw new CustomCalculatorException(
					"Something is wrong with the input provided. The error message is: " + e);
		}
		return ops;
	}

}
