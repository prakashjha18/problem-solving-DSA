// Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.
// Examples:

// Input: a[] = {8, -8, 9, -9, 10, -11, 12}
// Output: 22 (12 + 8 - 8 + 9 - 9 + 10)

// Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
// Output:  23 (7 + 6 + 5 - 4 -1 + 10) 

// Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
// Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)

// { Driver Code Starts
import java.io.*;
import java.util.*;

class maxcircularsubarray {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Kadane obj = new Kadane();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends
class Kadane{
    
    // Function to find circular subarray with maximum sum
    // a: input array
    // n: size of array
    public static int kadane(int[] A)
    {
    	int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < A.length; i++)
		{
		    max_ending_here = max_ending_here + A[i];

			// if maximum sum is negative, set it to 0 (which represents
			// an empty sub-array)
			max_ending_here = Integer.max(max_ending_here, 0);

			// update result if current sub-array sum is found to be greater
			max_so_far = Integer.max(max_so_far, max_ending_here);
		}
		return max_so_far;
    }
    static int circularSubarraySum(int a[], int n) {
        for(int i=0;i<n;i++)
            a[i]=-a[i];
            
        int negsum = kadane(a);
        
        for(int i=0;i<n;i++)
            a[i]=-a[i];
            
        return Integer.max(kadane(a), Arrays.stream(a).sum() + negsum);
       
    }
    
    
}

