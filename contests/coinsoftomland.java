// { Driver Code Starts
//Initial Template for Java
// In Tomland there is a grid of coins of size N x N . Since you are tom , you have to find the maximum sum of 
// coins in any sub-grid of size K x K.
// Note: Coins of negative denomination is also possible in Tomland.
// Input:
// First line of input contains T denoting number of test cases.For each test case, the first line contains N 
// denoting the size N x N of the grid .Next N lines contains the grid[N][N] . Last line contains the value of K. 
// Output:
// Print the maximum sum of a K x K sub-grid.
// User Task:
// Since it is a functional problem. So, you don't need to worry about the input. You just have to complete the 
// function Maximum_Sum() that takes grid as mat, an integer value N denoting the size of grid and integer value K 
// denoting size of sub grid . It returns the maximum sum of a K x K sub-grid.
// Constraints:
// 1 < T < 100
// 1 <= N <= 103
// -5*105 < grid[i][j] < 5*105
// 1 <= K <= N 
// Example:
// Sample Input:
// 1
// 5
// 1 1 1 1 1 
// 2 2 2 2 2 
// 3 8 6 7 3 
// 4 4 4 4 4 
// 5 5 5 5 5
// 3
// Sample output:
// 48
// Explanation:
// For test case 1:
// Maximum sum of 3 x 3 grid is: 48
// Here is the sub-grid of size K x K that is forming the maximum sum,
// 8 6 7
// 4 4 4
// 5 5 5


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.maximumSum(a,n,k));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maximumSum(int mat[][],int n,int k){
        
        // Write your code here
        int stripSum[][] = new int[n][n];
        for (int j = 0; j < n; j++) { 
            int sum = 0; 
            for (int i = 0; i < k; i++) 
                sum += mat[i][j]; 
            stripSum[0][j] = sum; 
            
           
            for (int i = 1; i < n - k + 1; i++) { 
                sum += (mat[i + k - 1][j] - mat[i - 1][j]); 
                stripSum[i][j] = sum; 
            } 
        } 
        int ans =Integer.MIN_VALUE;
        for (int i = 0; i < n - k + 1; i++) {
            
            int sum = 0; 
            for (int j = 0; j < k; j++) 
                sum += stripSum[i][j]; 
                
            ans=Math.max(ans,sum);
            
            for (int j = 1; j < n - k + 1; j++) { 
                sum += (stripSum[i][j + k - 1] - stripSum[i][j - 1]); 
                ans=Math.max(ans,sum);
            }  
        } 
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(stripSum[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}
