/*package whatever //do not write package name here */
/*
Given an array of integers (A[])  and a number x, find the smallest subarray 
with sum greater than the given value.

Note: There is at least one subarray with sum greater than x

Examples:
A[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

A[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

Input:
The first line of input contains an integer T denoting the no of test cases.
Then T test cases follow. Each test case contains two space separated integers N and x.
Then in the next line are N space separated values of the array.

Output:
For each test case in a new line print the required ouput.

Constraints:
1<=T<=100
1<=N,x<=1000
1<=A[]<=1000

Example:
Input:
2
6 51
1 4 45 6 0 19
5 9
1 10 5 2 7
Output:
3
1
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int smallestSubWithSum(int arr[], int n, int x)  
    { 
        int curr_sum = 0, min_len = n + 1; 
        int start = 0, end = 0; 
        
        while (end < n)  
        {
            while (curr_sum <= x && end < n) 
                curr_sum += arr[end++]; 
        
        
            while (curr_sum > x && start < n)  
            { 
                if (end - start < min_len) 
                    min_len = end - start; 
    
                curr_sum -= arr[start++]; 
            } 
        }
        return min_len;
        
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- >0)
		{
		    int n=sc.nextInt();
		    int x=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
		    
		    int res1 = smallestSubWithSum(a, n, x); 
            if (res1 == n+1) 
               System.out.println("Not Possible"); 
            else
               System.out.println(res1); 
		}
	}
}
