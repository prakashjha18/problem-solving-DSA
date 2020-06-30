// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
    
}

class BST
{
    public static Node insert(Node node, int data)
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
            
            int N = sc.nextInt();
            
            GfG gfg = new GfG();
            System.out.println(gfg.findMaxforKey(root, N, n));
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
    
}*/
class GfG
{
    public static int findMaxforKey(Node root, int key, int size)
    {
        if (root == null)
            return -1;
        int res=-1;
        while(root!=null){
            if(root.data==key)
                return root.data;
            else if(root.data<key){
                res=root.data;
                root=root.right;
            }
            else
                root=root.left;
        }
        return res;
    }
}
