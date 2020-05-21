// { Driver Code Starts
//Initial Template for Java
//https://www.youtube.com/watch?v=YDf982Lb84o
import java.util.*;
import java.io.*;
import java.lang.*;


 // } Driver Code Ends


//User function Template for Java

class Solution
{
    static int numTrees(int n)
    {
        // Your code goes here
        int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        int mod = 1000000007;
        for(int i=2; i <= n; i++){
            for(int j=0; j <i; j++){
                T[i] += ((long)(T[j])*(long)(T[i-j-1]))%mod;
                if(T[i]>=mod)
                    T[i]%=mod;
            }
        }
        return T[n];
    }
}


// { Driver Code Starts.

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            Solution T = new Solution();
            System.out.println(T.numTrees(n));
        }
    }
}
  // } Driver Code Ends
