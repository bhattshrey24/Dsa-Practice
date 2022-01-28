import java.util.HashSet;
import java.util.Scanner;

import Graph.WeightedUndirectedGrapg;

// this is same as Ap just difference is instead of vertex here we will find edges that breaks our grapg in 2 or more components
public class Bridges {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		DisplayBridges(grf);
	}

	public static void DisplayBridges(WeightedUndirectedGrapg gf) {

		// here its same as Ap just 1 condition is slightly changed i.e instead of
		// low[nbr.vertice] >= discovery[vertx] we use strict bounds that is
		// low[nbr.vertice] > discovery[vertx]
// we dont even have to manage the actual source thing here 
		boolean[] visited = new boolean[gf.adj.length];
		int[] discovery = new int[gf.adj.length];
		int[] parent = new int[gf.adj.length];
		int[] low = new int[gf.adj.length];
		int discoveredAt = 0;
		
		HashSet<String> isBridge = new HashSet<>(); // we used hashset cause we want to add one edge only once to the
													// answer

		for (int i = 0; i < gf.adj.length; i++) {
			if (!visited[i]) {
				dfs(gf, visited, i, low, parent, discovery, discoveredAt, isBridge);
			}
		}

		System.out.println("Bridges Are :-");
		int numberofBridges = 0;
		for (String edge : isBridge) {
			numberofBridges++;
			System.out.println(edge);
		}
		if (numberofBridges > 0) {
			System.out.println("Number of Bridges are : " + numberofBridges);
		} else {
			System.out.println("There are no Bridges");
		}
	}

	public static void dfs(WeightedUndirectedGrapg gf, boolean[] visited, int vertx, int[] low, int[] parent,
			int[] discovery, int discoverdAt, HashSet<String> isBridge) {

		if (visited[vertx]) { // base case
			return;
		}
		visited[vertx] = true; // marking visited

		discovery[vertx] = discoverdAt;// work
		low[vertx] = discoverdAt;// work
		discoverdAt++;// work

		for (WeightedUndirectedGrapg.Edge nbr : gf.adj[vertx]) {
			if (parent[vertx] == nbr.vertice) {
				continue; // that is dont do anything if current nbr is your parent just ignore this
							// neighbor completely
			} else if (visited[nbr.vertice]) {// if neighbor not visited then do dfs
				low[vertx] = Math.min(low[vertx], discovery[nbr.vertice]);
			} else {

				parent[nbr.vertice] = vertx;// since we are about to go in dfs so before that make current vertex as
											// father of the neighbor jispr dfs lagne jaara hai
				dfs(gf, visited, nbr.vertice, low, parent, discovery, discoverdAt, isBridge);

				// now we come here when BACKTRACKING

				low[vertx] = Math.min(low[vertx], low[nbr.vertice]);// now here we used low of neighbor and not
																	// disFcovery cause while backtracing we obviously
																	// will return in same path in whic dfs was run and
																	// since previously in if block where we checked "is
																	// visited" we updated low with discovery of
																	// neighbor and not low with low of neighbor
				// neighbor therefore right now our neighbor's low
				// can not be less than that(i.e discovery of our
				// neighbor's neighbor) therefore we wont cross any
				// path of dfs

				if (low[nbr.vertice] > discovery[vertx]) {// this means that if my neighbor can not reach me or before me then the current edge is bridge
				
					String edg = String.valueOf(vertx) + "," + String.valueOf(nbr.vertice); 
					
					isBridge.add(edg);
				}

			}
		}

	}

}
