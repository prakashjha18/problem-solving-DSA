// { Driver Code Starts
//Initial Template for Java
// Lucky numbers are subset of integers. Rather than going into much theory, 
// let us see the process of arriving at lucky numbers,
// Take the set of integers
// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
// First, delete every second number, we get following reduced set.
// 1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
// Now, delete every third number, we get
// 1, 3, 7, 9, 13, 15, 19,….….
// Continue this process indefinitely……
// Any number that does NOT get deleted due to above process is called “lucky”.

// Your task is to complete isLucky function.

// Input:
// The first line of input contains an integer T denoting the number of test cases.
// Then T test cases follow. The first line of each test case contains an integer N. 

// Output:
// For each testcase, in a new line, print 1 if the given number is a lucky number, else print 0.

// Your Task:
// This is a function problem. You only need to complete the function isLucky that 
// takes n as parameter and returns either 0 or 1.

// Expected Time Complexity: O(sqrt(n)).

// Constraints:
// 1 <= T <= 100
// 1 <= N <= 105

// Example:
// Input:
// 2
// 5
// 19
// Output:
// 0
// 1

// Explanation:
// Testcase1: 5 is not a lucky number as it gets deleted in the second iteration.
// Testcase2: 19 is a lucky number


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
            int n = Integer.parseInt(read.readLine());
            
            System.out.println((new Solution().isLucky(n))? "1" : "0");
            new Solution().counter = 2;
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    // Complete the function
    // n: Input n
    // counter: variable has already been declared in driver code
    //          you just have to use this variable.
    static int counter = 2;
    
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        // Your code here
        if(counter > n)
            return true;
        if(n%counter==0)
            return false;
        int np=n;
        // System.out.println(np);
        np=np-np/counter;
        counter++;
        return isLucky(np);
    }
}
