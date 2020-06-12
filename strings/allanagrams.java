// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

// The order of output does not matter.

// Example 1:

// Input:
// s: "cbaebabacd" p: "abc"

// Output:
// [0, 6]

// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input:
// s: "abab" p: "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

class Solution {
    static final int MAX = 256;
    public boolean compare(char arr1[], char arr2[]){ 
        for (int i = 0; i < MAX; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> arr = new ArrayList<>();
        int M = pat.length(); 
        int N = txt.length(); 
        char[] countP = new char[MAX]; 
        char[] countTW = new char[MAX]; 
        for (int i = 0; i < M; i++) 
        { 
            (countP[pat.charAt(i)])++; 
            (countTW[txt.charAt(i)])++; 
        } 
        for (int i = M; i < N; i++) 
        { 
            if (compare(countP, countTW)) 
                arr.add(i-M); 
              
            // Add current character to current  
            // window 
            (countTW[txt.charAt(i)])++; 
  
            // Remove the first character of previous 
            // window 
            countTW[txt.charAt(i-M)]--; 
        }
        if (compare(countP, countTW)) 
                arr.add(N-M);
        return arr;
    }
    //Sliding window approach two
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[26]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {

            if (hash[s.charAt(right++)-'a']-- >= 1) count--;
            if (count == 0) list.add(left);
            if (right - left == p.length() && hash[s.charAt(left++)-'a']++ >= 0) count++;
        }
        return list;
    }
}
