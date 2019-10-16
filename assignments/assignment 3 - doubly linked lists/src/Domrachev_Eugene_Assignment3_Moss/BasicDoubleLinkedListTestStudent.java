/**
 * 
 * @author Eugene Domrachev
 * 
 * Private tests for the basic double linked list.
 *
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





public class BasicDoubleLinkedListTestStudent {
	
	BasicDoubleLinkedList<String> linkedStringEmpty, linkedStringOne, linkedStringTwo, linkedString;
	ListIterator it;
	StringComparator sComp;
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	@Before
	public void setUp() throws Exception {
		
		sComp = new StringComparator();
		
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("A");
		linkedString.addToEnd("B");
		linkedString.addToEnd("C");
		linkedString.addToEnd("A");
		
		linkedStringOne = new BasicDoubleLinkedList<String>();
		linkedStringOne.addToEnd("headNtail");
		
		linkedStringTwo = new BasicDoubleLinkedList<String>();
		linkedStringTwo.addToEnd("First");
		linkedStringTwo.addToEnd("Second");
		
		linkedStringEmpty = new BasicDoubleLinkedList<String>();
	}

	@After
	public void tearDown() throws Exception { linkedString = null; }

	
	
	
	
	/*
	 * Test adding to the end of the list.
	 */
	
	@Test
	public void testAddToEnd() {
		
		//Multi list 
		assertEquals("A", linkedString.getLast());
		linkedString.addToEnd("B");
		assertEquals("B", linkedString.getLast());
		
		//Single list 
		assertEquals("headNtail", linkedStringOne.getLast());
		linkedStringOne.addToEnd("new tail");
		assertEquals("new tail", linkedStringOne.getLast());
		
		//Double list 
		assertEquals("Second", linkedStringTwo.getLast());
		linkedStringTwo.addToEnd("new tail");
		assertEquals("new tail", linkedStringTwo.getLast());
		
		//Empty list
		try {
			linkedStringEmpty.getLast();
		} catch (NoSuchElementException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		linkedStringEmpty.addToEnd("firstele");
		assertEquals("firstele", linkedStringEmpty.getLast());
		
		
	}

	
	
	
	
	/*
	 * Test adding to the front of the list.
	 */
	
	@Test
	public void testAddToFront() {		
		
		assertEquals("A", linkedString.getFirst());
		linkedString.addToFront("Begin");
		assertEquals("Begin", linkedString.getFirst());
		
		
		linkedStringOne.addToFront("new tail");
		assertEquals("new tail", linkedStringOne.getFirst());
		
		linkedStringTwo.addToFront("new tail");
		assertEquals("new tail", linkedStringTwo.getFirst());
		
		linkedStringEmpty.addToFront("firstele");
		assertEquals("firstele", linkedStringEmpty.getFirst());
		
	}
	
	
	
	
	
	
	/*
	 * Test if the size of the lists is being changed as expected.
	 * Precondition: the addToFront/End tests passed.
	 */
	
	@Test
	public void testGetSize() {

		assertEquals(4,linkedString.getSize());
		linkedString.retrieveLastElement();
		assertEquals(3,linkedString.getSize());
		linkedString.retrieveLastElement();
		linkedString.retrieveLastElement();
		assertEquals(1,linkedString.getSize());
		linkedString.retrieveLastElement();
		assertEquals(0,linkedString.getSize());
		linkedString.addToEnd("A");
		linkedString.addToEnd("A");
		assertEquals(2,linkedString.getSize());
		
	}
	
	
	
	
	
	/*
	 * Test if the iteration is as expected.
	 * Precondition: add must pass
	 */
	
	@Test
	public void testIterate() {
		
		ArrayList<Object> returns = new ArrayList<Object>();
		
		//Multi list
		it = linkedString.iterator();
		assertEquals(false, it.hasPrevious());
		assertEquals(true, it.hasNext());
		returns.add(it.next()); //to A
		returns.add(it.next()); //to B
		assertEquals(true, it.hasPrevious());
		assertEquals(true, it.hasNext());
		returns.add(it.next()); //to C
		returns.add(it.next()); //to A
		assertEquals(true, it.hasPrevious());
		assertEquals(false, it.hasNext());
		
		try {
			it.next();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		returns.add(it.previous()); //to A
		returns.add(it.previous()); //to C
		returns.add(it.next()); //to C
		returns.add(it.previous()); //to C
		returns.add(it.previous()); //to B
		returns.add(it.previous()); //to A
		
		try {
			it.previous();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			assertTrue(true);
			returns.add("E");
		} catch (Exception e) {
			assertTrue(false);
		}
		
		//[A, B, C, A, E, A, C, C, C, B, A, E] + E
		
		//Verifying retrieving first node does not keep reference
		linkedString.retrieveFirstElement();
		it = linkedString.iterator();
		assertEquals(false, it.hasPrevious());
		
		try {
			it.previous();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			assertTrue(true);
			returns.add("E");
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals("[A, B, C, A, E, A, C, C, C, B, A, E, E]", returns.toString());
		
		
		
		//Double list 
		
		returns = new ArrayList<Object>();
		it = linkedStringTwo.iterator();
		
		returns.add(it.next()); //to First
		assertEquals(true, it.hasPrevious());
		assertEquals(true, it.hasNext());
		returns.add(it.next()); //to Second

		try {
			it.next();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		returns.add(it.previous()); //to Second
		returns.add(it.previous()); //to First
		
		try {
			it.previous();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals("[First, Second, E, Second, First, E]", returns.toString());
		
		
		
		//Single list
		
		returns = new ArrayList<Object>();
		it = linkedStringOne.iterator();
		
		returns.add(it.next()); //to headNtail
		assertEquals(true, it.hasPrevious());
		assertEquals(false, it.hasNext());
		
		try {
			it.next();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		returns.add(it.previous()); //to headNtail
		
		try {
			it.previous();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals("[headNtail, E, headNtail, E]", returns.toString());
		
		
		
		//Empty list
		
		returns = new ArrayList<Object>();
		it = linkedStringEmpty.iterator();
		
		try {
			it.next();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		
		try {
			it.previous();
			assertTrue(false);
		} catch (NoSuchElementException e) {
			returns.add("E");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertEquals("[E, E]", returns.toString());
		

		
	}
	
	
	
	
	
	
	/*
	 * Test if the first element getter is working as expected.
	 * Precondition: addToFront tests passed.
	 */
	
	@Test
	public void testGetFirst() {
		
		assertEquals("A", linkedString.getFirst());
		assertEquals("A", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals("headNtail", linkedStringOne.getFirst());
		assertEquals("headNtail", linkedStringOne.getFirst());
		linkedStringOne.addToFront("New");
		assertEquals("New", linkedStringOne.getFirst());
		
		assertEquals("First", linkedStringTwo.getFirst());
		assertEquals("First", linkedStringTwo.getFirst());
		linkedStringTwo.addToFront("New");
		assertEquals("New", linkedStringTwo.getFirst());
		
		try {
			linkedStringEmpty.getFirst();
		} catch (NoSuchElementException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		linkedStringEmpty.addToFront("New");
		assertEquals("New", linkedStringEmpty.getFirst());
		
	}

	
	
	
	
	/*
	 * Test if the first element getter is working as expected.
	 * Precondition: addToEnd tests passed. 
	 */
	
	@Test
	public void testGetLast() {
		
		assertEquals("A", linkedString.getLast());
		assertEquals("A", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals("headNtail", linkedStringOne.getLast());
		assertEquals("headNtail", linkedStringOne.getLast());
		linkedStringOne.addToEnd("New");
		assertEquals("New", linkedStringOne.getLast());
		
		assertEquals("Second", linkedStringTwo.getLast());
		assertEquals("Second", linkedStringTwo.getLast());
		linkedStringTwo.addToEnd("New");
		assertEquals("New", linkedStringTwo.getLast());
		
		try {
			linkedStringEmpty.getLast();
		} catch (NoSuchElementException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		linkedStringEmpty.addToEnd("New");
		assertEquals("New", linkedStringEmpty.getLast());
		
	}
	
	
	
	
	
	
	/*
	 * Test if the list is as expected after valid and invalid remove operations
	 */
	
	@Test
	public void testRemove() {
		
		//Multi list
		assertEquals(true, linkedString.contains("A", sComp));
		linkedString.remove("A", sComp);
		assertEquals("[B, C, A]", linkedString.toArrayList().toString());
		linkedString.remove("A", sComp);
		assertEquals(false, linkedString.contains("A", sComp));
		linkedString.remove("Arbitrary element ", sComp);
		assertEquals("[B, C]", linkedString.toArrayList().toString());

		//Single list 
		assertEquals(true, linkedStringOne.contains("headNtail", sComp));
		linkedStringOne.remove("headNtail", sComp);
		assertEquals(false, linkedStringOne.contains("headNtail", sComp));
		linkedStringOne.remove("Arbitrary element ", sComp);
		assertEquals("[]", linkedStringOne.toArrayList().toString());
		assertEquals(false, linkedStringOne.contains("Arbitrary element", sComp));

		
		//Double list 
		assertEquals(true, linkedStringTwo.contains("Second", sComp));
		linkedStringTwo.remove("Second", sComp);
		assertEquals(false, linkedStringTwo.contains("Second", sComp));
		linkedStringTwo.remove("Arbitrary element ", sComp);
		assertEquals("[First]", linkedStringTwo.toArrayList().toString());
		assertEquals(false, linkedStringTwo.contains("Arbitrary Element", sComp));
		linkedStringTwo.remove("First", sComp);
		assertEquals("[]", linkedStringTwo.toArrayList().toString());
		
		//Empty list
		linkedStringEmpty.remove("A", sComp);
		assertEquals("[]", linkedStringEmpty.toArrayList().toString());
		
	}
	
	
}
