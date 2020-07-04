//https://leetcode.com/problems/set-matrix-zeroes/
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

// Example 1:

// Input: 
// [
//   [1,1,1],
//   [1,0,1],
//   [1,1,1]
// ]
// Output: 
// [
//   [1,0,1],
//   [0,0,0],
//   [1,0,1]
// ]
// Example 2:

// Input: 
// [
//   [0,1,2,0],
//   [3,4,5,2],
//   [1,3,1,5]
// ]
// Output: 
// [
//   [0,0,0,0],
//   [0,4,5,0],
//   [0,3,1,0]
// ]

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null){
            return;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        for(int i=0; i<n; i++){
            if(matrix[0][i]==0){
                rowHasZero = true;
                break;
            }
        }
        
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0){
                colHasZero = true;
                break;
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        

        
        for(int j=1;j<n; j++){
            if(matrix[0][j]==0){
                nullifyCol(matrix, j, m, n);
            }
        }
        
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0){
                nullifyRow(matrix, i, m, n);
            }
        }
        
        if(rowHasZero){
            nullifyRow(matrix, 0, m, n);
        }
        if(colHasZero){
            nullifyCol(matrix, 0, m, n);
        }
        
    }
    
    public void nullifyRow(int[][] matrix, int i, int m, int n){
        for(int col=0; col<n; col++){
            matrix[i][col] = 0;
        }
    }
    
    public void nullifyCol(int[][] matrix, int j, int m, int n){
        for(int row=0; row<m; row++){
            matrix[row][j] = 0;
        }
    }
}
