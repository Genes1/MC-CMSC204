import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author revised by Professor Kartchner
 * @author repurposed from RecipientLineTestPublic.java by Eugene Domrachev
 * 
 * Testing the RecipientLine class with private tests.
 *
 */
public class RecipientLineTestStudent {

	RecipientLine aRecipientLine;
	Recipient r1;

	@Before
	public void setUp() throws Exception {
		aRecipientLine = new RecipientLine(5);
		r1 = new Recipient("rc1");
	}

	@After
	public void tearDown() throws Exception {
		aRecipientLine = null;
		r1 = null;
	}
	
	/**
	 * Test if a recipient can be successfully loaded into the queue.
	 */
	@Test
	public void testAddNewRecipient() {

		try {
			assertTrue(aRecipientLine.addNewRecipient(r1));
		} catch (Exception e) {
			assertTrue("This should not have thrown an exception", false);
		}
	}
	
	
	/**
	 * Test if an exception is thrown when capacity is reached and another recipient is queued.
	 */
	@Test
	public void testAddOverflow() throws RecipientException{

		try {
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.addNewRecipient(r1);
			assertTrue(false);
		} catch (RecipientException e) {
			assertTrue("Expected exception thrown", true);
		}
	}
	
	/**
	 * Test if a recipient can be successfully dequeued.
	 */
	@Test
	public void testRemoveNewRecipient() throws RecipientException {
		
		// add and remove one 
		try {
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.recipientTurn();
			assertTrue(true);
		} catch (RecipientException e) {
			assertTrue("Exception thrown", false);
		}
		
		// add one and remove twice
		try {
			aRecipientLine.addNewRecipient(r1);
			aRecipientLine.recipientTurn();
			aRecipientLine.recipientTurn();
			assertTrue(false);
		} catch (RecipientException e) {
			assertTrue("Exception succesfully thrown", true);
		}
		
	}
	
}
