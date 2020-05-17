// { Driver Code Starts
//Initial Template for Java
//print nodes having k leaves
// Testcase 2:
//             0
//           /    \
//         1      2
//               /
//             4
//           /    \
//         5      9
// Nodes with data 2 and 4, have 2 leaves in the subtree below it.
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Main
{
    static Node buildTree(String str)
    {
        
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
    
    public static void main (String[] args) throws IOException
    {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t-- > 0)
        {
            int k=Integer.parseInt(br.readLine());
            
            String s = br.readLine();
            Node root = buildTree(s);
            
            GfG g = new GfG();
            g.btWithKleaves(root,k);
        }
	}
}

// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}*/

class GfG
{
    public static HashSet<Integer> hs = new HashSet<>();
    int flag=1;
    static int kLeaves(Node ptr,int k)  
    {  
        // Base Conditions : No leaves  
        if (ptr == null)  
            return 0;  
      
        // if node is leaf  
        if (ptr.left == null && ptr.right == null)  
            return 1;  
      
        // total leaves in subtree rooted with this  
        // node  
        int total = kLeaves(ptr.left, k) + kLeaves(ptr.right, k);  
      
        // Print this node if total is k  
        if (k == total) {
            System.out.print(ptr.data + " ");  
            hs.add(ptr.data);
        }
        
        return total;  
    }  
    public void btWithKleaves(Node root, int k){
        //add code here.
        hs.clear();
        kLeaves(root, k);
        if(hs.isEmpty()){
            System.out.print(-1);
        }
        System.out.println();
    }
}
