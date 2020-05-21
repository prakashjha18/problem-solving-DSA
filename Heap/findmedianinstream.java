// { Driver Code Starts
// Input:
// 4
// 5
// 15
// 1 
// 3
// Output:
// 5
// 10
// 5
// 4
 
// Explanation:
// Testcase 1:
// Flow in stream : 5, 15, 1, 3
// 5 goes to stream --> median 5 (5)
// 15 goes to stream --> median 10 (5, 15)
// 1 goes to stream --> median 5 (5, 15, 1)
// 3 goes to stream --> median 4 (5, 15, 1, 3)
import java.util.*;
import java.io.*;
import java.lang.*;


class Driverclass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FindMedian Ans = new FindMedian();
        for(int i = 1; i <= n; i++)
        {
            int x =sc.nextInt();
            Ans.insertHeap(x);
            System.out.println((int)Math.floor(Ans.getMedian()));
        }
        
    }
}

// } Driver Code Ends


class FindMedian
{
   static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    
    // Function to insert heap
    public static void insertHeap(int x)
    {
        if(max.size()==0 || x<max.peek())
        {
            max.add(x);
        }
        else
        {
            min.add(x);
        }
        balanceHeaps();
    }
    
     // Function to balance Heaps
    public static void balanceHeaps()
    {
        int size1=max.size();
        int size2=min.size();
        
        if(Math.abs(size1-size2)>1)
        {
            if(size1>size2)
            {
                int p=max.poll();
                min.add(p);
            }
            else
            {
                int p=min.poll();
                max.add(p);
            }
        }
       // add your code here
    }
    
    // function to getMedian
    public static double getMedian()
    {    
        int size1=max.size();
        int size2=min.size();
        if(size1==size2)
        {
            return (double)((double)max.peek()+(double)min.peek())/2;
        }
        else
        {
            if(size1>size2)
            {
                return max.peek();
            }
            else
            {
                return min.peek();
            }
        }
    }
}
