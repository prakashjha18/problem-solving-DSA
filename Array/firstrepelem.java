// { Driver Code Starts
//Initial Template for Java
Given an array arr[] of size N. The task is to find the first repeating element in an array of integers, i.e., an element that occurs more than once and whose index of first occurrence is smallest.

Input :
The first line contains an integer T denoting the total number of test cases. In each test cases, First line is number of elements in array N and second its values.

Output:
Complete firstRepeated function and return the index of first repeated element, if there is not any repeating element then return “-1” (without quotes). Use 1 Based Indexing.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 106

Expected Time Complexity : O(NlogN)
Expected Auxilliary Space : O(N)

Example:

Input:
3
7
1 5 3 4 3 5 6
4
1 2 3 4
5
1 2 2 1 3

Output:
2
-1
1

Explanation: 
Testcase 1: 5 is appearing twice and its first appearence is at index 2 which is less than 3 whose first occuring index is 3.
Testcase 2: All elements appear only once so -1 is printed.
Tescase 3:  The element 1 appears more than 1 times and is the first element to do so. So, we print its index 1.

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    
		    System.out.println(firstRepeated(arr,n));
		}
		
	}
	

 // } Driver Code Ends


//User function Template for Java


public static int firstRepeated(int []arr, int n) 
{
    //Your code here
    int min = -1; 
  
        // Creates an empty hashset 
        HashSet<Integer> set = new HashSet<>(); 
        //int i=0;
        // Traverse the input array from right to left 
        for (int i=arr.length-1; i>=0; i--) 
        { 
            // If element is already in hash set, update min 
            if (set.contains(arr[i])) 
                min = i; 
  
            else   // Else add element to hash set 
                set.add(arr[i]); 
        } 
  
        // Print the result 
        if (min != -1) 
            return min+1;
        else
            return -1;
}


// { Driver Code Starts.

}  // } Driver Code Ends
