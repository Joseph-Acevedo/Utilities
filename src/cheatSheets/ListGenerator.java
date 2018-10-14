package cheatSheets;

public class ListGenerator 
{
	private int   listLength;
	private int   numRange;
	private int   minVal;
	private int[] list;
	
	private boolean debug = false;

	
	//TODO: Make an ordered list generator and a seeded one
	
	public int[] genOrderedList(int minValue, int range)
	{
		list = new int[range];
		listLength = range;
		numRange = range;
		minVal = minValue;
		for(int i = 0; i < range; i++)
			list[i] = i + minVal;
		
		return list;
	}
	
	
	public int[] genRandomList(int minValue, int range, int length)
	{
		numRange = range;
		minVal = minValue;
		listLength = length;
		list = new int[length];
		
		for(int i = 0; i < listLength; i++)
		{
			list[i] = (int) (Math.random() * (numRange)) + (minVal);
		}
		return list;
	}
	
	public int[] getList()
	{
		return list;
	}
	
	
	public static void printList(int[] list, String name)
	{
		System.out.print(name + "\t {");
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + ", ");
		System.out.println("}");
	}
	
	
	/**
	 * Copies a list to another
	 * @param original The list to copy from
	 * @param copy The list to copy to
	 * @return true if the copy was a success, false otherwise
	 */
	public static boolean copyToList(int[] original, int[] copy)
	{
		if(original.length != copy.length)
			return false;
		
		for(int i = 0; i < copy.length; i++)
			copy[i] = original[i];
		
		return true;
	}
	
}
