/*

On a sunny day, Akbar and Birbal were taking a leisurely walk in palace gardens. Suddenly, Akbar noticed a bunch of sticks on the ground 
and decided to test Birbal's wits.

There are N stick holders with negligible size (numbered 1 through N) in a row on the ground. Akbar places all the sticks in them vertically;
for each valid i, the initial height of the stick in the i-th holder is Ai. Birbal has a stick cutter and his task is to completely cut all 
these sticks, i.e. reduce the heights of all sticks to 0. He may perform zero or more operations; in each operation, he should do the following:

Choose an integer H and fix the cutter at the height H above the ground.
The cutter moves from the 1-st to the N-th stick holder. Whenever it encounters a stick whose current height is greater than H, it cuts this 
stick down to height H (i.e. for a stick with height h>H, it removes its upper part with length h−H).
All the upper parts of sticks that are cut in one operation must have equal lengths. Otherwise, the operation may not be performed.
For example, if the heights of sticks are initially [5,3,5], then some valid values for H in the first operation are 3 and 4 ― the cutter
cuts the upper parts of two sticks and their lengths are [2,2] and [1,1] respectively. H=2 is an invalid choice because it would cut the 
upper parts of all three sticks with lengths [3,1,3], which are not all equal.

Akbar wants Birbal to completely cut all sticks in the minimum possible number of operations. If you want to be friends with Birbal, 
help him solve the problem.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer ― the minimum number of operations needed to completely cut all the sticks.

Constraints
1≤T≤50
1≤N≤105
0≤Ai≤109 for each valid i
Subtasks
Subtask #1 (20 points): N≤50
Subtask #2 (80 points): original constraints

Example Input
1
3
1 2 3
Example Output
3
Explanation
Example case 1: Birbal may perform the following three operations:

Fix the cutter at H=2. The heights of the sticks after this operation are [1,2,2].
Fix the cutter at H=1. The heights of the sticks after this operation are [1,1,1].
Fix the cutter at H=0. After this operation, all sticks are completely cut.
*/


import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try{
    		FastReader sc=new FastReader(); 
    		int t = sc.nextInt();
    		while(t-->0){
    		    int n = sc.nextInt();
    		    HashSet<Long> hs = new HashSet<Long>();
    		    //ong arr[] = new long[n];
    		    for(int i=0;i<n;i++){
    		        hs.add(sc.nextLong());
    		    }
    		    if(hs.size()==1 && hs.contains(0l)){
    		        System.out.println(0);
    		    } else if(hs.contains(0l)){
    		        System.out.println(hs.size()-1);
    		    } else {
    		        System.out.println(hs.size());
    		    }
    		}
		}
		catch(Exception e){}
	}
}
