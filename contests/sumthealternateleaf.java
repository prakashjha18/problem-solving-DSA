/*package whatever //do not write package name here */
/*You need to build a BST from the given array A of size N. The array contains distinct elements. You need 
to build the tree using the Array elements in the order of their arrival (A[0] becomes root and so on). Now, you need to sum the alternate leaf nodes of this BST and print the result.
Note: Start from the left side of the tree when searching for leaf nodes. So sum leaftnode1+leaftnode3+leafnode5 ...

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase
contains two lines of input. The first line contains N. The second line contains array elements.

Output:
For each testcase, in a new line, print the sum of alternate leaf nodes.

Constraints:
1 <= T <= 200
1 <= N <= 107
1 <= Ai <= 108

Examples:
Input:
1
6
5 1 2 3 4 6
Output:
4

Explanation:
Testcase1:
The BST will look like :
            5
          /     \
        1        6
         \         
            2                
               \          
                3  
                    \
                        4
As it is evident from the above BST, the leaf nodes are 4 and 6. So sum of alternate leaf nodes would be 4.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    Node left,right;
    int data;
    Node(int x)
    {
        data=x;
        left=null;
        right=null;
    }
}
class GFG {
    static Node root=null;
    static int c=1,sum=0;
	public static void main (String[] args) throws Exception{
		//code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    int n= Integer.parseInt(br.readLine());
		    String str[] = br.readLine().split("\\s+");
		    int a[]=new int[n];
		    root=null;
		    c=1;
		    sum=0;
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(str[i]);
		        root= insert(root,a[i]);
		    }
		    //print(root);
		    cal(root);
		    System.out.println(sum);
		}
	}
	public static Node insert(Node root,int d){
	    if(root==null){
	        root =new Node(d);
	        return root;
	    }
	    if(root.data>d){
	        root.left = insert(root.left,d);
	    } 
	    else {
	        root.right = insert(root.right,d);
	    }
	    return root;
	}
	public static void cal(Node root){
	    if(root==null)
	        return;
	    if(root.left==null && root.right==null){
	        if(c%2!=0){
	            //System.out.print(root.data+"__");
	            sum+=root.data;
	        }
	        c++;
	    } else {
	        cal(root.left);
	        cal(root.right);
	    }
	}
	public static void print(Node root){
	    if(root!=null){
	        print(root.left);
	        System.out.print(root.data+"  ");
	        print(root.right);
	    }
	}
	
}
