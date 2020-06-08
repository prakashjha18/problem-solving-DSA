// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    LCS obj = new LCS();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class LCS{
    
    // function to find LCS
    
    static int lcs(int p, int q, String s1, String s2){
        // your code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length(); i >= 1; i--) {
			
			for (int j = s2.length(); j >= 1; j--) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i-1][j-1] =  Math.max((1 + dp[i][j]), Math.max(dp[i][j-1], dp[i-1][j]));
				}
				else {
					dp[i-1][j-1] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}//end of inner loop
		}//end of loop
// 		for(int i =0 ;i<s1.length();i++){
// 		    for(int j=0;j<s2.length();j++){
// 		        System.out.print(dp[i][j]+" ");
// 		    }
// 		    System.out.println();
// 		}
		return dp[0][0];
    }
    
}
