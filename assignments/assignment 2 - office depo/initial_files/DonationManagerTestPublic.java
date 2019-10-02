package _solution;
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

 
/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerTestPublic {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {
	 
		manager = new DonationManager();
		
	}
 
	@After
	public void tearDown() throws Exception {
		 
		manager = null;
	}
 
	@Test
	public void testManagerLoadcontainer()   {
	
		try {
			manager.managerLoadContainer(new DonationPackage("Pens",12));
		} catch (Exception e) {
			System.out.println("Should not throw an exception ");
		}	 	 
	}
	 
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new  Volunteer("John"));
		} catch (Exception e) {
			System.out.println("Should not throw an exception ");
		}	
	} 

}
