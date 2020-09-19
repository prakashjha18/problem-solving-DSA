/*
https://leetcode.com/problems/integer-break/
Integer Break 

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.

*/



class Solution {
    // public int integerBreak(int n) {
    //     int[] dp = new int[n + 1];
    //     dp[0] = 1;
    //     int max = 0;
    //     for(int i = 1; i < n; i++){
    //         for(int j = i; j <= n; j++){
    //             dp[j] = Math.max(dp[j], dp[j - i] * i);
    //             if(j == n){
    //                 if(max < dp[j])
    //                     max = dp[j];
    //             }
    //         }
    //     }
    //     return max;
    // }
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;
        
        return product;
    }

}
