/*package whatever //do not write package name here */
/*
Factorials of large numbers 
Medium Accuracy: 45.51% Submissions: 23944 Points: 4
Given an integer, the task is to find factorial of the number.
 
Input:
The first line of input contains an integer T denoting the number of test cases.  
The first line of each test case is N,the number whose factorial is to be found
 
Output:
Print the factorial of the number in separate line.
 
Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 1000
 
Example:
Input
3
5
10
2
 
Output
120
3628800
2

 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
    		int n = sc.nextInt();
    		//System.out.print(n);
    		int q=2;
    		int arr[] = new int[100000];
    		arr[0] = 1;
    		int len=1;
    		int x=0;
    		int num=0;
    		while(q<=n){
    		    x=0;
    		    num=0;
    		    while(x<len){
    		        arr[x] = arr[x] *q;
                    arr[x] = arr[x]+num;
                    num = arr[x]/10;
                    arr[x] = arr[x]%10;
                    x++;
    		    }
    		    
    		    while(num!=0)
                {
                    arr[len] = num%10;
                    num = num/10;
                    len++;
                }
                q++;
    		}
    		
    		len--;
            while(len>=0)
            {
                System.out.print(arr[len]);
                len = len-1;
            }
            System.out.println();
		}
	}
}
