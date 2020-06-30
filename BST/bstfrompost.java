// { Driver Code Starts
//Initial Template for Java
/*
Given postorder traversal of a Binary Search Tree, you need to complete the function constructTree()
which will create a BST. The output will be the inorder of the constructed BST.

Input:
The constructTree() method consist of two arguments as input, the array consisting of the post order
traversal and the size of the array.

Output:
Print the Inorder traversal of the constructed BST.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
6
1 7 5 50 40 10
9
216 823 476 429 850 93 18 975 862

Output:
1 5 7 10 40 50
18 93 216 429 476 823 850 862 975

Explanation:
Testcase 1: The BST for the given post order traversal is:


Thus the inorder traversal of BST is: 1 5 7 10 40 50.

** For More Input/Output Examples Use 'Expected Output' option **
Contributor: Shubham Chaudhary
*/
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG(n);
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
class GFG
{
    GFG(int n)
    { }
    public static Node BST(Node root,int d){
        if(root == null)
            root = new Node(d);
        if(root.data>d){
            root.left = BST(root.left,d);
        }
        else if(root.data<d){
            root.right = BST(root.right,d);
        }
        return root;
    }
    public static Node constructTree(int post[],int size)
    {
        if(size==0)
            return null;
        Node root = null;
        for(int i=size-1;i>=0;i--){
            root = BST(root,post[i]);
        }
        return root;
    }
}
