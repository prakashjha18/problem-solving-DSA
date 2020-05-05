// There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N where N is the number of ropes. The second line of each test case contains N input L[i],length of ropes.

// Output:
// For each testcase, print the minimum cost to connect all the ropes.

// Your Task:
// You are required to complete the method minCost() which takes 2 arguments and returns the minimum cost.

// Constraints:
// 1 ≤ T ≤ 10
// 1 ≤ N ≤ 100000
// 1 ≤ L[i] ≤ 106

// Example:
// Input:
// 2
// 4
// 4 3 2 6
// 5
// 4 2 7 6 9

// Output:
// 29
// 62

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class minimumcostofropes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long arr[] = new long[n];

            for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

            new solve().minCost(arr, n);
        }
    }
}
// } Driver Code Ends


class solve {

    void minCost(long arr[], int n) {
        // your code here
        PriorityQueue<Long> pQueue = new PriorityQueue<Long>(); 
        for(int i=0;i<arr.length;i++){
            pQueue.add(arr[i]);
        }
        long sum=0;
        //System.out.print(pQueue.size());
        while(pQueue.size()>1){
            long x = pQueue.poll();
            long y = pQueue.poll();
            //System.out.print(x+y+" ");
            sum+=(x+y);
            pQueue.add(x+y);
        }
        System.out.println(sum);
    }
}
