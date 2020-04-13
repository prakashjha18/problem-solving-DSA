// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;
class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            GfG g=new GfG();
            System.out.println(g.multiply(a,b));
        }
    }
}// } Driver Code Ends
//User function Template for Java

class GfG{
    public String multiply(String a,String b){
        int sign = 1;
 
        if (a.startsWith("-")) {
            sign *= -1;
            a = a.substring(1, a.length());
        }
 
        if (b.startsWith("-")) {
            sign *= -1;
            b = b.substring(1, b.length());
        }
 
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
 
        int xlen = a.length();
        int ylen = b.length();
        int zlen = xlen * ylen;
        int[] p = new int[zlen + 1];
 
        int k = 0;
        for (int i = ylen - 1; i >= 0; i--) {
            int kk = 0;
            for (int j = xlen - 1; j >= 0; j--) {
                int s = (x[j] - '0') * (y[i] - '0') + p[kk + k];
                p[kk + k] = s % 10;
                if (s >= 10) {
                    p[kk + k + 1] += s / 10;
                }
                kk++;
            }
            k++;
        }
        }
        int idx = zlen;
        while (idx > 0 && p[idx] == 0) {
            idx--;
        }
 
        boolean allZeroes = true;
        for (int i = 0; i <= idx; i++) {
            if (p[i] != 0) {
                allZeroes = false;
                break;
            }
        }
 
        StringBuffer sb = new StringBuffer();
        if (sign == -1 && !allZeroes) {
            sb.append("-");
        }
        for (int i = 0; i <= idx; i++) {
            sb.append(p[i]);
        }
 
        int start = 0;
        if (sign == -1 && !allZeroes) {
            start = 1;
        }
        for (int i = start, j = sb.length() - 1; i < j; i++, j--) {
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, t);
        }
 
        return sb.toString();
    }
}
