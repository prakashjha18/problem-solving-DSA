// { Driver Code Starts
import java.util.*;
import java.lang.*;
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}
class CloneABT{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		int n,n1,n2;
		char lr;
		Tree root;
		while(q-->0){
			n=sc.nextInt();
			root=null;
			GfG g=new GfG();
			while(n-->0){
				n1=sc.nextInt();
				n2=sc.nextInt();
				lr=sc.next().charAt(0);
				if(root==null){
					root=new Tree(n1);
					switch(lr){
						case 'L':root.left=new Tree(n2);
						break;
						case 'R':root.right=new Tree(n2);
						break;
					}
				}
				else{
					if(lr=='X')
						clone(root,root,n1,n2);
					else
					insert(root,n1,n2,lr);
				}
			}
		try{Tree z=g.cloneTree(root);
		if(z==root)
        System.out.println("0");
     else
		System.out.println(printInorder(root,z));}catch(ClassCastException ex){}
		}
	}
public static int printInorder(Tree a,Tree b){
    if (((a==null) && (b==null)) || ((a.random==null) && (b.random==null)))
        return 1;
    if(a.random.data == b.random.data) 
		if(printInorder(a.left,b.left)==1) 
			if(printInorder(a.right,b.right)==1)
				return 1;
    return 0;

}
public static void clone(Tree root,Tree proot,int n1,int n2){
	try{if(root==null && proot==null)
		return;
	if(n1==root.data){
		if(proot.data==n2)
			root.random=proot;
		else{
			clone(root,proot.left,n1,n2);
			clone(root,proot.right,n1,n2);
		}
	}
	else{
		clone(root.left,proot,n1,n2);
		clone(root.right,proot,n1,n2);
	}}catch(NullPointerException ex){}
}
public static void insert(Tree root,int n1,int n2,char lr){
	if(root==null)
		return;
	if(n1==root.data){
		switch(lr){
						case 'L':root.left=new Tree(n2);
						break;
						case 'R':root.right=new Tree(n2);
						break;
					}
	}
	else{
		insert(root.left,n1,n2,lr);
		insert(root.right,n1,n2,lr);
	}
}
}// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Tree{
	int data;
	Tree left,right,random;
	Tree(int d){
		data=d;
		left=null;
		right=null;
		random=null;
	}
}*/
class GfG{
    static Tree makeTree(Tree t1,Tree clone)
    {
        if(t1 == null)
            return null;
        if(t1.left!=null){
            clone.left = new Tree(t1.left.data);
            makeTree(t1.left,clone.left);
        }
        if(t1.right!=null){
            clone.right = new Tree(t1.right.data);
            makeTree(t1.right,clone.right);
        }
        return clone;
    }
    public static Tree cloneTree(Tree tree){
        if(tree == null) return null;
        Tree clone = new Tree(tree.data);
        return makeTree(tree,clone);
    }
    
}
