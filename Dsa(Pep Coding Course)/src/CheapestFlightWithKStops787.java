import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops787 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		int[][] flight = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
		System.out.println(findCheapestPrice(4, flight, 0, 3, 1));
		// int[][] flight = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1,
		// 4, 1 }, { 4, 2, 1 } };
		// System.out.println(findCheapestPrice(5, flight, 0, 2, 2));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

		WeightedDirectedGrf grf = new WeightedDirectedGrf(n);
		int sol = 0;
		for (int i = 0; i < flights.length; i++) {
			int from = flights[i][0];
			int to = flights[i][1];
			int price = flights[i][2];
			grf.addEdge(from, to, price);
		}

		boolean visited[] = new boolean[grf.adj.length];
		int ans[] = new int[grf.adj.length];
		for (int i = 0; i < ans.length; i++) {
			if (i == src) {
				ans[i] = 0;
			} else {
				ans[i] = Integer.MAX_VALUE;
			}
		}

		int[] prev = new int[n];
		// ans is curr array
		for (int z = 0; z <= k; z++) { // simply processing each vertex v-1 times
			prev = ans.clone();
			for (int i = 0; i < n; i++) {
				if (prev[i] == Integer.MAX_VALUE) {
					continue;
				}
				// basically we make kth array using k+1
				for (int j = 0; j < grf.adj[i].size(); j++) {
					
					WeightedDirectedGrf.Edge edge = grf.adj[i].get(j);
					
					if (prev[i] + edge.weight < ans[edge.vertice]) {
						ans[edge.vertice] = prev[i] + edge.weight;
					}
				}

			}
		}
		if (ans[dst] == Integer.MAX_VALUE) {// infinity at destination means its not possible to reach at destination
											// with k steps
			return -1;
		}
		return ans[dst];
	}

	public static class WeightedDirectedGrf {

		public LinkedList<Edge> adj[];// array of linked List

		public WeightedDirectedGrf(int v) {
			adj = new LinkedList[v];// we are initializing adj array , we are just telling its size
			for (int i = 0; i < v; i++) { // assuming vertices starts from 0
				adj[i] = new LinkedList<Edge>();// we are connecting a empty linked list to every vertex i.e element of
												// array adj
			}
		}

		class Edge {
			int vertice;
			int weight;

			Edge(int v, int w) {
				vertice = v;
				weight = w;
			}
		}

		public void addEdge(int source, int destination, int weight) {
			adj[source].add(new Edge(destination, weight));// simply adding the a node in linkedlist of vertice 'source'
		}

	}

}