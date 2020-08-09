// { Driver Code Starts
//Initial Template for Java
/*
Constraints:
1 <= T <= 103
1 <= |S1|,|S2| <= 105
All the characters are in lowercase English alphabet.

Example:
Sample Input:
2
abcdab
abad
aghahb
ahagb
 

Sample Output:
2
1

Explanation:
For test case 1: Here,
You can see initially the boy1 has parcel of type 'A' ->2, 'B'->2, 'C'->1 and 'D'->1
You can see initially the boy2 has parcel of type 'A'->2, 'B'->1 and 'D'->1 
So, you can see clearly that boy2 has to take 1 parcel of type 'B' and 1 parcel of type 'C' 
to make all the parcel equal. So, the answer is 2.
*/
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S1 = read.readLine();
            String S2 = read.readLine();
            Solve s= new Solve();
            
            System.out.println(s.need_to_carry(S1,S2));
        }
	    
	}
}// } Driver Code Ends


//User function Template for Java


class Solve
{
   
   // Code Here
   int need_to_carry(String s1, String s2)
    {
        // Creating two array for index hashing of the character
        int a[] = new int[128];
        int b[] = new int[128];
        
        // Counting the ocuurence of particular character in string s1
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)]++;
        }
        
        // Counting the ocuurence of particular character in string s2
        for(int i=0;i<s2.length();i++){
            b[s2.charAt(i)]++;
        }
        // Initialising the answer equal to 0
        int ans=0;
        
        // counting the absolute difference of the occurence of character ['a'-'z']
        for(int i='a';i<='z';i++){
            ans += Math.abs(a[i]-b[i]);
        }
        
        return ans;
    }
    
}
