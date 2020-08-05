// { Driver Code Starts
//Initial Template for Java
// Given two strings A and B, find the minimum number of times A has to be stated such that B becomes a 
// substring of the repeated A. If no such solution exists, return -1.

// Input:
// First line of input contains number of testcases T. For each testcase, there will be two lines containing 
// A and B respectively. 

// Output:
// Print the minimum number of times A needs to be repeated. If no solution exists, return -1.

// Your Task:
// Complete the function repeatedStringMatch() that takes strings A and B as input and returns integer output.

// Constraints: 
// 1 <= T <= 100
// 1<= A.length() <= 1000
// 1<= B.length() <= 1000

// Example:
// Sample Input :
// 2
// abcd
// cdabcdab
// aa
// a

// Sample Output :
// 3
// 1

// Explanation : 
// Testcase 1: After repeating A 3 times, we get ‘abcdabcdabcd’. B is now a substring of A.

// Testcase 2: B is already a substring of A and need to be stated only once. 


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t > 0){
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    } 
} 
        

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
	static int repeatedStringMatch(String A, String B) 
	{ 
        // Code here
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        if(sb.toString().contains(B)) return count;
        if(sb.append(A).toString().contains(B)) return ++count;
        return -1;
	} 
} 
