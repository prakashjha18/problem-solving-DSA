// { Driver Code Starts
//Code by:Saksham Raj Seth
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class LL{
Node head;
    public void addToTheLast(Node node) {

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
 public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            LL llist = new LL();
			llist.head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
			int value=sc.nextInt();
			Node phead=head;
			while(phead.next!=null){
				phead=phead.next;
			}
			phead.next=head;
            GfG g=new GfG();
			g.insert(head,value,n);
			System.out.println();
        }
    }
}// } Driver Code Ends
/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class insertsortedDLL
{
	public static void insert(Node head,int key,int n)
    {
        Node newnode = new Node(key);
        Node temp = head;
        if (head == null)
        {
            newnode.next = head;
            head = newnode;
        }
        else if(newnode.data<=head.data){
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.next=head;
            head=newnode;
        }
        else{
            while(temp.next!=head && temp.next.data<newnode.data){
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;
            
        }
        temp = head;
        while(temp.next != head)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
