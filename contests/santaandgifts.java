/*This is the time of Christmas and Santa wants to distribute gifts to M children. He has N number of boxes,
and each box contains some chocolates. Now, Santa wants to distribute N boxes to M children keeping in mind 
that distribution should be as fair as possible. To fairly distribute the gift boxes, Santa wants to minimize 
the maximum number of choclates gifted to a child.

Formally, given M number of children and N boxes, where each box contains some amount of chocolates. The task 
is to minimize the maximum number of chocolate gifted to a child.

Input:
First line of input contains number of testcases T. For each testcase, there will be three lines of input. 
First line contains N number of gift boxes, next line contains choclates in each of the N boxes. Last line 
contains number of children.

Output:
For each testcase, print the minimum number of maximum chocolate a child get.

Constraints:
1 <= T <= 100
1 <= N, M <= 106
1 <= A[i] <= 108

Example:
Input:
1
4
12 34 67 200
3

Output:
200



For Input:
1
5
3 4 5 5 8
3
Your Output is:
10


Explanation:
Testcase 1: Minimum 200 chocolates will be given to a child which gets the maximum number of chocolate.

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s= new Scanner(System.in);
		int t=s.nextInt();
		while(t!=0){
		    int n=s.nextInt();
		    int []box= new int[n];
		    for(int i=0;i<n;i++){
		        box[i]=s.nextInt();
		    }
		    int m=s.nextInt();
		    System.out.println(minimise(box,n,m));
		    t--;
		}
		
	}
	
	public static int minimise(int []box, int n,int m){
	    int end=0;
	    
	    for(int i=0;i<n;i++){
	        end=end+box[i];
	    }
	    int start=box[n-1];
	    int result=start;
	    while(start<=end){
	        int mid=(start+end)/2;
	        //System.out.print(start+"  "+end+" "+mid+"  "+result+"__");
	        if(isPossible(box,mid,m)){
	            result=mid;
	            end=mid-1;
	        }else{
	            start=mid+1;
	        }
	    }
	    return result;
	}
	public static boolean isPossible(int []box,int ans,int m){
	    int count=1;
	   
	    int current_gift=0;
	    for(int i=0;i<box.length;i++){
	        
	         if(current_gift+box[i]>ans){
	               current_gift=box[i];
	               count++;
	               if(count>m){
	                   return false;
	               }
	         }else{
	             current_gift=current_gift+box[i];
	         }
	        
	       
	    }
	    return true;
	}
}
