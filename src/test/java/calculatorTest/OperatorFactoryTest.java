package calculatorTest;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.OperatorFactory;
import calculatorException.CustomCalculatorException;
import operatorImpl.Subtraction;
import operatorInterface.Operator;

/**
 * This class will test the methods in {@link OperatorFactory} class.
 * 
 * @author Revanth
 *
 */
public class OperatorFactoryTest {

	private OperatorFactory opf;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() {
		opf = new OperatorFactory();
	}

	/**
	 * Test for success scenario
	 */
	@Test
	public void testForSuccessScenarioWhen() throws CustomCalculatorException {
		Operator v = opf.getOperator("-");
		Assert.assertThat(v, Matchers.is(instanceOf(Subtraction.class)));
	}

	/**
	 * Test for the available operators in the class
	 */
	@Test
	public void testGetAvailableOperators() throws CustomCalculatorException {
		ArrayList<String> operatorList = new ArrayList<>();
		operatorList.add("+");
		operatorList.add("/");
		operatorList.add("*");
		operatorList.add("-");
		ArrayList<String> availableOperators = opf.getAvailableOperatorsFromOperatorClasses();
		Assert.assertTrue(operatorList.containsAll(availableOperators));
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() {
		opf = null;
	}

}
