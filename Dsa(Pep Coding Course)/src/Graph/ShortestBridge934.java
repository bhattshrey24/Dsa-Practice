package Graph;
import java.util.ArrayDeque;

public class ShortestBridge934 {

	public static void main(String[] args) {
		int[][] gri = { { 0, 0, 1, 1 }, { 0, 1, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 1, 1, 1 } };
//		int[][] gri = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
//		};
		// int[][] gri = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1,
		// 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };

		// int[][] gri = { { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0
		// }, { 0,0,0,1 } };

		// ArrayDeque<Pair> q = new ArrayDeque<>();
//		dfs(0, 0, gri, q);
//	    for(int i=0;i<gri.length;i++  ) {
//	    	for(int j=0;j<gri[i].length;j++  ) {
//		    	System.out.print(gri[i][j]+" ");
//		    }
//	    	System.out.println();
//	    }
//	    for(Pair p:q){
//			System.out.print(p.i+" "+p.j+" & ");
//		}
		// shortestBridge(gri);
		System.out.println(shortestBridge(gri));
	}

	public static int shortestBridge(int[][] grid) {
		// Step 1
		ArrayDeque<Pair> q = new ArrayDeque<>();
		int r = 0, c = 0;
		boolean oneFound = false;
		for (int i = 0; i < grid.length; i++) {
			if (oneFound) {
				break;
			}
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					// System.out.println("i,j" + i + " " + j);
					r = i;
					c = j;
					oneFound = true;
					break; // this break will only take us out of just inner loop but we have to move out
							// of both inner and
							// outer loop therefore we used "oneFound" boolean
				}
			}
		}
		dfs(r, c, grid, q);

		// Step 2 bfs from generated que

		int min = 0;
		while (!q.isEmpty()) {

			Pair currEle = q.remove();// REMOVE
			// we want to save space therefore we are marking visited in same grid
			if (grid[currEle.i][currEle.j] == 3) {// Check if visited
				continue;
			}

			if (grid[currEle.i][currEle.j] == 1) {// checking if current ele is the one we wanted
				min = currEle.dist - 1; // currEle.dist - 1 cause distance stores no of steps needed to reach neasrest 1
										// but we need
										// to find no of 0s that need to be flipped and that is "no of steps -1"
				break;
			}

			grid[currEle.i][currEle.j] = 3;// marking visited

			if (currEle.i - 1 >= 0) {
				if (grid[currEle.i - 1][currEle.j] != 2 && grid[currEle.i - 1][currEle.j] != 3) {

					q.add(new Pair(currEle.i - 1, currEle.j, currEle.dist + 1));
				}
			}
			if (currEle.i + 1 <= grid.length - 1) {
				if (grid[currEle.i + 1][currEle.j] != 2 && grid[currEle.i + 1][currEle.j] != 3) { // 3 means visited and
																									// 2 means its the
																									// part of 1st
																									// island so we
																									// already added
																									// them therefore no
																									// need to add them
																									// again
					q.add(new Pair(currEle.i + 1, currEle.j, currEle.dist + 1));

				}
			}
			if (currEle.j - 1 >= 0) {
				if (grid[currEle.i][currEle.j - 1] != 2 && grid[currEle.i][currEle.j - 1] != 3) {
					q.add(new Pair(currEle.i, currEle.j - 1, currEle.dist + 1));

				}
			}
			if (currEle.j + 1 <= grid[currEle.i].length - 1) {
				if (grid[currEle.i][currEle.j + 1] != 2 && grid[currEle.i][currEle.j + 1] != 3) {
					q.add(new Pair(currEle.i, currEle.j + 1, currEle.dist + 1));

				}
			}

		}

		return min;
	}

	public static void dfs(int i, int j, int grid[][], ArrayDeque<Pair> que) {
		if (i >= grid.length || i < 0 || j < 0 || j >= grid[i].length || grid[i][j] == 2 || grid[i][j] == 0) { // base
																												// case
			return;
		}
		grid[i][j] = 2; // marking visited

		dfs(i + 1, j, grid, que);
		dfs(i - 1, j, grid, que);
		dfs(i, j + 1, grid, que);
		dfs(i, j - 1, grid, que);

		que.add(new Pair(i, j, 0));// adding in queue while backtracking

	}

	public static class Pair {
		int i, j, dist;

		public Pair(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}

}
