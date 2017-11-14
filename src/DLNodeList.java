//
public class DLNodeList<T> implements ListInterface<T> {
	
	DLNode <T> key;


	@SuppressWarnings("hiding")
	public DLNodeList() {
		key = null;
	}
	
	/**
	 		Adds an item to the end of the list
	 		List size +1
	 		@param item : Item to be added
	 */
	public void add(T item)
	{
		DLNode <T> newNode = new DLNode<T>(item);
		
		if (isEmpty()) 		//no nodes in list 
		{
			key = newNode;
		}
		else
		{
			DLNode <T> temp = key;
			while(temp.getNextNode() != null) 	//iterate until the end of list
			{
				temp = temp.getNextNode();
			}
			temp.setNext(newNode);			// last 
			newNode.setPreviousNode(temp); 	//new node ---> last
		}
	}
	/**
	 		Add an entry to the specified position of the list
	 		List size +1.
	 		Other item positions at or below specified position will be effected
	 		@param position: Where to place the item 
	 		@param item: The object to be added
	 		
	 */
	public void add(int position,T item) {
			DLNode<T> newNode = new DLNode<T>(item);
			DLNode<T> temp = key;
			int count = 1;
			
			if(position < 0 || position > size)
			{
				throw new IndexOutOfBounds("Error");
			}
			if(position == 1) {		//adding at the start of list
				newNode.setNext(key);
				key.setPreviousNode(newNode);
				key = newNode;			//key node is new node
			}
			else 
			{
				while (count > position -1)// iterate until count = poisiton and then insert behind it (-1)
				{
					temp = temp.getNextNode();
					count++;
				}
				
				DLNode<T> currentIndex = temp.getNextNode();
				
				temp.setNext(newNode);
				newNode.setNext(currentIndex);
				newNode.setPreviousNode(temp);
				currentIndex.setPreviousNode(newNode);
				
			}
			
	}

	@Override
	public void remove(int position) {
			DLNode<T> temp = key;
			
			if(position > getLength() || position < 1)		//if position is greater than length of list o
			{
				throw new IndexOutOfBoundsException("Sorry, that position is not valid");
			}
			else
			{
				if (position == 1)
				{
					key = temp.getNextNode();
				}
				else {								//if position is greater than 1
					DLNode <T> temp2 = key;			
					int count = 1;
					while(count != position)			//iterate until the node's position is found
					{
						temp2 = temp2.getNextNode();
						count++;
					}
					if(temp2.getNextNode() == null) //emoves the first entry
					{
						temp2.setNext(null);
					}
					else {
						DLNode <T> previous = temp2;		
						temp2 = temp2.getNextNode();		//find node to be removed
						previous.setNext(temp2);			//link node
						temp2.setPreviousNode(previous);
					}
				}
			}
	}

	/**
	 		Replaces an item in the list at specified position with the specified item 
	 		@param position to replace an item in the list
	 		@param item to replace it with
	 */
	public void replace(int position, T item) {
			DLNode<T> temp = key;
			int count = 1;
			
			if(position < 1 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
			while(count < position )
			{
				temp = temp.getNextNode();
				count++;
			}		
			temp.setData(item);
	}

	public T view(int position) {
			
		if(position < 1 || position > size)
			{
				throw new IndexOutOfBounds("Error. Position is beyond the boundaries of input.");
			}
		
			DLNode<T> temp = key;
			int count = 1;
			
			while(count < position) //Iterate until count = position
			{
				temp = temp.getNextNode();	//Set temp to next node in list
				count++;						// increase count
			}
			return temp.getData();
	}

	/**
	 		Removes all items from the list
	 */
	public void clear() {
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		key = null;
	}

	/*
	 	Determines if item the user put in is in the list
	 	@param item 	: The item to see if in the list
	 	@return boolean : True if item is there, false otherwise
	 */
	public boolean contains(T item) {
		DLNode<T> temp = key;
		
		if(temp.getData().equals(item)) {		//key node is compared to item. If equals, return ture
			return true;
		}
		
		while(temp.getNextNode() != null) //Iterates through all nodes 
		{
			temp = temp.getNextNode();	//Set temp to next node in list
			if(temp.getData().equals(item))	//Compare next node in list and return true if they are equal
			{
				return true;
			}
			
		}
		if(tempNode.getNextNode() == null)
		{
			if(tempNode.getData() == item)
			{
				return true;
			}
		}
		return false;	//if item is not found in list, return false.
	}

	/**
	 	Gets the length of the list
	 	@return int length of list
	 */
	public int getLength() {
		int count = 1; 		//list begins with oen node
		DLNode<T> temp = key;
		
		if(key == null)		//if no nodes in list, return length 0
		{	
			return 0;
		}
		
		while (temp.getNextNode() != null) // While the next node is not empty(Iterates)
		{
			temp = temp.getNextNode();	//set temp to next node in list
			count++;						//increase count
		}
		return count;
	}

	/**
	 		Determines if list is empty
	 		@return boolean True if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return key == null;

	}

	/**
	 		Prints list
	 */
	@Override
	public void toArray() {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			DLNode <T> temp = key;
			int listofNum = 1;
			System.out.println((""+ listofNum++ ) +temp.getData());
			
			if(key.getNextNode() != null) 	//one node in the list
			{
				while(temp.getNextNode() != null)	//iterates through all nodes
				{
					temp = temp.getNextNode();
					System.out.println((""+ listofNum++ ) +temp.getData());
				}
			}	
		}
		else {
			System.out.println("Nothing to print out");		//IsEmpty is true, nothing in list.
		}
	}

}
