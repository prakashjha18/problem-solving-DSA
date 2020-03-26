//         Given K sorted lists of integers of size N each, find the smallest range that includes at least one element from each of the K lists. If more than one such range's are found, print the first such range found.

// Input:
// The first line of the input contains a single integer T denoting the number of test cases. For each test, inputs will be given to the findSmallestRange function. The input's to the function are:
// 1.) A 2D-array(arr) of size K*N, where each row represents an individual list.
// 2.) An integer N denoting the size of the list.
// 3.) An integer K denoting the number of lists.

// Output:
// For each test case output in a single line with two space-separated integers denoting the required range.

// Constraints:
// 1 <= T <= 50
// 1 <= K,N <= 500

// Example:
// Input:
// 2
// 5 3
// 1 3 5 7 9
// 0 2 4 6 8
// 2 3 5 7 11
// 4 3
// 1 2 3 4
// 5 6 7 8
// 9 10 11 12

// Output:
// 1 2
// 4 9
// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class smallestrangeinklist
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       new smallestRangeFromKLists().findSmallestRange(arr, n, k);
	       System.out.println();
	   }
	}
}
// } Driver Code Ends
class smallestRangeFromKLists
{
	static void findSmallestRange(int[][] arr,int n,int k)
	{
        int ptr[] = new int[501]; 
        int i, minval, maxval, minrange, minel = 0, maxel = 0, flag, minind; 
        for (i = 0; i <= k; i++) { 
            ptr[i] = 0; 
        } 
        minrange = Integer.MAX_VALUE; 
        while (true) { 
            minind = -1; 
            minval = Integer.MAX_VALUE; 
            maxval = Integer.MIN_VALUE; 
            flag = 0; 
            for (i = 0; i < k; i++) { 
                if (ptr[i] == n) { 
                    flag = 1; 
                    break; 
                } 
                if (ptr[i] < n && arr[i][ptr[i]] < minval) { 
                    minind = i; // update the index of the list 
                    minval = arr[i][ptr[i]]; 
                } 
                if (ptr[i] < n && arr[i][ptr[i]] > maxval) { 
                    maxval = arr[i][ptr[i]]; 
                } 
                System.out.println(minval+"_____"+maxval);
            } 
            if (flag == 1) { 
                break; 
            } 
            ptr[minind]++; 
            if ((maxval - minval) < minrange) { 
                minel = minval; 
                maxel = maxval; 
                minrange = maxel - minel; 
            } 
        } 
        System.out.print(minel+" " + maxel); 
	}
}
