/*package whatever //do not write package name here */
/*Given a postfix expression string str containing non-negative numbers and question marks(?). 
The task is to find the maximum number obtained by evaluating postfix espression. While evaluating 
the expression you can only replace '?' with '+' or '*' operators to calculate the number.

Input:
First line of input contains T, number of test cases. For each test case, the only line contains postfix expression.

Output:
For each test case, output the maximum number obtained.

Constraints:
1 <= T <= 100
1 <= |str| <= 1000

Example:
Input:
2
2 3 1 ? ? 9 ?
0 2 ?

Output:
63
2

Explanation:
Testcase 1: Maximum of (12+5, 12*5) gives 60, further evaluating last ? on 60 gives 360 i.e.max(60+6, 60*6).
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
	        String str = br.readLine().trim();
	        //System.out.println(str);
	        Queue<Integer> st = new LinkedList<Integer>();
	        for(int i=0;i<str.length();i+=2){
	            if(str.charAt(i)!='?'){
	                st.add(str.charAt(i)-'0');
	                //System.out.print((str.charAt(i)-'0')+"  ");
	            }
	            else{
	                int a=st.poll();
	                int b=st.poll();
	                int res =Math.max((a+b),(a*b));
	                //System.out.print(res+" ");
	                st.add(res);
	            }
	        }
	        System.out.println(st.poll());
        }
	}
}
