// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class maxofallsubarr
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int arr[] = new int[n];
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            new solve().max_of_subarrays(arr, n, k);
            System.out.println();
        }
    }
}// } Driver Code Ends
class solve{
    static void max_of_subarrays(int arr[], int n, int k){
        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(i  = 0; i < k ; i++){
            while(dq.isEmpty() == false && arr[i] >= arr[dq.peekLast()])
              dq.pollLast();
              
              dq.add(i);
        }
        for(i=k; i < n; i++){
            
            sb.append(arr[dq.peek()] + " ");
            
            while(dq.isEmpty() == false && (dq.peekFirst() <= i-k))
                dq.pollFirst();
               
            while(dq.isEmpty() == false && (arr[i] >= arr[dq.peekLast()]))
                dq.pollLast();
                
            dq.add(i);
        }
        sb.append(arr[dq.peek()]);
        dq.pollFirst();
        System.out.print(sb);
    }
}
