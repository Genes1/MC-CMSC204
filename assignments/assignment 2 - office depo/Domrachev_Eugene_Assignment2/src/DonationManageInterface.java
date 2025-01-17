
/**
 * DonationManagerInterface class simulates the operation of adding a new package to the container stack, adding a new volunteer to the
 * volunteer line, adding a new recipient to the recipient line and donating a package from the container by the volunteer to the recipient.
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public interface DonationManageInterface {
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage Donation package that is stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throw ContainerException if container is full
	 */
	public boolean   ManagerLoadcontainer(DonationPackage dPackage) throws ContainerException;
	 
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throw VolunteerException("Volunteer Line is full") if the Volunteer Line queue is full
	 */
	public  boolean  ManagerQueueVolunteer(Volunteer  v) throws VolunteerException;
	 
	/**
	 * adds a new Recipient to the queue of the Recipient line
	 * @param r a Recipient
	 * @return true if recipient is queued successfully , false if queue is full
	 * @throw RecipientException("Recipient Line is full") if the Recipient line is full
	 */
	public boolean ManagerQueueRecipient(Recipient r) throws RecipientException ;


	/**
	 * Simulates donating a DonationPackage from the container stack by the volunteer from the volunteer queue line to the 
	 * recipients from the recipients queue line. As a result the package is removed from the container, volunteer will be dequeued
	 * from  volunteer line and QUEUED BACK to the volunteer line and recipient will be dequeued from the recipient line.
	 * @throw VolunteerException("Volunteer Queue is empty") if there are no volunteers
	 * @throw ContainerExcpetion("Contain is empty") if the container is empty
	 * @throw RecipientException("Recipient Queue is empty") if there are no recipients
	 * 
	 */
	public  int donatePackage() throws VolunteerException, ContainerException, RecipientException;
}
