// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class FixingBST
{
    static int flag = 1;
    static int c = 0;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = n;
            if(n == 0)
            {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Node temp = null;
             for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    temp = new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                                 temp.left = new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                                 temp.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                    insert(temp, a, a1, lr);
                }
            }
            flag = 1;
            c = 0;
            GfG gfg = new GfG();
            root = gfg.correctBST(root);
            
            inorder(temp, root);
            if(c+1 == m)
            System.out.println(flag);
            else
            System.out.println("0");
            
        }
    }
    
    public static void insert(Node root, int a, int a1, char lr)
    {
         if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }
    
    public static void inorder(Node temp, Node root)
    {
        	if(flag==0){
		      return;
	}
	if(temp==null && root== null)
		return;
	if(root==null){
		flag=0;
		return;
	}
	if(temp==null){
		flag=0;
		return;
	}
	if(temp.data==root.data){
	    c++;
	}
	inorder(temp.left,root.left);
	inorder(temp.right,root.right);
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/

class GfG
{
    Node first, middle, last, prev; 
    void correctBSTUtil( Node root) 
    { 
        if( root != null ) 
        { 
            // Recur for the left subtree 
            correctBSTUtil( root.left); 
  
            // If this node is smaller than 
            // the previous node, it's  
            // violating the BST rule. 
            if (prev != null && root.data < 
                                prev.data) 
            { 
                // If this is first violation, 
                // mark these two nodes as 
                // 'first' and 'middle' 
                if (first == null) 
                { 
                    first = prev; 
                    middle = root; 
                } 
  
                // If this is second violation, 
                // mark this node as last 
                else
                    last = root; 
            } 
  
            // Mark this node as previous 
            prev = root; 
  
            // Recur for the right subtree 
            correctBSTUtil( root.right); 
        } 
    } 
    public void inorder(Node root){
        if(root!=null) {
        inorder(root.left);
        System.out.print(root.data+"__");
        inorder(root.right);
        }
    }
    public Node correctBST(Node root)
    {
        // Your code here
        // Initialize pointers needed  
        // for correctBSTUtil() 
        first = middle = last = prev = null; 
        //inorder(root);
        // Set the poiters to find out  
        // two nodes 
        correctBSTUtil( root ); 
        // Fix (or correct) the tree 
        if( first != null && last != null ) 
        { 
            int temp = first.data; 
            first.data = last.data; 
            last.data = temp;  
        } 
        // Adjacent nodes swapped 
        else if( first != null && middle != 
                                    null )  
        { 
            int temp = first.data; 
            first.data = middle.data; 
            middle.data = temp; 
        } 
        return root;
    }
    
}
