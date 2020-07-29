//https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newnode = new Node(node.val);
        HashMap<Integer, Node> map = new HashMap();
        map.put(node.val,newnode);
        
        LinkedList<Node> queue = new LinkedList();
        queue.add(node);
        //System.out.print(node.val+" ");
        while(!queue.isEmpty()){
            Node n =queue.pop();
            for (Node neighbor : n.neighbors) {
                //System.out.print(neighbor.val+" ");
                if (!map.containsKey(neighbor.val)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                //System.out.print(n.val+"__"+map.get(neighbor.val).val+"  ");
                map.get(n.val).neighbors.add(map.get(neighbor.val)); //add neighbor to new created nodes
            } 
        }
        return newnode;
    }
}
