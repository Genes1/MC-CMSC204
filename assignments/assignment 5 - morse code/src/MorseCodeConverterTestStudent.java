/**
 * 
 * @author Eugene Domrachev
 *
 * Private tests for morse code conversion system
 *
 */

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTestStudent {
	
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);

	}

	
	
	
	
	/**
	 * Testing file reading capabilities
	 */

	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		File file = new File("src/howDoILoveThee.txt");
		try {
			assertEquals("how do i love thee let me count the ways", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			System.out.println("An unwanted exception was caught.");
			assertEquals(true, false);
		}
	}
	
	
	
	
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */
	
	@Test
	public void testPrintTree() {	
		
		MorseCodeConverter converter = new MorseCodeConverter();
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", converter.printTree());
		
	}
	
	
}
