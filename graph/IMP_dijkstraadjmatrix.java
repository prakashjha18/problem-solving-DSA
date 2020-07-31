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

class PathFindingByDijkstra {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	
	//Constructor
	public PathFindingByDijkstra(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
	//Dijkstra from a Source Node
	void dijkstra(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<>(new comparator());
		node.distance = 0; 
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			WeightedNode presentNode = queue.remove(); 
			for(WeightedNode neighbor: presentNode.neighbors) { 
				if(queue.contains(neighbor)) { 
					if(neighbor.distance > (presentNode.distance+presentNode.weightMap.get(neighbor))) {
						neighbor.distance  = ((presentNode.distance+presentNode.weightMap.get(neighbor)));
						neighbor.parent = (presentNode);
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}
		
		
		for(WeightedNode nodeToCheck: nodeList) {
			System.out.print("Node "+nodeToCheck.name+", distance: "+nodeToCheck.distance+", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}
	
	private static void pathPrint(WeightedNode node) {
		if(node.parent!=null) {
			pathPrint(node.parent);
			System.out.print("->"+node.name);
		}
		else 
			System.out.print(node.name);
	}
	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second,d);
	}

}

public class dijiktradjmatrix {
	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(i));
		}
		PathFindingByDijkstra graph = new PathFindingByDijkstra(nodeList);
		
		graph.addWeightedEdge(0,2,6); //Add A-> C , weight 6
		graph.addWeightedEdge(0,3,3); //Add A-> D , weight 3
		graph.addWeightedEdge(1,0,3); //Add B-> A , weight 3
		graph.addWeightedEdge(2,3,2); //Add C-> D , weight 2
		graph.addWeightedEdge(4,2,1); //Add D-> C , weight 1
		graph.addWeightedEdge(3,1,1); //Add D-> B , weight 1
		graph.addWeightedEdge(4,1,4); //Add E-> B , weight 4
		graph.addWeightedEdge(4,3,2); //Add E-> D , weight 2
		
		System.out.println("Printing Dijkstra from source: 4");
		graph.dijkstra(nodeList.get(4));
	}	
}
