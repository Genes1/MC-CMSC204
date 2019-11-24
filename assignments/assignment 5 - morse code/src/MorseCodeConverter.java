import java.io.File;


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

	public static String convertToEnglish(File selectedFile) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String printTree() {
		return null;
	}
	
	
}
