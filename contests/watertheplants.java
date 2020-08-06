// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int n = Integer.parseInt(sc.next());
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(sc.next());
            Solution T = new Solution();
            System.out.println(T.min_sprinklers(gallery,n));
        }
		
		
	}
}




// } Driver Code Ends

/*
A gallery with plants is divided into n parts, numbered : 0,1,2,3...n-1. There are provisions for attaching
water sprinklers at every partition. A sprinkler with range x at partition i can water all partitions from i-x to i+x.

Given an array gallery[ ] consisting of n integers, where gallery[i] is the range of sprinkler at partition 
i (power==-1 indicates no sprinkler attached), return the minimum number of sprinklers that need to be turned 
on to water the complete gallery.

If there is no possible way to water the full length using the given sprinklers, print -1.

Input:
First line of input holds the number of test cases t, then t test cases follow. In each test case, first line
holds the integer n. Second line of test case holds the n space separated integers representing the array gallery[ ].

Output:
Output should hold the minimum number of sprinklers that need to be turned on to water the complete length.

Your task:
Your task is to complete the function min_sprinklers() which takes the array gallery[ ] and the integer n as
input parameters and returns the value to be printed.

Constraints:
T <= 500
n <= 1000
gallery[i] <= 50

Example:
Input:
3
6
-1 2 2 -1 0 0
9
2 3 4 -1 2 0 0 -1 0
9
2 3 4 -1 0 0 0 0 0
Output:
2
-1
3
Explanation:
Testcase 1:
Sprinklers at index 2 and 5 can water the full gallery, span of sprinkler at index 2 = [0,4] and span of sprinkler 
at index 5 = [5,5]
Testcase 2:
No sprinkler can throw water at index 7. Hence all plants cannot be watered.
Testcase 3:
Sprinkler at indexes 2, 7 and 8 together can water all plants.
*/

//User function Template for Java

class Pair{
   int x;
   int y;
   public Pair(int x,int y)
   {
       this.x = x;
       this.y = y;
   }
}

class Solution
{
    int min_sprinklers(int gallery[], int n)
    {
        List <Pair> sprinklers = new ArrayList<>();
        for(int i=0; i<n; i++)
            if(gallery[i] > -1)
                sprinklers.add( new Pair( i-gallery[i], i+gallery[i] ) );
        
        Collections.sort(sprinklers, new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2)
            {
                return p1.x - p2.x;
            }
            
        });
        // for(Pair sprink : sprinklers){
        //     System.out.print(sprink.x+" "+sprink.y+"__");
        // }
        int target=0, sprinklers_on=0, i=0;
        while(target<n)
        {
            if(i==sprinklers.size() || sprinklers.get(i).x>target)
                return -1;
            
            int max_range = sprinklers.get(i).y;
            while( i+1<sprinklers.size() && sprinklers.get(i+1).x<=target )
            {
                i++;
                max_range = Math.max( max_range,  sprinklers.get(i).y );
            }
            if(max_range<target)
                return -1;
            
            sprinklers_on++;
            target = max_range +1;
            i++;
        }
        
        return sprinklers_on;
    }



}
