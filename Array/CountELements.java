// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.HashMap;

class CountELements {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            // int k = sc.nextInt();

            GfG g = new GfG();
            g.countDistinct(a, k, n);
            System.out.println();

            t--;
        }
    }
}// } Driver Code Ends
/*You are required to complete below method */
class GfG {
    void countDistinct(int arr[], int k, int n) {
        // Your code here
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int dist_count = 0;
        for(int i=0;i<k;i++){
            if(hm.get(arr[i])==null){
                hm.put(arr[i],1);
                dist_count++;
            }
            else {
                int count = hm.get(arr[i]);
                hm.put(arr[i],count+1);
            }
        }
        System.out.print(dist_count+" ");
        for(int i=k;i<n;i++){
            if(hm.get(arr[i-k])==1){
                hm.remove(arr[i-k]);
                dist_count--;
            }
            else{
                int count=hm.get(arr[i-k]);
                hm.put(arr[i-k],count-1);
            }
            if(hm.get(arr[i])==null){
                hm.put(arr[i],1);
                dist_count++;
            }
            else{
                int count=hm.get(arr[i]);
                hm.put(arr[i],count+1);
            }
            System.out.print(dist_count+" ");
        }
        
    }
}
