/*
Given a binary tree of size N . We install bulb on the nodes of the tree . A bulb at a node can light it's parent , 
itself and it's immediate children . You have to find minimum number of bulbs required to light all the nodes of the 
tree.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input
which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and
a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case , print the minimum number of light bulbs required.
Your Task:
You have to complete function minBulb() which accepts root node of the tree as parameter and returns the minimum 
number of light bulbs required to light up the whole tree.
Constraints:
1<=T<=103
1<=N<=103
Example:
Input:
2
1 2 3
1 N 2 N 3 N 4 N 5 N
Output:
1
2
Explanation:
Test Case 2:
Given tree is: 
                       1
                          \
                            2
                               \
                                 3
                                    \
                                       4
                                           \
                                             5
On placing bulbs at node 2 and 4 we can light all the nodes of the tree.


*/

// { Driver Code Starts
//Initial Template for Java

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
        		System.out.println(g.minBulb(root));
                    t--;
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*
Class Node is as follows:
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
*/
class Tree
{
    public static int minBulb(Node root)
    {
       // code here.
       int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }
    public static int[] solve(Node node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }
}

