// { Driver Code Starts

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

class serializedeser {
    
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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Tree tr=new Tree();
	            ArrayList<Integer> A=new ArrayList<Integer>();
	            tr.serialize(root, A);
	            
	            Node getRoot=tr.deSerialize(A);
	            printInorder(getRoot);
	            System.out.println();
	        }
	}
}// } Driver Code Ends


/*Complete the given function
Node is as follows:
class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}*/
//This Code is developed by: Suman Rana
class Tree {
	public void serialize(Node root, ArrayList<Integer> A) {
	    Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		A.add(root.data);
		if (root == null) {
			return;
		}
		while (!queue.isEmpty()) {
			Node presentNode = queue.remove();
			
			if (presentNode.left != null){
				queue.add(presentNode.left);
				A.add(presentNode.left.data);
			} else {
			    A.add(-1);
			}
			if (presentNode.right!= null){
			    queue.add(presentNode.right);
			    A.add(presentNode.right.data);
			} else {
			    A.add(-1);
			}
				
		}
		System.out.print(A);
	}
	
    public Node deSerialize(ArrayList<Integer> A){
        Integer[] arr = new Integer[A.size()]; 
  
        // ArrayList to Array Conversion 
        for (int i =0; i < A.size(); i++) 
            arr[i] = A.get(i); 
        int n = arr.length;
        Node root=null;
        Node curr=null;
        int index=0;
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(root==null){
                root=new Node(arr[i]);
                q.add(root);
                curr=q.peek();
                index=1;
            }else{
                if(arr[i]==-1){
    
                     if(index==1)
                        index=2;
                    else{
                        q.remove();
                        curr=q.peek();
                        index=1;
                    }
                }
                else if(index==1){
                    curr.left=new Node(arr[i]);
                    q.add(curr.left);
                    index=2;
    
                }else if(index==2){
                    curr.right=new Node(arr[i]);
                    q.add(curr.right);
                    q.remove();
                    curr=q.peek();
                    index=1;
                }
    
            }
        }
        return root;
    }
    
}

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        //System.out.print(res.toString()+"PPPP");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;
        //System.out.print(data+"PPPP");
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
