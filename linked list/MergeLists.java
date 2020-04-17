// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;

    public void addToTheLast(Node node)
    {

      if (head == null) {
           head = node;
          } else {
           Node temp = head;
           while (temp.next != null)
            temp = temp.next;
        
           temp.next = node;
        }
    }


  /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	 
 
     /* Driver program to test above functions */
    public static void main(String args[])
    {
       
         
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t>0)
         {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeLists llist1 = new MergeLists();
		    MergeLists llist2 = new MergeLists();
			
				int a1=sc.nextInt();
				Node head1= new Node(a1);
				llist1.addToTheLast(head1);
				if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) 
				{ 
					//int a;
 
					 int a = sc.nextInt(); 
					llist1.addToTheLast(new Node(a));
				}
			
			
				int b1=sc.nextInt();
				Node head2 = new Node(b1);
				llist2.addToTheLast(head2);
				if (sc.hasNextInt()) 
				for (int i = 1; i < n2; i++) 
				{
					//int b;
					
					 int b = sc.nextInt(); 
					llist2.addToTheLast(new Node(b));
				}
				llist1.head= new LinkedList().sortedMerge(llist1.head,llist2.head);
				llist1.printList();
			
			t--;
			
         }
    }
}
// } Driver Code Ends
/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class LinkedList
{
    Node sortedMerge(Node headA, Node headB) {
        // Node dummyNode = new Node(0); 
        // Node tail=dummyNode;
        // Node p = headA;
        // Node q = headB;
        // while (headA != null || headB != null) {
        //     if(headA == null) { 
        //         tail.next = headB; 
        //         break; 
        //     } 
        //     if(headB == null){ 
        //         tail.next = headA; 
        //         break; 
        //     } 
        //     if(headA.data <= headB.data){ 
        //         tail.next = headA; 
        //         headA = headA.next; 
        //     }  
        //     else{ 
        //         tail.next = headB; 
        //         headB = headB.next; 
        //     } 
        //     tail = tail.next; 
        // }
        // return dummyNode.next;
        if(headA == null) return headB; 
        if(headB == null) return headA; 
          
        if(headA.data < headB.data)  
        { 
            headA.next = sortedMerge(headA.next, headB); 
            return headA; 
        } 
        else 
        { 
            headB.next = sortedMerge(headA, headB.next); 
            return headB; 
        } 
   } 
}
