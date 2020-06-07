// { Driver Code Starts
//https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1/?track=amazon-dynamic-programming&batchId=192
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}// } Driver Code Ends


class solve{
    static class Pair{
        int first, second;
    }
    static long countMaximum(int pots[], int n){
        // Your code here
        Pair[][] moves = new Pair[pots.length][pots.length];
        
        for(int i=0; i < moves.length; i++){
            for(int j=0; j < moves[i].length; j++){
                moves[i][j] = new Pair();
            }
        }
        
        for(int i=0; i < pots.length; i++){
            moves[i][i].first = pots[i];
        }
        
        for(int l = 2; l <= pots.length; l++){
            for(int i=0; i <= pots.length - l; i++){
                int j = i + l -1;
                if(pots[i] + moves[i+1][j].second > moves[i][j-1].second + pots[j]){
                    moves[i][j].first = pots[i] + moves[i+1][j].second;
                    moves[i][j].second = moves[i+1][j].first;
                }else{
                    moves[i][j].first = pots[j] + moves[i][j-1].second;
                    moves[i][j].second = moves[i][j-1].first;
                }
            }
        }
        return (long)(moves[0][pots.length-1].first);
    }
}
