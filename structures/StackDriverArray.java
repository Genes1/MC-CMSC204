package com;

public class StackDriverArray {
	
	public static void main(String[] args) {
		StringStackArray<String> s = new StringStackArray(3);
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
		s.pop();
		s.pop();
		s.pop();
	}
	
}
