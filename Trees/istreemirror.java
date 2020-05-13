// { Driver Code Starts
// INITIAL CODE

// Contributed by Sudarshan Sharma
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class istreemirror {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            String s1 = br.readLine();
            Node root = buildTree(s);
            Node root1 = buildTree(s1);
            Tree g = new Tree();
            if (g.areMirror(root, root1)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {
    boolean areMirror(Node n1, Node n2) {
        // Your code here
        if (n1 == null && n2 == null)
            return true;
   
        if (n1 == null || n2 == null)
            return false;
   
        if (n1.data != n2.data)
            return false;
         
        // There are two possible cases for n1 and n2 to be isomorphic 
        // Case 1: The subtrees rooted at these nodes have NOT been  
        // "Flipped".  
        // Both of these subtrees have to be isomorphic. 
        // Case 2: The subtrees rooted at these nodes have been "Flipped" 
        return 
        (areMirror(n1.left, n2.right) &&  
                                         areMirror(n1.right, n2.left));
    }
}
