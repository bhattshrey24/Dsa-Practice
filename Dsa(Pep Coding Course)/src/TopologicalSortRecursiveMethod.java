import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortRecursiveMethod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v= sc.nextInt();
		int e= sc.nextInt(); 
        System.out.println(); 
        WeightedDirectedGraph grf= new WeightedDirectedGraph(v);
        for(int i=0;i<e;i++) {
        	System.out.println("Enter source and destination");
        	int source=sc.nextInt();
        	int destination=sc.nextInt();
        	int weight=0;	
          grf.addEdge(source, destination, weight);;
        }
topologicalSortRecursionMethod(grf);
	}

	public static void topologicalSortRecursionMethod(WeightedDirectedGraph gf) {  // This is simply step 1 of kosaraju  
		LinkedList<Integer> LL = new LinkedList<>();
		boolean[] visited = new boolean[gf.adj.length];

		for (int i = 0; i < visited.length; i++) {// we do this cause we have to apply dfs from all the edges cause we
													// have to add all vertices , and to make sure that visited nodes from one dfs are not visited again by any other dfs we are passing same visited array to every dfs
		
			dfsRecursion(gf, visited, i, LL);// this is multi source dfs
		}

		System.out.println("The topological sort is: ");
		for(int el:LL) {
			System.out.print(el+"->");
		}
		
		
	}

	public static void dfsRecursion(WeightedDirectedGraph gf, boolean[] visited, int vertx, LinkedList<Integer> LL) {

		if (visited[vertx]) { // base case
			return;
		}
		visited[vertx] = true; // marking visited
		System.out.println(vertx);// work

		for (WeightedDirectedGraph.Edge nbr : gf.adj[vertx]) {
			dfsRecursion(gf, visited, nbr.vertice, LL); // adding neighbors
		}
		LL.addFirst(vertx);
	}

}
