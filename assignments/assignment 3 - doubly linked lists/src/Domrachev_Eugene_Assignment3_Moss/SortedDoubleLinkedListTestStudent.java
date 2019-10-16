/**
 * 
 * @author Eugene Domrachev
 * 
 * Private tests for the sorted double linked list.
 *
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





public class SortedDoubleLinkedListTestStudent {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator c;
	ListIterator it;


	@Before
	public void setUp() throws Exception {
		c = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(c);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	
	
	
	
	/*
	 * Test to ensure correct sorted results. 
	 * Precondition: toArrayList tests must pass
	 */
	
	@Test
	public void testSort() {
		
		sortedLinkedString.add("A", c);
		sortedLinkedString.add("C", c);
		assertEquals("[A, C]", sortedLinkedString.toArrayList().toString()); 
		sortedLinkedString.add("B", c);
		assertEquals("[A, B, C]", sortedLinkedString.toArrayList().toString());
		sortedLinkedString.add("BB", c);
		assertEquals("[A, B, BB, C]", sortedLinkedString.toArrayList().toString());
		sortedLinkedString.add("1", c);
		assertEquals("[1, A, B, BB, C]", sortedLinkedString.toArrayList().toString());
		sortedLinkedString.add("D", c);
		assertEquals("[1, A, B, BB, C, D]", sortedLinkedString.toArrayList().toString());
		
	}

	
	
	
	private class StringComparator implements Comparator<String>
	{
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

	
}
