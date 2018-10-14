package cheatSheets;

public class Sorting 
{
	/* ===== MERGE SORT O(n log(n)) ===== */
	public static void mergeSort(int[] a)
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}

	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
    	
    	
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
	
    
     /* ===== INSERTION SORT O(n^2) ===== */
    private static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; i++)
        {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
        
	public static void main(String[] args)
	{
		int listLength = 100;
		
		ListGenerator gen = new ListGenerator();
		int[]  mergeList = gen.genRandomList(0, listLength, listLength);
		int[] insertList = new int[mergeList.length];
		ListGenerator.copyToList(mergeList, insertList);
		
		System.out.printf("List Length: %d\n", listLength);
		
		long timeBegin = System.nanoTime();
		mergeSort(mergeList);
		System.out.printf("Merge Sort, %dns\n", (int)(System.nanoTime() - timeBegin));
				
		timeBegin = System.nanoTime();
		insertionSort(insertList);
		System.out.printf("Insertion Sort, %dns\n", (int)(System.nanoTime() - timeBegin));
		
	}
}
