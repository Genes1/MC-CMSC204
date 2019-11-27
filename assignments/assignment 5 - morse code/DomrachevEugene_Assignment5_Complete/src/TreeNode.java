/**
 * 
 * @author Eugene Domrachev
 *
 * The node of a tree structure.
 *
 * @param <T> data type for data reference of node
 */



public class TreeNode<T> {
	
	
	
	private T data;
	public TreeNode leftChild, rightChild;
	
	/**
	 * TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode data to store
	 */
	
	TreeNode(T data){
		leftChild = null; 
		rightChild = null;
		this.data = data;
	}
	
	
	
	/**
	 * Deep copy constructor
	 * @param node node to be copied
	 */
	
	TreeNode(TreeNode<T> node){
		this.data = node.getData();
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	
	
	
	
	/*
	 * Setter methods __________________________________________________________________________
	 */
	
	
	
	/**
	 * Set the left child of this node
	 * @param left node to be left child
	 */
	
	public void setLeft(TreeNode<T> left) { this.leftChild = left; }
	
	
	
	/**
	 * Set the right child of this node
	 * @param right node to be right child
	 */
	
	public void setRight(TreeNode<T> right) { this.rightChild = right; }
	
	
	
	

	/*
	 * Getter methods __________________________________________________________________________
	 */
	
	
	
	/**
	 * Get the left child of this node
	 * @return leftChild left child of node
	 */
	
	public TreeNode getLeft() { return leftChild; }
	
	
	
	/**
	 * Get the right child of this node
	 * @return rightChild right child of node
	 */
	
	public TreeNode getRight() { return rightChild; }
	
	
	
	/**
	 * Get the data of this node
	 * @return data the data element of the node
	 */	
	
	public T getData(){ return data; }
	
	
	
	
	
	/*
	 * Auxiliary methods _______________________________________________________________________
	 */
	
	
	
	/**
	 * Check whether the node has a right child via null comparison
	 * @return true if right child is not null
	 */
	
	public boolean hasRight() { return rightChild != null; }
	
	
	
	/**
	 * Check whether the node has a left child via null comparison
	 * @return true if left child is not null
	 */
	
	public boolean hasLeft() { return leftChild != null; }
	
	
	
	
}
