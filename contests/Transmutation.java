/*package whatever //do not write package name here */
// You are a legendary Alchemist known for transmuting any number N to 1. In 
// this transmutation process, you do  2 operations:

// If a number is odd, you either add 1 to it or subtract 1 from it.
// If a number is even, you divide the number by 2.
// Now, you have received a special request from Your Highness himself to transmute N to 1; 
// however, he wants you to do it in the minimum number of steps to save time.

// Can you maintain your status-quo as the legendary Alchemist?

// Input:
// The first line of input contains T, the number of testcases. T testcases follow. Each testcase 
// contains one line of input containing number N.

// Output:
// For each testcase, in a new line, print the minimum number of steps.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 10000000

// Example:
// Input:
// 4
// 1
// 2
// 3
// 4
// Output:
// 0
// 1
// 2
// 2

// Explanation:
// Testcase1: 1 can be converted into 1 in 0 steps.
// Testcase2: 2 can be converted into 1 in 1 step: 2-1
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		 int[] dp = new int[10000001];
		    dp[1] = 0;
		    dp[2] = 1;
		    for(int i = 3; i <= 10000000; i++){
		        if(i%2 == 0){
		            dp[i] = 1 + dp[i/2];
		        }
		        else{
		            dp[i] = 2 + Math.min(dp[(i-1)/2], dp[(i+1)/2]);
		        }
		    }
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());

		    sb.append(dp[n] + "\n");
            
		}
		System.out.print(sb);
	}
}
