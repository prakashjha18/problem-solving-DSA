// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
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
    
    int height(Node node) 
{
   if (node==null) return 0;
   else
   {
       int lDepth = height(node.left);
       int rDepth = height(node.right);
       if (lDepth > rDepth)
           return(lDepth+1);
       else 
           return(rDepth+1);
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
           
             GfG gfg = new GfG();
             
           root =  gfg.buildBalancedTree(root);
            // preOrder(root);
            BinarySearchTree bst = new BinarySearchTree();
             System.out.println(bst.height(root));
        }
    }
    
     void preOrder(Node node) 
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class GfG
{
    void storeBSTNodes(Node root, ArrayList<Node> nodes)  
    { 
        // Base case 
        if (root == null) 
            return; 
  
        // Store nodes in Inorder (which is sorted 
        // order for BST) 
        storeBSTNodes(root.left, nodes); 
        nodes.add(root); 
        storeBSTNodes(root.right, nodes); 
    } 
    Node buildTreeUtil(ArrayList<Node> nodes, int start,int end) {
        if(start>end) return null;
        int mid = (start + end) / 2; 
        Node node = nodes.get(mid); 
        node.left = buildTreeUtil(nodes, start, mid - 1); 
        node.right = buildTreeUtil(nodes, mid + 1, end); 
  
        return node; 
    }
    Node buildBalancedTree(Node root) 
    {
        //Add your code here.
        ArrayList<Node> nodes = new ArrayList<Node>();
        storeBSTNodes(root, nodes); 
        int n = nodes.size(); 
        return buildTreeUtil(nodes, 0, n - 1); 
    }
}
