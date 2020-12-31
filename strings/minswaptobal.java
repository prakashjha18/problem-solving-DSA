/*
You are given a string of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. 
A string is considered balanced if it can be represented in the for S2[S1] where S1 and S2
are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. 
Calculate the minimum number of swaps necessary to make a string balanced.

Input:

The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. The first line of each test case contains an integer N denoting 
the length of the string.

The second line of each test case contains the string consisting of '[' and ']'.

Output:

Print the minimum number of swaps to make the string balanced for each test case in a new line.


Constraints:

1<= T <=100

1<= N <=100000

 

Example:

Input  : []][][
Output : 2
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]

Input  : [[][]]
Output : 0
String is already balanced.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long swapCount(String s){
        List<Integer> pos = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '[')
                pos.add(i);
                
        int count = 0; 
     
        int p = 0;  
        
        long sum = 0; 

        char[] S = s.toCharArray(); 
        for(int i=0;i<S.length;i++){
            if(S[i]=='['){
                count++;
                p++;
            } else if(S[i]==']'){
                count--;
            }
            if(count<0){
                sum += pos.get(p) - i;
                char temp = S[i];
                S[i] = S[pos.get(p)];
                S[pos.get(p)] = temp;
                ++p;
                count = 1;
            }
        }
        return sum;
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    String s = sc.next();
		    System.out.println(swapCount(s));
		}
	}
}
