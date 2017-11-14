public class SingleSortedList<T extends Comparable<T>> extends NodeList<T> implements SortedListInterfacee<T>
{
	/**	Add an entry to the end of the list.
		
		@param item The Object to be added.
	*/
	public void add(T item)
	{
		if (key == null) //If there are no nodes, nothing needs to be compared.
		{
			Node<T> newNode = new Node<T>(item);
			key = newNode;
		}
		else			//if there are nodes
		{
			Node<T> newNode = new Node<T>(item);
			
			if (newNode.compareTo(key) <= 0) //Compare new node to key. If the new node is smallest 
			{
				newNode.setNext(key);		//becomes the new key node
				key = newNode;				//key 
			}
			else
			{
				Node<T> temp = key;
				
				//iterates until it is in the correct sorted positon
				////or the end of the nodes has been reached
				while (temp.getNextNode() != null && newNode.compareTo(temp.getNextNode()) > 0) 
				{																		
					temp = temp.getNextNode();
				}
				
				if (temp.getNextNode() == null) //if adding at the end of the que
				{
					temp.setNext(newNode);	 //link the last node to the new node
				}
				else //if its between nodes  and the the new node to the one after it
				{
					Node<T> temp2 = temp.getNextNode();
					temp.setNext(newNode);		//link the one before it to the new node
					newNode.setNext(temp2);		//new node to the one after it
				}
			}
		}
	}
}
