// { Driver Code Starts
//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
import java.util.*;
import java.io.*;
import java.lang.*;
//Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.
class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int num = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[num];
            for(int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            
            new solve().nearlySorted(arr, num, k);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class solve{
    void nearlySorted(int arr[], int n, int k){
        // your code here
         PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); 
  
        // add first k + 1 items to the min heap 
        for(int i = 0; i < k + 1; i++) 
        { 
            priorityQueue.add(arr[i]); 
        } 
  
        int index = 0; 
        for(int i = k + 1; i < n; i++)  
        { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
            priorityQueue.add(arr[i]); 
        } 
  
        Iterator<Integer> itr = priorityQueue.iterator(); 
  
        while(!priorityQueue.isEmpty())  
        { 
            arr[index++] = priorityQueue.peek(); 
            priorityQueue.poll(); 
        } 
        for(int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");
    }
}
