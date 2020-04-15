// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class SwappairwiseLL {
    static Node head;
    static Node last;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);

            addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            head = gfg.pairwiseSwap(head);
            printList(head);
            System.out.println();
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            last=head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;
            last.next = node;
            last=last.next;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends
/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
// complete the below function
class GfG {
    public static Node pairwiseSwap(Node node) {

        // add your code here
        Node curr = node;
        if(node == null || node.next==null) return node;
        while(curr!=null && curr.next!=null){
            int x = curr.data;
            curr.data = curr.next.data;
            curr.next.data=x;
            curr = curr.next.next;
        }
        return node;
    }
}
