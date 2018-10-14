package cheatSheets;

public class Search 
{
	private int[] searchList;
	private int   searchNum;
	
	/**
	 * @param list The list to search through
	 * @param val The number to search for in the list
	 */
	public Search(int[] list, int val)
	{
		searchNum  = val;
		searchList = new int[list.length];
		
		for(int i = 0; i < list.length; i++)
			searchList[i] = list[i];
	}
	
	
	/**
	 * Searches linearly through any list for the specified number
	 * @return the index of the number, -1 if not present
	 */
	public int linearSearch()
	{
		for(int i = 0; i < searchList.length; i++)
		{
			if(searchList[i] == searchNum)
				return i;
		}
		return -1;
	}
	
	/**
	 * Given an ordered list, efficiently searches for a given number's position
	 * @param start The starting index of the range to look at
	 * @param end The ending index of the range to look at
	 * @return the index of the number, -1 if not present
	 */
	public int orderedSearch(int start, int end)
	{
		if(searchNum > end || searchNum < start)
			return -1;
		// looking at the middle index ((end-start) / 2)
		int middlePos = (end - start) / 2 + start;
		
		if(searchList[middlePos] == searchNum)
			return middlePos;
		else {
			if(searchList[middlePos] < searchNum) 
				return orderedSearch(middlePos + 1, end);
			else if(searchList[middlePos] > searchNum) 
				return orderedSearch(start, middlePos - 1);
		}
		return -1;
	}
	
	
	public static void main(String[] args)
	{
		int listMin = 0;
		int listRange = 200000000;
		int listLength = 10;
		
		ListGenerator listGen = new ListGenerator();
		listGen.genOrderedList(listMin, listRange);
		//listGen.printList();
		Search search = new Search(listGen.getList(),listRange - 1);
		System.out.println(listGen.getList().length + " ordered elements in the array");
		long tStart = System.currentTimeMillis();
		System.out.print("Linear Search: " + search.linearSearch());
		System.out.println(" " + (System.currentTimeMillis() - tStart) + "ms");
		tStart = System.currentTimeMillis();
		System.out.print("Ordered Search: " + search.orderedSearch(0, listRange - 1));
		System.out.println(" " + (System.currentTimeMillis() - tStart) + "ms");

	}
	
	
}
