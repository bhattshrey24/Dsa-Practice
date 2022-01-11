import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KruskalsUsingDSU {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v = sc.nextInt();
		int e = sc.nextInt();
		Dijktras obj = new Dijktras();
		WeightedUndirectedGrapg grf = new WeightedUndirectedGrapg(v);
		// we can do same with directed graph too
		System.out.println();
		for (int i = 0; i < e; i++) {
			System.out.println("Enter source and destination");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			grf.addEdge(source, destination, weight);
		}
		kruskalsUsingDSU(grf, e, v);

	}

	public static void kruskalsUsingDSU(WeightedUndirectedGrapg gf, int edges, int vertices) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int[] parent = new int[vertices];
		int[] rank = new int[vertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < rank.length; i++) {
			rank[i] = i;
		}

		for (int i = 0; i < vertices; i++) {
			for (WeightedUndirectedGrapg.Edge edge : gf.adj[i]) {
				pq.add(new Pair(i, edge.vertice, edge.weight)); // adding all edges and since pq is configured to
																// arrange on basis of weight therefore the resultant
																// queue will be sorted based on weight
			}
		}
		int size = pq.size();
		ArrayList<Pair> sol = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Pair remPair = pq.remove();
			if (findLeaderWithPathCompression(remPair.u, parent) != findLeaderWithPathCompression(remPair.v, parent)) {// this
																														// means
																														// cycle
																														// is
																														// not
																														// formed
																														// so
																														// simply
																														// connect
																														// them
																														// vertices
																														// of
																														// edges
				UnionByRank(remPair.u, remPair.v, parent, rank);
				sol.add(remPair);
			} // if cycle is formed then no need to do anything
		}

		for (Pair el : sol) {
			System.out.println(el.u + "->" + el.v + " W:" + el.w);
		}
	}

	public static int findLeaderWithPathCompression(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		int temp = findLeaderWithPathCompression(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

	public static void UnionByRank(int u, int v, int[] parent, int[] rank) {// rank simply means height of tree
		int a = findLeaderWithPathCompression(u, parent);
		int b = findLeaderWithPathCompression(v, parent);
		if (a != b) {
			if (rank[a] > rank[b]) {
				parent[b] = a;
			} else if (rank[a] < rank[b]) {
				parent[a] = b;
			} else {
				parent[b] = a;// here we could also use parent[a]=b
				rank[a]++;
			}
		}
	}

	public static class Pair implements Comparable<Pair> {
		int u, v, w;

		public Pair(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(KruskalsUsingDSU.Pair o) {
			return this.w - o.w;

		}

	}

}
