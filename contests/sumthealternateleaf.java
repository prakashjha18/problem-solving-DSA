/*package whatever //do not write package name here */
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
