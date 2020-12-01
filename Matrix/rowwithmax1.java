// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static int first(int arr[], int low, int high) { 
		while (high >= low) { 
			int mid = low + (high - low) / 2; 

			if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) 
				return mid; 

			else if (arr[mid] == 0) 
				low=mid+1;
				
			else
				high=mid-1;
		} 
		return -1; 
	} 
    int rowWithMax1s(int mat[][], int R, int C) {
        // code here
        int max_row_index = -1, max = -1; 

		int i, index; 
		for (i = 0; i < R; i++) { 
			index = first(mat[i], 0, C - 1); 
			if (index != -1 && C - index > max) { 
				max = C - index; 
				max_row_index = i; 
			} 
		} 

		return max_row_index; 
    }
}
