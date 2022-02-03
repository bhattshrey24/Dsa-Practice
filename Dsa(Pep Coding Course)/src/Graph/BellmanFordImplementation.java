package Graph;

import java.util.Scanner;

import Graph.WeightedDirectedGraph.Edge;

public class BellmanFordImplementation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v = sc.nextInt();
		int e = sc.nextInt();
		System.out.println();
		WeightedDirectedGraph grf = new WeightedDirectedGraph(v);
		for (int i = 0; i < e; i++) {
			System.out.println("Enter source and destination and weight");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			grf.addEdge(source, destination, weight);
		}
		System.out.println("the starting vertex for bellmanFord : ");
		int start = sc.nextInt();

		// System.out.println();

		bellmanFord(grf, start, e);

	}

	public static void bellmanFord(WeightedDirectedGraph gf, int startVertx, int numOfedges) { // this logic works for
																								// both directed and
																								// undirected just pass
																								// undirected here to
		// step 1 initializing array
		int ans[] = new int[gf.adj.length];
		for (int i = 0; i < ans.length; i++) {
			if (i == startVertx) {// source se source tk ka distance cannot be less than 0
				ans[i] = 0;
			} else {
				ans[i] = Integer.MAX_VALUE;
			}
		}
		// step 2 running bellman ford v-1 times
		for (int i = 0; i < gf.adj.length - 1; i++) {// simply processing each vertex v-1 times

			for (int j = 0; j < gf.adj.length; j++) {// simply traversing over every edge

				if (ans[j] == Integer.MAX_VALUE) {// this is inorder to save us from unnecessary error like if we don't
													// do it then in below 'if' statement it will compare infinity with
													// infinity or try to add something to infinity which will
													// give us error
					continue;
				}
				for (Edge edge : gf.adj[j]) {
					if (ans[j] + edge.weight < ans[edge.vertice]) {// (ans[i] + edge.weight < ans[edge.vertice] means
																	// "Mujhse"(i.e. ans[i] + edge.weight) agar mere
																	// neighbor tk jana (i.e. ans[edge.vertice]) is
																	// cheaper than source se neighbor tk jana using
																	// some other path then choose me
						ans[edge.vertice] = ans[j] + edge.weight;
					}
				}
			}

		}
		// simply printing the answer
		System.out.println("ANSWER :-");
		for (int el : ans) { // if in directed graph any of these comes infinty means we cant go there by any
								// path
			System.out.print(el + " ");
		}

	}

}
