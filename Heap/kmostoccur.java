// { Driver Code Starts
// Given an array arr[] of N integers in which elements may be repeating several times. Also, 
// a positive number K is given and the task is to find sum of total frequencies of K most occurring elements

// Note: The value of K is guaranteed to be less than or equal to the number of distinct elements in arr.

// Input:
// First line of input contains number of testcases T. For each testcase, first line of input 
// contains the size of array N, and next line contains N positive integers. The last line contains K.

// Output:
// For each testcase, print the sum of total frequencies of K most occurring elements in the given array.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 107
// 1 <= K <= N
// 1 <= arr[i] <= 106

// Expected Time Complexity : O(N)

// Example:
// Input:
// 2
// 8
// 3 1 4 4 5 2 6 1
// 2
// 8
// 3 3 3 4 1 1 6 1
// 2

// Output:
// 4
// 6

// Explanation:
// Testcase 1: Since, 4 and 1 are 2 most occurring elements in the array with their frequencies as 2, 2. So total frequency is 2 + 2 = 4.

// Testcase 2: Since, 3 and 1 are most occurring elements in the array with frequencies 3, 3 respectively. So, total frequency is 6.
import java.io.*;
import java.util.*;
import java.lang.*;

class GfG {
    
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    inputLine = br.readLine().trim().split(" ");
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    int k = Integer.parseInt(br.readLine().trim());
		    new solve().kMostOccuring(arr, n, k);
		}
	}
}// } Driver Code Ends


class solve{
    void kMostOccuring(int arr[], int n6, int k){
        // your code here
        int max =0,val=0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int n: arr) {
            h.put(n, h.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> en : h.entrySet())
            pq.add(en.getValue());
        while(k-->0)
            val = val + pq.poll();
        System.out.println(val+" ");
    }
}
