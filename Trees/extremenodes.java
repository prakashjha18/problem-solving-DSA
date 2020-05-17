// { Driver Code Starts
//remove extreme nodes in alternate order

//Contributed by Sudarshan Sharma
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
    	        g.printExtremeNode(root);
    	        System.out.println();
	        }
	}
}
// } Driver Code Ends


/*Complete The given function
The Node class is as follows:
class Node{
    int data;
    Node left,right;
    
    Node(int d)
     {
      data=d;
      left=null;
      right=null;
    }
}*/
class Tree{
    public  void printExtremeNode(Node root)
    {
        if (root == null)  
        return;  
        Queue<Node> q = new LinkedList<Node>();  
        q.add(root);  
      
        // flag to indicate whether leftmost node or  
        // the rightmost node has to be printed  
        boolean flag = false;  
        while (q.size()>0)  
        {  
            // nodeCount indicates number of nodes  
            // at current level.  
            int nodeCount = q.size();  
            int n = nodeCount;  
      
            // Dequeue all nodes of current level  
            // and Enqueue all nodes of next level  
            while (n-->0)  
            {  
                Node curr = q.peek();  
      
                // Enqueue left child  
                if (curr.left!=null)  
                    q.add(curr.left);  
      
                // Enqueue right child  
                if (curr.right!=null)  
                    q.add(curr.right);  
      
                // Dequeue node  
                q.remove();  
      
                // if flag is true, print leftmost node  
                if (flag && n == nodeCount - 1)  
                    System.out.print( curr.data + " "); 
      
                // if flag is false, print rightmost node  
                if (!flag && n == 0)  
                    System.out.print( curr.data + " ");  
            }  
              
            // invert flag for next level  
            flag = !flag;  
        }  
    }
}
