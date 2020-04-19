// Given a Linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f 
// Example:
// Input:
// 2
// 4
// 1 2 3 4 
// 5
// 11 15 20 5 10

// Output:
// 1 3 2 4
// 11 20 5 15 10
// { Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
class ZigZag{
	static Node head;
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
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			if(n!=0){
			ZigZag llist = new ZigZag();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i=1;i<n;i++) {
                int a=sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
			}
		GfG g=new GfG();
		g.zigzag(head);
		head=null;
		}
	}
}// } Driver Code Ends
/*Complete the Function Provided
Node is as follows:
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class GfG{
	public static void zigzag(Node phead){
        //add code here.
        Node head = phead;
        boolean flag = true; 
        while(head!=null && head.next!=null){
            if (flag)  
            { 
                if (head.data > head.next.data) 
                { 
                    int temp  = head.data; 
                    head.data = head.next.data; 
                     head.next.data=  temp; 
                } 
                  
            } 
            else 
            { 
                if (head.data < head.next.data) 
                { 
                    int temp  = head.data; 
                    head.data = head.next.data; 
                     head.next.data=  temp; 
                } 
            } 
            flag = !flag;
            if(head.next.next==null)
                break;
            head=head.next;
        }
        while(phead!=null){
            System.out.print(phead.data+" ");
            phead=phead.next;
        }
        System.out.println();
    }
}
