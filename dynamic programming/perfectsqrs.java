/*
https://leetcode.com/problems/perfect-squares/
Given a positive integer n, find the least number of perfect 
square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9. */


class Solution {
    public int numSquares(int n) {
         if (n <= 3) 
            return n; 
  
        int dp[] = new int[n + 1]; 
  
        dp[0] = 0; 
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 3; 
  
        for (int i = 4; i <= n; i++) { 
            dp[i] = i; 
  
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) { 
                int temp = x * x; 
                if (temp > i) 
                    break; 
                else
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]); 
            } 
        } 
  
        int res = dp[n]; 
        for(int i=0;i<n;i++){
            System.out.print(dp[i]+" ");
        }
        return res;
    }
}
