/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    for(int i =0;i<n;i++)
		        arr1[i] =sc.nextInt();
		    for(int i =0;i<m;i++)
		        arr2[i] =sc.nextInt();
		    util(arr1,arr2);
		}
	}
	public static void util(long arr1[],long arr2[]){
	    HashSet<Long> st = new HashSet<>();
	    for(long ar:arr2){
	        st.add(ar);
	    }
	    for(int i=0;i<arr1.length;i++){
	        if(!st.contains(arr1[i])){
	            System.out.print(arr1[i]+" ");
	        }
	    }
	    System.out.println();
	}
}
