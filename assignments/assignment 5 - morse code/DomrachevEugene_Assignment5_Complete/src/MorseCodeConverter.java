/**
 * 
 * @author Eugene Domrachev
 *
 * The morse code conversion manager. Uses the MorseCodeTree class to convert morse code to English
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree tree;
	private static String ans;
	private static String[] codes;
	
	
	
	/**
	 * Convert a string of morse code to its English equivalent
	 * @param string the morse code string
	 * @return the English equivalent of string
	 */
	
	public static String convertToEnglish(String string) {
		
		tree = new MorseCodeTree();
		ans = "";
		codes = string.split(" ");
		
		for(int i = 0; i < codes.length; i++) {
			ans += tree.fetch(codes[i]);
		}
		
		return ans;
	
	}

	
	
	
	
	/**
	 * Convert a string of morse code from a file to its English equivalent
	 * @param selectedFile file to read morse from
	 * @return the EngliSh conversion of read morse code
	 * @throws FileNotFoundException
	 */
	
	public static String convertToEnglish(File selectedFile) throws FileNotFoundException {
		
		tree = new MorseCodeTree();
		ans = "";
		
		try {
			
			Scanner scanner = new Scanner(selectedFile);
			
			while(scanner.hasNextLine()){
				
				codes = scanner.nextLine().split(" ");
				
				for(int i = 0; i < codes.length; i++) {
					ans += tree.fetch(codes[i]);
				}
			    
			}
			

						
			scanner.close();
			
			return ans;
			
			
		} catch (IOException e) {
			throw new FileNotFoundException();
		} 
		
	}

	
	
	
	
	/**
	 * Get a string which represents the inorder traversal of the morse binary tree
	 * @return the inorder traversal of the morse binary tree
	 */
	
	public String printTree() {
		
		tree = new MorseCodeTree();
		String s = "";
		
		for(String letter : tree.toArrayList()) {
			s += letter + " ";
		}
		
		return s.substring(0, s.length() - 1);
		
	}
	
	
}
