import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class MorseCodeConverter {

	private static MorseCodeTree tree;
	private static String ans;
	private static String[] codes;
	
	
	
	
	public static String convertToEnglish(String string) {
		
		tree = new MorseCodeTree();
		ans = "";
		codes = string.split(" ");
		
		for(int i = 0; i < codes.length; i++) {
			ans += tree.fetch(codes[i]);
		}
		
		return ans;
	
	}

	
	
	
	
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

	
	
	
	
	public String printTree() {
		
		tree = new MorseCodeTree();
		String s = "";
		
		for(String letter : tree.toArrayList()) {
			s += letter + ", ";
		}
		
		return s;
		
	}
	
	
}
