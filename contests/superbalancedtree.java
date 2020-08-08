// { Driver Code Starts
//Initial Template for Java
/*
There is a computer network connected in a Binary tree-like structure. You as a network engineer want to connect any 
of the leaf computers with all other leaf computers with wlan wires. It is not possible to connect two leaf computer
if the difference between their depth from the root is greater than 1. You need to tell your Boss whether it is 
possible to connect any of the leaf computers with all other leaf computers.

Note that, if the network contains only one leaf computer then you don't need to connect it. That is, the output 
will be "YES"

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of 
input which is a string representing the network as described below: 

The values in the string are in the order of level order traversal of the network where, numbers denotes computers, 
and a character “N” denotes NULL child.

For example:



For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
Output:
For each test case, print "Yes" (without quotes) if above mentioned connection is possible otherwise, print 
"No" (without quotes) in new line.
Your Task:
Your task is to complete the function isPossible() which takes root pointer as parameter and returns boolean value.
Constraints:
1 <= T <= 100
1 <= Number of computers <= 10000
Example:
Input:
2
1 2 3 4 5 6 7
1 2 3 4 5 N N 6
Output:
Yes
No

Explanation:
Test Case 1:                                            1
                                                     /      \
                                                   2        3
                                                 /    \     /  \
                                                 4     5   6    7
All leaf computers are at same level.
Test Case 2:                                                1
                                                         /     \
                                                       2        3
                                                     /     \
                                                   4       5
                                                  /
                                                6
Leaf computers are 3, 5 & 6 and their depths are 2, 3 and 4 respectively and (4-2)=2 > 1. */


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
    
	public static void main (String[] args) throws IOException
	{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0)
	        {
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
        		if (g.isPossible(root)==true)
                    System.out.println("Yes");
                else
                    System.out.println("No");
                    t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Tree
{
    
/*
    root: current node
    depth: depth of current node from actual root
    minDepth: stores minimum depth
    maxDepth: stores maximum depth 
*/
    static int minDepth = Integer.MAX_VALUE;
    static int maxDepth = Integer.MIN_VALUE;
    public static void isSuperBalancedUtil(Node root, int depth) {
        // base case 
        // if current node is null
        
        if (root==null)
            return;
        // if leaf calculate min depth and max depth
        if (root.left==null && root.right==null) {
            
            minDepth = Math.min(minDepth, depth);
            maxDepth = Math.max(maxDepth, depth);
            //System.out.print(minDepth+" ");
            return;
        }
        // recur for left and right subtree
        isSuperBalancedUtil(root.left, depth + 1);
        isSuperBalancedUtil(root.right, depth + 1);
    }
    
    public static boolean isPossible(Node root)
    {
        minDepth = Integer.MAX_VALUE;
        maxDepth = Integer.MIN_VALUE;
        isSuperBalancedUtil(root, 1);
        //System.out.print(minDepth+" "+maxDepth);
        if (Math.abs(maxDepth - minDepth) <= 1)
            return true;
        return false;
    }
}


