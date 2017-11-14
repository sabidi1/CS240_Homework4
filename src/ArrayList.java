/**
	An ADT unsorted list implemented using a fixed
	sized array of size 10.
..
	@version 1.0 
*/

public class ArrayList<T> implements ListInterface<T>
{
	private final T[] list;
	private int endOfList = 0; //number of items in the list
	
	public ArrayList()
	{
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[10]; //Unchecked cast
		list = tempList;
	}
	
	/**	Add an entry to the end of the list.
		Other item positions will be unaffected.
		@param item The Object to be added.
	*/
	public void add(T item)
	{
		list[endOfList] = item;
		endOfList++;		//	The list size will be increased by 1.
	}
	
	/**
		Remove an entry from the specified position of the list.
		Other item positions below the specified index position will be effected.
		@param position: the location of the item to be removed.
		@throws IndexOutOfBoundsException 
	*/
	public void remove(int position)
	{
		if (position > endOfList || position < 1) //trying to remove something out of bounds
		{
			throw new IndexOutOfBoundsException("That position does not exist ");
		}
		else
		{
			for (int i = position; i < endOfList; i++) //Moves all items down the list starting from position
			{
				list[i-1] = list[i];
			}
			endOfList--;			//	The list size will be decreased by 1.
		}
	}
	
	/**
		Replaces an entry in the list at the specified position with the specified item.
		@param position The position to replace an item in the list.
		@param item The item to replace it with.
	*/
	public void replace(int position, T item)
		{
			list[position - 1] = item;
		}
		
	/**
		Returns an item based on the specified position in the list.
		The items in the list will not be effected.
		@param position The location of the item on the list to be returned.
		@return T The item at the specified position in the list.
	*/
	public T view(int position)
		{
			return list[position - 1];
		}
		
	/**
		Removes all items from the list.
	*/
	public void clear()
	{
		for (int i = 0; i < endOfList; i++)
		{
			list[i] = null;
		}
		endOfList = 0;
	}
	
	/**
		Determines whether the received item is in the list.
		@param item The item to see if the list contains.
		@return boolean True if the item is there, false if it is not.
	*/
	public boolean contains(T item)
	{
		for (int i = 0; i < endOfList; i++)
		{
			if (list[i].equals(item))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
		Determines the length of the list.
		@return int The length of the list.
	*/
	public int getLength()
	{
		return endOfList;
	}
	
	/**
		Determines if the list is empty.
		@return boolean True if the list is empty, false if it is not.
	*/
	public boolean isEmpty()
	{
		return endOfList == 0;
	}
	
	/**
		Prints the list out.
	*/
	public void toArray()
	{
		for (int i = 0; i < endOfList; i++)
		{
			System.out.println(list[i]);
		}
	}
}
