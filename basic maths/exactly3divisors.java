/*
Given a positive integer value N. The task is to find how many numbers less than or equal
to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. 
The only line of each test case contains an integer N.

Output:
For each testcase, in a new line, print the answer of each test case.

Your Task:
This is a function problem. You only need to complete the function exactly3Divisors() 
that takes N as parameter and returns count of numbers less than or equal to N with exactly 3 divisors.

Constraints :
1 <= T <= 100
1 <= N <= 109

Example:
Input :
3
6
10
30
Output :
1
2
3

Explanation:
Testcase 1: There is only one number 4 which has exactly three divisors 1, 2 and 4.
Testcase 2: 4 and 9 are the only two numbers less than or equal to 10 that have exactly three divisors.
Testcase 3: 4, 9, 25 are the only numbers less than or equal to 30 that have exactly three divisors.
*/

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Mathematics {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		while(T-->0)
		{
		    Divisors obj=new Divisors();
		    int N;
		    N=sc.nextInt();
		    
		    System.out.println(obj.exactly3Divisors(N));
		   
		    
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Divisors
{
    
   public boolean isPrime(int n)
    {
        if (n <= 1) return false; 
        if (n <= 3) return true; 
      
        // This is checked so that we can skip  
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) return false; 
      
        for (int i = 5;  i <= Math.sqrt(n); i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
      
        return true;
    }
    
    // function to check the numbers which has exactly 3 divisors
    public int exactly3Divisors(int N)
    {
        int counter=0; //Initializing counter to zero
        N = (int)Math.sqrt(N);
            
        for(int i=1;i<=N;i++) //Running a loop from 1 to N
        {
            // A number N only has 3 divisors if it is a perfect square and its square root is a prime number,
            //  and we know the number of perfect squares less than N which is sqrt(N),
            // so just checking if i is prime or not
            if(isPrime(i)) 
            counter++;
        }
        return counter;
    }
}
