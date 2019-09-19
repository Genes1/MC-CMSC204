/**
 * Thrown if no digit is found in a password.
 * @author Eugene Domrachev
 */

public class NoDigitException extends RuntimeException {

	NoDigitException(){}
	
	NoDigitException(String s){
		super(s);
	}

}