/**
 * 
 * @author Eugene Domrachev
 * 
 * An array-based implementation of a queue.
 *
 */

public class MyQueue<T> implements QueueInterface {
	
	final int MAX_SIZE;
	private T[] queue;
	private int size;
	
	/** 
	 * Provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 */
	
	MyQueue(int n) {
		MAX_SIZE = n;
		queue = (T[]) new Object[MAX_SIZE];
		size = 0;
	}
	
	MyQueue() {
		MAX_SIZE = 5;
		queue = (T[]) new Object[MAX_SIZE];
		size = 0;
	}
	
	
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() { return size == 0; };

	
	
	/**
	 * Determines if the Queue has reached max size
	 * @return true if the size == max size
	 */
	public boolean isFull() { return size == MAX_SIZE; };
	
	
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front [0] of the Queue
	 */
	
	public T dequeue() {
		
		T temp = (T) new Object();
		if(!isEmpty() && queue[0] != null) {
			temp = queue[0];
			for(int i = 0; i < size; i++) {
				if(i != size-1) {
					if(queue[i+1] != null) {
						queue[i] = queue[i+1];
					}
				}
			}
			size -= 1;
		}
		return temp;
		
	};

	
	
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	
	public int size() { return size; };
	
	
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	
	public boolean enqueue(Object e) {
		
		if(!isFull()) {
			queue[size] = (T) e;
			size += 1;
			return true;
		}
		return false;
		
	};
	
	
	
	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	 
	public T[] toArray() {
		
		T[] arr = (T[]) new Object[size];
		for(int i = 0; i < size; i++) {
			arr[i] = queue[i];
		}
		
		return arr;
		
	};
	

	
}
