/**
 * 
 * @author Eugene Domrachev
 *
 * Represent the node of a tree.
 *
 * @param <T> data type for data reference
 */
public class TreeNode<T> {
	
	private T data;
	public TreeNode leftChild, rightChild;
	
	/**
	 * TreeNode with left and right child set to null and data set to the dataNode
	 */
	
	TreeNode(T dataNode){
		leftChild = null; 
		rightChild = null;
		data = dataNode;
	}
	
	
	
	/**
	 * Deep copy constructor
	 */
	
	TreeNode(TreeNode<T> node){
		this.data = node.getData();
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	
	
	public TreeNode getLeft() {
		return leftChild; 
	}
	
	
	
	public TreeNode getRight() {
		return rightChild; 
	}
	
	
	
	public T getData(){ return data; }
	
}
