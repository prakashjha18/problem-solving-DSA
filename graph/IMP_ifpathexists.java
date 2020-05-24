// { Driver Code Starts
// Initial Template for Java
// Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether 
// there is a path possible from source to the destination 
// while traversing through blank cells only. You can traverse up, down, right and left.

// A value of cell 1 means Source.
// A value of cell 2 means Destination.
// A value of cell 3 means Blank cell.
// A value of cell 0 means Wall.
// Note: there are only a single source and a single destination.
// Explanation:
// Testcase 1: The matrix for the above given input is:
// 3 0 0 0
// 0 3 3 0
// 0 1 0 3
// 0 2 3 3
// From the matrix we can see that there exists a path from to reach destination 2 from source 1.
// Testcase 2: The matrix for the above-given input is:
// 0 3 2
// 3 0 0
// 1 0 0
// From the matrix, we can see that there does not exist any path to reach destination 2 from source 1.
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int A[][] = new int[n][n];
            String[] s = br.readLine().trim().split(" ", n * n);
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = Integer.parseInt(s[k]);
                    k++;
                }
            }

            Solution T = new Solution();
            System.out.println(T.isExist(A, n));

            t--;
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public static int isExist(int A[][], int n) {
        // your code goes here
         int []dx = new int[]{0,0,-1,1};
        int []dy = new int[]{-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(A[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
                int []cur = q.poll();
                for(int i=0;i<4;i++){
                    int x = dx[i]+cur[0];
                    int y = dy[i]+cur[1];
                    
                    if(x>=0 && y>=0 && x<n&& y<n && A[x][y]==3){
                        q.add(new int[]{x,y});
                        A[x][y]=0;
                    }
                    if(x>=0 && y>=0 && x<n&& y<n &&A[x][y]==2){
                        return 1;
                    }
                
            }
            //step++;
        }
        return 0;
    }
}
