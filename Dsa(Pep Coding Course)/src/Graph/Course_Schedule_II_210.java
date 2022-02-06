package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import Graph.WeightedDirectedGraph.Edge;

public class Course_Schedule_II_210 {

	public static void main(String[] args) {
		Course_Schedule_II_210 ob = new Course_Schedule_II_210();
		int arr[] = ob.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
// Its a simple topological sort question , simply convert given array to a graph and apply topological sort to it

		// creating the graph out of the given array
		WeightedDirectedGraph grf = new WeightedDirectedGraph(numCourses);
		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][0];
			int v = prerequisites[i][1];
			grf.addEdge(v, u);// observe its v , u and not u , v
		}

		int[] ans = new int[numCourses];
		int indegree[] = new int[numCourses];

		// just initializing inorder array by filling dependency of each vertex
		for (int i = 0; i < grf.adj.length; i++) {
			for (WeightedDirectedGraph.Edge edge : grf.adj[i]) {
				indegree[edge.vertice]++;
			}
		}
		// adding all the vertex with zero dependency to queue
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		// observe here we don't need visited array cause indegree acts like visited
		// cause we only add those neighbors whoe's indegree is 0 and if it was already
		// 0
		// then before adding we subtract the indegree means we make it negative
		// therefore again we wont add it.

		int j = 0;// remember in kahns first we add parent then its child unlike recursive method
					// in which we add child then parent

		while (!q.isEmpty()) {
			int ele = q.remove();// remove

			ans[j] = ele;// work
			j++;

			for (WeightedDirectedGraph.Edge edge : grf.adj[ele]) {
				indegree[edge.vertice]--;// decreasing dependecy
				if (indegree[edge.vertice] == 0) {// checking if the child has no dependency left or not
					q.add(edge.vertice);// adding child
				}
			}

		}

		if (j >= ans.length) {// this is me checking that if we printed all courses or not , if any one of
			// course was not added to the answer means its not possible to take that course
			// i.e. maybe there was a cycle , j>=ans.length means we reached the end of
			// answer array
			return ans;
		} else {
			return new int[0];// simply return empty array meaning its not possible to arrange courses
		}
	}

	public class WeightedDirectedGraph {

		public LinkedList<Edge> adj[];// array of linked List

		public WeightedDirectedGraph(int v) {
			adj = new LinkedList[v];// we are initializing adj array , we are just telling its size
			for (int i = 0; i < v; i++) { // assuming vertices starts from 0
				adj[i] = new LinkedList<Edge>();// we are connecting a empty linked list to every vertex i.e element of
												// array adj
			}
		}

		class Edge { // simply make linked list of this class instead of Integer if your graph is
						// weighted it will look like a[1]=>(v:2,w:8)->(v:4,w:5)
			int vertice;

			Edge(int v) {
				vertice = v;
			}
		}

		public void addEdge(int source, int destination) {
			// creating an undirected graph therefore i connected source with destination as
			// well as destination with source
			adj[source].add(new Edge(destination));// simply adding the a node in linkedlist of vertice 'source'
		}

	}
}
