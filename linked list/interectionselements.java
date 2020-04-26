// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class LLIntersection
{
    static Node append(Node head, int data)
    {
        if(head == null)
          return new Node(data);
        
            head.next = append(head.next, data);
            return head;
       
    }
    static void printList(Node node)
    {
        if(node == null)
          System.out.print("");
        else{
            while(node != null)
            {
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
        
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        
        while(t-- > 0)
        {
            Node head1 = null;
            Node head2 = null;
            
            int temp = 0;
            int n1 = sc.nextInt();
            
            for(int i = 0; i < n1; i++)
            {
                temp = sc.nextInt();
                
                if(head1 == null)
                  head1 = new Node(temp);
                else head1 = append(head1, temp);
            }
            
            int n2 = sc.nextInt();
            for(int i = 0; i < n2; i++)
            {
                temp = sc.nextInt();
                
                if(head2 == null)
                head2 = new Node(temp);
                else head2 = append(head2, temp);
            }
            
            Node result = new GFG().findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
            
            
        }
    }
}// } Driver Code Ends
//User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}*/
class interectionselements
{
    static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        ArrayList<Integer> arr1 = new ArrayList<>();
         ArrayList<Integer> arr2 = new ArrayList<>();
        while(head1!=null && head2!=null){
            arr1.add(head1.data);
            head1=head1.next;
            arr2.add(head2.data);
            head2=head2.next;
        }
        while(head1!=null){
            arr1.add(head1.data);
            head1=head1.next;
        }
        while(head2!=null){
            arr2.add(head2.data);
            head2=head2.next;
        }
        Collections.sort(arr1);
        Node x = new Node(-1);
        Node a=x;
        for(Integer v:arr1){
            if(arr2.contains(v)){
                x.next=new Node(v);
                x=x.next;
            }
        }
        return a.next;
        
    }
}
