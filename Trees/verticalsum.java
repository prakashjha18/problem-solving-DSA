// Given a Binary Tree, find vertical sum of the nodes that are in same vertical line. Print all sums through different 
// vertical lines starting from left-most vertical line to right-most vertical line.
// For Example:
 

//       1
//     /   \
//   2      3
//  / \    / \
// 4   5  6   7
// The tree has 5 vertical lines
// Vertical-Line-1 has only one node 4 => vertical sum is 4
// Vertical-Line-2: has only one node 2=> vertical sum is 2
// Vertical-Line-3: has three nodes: 1,5,6 => vertical sum is 1+5+6 = 12
// Vertical-Line-4: has only one node 3 => vertical sum is 3
// Vertical-Line-5: has only one node 7 => vertical sum is 7


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

class verticalsum {
    
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
			
			    g.verticalSum(root);
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Tree{
    Map<Integer, Integer> tm;
    void preOrder(Node node, int vd){
        if (node == null) return;
        
        tm.put(vd, tm.getOrDefault(vd, 0) + node.data);
        preOrder(node.left, vd-1);
        preOrder(node.right, vd+1);
    }
    
    public void verticalSum(Node root){
        tm = new TreeMap<>();
        preOrder(root, 0);
        
        for (Map.Entry<Integer, Integer> item : tm.entrySet()) 
            System.out.print(item.getValue() + " ");
    }
}
