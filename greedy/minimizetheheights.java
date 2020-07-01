/*package whatever //do not write package name here */

// Question statement itself is confusing
// you have to minimise the difference between highest and smallest tower and then print 
// the maximum difference after performing addtion/subtraction ONCE!!
// Given an array A[ ] denoting heights of N towers and a positive integer K, modify
// the heights of each tower either by increasing or decreasing them by K only once and 
// then find out the minimum difference of the heights of shortest and longest towers.

// Example

// Input  : A[] = {1, 15, 10}, k = 6
// Output : 5
// Explanation : We change 1 to 7, 15 to 
// 9 and 10 to 4. Maximum difference is 5
// (between 4 and 9). We can't get a lower
// difference.

// Input
// The first line of input contains an integer T denoting the number of test cases. Then 
// T test cases follow. The first line of each test case contains a positive integer K. 
// The second line of each test case contains a positive integer N, denoting number of towers.
// The third line of the test cases contains N integers denoting the heights of N towers.

// Output
// For each test case in new line print out the minimum difference of heights possible.

// Constraints
// 1 <= T <= 100
// 0 <   K <= 30
// 0 <   N <= 30
// 0 <= A[i] <= 500


// Examples 
// Input
// 3
// 2
// 4
// 1 5 8 10
// 3
// 5
// 3 9 12 16 20
// 4
// 6
// 100 150 200 250 300 400

// Output
// 5
// 11
// 292

// Explanation:
// Test Case 1: arr[] = {1, 5, 8, 10}. k = 2
// The array can be modified as: {3, 3, 6, 8}. The difference between the largest and the 
// smallest is 8-3 = 5. We can't have a difference less than this.
// Test Case 2: arr[] = {3 9 12 16 20}. k = 3
// The array can be modified as: {6 12 9 13 17}. The difference between the largest and the 
// smallest is 17-6 = 11. 
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int getMinDiff(int arr[], int n, int k) 
    {
        if (n == 1) 
        return 0; 
  
        // Sort all elements 
        Arrays.sort(arr); 
  
        // Initialize result 
        int ans = arr[n-1] - arr[0]; 
  
        // Handle corner elements 
        int small = arr[0] + k; 
        int big = arr[n-1] - k; 
        int temp = 0; 
          
        if (small > big) 
        { 
            temp = small; 
            small = big; 
            big = temp; 
        } 
  
        // Traverse middle elements 
        for (int i = 1; i < n-1; i ++) 
        { 
            int subtract = arr[i] - k; 
            int add = arr[i] + k; 
  
            // If both subtraction and addition 
            // do not change diff 
            if (subtract >= small || add <= big) 
                continue; 
            //System.out.print(subtract+"  "+add+"__");
            // Either subtraction causes a smaller 
            // number or addition causes a greater 
            // number. Update small or big using 
            // greedy approach (If big - subtract 
            // causes smaller diff, update small 
            // Else update big) 
            if (big - subtract <= add - small) 
                small = subtract; 
            else
                big = add; 
        } 
  
        return Math.min(ans, big - small); 
        
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-->0){
		    int k=sc.nextInt();
		    int n=sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] =sc.nextInt();
		    }
		    System.out.println(getMinDiff(arr, n, k)); 
		}
	}
}
