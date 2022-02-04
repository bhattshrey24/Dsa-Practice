package Graph;

import java.util.ArrayDeque;

public class RottingOranges994 {

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(orangesRotting(grid));
	}

	public static int orangesRotting(int[][] grid) {
		// step 1 , add all cell with value 2 in queue
		ArrayDeque<Pair> que = new ArrayDeque<Pair>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					que.add(new Pair(i, j, 0));
				}
			}
		}
// Step 2 multi source BFS
		Pair currEle = new Pair();
		
		while (!que.isEmpty()) {
			currEle = que.remove();
			if (currEle.i - 1 >= 0) {
				if (grid[currEle.i - 1][currEle.j] == 1) {// this is same as checking that neighbor is visited or not
					grid[currEle.i - 1][currEle.j] = 2;// here we are marking visited before hand cause we are not using
														// extra space
					que.add(new Pair(currEle.i - 1, currEle.j, currEle.cost + 1));
				}
			}
			if (currEle.i + 1 <= grid.length - 1) {
				if (grid[currEle.i + 1][currEle.j] == 1) {
					grid[currEle.i + 1][currEle.j] = 2;
					que.add(new Pair(currEle.i + 1, currEle.j, currEle.cost + 1));

				}
			}
			if (currEle.j - 1 >= 0) {
				if (grid[currEle.i][currEle.j - 1] == 1) {
					grid[currEle.i][currEle.j - 1] = 2;
					que.add(new Pair(currEle.i, currEle.j - 1, currEle.cost + 1));

				}
			}
			if (currEle.j + 1 <= grid[currEle.i].length - 1) {
				if (grid[currEle.i][currEle.j + 1] == 1) {
					grid[currEle.i][currEle.j + 1] = 2;
					que.add(new Pair(currEle.i, currEle.j + 1, currEle.cost + 1));

				}
			}

		}

		for (int i = 0; i < grid.length; i++) { // you can improve complexity by checking here whether there is a 1 //
												// surrounded by 0s or not
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return currEle.cost;

	}

	public static class Pair {
		int i, j, cost;

		public Pair() {

		}

		public Pair(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
	}

}
