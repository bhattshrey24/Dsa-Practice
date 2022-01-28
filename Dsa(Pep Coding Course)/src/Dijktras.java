import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

import Graph.WeightedUndirectedGrapg;

public class Dijktras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices and edges in graph");
		int v = sc.nextInt();
		int e = sc.nextInt();
		Dijktras obj = new Dijktras();
		// Dijktras.graph grf= new Dijktras.graph(v);
		WeightedUndirectedGrapg grf = new WeightedUndirectedGrapg(v);
		System.out.println();
		for (int i = 0; i < e; i++) {
			System.out.println("Enter source and destination");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			grf.addEdge(source, destination, weight);

		}

		System.out.println("the source vertex for dijktras");
		int src = sc.nextInt();
		obj.dijktras(grf, src);

	}

	public void dijktras(WeightedUndirectedGrapg gf, int source) {
		boolean[] visited = new boolean[gf.adj.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>(); // here since we re using priority queue therefore we dont have
														// to check for the condition d(u)+c(u)<d(v) manually cause
														// priority queue takes care of it
		pq.add(new Pair(source, String.valueOf(source), 0));

		while (!pq.isEmpty()) {
			Pair curVertex = pq.remove();
			
			if (visited[curVertex.v]) {
				continue;
			}

			visited[curVertex.v] = true;

			System.out.println("Shortest distance From " + source + " to vertex : " + curVertex.v + " via psf: "
					+ curVertex.psf + " wsf: " + curVertex.wsf);

			for (WeightedUndirectedGrapg.Edge nbr : gf.adj[curVertex.v]) {
				if (visited[nbr.vertice] == false) {
					pq.add(new Pair(nbr.vertice, curVertex.psf + nbr.vertice, curVertex.wsf + nbr.weight));
				}

			}
		}
	}

	public class Pair implements Comparable<Pair> {
		int v;// Vertex
		String psf;// (Path So Far)
		int wsf;// (Weight So Far)

		Pair(int v, String psf, int wsf) {
			this.v = v;
			this.wsf = wsf;
			this.psf = psf;
		}

		@Override
		public int compareTo(Dijktras.Pair o) {
			// TODO Auto-generated method stub
			return this.wsf - o.wsf;
		}

	}

}
