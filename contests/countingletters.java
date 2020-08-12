// { Driver Code Starts
// Initial Template for Java

/*
You are given a String S which consists of English lowerCase and UpperCase alphabets. First letter of 
String S can contain the Consonant and Vowels ('a', 'e', 'i', 'o' and 'u'). There are two types of query 
that you have to do on String S.
 

If the starting letter of S is vowel then you have to remove the first letter from the string S 
and add "ma" string to the end of String S.
If the starting letter of S is consonant then you have to remove the first letter from S and add 
"m" and also you have to add "a" as many times as vowel arrives before that particular consonant 
to the end of the string S.
For Example: Let consider a string S = "aaaba"
After the first operation: S = "aabama", because we have removed 'a' which is a vowel and add "ma"
to the end of the string.
After the second operating: S = "abamama", same as the first operation.
After the third operation: S = "bamamama", same as second operation.
After the fourth operation: S = "amamamamaaa", here we have removed 'b' and add "maaa" because 
before 'b' vowels has arrived 3 times that is why we have added 3 a's.
We have to do these operations K times. After that, we have to print the count of the number of 
vowels and the number of consonant in the updated string.


Input:
The first line contains the number of Test cases T.
For each test case, the first line contains the two space-separated integer N and K denoting 
the size of String S and the number of times we have to apply the operation on that String S.

User Task:
As this is a functional problem. So, you don't have to worry about the input and output. You 
just have to complete the function Count_V_W() which takes the parameter String S, Integer value 
N and K and print the number of vowels and consonant space separately.

Output:
Print the number of vowels and then print the number of consonant space separately.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= K <= 106
All the character in the string contains the lowercase and uppercase alphabets.

Example:
Sample Input:
2
5 7
ababb
5 7
aabab

Sample Output:

9 6
11 6

*/

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            String S = read.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append(S);

            Solve s = new Solve();
            s.Count_V_W(sb, n, k);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||
            a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U')
            return true;
        else
            return false;
    }
    void Count_V_W(StringBuilder s, int n, int k) {
        // Code Here
        
        int con = 0, vow = 0;
        // counting number of vowels before the particular index
        int till = 0;

        // counting vowels and consonant in the given string
        for (int i = 0; i < n; i++) {
            if (check(s.charAt(i)))
                vow++;
            else
                con++;
        }
        for (int i = 0; i < k; i++) {
            // if vowel
            if (check(s.charAt(i))) {
                // if size of current string is less than k then append "ma"
                if (s.length() < k) {
                    s.append("ma");
                    // logic is basically we have to create the size of s just
                    // greater than k.
                }
                till++;
                con++;
            } else {
                // Here also as per the rule of the inserting we have to insert
                // the K in S.
                if (s.length() < k) s.append("m");
                int i1 = 0;
                // push the char 'a' as many times as it arrived previously.
                while (i1 < till && s.length() < k) {
                    s.append("a");
                    i1++;
                }
                vow += till;
            }
        }

        System.out.println(vow + " " + con);
    }
}
