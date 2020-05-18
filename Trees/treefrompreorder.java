// { Driver Code Starts
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class treefrompreorder
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []pre=new int[n];
            char []preLN=new char[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                pre[i]=b;
            }
            for(int i=0;i<n;i++)
            {
                char c=sc.next().charAt(0);
                preLN[i]=c;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(n,pre,preLN);
            inorder(root);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/
//Function should return the root of the formed binary tree.
class GFG
{
    int node=0;
    Node constructTree(int n, int pre[], char preLN[])
    {
        if(preLN[node]=='L')
            return new Node(pre[node]);
        
        Node temp=new Node(pre[node]);
        node++;
        temp.left=constructTree(n,pre,preLN);
        node++;
        temp.right=constructTree(n,pre,preLN);
        return temp;
    }
}
