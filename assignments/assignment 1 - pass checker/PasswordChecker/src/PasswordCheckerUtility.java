import java.util.ArrayList;

public final class PasswordCheckerUtility{
	

	public PasswordCheckerUtility(){}
	
	/**
	 *
	 * description
	 *
	 * @param The password string to be tested
	 * 
	 * @return Returns true if valid password, returns false if invalid password.
	 * 
	 * @throws LengthException thrown if length is less than 6 characters
	 * @throws NoDigitException  thrown if no digit
	 * @throws NoUpperAlphaException thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException thrown if no lowercase alphabetic
	 * @throws InvalidSequenceException thrown if more than 2 of same character.
	 * 
	 */
	
	public static boolean isValidPassword(String passwordString) {
		return true;
	}
	
	
	
	/**
	 *
	 * description
	 *
	 * @param The password string to be tested
	 * 
	 * @return Returns true if weak password, returns false if strong password.
	 * 
	 */
	
	public static boolean isWeakPassword(String passwordString) {
		return true;
	}
	
	
	
	/**
	 *
	 * description
	 *
	 * @param The password string to be tested
	 * 
	 * @return Returns true if valid password, returns false if invalid password.
	 * 
	 */
	
	public static ArrayList<String> invalidPasswords(ArrayList<java.lang.String> passwords) {
		ArrayList<String> S = new ArrayList<String>(); 
		return S;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
}
