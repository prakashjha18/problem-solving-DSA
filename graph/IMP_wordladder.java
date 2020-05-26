// { Driver Code Starts
//Initial Template for Java
//     Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time.
// Each transformed word must exist in the word list.
// Note:

// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:

// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output: 5

// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
// Example 2:

// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// Output: 0

// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t>0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    Set<String> s = new HashSet<>();
		    for(int i=0;i<n;i++)
		    {
		        String words = br.readLine().trim();
		        s.add(words);
		    }
			String start = br.readLine().trim();
			String target = br.readLine().trim();
			Solution T = new Solution();
			System.out.println(T.wordLadderLength(start,target,s));
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java


public class Solution {
    public int wordLadderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        if(!wordList.contains(endWord)) return 0;
        
        int len = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (  wordList.contains(target)) {
                            temp.add(target);
                            wordList.remove(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
