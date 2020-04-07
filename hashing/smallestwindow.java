// Input:
// First line of the input contains an integer T, denoting the number of test cases. Then T test case follows. Each test contains 2 lines having a string S and next line contains text P.

// Output:
// Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.

// Your Task:
// You only need to complete the function smallestWindow that returns smallest window of the string containing all the characters of the text. Else return "-1".

// Constraints:
// 1 <= T <= 100
// 1 <= S.length, P.length <= 1000

// Example:
// Input:
// 2
// timetopractice
// toc
// zoomlazapzo
// oza
// Output:
// toprac
// apzo

// Explanation:
// Testcase 1: toprac is the smallest subset in which toc can be found.
// Testcase 2: To find oza in the zoomlazapzo the smallest subset is apzo.
// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class smallestwindow {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new solve().smallestWindow(s, t));
		    test--;
		}
	}
}// } Driver Code Ends

class solve
{
    public static String smallestWindow(String str, String pat){
        int no_of_chars = 256; 
        int len1 = str.length(); 
        int len2 = pat.length(); 
        if (len1 < len2) 
        { 
            return "-1"; 
        } 
      
        int hash_pat[] = new int[no_of_chars]; 
        int hash_str[] = new int[no_of_chars]; 
      
        for (int i = 0; i < len2; i++) 
            hash_pat[pat.charAt(i)]++; 
      
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE; 
        int count = 0; 
        
        for (int j = 0; j < len1 ; j++) 
        { 
            hash_str[str.charAt(j)]++; 
            if (hash_pat[str.charAt(j)] != 0 && 
                hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] ) {
                count++; 
                //System.out.print(str.charAt(j)+""+j+"__");
                }
            if (count == len2) 
            { 
                while ( hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] 
                    || hash_pat[str.charAt(start)] == 0) 
                { 
                   // System.out.print(start+""+j+"--");
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) 
                        hash_str[str.charAt(start)]--; 
                    start++; 
                } 
      
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
      
        if (start_index == -1) 
        { 
        return "-1"; 
        } 
        return str.substring(start_index, start_index + min_len); 
    }
}
