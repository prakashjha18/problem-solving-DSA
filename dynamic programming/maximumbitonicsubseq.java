/*package whatever //do not write package name here */
// Given an array of integers A. A subsequence of A is called Bitonic if it 
// is first increasing then decreasing.

// Input:
// The first line contains an integer T denoting the no of test cases. 
// Each test case consist of two lines. The first line contains an integer N 
// denoting the size of the array. Then in the next line are N space separated 
// values of the array A[].

// Output:
// For each test case in a new line print the max sum bitonic subsequence.

// Constraints:
// 1<=T<=100
// 1<=N<=50
// 1<=A[]<=100

// Example:
// Input:
// 2
// 6
// 80 60 30 40 20 10
// 9
// 1 15 51 45 33 100 12 18 9

// Output:
// 210
// 194

// Explanation:
// Testcase2:
// Input : A[] = {1, 15, 51, 45, 33, 100, 12, 18, 9}
// Output : 194
//  Bi-tonic Sub-sequence are :
// {1, 51, 9}
// {1, 50, 100, 18, 9}
// {1, 15, 51, 100, 18, 9}
// {1, 15, 45, 100, 12, 9}
// {1, 15, 45, 100, 18, 9} .. so on           
// Maximum sum Bi-tonic sub-sequence is 1 + 15 + 51 + 100 + 18 + 9 = 194  
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
	    int incseq[] =  new int[a.length];
	    int decseq[] =  new int[a.length];
	    for(int i=0;i<a.length;i++){
	        incseq[i] =a[i];
	        decseq[i] =a[i];
	    }
	    int n=a.length;
	    for (int i = 1; i < n; i++) 
            for (int j = 0; j < i; j++) 
                if (a[i] > a[j] && (a[i] + incseq[j])>incseq[i]) 
                    incseq[i] = a[i] + incseq[j];
       
        for (int i = n-2; i >= 0; i--) 
            for (int j = n-1; j > i; j--) 
                if (a[i] > a[j] && (a[i] + decseq[j])>decseq[i])
                    decseq[i] = a[i] + decseq[j];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
	        int x =incseq[i]+decseq[i]-a[i];
	        if (max <x) max =x;
	    }
	    return max;
  
	}
}
