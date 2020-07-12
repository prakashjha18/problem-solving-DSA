// { Driver Code Starts
//Initial Template for Java
//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Platform().findPlatform(arr, dep, n));
        }
    }
    
    
}


// } Driver Code Ends
//User function Template for Java

class Platform
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays 
        Arrays.sort(arr); 
        Arrays.sort(dep); 
       
        // plat_needed indicates number of platforms 
        // needed at a time 
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat_needed++;
                i++;
                result = Math.max(plat_needed,result);
            }
            else {
                plat_needed--; 
                j++; 
            }
        }
         return result;
   
   } 
   

        
    
    
}

