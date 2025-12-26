// There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

// You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.

// If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

// Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.

 

// Example 1:

// Input: words = ["wrt","wrf","er","ett","rftt"]
// Output: "wertf"
// Example 2:

// Input: words = ["z","x"]
// Output: "zx"
// Example 3:

// Input: words = ["z","x","z"]
// Output: ""
// Explanation: The order is invalid, so return "".
 

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists of only lowercase English letters.

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(String word : words){
            for(char c: word.toCharArray()){
                counts.put(c,0);
                adjList.put(c, new ArrayList<>());
            }
        }

        for(int i=0;i<words.length -1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            for(int j=0; j< Math.min(word1.length(),word2.length()); j++){
                Character char1 = word1.charAt(j);
                Character char2 = word2.charAt(j);
                if(char1 != char2){
                    adjList.get(char1).add(char2);
                    counts.put(char2, counts.get(char2)+1);
                    break;
                }
            }
         
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c : counts.keySet()){
            if(counts.get(c) == 0){
                queue.add(c);
            }
        }
        while(!queue.isEmpty()){
            Character node = queue.poll();
            sb.append(node);
            for(Character next: adjList.get(node)){
                counts.put(next,counts.get(next)-1);
                if(counts.get(next) == 0){
                    queue.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
        
    }
}