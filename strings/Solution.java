// Given a string s, find the length of the longest substring without duplicate characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// public class Solution {

//     public int lengthOfLongestSubstring(String s) {
//         Map<Character, Integer> chars = new HashMap();

//         int left = 0;
//         int right = 0;

//         int res = 0;
//         while (right < s.length()) {
//             char r = s.charAt(right);
//             chars.put(r, chars.getOrDefault(r, 0) + 1);

//             while (chars.get(r) > 1) {
//                 char l = s.charAt(left);
//                 chars.put(l, chars.get(l) - 1);
//                 left++;
//             }

//             res = Math.max(res, right - left + 1);

//             right++;
//         }
//         return res;
//     }
// }
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> charToNextIndex = new HashMap<>(); // index after current character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (charToNextIndex.containsKey(s.charAt(j))) {
                i = Math.max(charToNextIndex.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            charToNextIndex.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}