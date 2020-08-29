/*
Chef organised a chess tournament, which spanned over M months. There were N players, and 
player i was rated Ri before the start of the tournament. To see the progress of the players,
he noted their rating changes at the end of each month.

After the tournament, FIDE asked Chef to find the number of players whose peak rating and peak
ranking did not occur in the same month. In other words, Chef was asked to find the ratings and 
ranking of each player after each of the M months. Then, using this data, he should find the 
number of players, such that the month in which they achieved their highest rating over all
the months, was different from the month in which they achieved their best rank 
(based on ratings), over all the months. Note that we do not consider the initial rating/ranking,
but only the rating and rankings after each of the M months.

For a particular player, if there are multiple peak rating or peak ranking months, Chef was 
to consider the earliest of them. If multiple players had the same rating at the end of some 
month, they were to be given the same rank. For example, if there were 5 players, and their 
ratings at the end of some month were (2600, 2590, 2600, 2600 and 2590), players 1, 3 and 4 
were to be given the first rank, while players 2 and 5 should be given the fourth rank.

As Chef hates statistics, he asks you, his friend, to help him find this. Can you help Chef?

Input:
The first line contains an integer T, the number of test cases.
The first line of each test case contains two space-separated integers N and M, the number of 
players and the number of months that the tournament spanned over.
The second line of each test case contains N space-separated integers, R1,R2,…,RN denoting the 
initial ratings of the players, i.e., their ratings before the start of the tournament.
The next N lines each contain M space-separated integers. The jth integer of the ith line, Ci,j
denotes the rating change of the ith player after the jth month.
Output:
For each test case, print the number of players whose peak ratings did not occur in the same 
month as their peak ranking, in a new line.

Constraints
1≤T≤10
1≤N,M≤500
1800≤Ri≤2800
−20≤Ci,j≤20
Subtasks
30 points : 1≤N,M≤50
70 points : Original constraints.
Sample Input:
2
3 3
2500 2500 2520
10 -5 -20
10 15 20
-15 17 13
2 3
2125 2098
-20 10 -10
10 10 -20
Sample Output:
2
2
Explanation:
Test case 1:

The ratings for player 1 after each month are: (2510, 2505 and 2485), while his rankings 
are first, third and third, respectively. Thus, his best rating and best ranking occur after 
the same month, i.e., after the first month.

The ratings for player 2 after each month are: (2510, 2525 and 2545), while his rankings are 
first, first and first, respectively. His best rating occurs after the third month, while his
best ranking occurs after the first month (we consider the first month even though his peak 
ranking is over all the months, because we consider only the earliest month where he attains 
the peak ranking).

The ratings for player 3 after each month are: (2505, 2522 and 2535), while his rankings are 
third, second and second, respectively. His best rating occurs after the third month, while his 
best ranking occurs after the second month.

So there are two players (2 and 3), whose peak ratings did not occur in the same month as their 
peak ranking, and hence the answer is 2.

Test case 2:

The ratings for player 1 after each month are: (2105, 2115 and 2105), while his rankings are
second, second and first, respectively. Best rating is after second month, but best ranking is
after third month.

The ratings for player 2 after each month are: (2108, 2118 and 2098), while his rankings are 
first, first and second, respectively. Best rating is after second month, but best ranking is
after first month.

So there are two players (1 and 2), whose peak ratings did not occur in the same month as
their peak ranking, and hence the answer is 2.

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
    		    //System.out.println("____________");
    		    int n=sc.nextInt();
    		    int m=sc.nextInt();
    		    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    		    ArrayList<Integer> plrat = new ArrayList<Integer>();
    		    ArrayList<Integer> plscor = new ArrayList<Integer>();
    		    for(int i=0;i<n;i++){
    		        plrat.add(0);
    		        plscor.add(sc.nextInt());
    		        arr.add(new ArrayList<Integer>());
    		    }
    		    for(int i=0;i<n;i++){
    		        int max = Integer.MIN_VALUE;
    		        int gt = plscor.get(i);
    		        for(int j=0;j<m;j++){
    		            int x = sc.nextInt();
    		            gt = gt+x;
    		            arr.get(i).add(gt);
    		            //plscor.set(i,gt );
    		            if(gt>max){
    		                max=gt;
    		                plrat.set(i,j);
    		            }
    		        }
    		    }
    		    int [][] scor = new int[n][m];
    		    for(int j=0;j<m;j++){
    		        ArrayList<Integer> plrank = new ArrayList<Integer>();
    		        Map<Integer, Integer> hm = 
                            new HashMap<Integer, Integer>(); 
    		        for(int i=0;i<n;i++){
    		            plrank.add(arr.get(i).get(j));
    		        }
    		        Collections.sort(plrank,Collections.reverseOrder());
    		        for(int i=0;i<n;i++){
    		            if(!hm.containsKey(plrank.get(i))){
    		                hm.put(plrank.get(i),i);
    		            }
    		        }
    		        //System.out.print(plrank+ "  "+hm);
    		        for(int i=0;i<n;i++){
    		            scor[i][j] = hm.get(arr.get(i).get(j));
    		        }
    		    }
    		    //System.out.println(plrat);
    		    //System.out.println();
    		    int count = 0;
    		    for(int i=0;i<n;i++){
    		        int lowest = -1;
    		        int val = Integer.MAX_VALUE;
    		        for(int j=0;j<m;j++){
    		            //System.out.print(scor[i][j]+" ");
    		            if(scor[i][j]<val){
    		                val=scor[i][j];
    		                lowest = j;
    		            }
    		            
    		        }
    		        //System.out.print(lowest+"  ");
    		        if(lowest!=plrat.get(i)){
    		            count++;
    		        }
    		        //System.out.println();
    		    }
    		    System.out.println(count);
    		}
		}
		catch(Exception e){}
	}
}
