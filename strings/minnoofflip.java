/*package whatever //do not write package name here */
/*
Given a binary string, that is it contains only 0s and 1s. We need to make this 
string a sequence of alternate characters by flipping some of the bits, our goal is to
minimize the number of bits to be flipped.
Examples:

Input : str = “001”
Output : 1
Minimum number of flips required = 1
We can flip 1st bit from 0 to 1 

Input : str = “0001010111”
Output : 2
Minimum number of flips required = 2
We can flip 2nd bit from 0 to 1 and 9th 
bit from 1 to 0 to make alternate 
string “0101010101”.
Input:

The first line of input contains a single integer T denoting the number of test cases. 
Then T test cases follow. Each test case consists of one line. The line contains a string of 0's and 1's.

Output:

Minimum number of characters to be removed to make string alternate.

Constraints:

1 ≤ T ≤ 100
1 ≤ string length ≤ 1000

Example:

Input
2
01010
1111

Output
0
2

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int getFlipWithStartingCharcter(String str,char expected){
        int flipcount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=expected)
                flipcount++;
            expected = (expected=='0') ? '1':'0';
        }
        return flipcount;
    }
    public static int minFlipToMakeStringAlternate(String str){
        return Math.min(getFlipWithStartingCharcter(str, '0'), 
            getFlipWithStartingCharcter(str, '1'));
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String str = sc.next();
		    System.out.println(minFlipToMakeStringAlternate(str)); 
		}
	}
}
