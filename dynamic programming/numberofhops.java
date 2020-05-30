// { Driver Code Starts
//Initial Template for Java
//A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top.
import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            System.out.println(new Hops().countWays(n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Hops
{
    static long countWays(int n)
    {
        // add your code here
        int mod = 1000000007;
        long[] ways = new long[n + 3];
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for(int i = 3; i <= n; i++){
            ways[i] = (ways[i - 1]%mod + ways[i - 2]%mod + ways[i-3]%mod)%mod;
        }

        return ways[n];
    }
    
}

