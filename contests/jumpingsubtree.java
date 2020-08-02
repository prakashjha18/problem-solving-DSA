/*package whatever //do not write package name here */
/*You are provided with a binary search tree of n nodes with distinct values.. You are 
given Q queries: Each query consists of a node value that you need to find in the BST 
and skip the subtree that has given node as its root. If the provided node is the root 
itself then print "Empty" without quotes. After that print the preorder traversal of the BST.

Input :
First line of input contains number of testcases T. For each testcase, first line of input 
contains number of elements n to be inserted in binary tree followed by queries number Q. 
The next line contains n elements of the BST that are to be inserted in the order of their arrival. 
The next lines contains Q queries denoting the value of a node.

Output :
For each testcase, print the preorder traversal after performing the required operations.

Constraints :
1 <= T <= 100
1 <= Q <= 103
1 <= Elements of Binary Tree <= 106
1 <= N <= 106

Example :
Input :
1
7 2
8 4 10 15 14 88 64
15
88

Output :
8 4 10
8 4 10 15 14

Explanation : For testcase1: We have n = 7 nodes to be inserted in the BST. The BST formed will be :
                                               
                                              8
                                          /         \
                                       4            10
                                                         \
                                                           15
                                                         /        \
                                                       14         88
                                                                    /
                                                                 64
Q = 2
Q1 = 15. So, we skip the subtree with 15 as root. The remaining tree is :
                                               
                                              8
                                          /         \
                                       4            10
The preorder traversal of the above tree is : 8 4 10
Q2 = 88. So we skip the subtree with 88 as root. The remaining tree is :
                                               8
                                          /         \
                                       4            10
                                                         \
                                                           15
                                                         /       
                                                       14                  
The preorder traversal of the above tree is : 8 4 10 15 14*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    Node left,right;
    int data;
    Node(int x)
    {
        data=x;
        left=null;
        right=null;
    }
}
class GFG {
    static Node root=null;
	public static void main (String[] args) throws Exception{
		//code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String line = br.readLine().trim();
		    String[] tokens = line.split("\\s+");
		    int n = Integer.parseInt(tokens[0]);
		    int Q = Integer.parseInt(tokens[1]);
		    int a[]=new int[n];
		    line = br.readLine().trim();
		    tokens = line.split("\\s+");
		    root=null;
		    for (int i=0; i<n; i++){ 
		        a[i] = Integer.parseInt(tokens[i]);
		        root= insert(root,a[i]);
		    }
		    for(int i=0;i<Q;i++){
		        int ele = Integer.parseInt(br.readLine().trim());
		        StringBuffer result = new StringBuffer();
		        print(root,ele,result);
		        if (result.length() == 0) result.append("Empty");
    		    System.out.println(result);
		    }
		}
	}
	
	public static Node insert(Node root,int d){
	    if(root==null){
	        root =new Node(d);
	        return root;
	    }
	    if(root.data>d){
	        root.left = insert(root.left,d);
	    } 
	    else {
	        root.right = insert(root.right,d);
	    }
	    return root;
	}
	public static void print(Node root,int ele,StringBuffer result){
	    if(root!=null){
	        if(root.data==ele){
	            return;
	        }
	        result.append(root.data+" ");
	        print(root.left,ele,result);
	        print(root.right,ele,result);
	    }
	}
	
}
