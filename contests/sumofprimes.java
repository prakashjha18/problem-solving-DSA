// Given a positive number N. The task is to find sum of all the primes upto N(inclusive).

// Input:
// First line of input contains number of testcases T. For each testcase, 
// there will be only single line containing N.

// Output:
// For each testcase, output the sum.

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 106

// Example:
// Input:
// 1
// 23

// Output:
// 100

// Explanation:
// Testcase 1: Sum of primes till 23 is 100, i.e, 2+3+5+7+11+13+17+19+23 = 100.
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	static int N = 1000000;
	static boolean[] primes = new boolean[N+1];
	static long[] primeSum = new long[N+1];
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SoE();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(br.readLine());
		    System.out.println(primeSum[n]);
		}
	}
	static void SoE()
	{
	    for(int i=2; i<=N; i++)
	        primes[i] = true;
	    for(int i=2; i*i<=N; i++)
	    {
	        if(primes[i])
	            for(int j=i*i; j<=N; j+=i)
	                primes[j] = false;
	    }
	    long sum = 0;
	    for(int i=2; i<=N; i++)
	    {
	        if(primes[i])
	            sum+=i;
	        primeSum[i] = sum;
	    }
	}
}
