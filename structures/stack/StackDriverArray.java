import java.util.Arrays;

public class StackDriverArray {
	
	public static void main(String[] args) {
		StackArray<String> s = new StackArray(3);
		s.push("a");
		s.push("b");
		s.push("c"); 
		s.push("c"); //expect error message here about stack space
		s.display(); //expect a, b, c
		s.pop(); //expect c 
		s.pop(); //expect b
		s.peek(); //expect a
		s.display(); //expect a
		s.clear();
		s.display(); //expect all null
		s.push("yes");
		s.push("no");
		System.out.println(Arrays.toString(s.toArray()) + "\n");
		s.pop();
		s.pop();
		System.out.println(s.isEmpty());
		s.pop();
	}
	
}
