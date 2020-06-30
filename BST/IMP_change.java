// { Driver Code Starts
// Given a Binary Search Tree of size N, your task is to complete the function changeKey()
// that change old key value present in the tree and changes it to new key value.
// Example:

// Input: Root of below tree
//               50
//           /     \
//           30      70
//          /  \    /  \
//       20   40  60   80 
//      Old key value:  40
//      New key value:  10

// Output: BST should be modified to following
//               50
//           /     \
//           30      70
//          /       /  \
//       20      60   80  
//       /
//      10

// Input:
// The function takes three arguments, reference pointer to the root node of the BST, old key value 
// of the node and a new key value.
// There will be T test cases and for each test case the function will be called separately.

// Output:
// For each test case output the Inorder traversal of the Tree.

// Constraints:
// 1<=T<=100
// 1<=N<=500

// Example:
// Input:
// 1
// 7
// 20 8 22 4 12 10 14
// 8 1
// Output:
// 1 4 10 12 14 20 22
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}

class BinarySearchTree
{
     static Node insert(Node node, int data)
    {
     if (node == null)
     {
            return (new Node(data));
    } else 
        {
             
            /* 2. Otherwise, recur down the tree */
            if (data <= node.data)
            {
                node.left = insert(node.left, data);
            } else 
            {
                node.right = insert(node.right, data);
            }
 
            /* return the (unchanged) node pointer */
            return node;
        }
    
    }
    
    
    
         public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            
            while(n-- > 0)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            
            int old_key = sc.nextInt();
            int new_key = sc.nextInt();
             GfG gfg = new GfG();
             
            root =  gfg.changeKey(root, old_key, new_key);
             inorder(root);
             System.out.println();
        }
    }
    
  static void inorder(Node root)
    {
        if(root != null)
         {
        inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
         }
    }
    

}
// } Driver Code Ends


/* A binary search tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
// your task is to complete the below function
class GfG
{
    Node minimumElement(Node root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}
	Node deleteNode(Node root, int value)
	{
		// code here.
		if(root==null) return null;
		if(value<root.data)
		    root.left=deleteNode(root.left,value);
	    else if(value>root.data)
	        root.right=deleteNode(root.right,value);
	    else{
	        if(root.left!=null && root.right!=null){
	            Node temp=root;
	            Node minnodeforight = minimumElement(temp.right);
	            root.data=minnodeforight.data;
	            root.right=deleteNode(root.right,minnodeforight.data);
	        }
	        else if(root.left!=null)
	            root=root.left;
	        else if(root.right!=null)
	            root=root.right;
	        else
	            root=null;
	     }
	     return root;
	}
	Node insert(Node root,int key)
    {
        //Write your code here
        if (root == null) { // if root node is blank then insert new node there
			return new Node(key);
		} 
		if (key < root.data) 
			root.left=insert(root.left, key);
		else  
			root.right=insert(root.right, key);
			
        return root;
    }
    Node changeKey(Node root, int old_key, int new_key)
    {
        // your code here
        deleteNode(root,old_key);
        insert(root,new_key);
        return root;
    }
   
}
