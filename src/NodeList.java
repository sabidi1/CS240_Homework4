//

/**
	An ADT unsorted list implemented
	using singly-linked nodes.

*/

public class NodeList<T> implements ListInterface<T>
{
	Node<T> key;
	
	public NodeList()
	{
		key = null;
	}
	
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		@param item The Object to be added.
	*/
	public void add(T item)
	{	
		int count = 0;
		if (key == null) //No nodes in the list
		{
			Node<T> newNode = new Node<T>(item);		//newNode = item
			key = newNode;
			count++;
		}
		else
		{
			Node<T> newNode = new Node<T>(item);
			Node<T> temp = key;
			
			while(temp.getNextNode() != null) //Iterates until it finds the last node in the list
			{
				temp = temp.getNextNode();
				count++;
			}
			temp.setNext(newNode); //Links the last node to the new node
		}
	}
	
	/**
		Remove an entry from the specified position of the list.
		The list size will be decreased by 1.
		Other item positions below the specified index position will be effected.
		@param position The location of the item to be removed.
		@throws IndexOutOfBoundsException if the specified index is not part of the list.
	*/
	public void remove(int position)
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		@SuppressWarnings("unused")
		Node<T> temp = key;
		
		if (position > getLength() || position < 1) //if position is greater than the number of nodes or less than 1, throw an error
		{
			throw new IndexOutOfBoundsException("That position does not exist on this list!");
		}
		else
		{	
			if (position == 1) //if removing the key node, set the key node equal to the next node
			{
				key = key.getNextNode();
			}
			else
			{
				int count = 1;
				Node<T> temp2 = key;
				while(count != position - 1) //iterate until the node previous the desired node to be removed is found
				{
					temp2 = temp2.getNextNode();
					count++;
				}
				Node<T> previous = temp2;
				temp2 = temp2.getNextNode().getNextNode();
				previous.setNext(temp2); 
			}
		}
	}
	
	/**
		Replaces an entry in the list at the specified position with the specified item.
		@param position The position to replace an item in the list.
		@param item The item to replace it with.
	*/
	public void replace(int position, T item)
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		Node<T> temp = key;
		int count = 1;
		
		while (count < position) //iterate until count equals position
		{
			temp = temp.getNextNode();
			count++;
		}
		temp.setData(item); //replace the data in the node with the desired item
	}
	
	/**
		Returns an item based on the specified position in the list.
		The items in the list will not be effected.
		@param position The location of the item on the list to be returned.
		@return T The item at the specified position in the list.
	*/
	public T view(int position)
	{	
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		Node<T> temp = key;
		int count = 1;
		while (count < position) //iterate until count equals position
		{
			temp = temp.getNextNode();
			count++;
		}
		return temp.getData();
	}
	
	/**
		Removes all items from the list.
	*/
	public void clear()
	{
		key = null;
	}
	
	/**
		Determines whether the received item is in the list.
		@param item The item to see if the list contains.
		@return boolean True if the item is there, false if it is not.
	*/
	public boolean contains(T item)
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		Node<T> temp = key;
		
		if (temp.getData().equals(item)) //The key node must be checked for equality previous moving to the next node
		{
			return true;
		}
		
		while (temp.getNextNode() != null) //iterates through the list and compares the data 
		{
			temp = temp.getNextNode();
			if (temp.getData().equals(item)) //if there the same, the item is in the list
			{
				return true;
			}
		}
		return false; //If the item was never found, it is not in the list
	}
	
	/**
		Determines the length of the list.
		@return int The length of the list.
	*/
	public int getLength()
	{
		int count = 1; //we begin with 1 node, since we start at the key node, which is node 1
		Node<T> temp = key;
		
		if (key == null) //if there are no items, the length is 0
		{
			return 0;
		}
		
		while (temp.getNextNode() != null) //iterates through the list
		{
			temp = temp.getNextNode();
			count++;
		}
		return count;
	}
	
	/**
		Determines if the list is empty.
		@return boolean True if the list is empty, false if it is not.
	*/
	public boolean isEmpty()
	{
		return key == null;
	}
	
	
	/**
		Prints the list out.
	*/
	public void toArray()
	{
		if(isEmpty())
		{
			throw new EmptyListException("Error. The list is empty.");
		}
		if (!isEmpty()) //only print if there is at least one item in the list
		{
		
			Node<T> temp = key;
			System.out.println(temp.getData());
			
			if (key.getNextNode() != null) 
			{
				while(temp.getNextNode() != null);	//iterate through the list
				
				{
					temp = temp.getNextNode();
					System.out.println(temp.getData());
				}
				
			}
		}
		
	}
}
