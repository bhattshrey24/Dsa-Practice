import java.util.Scanner;
import java.util.Stack;

import Graph.WeightedDirectedGraph;

public class DFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v = sc.nextInt();
		int e = sc.nextInt();
		System.out.println();
		WeightedDirectedGraph grf = new WeightedDirectedGraph(v);
		for (int i = 0; i < e; i++) {
			System.out.println("Enter source and destination");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = 0;
			grf.addEdge(source, destination, weight);
			;
		}
		System.out.println("the starting vertex for dfs : ");
		int start = sc.nextInt();

		// dfs(grf,start);
		boolean visited[] = new boolean[grf.adj.length];
		// dfsRecursion(grf,visited,start);
		dfs(grf, start);
		sc.close();
	}

	public static void dfs(WeightedDirectedGraph gf, int startVertex) {// this is stack implementation and stack
																		// implementation is better if number of
																		// elements in grpah is large cause if we use
																		// recursion then we will reach memory overflow
																		// cause it will create new stack frame for each
																		// call but if we use stack class it will just
																		// make an stack object in heap
		// Some problem with this fix later
		boolean[] visited = new boolean[gf.adj.length];
		Stack<Integer> st = new Stack<>();

		// rm*wa*(remove->mark->work->add)
		st.add(startVertex);
		while (!st.isEmpty()) {
			int curr = st.pop();

			if (visited[curr]) {
				continue;
			}
			visited[curr] = true;
			System.out.println(curr);
			for (WeightedDirectedGraph.Edge nbr : gf.adj[curr]) {
				if (!visited[nbr.vertice]) {
					st.add(nbr.vertice);
				}

			}

		}

//		for(boolean x:visited) {
//			System.out.println(x);
//		}

	}

	public static void dfsRecursion(WeightedDirectedGraph gf, boolean[] visited, int vertx) {

		if (visited[vertx]) { // base case
			return;
		}
		visited[vertx] = true; // marking visited
		
		System.out.println(vertx);// work

		for (WeightedDirectedGraph.Edge nbr : gf.adj[vertx]) {
			if (!visited[nbr.vertice]) {// if neighbor not visited then do dfs
				dfsRecursion(gf, visited, nbr.vertice); // adding neighbors
			}
			// .add(nbr.vertice);
		}

		System.out.println("bg");// this is where you do stuff that you want to do when this function backtracks

	}

}
