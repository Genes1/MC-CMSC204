
public class StackDriverLinkedList {
	
	public static void main(String[] args) {
		//StringStackArray s = new StringStackArray(3);
		DoubleLinkedList<String> s = new DoubleLinkedList("a");	
		s.push("b");
		s.push("c");
		s.push("d"); //expect error message here about stack space
		s.display(); //expect a, b, c
		System.out.println(s.pop() + "\n"); //expect c 
		System.out.println(s.pop() + "\n"); //expect b
		System.out.println(s.peek() + "\n"); //expect a
		s.display(); //expect a, b
		s.clear();
		s.display(); //expect all null
		s.push("yes"); 
		s.push("no");
		s.pop();
		s.pop();
		s.pop();
	}
	
}
