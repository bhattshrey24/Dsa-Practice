
public class IslandPerimeter463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int islandPerimeter(int[][] grid) {
		int per = 0;// keeps track of perimeter

		for (int i = 0; i < grid.length; i++) {
			// we basically first assume for every cell that it has 4 open sides then we
			// check on all 4 sides one by one and if we find island we reduce cell's
			// perimeter by 1 and , we do
			// this for all 4 sides of cell and then we add resultant perimeter of this
			// cell to answer and we do the same process for all cells
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int indiPe = 4;// assuming current cell has all 4 sides as perimeter
					if (i - 1 != -1 && grid[i - 1][j] == 1) {
						indiPe--;
					}
					if (i + 1 != grid.length && grid[i + 1][j] == 1) {
						indiPe--;
					}
					if (j + 1 != grid[i].length && grid[i][j + 1] == 1) {
						indiPe--;
					}
					if (j - 1 != -1 && grid[i][j - 1] == 1) {
						indiPe--;
					}
					per += indiPe;// adding the resultant preimeter of the current cell to answer , like if current cell
									// is surrounded by island on all 4 sides then this indiPe will be 0
				}

			}
		}

		return per;
	}

}
