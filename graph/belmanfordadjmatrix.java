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

class PathFindingByBellmanFord {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	
	public PathFindingByBellmanFord(ArrayList<WeightedNode> nodeList) {
			this.nodeList = nodeList;
			for(WeightedNode aNode: nodeList){
				aNode.distance  = (Integer.MAX_VALUE/10);
			}
	}
	
	void bellmanFord(WeightedNode sourceNode) {
		sourceNode.distance  = (0); 
		
		for (int i = 1; i < nodeList.size(); i++) { 
			for (WeightedNode presentNode : nodeList) {
				for (WeightedNode neighbor : presentNode.neighbors) { 
					if (neighbor.distance > (presentNode.distance + presentNode.weightMap.get(neighbor))) {
						neighbor.distance = ((presentNode.distance + presentNode.weightMap.get(neighbor)));
						neighbor.parent = (presentNode);
					}
				} 
			} 
		} 
		
        System.out.println("Checking for Negative Cycle ...");
        
		for(WeightedNode presentNode: nodeList) {
			for(WeightedNode neighbor: presentNode.neighbors) {
				if(neighbor.distance > (presentNode.distance+presentNode.weightMap.get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.name);
					System.out.println("Old Distance: " + neighbor.distance);
					int newDistance = presentNode.distance+presentNode.weightMap.get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found !");
		
		System.out.println("\n\nPrinting Paths now: ");
		for (WeightedNode nodeToCheck : nodeList) {
			if (nodeToCheck.distance != Integer.MAX_VALUE / 10) {
				System.out.print("Node " + nodeToCheck.name + ", distance: " + nodeToCheck.distance + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck);
			}
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

public class belmanfordadjmatrix {

	public static void main(String[] args) {
		
		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		
		//create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode(i));
		}
		
		//Constructor
		PathFindingByBellmanFord graph = new PathFindingByBellmanFord(nodeList);
		
		graph.addWeightedEdge(0,2,6); //Add A-> C , weight 6
		graph.addWeightedEdge(1,0,3); //Add B-> A , weight 3
		graph.addWeightedEdge(0,3,6); //Add A-> D , weight 6
		//graph.addWeightedEdge(0,3,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT HERE
		graph.addWeightedEdge(3,2,1); //Add D-> C , weight 1
		graph.addWeightedEdge(2,3,2); //Add C-> D , weight 2
		graph.addWeightedEdge(3,1,1); //Add D-> B , weight 1
		graph.addWeightedEdge(4,3,2); //Add E-> D , weight 2
		graph.addWeightedEdge(4,1,4); //Add E-> B , weight 4
		
		graph.bellmanFord(nodeList.get(4));
	}
}
