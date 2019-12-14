/**
 * Represents a network of cities and roads (a graph). 
 * @author Eugene Domrachev
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;



public class TownGraph implements GraphInterface<Town, Road> {

	
	
	HashMap<Town, LinkedHashSet<Town>> adjacencyMap;
	HashMap<Town, LinkedHashSet<Road>> roadMap;
	HashSet<Road> roadSet;
	ArrayList<Town> vertexList;
	int[] distanceArray;
	Town[] previousVertexArray;
	
	TownGraph(){
		adjacencyMap = new HashMap<Town, LinkedHashSet<Town>>();
		roadMap = new HashMap<Town, LinkedHashSet<Road>>();
		roadSet = new HashSet<Road>();
	}
	
	
	
	
	
	
	
	/**
	 * Gets the road which connects the two towns.
	 * @param sourceVertex
	 * @param destinationVertex
	 * @return road if such a road exists, null if not 
	 */
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		if(adjacencyMap.get(sourceVertex).contains(destinationVertex)) {
			//TODO is there a better way to check this?
			for(Road road : roadSet) {
				if(road.connects(sourceVertex, destinationVertex)) {
					return road;
				}
			}
			
		}
		
		return null;
		
	}

	
	
	
	
	
	
	/**
	 * Add a road between two existing towns in the graph.
	 * @param sourceVertex source town
	 * @param destinationVertex destination town
	 * @param weight the length of the road in miles
	 * @param description the name of the road
	 * @return road the road that was created
	 * @throws IllegalArgumentException if either town does not exist in the graph
     */
	
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException {
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(!containsVertex(sourceVertex) || !containsVertex(sourceVertex)) {
			throw new IllegalArgumentException();
		}
		
		if(!roadMap.keySet().contains(sourceVertex) || !roadMap.keySet().contains(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		
		roadMap.get(sourceVertex).add(road);
		roadMap.get(destinationVertex).add(road);
		
		adjacencyMap.get(sourceVertex).add(destinationVertex);
		adjacencyMap.get(destinationVertex).add(sourceVertex);
		
		roadSet.add(road);
		
		return road;
		
	}

	
	
	
	
	
	
	/**
	 * Add a town to the graph.
	 * @param town the town to be added
	 * @return true if successfully added
	 */
	
	@Override
	public boolean addVertex(Town town) {
		
		if(!adjacencyMap.keySet().contains(town)) {
			adjacencyMap.put(town, town.getAdjacentSet());
			roadMap.put(town, new LinkedHashSet<Road>());
			return true;
		}
		
		return false;
		
	}

	
	
	
	
	
	
	/**
	 * Check if a road exists between two towns.
	 * @param sourceVertex the source town
	 * @param destinationVertex the destination town
	 * @return true if the road does exist, false if not
	 */
	
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		//TODO wouldn't this be the same as just checking the adjacency matrix?
		for(Road road : roadSet) {	
			 if (road.connects(sourceVertex, destinationVertex)) return true;
		}
		
		return false;
	
	}

	
	
	
	
	
	
	/**
	 * Check if the graph contains a town.
	 * @param town the town to check for
	 * @return true if the town exists, false if not
	 */
	
	@Override
	public boolean containsVertex(Town town) {
		return adjacencyMap.keySet().contains(town);
	}

	
	
	
	
	
	
	/**
	 * Return the set of roads in the graph.
	 * @return roadSet
	 */
	
	@Override
	public Set<Road> edgeSet() {
		return roadSet;
	}

	
	
	
	
	

	/**
	 * Return the vertex list.
	 * @return vertexList
	 */
	
	public ArrayList<Town> getTowns() {
		return vertexList;
	}
	
	
	
	
	
	
	
	/**
	 * Get the names of all towns in the graph.
	 * @return names an arraylist of all town names
	 */
	
	public ArrayList<String> getTownNames() {
		
		ArrayList<String> names = new ArrayList<String>();
		
		for(Town t : adjacencyMap.keySet()) {
			names.add(t.toString());
		}
		
		return names;
		
	}
	
	
	
	
	
	
	
	/**
	 * Get all the roads of a town in the graph.
	 * @param vertex the town to check
	 * @return the roads leading out of it
     * @throws NullPointerException if vertex is null
     */
	
	@Override
	public Set<Road> edgesOf(Town vertex) throws NullPointerException {

		if(roadMap.keySet().contains(vertex)) {
			return roadMap.get(vertex);
		}
		
		throw new NullPointerException();
	
	}

	
	
	
	
	
	
	/** 
	 * Removes a road from the graph.
	 * @param sourceVertex town it leads from/to
	 * @param destinationVertex town it leds to/from
	 * @param weight the road's distance
	 * @param description the road's name
	 * @return road the road removed, null if one was not removed
	 */
	
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(roadSet.contains(road)) {
			roadSet.remove(road);
			roadMap.remove(sourceVertex);
			roadMap.remove(destinationVertex);
			return road;
		}
		
		return null;
		
	}

	
	
	
	
	
	/**
	 * Remove all the specified town from the graph.
	 * @param town the town to be removed
	 * @return true if a town was removed, false if not 
	 */
	
	@Override
	public boolean removeVertex(Town town) {
		
		
		if(adjacencyMap.keySet().contains(town)) {
			
			LinkedHashSet roadsToDelete = roadMap.get(town);
			
			for(Town key : adjacencyMap.keySet()) {
				adjacencyMap.get(key).removeAll(Collections.singleton(town));
				roadMap.get(key).removeAll(roadsToDelete);
			}
			
			adjacencyMap.remove(town);
			roadMap.remove(town);
			
			
			return true;
			
			
		}
		
		
		
		return false;
		
	}

	
	
	
	
	
	
	/**
	 * Returns the vertices in the graph.
	 * @return tons the vertices of the graph
	 */
	
	@Override
	public Set<Town> vertexSet() {
		return adjacencyMap.keySet();
	}

	
	
	
	
	
	
	/**
	 * Gets the shortest path between two points by calculating the shortest path to all point from
	 * the source vertex using dijstrka's algorithm.
	 * @param sourceVertex the source of the path
	 * @param destinationVertex the end of the path
	 * @return history the traversal order of towns in arraylist form
	 */
	
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		
		dijkstraShortestPath(sourceVertex);
		System.out.println();
		Town temp = destinationVertex;
		ArrayList<String> history = new ArrayList<String>();
		
		if(previousVertexArray[vertexList.indexOf(temp)] != null) {
			while(!temp.equals(sourceVertex)) {
				history.add(temp.toString());
				temp = previousVertexArray[vertexList.indexOf(temp)];
			}
		} else if (!sourceVertex.equals(destinationVertex)) {
			throw new UnsupportedOperationException();
		}
		
		history.add(sourceVertex.toString());
		Collections.reverse(history);
		return history;
	}

	
	
	
	
	
	
	/**
	 * Fill the preset dijstrka fields to paths according to dijstrka's shortest path algorithm.
	 * @param startVertex the startpoint of the algorithm
	 */
	
	@Override
	public void dijkstraShortestPath(Town startVertex) {
		
		int size = vertexSet().size();
		
		vertexList = new ArrayList<Town>();
		distanceArray = new int[size];
		previousVertexArray = new Town[size];
		Arrays.fill(distanceArray, Integer.MAX_VALUE);
		
		ArrayList<Town> unvisited = new ArrayList<Town>();
		ArrayList<Town> visited = new ArrayList<Town>();
		
		for (Town t : vertexSet()){
			vertexList.add(t);
			unvisited.add(t);
		}
		
		
		distanceArray[vertexList.indexOf(startVertex)] = 0;
		
		

		Town source;
		
		while(!unvisited.isEmpty()) {
			
			int smallestDistIndex = vertexList.indexOf(unvisited.get(0));
			
			for(int i = 0; i < size; i++) {
				if(!visited.contains(vertexList.get(i)) && (distanceArray[i] < distanceArray[smallestDistIndex])) {
					smallestDistIndex = i;
				}
			}
			
			source = vertexList.get(smallestDistIndex);
			Town temp;
			
			for(Town t : adjacencyMap.get(source)) {
				
				if(unvisited.contains(t)) {
					
					int indexOfCurrent = vertexList.indexOf(t);
					Town holdingOld = previousVertexArray[indexOfCurrent];
					
					if(vertexList.get(indexOfCurrent) != startVertex) {
						previousVertexArray[indexOfCurrent] = source;
					}
					
					int distFromStart = 0;
					temp = t;
					
					while(!temp.equals(startVertex)) {
						distFromStart += getEdge(previousVertexArray[vertexList.indexOf(temp)], temp).getWeight();
						temp = previousVertexArray[ vertexList.indexOf(temp)];
					}
					
					if(distFromStart < distanceArray[indexOfCurrent]) {
						distanceArray[indexOfCurrent] = distFromStart;
						previousVertexArray[indexOfCurrent] = source;
					} else {
						previousVertexArray[indexOfCurrent] = holdingOld;
					}
					
				}
				
			}
			
			visited.add(source);
			unvisited.remove(source);
			
			
			
		}		
		
		
	}

	
	
	
	
	@Override
	public String toString() {
		
		String s = "TOWNS\n";
		
		if(adjacencyMap != null) {
			for(Town t : adjacencyMap.keySet()) {
				s += t + ": " + adjacencyMap.get(t) + "\n";
			}
			
			s += "\nROADS\n";
		}
		
		if(roadMap != null) {
			for(Town t : roadMap.keySet()) {
				s += t + ": " + roadMap.get(t) + "\n";
			}
		}
		return s;
	
	}
	
	
}
