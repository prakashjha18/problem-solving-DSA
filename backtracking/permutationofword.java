/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
// Input:  str[] = "ABC"
// Output: (A B C)(A BC)(AB C)(ABC)
class GFG
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0)
        {
            String s = in.next();
            //System.out.print(s.substring(0,1));
            find(s,0);
            
            System.out.println();
        }
    }
    public static void find(String s,int i)
    {
        if(i==s.length()-1)
        {
            System.out.print("("+s+")");
            return;
        }
        find(s.substring(0,i+1)+" "+s.substring(i+1),i+2);
        find(s,i+1);
        return;
    }
}
