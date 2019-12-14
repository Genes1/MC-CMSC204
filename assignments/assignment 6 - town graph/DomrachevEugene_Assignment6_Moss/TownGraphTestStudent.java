/**
 * Private tests for TownGraph. 
 * @author Eugene Domrachev
 *
 */


import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphTestStudent {
	
	TownGraph graph, ytExample;
	Town dc, ny, la, arc;
	Road highway1, highway2, highway3;

	
	@Before
	public void setUp() throws Exception {
		
		graph = new TownGraph();
		dc = new Town("Washington DC");
		ny = new Town("NYC");
		la = new Town("Los Angeles");
		arc = new Town("Arctic base");
		
		
		
		graph.addVertex(dc);
		graph.addVertex(ny);
		graph.addVertex(la);
		graph.addVertex(arc);
		
		
		graph.addEdge(dc, ny, 300, "highway 1");
		graph.addEdge(ny, la, 1000, "highway 2");
		graph.addEdge(dc, la, 1200, "highway 3");
		
		
		
		
		//https://youtu.be/pVfj6mxhdMw?t=553
		
		ytExample = new TownGraph();
		Town A = new Town("A");
		Town B = new Town("B");
		Town C = new Town("C");
		Town D = new Town("D");
		Town E = new Town("E");
		
		ytExample.addVertex(A);
		ytExample.addVertex(B);
		ytExample.addVertex(C);
		ytExample.addVertex(D);
		ytExample.addVertex(E);
		
		ytExample.addEdge(A, B, 6, "A to B");
		ytExample.addEdge(A, D, 1, "A to D");
		ytExample.addEdge(B, D, 2, "B to D");
		ytExample.addEdge(D, E, 1, "D to E");
		ytExample.addEdge(B, E, 2, "B to E");
		ytExample.addEdge(E, C, 5, "E to C");
		ytExample.addEdge(B, C, 5, "B to C");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	

	@Test
	public void testAddVertex() {
		
		Set<Town> set = new HashSet<Town>();
		set.add(dc);
		set.add(ny);
		set.add(la);
		set.add(arc);
		assertEquals(set, graph.adjacencyMap.keySet());
		
	}
	
	
	
	
	//TODO make separate cases
	@Test
	public void testAddEdge() {
		
		
		graph.addEdge(dc, ny, 300, "highway 1");
		graph.addEdge(ny, la, 1000, "highway 2");
		graph.addEdge(dc, la, 1200, "highway 3");
		

	}

	
	
	
	@Test
	public void testGetEdge() {
		
		assertEquals("highway 1", graph.getEdge(dc, ny).toString());
		assertEquals("highway 3", graph.getEdge(dc, la).toString());
		assertEquals(null, graph.getEdge(dc, arc));
	}
	
	
	
	
	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(la));
		assertEquals(true, graph.containsVertex(new Town("Los Angeles")));
		assertEquals(false, graph.containsVertex(new Town("Nonexistent town")));
	}
	
	
	
	
	@Test
	public void testEdgesOf() {
		
		try {
			graph.edgesOf(new Town("Nonexistent town"));
			assertEquals(true, false);
		} catch (NullPointerException e) {
			assert(true);
		}
		
		assertEquals("[highway 1, highway 3]", graph.edgesOf(dc).toString());
		
	}

	
	
	
	
	@Test
	public void testRemoveVertex() {
		
		//System.out.println(graph);
		LinkedHashSet<Road> deletedRoads = graph.roadMap.get(la);
		graph.removeVertex(la);
		assertEquals(true, !graph.adjacencyMap.keySet().contains(la) && !graph.roadMap.keySet().contains(la));
		
		
		for(Town key : graph.adjacencyMap.keySet()) {
			
			if(graph.adjacencyMap.get(key).contains(la.toString())) {
				System.out.println(graph);
				assertEquals(true, false);
				return;
			}
			
			for(Road r : graph.roadMap.get(key)) {
				if(deletedRoads.contains(r)) {
					System.out.println(graph);
					assertEquals(true, false);
					return;
				}
			}
			
		}

		

		
	}
	
	

	
	@Test
	public void testShortestPath() {
		Town A = new Town("A");
		Town C = new Town("C");
		assertEquals("[A, D, E, C]", ytExample.shortestPath(A, C).toString() );
	}
	
	
	

}
