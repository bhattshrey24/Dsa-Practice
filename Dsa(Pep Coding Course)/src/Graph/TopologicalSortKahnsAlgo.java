package Graph;
import java.util.ArrayDeque;
import java.util.Scanner;

//KAHNS ALGO
public class TopologicalSortKahnsAlgo {

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
		topologicalSortUsingkahns(grf);
	}

	public static void topologicalSortUsingkahns(WeightedDirectedGraph gf) {
		// Step 1 is to create indegree array

		int[] indegree = new int[gf.adj.length];

		// Step 2 fill this indegree array initially

		for (int i = 0; i < gf.adj.length; i++) {
			for (WeightedDirectedGraph.Edge edge : gf.adj[i]) {
				indegree[edge.vertice] += 1;
			}
		}

		for(int el:indegree) {
			System.out.println(el);
		}
		
		// Step 3 add those in que with indegree == 0
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				que.add(i);
			}
		}

		// Step 4 work till the que is empty its basically multi source bfs

		boolean[] visited = new boolean[indegree.length];

		while (!que.isEmpty()) {
			int currEle = que.remove(); // remove
			if (visited[currEle]) { // check visited
				continue;
			}
			visited[currEle] = true; // if not visited then mark visited

			System.out.print(currEle + "->"); // work

			for (WeightedDirectedGraph.Edge edge : gf.adj[currEle]) {
				if (!visited[edge.vertice]) { // check if neighbor is visited
					indegree[edge.vertice] = indegree[edge.vertice] - 1; // decrease indegree of the neighbor cause its
																			// parent is just removed and printed so
																			// it's indegree/dependency obviously
																			// decreased by 1
					if (indegree[edge.vertice] == 0) { // now check if he became the eldest ancestor or not
						que.add(edge.vertice);// if yes then add in que
					}
				}
			}
		}

	}

}
