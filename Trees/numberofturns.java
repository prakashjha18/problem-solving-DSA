// { Driver Code Starts
//Initial template for Java
//     Input:   Below Binary Tree and two nodes
//         5 & 6 
//                   1
//                 /     \
//               2        3
//              /   \    /   \
//             4     5   6     7
//           /         / \
//           8         9   10
// Output: Number of Turns needed to reach 
// from 5 to 6:  3
        
// Input: For above tree if two nodes are 1 & 4
// Output: Straight line : 0 turn 
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Tree g = new Tree();
            if((turn = g.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Tree
{
    static int Count; 
    static Node lca(Node node, int n1,int n2){
		if (node == null) 
            return null; 
  
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (node.data == n1 || node.data == n2) 
            return node; 
  
        Node left_lca = lca(node.left, n1, n2); 
        Node right_lca = lca(node.right, n1, n2); 
  
        if (left_lca!=null && right_lca!=null) 
            return node; 
  
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
	}
	static boolean CountTurn(Node root, int key, boolean turn) { 
        if (root == null) 
            return false; 
  
        // if found the key value in tree 
        if (root.data == key) 
            return true; 
  
        // Case 1: 
        if (turn == true) { 
            if (CountTurn(root.left, key, turn)) 
                return true; 
            if (CountTurn(root.right, key, !turn)) { 
                Count += 1; 
                return true; 
            } 
        } else // Case 2: 
        { 
            if (CountTurn(root.right, key, turn)) 
                return true; 
            if (CountTurn(root.left, key, !turn)) { 
                Count += 1; 
                return true; 
            } 
        } 
        return false; 
    } 
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        Node LCA = lca(root, first, second); 
        if (LCA == null) 
            return -1; 
        Count = 0; 
        if (LCA.data != first && LCA.data != second) { 
  
            // count number of turns needs to reached 
            // the second node from LCA 
            if (CountTurn(LCA.right, second, false) 
                    || CountTurn(LCA.left, second, true)) 
                ; 
  
            // count number of turns needs to reached 
            // the first node from LCA 
            if (CountTurn(LCA.left, first, true) 
                    || CountTurn(LCA.right, first, false)) 
                ; 
            return Count + 1; 
        } 
        // case 2: 
        if (LCA.data == first) { 
  
            // count number of turns needs to reached 
            // the second node from LCA 
            CountTurn(LCA.right, second, false); 
            CountTurn(LCA.left, second, true); 
            return Count; 
        } else { 
  
            // count number of turns needs to reached 
            // the first node from LCA1 
            CountTurn(LCA.right, first, false); 
            CountTurn(LCA.left, first, true); 
            return Count; 
        } 
    }
}


