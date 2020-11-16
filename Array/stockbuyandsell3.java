/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Example 4:

Input: prices = [1]
Output: 0
*/

class Solution {
    public int maxProfit(int[] price) {
        int n = price.length;
        int profit[] = new int[n];

        int max_price = price[n - 1];
        for (int i = n - 2; i >= 0; i--) 
        {
            if (price[i] > max_price)
                max_price = price[i];
 
            profit[i] = Math.max(profit[i + 1],
                                 max_price - price[i]);
        }
 
        int min_price = price[0];
        for (int i = 1; i < n; i++) 
        {
            if (price[i] < min_price)
                min_price = price[i];
 
            profit[i] = Math.max(
                profit[i - 1],
                profit[i] + (price[i] - min_price));
        }
        int result = profit[n - 1];
        return result;
    }
}
