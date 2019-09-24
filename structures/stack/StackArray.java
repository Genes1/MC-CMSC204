
public class StackArray<T> implements StackInterface<T>{ 

	final int MAX_SIZE;
	private T[] stack;
	private int size;
	//TODO CHECK FOR SIZE
	StackArray(int size) {
		MAX_SIZE = size;
		stack = (T[]) new Object[MAX_SIZE];
		size = 0;
	}

	
	
	
	//   public T getMaximum()
	public boolean push(T newEntry) {
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if (stack[i] == null) {
		    	stack[i] = newEntry;
    			System.out.println("'" + newEntry + "' was pushed to the stack.");
    			size += 1;
		    	return true;
		    }
	    } 
	    
	    System.out.println("Could not add '" + newEntry + "' to stack as it is full.\n");
	    return false;
	    
	}
	
	
	
	
	
	public T pop() {
		
		int last = 0;
		T val = null;
		
		//get last element 
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
	    
	    //if val == null return -1?
	    System.out.println("Popped: " + val);
	    
	    size -= 1;
	    return val;
	    
	}
  
	

	
	
	public T peek() {
		
		int last = 0;
		T val = null; //?
		
		//get last element 
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if(stack[i] != null || i == MAX_SIZE - 1){
			    last = i;
		    } else {
		    	val = stack[last];
		    	break;
		    }
	    } 
	    
	    System.out.println("Peeked: " + val);
	    return val;
	    
	}

	
	
	
	
	public void display() {
		
		System.out.println();
	    for(int i = 0; i < MAX_SIZE; i++) {
		    System.out.println("[" + i + "] " + stack[i]);
	    } 
	    System.out.println();
	    
	}
	
	
	
	
	
	public boolean isEmpty() {
		
	    /*for(int i = 0; i < MAX_SIZE; i++) {
		    if(stack[i] != null) return false;
	    } */
	    return size == 0;
	    
	}
  
	
	
	
	
	public void clear(){
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    stack[i] = null;
	    } 
	    size = 0;
	    
	}
  
	
	
	
	
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}





	@Override
	public int size() {
		return size;
	}



	@Override
	public T[] toArray() {
		T[] arr = (T[]) new Object[size];
		for(int i = 0; i < size; i++) {
			arr[i] = stack[i];
		}
		return arr;
	}
	
	
}
