package operatorImplTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import operatorImpl.Division;
import operatorInterface.Operator;

/**
 * This class will test the methods of {@link Division} class
 * 
 * @author Revanth
 *
 */
public class DivisionTest {

	private Operator op;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() throws Exception {
		op = new Division();
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() throws Exception {
		op = null;
	}

	/**
	 * Check for success scenario when two parameters are provided
	 */
	@Test
	public void testForSuccessScenario() {
		int result = op.operation(15, 3);
		Assert.assertThat(result, Matchers.is(5));
	}

	/**
	 * Check for the given priority for division
	 */
	@Test
	public void testForPriority() {
		Assert.assertThat(op.getPriority(), Matchers.is(4));
	}

	/**
	 * Check for the division operator
	 */
	@Test
	public void testForOperator() {
		Assert.assertThat(op.getOperator(), Matchers.is("/"));
	}
}
