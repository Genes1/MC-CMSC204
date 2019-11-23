/**
 * 
 * @author Eugene Domrachev
 *
 * A binary tree representing the morse code alphabet.
 *
 * @param <T> data type for data reference
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode root;
	private MorseCodeTree tree;
	
	MorseCodeTree(){
		this.buildTree();
	}
	
	
	/*
	 * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
		1. if there is only one character
		a. if the character is '.' (dot) store to the left of the current root
		b. if the character is "-" (dash) store to the right of the current root
		c. return
		2. if there is more than one character
		a. if the first character is "." (dot) new root becomes the left child
		b. if the first character is "-" (dash) new root becomes the right child
		c. new code becomes all the remaining charcters in the code (beyond the first character)
		d. call addNode(new root, new code, letter)
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
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
		
		TreeNode<String> temp = getRoot(); 
		boolean last = false;
		
		for(int i = 0; i < code.length(); i++) {
			
			//Needed?
			if(i == code.length() - 1) {
				last = true;
			}
			
			char symbol = code.charAt(i);
			
			if(symbol == '.') {
				

			} else() { 
				
			}
		}
		
	}
	
	
	
	public String fetchNode(TreeNode<String> root, String code) {
		return code;
	}
	
	
	
	public TreeNode<String> getRoot(){
		return root;
	}
	
	
	
	public MorseCodeTree insert(String code, String letter) {
		
		TreeNode<String> temp = getRoot(); 
		boolean last = false;
		//TODO ZERO LENGTH EXCEPTION
		// The assignment doesn't require checking for uninitialized nodes, but let's do it anyway.
		for(int i = 0; i < code.length(); i++) {
			
			//Needed?
			if(i == code.length() - 1) {
				last = true;
			}
			
			char symbol = code.charAt(i);
			
			if(symbol == '.') {
				
				//left
				if(temp.getLeft() == null) {
					if(last) {
						temp.leftChild = new TreeNode<String>(letter);
					} else {
						temp.leftChild = new TreeNode<String>("");
					}
					
				}
				
				temp = temp.getLeft();
				
			} else if (symbol == '-') {
				
				//right

				if(temp.getRight() == null) {
					if(last) {
						temp.rightChild = new TreeNode<String>(letter);
					} else {
						temp.rightChild = new TreeNode<String>("");
					}
					
				}
				
				temp = temp.getRight();

			} else {
				//TODO throw exception
				System.out.println("Invalid code");
				break;
			}
			
		}
		
		
		return this;
		
	}
	
	
	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
	}
	
	
	
	public ArrayList<String> toArrayList(){
		return null;
	}
	
	
	// Unsupported exception
	
	public MorseCodeTree update() { return null; }
	
	public MorseCodeTree delete(String data) { return null; }
	
}
