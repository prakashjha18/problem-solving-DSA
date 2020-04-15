// { Driver Code Starts
import java.util.*;
class Node{
int data;
Node next;
Node(int d){
data=d;
next=null;
} 
}
class AddOne{
  static Node head;
	public static void insert(Node node){
		if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			if(n==0){
		System.out.println("1");
		continue;}
			
			head=null;
			while(n>0){
					insert(new Node(n%10));
				n/=10;
			}
		GfG g=new GfG();
		Node mnode=g.addOne(head);
		print(mnode);
		System.out.println();
		}
	}
	public static void print(Node mnode){
	    while(mnode!=null){
	        System.out.print(mnode.data);
	        mnode=mnode.next;
	    }
	}
}// } Driver Code Ends
/*Complete the given Function
Node is as follows
class Node{
int data;
Node next;
Node(int d){
data=d;
next=null;
} 
}*/
class GfG{
	public Node addOne(Node head){
	    
    
        Node ptr = head;
        int x =ptr.data +1;
        ptr.data = ptr.data+1;
        if(x>9){
            
            while(ptr.data>9 && ptr.next!=null){
                ptr.data=0;
                ptr=ptr.next;
                ptr.data=ptr.data+1;
            }
        }
        
        
        Node prev = null;
        Node curr = head;
        Node temp = head;
        while(curr!=null){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        return prev;
    }
    
    
    
    
    
    
    
    
    
    
    
}
