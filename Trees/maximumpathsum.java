// { Driver Code Starts
//https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
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

class Main {
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

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);

            GfG g = new GfG();
            System.out.println(g.maxPathSum(root));
        }
    }
}
// } Driver Code Ends


class GfG {
    static class Res { 
        int val; 
    }

    static int maxPathSumUtil(Node node, Res res) { 
  
        // Base cases 
        if (node == null) 
            return 0; 
        if (node.left == null && node.right == null) 
            return node.data; 
  
        // Find maximum sum in left and right subtree. Also 
        // find maximum root to leaf sums in left and right 
        // subtrees and store them in ls and rs 
        int ls = maxPathSumUtil(node.left, res); 
        int rs = maxPathSumUtil(node.right, res); 
  
        // If both left and right children exist 
        if (node.left != null && node.right != null) { 
  
            // Update result if needed 
            res.val = Math.max(res.val, ls + rs + node.data); 
  
            // Return maxium possible value for root being 
            // on one side 
            return Math.max(ls, rs) + node.data; 
        } 
  
        // If any of the two children is empty, return 
        // root sum for root being on one side 
        return (node.left == null) ? rs + node.data 
                : ls + node.data; 
    } 
  
    // The main function which returns sum of the maximum 
    // sum path between two leaves. This function mainly 
    // uses maxPathSumUtil() 
    static int maxPathSum(Node root) 
    { 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
        maxPathSumUtil(root, res); 
        return res.val; 
    } 
}
