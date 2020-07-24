class Node  { 
    int data; 
    Node left, right; 
   
    public Node(int data)  
    { 
        this.data = data; 
        left = right = null; 
    } 
}
public class bintreetodll  { 
    Node root; 
    Node head; 
    Node prev = null; 
   
    void BinaryTree2DoubleLinkedList(Node root)  { 
        if (root == null) 
            return; 
   
        BinaryTree2DoubleLinkedList(root.left); 
   
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        BinaryTree2DoubleLinkedList(root.right); 
    } 
   
    void printList(Node node) { 
        while (node != null){ 
            System.out.print(node.data + " "); 
            node = node.right; 
        } 
    } 
   
    public static void main(String[] args) { 
        // Let us create the tree as shown in above diagram 
        bintreetodll tree = new bintreetodll(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
        tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36); 
   
        tree.BinaryTree2DoubleLinkedList(tree.root); 
           
        tree.printList(tree.head); 
   
    } 
} 
