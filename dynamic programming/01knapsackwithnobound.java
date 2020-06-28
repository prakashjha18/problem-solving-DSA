// Given weights and values related to n items and the maximum capacity allowed 
// for these items. What is the maximum value we can achieve if we can pick any
// weights any number of times for a total allowed weight of W?

// Input:
// The first line of input contains an integer denoting the number of test cases.
// Then T test cases follow . Each test case contains two integers N and W denoting 
// the number of items and the total allowed weight. In the next two lines are space 
// separated values of the array denoting values of the items (val[]) and their weights
// (wt[]) respectively.

// Output:
// For each test case, in a new line, print the  maximum value which we can achieve 
// if we can pick any weights any number of times for a bag of size W.

// Constraints:
// 1 <= T <= 100
// 1 <= N, W <= 103
// 1 <= wt[], val[] <= 100

// Example:
// Input:
// 2
// 2 3
// 1 1
// 2 1 
// 4 8
// 1 4 5 7
// 1 3 4 5
// Output:
// 3
// 11


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG{
	public static void main (String[] args)throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-- > 0){
	        String p[] = br.readLine().split(" ");
	        int n = Integer.parseInt(p[0]);
	        int w = Integer.parseInt(p[1]);
	        int val[] = new int[n];
	        int wt[] = new int[n];
	        String st[] = br.readLine().split(" ");
	        for(int i=0;i<n;i++){
	            val[i] = Integer.parseInt(st[i]);
	        }
	        String s[] = br.readLine().split(" ");
	        for(int i=0;i<n;i++){
	            wt[i] = Integer.parseInt(s[i]);
	        }
	        int dp[][] = new int[n+1][w+1];
	        for(int i=0;i<=n;i++){
	            for(int j=0;j<=w;j++){
	                if(i==0 || j==0){
	                    dp[i][j] = 0;
	                    continue;
	                }
	                if(j-wt[i-1] >=0 )
	                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
	                else
	                    dp[i][j] = dp[i-1][j];
	            }
	        }
	       // for(int i=0; i <= n; i++){
        //         for(int j=0; j <= w; j++){
        //             System.out.print(dp[i][j]+" ");
        //         }
        //         System.out.println();
        //     }
	        System.out.println(dp[n][w]);
	    }
	}
}
