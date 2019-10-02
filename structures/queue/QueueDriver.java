import java.util.Arrays;

public class QueueDriver {
	
	public static void main(String[] args) {
		QueueInterface<String> s = new QueueArray();	
		s.enqueue("a");
		s.enqueue("b");
		s.enqueue("c");
		System.out.println(Arrays.toString(s.toArray()) + "\n");	//expect [a, b, c]
		System.out.println(s.dequeue() + " dequeued \n");			//expect a
		System.out.println(s.dequeue() + " dequeued \n"); 			//expect b
		System.out.println(Arrays.toString(s.toArray()) + "\n"); 	//expect [c]
		
		System.out.println(s.dequeue() + "\n");						//expect c
		System.out.println(Arrays.toString(s.toArray()) + "\n");	//expect []
		
		/*s.display(); //expect a, b
		s.clear();
		s.display(); //expect all null*/
		
		s.enqueue("yes"); 
		s.enqueue("no");
		System.out.println("size: " + s.size() + "\n"); 			//expect 2
		System.out.println(Arrays.toString(s.toArray()) + "\n");	//expect [yes, no]

	}
	
}
