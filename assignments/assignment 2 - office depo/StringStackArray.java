package com;

public class StringStackArray<T> implements StackInterface<T>{ 

	final int MAX_SIZE;
	private T[] stack;
	
	
	StringStackArray(int size){
		
		MAX_SIZE = size;
		stack = (T[]) new Object[MAX_SIZE];
		
	}

	
	
	
	
	public T pop(){
		
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
	    
	    System.out.println("Popped: " + val);
	    return val;
	    
	}
  
	

	public T peek(){
		
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

	
	
	public boolean isEmpty(){
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if(stack[i] != null) return false;
	    } 
	    return true;
	    
	}
  
	
	
	public void clear(){
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    stack[i] = null;
	    } 
	    
	}
   
	
	
	public void display(){
		
		System.out.println();
	    for(int i = 0; i < MAX_SIZE; i++) {
		    System.out.println("[" + i + "] " + stack[i]);
	    } 
	    System.out.println();
	    
	}
	
	
	//   public T getMaximum()
	public void push(T newEntry) {
		
	    for(int i = 0; i < MAX_SIZE; i++) {
		    if (stack[i] == null) {
		    	stack[i] = newEntry;
    			System.out.println("'" + newEntry + "' was pushed to the stack.");
		    	return;
		    }
	    } 
	    
	    System.out.println("Could not add '" + newEntry + "' to stack as it is full.\n");

	}
	
	
}
