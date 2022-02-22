package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CheapestFlightWithKStops787 {

	public static void main(String[] args) {
		int[][] flight = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
		System.out.println(findCheapestPrice(4, flight, 0, 3, 1));
		// int[][] flight = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1,
		// 4, 1 }, { 4, 2, 1 } };
		// System.out.println(findCheapestPrice(5, flight, 0, 2, 2));
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		// here we don't actually need to create a graph because for running bellman
		// ford we just need edges(ie. u and v) with it's weights and that is provided
		// by 'Flights'
		// array in the argument of this function

		int ans[] = new int[n];// ans array is the curr array

		for (int i = 0; i < ans.length; i++) {
			if (i == src) {
				ans[i] = 0;
			} else {
				ans[i] = Integer.MAX_VALUE;
			}
		}

		int[] prev = new int[n];

		for (int z = 0; z <= k; z++) { // simply processing each vertex v-1 times , in this case it's K times because
										// at Kth iteration all the paths with length K will be solved

			prev = ans.clone();// simly copied the 'ans' array to 'prev' array

			for (int i = 0; i < flights.length; i++) {
				int u = flights[i][0];
				if (prev[u] == Integer.MAX_VALUE) {
					continue;
				}
				int v = flights[i][1];
				int weight = flights[i][2];

				if (prev[u] + weight < ans[v]) {
					ans[v] = prev[u] + weight;
				}

			}
		}

		if (ans[dst] == Integer.MAX_VALUE) {// infinity at destination means its not possible to reach at destination
											// with k steps
			return -1;
		}
		return ans[dst];
	}

}