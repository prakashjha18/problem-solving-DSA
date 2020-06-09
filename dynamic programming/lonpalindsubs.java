class Solution {
//     public String longestPalindrome(String s) {
//     if (s == null || s.length() < 1) return "";
//     int start = 0, end = 0;
//     for (int i = 0; i < s.length(); i++) {
//         int len1 = expandAroundCenter(s, i, i);
//         int len2 = expandAroundCenter(s, i, i + 1);
//         int len = Math.max(len1, len2);
//         if (len > end - start) {
//             start = i - (len - 1) / 2;
//             end = i + len / 2;
//         }
//     }
//     return s.substring(start, end + 1);
// }

// public int expandAroundCenter(String s, int left, int right) {
//     int L = left, R = right;
//     while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//         L--;
//         R++;
//     }
//     return R - L - 1;
// }
    public String longestPalindrome(String str) {
        if (str == null || str.length() < 1) return "";
        boolean arr[][] = new boolean[str.length()][str.length()];
            int a=0;
            int b=0;
            int m=-1;
            for(int i=0; i < str.length(); i++){
                arr[i][i] = true;
            }
            for(int l = 2; l <= str.length(); l++){
                for(int i=0; i <= str.length() - l; i++){
                    int j = i + l -1;
                    if(Math.abs(i-j)==1 && str.charAt(i)==str.charAt(j)){
                        arr[i][j]=true;
                    }
                    else {
                        if(str.charAt(i)==str.charAt(j) && arr[i+1][j-1]==true){
                            arr[i][j]=true;
                        }
                    }
                    if( arr[i][j]==true && (j-i)>m){
                        m=(j-i);
                        a=i;
                        b=j;
                    }
                }
            }
            return str.substring(a,b+1);
    }
}
