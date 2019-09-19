/**
 * Thrown if password length is less than 6 characters.
 * @author Eugene Domrachev
 */

public class LengthException extends RuntimeException {

	LengthException(){}
	
	LengthException(String s){
		super(s);
	}

}