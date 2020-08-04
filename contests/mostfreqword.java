/*package whatever //do not write package name here */
/*Given an array containing N words consisting of lowercase characters. Your task is to find the most frequent
word in the array. If multiple words have same frequency, then print the word that comes last in the array.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test case f
ollows. Each test case contains 2 lines, the size of array N and N words separated by spaces.

Output:
For each testcase, output the most frequent word.

Constraints:
1 <= T <= 100
1 <= N <= 1000

Example:
Input:
3
3
geeks for geeks
2
hello world
3
world wide fund

Output:
geeks
world
fund

Explanation:
Testcase 1: "geeks" comes 2 times.
Testcase 2: "hello" and "world" both have 1 frequency. We print world as it comes last in the input array. */
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n=Integer.parseInt(br.readLine().trim());
		    String[] str=br.readLine().trim().split(" ");
		    HashMap<String, Integer> map=new HashMap<String, Integer>();
		    String res="";
		    int max=0;
		    for(int i=n-1;i>=0;i--){
		        String s=str[i];
		        if(map.containsKey(s)){
		            map.put(s, map.get(s)+1);
		        }else{
		            map.put(s, 1);
		        }
		        if(map.get(s)>max){
		            max=map.get(s);
		            res=s;
		        }
		    }
		    System.out.println(res);
		}
	}
}
