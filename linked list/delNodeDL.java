// { Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node temp;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
		}
		else
		{
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = node;
			node.prev = temp;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			GfG g = new GfG();
			list.temp = head;
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               // } Driver Code Ends
//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class delNodeDL
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
        Node t = head;
        Node p = null;
        if(x == 1) {
        head = head.next;
        head.prev = null;
            return head;
        }
        while(x-- > 0 && t != null) {
            p = t;
            t = t.next;
        }
        if(p != null && p.prev != null) {
            p.prev.next = t;
            if(t != null) t.prev = p.prev;
        }
        
        return head;
    }
}
