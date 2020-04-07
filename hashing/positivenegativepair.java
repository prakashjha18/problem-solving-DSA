// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class positivenegativepair {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.printPairs(a, n);
            System.out.println();
        }
    }
}// } Driver Code Ends
// User function Template for Java

class Solution {
    public void printPairs(int arr[], int n) {
        Set<Integer> pairs = new HashSet<Integer>();  
    boolean pair_exists = false;  
  
    // Store all the positive elements  
    // in the unordered_set  
    for (int i = 0; i < n; i++)  
        if (arr[i] > 0)  
            pairs.add(arr[i]);  
  
    // Start traversing the array  
    for (int i = 0; i < n; i++)  
    {  
  
        // Check if the positive value of current  
        // element exists in the set or not  
        if (arr[i] < 0)  
            if (pairs.contains(-arr[i]))  
            {  
                // Print that pair  
                System.out.print(arr[i] + " " + -arr[i]);  
  
                pair_exists = true;  
            }  
    }  
  
    if (pair_exists == false)  
        System.out.println("0");  
      
    }
}
