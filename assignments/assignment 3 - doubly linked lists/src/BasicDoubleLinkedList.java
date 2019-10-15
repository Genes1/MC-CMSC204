import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T>{

	protected Node firstNode, lastNode;	
	protected int size;
	protected DoubleIterator it;
	
	BasicDoubleLinkedList(){
		firstNode = null;
		lastNode = null;
		size = 0;
	}
	
	
	
	// Adding functions
	
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
	 
	
	
	
	// Auxiliary functions
	
	public T getFirst() { 
		if(firstNode != null) {
			return firstNode.getData(); 
		} else {
			throw new NoSuchElementException();
		}
	}
	
	
	
	public T getLast() {
		if(firstNode != null) {
			return lastNode.getData(); 
		} else {
			throw new NoSuchElementException();
		}
	}
	 
	
	
	public int getSize() { return size; }
	
	
	
	public ArrayList<T> toArrayList() { 
		
		ArrayList<T> list = (ArrayList<T>) new ArrayList<Object>();
		it = iterator();
		
		while(it.hasNext()) {
			it.next();
			System.out.println(it.current.getData());
			list.add(it.current.getData());
		}
		
		
		return list;
		
	}
	
	
	
	// Iterator instantiator
	
	public DoubleIterator iterator() throws UnsupportedOperationException, NoSuchElementException { return new DoubleIterator(); }
	
	
	
	// Removing functions
	
	BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		
		it = iterator();
		
		if(size == 0) {
			return this;
		}
		

		
		it.next();
		
		
		while(it.current != null){
			if(it.next() != null) {
				System.out.println("Looking: " + it.current.getData() + " to "+ targetData);
				if(comparator.compare(it.current.getData(), targetData) == 0) {
					System.out.println("Found");
					if(size == 1) {
						size = 0;
						firstNode = null;
						lastNode = null;
						break;
					} 
					
					if(it.current.equals(firstNode)) {
						firstNode = firstNode.getNext();
						firstNode.setPrevious(null);
					} else if (it.current.equals(lastNode)) {
						lastNode = lastNode.getPrevious();
						lastNode.setNext(null);
					}
					
					size--;
					break;
					
				}
			}
		}
		
		//size -= 1;
		
		return this;
		
	}
	
	
	
	public T retrieveFirstElement() {
		
		T t;
		
		if(firstNode != null) {
			t = firstNode.getData();
		} else {
			t = null;
		}
		
		if(size > 1) {
			firstNode = firstNode.getNext();
			firstNode.setPrevious(null);
		} else {
			firstNode = null;
			lastNode = null;
		}
		
		size = size == 0 ? 0 : size - 1;
		
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
		size = size == 0 ? 0 : size - 1;
		
		return t;
		
	}

	
	
	
	
	
	
	

	 /*
	  * However only the hasNext(), next(), hasPrevious() and previous() 
	  * methods of ListIterator need to be implemented, 
	  * all other methods can throw the UnsupportedOperationException:
	  * 
	  * public void remove() throws UnsupportedOperationException{throw new UnsupportedOperationException();}
	  */

	protected class DoubleIterator implements ListIterator<T> {

		Node current;
		boolean atEnd, atStart = false;
		
		DoubleIterator(){
			current = null;
			//current = firstNode;
		}
		
		
		// Supported methods
		//TODO ADD NULL?
		
		@Override
		public boolean hasNext() {
			return current != lastNode && !atEnd;
		}

		
		@Override
		public boolean hasPrevious() {
			return !(current == null  && !atEnd);
		}

		
		@Override
		public T next() throws NoSuchElementException{
			
			T temp;
			
			if(size == 0) { // The list is empty
				throw new NoSuchElementException();
			} 
			
			if(atEnd) {
				throw new NoSuchElementException();
			}
			
			if(current == null) { // Before first (null)
				current = firstNode;
				return current.getData();
			}

			if(current.hasNext()) { // Before another element
				current = current.getNext();
				return current.getData();
			} else {
				throw new NoSuchElementException();
			}
			

			//throw new RuntimeException();

		}

		
		@Override
		public T previous() throws NoSuchElementException{
			
			T temp;

			if(size == 0) {
				throw new NoSuchElementException();
			}
			
			if(current == null && atEnd) { // Before first (null)
				current = lastNode;
				return current.getData();
			} else if (current == null && !atEnd) {
				throw new NoSuchElementException();
			}
			
			if(current.hasPrevious()) { // Before another element
				atEnd = false;
				current = current.getPrevious();
				return current.getNext().getData();
			} else {
				if(current != null) {
					temp = current.getData();
					current = null;
					return temp;
				} /*else {
					throw new NoSuchElementException();
				}*/

				
			}
			

			throw new RuntimeException();
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

		//TODO SUPPORT THIS
		@Override
		public void remove() throws UnsupportedOperationException {
			this.remove();			
		}
		
	}

	
	
	
	
	
	
	
	class Node {
		
		private T data;
		private Node previous, next;
		
		
		Node(T d, Node previous, Node next){
			data = d;
			this.previous = previous;
			this.next = next;
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

	
}
