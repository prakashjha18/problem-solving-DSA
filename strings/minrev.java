/*package whatever //do not write package name here */
/*
Given a string S consisting only of opening and closing curly brackets '{' and '}' find out the
minimum number of reversals required to make a balanced expression.

Input
The first line of input contains an integer T, denoting the number of test cases. Then T test cases
follow. The first line of each test case contains a string S consisting only of { and }.

Output
Print out minimum reversals required to make S balanced. If it cannot be balanced, then print -1.

Constraints
1 <= T <= 100
0 <= |S| <= 50

Examples
Input
4
}{{}}{{{
{{}}}}
{{}{{{}{{}}{{
{{{{}}}}

Output
3
1
-1
0

Explanation:
Testcase 1: For the given string }{{}}{{{ since the length is even we just need to count the
number of openning brackets('{') suppose denoted by 'm' and closing brackest('}') suppose
dentoed by 'n' after removing highlighted ones. After counting compute ceil(m/2) + ceil(n/2).
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class minrev {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    String ip = sc.next();
		    int len = ip.length(); 
            if (len%2 != 0) {
                System.out.println(-1);
            } else {
                Stack<Character> s=new Stack<>(); 
                for(int i=0;i<len;i++){
                    char c = ip.charAt(i);
                    if(c=='}' && !s.empty()){
                        if(s.peek()=='{'){
                            s.pop();
                        } else {
                            s.push(c);
                        }
                    } else {
                        s.push(c);
                    }
                }
                double n = 0; 
                double m=0;
                while (!s.empty()) 
                { 
                    char ch = s.pop();
                    if(ch=='{'){
                        m++;
                    } else{
                        n++;
                    }
                } 
                
                int bm = (int)Math.ceil(m/2);
                int bn = (int)Math.ceil(n/2);
                System.out.println(bm+bn);
            }
            
		}
	}
}
