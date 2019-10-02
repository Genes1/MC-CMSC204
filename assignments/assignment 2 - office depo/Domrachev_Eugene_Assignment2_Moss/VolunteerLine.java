/**
 * 
 * @author Eugene Domrachev
 * 
 * Custom error for errors dealing with the RecipientLine class.
 *
 */

public class VolunteerLine {

	MyQueue<Volunteer> volunteers;
	
	/**
	 * Provide two constructors:
	 * VolunteerLine(int size) make internal queue this size
	 * VolunteerLine() make internal queue default size
	 */
	
	VolunteerLine(int size){
		volunteers = new MyQueue(size);
	}
	
	VolunteerLine(){
		volunteers = new MyQueue(5);
	}
	
	
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throw VolunteerException("Volunteer Queue is full") is queue is full
	 */
	
	public boolean addNewVolunteer(Volunteer v) throws VolunteerException {
		
		if(!volunteers.isFull()) {
			return volunteers.enqueue(v);
		}
		
		throw new VolunteerException("Volunteer Queue is full");
		
	}
	
	
	
	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throw VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	public Volunteer volunteerTurn() throws VolunteerException {
		
		if(!volunteers.isEmpty()) {
			return volunteers.dequeue();
		}
		
		throw new VolunteerException("Volunteer queue is empty");
		
	}
 	  
	
	
	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, false otherwise
	 */
	public boolean volunteerLineEmpty() { return volunteers.isEmpty(); }
	
	
	
	/**
	 * Returns an array of the Volunteers in the queue
	 * @return an array of the volunteers in the queue
	 */
	public Volunteer[] toArrayVolunteer() {
		
		Object[] t = volunteers.toArray();
		Volunteer[] temp = new Volunteer[t.length];
		for ( int i= 0 ; i< t.length; i++)
			temp[i] = (Volunteer) t[i];
		return temp;
		
	}
	 
}
