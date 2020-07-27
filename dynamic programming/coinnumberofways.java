// { Driver Code Starts
//Initial Template for Java
// You have an infinite supply of coins, each having some value. Find out the number of
// ways to use the coins to sum-up to a certain required value.

// Input Format:
// The first line of input contains the number of test cases. The number of test cases follows. 
// Each testcase contains three lines of input. The first line contains the value for which you 
// need to make the change. The second line contains the size of the array. The third line contains 
// the denominations of the coins.

// Output Format:
// For each testcase, in a new line, print the number of ways.

// Your Task:
// This is a function problem where you've to complete the funcion numberOfWays (). You are given 
// an amount denoted by value. You are also given an array of coins. The array contains the denominations 
// of the given coins. You need to return the number of ways you can make the change for value using the 
// coins of given denominations. Also, keep in mind that you have an infinite supply of coins.

// Expected Time Complexity: O(Number of Coins * Value).
// Expected Auxiliary Space: O(Value).

// Constraints:
// 1 <= T <= 100
// 1 <= value <= 103
// 1 <= numberOfCoins <= 103
// 1 <= coinsi <= 1000

// Example:
// Input:
// 2
// 4
// 3
// 1 2 3
// 10
// 4
// 2 5 3 6
// Output:
// 4
// 5

// Explanation:
// Testcase1: We need to make the change for value = 4
// The denominations are {1,2,3}
// Change for 4 can be made:
// 1+1+1+1
// 1+1+2
// 1+3
// 2+2
// So, as it is evident, we can do this in 4 ways.

/*package whatever //do not write package name here */

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
		    System.out.println(obj.numberOfWays(coins,numberOfCoins,value));
		}
	}
}



 // } Driver Code Ends
class Geeks
{
    //Complete this function
    public long numberOfWays(int coins[],int numberOfCoins,int value)
    {
        long ways[]=new long[value+1];
        ways[0]=1;
        for(int coin:coins){
            for(int i=1;i<value+1;i++){
                if(i>=coin){
                    ways[i] += ways[i-coin];
                }
                
            }
            // for(long x:ways) System.out.print(x+" ");
            // System.out.println();
        }
        return ways[value];
    }
}

// { Driver Code Starts.

  // } Driver Code Ends
