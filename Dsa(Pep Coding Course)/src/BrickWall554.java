import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrickWall554 {

	public static void main(String[] args) {
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		row.add(2);
		row.add(2);
		row.add(1);
		wall.add(row);

		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(3);
		row2.add(1);
		row2.add(2);
		wall.add(row2);

		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(1);
		row3.add(3);
		row3.add(2);
		wall.add(row3);

		List<Integer> row4 = new ArrayList<Integer>();
		row4.add(2);
		row4.add(4);
		wall.add(row4);

		List<Integer> row5 = new ArrayList<Integer>();
		row5.add(3);
		row5.add(1);
		row5.add(2);
		wall.add(row5);

		List<Integer> row6 = new ArrayList<Integer>();
		row6.add(1);
		row6.add(3);
		row6.add(1);
		row6.add(1);
		wall.add(row6);

		System.out.println(leastBricks(wall));

	}

	public static int leastBricks(List<List<Integer>> wall) {
		int ans = 0;
		int width = 0;

		for (int ele : wall.get(0)) { // finding width of the wall so that we never include it width
			width += ele;
		}

		HashMap<Integer, Integer> hm = new HashMap<>();

		int maxNoOfCrossLine = 0;// we basically find how many max number of lines we can cross by drawing an
									// imaginary line , cause
									// then the answer would simply be array length- this max , cause array length
									// shows how many rows are there and max shoes how many rows we can skip by
									// traveling on edge of brick components

		for (List<Integer> row : wall) {
			
			int rowWidthTillNow = 0;// we intialize it to 0 again for new row
			
			for (int currEleWidth : row) {
				rowWidthTillNow += currEleWidth;// rowWidthTillNow tells till now what is
												// width of row 

				if (rowWidthTillNow == width) {// we skip the width cause we cant move on vertical edges of wall
					continue;
				}
				if (hm.containsKey(rowWidthTillNow)) {
					int prev = hm.get(rowWidthTillNow);
					hm.put(rowWidthTillNow, prev + 1);
					maxNoOfCrossLine = Math.max(prev + 1, maxNoOfCrossLine);
				} else {
					hm.put(rowWidthTillNow, 1);
					maxNoOfCrossLine = Math.max(1, maxNoOfCrossLine);
				}
			}
		}
		ans = wall.size() - maxNoOfCrossLine;
		return ans;
	}
}
