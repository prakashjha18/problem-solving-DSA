// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}
// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/

// Function should construct tree and return
// root of it.  in[] stores inorder traversal
// post[] stores postorder traversal.  n is
// size of these arrays
class GfG {
    public static int preIndex=0;
    // Complete the function
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        preIndex = n - 1; 
        return buildUtil(in, post, 0, n - 1); 
    }
    Node buildUtil(int in[], int post[], int inStrt, 
                   int inEnd) 
    { 
        // Base case 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Postrder traversal using 
           postIndex and decrement postIndex */
        Node node = new Node(post[preIndex--]); 
  
        /* Else find the index of this node in Inorder 
           traversal */
        int iIndex = search(in, inStrt, inEnd, node.data); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        node.right = buildUtil(in, post, iIndex + 1, inEnd); 
        node.left = buildUtil(in, post, inStrt, iIndex - 1); 
  
        return node; 
    }
    static int search(int arr[], int strt, int end, int value){ 
        int i; 
        for (i = strt; i <= end; i++){ 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    }
}
