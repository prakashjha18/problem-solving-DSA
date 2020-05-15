// { Driver Code Starts
// Input :               4
//                     /   \
//                   2    -5
//                   / \    /\
//                 -1   3 -2  6
// Output: 6
// Explanation :
// Sum of all nodes of 0'th level is 4
// Sum of all nodes of 1'th level is -3
// Sum of all nodes of 2'th level is 6
// Hence maximum sum is 6

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
            System.out.println(g.maxLevelSum(root));
        }
    }
}// } Driver Code Ends


/*Complete the finction below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
class GfG {
    public int maxLevelSum(Node root) {
        // add code here.
        if (root == null) 
            return 0; 
        Queue<Node> q = new LinkedList<>(); 
        q.add(root); 
        int result=Integer.MIN_VALUE;
        while (!q.isEmpty()) { 
            int sum = 0;
            int count = q.size(); 
            while (count-- > 0)  { 
                
                Node temp = q.remove(); 
                sum+=temp.data;
                if (temp.left != null){ 
                    q.add(temp.left); 
                } 
                if (temp.right != null){ 
                    q.add(temp.right); 
                } 
            } 
            result=Math.max(sum,result);
        } 
        return result; 
    }
}
