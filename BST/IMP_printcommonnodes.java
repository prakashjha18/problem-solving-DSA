// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            BST g=new BST();
            g.printCommon(root1,root2);
            System.out.println();
            
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node (int d){
		data=d;
		left=right=null;
	}
}
*/
class BST
{
	public void printCommon(Node root1,Node root2)
    {
        Stack<Node> s1 = new Stack<Node> ();  
        Stack<Node> s2 = new Stack<Node> (); 
      
        while (true)  
        {  
            // push the Nodes of first tree in stack s1  
            if (root1 != null)  
            {  
                s1.push(root1);  
                root1 = root1.left;  
            }  
      
            // push the Nodes of second tree in stack s2  
            else if (root2 != null)  
            {  
                s2.push(root2);  
                root2 = root2.left;  
            }  
      
            // Both root1 and root2 are NULL here  
            else if (!s1.isEmpty() && !s2.isEmpty())  
            {  
                root1 = s1.peek();  
                root2 = s2.peek();  
      
                // If current keys in two trees are same  
                if (root1.data == root2.data)  
                {  
                    System.out.print(root1.data + " ");  
                    s1.pop();  
                    s2.pop();  
      
                    // move to the inorder successor  
                    root1 = root1.right;  
                    root2 = root2.right;  
                }  
      
                else if (root1.data < root2.data)  
                {  
                    // If Node of first tree is smaller, than that of  
                    // second tree, then its obvious that the inorder  
                    // successors of current Node can have same value  
                    // as that of the second tree Node. Thus, we pop  
                    // from s2  
                    s1.pop();  
                    root1 = root1.right;  
      
                    // root2 is set to NULL, because we need  
                    // new Nodes of tree 1  
                    root2 = null;  
                }  
                else if (root1.data > root2.data)  
                {  
                    s2.pop();  
                    root2 = root2.right;  
                    root1 = null;  
                }  
            }  
      
            // Both roots and both stacks are empty  
            else break;  
        }  

    }
}
