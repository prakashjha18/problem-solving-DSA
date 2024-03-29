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
    
	        while(t > 0)
	        {
	            String arr[] = br.readLine().split(" ");
	            int key = Integer.parseInt(arr[0]);
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution g = new Solution();
        		g.deletionBT(root,key);
        		printInorder(root);
        		System.out.println();
                    t--;
            
        }
    }
}


// } Driver Code Ends


/*
Node class is as follows:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public Node deletionBT(Node root, int key){
        Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node toDelete  = null;
		Node toReplace = null;
		while (!queue.isEmpty()) {
		    int size = queue.size();
		    Node curr = null;
		    for(int i=0;i<size;i++){
		        curr= queue.remove();
		        if(curr.data == key)
		            toReplace = curr;
		        if(curr.left!=null)
		            queue.add(curr.left);
		        if(curr.right!=null)
		            queue.add(curr.right);
		    }
		    if(queue.size()==0){
		        toDelete =curr;
		    }
		}//end of while loop
		if(toReplace != null && toDelete != null)
			toReplace.data = toDelete.data;
		DeleteDeepestNode(root,toDelete);
		return root;
    }

    public void DeleteDeepestNode(Node root,Node toDelete) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
		    Node curr = q.remove();
			if(curr.left != null) {
				if(curr.left == toDelete) {
					curr.left = null;
					break;
				}
				q.add(curr.left);
			}
			if(curr.right != null) {
				if(curr.right == toDelete) {
					curr.right = null;
					break;
				}
				q.add(curr.right);
			}
		}
	}
}
