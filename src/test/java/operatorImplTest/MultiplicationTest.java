package operatorImplTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import operatorImpl.Multiplication;
import operatorInterface.Operator;

/**
 * This class will test for {@link Multiplication} class.
 * 
 * @author Revanth
 *
 */
public class MultiplicationTest {

	private Operator op;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() throws Exception {
		op = new Multiplication();
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() throws Exception {
		op = null;
	}

	/**
	 * Test for success scenario.
	 */
	@Test
	public void testForMultiplicationSuccessScenario() {
		int result = op.operation(5, 5);
		Assert.assertThat(result, Matchers.is(25));
	}

	/**
	 * Check for the given priority for multiplication
	 */
	@Test
	public void testForPriority() {
		Assert.assertThat(op.getPriority(), Matchers.is(3));
	}

	/**
	 * Check for the multiplication operator
	 */
	@Test
	public void testForOperator() {
		Assert.assertThat(op.getOperator(), Matchers.is("*"));
	}
}
