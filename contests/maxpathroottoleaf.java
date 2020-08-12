// { Driver Code Starts
// Initial Template for Java

/*

You are given a binary tree, you need to find maximum path sum from root to leaf. You are also allowed 
to do at most one operation. The operation says you can multiply any node data by -1.

Note: This operation can be performed at most 1 times.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single 
line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node
values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
For each test case, print the maximum path sum from root to leaf when you are allowed to do at most one 
operation as mentioned above.

Your Task:
Your task is to complete the function maxRootToLeafPathSum() which takes root pointer as parameter and
returns an integer.

Constraints:
1 <= T <= 100
1 <= Number of Nodes <= 10000
0 <= |Data on Node| <= 10000

Example:
Input:
2
0 -75 -20 3 1 75 7 N N 30 10 3 N
0 -4 -3 14 N N 23
Output:
106
26

Explanation:
Test Case 1:                                 0
                                     /          \
                                -75            -20
                              /       \         /      \
                             3        1      75       7
                                    /    \     /
                                 30      10   3


Without changing any node value, the path sum from root to leaves are respectively 
-72, -44, -64, 58, -13. 
If -75 is changed to 75 then the maximum path sum will be 106 (i.e. 0+75+1+30).*/

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

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String treeString = br.readLine();
            Node root = buildTree(treeString);
            Tree tree = new Tree();
            int ans = tree.maxRootToLeafPathSum(root);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Tree {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    ArrayList<Integer> minarr = new ArrayList<Integer>();
    public int maxRootToLeafPathSum(Node root) {
        // code here.
        arr.clear();
        minarr.clear();
        int sum=0;
        printPathsRecur(root,sum,Integer.MAX_VALUE);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            max=Math.max(max,Math.max(arr.get(i),arr.get(i)-2*minarr.get(i)));
        }
        // System.out.print(arr);
        // System.out.print(minarr);
        return max;
    }
    void printPathsRecur(Node node, int sum,int mini)  
    { 
        if (node == null) 
            return; 
   
    
        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) {
            sum+=(node.data);
            minarr.add(Math.min(mini, node.data));
            arr.add(sum);
        }
        else { 
            printPathsRecur(node.left, sum+(node.data),Math.min(mini, node.data)); 
            printPathsRecur(node.right, sum+(node.data),Math.min(mini, node.data)); 
        } 
    } 
}
