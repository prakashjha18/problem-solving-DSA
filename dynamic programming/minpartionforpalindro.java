// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// Example:

// Input: "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

class Solution {
    public int minCut(String s) {
        int T[][] = new int[s.length()][s.length()];
         for(int i=0; i < s.length(); i++){
            T[i][i] = 0;
        }
        for(int l = 2; l <= s.length(); l++){
            for(int i = 0; i < s.length()-l + 1; i++){
                int j = i + l - 1;
                if(l == 2){ 
                    if(s.charAt(i) == s.charAt(j)){
                        T[i][j] =0;
                    } else {
                        T[i][j] =1;
                    }
                }else{
                    if(isPalindrome(s,i,j)) T[i][j] =0;
                    else {
                        int x = Integer.MAX_VALUE;
                        for(int k=i;k<=j-1;k++){
                            
                            x = Math.min(T[i][k]+T[k+1][j],x);
                        }
                        T[i][j] =x+1;
                    }
                }
            }
        }
        // for(int i=0;i<s.length();i++){
        //     for(int j=0;j<s.length();j++){
        //         System.out.print(T[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return T[0][s.length()-1];
    }
    public boolean isPalindrome(String s, int low, int high){
       while(low < high)
          if(s.charAt(low++) != s.charAt(high--)) return false;
       return true;
    }
}
