/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    int brr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        brr[i] = arr[i];
 		    }
		    Arrays.sort(arr);
		    HashMap<Integer,Integer> hm = new HashMap<>();
		    for(int i=0;i<n;i++){
		        hm.put(arr[i],i);
		    }
		    for(int i=0;i<n;i++){
		        System.out.print(hm.get(brr[i])+" ");
		    }
		    System.out.println();
		}
	}
}
