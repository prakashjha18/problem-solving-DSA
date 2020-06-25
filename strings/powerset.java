// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            ArrayList<String> ans = new LexSort().powerSet(st);
            Collections.sort(ans);
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


 // } Driver Code Ends





//User function Template for Java


class LexSort
{
    // complete the function
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        ArrayList<String> ans  = new ArrayList<String>();
        subseq(s,"",ans);
        Collections.sort(ans);
        return ans;
    }
    static void subseq(String ip,String op,ArrayList<String> ans){
        if(ip.length()==0){
            System.out.print(op+"T");
            ans.add(op);
            return;
        }
        subseq(ip.substring(1),op,ans);
        //System.out.print(ip.charAt(0)+"_");
        subseq(ip.substring(1),op+ip.charAt(0),ans);
    }
    // static void permuteRec(String str, int n, 
    //                       int index, String curr) 
    // { 
    //     // base case 
    //     if (index == n) { 
    //         return; 
    //     } 
    //     System.out.println(curr); 
    //     for (int i = index + 1; i < n; i++) { 
  
    //         curr += str.charAt(i); 
    //         permuteRec(str, n, i, curr); 
  
    //         // backtracking 
    //         curr = curr.substring(0, curr.length() - 1); 
    //     } 
    //     return; 
    // } 
  
    // // Generates power set in lexicographic 
    // // order. 
    // static void powerSet(String str) 
    // { 
    //     char[] arr = str.toCharArray(); 
    //     Arrays.sort(arr); 
    //     permuteRec(new String(arr), str.length(), -1, ""); 
    // } 
}


 


// { Driver Code Starts.

                                // } Driver Code Ends
