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

  public class DeleteMiddle {
    Node head; // head of list
    Node tail; // tail reference of list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            //   Node temp = head;
            //   while (temp.next != null)
            //     temp = temp.next;

            tail.next = node;
            tail = tail.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            DeleteMiddle llist = new DeleteMiddle();
            // int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new GFG().Delete(llist.head);

            llist.printList();

            t--;
        }
    }
}// } Driver Code Ends
/* class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}*/

class GFG {
    Node Delete(Node head) {
        Node slow=head;Node fast=head;Node prev=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev = slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
}
