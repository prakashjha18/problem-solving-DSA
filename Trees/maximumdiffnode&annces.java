// Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of
// node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 
// You are required to complete the function maxDiff. You should not read any input from stdin/console. 
// There are multiple test cases. For each test case, this method will be called individually.
// Explanation:
// Testcase 1:

//              5
//           /    \
//          2      1
// The maximum difference we can get is 4, which is bewteen 5 and 1.

// Testcase 2:

//              1
//           /    \
//          2      3
//                   \
//                     7
// The maximum difference we can get is -1, which is bewteen 1 and 2.

// { Driver Code Starts
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

class maximumdiffnode&annces {
    
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
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr = new Tree();
                System.out.println(tr.maxDiff(root));
	            
	        }
	    
	}
}


// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

/*
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
    int res = Integer.MIN_VALUE;
    int maxDiffUtil(Node t)  
    { 
        /* Returning Maximum int value if node is not 
           there (one child case)  */
        if (t == null) 
            return Integer.MAX_VALUE; 
           
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null) 
            return t.data; 
   
        /* Recursively calling left and right subtree 
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left), 
                maxDiffUtil(t.right)); 
   
        /* Updating res if (node value - minimum value 
           from subtree) is bigger than res  */
        res = Math.max(res, t.data - val); 
   
        /* Returning minimum value got so far */
        return Math.min(val, t.data); 
    } 
    int maxDiff(Node root)
    {
        //your code here
         
        maxDiffUtil(root); 
   
        return res;
    }
}

