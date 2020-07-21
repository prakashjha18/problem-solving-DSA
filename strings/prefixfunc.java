class Solution {
    public boolean repeatedSubstringPattern(String pat) {
        int M = pat.length();
        int lps[] = new int[M]; 
        int len=0;
        int i=1;
        lps[0]=0;
        while(i<M){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            } else {
                if(len!=0){
                    len = lps[len-1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        
        if(lps[M-1]!=0 && (lps[M-1]%(M-lps[M-1])) ==0){
            return true;
        }
        return false;
    }
}
    
    
    
