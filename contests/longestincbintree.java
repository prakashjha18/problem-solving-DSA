// { Driver Code Starts
// Initial Template for Java
/*
Find the length of the longest strictly increasing path in a tree. A path here is a sequence of consecutive 
nodes that can start from any node in the tree and end at any node as well.
See examples below for better understanding.

Input:
First line of input contains number of test cases T. Then T test cases follow. For each test case, there 
will be only a single line of input which is a string representing the tree as described below:

The values in the string are in the order of level order traversal of the tree where, numbers denotes node 
values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
Input will be read by driver code.

Output: Output will be an integer value representing the length of the longest strictly increasing path
in the tree in a new line for every test case. Output will be printed by driver code.

Your task: Your task is to complete the function longest_strictly_increasing_path(). This function takes 
head node of tree as argument and returns the length of longest inc path.

Constraints: T <= 1000 ; 1 <= Nodes in a tree <= 1000 ; -104 <= data in nodes <= 104

Example:
Input:
2
5 4 6 2 7 5 15 9 0 N N N 2 N 3
2 3 7 4 5 6 8
Output:
6
3
Explanation:
Testcase 1:
                                           5
                                         /    \
                                      4        6
                                    /    \    /    \
                                  2     7  5    15
                                /   \          \       \ 
                              9     0         2      3
The longest strictly increasing path in this tree is 0-2-4-5-6-15, which covers 6 nodes

Testcase 2:
                                        12
                                       /    \
                                     3      7
                                    /  \    /  \
                                  4   5  6   8
Here the longest paths are 6-7-12 and 6-7-8 both of which span 3 nodes.
*/

// Initial Template for Java

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

class GfG {

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
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Tree g = new Tree();

            System.out.println(g.longest_strictly_increasing_path(root));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Tree {
    int max = 0;

    int longest_strictly_increasing_path(Node head) {
        // Code Here
        max = 0;
        travel(head, 1);
        return max;
    }
    int travel(Node n, int change) {
        int inc_max=0,dec_max=0;
        if(n.left!=null){
            if(n.left.data>n.data) inc_max=travel(n.left, 1);
            else if (n.left.data < n.data)
                dec_max = travel(n.left, 0);
            else
                travel(n.left, 0);
        }
        if(n.right!=null){
            int temp1 = 0, temp2 = 0;
            if(n.right.data>n.data) temp1=travel(n.right, 1);
            else if (n.right.data < n.data)
                temp2 = travel(n.right, 0);
            else
                travel(n.right, 0);
                
            if (temp1 > inc_max) inc_max = temp1;
            if (temp2 > dec_max) dec_max = temp2;
        }
        if(inc_max+dec_max+1>max){
            max = inc_max + dec_max + 1;
        }
        if (change == 1) return inc_max + 1;
        return dec_max + 1;
    }
}
