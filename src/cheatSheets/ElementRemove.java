package cheatSheets;

public class ElementRemove 
{
	private static void removeSingleElement(char[] array, int position)
	{
		for(int i = position; i < array.length - 1; i++)
		{
			array[i] = array[i+1];
		}
		array[array.length - 1] = '\b';
	}
	
	
	private static void removeAllElement(char[] array, char element)
	{
		for(int i = 0; i < array.length; i++)
		{
			while(array[i] == element)
				removeSingleElement(array, i);
		}
	}
	
	
	public static void main(String[] args)
	{
		//int[] test = {0, 1, 2, 3, 4, 5, 6};
		char[] test = {'a', 'a', 'a', 'a', 'e', 'f'};
		
		removeAllElement(test, 'a');
		for(int i = 0; i < test.length; i++)
			System.out.print(test[i] + " ");
	}
}
