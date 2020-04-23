// { Driver Code Starts
import java.util.*;
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class DeleteAllOccuances
{
	Node head;
	void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}
    }
	
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t  =sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			DeleteAllOccuances llist = new DeleteAllOccuances();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			int x = sc.nextInt();
			  GfG g = new GfG(); 
			Node result = g.deleteAllOccurances(llist.head, x);
			llist.printList(result);
		t--;
		}
	}
}// } Driver Code Ends
/* Linked list Node
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class deleteallocc
{
    Node deleteAllOccurances(Node head, int x)
    {
        while(head.data==x){
            head=head.next;
        }
        Node start=head;
        while(head.next!=null){
            if(head.next.data==x)
            {
                head.next=head.next.next;
            }
            else
            {
                head=head.next;
            }
        }
    }
}
