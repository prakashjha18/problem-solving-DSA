// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class printbinary
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            new solve().generate(n);
            System.out.println();
        }
    }
}// } Driver Code Ends


class solve{
    static void generate(long n)
    {
        // Your code here
        Queue<String> q = new LinkedList<String>(); 
        q.add("1"); 
        while(n-- > 0) 
        { 
            String s1 = q.peek(); 
            q.remove(); 
            System.out.print(s1+" "); 
            String s2 = s1; 
            q.add(s1 + "0"); 
            q.add(s2 + "1"); 
        } 
    }
    
}
