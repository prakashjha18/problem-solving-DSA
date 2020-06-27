// { Driver Code Starts

// Given a Binary Tree, the task is to complete the function dupSub which takes the root of the tree as 
// the only argument and returns true if the Binary tree contains a duplicate sub-tree of size two or more.

// Input :  Binary Tree 
//               A
//              /    \ 
//           B        C
//          /   \       \    
//         D     E       B     
//                      /  \    
//                     D    E
// Output : Yes

// Note: Two same leaf nodes are not considered as subtree as size of a leaf node is one.

// Input:
// The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
// Each test case contains a string s representing the binary tree.
// For example the string : (a(b()())(c()()) represents the below binary tree
//       a
//     /     \
//   b       c

// Output:
// For each test case output will be 1 if the binary tree contains duplicate sub-tree of size two or more else 0.

// Constraints:
// 1<=T<=50
// 1<=length of string<=100
import java.util.*;
import java.lang.*;

class Node
{
    char data;
    Node left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}


class DuplicateSub
{
  static  class Res
{
    int j;
}
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String str = "";
            str = sc.next();
            Res r = new Res();
            r.j = 0;
            Node root = null;
            root = insertString(root, str, r);
            
            GfG gfg = new GfG();
            boolean res = gfg.dupSub(root);
            if(res == true)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
    public static Node insertString(Node root, String str, Res r)
    {
        if(r.j > str.length())
         return null;
         
        if(str.charAt(r.j) == '(')
	          (r.j)++;
	          
	    if(str.charAt(r.j) != '(' && str.charAt(r.j) != ')')
	    {
	        char n=0;
	             n = str.charAt(r.j);
	             
	       (r.j)++;
	       
	       root = insert(root,n);
	       
	       if(str.charAt(r.j) == ')')
	       {
	           root.left = null;
	           root.right = null;
	           
	           return root;
	       }
	    }
	    
	        if(str.charAt(r.j) == '(')
	             (r.j)++;
	             
	       if(str.charAt(r.j) == ')')
	       {
	           root.left = null;
	       }
	       else
	       {
	            root.left = insertString(root.left, str, r);
	       }
	       
	       while(str.charAt(r.j) == ')')
	              (r.j)++;

	          if(str.charAt(r.j) == '(')
	               (r.j)++;
	               
	       if(str.charAt(r.j) == ')')
	       {
	           root.right = null;
	           (r.j)++;
	       }
	       else
	       {
	           root.right = insertString(root.right, str, r);
	       }
	       
        return root;
    }
    
    public static Node insert(Node root, char n)
    {
        if(root == null)
        {
            root = new Node(n);
            return root;
        }
        else if(n < root.data)
              root = insert(root.left, n);
             
        else if(n > root.data)
             root = insert(root.right, n);
     
     return root;   
    }
    
    
}
// } Driver Code Ends



/*node class of the binary tree
class Node
{
    char data;
    Node left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}*/
class GfG
{
    static Set<String> subtrees = new HashSet<String>();
    public static boolean dupSub(Node root)
    {
        if(subtrees.size()>0){
            subtrees.clear();
        }
        
        return dupSub1(root);
    }
    
    public static boolean dupSub1(Node root)
    {
        String s="",s1;
        //System.out.print(subtrees+"  ");
        if(root!=null){
        
            s+=root.data;
            s1=new String(s);
        
            if(root.left!=null){
                s+=root.left.data;
                s1+=root.left.data;
            }
            else{
                s+="$";
            }
        
            if(root.right!=null){
                s+=root.right.data;
                s1+=root.right.data;
            }
            else{
                s+="#";
            }
            
            if(subtrees.contains(s)){
                return true;
            }
            
            if(s1.length()>1){
                subtrees.add(s);
            }
            
            return (dupSub1(root.left) || dupSub1(root.right));
        }
        else{
            return false;
        }
    }
}
