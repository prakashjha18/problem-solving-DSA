// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class reversealtnodes
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            GfG gfg = new GfG();
            gfg.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
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
class GfG
{
    public static void rearrange(Node odd)
    {
        // add your code here
//         Node even=new Node(0);
//         Node befodd=odd;
//         Node evencopy=even;
//         while(odd!=null && odd.next!=null){
//             even.next=odd.next;
//             even=even.next;
//             odd.next=odd.next.next;
//             befodd=odd;
//             odd=odd.next;
            
//         }
//         even.next=null;
//         evencopy=evencopy.next;
//         Node temp = evencopy;
//         Node curr = evencopy;
//         Node prev = null;
//         while(curr!=null){
//             temp=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
//         if(odd!=null)
//             odd.next=prev;
//         else
//             befodd.next=prev;
        //APPROACH TWO
        // add your code here
        if (odd == null || odd.next == null || odd.next.next == null) { 
            return; 
        } 
        Node even=odd.next;
        odd.next=odd.next.next;
        odd = odd.next; 
        even.next=null;
        while (odd != null && odd.next != null) { 
            Node temp=odd.next.next;
            odd.next.next=even;
            even=odd.next;
            odd.next=temp;
            if (temp != null) { 
                odd = temp; 
            } 
            
        }
        odd.next = even; 
    }
}
