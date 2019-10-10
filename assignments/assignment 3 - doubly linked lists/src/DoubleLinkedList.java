import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class DoubleLinkedList<T> implements Iterable<T>{ //throw exceptions fullstack?

	private Node firstNode, lastNode;	
	private int size;
	//TODO All the entities are defined as protected so they can be accessed by the subclasses.
	
	DoubleLinkedList(){
		firstNode = new Node(null);
		lastNode = new Node(null);
		//System.out.println("Added '" + firstNode.getData() + "' to stack at " + lastNode + "  \n");
		size = 1;
	}
	
	
	
	
	BasicDoubleLinkedList<T> addToEnd(T newEntry) { //TODO SET BACKREFERENCES
		
		if(firstNode == null){
			firstNode = new Node(newEntry, null, null);
			lastNode = firstNode;
		} else {
			Node temp = lastNode;
			lastNode = new Node(newEntry, lastNode, null);
			temp.setNext(lastNode);
		}
		
		size += 1;
	    //System.out.println(" + Added '" + newEntry + "' to stack at " + ((lastNode == null) ? "stack base" : lastNode) + "  \n");
	    return ;
	    
	}
	
	
	
	BasicDoubleLinkedList<T> addToFront(T data){}
	 
	
	
	public T getFirst() { return firstNode.getData(); }
	
	
	
	public T getLast() { return lastNode.getData(); }
	 
	
	
	public int getSize() { return size; }
	
	
	
	public ListIterator iterator() {
		iterator = new DoubleIterator();
	}
	
	
	
	BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){}
	
	
	
	public T retrieveFirstElement() {}
	
	
	
	public T retrieveLastElement() {}
	
	

	

	






	 public ArrayList<T> toArrayList() { //TODO review to make sure it works, use iterator?
		
		ArrayList<T> list = (ArrayList<T>) new ArrayList<Object>();
		
		list.add(firstNode.getData());
		
		if(firstNode.getNext() != null) {
			Node iter = firstNode.getNext();
			while(iter.hasNext()){
				list.add(iter.getData());
				iter = iter.getNext();
			}
		}
		
		if(size > 1) {
			list.add(lastNode.getData());
		}
		
		return list;
		
	}
   
	
	

	
	/*
	 * O - addToEnd (push)
	 * X - addToFront
	 * O - getFirst
	 * O - getLast
	 * O - getSize (size)
	 * X - iterator: This method must be implemented using an inner class that implements ListIterator and defines the methods of hasNext(), next(), hasPrevious() and previous(). Remember that we should be able to call the hasNext() method as many times as we want without changing what is considered the next element. EXCEPTIONS
	 * X - remove
	 * X - retrieveFirstElement
	 * X - retrieveLastElement
	 * O - toArrayList (toArray)

	 */
	
	class Node {
		
		private T data;
		private Node previous, next;
		
		
		Node(T d, Node p, Node n){
			data = d;
			previous = p;
			next = n;
		}
		
		Node(T d){
			data = d;
			previous = null;
			next = null;
		}
		
		
		
		// Data operations
		
		public void setData(T d) { this.data = d; }
		
		public T getData() { return data; } 
		
		
		// Next operations
		
		public void setNext(Node n) { this.next = n; }
		
		public Node getNext() { return next; }
		
		public boolean hasNext() { return (next == null) ? false : true; }		
		
		
		// Previous operations
		
		public void setPrevious(Node n) { this.previous = n; }
		
		public Node getPrevious() { return previous; }
		
		public boolean hasPrevious() { return (previous == null) ? false : true; }
		
		
	}
   

	
	
	 /*
	  * However only the hasNext(), next(), hasPrevious() and previous() 
	  * methods of ListIterator need to be implemented, 
	  * all other methods can throw the UnsupportedOperationException:
	  * 
	  * public void remove() throws UnsupportedOperationException{throw new UnsupportedOperationException();}
	  */

	//TODO THROW EXCEPTIONS FOR UNSUPPORTED METHODS
	class DoubleIterator implements ListIterator<T> {

		DoubleIterator(){
			
		}
		
		
		// Supported methods

		@Override
		public boolean hasNext() {
			// TODO Implement
			return false;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Implement
			return false;
		}

		@Override
		public T next() {
			// TODO Implement
			return null;
		}

		@Override
		public T previous() {
			// TODO Implement
			return null;
		}
		
		
		
		// Unsupported methods
		
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}


		@Override
		public void set(Object arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();			
		}

		@Override
		public void add(Object e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();			
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();			
		}
		
	}




	
}
