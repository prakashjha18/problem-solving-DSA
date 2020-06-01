// Example
// Input
// 2
// 4
// 2 1 1
// 5
// 5 3 2
// Output
// 4
// 2

// Explanation:
// Testcase 1: Total length is 4, and the cut lengths are 2, 1 and 1.  We can make maximum 4 segments each of length 1.
// Testcase 2: Here total length is 5, and the cut lengths are 5, 3 and 2. We can make two segments of lengths 3 and 2.

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int maximizeCuts(int n, int a, int b, int c)
    {
       //Your code here
        int dp[] = new int[n+1 ]; 
        Arrays.fill(dp, -1); 
        dp[0] = 0;  
        for (int i = 0; i < n; i++)  
        { 
            if (dp[i] != -1)  
            { 
                if(i + a <= n ) 
                dp[i + a] = Math.max(dp[i] + 1,  
                                    dp[i + a]); 
                                      
                if(i + b <= n ) 
                dp[i + b] = Math.max(dp[i] + 1,      
                                    dp[i + b]); 
                                      
                if(i + c <= n )  
                dp[i + c] = Math.max(dp[i] + 1,  
                                    dp[i + c]); 
            } 
        } 
        if(dp[n]==-1)
            return 0;
        return dp[n]; 
    }
}
