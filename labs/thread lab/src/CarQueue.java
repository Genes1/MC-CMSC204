import java.util.LinkedList;
import java.util.Queue;

public class CarQueue {
	
	Queue<Integer> directionQueue;
	
	CarQueue(){
		directionQueue = new LinkedList<Integer>();
		for(int i = 0; i < 5; i++) {
			directionQueue.add(getRandom());
		}
	}
	
	
	
	/** 
	 * Adds 0,1,2 or 3 to queue
     *  0 = up
     *  1 = down
     *  2 = right
     *  3 = left
     */

	void addToQueue(){

		
		class RandomThread implements Runnable {
			public void run(){
				try {
					while(true) {
						directionQueue.add(getRandom());
						Thread.sleep(500);
					}
				} catch (InterruptedException e) {
					
				}
			}
		}
		
		RandomThread rThread = new RandomThread();
		Thread randomGenThread = new Thread(rThread);
		randomGenThread.start();
		
	}
	
	
	
	int deleteQueue(){
		return directionQueue.poll();
	}
	
	
	
	static int getRandom() {
		return (int) (Math.random() * 4);
	}
	
}
