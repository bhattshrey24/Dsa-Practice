//leetcode ques 1034
public class ColoringBorders1034 {
//fastest solution
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		boolean[][] visited = new boolean[grid.length][grid[0].length]; // assuming column number is same for each row
	
		dfs(grid, grid[r0][c0], color, r0, c0, visited);

		return grid;
	}

	public static void dfs(int grid[][], int originalColor, int newColor, int i, int j, boolean[][] visited) {
		int count = 0;
		grid[i][j] = newColor;// assuming its border
		visited[i][j] = true;

		if (isValid(i + 1, j, grid)) { // here isValid acts like base case since we already checking before going to that cell
			if (visited[i + 1][j]) { // if visited means we changed it already this means that the current cell is adjecent to that cell that means ek side se ghira hai therefore count+1
				count++; // simply increase count and dont go in that direction
			}else if(grid[i + 1][j] == originalColor){
				count++; // means we are going in that direction and since we are going it means that it is the color that we are looking for hence ek side se ghira hai current cell therefore count ++
				dfs(grid, originalColor, newColor, i + 1, j, visited);
			}
		
		}
		if (isValid(i - 1, j, grid)) {
				if (visited[i - 1][j]) {
					count++; // simply increase count and dont go in that direction
				} else if(grid[i - 1][j] == originalColor) {
					count++;
					dfs(grid, originalColor, newColor, i - 1, j, visited);
				}
			
		}
		if (isValid(i, j + 1, grid)) {
				if (visited[i][j + 1]) {
					count++; // simply increase count and dont go in that direction
				} else if(grid[i][j + 1] == originalColor) {
					count++;
					dfs(grid, originalColor, newColor, i, j + 1, visited);
				}
			
		}
		if (isValid(i, j - 1, grid)) {
				if (visited[i][j - 1]) {
					count++; // simply increase count and dont go in that direction
				} else if(grid[i][j - 1] == originalColor){
					count++;
					dfs(grid, originalColor, newColor, i, j - 1, visited);
				}
			
		}
		// backtracing
		if (count == 4) { // if count is 4 means current cell is not border therefore change it back to original color
			grid[i][j] = originalColor;
		}

	}

	public static boolean isValid(int i, int j, int[][] grid) {

		return !(i >= grid.length || i < 0 || j >= grid[i].length || j < 0);

	}

}
