// { Driver Code Starts
import java.io.*;
import java.util.*;

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
            
            Solution T = new Solution();
            
            T.printBoundary(root);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    void printLeaves(Node node) 
    { 
        if (node == null) 
            return; 
  
        printLeaves(node.left); 
        // Print it if it is a leaf node 
        if (node.left == null && node.right == null) 
            System.out.print(node.data + " "); 
        printLeaves(node.right); 
    } 
  
    // A function to print all left boundary nodes, except a leaf node. 
    // Print the nodes in TOP DOWN manner 
    void printBoundaryLeft(Node node) 
    { 
        if (node == null) 
            return; 
  
        if (node.left != null) { 
            // to ensure top down order, print the node 
            // before calling itself for left subtree 
            System.out.print(node.data + " "); 
            printBoundaryLeft(node.left); 
        } 
        else if (node.right != null) { 
            System.out.print(node.data + " "); 
            printBoundaryLeft(node.right); 
        } 
        else {
            return;
        }
  
        // do nothing if it is a leaf node, this way we avoid 
        // duplicates in output 
    } 
  
    // A function to print all right boundary nodes, except a leaf node 
    // Print the nodes in BOTTOM UP manner 
    void printBoundaryRight(Node node) 
    { 
        if (node == null) 
            return; 
  
        if (node.right != null) { 
            // to ensure bottom up order, first call for right 
            // subtree, then print this node 
            printBoundaryRight(node.right); 
            System.out.print(node.data + " "); 
        } 
        else if (node.left != null) { 
            printBoundaryRight(node.left); 
            System.out.print(node.data + " "); 
        } 
        else{
            return;
        }
        // do nothing if it is a leaf node, this way we avoid 
        // duplicates in output 
    } 
	void printBoundary(Node node)
	{
	    if (node == null) 
            return; 
  
        System.out.print(node.data + " "); 
  
        // Print the left boundary in top-down manner. 
        printBoundaryLeft(node.left); 
  
        // Print all leaf nodes 
        printLeaves(node.left); 
        printLeaves(node.right); 
  
        // Print the right boundary in bottom-up manner 
        printBoundaryRight(node.right); 
	}
}
