/*package whatever //do not write package name here */
// Given a total score n, find the number of distinct combinations to reach the given score.

// Input:
// The first line of input contains an integer T denoting the number of test cases. 
// T test cases follow. The first line of each test case is n.

// Output:
// For each testcase, in a new line, print the number of ways/combinations to reach
// the given score.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ n ≤ 1000

// Example:
// Input:
// 3
// 8
// 20
// 13

// Output:
// 1
// 4
// 2
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n =sc.nextInt();
		    System.out.println(count(n));
		}
	}
	static int count(int n) 
    { 
        // table[i] will store count of solutions for 
        // value i. 
        int table[] = new int[n + 1], i; 
      
        // Initialize all table values as 0 
        Arrays.fill(table, 0); 
      
        // Base case (If given value is 0) 
        table[0] = 1; 
      
        // One by one consider given 3  
        // moves and update the table[] 
        // values after the index greater  
        // than or equal to the value of  
        // the picked move 
        for (i = 3; i <= n; i++) 
            table[i] += table[i - 3]; 
        for (i = 5; i <= n; i++) 
            table[i] += table[i - 5]; 
        for (i = 10; i <= n; i++) 
            table[i] += table[i - 10]; 
      
        return table[n]; 
    } 
}
