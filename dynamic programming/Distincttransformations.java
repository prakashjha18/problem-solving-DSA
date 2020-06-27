/*package whatever //do not write package name here */
// Given two sequences A, B, find out number of unique ways in sequence A,
// to form a subsequence that is identical to the sequence B.

// Example :
// A = "abcccdf"  B = "abccdf"

// Return 3. And the formations as follows:

// A1= "ab.ccdf"
// A2= "abc.cdf"
// A3="abcc.df"

// "." is where character is removed.


// Input:
// First line contains the test cases T.  1<=T<=500
// Each test case have two lines
// First is a string A of length less than 1000.
// Second is a string B of length less than 100.

// Exapmle:
// Input:
// 2
// abcccdf
// abccdf
// uwnny
// uwnny

// Output:
// 3
// 1
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int  t = sc.nextInt();
		while(t-->0){
		    String a = sc.next();
		    String b = sc.next();
		    System.out.println(countTransformation(a,b));
		}
	}
	static int countTransformation(String a,String b) 
    { 
        int n = a.length(), m = b.length(); 
        if (m == 0) { 
            return 1; 
        } 
  
        int dp[][] = new int[m][n]; 
        for (int i = 0; i < m; i++) { 
            for (int j = i; j < n; j++) { 
                if (i == 0) { 
                    if (j == 0) { 
                        dp[i][j] = (a.charAt(j) == b.charAt(i)) ? 1 : 0; 
                    } 
                    else if (a.charAt(j) == b.charAt(i)) { 
                        dp[i][j] = dp[i][j - 1] + 1; 
                    } 
                    else { 
                        dp[i][j] = dp[i][j - 1]; 
                    } 
                } 
                else if (a.charAt(j) == b.charAt(i)) { 
                    dp[i][j] = dp[i][j - 1] 
                               + dp[i - 1][j - 1]; 
                } 
                else { 
                    dp[i][j] = dp[i][j - 1]; 
                } 
            } 
        }
        return dp[m - 1][n - 1]; 
    }
}
