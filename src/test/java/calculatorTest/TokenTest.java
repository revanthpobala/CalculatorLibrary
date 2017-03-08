package calculatorTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import calculator.Token;
import calculatorException.CustomCalculatorException;

/**
 * This class will test for the methods in {@link Token} class.
 * 
 * @author Revanth
 *
 */
public class TokenTest {

	private Token token;

	/**
	 * Initialization
	 */
	@Before
	public void setUp() throws Exception {
		token = new Token();
	}

	/**
	 * Destroy the object
	 */
	@After
	public void tearDown() throws Exception {
		token = null;
	}

	/**
	 * Test for success scenario
	 */
	@Test
	public void testForSuccessScenario() throws CustomCalculatorException {
		Assert.assertThat(token.entryPoint("123+9*8"), Matchers.is(195));
	}
	
	/**
	 * Test for {@link NumberFormatException}
	 */
	@Test(expected = NumberFormatException.class)
	public void testFotNumberFormatException() throws CustomCalculatorException{
		token.entryPoint("2/8*/*");
	}

}
