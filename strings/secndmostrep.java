// { Driver Code Starts
//Initial Template for Java
/*

Given a sequence of strings, the task is to find out the second most repeated (or frequent) 
string in the given sequence.

Note: No two strings are the second most repeated, there will be always a single string.

Example 1:

Input:
N = 6
arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
Output: bbb
Explanation: "bbb" is the second most 
occurring string with frequency 2.

â€‹Example 2:

Input: 
N = 6
arr[] = {geek, for, geek, for, geek, aaa}
Output: for
Explanation: "for" is the second most
occurring string with frequency 2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function secFrequent() 
which takes the string array arr[] and its size N as inputs and returns the second most frequent
string in the array.


Expected Time Complexity: O(N*max(|Si|).
Expected Auxiliary Space: O(N*max(|Si|).


Constraints:
1<=N<=103



*/
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String, Integer> occ = new HashMap<String,Integer>();
        for (int i=0;i<N;i++) {
            occ.put(arr[i], occ.getOrDefault(arr[i], 0) + 1);
        }
        int first_max = Integer.MIN_VALUE, sec_max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : occ.entrySet()) {
            int v = entry.getValue(); 
           if( v > first_max) { 
                sec_max = first_max; 
                first_max = v; 
            } 
       
            else if (v > sec_max &&  
                     v != first_max) 
                sec_max = v; 
        }
        //System.out.print(occ+""+first_max+""+sec_max);
        for(Map.Entry<String, Integer> entry : occ.entrySet()) {
            int v = entry.getValue(); 
            if (v == sec_max) 
                return entry.getKey(); 
        }
        return " "; 
    }
}
