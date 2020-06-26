// { Driver Code Starts
//Initial Template for Java
// Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are 
// said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be 
// different though.
// Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

// Input Format:
// The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  
// Each test case contains 3 lines of input. The first line contains an integer N denoting the size of the array. 
// The second line contains element of array A[]. The third line contains elements of the array B[].

// Output Format:
// For each testcase in a new line print 1 if the arrays are equal else print 0.

// Your Task:
// Complete check function which takes both the given array and their size as function arguments and returns true 
// if the arrays are equal else returns false.The 0 and 1 printing is done by the driver code.

// Constraints:
// 1<=T<=100
// 1<=N<=107
// 1<=A[],B[]<=1018

// Expected Time Complexity : O(N)
// Expected Auxilliary Space : O(N)

// Example:
// Input:
// 2
// 5
// 1 2 5 4 0
// 2 4 5 0 1
// 3
// 1 2 5
// 2 4 15

// Output:
// 1
// 0

/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		long t=sc.nextLong();
		
		while(t-->0)
		{
		  int n=sc.nextInt();
		  long a[]=new long[n];
		  long b[]=new long[n];
		  
		  for(int i=0;i<n;i++)
		  {
		      a[i]=sc.nextLong();
		  }
		  
		  for(int i=0;i<n;i++)
		  {
		      b[i]=sc.nextLong();
		  }
		  
		  System.out.println(check(a,b,n)==true?"1":"0");
		  
		  
		}
	}

 // } Driver Code Ends


//User function Template for Java


public static boolean check(long arr1[],long arr2[],int n1)
{
    //Your code here
        int n = arr1.length; 
        int m = arr2.length; 
  
        // If lengths of arrays are not equal 
        if (n != m) 
            return false; 
  
        // Store arr1[] elements and their counts in 
        // hash map 
        HashMap<Long, Long> map = new HashMap<>(); 
        long count = 0; 
        for (int i = 0; i < n; i++) { 
            if (map.get(arr1[i]) == null) 
                map.put(arr1[i], (long)1); 
            else { 
                count = map.get(arr1[i]); 
                count++; 
                map.put(arr1[i], count); 
            } 
        } 
  
        // Traverse arr2[] elements and check if all 
        // elements of arr2[] are present same number 
        // of times or not. 
        for (int i = 0; i < n; i++) { 
            // If there is an element in arr2[], but 
            // not in arr1[] 
            if (!map.containsKey(arr2[i])) 
                return false; 
  
            // If an element of arr2[] appears more 
            // times than it appears in arr1[] 
            if (map.get(arr2[i]) == 0) 
                return false; 
  
            count = map.get(arr2[i]); 
            --count; 
            map.put(arr2[i], count); 
        } 
        return true;
}

// { Driver Code Starts.
	    



}  // } Driver Code Ends
