// Java implementation of the approach 
public class GFG { 

	// Function to print the required numbers 
	static void findNumbers(int arr[], int n) 
	{ 

		// Sum of first n natural numbers 
		int sumN = (n * (n + 1)) / 2; 

		// Sum of squares of first n natural numbers 
		int sumSqN = (n * (n + 1) * (2 * n + 1)) / 6; 

		// To store the sum and sum of squares 
		// of the array elements 
		int sum = 0, sumSq = 0, i; 

		for (i = 0; i < n; i++) { 
			sum += arr[i]; 
			sumSq += Math.pow(arr[i], 2); 
		} 

		int B = (((sumSq - sumSqN) / (sum - sumN)) + sumN - sum) / 2; 
		int A = sum - sumN + B; 
		System.out.println("A = " + A + "\nB = " + B); 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int arr[] = { 1, 2, 2, 3, 4 }; 
		int n = arr.length; 

		findNumbers(arr, n); 
	} 
} 
