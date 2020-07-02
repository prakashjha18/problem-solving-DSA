// Given a pattern containing only I's and D's. I for increasing and D for decreasing.
// Devise an algorithm to print the minimum number following that pattern.
// Digits from 1-9 and digits can't repeat.

// Input:
// The first line of input contains an integer T denoting the number of test cases.
// The first line of each test case is a string, which contains only I's and D's in capital letter.

// Output:
// Print the minimum number following that pattern.

// Constraints:
// 1 ≤ T ≤ 100
// 1 ≤ Length of String ≤ 8

// Example:
// Input
// 5
// D
// I
// DD
// IIDDD
// DDIDDIID

// Output
// 21
// 12
// 321
// 126543
// 321654798

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static void PrintMinNumberForPattern(String seq) { 
	    StringBuilder sb = new StringBuilder();
	    Stack<Integer> stk = new Stack<Integer>(); 
	    for(int i=0;i<=seq.length();i++){
	        stk.push(i+1);
	        if(i==seq.length() || seq.charAt(i)=='I'){
	            while (!stk.empty()) {  
                sb.append(String.valueOf(stk.pop()));
                } 
	        }
	    }
	    System.out.println(String.valueOf(sb));
	}
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
		    String str = sc.next();
		    PrintMinNumberForPattern(str);
		}
	}
}
