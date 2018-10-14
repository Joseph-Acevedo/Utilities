package cheatSheets;

public class ElementInsert 
{
	
	private static void insertElement(char[] array, int position, char element)
	{
		char[] aCopy = new char[array.length];
		
		for(int i = 0; i < position; i++) {
			aCopy[i] = array[i];
		}
		
		aCopy[position] = element;
		
		for(int i = position + 1; i < array.length; i++) {
			aCopy[i] = array[i-1];
			array[i-1] = aCopy[i-1];
		}
		array[array.length - 1] = aCopy[array.length - 1];
	}
	
	public static void main(String[] args)
	{
		char[] test = {'a', 'b', 'c', 'd', 'e', 'f', ' ', ' '};
		
		insertElement(test, 6, 'g');
		
		for(int i = 0; i < test.length; i++)
			System.out.print(test[i] + " ");
	}

}
