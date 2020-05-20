// { Driver Code Starts
//Initial Template for Java
//Given a Binary Search Tree and a target sum, write a function that returns true if there is a pair with sum
//equals to target sum, otherwise return false.
// 2
// 2 1 3
// 5
// 6 5 N 3 N 1 4
// 2
// Output:
// 1
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
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> treeToList(Node node, ArrayList<Integer> 
                                                 list){ 
        // Base Case 
        if (node == null) 
            return list; 
        treeToList(node.left, list); 
        list.add(node.data); 
        treeToList(node.right, list); 
        return list; 
    } 
    public int isPairPresent(Node node,int target){
        ArrayList<Integer> a2 = treeToList(node, new ArrayList<>()); 
        int start = 0; // Starting index of a2 
        int end = a2.size() - 1; // Ending index of a2 
        while (start < end){ 
            if (a2.get(start) + a2.get(end) == target){ 
                return 1; 
            } 
            if (a2.get(start) + a2.get(end) > target){ 
                end--; 
            } 
            if (a2.get(start) + a2.get(end) < target){ 
                start++; 
            } 
        } 
        return 0; 
    }
}
