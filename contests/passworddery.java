// { Driver Code Starts
//Initial Template for Java
/*
Alice wants to secure his bank account details and wants to encrypt his password P. He wants to encrypt it in such a 
fashion:-
Suppose P = "zyxabc", he will randomly shuffle his password, then he will concatenate a random string S1 in starting
of P and a random string S2 at end of the string P. Let S1 = "fgh" and S2 = "bvf" then encrypted string become 
H = "fghcxabyzbvf".
Bob has got a password and an encrypted string, He being a hacker wants to check if the encrypted string can be 
a valid one for the password he have.
The password and encrypted password only consists of lower case english alphabets.

Input:
First line of input contains an integer T, denoting the number of test cases. First line of each test case
contains the string P, second line of the test case contains the string H.

Output:
Print "Yes" if it is a valid one else "No".

Your Task:
This is a functional problem . You don't need to take input just complete the function valid() which accepts
two strings P and S as parameters and return 0 or 1.

Constraints:
1<= T  <=30
1<= |P| <=105
1<= |H| <=105

Example:
Input:
2
zyxabc
fghcxabyzbvf
htc
hxtcczht

Output:
Yes
No
*/


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t>0)
		{
		    String s1=ob.next();
		    String s2=ob.next();
		    Solution ab=new Solution();
		    if(ab.valid(s1,s2))
		    System.out.println("Yes");
		    else
		    System.out.println("No");
		    t--;
		}
	}
}

// } Driver Code Ends



//User function Template for Java

class Solution
{
    boolean valid(String p,String s)
    {
        int n=p.length();
        int m=s.length();
        if(m<n)
        {
            return false;
        }
        int l=0;
        int r=0;
        
        // Create two hash arrays of size 26 each
        // for storing frequency of characters
        // h1[]: stores frequency of characters of password String
        // h[]: stores frequency of characters of encrypted string
        //          of window of length p.size()
        int h1[]=new int[128];
        int h[]=new int[128];
        
        // Calculate frequency of password string P
        for(int i=0;i<n;i++)
            h1[p.charAt(i)]+=1;
            
        // Traverse the encrypted string with
        // window of size P.size()
        while(r<m)
        {
            if(r-l+1<n)
            {
                h[s.charAt(r)]+=1;
                r=r+1;
                System.out.print(r+" ");
            }
            else if(r-l+1==n)
            {
                int flag=1;
                h[s.charAt(r)]+=1;
                
                // If all characters in current window is same as 
                // that of Password string, we return true
                for(int i='a';i<='z';i++)
                {
                    if(h[i]!=h1[i])
                    {
                        flag=0;
                        break;
                    }
                }
                if(flag==1)
                return true;
                r=r+1;
                h[s.charAt(l)]-=1;
                l=l+1;
            }
        }
        return false;
    }
}

       
