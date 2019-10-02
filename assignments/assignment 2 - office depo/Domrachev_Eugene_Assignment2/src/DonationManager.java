/**
 * 
 * @author Eugene Domrachev
 * 
 * The manager of a theoretical Office Depot which directs donations and 
 * addition of new packages, recipients, and volunteers.
 *
 */

public class DonationManager {
	
	Container container;
	VolunteerLine volunteers;
	RecipientLine recipients;
	String msg;
	
	DonationManager(){
		container = new Container();
		volunteers = new VolunteerLine();
		recipients = new RecipientLine();

	}
	
	/**
	 * Stacks a new donation package in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throw ContainerException if container is full
	 */
	
	public boolean managerLoadContainer(DonationPackage dPackage) throws ContainerException{
		return container.loadContainer(dPackage);
	};
	 
	
	
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throw VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	
	public boolean managerQueueVolunteer(Volunteer v) throws VolunteerException {
		return volunteers.addNewVolunteer(v);
	}
	 
	
	
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param r a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throw RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	
	public boolean managerQueueRecipient(Recipient r) throws RecipientException {
		return recipients.addNewRecipient(r);
	}


	
	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throw VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throw ContainerExcpetion("Contain is empty") if the container is empty
	 * @throw RecipientException("Recipient Queue is empty") if there are no recipients
	 */
	
	public void donatePackage() throws VolunteerException, ContainerException, RecipientException {
		
		if(recipients.recipientLineEmpty()) {
			throw new RecipientException("The Recipient Queue is empty");
		} else if(volunteers.volunteerLineEmpty()) {
			throw new VolunteerException("Volunteer queue is empty");
		} else if(container.getStack().isEmpty()) {
			throw new ContainerException("The Container is empty"); 
		} else {
			Volunteer v = volunteers.volunteerTurn();
			msg = new String(v + " delivered " 
							+ container.removePackageFromContainer() + " to " 
							+  recipients.recipientTurn() + ".");
			volunteers.addNewVolunteer(v);
		}

		
	}

	/**
	 * @return array of packages in the container
	 */
	public Object[] ManagerArrayPackage() {
		return container.toArrayPackage();
	}
	
	/**
	 * @return array of volunteers available/in queue
	 */
	public Object[] ManagerArrayVolunteer() {
		return volunteers.toArrayVolunteer();
	}
	
	/**
	 * @return array of recipients available/in queue
	 */
	public Object[] ManagerArrayRecipient() {
		return recipients.toArrayRecipient();
	}
	
	
	public String toString() {
		return msg;
	}

	
}
