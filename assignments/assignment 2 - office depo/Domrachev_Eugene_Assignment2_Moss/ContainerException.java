/**
 * 
 * @author Eugene Domrachev
 * 
 * Custom error for errors dealing with the Container class.
 *
 */

public class ContainerException extends RuntimeException {

	ContainerException(){}
	
	ContainerException(String s){
		super(s);
	}

}