/**
 * Private tests for class Road.
 * @author Eugene Domrachev
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoadTestStudent {
	
	Road road1, road2, road3;
	Town town1, town2, town3;
	  
	@Before
	public void setUp() throws Exception {
		
		town1 = new Town("Washington");
		town2 = new Town("Dallas");
		town3 = new Town("NYC");
		
		road1 = new Road(town1, town2, 500, "WtD");
		road2 = new Road(town1, town2, 500, "DtW");
		road2 = new Road(town1, town2, "WtN");

	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	
	@Test
	public void testContains() {
		assertEquals(true, road1.contains(town1));
		assertEquals(true, road1.contains(town2));
		assertEquals(false, road1.contains(town3));
	}
	
	
	
	
	
	@Test
	public void testConnects() {
		assertEquals(true, road1.connects(town1, town2));
		assertEquals(true, road1.connects(town2, town1));
		assertEquals(false, road1.connects(town1, town3));
	}
	
	

}
