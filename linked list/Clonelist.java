// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

// The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Clonelist {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node ptr = head;
        while(ptr != null) {
            Node node = new Node(ptr.val);
            map.put(ptr, node);
            ptr = ptr.next;
        }
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
        
        for(Map.Entry<Node, Node> entry : map.entrySet()) {
            entry.getValue().next = map.get(entry.getKey().next);
            if(entry.getKey().random != null) entry.getValue().random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }
}
