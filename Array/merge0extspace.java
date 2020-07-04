/*package whatever //do not write package name here */
// Input: arr1[] = {10};
//       arr2[] = {2, 3};
// Output: arr1[] = {2}
//         arr2[] = {3, 10}  

// Input: arr1[] = {1, 5, 9, 10, 15, 20};
//       arr2[] = {2, 3, 8, 13};
// Output: arr1[] = {1, 2, 3, 5, 8, 9}
//         arr2[] = {10, 13, 15, 20} 

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void merge(int[] arr1,int m,int[] arr2,int n){
        for(int i=n-1;i>=0;i--){
          
            int j, last = arr1[m-1]; 
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--) 
                arr1[j+1] = arr1[j]; 
       
            if(j!=m-2 || last>arr2[i]){
                arr1[j+1] = arr2[i]; 
                arr2[i] = last; 
            }
        }
        for(int i=0;i<m;i++){
            System.out.print(arr1[i]+" ");
        }
        for(int i=0;i<n;i++){
            System.out.print(arr2[i]+" ");
            
        }
        System.out.println();
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    int arr1[] =new int[m];
		    int arr2[] =new int[n];
		    for(int i=0;i<m;i++)
		        arr1[i]=sc.nextInt();
		    for(int i=0;i<n;i++)
		        arr2[i]=sc.nextInt();
		    merge(arr1,m,arr2,n);
		}
	}
}
