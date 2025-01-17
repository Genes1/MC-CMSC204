/**
 * Manager class for a graph of type TownGraph. 
 * @author Eugene Domrachev
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


public class TownGraphManager implements TownGraphManagerInterface {

	
	
	TownGraph graph;
	
	TownGraphManager(){
		graph = new TownGraph();
	}
	
	
	
	
	
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		try {
			Town townA = new Town(town1);
			Town townB = new Town(town2);
			graph.addEdge(townA, townB, weight, roadName);
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

	
	
	

	
	
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	
	@Override
	public String getRoad(String town1, String town2) {
		
		Town townA = new Town(town1);
		Town townB = new Town(town2);
		
		for(Road r : graph.roadMap.get(townA)) {
			if(r.connects(townA, townB)) {
				return r.toString();
			}
		}
		
		return null;
		
	}

	
	
	

	
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	
	@Override
	public boolean addTown(String v) {
		
		try {
			graph.addVertex(new Town(v));
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

	
	
	

	
	
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	
	@Override
	public Town getTown(String name) {
		
		for(Town t : graph.vertexSet()) {
			if(t.getName().equals(name)) {
				return t;
			}
		}
		
		return null;
		
	}

	
	
	

	
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}
	
	

	
	
	
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		Town townA = new Town(town1);
		Town townB = new Town(town2);
		HashSet<Road> smallestSet = (graph.roadMap.get(townA).size() < graph.roadMap.get(townA).size()) ? graph.roadMap.get(townA) : graph.roadMap.get(townB);
		
		for(Road r : smallestSet) {
			if(r.connects(townA, townB)) {
				return true;
			}
		}
		
		return false;
		
	}

	
	
	

	
	
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	
	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(Road r : graph.edgeSet()) {
			list.add(r.toString());
		}
		
		Collections.sort(list);
		return list;
		
	}

	
	
	

	
	
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		Town townA = new Town(town1);
		Town townB = new Town(town2);
		
		if(graph.removeEdge(townA, townB, 1, road) != null) {
			return true;
		}
		
		return false;
		
	}

	
	
	

	
	
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	
	@Override
	public boolean deleteTown(String v) {
		Town town = new Town(v);
		return graph.removeVertex(town);
	}

	
	
	

	
	
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> list = graph.getTownNames(); //a new variable has to be sorted as a sort on the vertexlist would desync the dijstrka's algorithm output.
		Collections.sort(list);
		return list;
	}
	
	
	
	
	
	
	
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town townA = new Town(town1);
		Town townB = new Town(town2);
		return graph.shortestPath(townA, townB);
	}

	
	
	

	
	
	/**
	 * Clears the results of dijstrka's algorithm.
	 */
	
	public void clearTownFields() {
		graph.vertexList = null;
		graph.distanceArray = null;
		graph.previousVertexArray = null;
	}

	
	

	
	
	
	/**
	 * Display the path between the two inputs via arraylist for each road.
	 * @param name the source town
	 * @param name2 the destination town
	 * @return path the arraylist of roads and towns traveled
	 */
	
	public ArrayList<String> getPathSets(String name, String name2) {
		
		ArrayList<String> path = new ArrayList<String>();
		ArrayList<String> townpath = getPath(name, name2);
		Town temp = new Town("");
		
		for(int i = 0; i < townpath.size(); i++) {
			
			if(i != 0) {
				Road r = graph.getEdge(temp, new Town(townpath.get(i)));
				path.add(temp + " via " + r.toString() + " to " + townpath.get(i) + " " + r.getWeight() + " mi\n");
			}
			
			temp = new Town(townpath.get(i));
			
		}
		
		return path;
		
	}
	
	

}
