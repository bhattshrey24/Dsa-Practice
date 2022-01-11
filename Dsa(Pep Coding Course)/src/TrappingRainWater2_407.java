import java.util.PriorityQueue;

import java.util.Comparator;
import java.util.Collections;

public class TrappingRainWater2_407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(isValid(3 , 2 , 3 , 3));
		int[][] heights = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };

		System.out.println(trapRainWater(heights));

	}

	public static int trapRainWater(int[][] heightMap) {
		int trappedWater = 0;
		boolean visited[][] = new boolean[heightMap.length][heightMap[0].length];
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

		for (int i = 0; i < heightMap.length; i++) {// add boundary members
			for (int j = 0; j < heightMap[i].length; j++) {
				if (i == 0 || j == 0 || i == heightMap.length - 1 || j == heightMap[0].length - 1) {
					pq.add(new Pair(heightMap[i][j], i, j));// adding boundary cells
					visited[i][j] = true;// and marking them visited
				}
			}
		}

		while (!pq.isEmpty()) {
			Pair removed = pq.remove();

			if (isValid(removed.r + 1, removed.c, heightMap.length, heightMap[0].length)) {

				if (!visited[removed.r + 1][removed.c]) {// we only work if neighbor is unvisited
					Pair nbr = new Pair(heightMap[removed.r + 1][removed.c], removed.r + 1, removed.c);
					if (nbr.val >= removed.val) {
						pq.add(nbr);// delagte work directly since its better than you and can act as a wall cause
									// if water is coming from this neighbor then if he cant stop the amount then
									// you toh definately cant therefore just pass the boundary to it

						visited[nbr.r][nbr.c] = true;// mark neighbor as visited since we added it in pq
					} else {

						trappedWater += removed.val - nbr.val;// its safe to add answer directly without thinking of
																// other 3 walls cause we started with making a safe
																// boundary and then moved on those buildings which are
																// smaller and hence can leak water out , others are
																// safe since if we picked current pair means it has
																// smallest height in pq currently others are better
																// than it
						Pair neighbor = new Pair(removed.val, removed.r + 1, removed.c);// cause now it acts as virtual
																						// wall with same height as
																						// current removed building ,
																						// and now we deligating the
																						// work to it since now its
																						// virtual height is same as
																						// current removed pair
						pq.add(neighbor);
						visited[neighbor.r][neighbor.c] = true;

					}

				}
			}
			if (isValid(removed.r - 1, removed.c, heightMap.length, heightMap[0].length)) {
				if (!visited[removed.r - 1][removed.c]) {
					Pair nbr = new Pair(heightMap[removed.r - 1][removed.c], removed.r - 1, removed.c);
					if (nbr.val >= removed.val) {
						pq.add(nbr);// delagte work diirectly since its better than you

						visited[nbr.r][nbr.c] = true;

					} else {
						trappedWater += removed.val - nbr.val;
						Pair neighbor = new Pair(removed.val, removed.r - 1, removed.c);// cause now it acts as virtual
																						// wall with same height as
																						// current removd building
						pq.add(neighbor);
						visited[neighbor.r][neighbor.c] = true;

					}

				}
			}
			if (isValid(removed.r, removed.c + 1, heightMap.length, heightMap[0].length)) {
				if (!visited[removed.r][removed.c + 1]) {
					Pair nbr = new Pair(heightMap[removed.r][removed.c + 1], removed.r, removed.c + 1);
					if (nbr.val >= removed.val) {
						pq.add(nbr);// delagte work diirectly since its better than you
						visited[nbr.r][nbr.c] = true;
					} else {
						trappedWater += removed.val - nbr.val;
						Pair neighbor = new Pair(removed.val, removed.r, removed.c + 1);// cause now it acts as virtual
																						// wall with same height as
																						// current removd building
						pq.add(neighbor);
						visited[neighbor.r][neighbor.c] = true;
					}

				}
			}
			if (isValid(removed.r, removed.c - 1, heightMap.length, heightMap[0].length)) {
				if (!visited[removed.r][removed.c - 1]) {
					Pair nbr = new Pair(heightMap[removed.r][removed.c - 1], removed.r, removed.c - 1);
					if (nbr.val >= removed.val) {
						pq.add(nbr);// delagte work diirectly since its better than you
						visited[nbr.r][nbr.c] = true;

					} else {

						trappedWater += removed.val - nbr.val;
						Pair neighbor = new Pair(removed.val, removed.r, removed.c - 1);// cause now it acts as virtual
																						// wall with same height as
																						// current removd building
						pq.add(neighbor);
						visited[neighbor.r][neighbor.c] = true;

					}

				}
			}

		}
//System.out.println(trappedWater);
		return trappedWater;
	}

	public static boolean isValid(int i, int j, int r, int c) {
		return !(i < 0 || j < 0 || i >= r || j >= c);
	}

	public static class Pair implements Comparable<Pair> {
		int val;
		int r;
		int c;

		Pair(int val, int r, int c) {
			this.val = val;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
	}

}
