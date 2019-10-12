import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{ //throw exceptions fullstack?

	protected Node firstNode, lastNode;	
	protected int size;
	protected DoubleIterator it;
	
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
	
	
	//TODO ITERATOR IS MESSED UP FOR GUI
	public ArrayList<T> toArrayList() { //TODO review to make sure it works, use iterator
	
		ArrayList<T> list = (ArrayList<T>) new ArrayList<Object>();
		it = iterator();
		while(it.hasNext()) {
			list.add(it.current.getData());
			it.next();
		}
		if(it.current != null) {
			list.add(it.current.getData());
		}
		return list;
		
	}
   
	
	
	
	
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
	protected class DoubleIterator implements ListIterator<T> {

		Node current;
		boolean atEnd = false;
		
		DoubleIterator(){
			current = firstNode;
		}
		
		
		// Supported methods

		@Override
		public boolean hasNext() {
			if(size == 0) {
				//The list is empty.
				return false;
			}  else if (current == lastNode) {
				//The iterator is the last node.
				return false;
			} else {
				//The list is not empty, and the iterator is not the last node.
				return true;
			}	
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
			
			if(atEnd) { //iter past end
				
				throw new NoSuchElementException();	
				
			} else if(current == null && firstNode != null) { //iter at beginning
				
				current = firstNode;
				temp = current.getData();
				current = current.getNext();
				return temp;
				
			} else if(current.hasNext()) { //iter in middle
				
				temp = current.getData();
				current = current.getNext();
				return temp;
				
			} else if(!current.hasNext()){ //iter at end
				
				temp = current.getData();
				System.out.println("at end ");
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
				current = lastNode;
				temp = current.getData();
				current = current.getPrevious();
				atEnd = false;
				return temp;
			} else if(current != null && current.hasPrevious()) { //in middle
				temp = current.getData();
				current = current.getPrevious();
				return temp;
			} if(current == null & !atEnd) {//no list
				throw new NoSuchElementException();
			} else if(current != null && !current.hasPrevious()) {//at start
				temp = current.getData();
				current = null;
				return temp;
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
