
// Given an array A of N integers. The task is to find a peak element in it in O( log N ) .
// An array element is peak if it is not smaller than its neighbours. For corner elements, we need to consider only one neighbour.
// Note: There may be multiple peak element possible, in that case you may return any valid index.

// Input:
// The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N. Then in the next line are N space separated values of the array.

// Output:
// For each test case output will be 1 if the index returned by the function is an index with peak element.

// User Task:
// You don't have to take any input. Just complete the provided function peakElement() and return the valid index.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 105
// 1 <= A[] <= 106

// Example:
// Input:
// 2
// 3
// 1 2 3
// 2
// 3 4
// Output:
// 1
// 1

// Explanation:
// Testcase 1: In the given array, 3 is the peak element as it is greater than its neighbour.
// Testcase 2: 4 is the peak element as it is greater than its neighbour elements.
// { Driver Code Starts
import java.util.*;
class PeakElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
		
			int A=new Peak().peakElement(a,n);
			int f=0;
			if(n==1)
			f=1;
			else
			if(A==0 && a[0]>=a[1])
			f=1;
			else if(A==n-1 && a[n-1]>=a[n-2])
			f=1;
			else if(a[A] >=a[A+1] && a[A]>= a[A-1])
			f=1;
			else
			f=0;
			System.out.println(f);
		}
	}
}// } Driver Code Ends
/*Complete the function below*/

class Peak
{
	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	static int findPeakUtil(int arr[], int low, int high, int n) 
    { 
        int mid = low + (high - low)/2;
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || 
             arr[mid+1] <= arr[mid])) 
            return mid; 
            
        else if (mid > 0 && arr[mid-1] > arr[mid]) 
            return findPeakUtil(arr, low, (mid -1), n); 
            
        else 
            return findPeakUtil(arr, (mid + 1), high, n); 
    } 
	public int peakElement(int[] arr,int n)
    {
       return findPeakUtil(arr, 0, n-1, n); 
    }
}
