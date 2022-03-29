package Graph;
import java.util.Scanner;

import Graph.WeightedDirectedGraph;

public class FloydWarshall {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertice and edges");
		int v = sc.nextInt();
		int e = sc.nextInt();
		WeightedDirectedGraph grf = new WeightedDirectedGraph(v);
		for (int i = 0; i < e; i++) {
			System.out.println("Enter source , destination and Weight");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			int weight = sc.nextInt();
			grf.addEdge(source, destination, weight);
		}

		shortest_distance(grf);
	}

	public static void shortest_distance(WeightedDirectedGraph grf) {
		// this matrix is actually adjecency matrix
		
		int[][] solMat = new int[grf.adj.length][grf.adj.length];

		for (int i = 0; i < solMat.length; i++) {
			for (int j = 0; j < solMat[i].length; j++) {
				if (i != j) { // we dont put infinity on diagonal cause its always 0
					solMat[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < grf.adj.length; i++) {
			for (int j = 0; j < grf.adj[i].size(); j++) {
				solMat[i][grf.adj[i].get(j).vertice] = grf.adj[i].get(j).weight;
			}
		}

		for (int v = 0; v < solMat.length; v++) {//v times loop 
			for (int i = 0; i < solMat.length; i++) {
				for (int j = 0; j < solMat[i].length; j++) {
				
					if (i == v || j == v || i == j) {// we dont calculate for same row , same col or diagonal
						continue;
					} else if (solMat[i][v] == Integer.MAX_VALUE || solMat[v][j] == Integer.MAX_VALUE) {
						// because adding in infinity will bascially make the value -ve , this is i
						// guess property of Integer.Max
						// and if any of these value solMat[i][v],solMat[v][j] is infinity then their
						// sum
						// will always be greater than solMat[i][j] so no need to process it cause
						// formula Math.min(solMat[i][j], solMat[i][v] + solMat[v][j]) will put value of
						// solMat[i][j] in solMat[i][j] which is useless to do
						continue;
					}
					solMat[i][j] = Math.min(solMat[i][j], solMat[i][v] + solMat[v][j]);

				}
			}
		}

		System.out.println("solution matrix");
		for (int i = 0; i < solMat.length; i++) {
			for (int j = 0; j < solMat[i].length; j++) {
				System.out.print(solMat[i][j] + " ");
			}
			System.out.println();
		}

	}

}
