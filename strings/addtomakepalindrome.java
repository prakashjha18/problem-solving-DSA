//Minimum characters to be added at front to make string palindrome


class addtomakepalindrome{
    static int[] computeLPSArray(String pat){
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
        return lps;
    }
    static int getMinCharToAddedToMakeStringPalin(String str)  
    {  
        StringBuilder s = new StringBuilder(); 
        s.append(str); 
        
        // Get concatenation of string, special character  
        // and reverse string  
        String rev = s.reverse().toString(); 
        s.reverse().append("$").append(rev); 
        
        // Get LPS array of this concatenated string 
        int lps[] = computeLPSArray(s.toString()); 
        return str.length() - lps[s.length() - 1]; 
    }
    public static void main(String args[]) 
    { 
        String str = "AACECAAAA";  
        System.out.println(getMinCharToAddedToMakeStringPalin(str));  
    }
}
