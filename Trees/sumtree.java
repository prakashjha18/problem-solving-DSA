// { Driver Code Starts
//Initial Template for Java
// Write a function that returns true if the given Binary Tree is SumTree 
// else false. A SumTree is a Binary Tree where the value of a node 
// is equal to sum of the nodes present in its left subtree and 
// right subtree. An empty tree is SumTree and sum of an empty tree
// can be considered as 0. A leaf node is also considered as SumTree.

// Following is an example of SumTree.

//           26
//         /   \
//       10     3
//     /    \     \
//   4      6      3
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

class sumtree {
    
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			
			    if(g.isSumTree(root) == true)
    			    System.out.println(1);
    			else 
    			    System.out.println(0);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree
{
    int isLeaf(Node node)  
    { 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return 1; 
        return 0; 
    } 
	boolean isSumTree(Node node)
	{
        int ls; // for sum of nodes in left subtree 
        int rs; // for sum of nodes in right subtree 
   
        /* If node is NULL or it's a leaf node then 
         return true */
        if (node == null || isLeaf(node) == 1) 
            return true; 
   
        if (isSumTree(node.left) != false && isSumTree(node.right) != false)  
        { 
            // Get the sum of nodes in left subtree 
            if (node.left == null) 
                ls = 0; 
            else if (isLeaf(node.left) != 0) 
                ls = node.left.data; 
            else
                ls = 2 * (node.left.data); 
   
            // Get the sum of nodes in right subtree 
            if (node.right == null) 
                rs = 0; 
            else if (isLeaf(node.right) != 0) 
                rs = node.right.data; 
            else
                rs = 2 * (node.right.data); 
               
            /* If root's data is equal to sum of nodes in left 
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls)) 
                return true; 
            else
                return false; 
        } 
   
        return false; 
	}
}
