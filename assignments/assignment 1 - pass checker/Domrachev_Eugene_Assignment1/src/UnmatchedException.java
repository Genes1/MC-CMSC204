/**
 * Thrown if the two entered passwords are not equivalent.
 * @author Eugene Domrachev
 */

public class UnmatchedException extends RuntimeException {

	UnmatchedException(){}
	
	UnmatchedException(String s){
		super(s);
	}

}