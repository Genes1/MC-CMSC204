

/**
 * The DataManager class should never depend on the GUI, but rather the reverse. 
 * So the DataManager methods should not use the GUI directly.  If you want data
 * to get from the user to the manager, have the GUI get the data, and call the manager 
 * with the data that the GUI got from a text field or other data structure.
 * @author ralexander
 *
 */
public class DataManager {
    
	DataManager() {
		//TO DO: initialize the manager
	}

	/** 
	 * This method illustrates how the GUI can pass data to the manager
	 * @param text a String entered by the user in a JTextField
	 */
	public String doSomething(String text) {
		return "Data Manager receives text from the user... "+text;		
	}
	
	public int sendSomething() {
		return 0;
	}


}
