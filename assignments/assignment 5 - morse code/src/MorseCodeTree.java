/**
 * 
 * @author Eugene Domrachev
 *
 * A binary tree representing the morse code alphabet.
 *
 * @param <T> data type for data reference
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode root;
	private MorseCodeTree tree;
	
	MorseCodeTree(){
		this.buildTree();
	}
	
	
	
	

	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> temp = root; 
		
		if(code.length() == 1) {
			temp = new TreeNode(letter);
			if(code.equals(".")) {
				root.setLeft(temp);
			} else {
				root.setRight(temp);
			}
			return;
		}
		
		//TODO NO SUCH EXCEPTIONS
		if(code.charAt(0) == '.') {
			addNode(temp.getLeft(), code.substring(1), letter);
		} else {
			addNode(temp.getRight(), code.substring(1), letter);
		}
		
	}
	
	
	
	
	
	public void buildTree() {
		
		// level 0
		setRoot(new TreeNode<String>(""));
		
		// level 1
		insert(".", "e");
		insert("-", "t");
		
		// level 2
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		// level 3
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		// level 4
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		//insert("", " ");
		insert(".-..", "l");
		//insert("", " ");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	
	
	
	
	//TODO add nosucheleexception
	
	public String fetch(String code) {	
		if(code.equals("/")) {
			return " ";
		}
		return fetchNode(getRoot(), code);		
	}
	
	
	
	
	
	public String fetchNode(TreeNode<String> root, String code) {
		
		TreeNode<String> temp = root; 
		
		if(code.length() == 0) {
			return root.getData();
		}
		
		//TODO NO SUCH EXCEPTIONS
		if(code.charAt(0) == '.') {
			return fetchNode(temp.getLeft(), code.substring(1));
		} else {
			return fetchNode(temp.getRight(), code.substring(1));
		}
		
		//return "";
	}
	
	
	
	
	
	public TreeNode<String> getRoot(){
		return root;
	}
	
	
	
	
	
	public MorseCodeTree insert(String code, String letter) {
		addNode(getRoot(), code, letter);
		return this;
		
	}
	
	
	
	
	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	
	
	
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		//LNRoutputTraversal(root.getLeft(), list);
		if(root == null) {
			return;
		}
		
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
		
	}
	
	
	
	
	
	public ArrayList<String> toArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(getRoot(), list);
		return list;
	}
	
	
	
	
	// TODO Unsupported exception
	
	public MorseCodeTree update() { return null; }
	
	public MorseCodeTree delete(String data) { return null; }
	
}
