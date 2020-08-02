/*
We are given bracket sequence(may not be balanced). Every character of the sequence is either '(' or ')'.  
For each closing bracket, we need to find an opening bracket which is farthest from it (and on left of it) 
and pair those two brackets.
Once an opening bracket is paired with closing bracket, it can not be used again for any other closing bracket.
Traverse from left of the sequence and for each ')' you need to find the left-most '('. Do this for all the ')'.

Input: 
First line contains an integer T which deoted number of test cases. Next line of each test case contains 
string which consist of  '(' or ')' .

Output:
For each testcase, in a newline, print:

The count of total number of pairs in the first line.
The indices of opening and closing brackets (pairs) in subsequent lines. The indices are 0 based.
If the count is zero, just print the count as no pairs exist.

Constraints:
1 <= T <= 10
1 <= |S| <= 105
Example :
Input :
3
))((()
()()()
((()

Output :
1
2 5
3
0 1
2 3
4 5
1
0 3

Explanation:
Testcase1: The given sequence is ))((()
Only the last ')' has a '(' . Also the leftmost '(' for it is at the index 2. So the count is 1 and the indices are 
2(open) and 5(close).

Testcase2: The sequence is ()()(). The first ')' has leftmost '(' at 0 index. The second ')' has leftmost 
'(' at 2 index. The third ')' has leftmost '(' at 4 index. So total count is 3 and the indices are 0 1, 2 3, 4 5.

Testcase3: The sequence is (((). The first ')' is at 3 index. The leftmost '(' is at 0 index. So total count is 
1 and indices are 0 3
*/

import java.lang.*;
import java.util.*;
class GFG{
    public static void main (String[] args){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine().trim());
	while(t>0){
	    String a = br.readLine().trim();
	    Queue<Integer> q=new LinkedList<Integer>();
	    ArrayList<Integer> first=new ArrayList<Integer>();
	    ArrayList<Integer> second=new ArrayList<Integer>();
	    for(int i=0;i<a.length();i++){
	        if(a.charAt(i)=='('){
                q.add(i);
	        }
    	    else{
    	        if(!q.isEmpty()){
    	            first.add(q.remove());
    	            second.add(i);
    	        }
                }
	     }
	     System.out.println(first.size()); 
	     for(int i=0;i<first.size();i++){
	         System.out.println(first.get(i)+" "+second.get(i));
	     }
	     t--;
	 }
}
}
