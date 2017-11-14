//

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {
	
	private Node<T> key;
	
	
	public PriorityQueue() {
		key = null;
	}
	
	
	public void add(T newEntry) {
		if (key == null) {		//If there are no nodes, compare nothing		
			Node <T> newNode = new Node<T>(newEntry);
			key = newNode;
			}
		else
		{
			Node<T> newNode = new Node<T>(newEntry);
			if(newNode.compareTo(key) <= 0)	//if new node is smallest
			{
				newNode.setNext(key);	//new node becomes next key node
				key = newNode;
			}
			else
			{
				Node<T> temp = key;
				
				//Iterates until its in the correct order
				while(temp.getNextNode() !=null && newNode.compareTo(temp.getNextNode()) >0)
				{
					temp = temp.getNextNode();
				}
				
				if(temp.getNextNode() == null) {		//end of que = last node ----> to new node
					temp.setNext(newNode);
				}
				else	 {		// if iteration is in between, 
					Node<T> temp2 = temp.getNextNode();
					temp.setNext(newNode);
					newNode.setNext(temp2);		//new node --> to the next one
				}
			}
		}
	}

	public T remove() {
		if (isEmpty())
		{
			System.out.println("Empty, nothing to remove.");
		}
		else
		{
			if(key.getNextNode() == null)	//if only one node, key node is removed
			{
				T temp = key.getData();
				key = null;
				return temp;
			}
			else 		// if theres more than one node
			{
				T data = key.getData();		//get data
				Node <T> temp = key;			//remove key node
				key = key.getNextNode();			//set next node as key node
				temp.setData(null);
				
				return data;
			}
		}
		return null;
	}

	public T peek() {
		
		if(!isEmpty())
		{
			return key.getData();
		}
		return null;
	}

	public boolean isEmpty() {
		return key == null;
	}

	public int getSize() {
		if(!isEmpty()) //not empty
		{
			int numberOfItems = 1;	// One node
			Node<T> currentIndex = key;
			while(currentIndex.getNextNode() !=null) //iterate through each line
			{
				currentIndex = currentIndex.getNextNode();	//current node = next node
				numberOfItems++;							
			}
			return numberOfItems;
		}
	
	}

	@Override
	public void clear() {
		key = null;
	}

}
