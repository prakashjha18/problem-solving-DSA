// Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

// Example 1:

// Input: A = "ab", B = "ba"
// Output: true
// Example 2:

// Input: A = "ab", B = "ab"
// Output: false
// Example 3:

// Input: A = "aa", B = "aa"
// Output: true
// Example 4:

// Input: A = "aaaaaaabc", B = "aaaaaaacb"
// Output: true
// Example 5:

// Input: A = "", B = "aa"
// Output: false

class Solution {
    public boolean buddyStrings(String str1, String str2) {
        int len1 = str1.length(); 
        int len2 = str2.length(); 

        if (len1 != len2) 
            return false; 
        
       if (str1.equals(str2)) {
            int[] count = new int[26];
            for (int i = 0; i < str1.length(); ++i)
                count[str1.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
        // To store indexes of previously mismatched 
        // characters 
        int prev = -1, curr = -1; 
       
        int count = 0; 
        for (int i=0; i<len1; i++) 
        { 
            // If current character doesn't match 
            if (str1.charAt(i) != str2.charAt(i)) 
            { 
                // Count number of unmatched character 
                count++; 
       
                // If unmatched are greater than 2, 
                // then return false 
                if (count > 2) 
                    return false; 
       
                // Store both unmatched characters of 
                // both strings 
                prev = curr; 
                curr = i; 
            } 
        } 
        return (count == 2 && 
                str1.charAt(prev) == str2.charAt(curr) && 
                str1.charAt(curr) == str2.charAt(prev)); 
    }
    }
}
