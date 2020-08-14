// { Driver Code Starts
//Initial Template for Java
/*
You are given an array of integers. You have to start from the first index and reach the end. 
The only steps you can take are +3 or -1. Cost of a path is equal to the sum of all integers in the path. 
Find the cost of the lowest cost path. If no path is possible, print -1.

Input: First line of input contains number of test cases T. Then T test cases follow. In each test case,
first line contains n, i.e., number of integers in the array a[ ]. Second line of each test case contains

n space separated integers of the array. Input will be read by driver code.

Output: Output for every test case is the minimum cost to travel from start of array to end.

Your Task: Your task is to complete the function min_cost(). This function takes array a[ ] and its 
length n as argumments and returns the cost of most optimal path. Returned value will be automatically 
printed by driver code.

Constraints: T<=100 ; 4 <= n <= 105 ; 1 <= a[i] <= 103

Example:

Input :
2
8
3 1 2 5 10 100 200 20
6
4 3 2 1 5 6

Output:
41
13

Explanation:

Testcase 1 : Most optimised path is 3 -> 5 -> 2 -> 1 -> 10 -> 20. Sum of elements in this path is 41.

Testcase 2 : Most optimised path is 4 -> 1 -> 2 -> 6. Cost of path is 13.

*/
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0)
                {
                    int ans;
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    for(int i=0;i<n;i++)
                        arr[i] = sc.nextInt();
                    Minimum g = new Minimum();
                    ans = g.min_cost(arr,n);
                    System.out.println(ans);
                    t--;
                }
        }
        
}// } Driver Code Ends


//User function Template for Java

class Minimum
{
    public int min_cost(int[] arr , int n)
        {
            //code here.
            int[] dp =  new int[n];
            dp[0] = arr[0];
            dp[3] = dp[0]+arr[3];
            dp[1] = dp[3] + arr[1] + arr[2];
        	dp[2] = dp[3] + arr[2];
        	
        	for(int i=4;i<=n-3;i++){
        	    dp[i] = arr[i] + Math.min(dp[i-3],Math.min(dp[i-1]+arr[i+1]+arr[i+2],dp[i-2]+arr[i+1]));
        	}
            return dp[n-4]+arr[n-1];
        }
}
