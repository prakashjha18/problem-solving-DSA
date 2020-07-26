//Maximum sum path in matrix, (count paths, and similar type do, also backtrack to find the maximum path) 


import java.util.*; 
  
class maximumpathsum { 
      
    static int N = 4; 
  
    // function find maximum sum path 
    static int MaximumPath(int Mat[][]) 
    { 
        int result = 0; 
  
        // creat 2D matrix to store the sum 
        // of the path 
        int dp[][] = new int[N][N + 2]; 
  
        // initialize all dp matrix as '0' 
        for (int[] rows : dp) 
            Arrays.fill(rows, 0); 
  
        // copy all element of first column into 
        // 'dp' first column 
        for (int i = 0; i < N; i++) 
            dp[0][i + 1] = Mat[0][i]; 
  
        for (int i = 1; i < N; i++) 
            for (int j = 1; j <= N; j++) 
                dp[i][j] = Math.max(dp[i - 1][j - 1], 
                                    Math.max(dp[i - 1][j], 
                                    dp[i - 1][j + 1])) + 
                                    Mat[i][j - 1]; 
  
        // Find maximum path sum that end ups 
        // at any column of last row 'N-1' 
        int r=0;
        int c=0;
        for (int i = 0; i <= N; i++) {
            if(dp[N-1][i]>result){
                result  =dp[N - 1][i];
                r=N-1;
                c=i;
            }
            result = Math.max(result, dp[N - 1][i]); 
        }
        System.out.print("Path:  "+Mat[r][c-1]+"__");
        //System.out.println(r+" "+c);
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<N+2;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }System.out.println();
        // }
        int mainres =result;
        for(int i=N-2;i>=0;i--){
            int term = Mat[i+1][c-1];
            if(dp[i][c] == result-term){
                c=c;
            } else if(dp[i][c+1] == result- term){
                c=c+1;
            } else if(dp[i][c-1] == result-term) {
                c=c-1;
            }
            
            result = result -term;
            System.out.print(Mat[i][c-1]+"__");
        }
        System.out.println();
        // return maximum sum path 
        return mainres; 
    } 
      
    // driver code 
    public static void main(String arg[]) 
    { 
        int Mat[][] = { { 10, 10, 2, 0 }, 
                        { 1, 0, 0, 30 }, 
                        { 0, 10, 4, 0 }, 
                        { 1, 0, 2, 20 } }; 
  
        System.out.println(MaximumPath(Mat)); 
    } 
} 
