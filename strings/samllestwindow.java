// Java program to find the smallest window containing 
// all characters of a pattern. 
// Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

// Examples:

// Input: aabcbcdbca
// Output: dbca
// Explanation: 
// Possible substrings= {aabcbcd, abcbcd, 
// bcdbca, dbca....}
// Of the set of possible substrings 'dbca' 
// is the shortest substring having all the 
// distinct characters of given string. 

// Input: aaab
// Output: ab
// Explanation: 
// Possible substrings={aaab, aab, ab}
// Of the set of possible substrings 'ab' 
// is the shortest substring having all 
// the distinct characters of given string.    
import java.util.Arrays; 
public class GFG { 
  
    static final int MAX_CHARS = 256; 
  
    // Function to find smallest window containing 
    // all distinct characters 
    static String findSubString(String str) 
    { 
        int n = str.length(); 
  
        // Count all distinct characters. 
        int dist_count = 0; 
  
        boolean[] visited = new boolean[MAX_CHARS]; 
        Arrays.fill(visited, false); 
        for (int i = 0; i < n; i++) { 
            if (visited[str.charAt(i)] == false) { 
                visited[str.charAt(i)] = true; 
                dist_count++; 
            } 
        } 
  
        // Now follow the algorithm discussed in below 
        // post. We basically maintain a window of characters 
        // that contains all characters of given string. 
        int start = 0, start_index = -1; 
        int min_len = Integer.MAX_VALUE; 
  
        int count = 0; 
        int[] curr_count = new int[MAX_CHARS]; 
        for (int j = 0; j < n; j++) { 
            // Count occurrence of characters of string 
            curr_count[str.charAt(j)]++; 
  
            // If any distinct character matched, 
            // then increment count 
            if (curr_count[str.charAt(j)] == 1) 
                count++; 
  
            // if all the characters are matched 
            if (count == dist_count) { 
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of times 
                // than its occurrence in pattern, if yes 
                // then remove it from starting and also remove 
                // the useless characters. 
                while (curr_count[str.charAt(start)] > 1) { 
                    if (curr_count[str.charAt(start)] > 1) 
                        curr_count[str.charAt(start)]--; 
                    start++; 
                } 
  
                // Update window size 
                int len_window = j - start + 1; 
                if (min_len > len_window) { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
        // Return substring starting from start_index 
        // and length min_len 
        return str.substring(start_index, start_index + min_len); 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        String str = "aabcbcdbca"; 
        System.out.println("Smallest window containing all distinct"
                           + " characters is: " + findSubString(str)); 
    } 
}
