import java.util.ArrayList;

public class Test {
	static BasicDoubleLinkedList<String> l;
	
	public static void main(String[] args) {
		l = new BasicDoubleLinkedList<String>();

		l.addToEnd("A");
		l.addToEnd("B");
		l.addToEnd("C");
		System.out.println(l.toArrayList());
	}
}
