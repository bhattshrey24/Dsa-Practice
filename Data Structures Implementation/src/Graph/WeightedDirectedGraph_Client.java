package Graph;

public class WeightedDirectedGraph_Client {

	public static void main(String[] args) {
		WeightedDirectedGraph_Implementation Dgraph = new WeightedDirectedGraph_Implementation(3);
		Dgraph.addEdge(0, 1, 10);
		Dgraph.addEdge(1, 2, 20);
		Dgraph.addEdge(2, 3, 30);
		Dgraph.displayGraph();

	}

}
