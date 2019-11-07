import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * @author Professor Kartchner, repurposed by Eugene Domrachev
 */
public class ConcordanceDataStructureTestStudent {
	
	
	
	ConcordanceDataStructureInterface concordanceDataStructure, testStructure;
	String text;
	ArrayList<String> array;

	@Before
	public void setUp() throws Exception {
		testStructure = new ConcordanceDataStructure("Testing", 20);
	}

	@After
	public void tearDown() throws Exception {
		concordanceDataStructure = testStructure = null;
	}

	
	
	
	
	/**
	 * Test that words that hash to the same index are put in the same
	 * "bucket" for that index
	 */
	@Test
	public void testAdd() {
		
		testStructure.add("Dog", 5);
		testStructure.add("dog", 1);
		testStructure.add("dog", 1);
		testStructure.add("zebra", 3);
		testStructure.add("horse", 5);

		
		System.out.println(testStructure.showAll());
		assertEquals("[dog: 1, 5\n, horse: 5\n, zebra: 3\n]", testStructure.showAll().toString());
		
	}
	
	
	
	
	
	/**
	 * Test the tableSize for concordanceDataStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(20, testStructure.getTableSize());		
		testStructure = new ConcordanceDataStructure(500);
		assertEquals(347, testStructure.getTableSize());	
	}
	
	
	
}
