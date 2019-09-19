/**
 * Thrown if no lowercase alphabetic character is found in a password.
 * @author Eugene Domrachev
 */

public class NoLowerAlphaException extends RuntimeException {

	NoLowerAlphaException(){}
	
	NoLowerAlphaException(String s){
		super(s);
	}

}