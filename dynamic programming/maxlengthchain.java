// You are given N pairs of numbers. In every pair, the first number is always smaller than the second number.
// A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion.
// Your task is to complete the function maxChainLen which returns an integer denoting the 
// longest chain which can be formed from a given set of pairs. 
// Input
// 2
// 5
// 5  24 39 60 15 28 27 40 50 90
// 2
// 5 10 1 11 
// Output
// 3
// 1
// Explanation
// (i) the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },the longest chain 
// that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}
// (ii) The max length chain possible is only of length one.


// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
               arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}
// } Driver Code Ends


/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

class GfG
{
    // GREEDY ALGORITHM
    class CompareByFirstN implements Comparator<Pair>
    {
      public int compare(Pair a, Pair b)
        {
            return a.y - b.y;
        }
    }
    
    int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, new CompareByFirstN());
        int index=0;
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[index].y<arr[i].x){
                count++;
                index=i;
            }
        }
        return count;
      // your code here
    }
    //DYNAMIC PROGRAMMING
    // int maxChainLength(Pair arr[], int n){
        
    //     int i, j, max = 0; 
    //   int mcl[] = new int[n]; 
       
    //   /* Initialize MCL (max chain length) values for all indexes */
    //   for ( i = 0; i < n; i++ ) 
    //       mcl[i] = 1; 
       
    //   /* Compute optimized chain length values in bottom up manner */
    //   for ( i = 1; i < n; i++ ) 
    //       for ( j = 0; j < i; j++ ) 
    //          if ( arr[i].x > arr[j].y && mcl[i] < mcl[j] + 1) 
    //             mcl[i] = mcl[j] + 1; 
       
    //   // mcl[i] now stores the maximum chain length ending with pair i 
       
    //   /* Pick maximum of all MCL values */
    //   for ( i = 0; i < n; i++ ) 
    //       if ( max < mcl[i] ) 
    //          max = mcl[i]; 
       
    //   return max; 
    // }
    
    
    
}
