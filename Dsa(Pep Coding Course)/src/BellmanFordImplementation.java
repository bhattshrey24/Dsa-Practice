import java.util.Scanner;

import Graph.WeightedDirectedGraph;

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
		// step 1 initializing array // get answer for that
		boolean visited[] = new boolean[gf.adj.length];
		int ans[] = new int[gf.adj.length];
		for (int i = 0; i < ans.length; i++) {
			if (i == startVertx) {
				ans[i] = 0;
			} else {
				ans[i] = Integer.MAX_VALUE;
			}
		}
		// step 2 running bellman ford v-1 times

		for (int z = 0; z < gf.adj.length - 1; z++) { // simply processing each vertex v-1 times

			for (int i = 0; i < numOfedges; i++) {// this should be edge number if time not vertices , this adj is quite
													// weird instead of this simply run this algo v-1 times for whole
													// graph

				if (ans[i] == Integer.MAX_VALUE) {
					continue;
				}

				for (int j = 0; j < gf.adj[i].size(); j++) {
					WeightedDirectedGraph.Edge edge = gf.adj[i].get(j);

					if (ans[i] + edge.weight < ans[edge.vertice]) {// (ans[i] + edge.weight < ans[edge.vertice] means
																	// "Mujhse"(ans[i] + edge.weight) agar mere neighbor
																	// tk jana (ans[edge.vertice]) is cheaper than
																	// source se neighbor tk jana using some other path
																	// then choose me
						ans[edge.vertice] = ans[i] + edge.weight;
					}
				}

			}
		}
		System.out.println("ANSWER :-");
		for (int el : ans) { // if in directed graph any of these comes infinty means we cant go there by any
								// path
			System.out.print(el + " ");
		}

	}

}
