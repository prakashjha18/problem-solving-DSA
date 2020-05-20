// { Driver Code Starts
//Initial Template for Java
// Input:
// 2
// 10 2 11 1 5 N N N N 3 6 N 4
// 13
// 8 1 9 N 4 N 10 3
// 9

// Output:
// 2
// 0
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int k = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.maxDiff(root,k));
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int min_diff, min_diff_key; 
    static void maxDiffUtil(Node  ptr, int k) { 
        if (ptr == null) 
            return ; 
       
        // If k itself is present 
        if (ptr.data == k) { 
            min_diff = 0; 
            return; 
        } 
       
        // update min_diff and min_diff_key by checking 
        // current node value 
        if (min_diff > Math.abs(ptr.data - k)) { 
            min_diff = Math.abs(ptr.data - k); 
            min_diff_key = ptr.data; 
        } 
       
        // if k is less than ptr.key then move in 
        // left subtree else in right subtree 
        if (k < ptr.data) 
            maxDiffUtil(ptr.left, k); 
        else
            maxDiffUtil(ptr.right, k); 
    } 
    static int maxDiff(Node  root, int k) 
    { 
        // Write your code here
        
         min_diff = 999999999; min_diff_key = -1; 
   
        // Find value of min_diff_key (Closest key 
        // in tree with k) 
        maxDiffUtil(root, k); 
       
        return min_diff; 
    } 
}

