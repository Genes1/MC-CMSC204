package _solution1;


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



public class SortedDoubleLinkedListTestPublic {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator;
	

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception", true);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception", true);
		}
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
	}

}
