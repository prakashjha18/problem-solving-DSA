// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValidIP(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends
// User function Template for Java

class Solution {

    public boolean isValidIP(String s) {
        return s.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])");
    }
}
