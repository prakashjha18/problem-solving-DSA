// { Driver Code Starts
//Initial Template for Java
// Given an array arr[] of positive integers of size N . You need to find maximum sum that can be formed from
// the integers of the array under the constraint that no three consecutive elements can be used .
// Input:
// First line of input contains number of test cases T. For each test case , first line contains N denoting 
// size of the array and Next line contains N space seperated integers .
// Output:
// For each test case , Print maximum sum.
// Your Task:

// You have to complete the function MaxSum() which accpets given array and it's size as parameter and returns
// the value of maximum sum.
// Constraints:
// 1<= T <=100
// 1<= N <=105
// 1<= arr[i] <=103
// Example:
// Input:
// 2
// 5
// 1 2 3 4 5
// 4
// 9 2 1 3
// Output:
// 12
// 14
// Explanation: 
// Test Case 1: 1 + 2 + 4 + 5 = 12


import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0)
                {
                    int n = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        arr[i] = sc.nextInt();
                    
                    Solve obj = new Solve();
                    System.out.println(obj.MaxSum(arr,n));
                }
        }
}// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solve
{
    public static int MaxSum(int arr[], int n) 
    { 
        //code here.
        int sum[] = new int[n];
        if(n>=1)
            sum[0]=arr[0];
        if(n>=2)
            sum[1]=arr[0]+arr[1];
        if(n>2)
            sum[2] = Math.max(sum[1],Math.max(arr[1]+arr[2],arr[0]+arr[2]));
            
        for(int i=3;i<n;i++){
            sum[i] =Math.max(Math.max(sum[i-1],sum[i-2]+arr[i]),arr[i]+arr[i-1]+sum[i-3]);
        }
        return sum[n-1];
    } 
}
