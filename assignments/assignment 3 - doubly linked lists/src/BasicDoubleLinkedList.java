import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{ //throw exceptions fullstack?

	private Node firstNode, lastNode;	
	private int size;
	DoubleIterator it;
	//TODO All the entities are defined as protected so they can be accessed by the subclasses.
	
	BasicDoubleLinkedList(){
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	
	
	
	BasicDoubleLinkedList<T> addToEnd(T data) { 
		
		if(lastNode == null) {
			firstNode = new Node(data);
			lastNode = firstNode;
		} else {
			Node temp = new Node(data, lastNode, null);
			lastNode.setNext(temp); //Formerly last node
			lastNode = temp;
		}
		
		size += 1;
	    return this;
	    
	}
	
	
	
	BasicDoubleLinkedList<T> addToFront(T data){
		
		if(firstNode == null) {
			firstNode = new Node(data);
			lastNode = firstNode;
		} else {
			Node temp = new Node(data, null, firstNode);
			firstNode.setPrevious(temp); //Formerly first node
			firstNode = temp;
		}
		
		size += 1;
	    return this;
		
	}
	 
	
	
	public T getFirst() { return firstNode.getData(); }
	
	
	
	public T getLast() { return lastNode.getData(); }
	 
	
	
	public int getSize() { return size; }
	
	
	
	public DoubleIterator iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new DoubleIterator();
	}
	
	
	
	BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		it = iterator();
		while(it.hasNext()){
			if(comparator.compare(it.next(), targetData) == 0) {
				if(it.current.equals(firstNode)) {
					firstNode = firstNode.getNext();
				}
				it.remove();
				break;
			}
		}
		
		size -= 1;
		
		return this;
	}
	
	
	
	public T retrieveFirstElement() {
		
		T t;
		
		if(firstNode != null) {
			t = firstNode.getData();
		} else {
			t = null;
		}
		
		firstNode = firstNode.getNext();
		size -= 1;
		
		return t;
		
	}
	
	
	
	public T retrieveLastElement() {
		
		T t;
		
		if(lastNode != null) {
			t = lastNode.getData();
		} else {
			t = null;
		}
		
		lastNode = lastNode.getPrevious();
		size -= 1;
		
		return t;
		
	}
	
	

	public ArrayList<T> toArrayList() { //TODO review to make sure it works, use iterator
	
		ArrayList<T> list = (ArrayList<T>) new ArrayList<Object>();
		it = this.iterator();
		if(it.hasNext()) {
			it.next();
			while(it.hasNext()) {
				list.add(it.next());
			}
			list.add(it.next());
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

		Node current;
		
		DoubleIterator(){
			current = null;
		}
		
		
		// Supported methods

		@Override
		public boolean hasNext() {
			if(current != null) {
				return current.hasNext();
			}
			return false;
		}

		
		@Override
		public boolean hasPrevious() {
			if(current != null) {
				return current.hasPrevious();
			}
			return false;
		}

		
		@Override
		public T next() {
			if(current == null) {
				if(firstNode != null) {
					current = firstNode;
					return null; //TODO is this allowed?
				} else {
					//TODO THIS MEANS LIST IS EMPTY. THROW NoSuchElement EXCEPTION?
				}
			} else if (current.hasNext()) {
				T temp = current.getData(); //Get element to return
				current = current.getNext(); //Iterate to next element
				return temp;
			}
			return null;
		}

		
		@Override
		public T previous() {
			if(current == null) {
				if(lastNode != null) {
					current = lastNode;
					return null; //TODO is this allowed?
				} else {
					//TODO THIS MEANS LIST IS EMPTY. THROW NoSuchElement EXCEPTION?
				}
			} else if (current.hasPrevious()) {
				T temp = current.getData(); //Get element to return
				current = current.getPrevious(); //Iterate to previous element
				return temp;
			}
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
