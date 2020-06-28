/*package whatever //do not write package name here */
https://practice.geeksforgeeks.org/problems/maximum-sum-problem/0
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int dp[] = new int[n+1]; 
   
            // base conditions 
            dp[0] = 0;  dp[1] = 1; 
           
            // Fill in bottom-up manner using recursive 
            // formula. 
            for (int i=2; i<=n; i++) 
               dp[i] = Math.max(dp[i/2] + dp[i/3] + dp[i/4], i); 
           
            System.out.println(dp[n]);  
		}
	}
}
