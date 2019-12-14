/**
 * Represents a road/edge in a graph of cities. All roads are BIDIRECTIONAL and SYMMETRIC.
 * @author Eugene Domrachev
 *
 */

public class Road implements Comparable<Road>{

	
	
	String name;
	Town one, two;
	int distance;
	
	public Road(Town source, Town destination, int weight, String name) {
		distance = weight;
		one = source;
		two = destination;
		this.name = name;
	}

	public Road(Town source, Town destination, String name) {
		distance = 1;
		one = source;
		two = destination;
		this.name = name;
	}
	
	
	
	
	
	
	
	
	/**
	 * Check if the road/edge contains the given town
	 * @param town a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	
	public boolean contains(Town town) {
		return (town.equals(one) || town.equals(two));
	}
	
	
	
	
	
	
	
	/**
	 * Check if the passed towns are connected via this road.
	 * Pre: the towns ARE NOT the same, and there are no loops
	 * TODO is there a better way to check? does this check for self?
	 * 
	 * @param first town to be compared
	 * @param second town a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	
	public boolean connects(Town town1, Town town2) {
		return (town1.equals(one) || town1.equals(two)) && (town2.equals(one) || town2.equals(two));
	}
	
	
	
	
	
	
	
	/**
	 * Get the name of the road
	 * @return the name of the road
	 */
	
	public String getName() {
		return name;
	}
	
	
	
	
	
	
	
	/**
	 * Returns the second town on the road
	 * @return A town on the road

	 */
	
	public Town getSource() {
		return one;
	}
	
	
	
	
	
	
	
	/**
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	
	public Town getDestination() {
		return two;
	}
	
	
	
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	
	public int getWeight() {
		return distance;
	}
	
	
	
	
	
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. Remember that a road that goes from point A to point B is the same as a road that goes from point B to point A.
	 * @param r road object to compare it to
	 * @return true if equal, false if not
	 */
	
	@Override
	public boolean equals(Object r) {
		
		if (!(r instanceof Road)) {
			return false;
		}
		
		Road road = (Road) r;
		
		if(one.equals(road.getSource())) {
			if(one.equals(road.getDestination())) {
				return true;
			}
		} else if (one.equals(road.getDestination())) {
			if(one.equals(road.getSource())) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
	
	
	

	@Override
	public int compareTo(Road o) {
		return name.compareTo(o.getName());
	}

	
	
	@Override
	public String toString() {
		return name;//one + " via " + name + " to " + two + " " + distance + " mi";
	}
	
	
	
	public boolean equals(Road o) {
		return name.equals(o.getName());
	}
	
	
}
