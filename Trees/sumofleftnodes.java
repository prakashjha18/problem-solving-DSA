// { Driver Code Starts
//Initial Template for Java

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

class sumofleftnodes
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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
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
            
            Solution T = new Solution();
            System.out.println(T.leftLeavesSum(root));
            
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    // boolean isLeaf (Node node){
    //     if(node == null)
    //         return false;
    //     if(node.left==null && node.right==null)
    //         return true;
    //     return false;
    // }
    // public int leftLeavesSum(Node node) {
    //     int res=0;
    //     if(node !=null){
    //         if (isLeaf(node.left)) 
    //             res += node.left.data; 
    //         else 
    //             res += leftLeavesSum(node.left); 
  
    //         res += leftLeavesSum(node.right); 
    //     }
    //     return res;
    // } 
    int sum=0;
    public void leftLeavesSumRec(Node node, boolean isleft){
        if(node ==null)
            return;
        if(node.left==null && node.right==null && isleft){
            sum+=node.data;
        }
        leftLeavesSumRec(node.left, true);
        leftLeavesSumRec(node.right, false);
    }
    public int leftLeavesSum(Node node) {
        leftLeavesSumRec(node, false); 
        return sum;
    }

}
