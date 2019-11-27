/**
 * 
 * @author Eugene Domrachev
 *
 * A binary tree representing the morse code alphabet.
 * @param <T> data type for data reference
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	
	
	private TreeNode<String> root;
	
	MorseCodeTree(){
		this.buildTree();
	}
	
	
	
	
	/**
	 * Recursive method to navigate the binary tree via each character in the morse code message (. = left, - = right).
	 * Adds a node to the tree with the data of the passed English letter
	 * @param root the reference node for an iteration
	 * @param code the morse code string
	 * @param letter the English letter to be inserted 
	 * @throws NoSuchElementException
	 */
	
	public void addNode(TreeNode<String> root, String code, String letter) throws NoSuchElementException {
		
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
		
		if(code.charAt(0) == '.') {
			addNode(temp.getLeft(), code.substring(1), letter);
		} else if(code.charAt(0) == '-') {
			addNode(temp.getRight(), code.substring(1), letter);
		} else {
			throw new NoSuchElementException();
		}
		
	}
	
	
	
	
	
	/**
	 * Create the morse code binary tree via the insert method
	 */
	
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
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
		
	}
	
	
	
	
	
	/**
	 * Get the symbol which the passed morse code represents (via the built tree). Calls fetchNode()
	 * @param code the morse code string
	 * @return letter the letter which the code represents
	 */
	
	public String fetch(String code) {	
		if(code.equals("/")) {
			return " ";
		}
		return fetchNode(getRoot(), code);		
	}
	
	
	
	
	
	/**
	 * Recursively get the alphanumeric character which is represented by the remaining code and reference node.
	 * @param root the reference node from which traversal occurs
	 * @param code the remaining morse code to traverse
	 * @return the character represented by the given traversal
	 * @throws NoSuchElementException
	 */
	
	public String fetchNode(TreeNode<String> root, String code) throws NoSuchElementException {
		
		TreeNode<String> temp = root; 
		
		if(code.length() == 0) {
			return root.getData();
		}
		
		if(code.charAt(0) == '.') {
			return fetchNode(temp.getLeft(), code.substring(1));
		} else if (code.charAt(0) == '-') {
			return fetchNode(temp.getRight(), code.substring(1));
		}  else {
			throw new NoSuchElementException();
		}
		
	}
	
	
	
	
	
	/**
	 * Get the root of the morse binary tree
	 * @return the (empty) root of the morse code tree
	 */
	
	public TreeNode<String> getRoot(){
		return root;
	}
	
	
	
	
	
	/**
	 * Insert an node into the morse code tree
	 * @return the current state of the tree
	 */
	
	public MorseCodeTree insert(String code, String letter) {
		addNode(getRoot(), code, letter);
		return this;
	}
	
	
	
	
	
	/**
	 * Set the root node of the binary tree
	 * @param newNode node to be set as root
	 */
	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	
	
	
	
	/**
	 * Traverse the binary tree using in-order traversal.
	 * @param root starting point of traversal
	 * @param list storage for all visisted nodes
	 */
	
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		
		if(root == null) {
			return;
		}
		
		LNRoutputTraversal(root.getLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(), list);
		
	}
	
	
	
	
	
	/**
	 * Create and return a list to display the morse binary tree
	 * @return the contents of the LNR traversal
	 */
	
	public ArrayList<String> toArrayList(){
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(getRoot(), list);
		return list;
	}
	
	
	
	
	// Unsupported exceptions
	
	public MorseCodeTree update() throws UnsupportedOperationException { throw new UnsupportedOperationException(); }
	
	public MorseCodeTree delete(String data) { throw new UnsupportedOperationException(); }
	
}
