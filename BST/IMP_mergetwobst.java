// { Driver Code Starts
//Initial Template for Java
// First BST 
//       3
//     /     \
//   1       5
// Second BST
//     4
//   /   \
// 2       6
// Output: 1 2 3 4 5 6
/*package whatever //do not write package name here */

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
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
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
        
                  // Create the right child for the curr node
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
            
            Solution T = new Solution();
            List<Integer> ans = T.merge(root1,root2);
            for(int i=0;i<ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution{
    static void inorder(Node root,List<Integer> al) {  
        if (root != null)  
        {  
            inorder(root.left,al);  
            al.add(root.data);
            inorder(root.right,al);  
        }  
    }
    public List<Integer> merge(Node root1,Node root2){
        List<Integer> al = new ArrayList<Integer>();
        Stack<Node> s1 = new Stack<Node> ();  
        Stack<Node> s2 = new Stack<Node> (); 
      
        Node current1 = root1;  
        Node current2 = root2;  
        while (current1 != null || !s1.isEmpty() ||  
            current2 != null || !s2.isEmpty()){  
            if (current1 != null || current2 != null ){  
                if (current1 != null)  
                {  
                      
                    s1.push( current1);  
                    current1 = current1.left;  
                }  
                if (current2 != null)  
                {  
                    s2.push( current2);  
                    current2 = current2.left;  
                }  
            }  
            else{ 
                if (s1.isEmpty()){  
                    while (!s2.isEmpty())  
                    {  
                        current2 = s2.pop ();  
                        current2.left = null;  
                        inorder(current2,al);  
                    }  
                    return al;  
                }  
                if (s2.isEmpty()){  
                    while (!s1.isEmpty())  
                    {  
                        current1 = s1.pop ();  
                        current1.left = null;  
                        inorder(current1,al);  
                    }  
                    return al;  
                }  
      
                current1 = s1.pop(); 
                current2 = s2.pop(); 
                if (current1.data < current2.data){  
                    al.add(current1.data);
                    current1 = current1.right;  
                    s2.push( current2);  
                    current2 = null;  
                }  
                else{  
                    
                   al.add(current2.data);
                    current2 = current2.right;  
                    s1.push( current1);  
                    current1 = null;  
                }  
            }  
        } 
        return al;
    }
}
