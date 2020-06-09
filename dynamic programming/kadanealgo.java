// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<Integer> arr = new ArrayList<Integer>();
                    for(int i = 0;i<n;i++)
                        {
                            int p = sc.nextInt();
                            arr.add(p);
                        }
                        
                    Sol obj = new Sol();  
                    System.out.println(obj.maxSubArray(arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    
    public static int maxSubArray(ArrayList<Integer> a)
    {
        // code here.
        int max_so_far = a.get(0); 
        int curr_max = a.get(0); 
  
        for (int i = 1; i < a.size(); i++) 
        { 
            curr_max = Math.max(a.get(i), curr_max+a.get(i)); 
            max_so_far = Math.max(max_so_far, curr_max); 
            //System.out.print(curr_max+" "+max_so_far+"__");
        } 
           return max_so_far; 
    }
}
