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
	
	public T getFirst() { return firstNode.getData(); }
	
	
	
	public T getLast() { return lastNode.getData(); }
	 
	
	
	public int getSize() { return size; }
	
	
	
	public ArrayList<T> toArrayList() { 
		
		ArrayList<T> list = (ArrayList<T>) new ArrayList<Object>();
		it = iterator();
		
		while(it.current != null) {
			System.out.println(it.current.getData());
			list.add(it.current.getData());
			if(it.current.hasNext()) {
				it.next();
			} else {
				break;
			}
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
		
		
		
		while(it.current != null){
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
   

	
	
	 /*
	  * However only the hasNext(), next(), hasPrevious() and previous() 
	  * methods of ListIterator need to be implemented, 
	  * all other methods can throw the UnsupportedOperationException:
	  * 
	  * public void remove() throws UnsupportedOperationException{throw new UnsupportedOperationException();}
	  */

	protected class DoubleIterator implements ListIterator<T> {

		Node current;
		boolean atEnd = false;
		
		DoubleIterator(){
			current = firstNode;
		}
		
		
		// Supported methods
		//TODO ADD NULL?
		
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
		public T next() throws NoSuchElementException{
			T temp;
			
			if(size == 1) {
				if(!atEnd) {
					atEnd = true;
					return firstNode.getData();
				} else {
					throw new NoSuchElementException();
				}
			} 
			
			if(atEnd) { //iterator past end
				
				throw new NoSuchElementException();	
				
			} else if(current == null && firstNode != null) { //iterator at beginning
				
				current = firstNode;
				temp = current.getData();
				current = current.getNext();
				return temp;
				
			} else if(current.hasNext()) { //iterator in middle
				
				temp = current.getData();
				current = current.getNext();
				return temp;
				
			} else if(!current.hasNext()){ //iterator at end
				
				temp = current.getData();
				atEnd = true;
				current = null;
				return temp;
				
			} 
			

			throw new NoSuchElementException();
			
			

		}

		
		@Override
		public T previous() throws NoSuchElementException{
			
			T temp;

			if(size == 1) {
				if(atEnd) {
					atEnd = false;
					return firstNode.getData();
				} else {
					throw new NoSuchElementException();
				}
			} 
			
			
			if(atEnd) { //at end
				
				System.out.println("At end");
				current = lastNode;
				temp = current.getData();
				System.out.println(current.getData());
				current = current.getPrevious();
				System.out.println(current.getData() + "\n");
				atEnd = false;
				return temp;
				
			} else if(current != null && current.hasPrevious()) { //in middle
				
				System.out.println("In middle");
				temp = current.getData();
				System.out.println(current.getData());
				current = current.getPrevious();
				System.out.println(current.getData() + "\n");
				atEnd = false;
				return temp;
				
				
			} if(current == null & !atEnd) {//no list
				
				throw new NoSuchElementException();
				
			} else if(current != null && !current.hasPrevious()) {//at start
				System.out.println("Was at start");
				temp = current.getData();
				current = null;
				atEnd = false;
				return temp;
				/*
				temp = current.getData();
				current = null;
				return temp;
				*/
			}
			
			
			throw new NoSuchElementException();
			
			
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
