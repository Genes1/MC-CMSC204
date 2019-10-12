import java.util.Comparator;


public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	
	private static Comparator comparator;
	
	SortedDoubleLinkedList(Comparator c){
		super();
		comparator = c;
	}
	
	
	
	//These methods are unused as the add() method automatically sorts any added element.
	@Override BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException { throw new UnsupportedOperationException(); }
	@Override BasicDoubleLinkedList<T> addToEnd(T data)   throws UnsupportedOperationException { throw new UnsupportedOperationException(); }
	
	
	
	public SortedDoubleLinkedList<T> add(T data, Comparator<T> comparator){
		it = iterator();
		Node t;
		
		if(firstNode != null && lastNode != null) {
			while(it.hasNext()) {
				
				//Try to find the first node that has data larger or equal to the passed data (we will call this the target node).
				if(comparator.compare(data, it.next()) <= 0) {
					
					//If the target node has a previous node, relink the previous node's reference to the new node.
					if(it.current.hasPrevious()) {
						t = new Node(data, it.current.getPrevious(), it.current);
						it.current.getPrevious().setNext(t);
					} else {
						//If it doesn't, make the new node and set it as the first.
						t = new Node(data, null, it.current);
						firstNode = t;
					}
					
					//Regardless, the spot before the target node will be set to the new node.
					it.current.setPrevious(t);
					return this;
					
				}
				
				
			}
			
			//If the iterator gets to the last node (so no data smaller is found), the element belongs at the back.
			if(it.current.equals(lastNode)) {
				it.current.setNext(new Node(data, it.current, null));
				firstNode = it.current.getPrevious();
			}
			
		} else {
			//If the first node is null, the list is null.
			firstNode = new Node(data);
			lastNode = firstNode;
		}
		
		return this;
	}
	
	
	
	@Override
	BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		
		it = iterator();
		
		while(it.hasNext()){
			if(comparator.compare(it.next(), targetData) == 0) {
				
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
				}
						
				it.remove();
				break;
			}
		}
		
		size -= 1;
		
		return this;
		
	}
	
}
