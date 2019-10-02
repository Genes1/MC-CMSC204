import static org.junit.Assert.*;

import java.util.EmptyStackException;
 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author revised by Professor Kartchner
 * @author repurposed from ContainerTestPublic.java by Eugene Domrachev
 * 
 * Testing the Container class with private tests.
 *
 */
public class ContainerTestStudent {
	
	Container aContainer;
	DonationPackage dpk1, testPack;
	

	@Before
	public void setUp() throws Exception {
		dpk1 = new DonationPackage("Pens", 10);
		aContainer = new Container(5);
	}
	

	@After
	public void tearDown() throws Exception {
		dpk1 = null;
		aContainer = null;
	}

	/**
	 * Test if a package can be successfully loaded into a container.
	 */
	@Test
	public void testLoadContainer() {
		try {
			assertTrue(aContainer.loadContainer(dpk1));
			testPack = new DonationPackage("Book", 10);
			assertTrue(aContainer.loadContainer(testPack));
		} catch (Exception e) {
			assertTrue("This should not have thrown an exception", false);
		}		 
	}
	
	/**
	 * Test if the container throws an exception when excessive packages are loaded.
	 * @throw ContainerException
	 */
	@Test
	public void testOverloadContainer() throws  ContainerException {
		try {
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk1);
			aContainer.loadContainer(dpk1);
			assertTrue(false);
		} catch (ContainerException  e) {
			assertTrue("Properly threw exception", true);
		}		 
	}
	
	/**
	 * Test if the container successfully removes a package from a container.
	 */
	@Test
	public void testRemovePackageFromContainer() {		 
		try {
			aContainer.loadContainer(dpk1);
			aContainer.removePackageFromContainer();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue("This should not have thrown an exception", false);
		}

	}
	
	/**
	 * Test if the container throws an exception when it is empty and a call to remove is made.
	 * @throw ContainerException
	 */
	@Test
	public void testRemovePackageFromEmptyContainer() throws  ContainerException {		 
		try {
			aContainer.loadContainer(dpk1);
			aContainer.removePackageFromContainer();
			aContainer.removePackageFromContainer();

		} catch (ContainerException e) {
			assertTrue("Properly threw exception", true);
		}

	}

}
