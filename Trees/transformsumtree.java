// { Driver Code Starts

//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
        	    g.toSumTree(root);
        	    printInorder(root);
        	    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*Complete the Given Function
Node is as follows:
class Tree{
int data;
Tree left,right;
Tree(int d){
	data=d;
	left=null;
	right=null;
}
}*/
// Given a Binary Tree of size N , where each node has positive and negative values.
// Convert this to a tree where each node contains the sum of the left and right sub 
// trees in the original tree. The values of leaf nodes are changed to 0.

// For example, the following tree

//              10
//           /      \
//         -2        6
//       /   \     /  \
//      8     -4   7    5

// should be changed to

//              20(4-2+12+6)
//           /              \
//         4(8-4)      12(7+5)
//         /   \           /  \
//       0      0       0    0
class Tree{
    int toSumTreee(Node node)  
    { 
        // Base case 
        if (node == null) 
            return 0; 
   
        // Store the old value 
        int old_val = node.data; 
   
        // Recursively call for left and right subtrees and store the sum 
        // as new value of this node 
        node.data = toSumTreee(node.left) + toSumTreee(node.right); 
   
        // Return the sum of values of nodes in left and right subtrees 
        // and old_value of this node 
        return node.data + old_val; 
    } 
    public void toSumTree(Node node){
        toSumTreee(node);
    }
}
