import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * 
 * @author khandan Monshi, revised by Professor Kartchner
 * @author repurposed from DonationManagerTestPublic.java by Eugene Domrachev
 * 
 * Testing the DonationManager class with private tests.
 *
 */
public class DonationManagerTestStudent {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
		manager = new DonationManager();
	}
 
	@After
	public void tearDown() throws Exception {
		manager = null;
	}
 
	/**
	 * Test if a package can be successfully loaded into the manager.
	 */
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.managerLoadContainer(new DonationPackage("Pens",12));
		} catch (Exception e) {
			System.out.println("Should not throw an exception ");
		}	 	 
	}
	 
	/**
	 * Test if a volunteer is successfully loaded into the manager.
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new Volunteer("John"));
		} catch (Exception e) {
			System.out.println("Should not throw an exception ");
		}	
	} 
	
	/**
	 * Test if a recipient is successfully loaded into the manager.
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new Recipient("UMD"));
		} catch (Exception e) {
			assertTrue("Properly threw exception", true);
		}	
	} 
	
	/**
	 * Test if an error is thrown when there is no package and a donation is attempted.
	 */
	@Test
	public void donateNoPackage() throws ContainerException{
		try {
			manager.managerQueueRecipient(new Recipient("UMD"));
			manager.managerQueueVolunteer(new Volunteer("John"));
		} catch (Exception e) {
			assertTrue("Properly threw exception", true);
		}	
	} 
	
	/**
	 * Test if an error is thrown when there is no package and a donation is attempted.
	 */
	@Test
	public void donateNoVolunteer() throws VolunteerException {
		try {
			manager.managerQueueRecipient(new Recipient("UMD"));
			manager.managerLoadContainer(new DonationPackage("Pens",12));		
			} catch (VolunteerException e) {
				assertTrue("Properly threw exception", true);
		}	
	} 
	
	/**
	 * Test if an error is thrown when there is no package and a donation is attempted.
	 */
	@Test
	public void donateNoRecipient() throws RecipientException {
		try {
			manager.managerLoadContainer(new DonationPackage("Pens",12));
			manager.managerQueueVolunteer(new Volunteer("John"));
		} catch (RecipientException e) {
			System.out.println("Should not throw an exception ");
		}	
	} 

}
