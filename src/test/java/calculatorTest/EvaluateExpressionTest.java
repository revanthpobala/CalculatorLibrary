package calculatorTest;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.EvaluateExpression;
import calculatorException.CustomCalculatorException;

/**
 * This class will test for the methods in {@link EvaluateExpression} class
 * 
 * @author Revanth
 *
 */
public class EvaluateExpressionTest {

	private EvaluateExpression evaluateExpression;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() throws Exception {
		evaluateExpression = new EvaluateExpression();
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() throws Exception {
		evaluateExpression = null;
	}

	/**
	 * Test for success scenario
	 */
	@Test
	public void testForSuccessScenario() throws CustomCalculatorException {
		ArrayList<String> l = new ArrayList<>();
		l.add("11");
		l.add("2");
		l.add("*");
		l.add("5");
		l.add("-");
		Assert.assertThat(evaluateExpression.eval(l), Matchers.is(17));
	}

	/**
	 * Test for {@link NumberFormatException} 
	 */
	@Test(expected = NumberFormatException.class)
	public void testForNumberFormatException() throws CustomCalculatorException{
		ArrayList<String> l = new ArrayList<>();
		l.add("11");
		l.add("2");
		l.add("--");
		l.add("5");
		l.add("-");
		evaluateExpression.eval(l);
	}
	
}
