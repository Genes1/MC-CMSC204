
public class StackLinkedList<T> implements StackInterface<T >{ //throw exceptions fullstack?

	private Node firstNode, lastNode;	
	private int size;
	
	StackLinkedList(T a){
		firstNode = new Node(a, null);
		lastNode = firstNode;
		System.out.println("Added '" + firstNode.getData() + "' to stack at " + lastNode + "  \n");
		size = 1;
	}
		
	
	//TODO should I add @overrides???
	public T pop(){
		
		if(!this.isEmpty()) {

			T  val = lastNode.getData();			
			Node iter = firstNode;		
			Node prev = null;
			
			while(iter.hasNext()){
				if(!iter.getNext().hasNext()){
					prev = iter;
				}
				iter = iter.getNext();
			}
			
			iter = null;
			
			if(prev != null) {
				prev.setNext(null);
			} else {firstNode = null;}
			
			lastNode = prev;	
			System.out.println(" - Popped: " + val);
			size -= 1;
		    return val;
		}
		System.out.println("Can not pop from stack as it is empty.");
		return null;
		
	}
  
	

	public T peek(){
		
		if(!this.isEmpty()) { 
			System.out.println("* Peeked: " + lastNode.getData());
		    return lastNode.getData();
		}
		System.out.println("Can not peek stack as it is empty.");
		return null;

	}

	
	
	public boolean isEmpty(){ return firstNode == null; }
  
	
	
	public void clear(){
		
		firstNode = null;
		lastNode = null;
		System.out.println("Stack has been cleared. \n");
		size = 0;
		
	}
   
	
	
	public void display(){
		
		Node iter = firstNode;	
		
		if(!this.isEmpty()) {
			System.out.println("_____________________________________________________________________________________");
			while(iter.hasNext()){
				System.out.println(iter + " | " + iter.getData() + " | " + iter.getNext() );
				if (iter.hasNext()) iter = iter.getNext();
			}	
			System.out.println(lastNode+ " | " + lastNode.getData() + " | no reference "  );   
			
		} else {System.out.println("Nothing to display: the stack is empty.");}
		System.out.println("_____________________________________________________________________________________");
		System.out.println();
		
	}
	
	
	
	//TODO when should this not return true?
	public boolean push(T newEntry) {
		
		if(firstNode == null){
			firstNode = new Node(newEntry, null);
			lastNode = firstNode;
		} else {
			Node temp = new Node(newEntry, null);
			if(!isEmpty()) lastNode.setNext(temp);
			lastNode = temp;
		}
		
		size += 1;
	    System.out.println(" + Added '" + newEntry + "' to stack at " + ((lastNode == null) ? "stack base" : lastNode) + "  \n");
	    return true;
	    
	}
	


	//TODO will this every be true?
	public boolean isFull() { return false; }



	public int size() { return size; }




	public T[] toArray() {
		
		T[] arr = (T[]) new Object[size];
		arr[0] = firstNode.getData();
		arr[size-1] = lastNode.getData();
		
		if(firstNode.getNext() != null) {
			int c = 1;
			Node iter = firstNode.getNext();
			while(iter.hasNext()){
				arr[c] = iter.getData();
				c += 1;
				iter = iter.getNext();
			}
		}
		return arr;
		
	}
   
	
	
	class Node {
		
		private T data;
		private Node ref;
		
		Node(T d, Node n){
			data = d;
			ref = n;
		}
		
		public void setData(T d) { this.data = d; }
		
		public T getData() { return data; } 
		
		public void setNext(Node n) { this.ref = n; }
		
		public Node getNext() { return ref; }
		
		public boolean hasNext() { return (ref != null) ? true : false; }		
		
	}
   
}
