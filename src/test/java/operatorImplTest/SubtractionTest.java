package operatorImplTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import operatorImpl.Subtraction;
import operatorInterface.Operator;

/**
 * This class will test for {@link Subtraction} class
 * 
 * @author Revanth
 *
 */
public class SubtractionTest {

	private Operator op;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() throws Exception {
		op = new Subtraction();
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() throws Exception {
		op = null;
	}

	/**
	 * Test for success scenario
	 */
	@Test
	public void testForSubtractionSuccessScenario() {
		int result = op.operation(7, 8);
		Assert.assertThat(result, Matchers.is(-1));
	}

	/**
	 * Check for the given priority for Subtraction
	 */
	@Test
	public void testForPriority() {
		Assert.assertThat(op.getPriority(), Matchers.is(2));
	}

	/**
	 * Check for the Subtraction operator
	 */
	@Test
	public void testForOperator() {
		Assert.assertThat(op.getOperator(), Matchers.is("-"));
	}

}
