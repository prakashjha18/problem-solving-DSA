import java.util.*;

class WeightedNode  {
	public int name;

	public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode parent;
	public int distance;

	public WeightedNode(int name) {
		this.name = name;
		distance = Integer.MAX_VALUE;
	}

}
class comparator implements Comparator<WeightedNode> { 
  
    public int compare(WeightedNode node0, WeightedNode node1) 
    { 
        return node0.distance - node1.distance; 
    } 
}
class Prims {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	void prims(WeightedNode node) {
        for (int counter = 0; counter < nodeList.size(); counter++) {
            nodeList.get(counter).distance = (Integer.MAX_VALUE);
        } 
        node.distance= 0; 
	  
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>(new comparator());
		
		queue.addAll(nodeList);
		while (!queue.isEmpty()) {
            
			WeightedNode presentNode = queue.remove();
			
			for (WeightedNode neighbor : presentNode.neighbors) {

                if (queue.contains(neighbor)) {
                    
					if (neighbor.distance > presentNode.weightMap.get(neighbor)) {
                        neighbor.distance  = (presentNode.weightMap.get(neighbor));
                        neighbor.parent = (presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
                    }
                    //System.out.print(neighbor.name+" "+neighbor.distance+"__");
				}
			}
		}
		
		int cost = 0;
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck.name + ", Parent: " + (nodeToCheck.parent==null? -1:nodeToCheck.parent.name)+ ", key: " + nodeToCheck.distance );
			cost = cost + nodeToCheck.distance;
		}
		
		System.out.println("\nTotal cost of MST: " + cost);
	}


	public void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second,d);
		second.weightMap.put(first, d);
	}
	
}

public class primsadjmatrix {

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(i));
        }   
		Prims graph = new Prims(nodeList);
		//Add A<-> B , weight 10
		graph.addWeightedUndirectedEdge(0,1,10);
		graph.addWeightedUndirectedEdge(0,2,20);
		graph.addWeightedUndirectedEdge(1,2,30);
		graph.addWeightedUndirectedEdge(1,3,5);
		graph.addWeightedUndirectedEdge(2,3,15);
		graph.addWeightedUndirectedEdge(2,4,6);
		graph.addWeightedUndirectedEdge(3,4,8);
		
		System.out.println("Printing Prim's Algo from source: A");
		graph.prims(nodeList.get(0));
		
	}
}

