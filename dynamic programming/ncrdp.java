// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG 
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int testcase=s.nextInt();  
        while(testcase>0)
        {
            int n=s.nextInt();              // Input n
            int r=s.nextInt();              // Input p
            
            DynamicProgramming obj = new DynamicProgramming();
            System.out.println(obj.nCrModp(n, r));
            
            testcase--;
        }
    }
     
}
// } Driver Code Ends


class DynamicProgramming{
    
    // function to find nC recursive method
    // public static int nCrModp(int n, int r){
        
    //     // your code here
    //     int mod = 1000000007; 
    //     if(r==0 || r==n)
    //         return 1;
    //     if(n<r)
    //         return 0;
    //     return (nCrModp(n-1,r-1) + nCrModp(n-1,r)%mod);
    // }
    // DYNAMIC PROGRAMMING METHOD 1
    // public static int nCrModp(int n, int r){
        
    //     // your code here
    //     int[][] arr = new int[n+1][r+1];
    //     for(int i=0;i<=n;i++){
    //         for(int j=0;j<=r;j++){
    //             arr[i][j] = -1;
    //         }
    //     }
    //     return ncrmod(arr,n,r);
    // }
    // public static int ncrmod(int arr[][], int n, int r){
    //      int mod = 1000000007; 
    //         if(r==0 || r==n)
    //             return 1;
    //         if(n<r)
    //             return 0;
    //         if(arr[n][r]!=-1)
    //             return arr[n][r];
    //         arr[n][r] =(nCrModp(n-1,r-1) + nCrModp(n-1,r)%mod);
    //         return arr[n][r];
    // }
    // DYNAMIC PROGRAMMING METHOD 2
     public static int nCrModp(int n, int r){
        
        // your code here
        int mod = 1000000007;
        int[][] arr = new int[n+1][r+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=r;j++){
                if(i<j)
                    arr[i][j]=0;
                else if(j==0 || i==j)
                    arr[i][j]=1;
                else 
                    arr[i][j]=((arr[i-1][j-1]%mod) + (arr[i-1][j]%mod))%mod;
            }
        }
        return arr[n][r];
    }
}


