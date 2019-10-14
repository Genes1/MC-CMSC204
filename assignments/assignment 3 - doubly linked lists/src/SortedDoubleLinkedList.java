import java.util.Comparator;
import java.util.NoSuchElementException;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private static Comparator comparator;
	
	SortedDoubleLinkedList(Comparator c){
		super();
		comparator = c;
	}
	
	
	
	//These methods are unused as the add() method automatically sorts any added element.
	@Override SortedDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException { throw new UnsupportedOperationException(); }
	@Override SortedDoubleLinkedList<T> addToEnd(T data)   throws UnsupportedOperationException { throw new UnsupportedOperationException(); }
	
	
	
	public SortedDoubleLinkedList<T> add(T data, Comparator<T> comparator){
		it = iterator();
		Node t;
		
		if(size > 0) {
			
			if(size == 1) {
				System.out.println("D0");
				if(comparator.compare(data, firstNode.getData()) <= 0) {
					System.out.println("D0.5");
					t = new Node(data, null, firstNode);
					firstNode.setPrevious(t);
					firstNode = t;
				} else {
					System.out.println("D0.8");
					t = new Node(data, firstNode, null);
					firstNode.setNext(t);
					lastNode = t;
				}
				size++;
				return this;
			}
			
			it.next();
			
			while(it.current != null) {
				
				//Try to find the first node that has data larger or equal to the passed data (we will call this the target node).
				System.out.println(data + " to " + it.current.getData() + " " +  comparator.compare(data, it.current.getData()));
				if(comparator.compare(data, it.current.getData()) <= 0) {
					System.out.println("D1.5");
					//If the target node has a previous node, relink the previous node's reference to the new node.
					if(it.current.hasPrevious()) {
						
						t = new Node(data, it.current.getPrevious(), it.current);
						System.out.println("D");
						it.current.getPrevious().setNext(t);
						size++;
						
					} else {
						
						//If it doesn't, make the new node and set it as the first.
						System.out.println("D2");
						t = new Node(data, null, it.current);
						firstNode = t;
						size++;
						
					}
					
					//Regardless, the spot before the target node will be set to the new node.
					it.current.setPrevious(t);
					size++;
					return this;
					
				}
				
				//If the iterator gets to the last node (so no data smaller is found), the element belongs at the back.
				if(/*it.current.equals(lastNode)*/ !it.hasNext()) {
					
					Node temp = new Node(data, lastNode, null);
					System.out.println("D3");
					lastNode.setNext(temp);
					lastNode = temp;
					size++;
					return this;
					
				}
				
				it.next();
				
			}
			

			
		} else {
			
			//If the first node is null, the list is null.
			System.out.println("D4");
			firstNode = new Node(data);
			lastNode = firstNode;
			size++;
			return this;
		}
		

		
		System.out.println("D5");
		size++;
		return this;
	}
	
	
	
	@Override
	SortedDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		
		it = iterator();
		
		while(it.current != null){
			if(comparator.compare(it.current.getData(), targetData) == 0) {
				System.out.println(it.current.getData() + " to " + targetData + " " +  comparator.compare(it.current.getData(), targetData));
				Node found = it.current;
				
				//If the node to be removed has a previous and a next node, they need to be linked together.
				if(found.hasPrevious() && found.hasNext()) {
					found.getPrevious().setNext(found.getNext());
					found.getNext().setNext(found.getNext());
				} else if(found.hasPrevious()) {
					//Otherwise, if it is the last node, the 'next' reference of the previous node is tossed and that node is set to last.
					found.getPrevious().setNext(null);
					lastNode = found.getPrevious();
				} else if(found.hasNext()) {
					//Otherwise still, if it is the first node, do the same but with 'previous' of next and set to first.
					found.getNext().setPrevious(null);
					firstNode = found.getNext();
				} else {
					//If none of these conditions were met, it is the only element in the list.
					firstNode = null;
					lastNode = null;
				}
						
				//it.remove();
				size -= 1;
				return this;
				
			}
			

			
		}
		
		throw new NoSuchElementException();
		
		
	}
	
}
