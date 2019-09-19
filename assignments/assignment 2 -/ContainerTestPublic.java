package _solution;
import static org.junit.Assert.*;

import java.util.EmptyStackException;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author revised by Professor Kartchner
 *
 */
public class ContainerTestPublic {
	Container aContainer;
	DonationPackage dpk1;
	@Before
	public void setUp() throws Exception {
		dpk1 = new DonationPackage("Pens", 10);
		aContainer = new Container(5);
		 
		
	}

	@After
	public void tearDown() throws Exception {
		dpk1=null;
		aContainer=null;
	}

	@Test
	public void testLoadContainer() {
		 
		try {
			assertTrue(aContainer.loadContainer(dpk1));

		} catch (Exception e) {
			assertTrue("This should not have thrown an exception", false);
		}		 
	}
	@Test
	public void tesRemovePackageFromContainer() {		 
		try {
			aContainer.loadContainer(dpk1);
			aContainer.removePackageFromContainer();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue("This should not have thrown an exception", false);
		}

	}

}
