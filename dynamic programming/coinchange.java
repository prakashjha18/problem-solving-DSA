// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    int value=sc.nextInt();
		    int numberOfCoins=sc.nextInt();
		    int coins[]=new int[numberOfCoins];
		    
		    for(int i=0;i<numberOfCoins;i++)
		    {
		        int x=sc.nextInt();
		        coins[i]=x;
		    }
		    Geeks obj=new Geeks();
		    long answer=obj.minimumNumberOfCoins(coins,numberOfCoins,value);
		    System.out.println(answer==Integer.MAX_VALUE?"Not Possible":answer);
		}
	}
}


 // } Driver Code Ends




class Geeks
{
    //Complete this function
    public long minimumNumberOfCoins(int coins[],int m,int V)
    {
        // table[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // table[V] will have result 
        int table[] = new int[V + 1]; 
  
        // Base case (If given value V is 0) 
        table[0] = 0; 
  
        // Initialize all table values as Infinite 
        for (int i = 1; i <= V; i++) 
        table[i] = Integer.MAX_VALUE; 
  
        // Compute minimum coins required for all 
        // values from 1 to V 
        for (int i = 1; i <= V; i++) 
        { 
            // Go through all coins smaller than i 
            for (int j = 0; j < m; j++) 
            if (coins[j] <= i) 
            { 
                int sub_res = table[i - coins[j]]; 
                if (sub_res != Integer.MAX_VALUE  
                       && sub_res + 1 < table[i]) 
                       table[i] = sub_res + 1; 
                         
                  
            }
            // for(int ii=0;ii<table.length;ii++){
            //     System.out.print(table[ii]+" ");
            // }
            // System.out.println();
        } 
        return table[V];
    }
}

// { Driver Code Starts.

  // } Driver Code Ends
