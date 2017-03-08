package calculatorException;

public class CustomCalculatorException extends Exception {
	
	private static final long serialVersionUID = -4553625200823136912L;

	public CustomCalculatorException(){
		super();
	}

	public CustomCalculatorException(String message){
		super(message);
	}
}
