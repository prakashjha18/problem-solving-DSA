/*Given a string S of digits(0-9), your task is to find the maximum value that can be obtained from the string 
by putting either '*' or '+' operators in between the digits while traversing from left to right of the string 
and picking up a single digit at a time.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contans 
one line of input denoting the string.

Output:
For each testcase, print the maximum value obtained.

Constraints:
1 <= T <= 100
1 <= |S|< = 20
0 <= Digits <= 9

Example:
Input:
2
01230
891
Output:
9
73

Explanation:
Testcase1: we have 01230. We traverse from left and pick zero. Now we encounter 1. We see if 0*1 gives maximum 
or 0+1. Now we have ans as 1. Now we traverse further. We encounter 2. Now 1*2 gives max or 1+2. Now we have ans 3. 
Now we traverse further. We encounter 3. We see if 3*3 gives max or 3+3. The ans is now 9. Now we traverse fiurther. 
We encounter 0, we see  if 9+0 gives max or 9*0. The ans is now 9. We've traversed whole string so we stop.
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
		    String s1=sc.next();
		    long sum=0;
		    for(int i=0;i<s1.length();i++){
		        long x =Long.parseLong(String.valueOf(s1.charAt(i)));
		        sum=Math.max((sum*x),(sum+x));
		    }
		    System.out.println(sum);
		}
	}
}
