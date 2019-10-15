
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

	@Before
	public void setUp() throws Exception {
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
	public void tearDown() throws Exception {
		linkedString = null;
	}

	
	
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
	
	
	
	@Test
	public void testAddToEnd() {
		assertEquals("A", linkedString.getLast());
		linkedString.addToEnd("B");
		assertEquals("B", linkedString.getLast());
		
		assertEquals("headNtail", linkedStringOne.getLast());
		linkedStringOne.addToEnd("new tail");
		assertEquals("new tail", linkedStringOne.getLast());
		
		assertEquals("Second", linkedStringTwo.getLast());
		linkedStringTwo.addToEnd("new tail");
		assertEquals("new tail", linkedStringTwo.getLast());
		
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
	
	
	//TODO
	@Test
	public void testIteration() {
		it = linkedString.iterator();
		
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}
	
	@Test
	public void testRemove() {
		it = linkedString.iterator();
		
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
	}
	
	
}
