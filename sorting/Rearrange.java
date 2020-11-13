//Rearrange array in alternating positive & negative items with O(1) extra space 
// Input:  arr[] = {1, 2, 3, -4, -1, 4}
// Output: arr[] = {-4, 1, -1, 2, 3, 4}

// Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
// output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 
class RearrangeArray 
{ 
	void rightrotate(int arr[], int n, int outofplace, int cur) 
	{ 
		int tmp = arr[cur]; 
		for (int i = cur; i > outofplace; i--) 
			arr[i] = arr[i - 1]; 
		arr[outofplace] = tmp; 
	} 

	void rearrange(int arr[], int n) 
	{ 
		int outofplace = -1; 

		for (int index = 0; index < n; index++) 
		{ 
			if (outofplace >= 0) 
			{ 
				if (((arr[index] >= 0) && (arr[outofplace] < 0)) 
						|| ((arr[index] < 0) && (arr[outofplace] >= 0))) 
				{ 
					rightrotate(arr, n, outofplace, index); 

					// the new out-of-place entry is now 2 steps ahead 
					if (index - outofplace > 2) 
						outofplace = outofplace + 2; 
					else
						outofplace = -1; 
				} 
			} 

			// if no entry has been flagged out-of-place 
			if (outofplace == -1) 
			{ 
				// check if current entry is out-of-place 
				if (((arr[index] >= 0) && ((index % 2)==0)) 
						|| ((arr[index] < 0) && (index % 2)==1)) 
					outofplace = index; 
			} 
		} 
	} 

	// A utility function to print an array 'arr[]' of size 'n' 
	void printArray(int arr[], int n) 
	{ 
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println(""); 
	} 

	public static void main(String[] args) 
	{ 
		RearrangeArray rearrange = new RearrangeArray(); 
		//int arr[n] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}; 
		//int arr[] = {-5, -3, -4, -5, -6, 2 , 8, 9, 1 , 4}; 
		//int arr[] = {5, 3, 4, 2, 1, -2 , -8, -9, -1 , -4}; 
		//int arr[] = {-5, 3, -4, -7, -1, -2 , -8, -9, 1 , -4}; 
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; 
		int n = arr.length; 

		System.out.println("Given array is "); 
		rearrange.printArray(arr, n); 

		rearrange.rearrange(arr, n); 

		System.out.println("RearrangeD array is "); 
		rearrange.printArray(arr, n); 
	} 
} 

//Method 2
import java.util.Arrays;

class Main
{
	// Partitioning routine of quicksort
	public static int partition(int[] A)
	{
		int j = 0;
		int pivot = 0;	// consider 0 as pivot

		// each time we find a negative number, j is incremented
		// and negative element would be placed before the pivot
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] < pivot)
			{
				// swap A[i] with A[j]
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;

				j++;
			}
		}

		// j holds index of first positive element
		return j;
	}

	// Function to rearrange given array such that it contains positive
	// and negative numbers at alternate positions
	public static void rearrange(int[] A)
	{
		// partition given array such that all positive elements move
		// to end of the array
		int p = partition(A);

		// swap alternate negative element from next available positive
		// element till end of array is reached or all negative or
		// positive elements are exhausted.
		for (int n = 0; (p < A.length && n < p); p++, n += 2) {
			// swap A[n] with A[p]
			int temp = A[n];
			A[n] = A[p];
			A[p] = temp;
		}
	}

	public static void main(String[] args)
	{
		int[] A = { 9, -3, 5, -2, -8, -6, 1, 3 };

		rearrange(A);

		// print the rearranged array
		System.out.println(Arrays.toString(A));
	}
}
