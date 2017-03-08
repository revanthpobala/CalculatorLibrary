package operatorImplTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import operatorImpl.Addition;
import operatorInterface.Operator;

/**
 * This class will test the methods in {@link Addition} class
 * 
 * @author Revanth
 *
 */
public class AdditionTest {

	private Operator op;

	@Before
	public void setUp() throws Exception {
		op = new Addition();
	}

	/**
	 * Check for the success scenario.
	 */
	@Test
	public void testSuccessScenarioWhenParametersGivenAreCorrect() {
		int result = op.operation(2, 3);
		Assert.assertThat(result, Matchers.is(5));
	}

	/**
	 * Check for the given priority for addition
	 */
	@Test
	public void testForPriority() {
		Assert.assertThat(op.getPriority(), Matchers.is(1));
	}

	/**
	 * Check for the addition operator
	 */
	@Test
	public void testForOperator() {
		Assert.assertThat(op.getOperator(), Matchers.is("+"));
	}

	/**
	 * Destroy the object created.
	 */
	@After
	public void tearDown() throws Exception {
		op = null;
	}

}
