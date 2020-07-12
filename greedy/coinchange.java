/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static void coinChangeProblem(int [] coins, int N) {
	    
		//Arrays.sort(coins);//Sort the coins in ascending order
		int index = coins.length-1;
		while(true){
		   	int coinValue = coins[index];
			index--;
			int maxAmount = (N/coinValue)*coinValue;
			if(maxAmount>0) {
			    int c = (N/coinValue);
			    while(c-->0)
	    	        System.out.print(coinValue+" ");
	    	    N = N - maxAmount;
			}
	        if(N==0)break;
		}
	}
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int [] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
		int t = sc.nextInt();
		while(t-->0){
		    int amount = sc.nextInt();
		    coinChangeProblem(coins, amount);
		    System.out.println();
		}
	}
}
