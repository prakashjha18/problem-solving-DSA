/*
Given an array of n positive integers and a number k. Find the minimum number of swaps 
required to bring all the numbers less than or equal to k together.

Input:
The first line of input contains integer T denoting the number of test cases. For each
test case,  the first line of input contains an integer n denoting the size of the array.
Next line contains n space separated integers denoting the elements of the array. Next line 
contains an integer k denoting the number such that elements less than and equal to k are group together. 

Output:
For each test case, the output is an integer displaying the minimum swaps required.

Constraints:
1<=T<=100
1<=n<=50

Example:
Input
2
5
2 1 5 6 3
3
7
2 7 9 5 8 7 4
6
Output
1
2

Explanation:
1. To bring elements 2, 1, 3 together, swap element '5' with '3' such that final array will be- arr[] = {2, 1, 3, 6, 5}
2. To bring elements 2, 5, 4 together, swap element 7 with 5 & 9 with 4 such that the final array will be {2,5,4,7,8,7,9}   

*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int minSwap(int arr[], int n, int k) { 
        int count = 0;
        for(int i=0;i<n;i++)
            if(arr[i]<=k)
                count++;
        
        int bad = 0;
        for(int i=0;i<count;i++)
            if(arr[i]>k)
                bad++;
                
        int ans = bad;
        
        for(int i=0,j=count;j<n;i++,j++){
            if(arr[i]>k)
                bad--;
            
            if(arr[j]>k)
                bad++;
            
            ans = Math.min(ans, bad); 
        }
        return ans;
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		    System.out.println(minSwap(arr, n, k));
		}
	}
}
