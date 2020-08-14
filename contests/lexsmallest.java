// { Driver Code Starts
// Initial Template for Java

/*

Find the lexicographically smallest sub sequence of exactly k length in a given string.

Input: First line of input contains number of test cases T. Then T test cases folow. 
In each test case first line contains the input string s. Input string consists of lower
case letters. Second line of each test case contains the value k. Input will be read by driver code.

Output: Output should be the lexicographically smallest sub sequence of k length correspondint
to input string.

Your task: Your task is to complete the function lexico_smallest_sub_seq(). This function takes
the input string and k as argument and returns the output string. String returned by this function 
will be printed by driver code.

Constraints: T <= 103 ; 1 <= k <= |s| <= 104

Example:

Input:
2
bbxabfc
3
iftygoprthxzad
6

Output:
abc
fghxad
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine());
            Solution sln = new Solution();
            System.out.println(sln.lexicoSmallestSubSeq(s, k));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public String lexicoSmallestSubSeq(String s, int k) {
        // letters[] will store indexes for all letters
        // appearing in string
        ArrayList<LinkedList<Integer>> letters =
            new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < 26; i++) {
            letters.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            letters.get(s.charAt(i) - 'a').add(i);
        }
        StringBuilder sb = new StringBuilder();
        int lowerLimit = 0, upperLimit = 0;
        while (k-- > 0) {
            // while deciding uppper limit for any pick, some margin
            // is to be left to make sure that k character can be picked
            // for the sub seq
            upperLimit = s.length() - k - 1;

            // starting pick(next character for sub seq) should as
            // small as possible
            int pick = 0;

            while (true) {
                // removing indexes lower than lower_lim
                while (!letters.get(pick).isEmpty() &&
                       lowerLimit > letters.get(pick).peek()) {
                    letters.get(pick).remove();
                }

                // if an index lower than upper_lim
                // is found, pick is finalized
                if (!letters.get(pick).isEmpty() &&
                    upperLimit >= letters.get(pick).peek()) {
                    break;
                }
                pick++;
            }
            sb.append((char)(pick + 'a'));
            // next char should have higher index
            // hence changing lower_lim
            lowerLimit = letters.get(pick).peek() + 1;
        }
        return sb.toString();
    }
}
