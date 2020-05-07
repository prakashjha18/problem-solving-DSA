// Given 2 Arrays of Inorder and preorder traversal. Construct a tree and print the Postorder traversal. 

// Input:
// First line consists of T test cases. First line of every test case consists of N , denoting the number of elements in array. Second and Third line of every test case consists of Inorder and preOrder traversal of a tree.

// Output:
// Single line output, return the Node of the tree.

// **Use already defined preIndex in template

// Constraints:
// 1<=T<=500
// 1<=N<=1000

// Example:
// Input:
// 1
// 7
// 3 1 4 0 5 2 6 
// 0 1 3 4 2 5 6 
// Output:
// 3 4 1 5 6 2 0

// { Driver Code Starts
import java.util.*;

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

class BuildTree
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int ino[] = new int[n];
            int pre[] = new int[n];
            for(int i = 0; i < n; i++)
              ino[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            GfG gfg = new GfG(0);
            root = gfg.buildTree(ino, pre, 0, n-1);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class GfG
{
    public static int preIndex=0;
    GfG(int ind)
    {
        preIndex = ind;
    }
    
    public static Node buildTree(int in[], int pre[], int inStrt, int inEnd){
       if (inStrt > inEnd) 
            return null; 
            
        Node tNode = new Node(pre[preIndex++]); 
        
        int inIndex = search(in, inStrt, inEnd, tNode.data);
        
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
  
        return tNode;
    }
    static int search(int arr[], int strt, int end, int value) { 
        int i; 
        for (i = strt; i <= end; i++){ 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    } 
}
