/**
 * 
 * @author Eugene Domrachev
 * 
 * Custom error for errors dealing with the RecipientLine class.
 *
 */

public class VolunteerException extends RuntimeException {

	VolunteerException(){}
	
	VolunteerException(String s){
		super(s);
	}

}