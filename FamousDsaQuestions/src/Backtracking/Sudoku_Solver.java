package Backtracking;

public class Sudoku_Solver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = new int[][] { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		sudokuSolver(grid);// this function solves the grid
		System.out.println("Solution is:");
		for (int i = 0; i < grid.length; i++) {
			System.out.println();
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}

	}

	public static boolean sudokuSolver(int board[][]) {// GFG has even better TC solution than this , see when you have
														// time

		int row = -1;// this stores current empty cells row
		int col = -1;// this stores current empty cells col

		boolean isEmptyCellsFilled = true;// assuming we filled all empty cells , isEmptyCellsFilled means is all empty
											// cells filled?

		for (int i = 0; i < board.length; i++) {// finding empty cell
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 0) {// board[i][j] == 0 means empty cell , if this is true it means we still have
										// empty cells left
					row = i;
					col = j;
					// We still have some remaining
					// missing values in Sudoku
					isEmptyCellsFilled = false;// therefore it means all cells are not filled yet and there are still
												// empty
												// cells left
					break;
				}
			}
			if (!isEmptyCellsFilled) {// if this is true means we found empty cell ,so break out of the for loop
				break;
			}
		}

		// No empty space left , means we placed all numbers means we solved the sudoku
		if (isEmptyCellsFilled) {
			return true;
		}

		for (int i = 1; i < 10; i++) {
			if (isSafe(board, row, col, i)) {// wahi nqueens wala logic
				board[row][col] = i;
				if (sudokuSolver(board)) {
					return true;
				}
				board[row][col] = 0;

			}
		}
		return false;
	}

	public static boolean isSafe(int board[][], int row, int col, int num) {// num is the number that we placed on cell
		// Row has the unique (row-clash)
		for (int d = 0; d < board.length; d++) {

			// Check if the number we are trying to
			// place is already present in
			// that row, return false;
			if (board[row][d] == num) {
				return false;
			}
		}

		// Column has the unique numbers (column-clash)
		for (int r = 0; r < board.length; r++) {

			// Check if the number
			// we are trying to
			// place is already present in
			// that column, return false;
			if (board[r][col] == num) {
				return false;
			}
		}

		// Corresponding square has
		// unique number (box-clash)
		int sqrt = (int) Math.sqrt(board.length);// since number of small squares in large square is sqaure root of
													// large
													// boards length
		int boxRowStart = row - row % sqrt;
		int boxColStart = col - col % sqrt;

		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (board[r][d] == num) {
					return false;
				}
			}
		}

		// if there is no clash, it's safe
		return true;
	}
}
