// { Driver Code Starts
//Initial Template for Java

/*
Given an array arr[] of N non-negative integers and an integer K. You have to find the sum of the products of 
all possible subsets of arr[] of size K.

Input:
First line of every input contains single integer T, denoting number of test cases. For each test case, first 
line contains two integer N and K, denoting size of array arr[] and size of subset respectively. Next line contains 
space separated N integers.

Output:
For each test case, print a single integer i.e. the sum of products of all possible subsets of size K modulo 10^9 + 7 
in new line.

Your Task:
You have to complete the function sumOfProduct() which takes array arr, n and k as parameter and returns the the sum 
of products.

Constraints:
1 <= T <= 10
1 <= N <= 10^3
 1 <= K <= N
1 <= arr[i] <= 10^9

Example:
Input:
2
4 2
1 2 3 4
3 1
1 2 3
Output:
35
6
Explanation:
For first testcase, the sum of products of subsets of size K=2 is  ​(1 * 2) + (1 * 3) + (1 * 4) + (2 * 3) + (2 * 4) + 
(3 * 4) = 2 + 3 + 4 + 6 + 8 + 12 = 35. */

import java.util.*;
import java.math.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());
            int a[] = new int[n];
            for(int i=0;i<n;i++)
            {
                a[i] = Integer.parseInt(sc.next());
            }
           
            Solution T = new Solution();
            System.out.println(T.sumOfProduct(a, n, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int sumOfProduct(int a[], int n,int k)
    {
        // write your code here
        // int mod = 1000000007;
        // int dp[][] = new int[n+1][n+1];
        // for(int i=0;i<=n;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //     {
        //         dp[i][j] = 0;
        //     }
        // }
        // int cur_sum =0;
        // for(int i=1;i<=n;i++){
        //     dp[1][i] = arr[i-1];
        //     cur_sum+=arr[i-1];
        //     cur_sum=cur_sum%mod;
        // }
        // for(int i=2;i<=k;i++){
        //     int temp_sum=0;
        //     for(int j=1;j<=n;j++){
        //         cur_sum-=dp[i-1][j]%mod;
        //         cur_sum+=mod;
        //         cur_sum%=mod;
        //         dp[i][j]=(arr[j-1]*cur_sum)%mod;
        //         temp_sum+=(dp[i][j]%mod);
        //         temp_sum=temp_sum%mod;
        //     }
        //     cur_sum=temp_sum;
        // }
        // return (int)cur_sum;
        long dp[][] = new long[n+1][n+1];
        long mod = 1000000007;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                dp[i][j] = 0;
            }
        }
        
        long sum = 0;

        for(int i=1;i<=n;i++) 
        {
            dp[1][i] = a[i - 1];
            sum +=a[i-1];
            sum%=mod;
        }

        for(int i=2;i<=k;i++) 
        {
            int temp = 0;
    
            for(int j = 1;j<=n;j++)
            {
    
                sum -= (dp[i - 1][j] % mod);
                sum+=mod;
                sum%=mod;
                dp[i][j] = (a[j - 1] * sum)%mod;
                temp += (dp[i][j] % mod);
                temp%=mod;
            }
            
            sum = temp;
        }
        
        return (int)sum;
    }
}
