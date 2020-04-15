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

  public class insertsortedlist {
    Node head, last;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null)
            // temp = temp.next;
            last.next = node;
            last = last.next;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            GFG2 llist1 = new GFG2();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist1.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist1.addToTheLast(new Node(a));
            }
            llist1.head = head;
            a1 = sc.nextInt();
            GFG obj = new GFG();
            Node start = obj.sortedInsert(llist1.head, a1);
            llist1.printList(start);
        }
    }
}// } Driver Code Ends
/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class GFG {
    Node sortedInsert(Node head, int key) {
        Node new_node = new Node(key);
        Node current; 
         if (head == null || head.data >= new_node.data){ 
            new_node.next = head; 
            head = new_node; 
         } 
         else { 
            current = head; 
            while (current.next != null && 
                   current.next.data < new_node.data) 
                  current = current.next; 
    
            new_node.next = current.next; 
            current.next = new_node; 
         } 
         return head;
    }
}
