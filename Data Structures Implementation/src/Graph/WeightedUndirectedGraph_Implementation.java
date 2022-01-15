package Graph;

import java.util.LinkedList;

import Graph.WeightedDirectedGraph_Implementation.Edge;

public class WeightedUndirectedGraph_Implementation {

	public LinkedList<Edge> adj[];// array of linked List

	public WeightedUndirectedGraph_Implementation(int v) {
		adj = new LinkedList[v];// we are initializing adj array , we are just telling its size like int []a;
								// a=new int[v];

		for (int i = 0; i < v; i++) { // assuming vertices starts from 0
			adj[i] = new LinkedList<Edge>();// we are connecting a empty linked list to every vertex i.e element of
											// array adj
		}

	}

	static class Edge { // Our graph is made of linkedlist of 'Edge' class instead of 'Integer'
						// the graph will look like a[1]=>(v:2,w:8)->(v:4,w:5)
		int vertice;
		int weight;

		Edge(int v, int w) {
			vertice = v;
			weight = w;
		}
	}

	public void addEdge(int source, int destination, int weight) {
		// creating an undirected graph therefore i connected source with destination as
		// well as destination with source
		adj[source].add(new Edge(destination, weight));// simply adding the a node in linkedlist of vertice 'source'
		adj[destination].add(new Edge(source, weight));// if we simply remove this line then it becomes directed graph
	}

	public void displayGraph() {
		for (int i = 0; i < adj.length; i++) {
			LinkedList<Edge> temp = adj[i];
			int j = 0;
			System.out.print("a["+i+"]=>");
			while (j < temp.size()) {
				System.out.print("| v:" + temp.get(j).vertice + " w:" + temp.get(j).weight + "|-->");
				j++;
			}
			System.out.println();
		}
		System.out.println();
	}
}
