package Arrays_And_Strings;

import java.util.ArrayList;

public class Best_Meeting_Point_296 {
//It's actually now made available for premium users only in leetcode so instead see Lintcode "912 Best Meeting Point"
	public static void main(String[] args) {
		Best_Meeting_Point_296 ob = new Best_Meeting_Point_296();
		System.out
				.println(ob.minTotalDistance(new int[][] { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } }));
	}

	public int minTotalDistance(int[][] grid) {
		ArrayList<Pair> points = new ArrayList<>();// to collect points so that we don't have travel the matrix again
		ArrayList<Integer> xCoordinates = new ArrayList<>();
		ArrayList<Integer> yCoordinates = new ArrayList<>();
		// Just see video , It's quite easy but beautiful
// The idea is that if we find median of all point's x axis and median of all point's y axis the point obtained will be closests to all points

		for (int i = 0; i < grid.length; i++) {// moving in normal way ie first all columns of row 1 then all columns of
												// row 2 etc
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					xCoordinates.add(i);
					points.add(new Pair(i, j));// only add points once
				}
			}
		}
		for (int j = 0; j < grid[0].length; j++) {// moving different than normal ie. first all rows of column 1 are
													// travelled then all rows of column 2 and so on
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 1) {
					yCoordinates.add(j);
				}
			}
		}

		int medianX = xCoordinates.get(xCoordinates.size() / 2); // median is simply the middle element in the sorted
																	// list , in case of even number of element there
																	// will be 2 medians you can choose any one since
																	// both are correct
		int medianY = yCoordinates.get(yCoordinates.size() / 2);

		int sol = 0;

		for (Pair pair : points) {
			int currPointsDis = Math.abs(medianX - pair.x) + Math.abs(medianY - pair.y); // simply finding the manhattan
																							// distance
			sol += currPointsDis;// adding the distance to total distance
		}

		return sol;
	}

	class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
