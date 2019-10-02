/**
 * 
 * @author Eugene Domrachev
 * 
 * An array-based implementation of a stack.
 *
 */

public class MyStack<T> implements StackInterface<T>{ 

	final int MAX_SIZE;
	private T[] stack;
	private int size;
	
	MyStack(int size) {
		MAX_SIZE = size;
		stack = (T[]) new Object[MAX_SIZE];
		size = 0;
	}

	
	
	/**
	 * Attempt to push an entry onto the stack.
	 * @return true if newEntry was successfully pushed
	 */
	
	public boolean push(T newEntry) {
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if (stack[i] == null) {
		    	stack[i] = newEntry;
    			size += 1;
		    	return true;
		    }
	    } 
	    
	    return false;
	    
	}
	
	
	
	/**
	 * Remove and return the topmost element of the stack.
	 * @return val - null if stack is empty, T otherwise
	 */
	
	public T pop() {
		
		int last = 0;
		T val = null;
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if(stack[i] != null){
			    last = i;
			    if (i == MAX_SIZE - 1 && stack[i] != null){ 
			    	val = stack[MAX_SIZE -1];
			    	stack[MAX_SIZE -1] = null;
			    }
	    	} else {
		    	val = stack[last];
		    	stack[last] = null;
		    	break;
		    }
	    } 
	    
	    
	    size -= 1;
	    return val;
	    
	}
  
	
	
	/**
	 * Return the topmost element of the stack.
	 * @return val - null if stack is empty, T otherwise
	 */
	
	public T peek() {
		
		int last = 0;
		T val = null; 
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if(stack[i] != null || i == MAX_SIZE - 1){
			    last = i;
		    } else {
		    	val = stack[last];
		    	break;
		    }
	    } 
	    
	    return val;
	    
	}

	
	
	/**
	 * A utility function to display the stack in the console.
	 */
	
	public void display() {
		
		System.out.println();
	    for(int i = 0; i < MAX_SIZE; i++) {
		    System.out.println("[" + i + "] " + stack[i]);
	    } 
	    System.out.println();
	    
	}
	
	
	
	@Override
	public T[] toArray() {
		
		T[] arr = (T[]) new Object[size];
		for(int i = 0; i < size; i++) {
			arr[i] = (T) stack[i];
		}
		
		return arr;
		
	}
	
	
	
	/**
	 * Reset the contents of the stack by setting each element to null
	 */
	public void clear(){
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    stack[i] = null;
	    } 
	    size = 0;
	    
	}
  
	
	
	/**
	 * Return if the stack is at capacity.
	 * @returns true if the stack is full 
	 */
	public boolean isFull() { return size == MAX_SIZE; }


	
	/**
	 * Return if the stack has any elements.
	 * @returns true if the stack has no elements
	 */
	
	public boolean isEmpty() { return size == 0; }
	
	
	
	/**
	 * Return the number of elements in the stack.
	 * @returns size - the number of elements in the stack currently
	 */
	
	public int size() { return size; }
	
	
}
