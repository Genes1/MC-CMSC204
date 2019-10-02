/**
 * 
 * @author Eugene Domrachev
 * 
 * Custom error for errors dealing with the RecipientLine class.
 *
 */

public class RecipientException extends RuntimeException {

	RecipientException(){}
	
	RecipientException(String s){
		super(s);
	}

}