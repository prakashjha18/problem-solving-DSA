// { Driver Code Starts
//Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

// Input:
// The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the length of string. The second line contains a string S of length N, consisting of uppercase and lowercase characters.

// Output:
// For each testcase, in a new line, print the answer.

// Your Task:
// This is a function problem. You only need to complete the function caseSort that returns sorted string.

// Expected Time Complexity: O(N*Log(N)).
// Expected Auxiliary Space: O(N).

// Constraints:
// 1 ≤ T ≤ 50
// 1 ≤ N ≤ 103

// Example:
// Input:
// 2
// 12
// defRTSersUXI
// 6
// srbDKi
// Output:
// deeIRSfrsTUX
// birDKs

// Explanation:
// Testcase 1: Sorted form of given string with the same case of character as that in original string.
// Testcase 2: Sorted form of given string with the same case of character will result in output as
import java.util.*;
import java.lang.*;
import java.io.*;


 // } Driver Code Ends


class solve{
    public static String caseSort(String str) {
        // Your code here
        ArrayList<Character> v1 = new ArrayList<Character>();
        ArrayList<Character> v2 = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++)  
        { 
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') 
                v1.add(str.charAt(i)); 
  
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'z') 
                v2.add(str.charAt(i)); 
        } 
        Collections.sort(v1); 
        Collections.sort(v2); 
        StringBuilder s1 = new StringBuilder();
        int i = 0, j = 0; 
        //System.out.print(v2);
        for (int k = 0; k < str.length(); k++) 
        { 
            if (str.charAt(k) >= 'a' && str.charAt(k) <= 'z') 
            { 
                s1.append(v1.get(i));
                ++i; 
            } 
  
            // Else pick the uppercase character 
            else if (str.charAt(k) >= 'A' && str.charAt(k) <= 'Z') 
            { 
                s1.append(v2.get(j));
                ++j; 
            } 
        }
        return s1.toString();
    }
}

// { Driver Code Starts.

class GFG {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new solve().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
  // } Driver Code Ends
