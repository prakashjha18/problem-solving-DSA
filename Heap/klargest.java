// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i<n; ++i)
                arr[i] = sc.nextInt();
            Solution T = new Solution();
            T.kLargest(arr, n, k);
            t--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java

class Solution
{
//     Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and k, N is the size of the array and K is the largest element to be returned. The second line of each test case contains N input C[i].

// Output:
// Print the k largest element in descending order.

// Your Task:
// You are required to complete the method kLargest() which takes 3 arguments and prints required output in a new line.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ N ≤ 10000
// K ≤ N
// 1 ≤ C[i] ≤ 100000

// Example:
// Input:
// 2
// 5 2
// 12 5 787 1 23
// 7 3
// 1 23 12 9 30 2 50

// Output:
// 787 23
// 50 30 23
    public static void kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pQueue.add(arr[i]);
        }
        for(int i=0;i<k;i++){
            System.out.print(pQueue.poll()+" ");
        }
		System.out.println();
        
    }
}
