// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class swapkthnodesfromends
{
    static  Node head;  
    static  Node lastNode;
    
    public static void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            lastNode = node;
        }
        else
        {
            Node temp = head;
            lastNode.next = node;
            lastNode = node;
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=  new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n, K;
            n = sc.nextInt();
            K = sc.nextInt();
            
            Node head = null;
            int val = sc.nextInt();
            head = new Node(val);
            addToTheLast(head);
            
            for(int i = 1; i< n; i++)
            {
                val = sc.nextInt();
                addToTheLast(new Node(val));
            }
            
            Node before[] = new Node[n];
            addressstore(before, head);
            GFG obj = new GFG();
            
            head = obj.swapkthnode(head, n, K);
        
           Node after[] = new Node[n];
          addressstore(after, head);
        
        if(check(before, after, n, K) == true)
            System.out.println("1");
        else
            System.out.println("0");
        
        }
    }
    
    static boolean check(Node before[], Node after[], int num, int K)
    {
          if(K > num)
           return true;
           
           return (before[K-1] == after[num - K]) && (before[num-K] == after[K-1]);
              
       
    }
    
    static void addressstore(Node arr[], Node head)
  {
      Node temp = head;
      int i = 0;
      while(temp != null){
        arr[i] = temp;
        i++;
        temp = temp.next;
    }
}
    
}// } Driver Code Ends
//User function Template for Java


/* Linked List Node class
   class Node  {
     int data;
     Node next;
     Node(int data)
     {
         this.data = data;
         next = null;
     }
  }
*/
class GFG
{
    // Should swap Kth node from beginning and 
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int n, int k)
    {
         if (n < k) 
            return head; 
  
        if (2*k - 1 == n) 
            return head; 
  
        Node x = head; 
        Node x_prev = null; 
        for (int i = 1; i < k; i++) 
        { 
            x_prev = x; 
            x = x.next; 
        } 
        //System.out.print(x.data+"__");
        Node y = head; 
        Node y_prev = null; 
        for (int i = 1; i < n - k + 1; i++) 
        { 
            y_prev = y; 
            y = y.next; 
        } 
        //System.out.print(y.data+"__");
        if (x_prev != null) 
            x_prev.next = y; 
  
        if (y_prev != null) 
            y_prev.next = x; 
            
        Node temp = x.next; 
        x.next = y.next; 
        y.next = temp; 
  
        // Change head pointers when k is 1 or n 
        if (k == 1) 
            return y; 
  
        if (k == n) 
            return x; 
            
        Node sam=head;
        while(sam!=null){
            System.out.print(sam.data);
            sam=sam.next;
        }
        return head;
    }
}
