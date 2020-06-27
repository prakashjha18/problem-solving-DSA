/*package whatever //do not write package name here */
Given an array A[ ] denoting the time taken to complete N tasks, determine the minimum
// amount of time required to finish the tasks considering that you can skip any task, but 
// skipping two consecutive tasks is forbidden.
 

// For example 
// For the array arr [] = {10, 5, 2, 4, 8, 6, 7, 10}
// the output will be  22  (Skip the tasks taking more time ,avoiding consective 
// skipping(10,8,10). Tasks done in: 5+2+4+6+7)
 

// Input
// The first line of input contains an integer T denoting the number of test cases. 
// Then T test cases follow. 
// The first line of each test case contains a positve integer N, denoting the length
// of the array A[ ].
// The second line of each test case contains a N space seprated positve integers,
// denoting the elements of the array A[ ].


// Output
// Print out the minimum time taken to complete the tasks.
 

// Constraints
// 1 <= T <= 100
// 0 <   N <= 30
// 0 <= A[ ] <= 1000
 

// Examples 

// Input
// 4
// 4
// 10 5 7 10
// 6
// 5 6 7 8 9 10
// 2
// 10 20
// 5
// 22 10 15 3 5

// Output
// 12
// 21
// 10
// 13

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(getdy(a));
        }
	}
	public static int getdy(int[] a){
	    if(a.length==1)
	        return 0;
	    if(a.length==2)
	        return Math.min(a[0],a[1]);
	    int dp[] = new int[a.length + 2]; // '+1' to handle the zero house
		dp[0] = a[0]; // if there are no houses, the thief can't steal anything
		dp[1] = a[1];
		for (int i = 2; i <a.length ; i++) {
			dp[i] = a[i]  + Math.min(dp[i-1],dp[i-2]);
		}
		return Math.min(dp[a.length-1],dp[a.length-2]);
	}
}
