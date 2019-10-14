import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Warmup {
	
	LinkedList<String> courses;
	
	public static void main(String[] args) {
		
        LinkedList<String> courses = new LinkedList<String>(); 
        courses.add("cmsc204");
        courses.add("cmsc140");
        courses.add("bio141");
        courses.add("econ100");
    	Iterator<String> it = courses.iterator();

    	//iteration
    	while(it.hasNext()) {
    		System.out.println(it.next());
    	}	
    	System.out.println();
    	
    	
    	
    	it = courses.iterator();
    	
    	
    	
    	//search for the desired element using .next() and remove() it 
    	while(it.hasNext()) {
    		if(it.next().equals("bio141")) {
    			it.remove();
    			break;
    		}
    	}	
    	System.out.println();
    	
    	
    	
    	it = courses.iterator();
    	
    	
    	
    	//iteration
    	while(it.hasNext()) {
    		System.out.println(it.next());
    	}	
    	
    	
    	System.out.println("a to b " + "a".compareTo("b"));
    	System.out.println("a to c " + "a".compareTo("c"));
    	System.out.println("b to c " + "b".compareTo("c"));
	}
	
	
	
	
	
	


		

		
}
	
