// { Driver Code Starts
//Initial Template for Java
/*
A gallery with plants is divided into n parts, numbered : 0,1,2,3...n-1. There are provisions for attaching
water sprinklers at every partition. A sprinkler with range x at partition i can water all partitions from i-x to i+x.

Given an array gallery[ ] consisting of n integers, where gallery[i] is the range of sprinkler at partition 
i (power==-1 indicates no sprinkler attached), return the minimum number of sprinklers that need to be turned 
on to water the complete gallery.

If there is no possible way to water the full length using the given sprinklers, print -1.

Input:
First line of input holds the number of test cases t, then t test cases follow. In each test case, first line
holds the integer n. Second line of test case holds the n space separated integers representing the array gallery[ ].

Output:
Output should hold the minimum number of sprinklers that need to be turned on to water the complete length.

Your task:
Your task is to complete the function min_sprinklers() which takes the array gallery[ ] and the integer n as
input parameters and returns the value to be printed.

Constraints:
T <= 500
n <= 1000
gallery[i] <= 50

Example:
Input:
3
6
-1 2 2 -1 0 0
9
2 3 4 -1 2 0 0 -1 0
9
2 3 4 -1 0 0 0 0 0
Output:
2
-1
3
Explanation:
Testcase 1:
Sprinklers at index 2 and 5 can water the full gallery, span of sprinkler at index 2 = [0,4] and span of sprinkler 
at index 5 = [5,5]
Testcase 2:
No sprinkler can throw water at index 7. Hence all plants cannot be watered.
Testcase 3:
Sprinkler at indexes 2, 7 and 8 together can water all plants.
*/


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
