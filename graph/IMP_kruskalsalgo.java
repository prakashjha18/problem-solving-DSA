import java.util.*;

class UndirectedEdge {
    public WeightedNode first;
    public WeightedNode second;
    public int weight;
    
    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "Edge (" + first.name + "," + second.name + "), weight=" + weight + "]";
    }
    
}

class WeightedNode  {
	public int name;
	public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
	public boolean isVisited = false;
	public WeightedNode parent;
	public int distance;
    public DisjointSet set; 

	public WeightedNode(int name) {
		this.name = name;
		distance = Integer.MAX_VALUE;
	}
    public String toString() {
        return String.valueOf(name);
    }
}

class DisjointSet {
    
	public ArrayList<WeightedNode> nodes = new ArrayList<>();
	
	public static void makeSet(ArrayList<WeightedNode> nodeList) {
		for(WeightedNode node: nodeList) {
			DisjointSet set = new DisjointSet();
			set.nodes.add(node);
			node.set  = (set);
		}
    }
    
	public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
		if(node1.set.equals(node2.set)) { //if two nodes are of same set then no union needed
			return null;
		}	
		else {
			DisjointSet set1 = node1.set;
			DisjointSet set2 = node2.set;
				ArrayList<WeightedNode> nodeSet1 = set1.nodes;
				for(WeightedNode node: nodeSet1) {
					node.set  = (set2);
					set2.nodes.add(node);
				}
				return set2;
		}
	}
    
    public String toString() {
        return String.valueOf(nodes.get(0));
    }
	
}

class comparator implements Comparator<UndirectedEdge> { 
  
    public int compare(UndirectedEdge o1, UndirectedEdge o2) {
        return o1.weight - o2.weight;
    }
}

class Kruskal {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

	public Kruskal(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
    }
    
	
	// Kruskal algo
	void kruskal() {
		// make disjoint sets for each node
        DisjointSet.makeSet(nodeList);
        
        Collections.sort(edgeList, new comparator());
        
        for(UndirectedEdge ed : edgeList){
            System.out.println(ed.first.name+"  "+ed.second.name+"  "+ed.weight);
        }
		int cost = 0;
		for (UndirectedEdge edge : edgeList) {
            System.out.print(edge.first.set.nodes+"_____"+edge.second.set.nodes);
			if (!edge.first.set.nodes.equals(edge.second.set.nodes)) {
				DisjointSet.union(edge.first, edge.second);
				cost += edge.weight;
				System.out.print("Taken " + edge);
            }
            System.out.print(edge.first.set.nodes+"_____"+edge.second.set.nodes);
            System.out.println();
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}

	
	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex ), nodeList.get(secondIndex), weight);
		WeightedNode first = nodeList.get(firstIndex);
		WeightedNode second = nodeList.get(secondIndex);
		first.neighbors.add(second);
		second.neighbors.add(first);
		first.weightMap.put(second,weight);
		second.weightMap.put(first, weight);
        edgeList.add(edge);
        
	}
}

public class kruskaladjmat {
	public static void main(String[] args) {

		ArrayList<WeightedNode> nodeList = new ArrayList<>();
		for(int i=0;i<4; i++) {
			nodeList.add(new WeightedNode(i));
		}
		Kruskal graph = new Kruskal(nodeList);
		
		graph.addWeightedUndirectedEdge(0,1,10);
		graph.addWeightedUndirectedEdge(0,2,6);
		graph.addWeightedUndirectedEdge(0,3,5);
		graph.addWeightedUndirectedEdge(1,3,15);
		graph.addWeightedUndirectedEdge(2,3,4);
		
		System.out.println("Running Kruskal's Algo on the graph: ");
		graph.kruskal();
	}
}
