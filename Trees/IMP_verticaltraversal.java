// { Driver Code Starts
//Initial Template for Java
// Testcase2:
//              1
//           /     \
//          2       3
//       /     \        \
//     4       5       6
// As it is evident from the above diagram that during vertical traversal 4 will come first, 
// then 2, then 1,5, then 3 and then 6. So the output is 4 2 1 5 3 6.
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
                BinaryTree obj = new BinaryTree();
                obj.verticalOrder(root);
                System.out.println();
    	        
	        }
	}
}
// } Driver Code Ends


//User function Template for Java


/*class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
// class Pair{
// 	public int first;   	// first field of a Pair
// 	public int second;  	// second field of a Pair
// 	public Pair(int first, int second){
// 		this.first = first;
// 		this.second = second;
// 	}
// }
class BinaryTree
{
    public static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
    static void verticalorder(Node root, int level){
        if(root==null)
            return;
        HashMap<Node,Integer> hm= new HashMap<Node,Integer>();
        int hd=0;
        hm.put(root,0);
        Queue<Node> q = new LinkedList<>(); 
        q.add(root); 
        while (!q.isEmpty()) { 
            Node temp = q.remove(); 
            hd=hm.get(temp);
            ArrayList<Integer> levelist = map.get(hd);
            if(levelist == null) {
                 levelist = new ArrayList<Integer>();
                 levelist.add(temp.data);
                 map.put(hd, levelist);
            } else {
                levelist.add(temp.data);
            }
            if (temp.left != null){ 
                q.add(temp.left);
                hm.put(temp.left,hd-1);
            } 
            if (temp.right != null){ 
                q.add(temp.right); 
                hm.put(temp.right,hd+1);
            } 
            
        } 
    }
    static void verticalOrder(Node root){
        map.clear();
        verticalorder(root,0);
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for(Integer n : entry.getValue()){
                System.out.print(n+" ");
            }
        }
    }
}
