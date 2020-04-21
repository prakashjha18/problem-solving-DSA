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


public class deletenoderight
    Node head;
    
    /* Linked list Node*/
    /* Utility functions */
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            LinkedList llist = new LinkedList();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }


            new GfG().compute(llist);
            llist.printList();
            t--;
        }
    }
}// } Driver Code Ends
/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}

public class LinkedList
{
    Node head;
    // Member Methods
}*/

/* This is method only submission.
You only need to complete the below method.*/
class GfG
{
    void compute(LinkedList l)
    {
        // your code here
        Node temp = l.head;
        Node curr = l.head;
        Node prev=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        //return prev;
        //l.head=prev;
        Node head =prev;
        Node maxnode = prev;
        Node temp2;
        while(head!=null && head.next!=null){
            if(maxnode.data>head.next.data){
                temp2 = head.next; 
                head.next = temp2.next; 
                temp2 = null; 
            }
            //System.out.print(head.data);
            else{
            head=head.next;
            maxnode=head;
            }
            
        }
        Node temp1 = prev;
        Node curr1 = prev;
        Node prev1=null;
        while(curr1!=null){
            temp1=curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=temp1;
        }
        l.head=prev1;
    }
}
  
