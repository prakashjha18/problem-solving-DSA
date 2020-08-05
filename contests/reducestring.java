// { Driver Code Starts
//Initial Template for Java
//Given a string Str and an integer K, the task is to reduce the string by applying the following operation:
// Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.

// Input:
// First-line contains T, denoting the number of test cases.
// For each test case, the first line contains K, denoting the number of characters we can reduce then the next line contains the String Str.

// User Task:
// As it is a functional problem. So, you don't have to worry about the input. You just have to complete the function Reduced_String() that takes the number of consecutive identical character K and string Str as parameter and returns the reduced string.

// Output:
// Print the reduced String.

// Constraints:
// 1 <= T <= 100
// 1 <=  k <=100
// 1 <= |S| <=10^4

// Example:
// Sample Input:
// 2
// 2
// geeksforgeeks
// 2
// geegsforgeeeks

// Sample Output:
// gksforgks
// sforgeks


import java.util.*;
import java.math.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            
            System.out.println(T.reduced_String(s, k));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Pair{
    
    char c;
    int ctr;
    Pair(char c,int ctr)
    {
        this.c = c;
        this.ctr = ctr;
    }
}

class Solution
{
    public static String reduced_String(String s, int k)
    {
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int ctr = 0;
        for(int i=0;i<l;i++)
        {
            if(st.size() == 0)
            {
                st.push(new Pair(s.charAt(i),1));
                continue;
                
            }
            if(st.peek().c == s.charAt(i))
            {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if(p.ctr == k)
                {
                    continue;
                }
                else
                {
                    st.push(p);
                }
            }
            else{
                 st.push(new Pair(s.charAt(i),1));
            }
        }
       
        String ans = "";
        while(st.size() > 0)
        {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while(cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        
        return ans;
    }
}
