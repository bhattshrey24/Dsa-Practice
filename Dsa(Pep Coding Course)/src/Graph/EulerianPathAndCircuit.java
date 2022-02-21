package Graph;
import java.util.Scanner;

// this is just for true and false that whether EP and EC exsists or not and not finding the path 
public class EulerianPathAndCircuit {

	public static void main(String[] args) {
		System.out.println("Press 1 for Directed graph and 2 for Undirected graph");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input == 1) {
			System.out.println("Enter number of vertices and edges in graph");
			int v = sc.nextInt();
			int e = sc.nextInt();
			WeightedDirectedGraph grf = new WeightedDirectedGraph(v);
			System.out.println();
			for (int i = 0; i < e; i++) {
				System.out.println("Enter source and destination");
				int source = sc.nextInt();
				int destination = sc.nextInt();
				int weight = 0;
				grf.addEdge(source, destination, weight);
			}
			ECforDirectedGraph(grf);
			EPforDirectedGraph(grf);
		} else {
			System.out.println("Enter number of vertices and edges in graph");
			int v = sc.nextInt();
			int e = sc.nextInt();
			WeightedUndirectedGrapg grf = new WeightedUndirectedGrapg(v);
			System.out.println();
			for (int i = 0; i < e; i++) {
				System.out.println("Enter source and destination");
				int source = sc.nextInt();
				int destination = sc.nextInt();
				int weight = 0;
				grf.addEdge(source, destination, weight);
			}
			ECforUndirectedGraph(grf);
			EPforUndirectedGraph(grf);
		}

	}

	public static void ECforUndirectedGraph(WeightedUndirectedGrapg gf) {// not considering self loops right now
		int degree[] = new int[gf.adj.length];
		for (int i = 0; i < gf.adj.length; i++) {
			degree[i] = gf.adj[i].size();// this imply returns number of children this vertex has and number of children
											// is equal to degree of vertex
		}
		boolean ecExists = true;
		for (int deg : degree) {
			if (deg % 2 != 0) {
				ecExists = false;
				break;
			}
		}
		if (ecExists) {
			System.out.println("Eularian circuit Exsists");
		} else {
			System.out.println("Eularian circuit doesnot Exsists");
		}

	}

	public static void ECforDirectedGraph(WeightedDirectedGraph gf) {
		int indegree[] = new int[gf.adj.length];
		int outdegree[] = new int[gf.adj.length];

		for (int i = 0; i < gf.adj.length; i++) {
			indegree[i] = gf.adj[i].size();// indegree means that current vertex ke kitne bache hai
			for (WeightedDirectedGraph.Edge edge : gf.adj[i]) {
				outdegree[edge.vertice] += 1; // out degree means ki app kitno ke bache ho
			}
		}
		boolean ecExists = true;

		for (int i = 0; i < gf.adj.length; i++) {
			if (indegree[i] != outdegree[i]) {
				ecExists = false;
				break;
			}
		}
		if (ecExists) {
			System.out.println("Eularian circuit Exsists");
		} else {
			System.out.println("Eularian circuit doesnot Exsists");
		}
	}

	public static void EPforUndirectedGraph(WeightedUndirectedGrapg gf) {

		int[] degree = new int[gf.adj.length];
		int numberOfOddDegrees = 0;

		for (int i = 0; i < gf.adj.length; i++) {
			degree[i] = gf.adj[i].size();
		}
		boolean epExists = true;
		for (int deg : degree) {
			if (deg % 2 != 0) {
				if (numberOfOddDegrees > 2) {
					break; // no need to check further if numberOfOddDegrees is already greater than 2
				}
				numberOfOddDegrees++;
			}
		}
		if (numberOfOddDegrees == 2 || numberOfOddDegrees == 0) { // numberOfOddDegrees==0 cause that means it has ec
																	// and if graph has ec then it definately has ep
			System.out.println("Eularian path Exsists");
		} else {
			System.out.println("Eularian path doesnot Exsists");
		}

	}

	public static void EPforDirectedGraph(WeightedDirectedGraph gf) {

		int[] indegree = new int[gf.adj.length];
		int[] outdegree = new int[gf.adj.length];
		int numberOfOddDegrees = 0;

		for (int i = 0; i < gf.adj.length; i++) {
			indegree[i] = gf.adj[i].size();// indegree means that current vertex ke kitne bache hai
			for (WeightedDirectedGraph.Edge edge : gf.adj[i]) {
				outdegree[edge.vertice] += 1; // out degree means ki app kitno ke bache ho
			}
		}
		boolean epExists = true;
		int numOfVertxWithSameInandOutDegree = 0;
		int numOfVertxWithExtraPlusOneIndegree = 0;
		int numOfVertxWithExtraPlusOneOutdegree = 0;
		for (int i = 0; i < gf.adj.length; i++) {
			if (indegree[i] == outdegree[i]) {
				numOfVertxWithSameInandOutDegree++;

			} else if (indegree[i] + 1 == outdegree[i]) {
				numOfVertxWithExtraPlusOneIndegree++;

			} else if (indegree[i] == outdegree[i] + 1) {
				numOfVertxWithExtraPlusOneOutdegree++;
			}
		}

		if (numOfVertxWithSameInandOutDegree == gf.adj.length
				|| (numOfVertxWithExtraPlusOneOutdegree == 1 && numOfVertxWithExtraPlusOneIndegree == 1)) { // numOfVertxWithSameInandOutDegree
																											// ==
																											// gf.adj.length
																											// if this
																											// is true
																											// means
																											// graph has
																											// ec and if
																											// ec is
																											// present
																											// then ep
																											// is
																											// definately
																											// present
			System.out.println("Eularian path Exsists");
		} else {
			System.out.println("Eularian path doesnot Exsists");
		}

	}

}
