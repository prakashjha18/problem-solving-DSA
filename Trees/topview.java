// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
			    g.bottomView(root);
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

// class Node
// {
//     int data; //data of the node
//     int hd; //horizontal distance of the node
//     Node left, right; //left and right references
 
//     // Constructor of tree node
//     public Node(int key)
//     {
//         data = key;
//         hd = Integer.MAX_VALUE;
//         left = right = null;
//     }
// }
// For the above tree, the bottom view is 5 10 3 14 25.
// If there are multiple bottom-most nodes for a horizontal distance from root, 
// then print the later one in level traversal. For example, in the below diagram, 
// 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

//                       20
//                     /    \
//                   8       22
//                 /   \     /   \
//               5      3 4     25
//                      /    \      
//                  10       14
class Pair{
	public int first;   	// first field of a Pair
	public int second;  	// second field of a Pair
	public Pair(int first, int second){
		this.first = first;
		this.second = second;
	}
}
class Tree{
    public static void printBottom(Node root, int dist, int level,
								   Map<Integer, Pair> map){
		if (root == null) {
			return;
		}
        if (!map.containsKey(dist) || level <= map.get(dist).second){
			map.put(dist, new Pair(root.data, level));
		}
		printBottom(root.left, dist - 1, level + 1, map);
		printBottom(root.right, dist + 1, level + 1, map);
	}
    public void bottomView(Node root){
        Map<Integer, Pair> map = new TreeMap<Integer, Pair>();
		printBottom(root, 0, 0, map);
		for (Map.Entry<Integer, Pair> item : map.entrySet()) {
			System.out.print(item.getValue().first + " ");
		}
    }
}
