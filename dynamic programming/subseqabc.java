// { Driver Code Starts
//Ini// Input  : abbc
// Output : 3
// Subsequences are abc, abc and abbc

// Input  : abcabc
// Output : 7
// Subsequences are abc, abc, abbc, aabc
// abcc, abc and abctial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        //int mod = 1000000007;
        int aCount = 0; 
        int bCount = 0; 
        int cCount = 0; 
        for (int i = 0; i < s.length(); i++) { 
            if (s.charAt(i) == 'a') 
                aCount = (1 + (2 * aCount)); 
  
            else if (s.charAt(i) == 'b') 
                bCount = (aCount + (2 * bCount)); 
                
            else if (s.charAt(i) == 'c') 
                cCount = (bCount + (2 * cCount)); 
        } 
  
        return cCount; 
    }
}
