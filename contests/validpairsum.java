// { Driver Code Starts
//Initial Template for Java
// Given an array of distinct elements of size N, find the number of pairs in the array with their sum greater than 0.

// Input:
// First line of input contains number of testcases T. For each testcase, there will be two lines,
// first of which will contain N. Second line contains N space separated integers. 

// Output:
// Print number of valid pairs whose sum is greater that 0.

// Your Task:
// Complete the function ValidPair() that takes array and N as input and returns an integer.

// Constraints: 
// 1 <= T <= 100
// 1 <= N <= 105
// -104 <= A[i] <= 104

// Example:
// Sample Input:
// 2
// 3
// 3 -2 1
// 4
// -1 -1 -1 0

// Sample Output:
// 2
// 0

// Explanation:
// Testcase 1 : There are two pairs of elements in the array whose sum is positive. They are:
// {3, -2} = 1
// {3, 1} = 4


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ;i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int ValidPair(int a[], int n) 
	{ 
	    // code here 
	    Arrays.sort(a);  
      
        // Variable to store the count of pairs 
        int ans = 0; 
      
        // Loop to iterate through the array 
        for (int i = 0; i < n; ++i) { 
      
            // Ignore if the value is negative 
            if (a[i] <= 0) 
                continue; 
      
            // Finding the index using lower_bound 
            // find length of array  
            int len = a.length;  
            int j = lower(a,-a[i]+1); 
            //System.out.print(i+" "+j+"__");
                // Finding the number of pairs between 
            // two indices i and j 
            ans += i - j; 
        } 
        return ans;
	}
	public static int lower(int arr[],int key){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid] >= key){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return high;
    }
} 
