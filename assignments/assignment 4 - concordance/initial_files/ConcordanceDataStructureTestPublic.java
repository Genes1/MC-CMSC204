package _solution;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the ConcordanceDataManager
 * which is implemented from the ConcordanceDataManagerInterface
 * @author Professor Kartchner
 */
public class ConcordanceDataStructureTestPublic {
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
	public void testAddA() {
		testStructure.add("dog", 1);
		//banana should be stored at index 7
		//Math.abs("banana".hashCode()%20)
		System.out.println(Math.abs("dog".hashCode()%20));
		assertEquals("dog", testStructure.getWords(4).get(0));
	}
	
	/**
	 * Test the tableSize for concordanceDataStructures constructed
	 * with both constructors
	 */
	@Test
	public void testGetTableSize()
	{
		assertEquals(20, testStructure.getTableSize());		
	}
	
}
