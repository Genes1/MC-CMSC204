
/**
 * 
 * @author Eugene Domrachev
 * 
 * This class provides a structure to organize recipients in queue form.
 *
 */

public class RecipientLine implements RecipientLineInterface {
	
	MyQueue<Recipient> recipients;

	
	/**
	 * Provide two constructors:
	 * RecipientLine(int size) make internal queue this size
	 * RecipientLine() make internal queue default aize
	 */
	
	RecipientLine(int size){
		recipients = new MyQueue(size);
	}
	
	RecipientLine(){
		recipients = new MyQueue(5);
	}
	
	
	
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 * @return true if recipient is queued successfully
	 * @throw RecipientException("The Recipent Queue is Full") if queue is full
	 */
	public boolean addNewRecipient(Recipient rc) throws RecipientException {
		
		if(!recipients.isFull()) {
			return recipients.enqueue(rc);
		}
		
		throw new RecipientException("The Recipent Queue is Full");
		
	}
	 
	
	
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throw RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	
	public Recipient recipientTurn() throws RecipientException {
		
		if(!recipients.isEmpty()) {
			return recipients.dequeue();
		}
		
		throw new RecipientException("The Recipient Queue is empty");
		
	}
	
	
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean recipientLineEmpty() { return recipients.isEmpty(); }
	 
	/**
	 * Returns an array of the Recipients in the queue
	 * @return an array of the Recipients in the queue
	 */
	public Recipient[] toArrayRecipient() { 
		
		Object[] t = recipients.toArray();
		Recipient[] temp = new Recipient[t.length];
		for ( int i= 0 ; i< t.length; i++)
			temp[i] = (Recipient) t[i];
		return temp;
		
	}
	 

}
