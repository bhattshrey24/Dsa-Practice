package miscellaneous;

public class NQueensUsingBranchAndBound {

	public static void main(String[] args) {
		int n = 4;
		nQueenUsingBnB(new boolean[n][n], 0, new boolean[n], new boolean[(2 * n) - 1], new boolean[(2 * n) - 1], "");
	}

	// basic N Queen problem solved using branch and Bound Algo

	// here also all queens are treated as same and not different

	// the difference here is that we check if current cell is in path of any queen
	// placed before in O(1) , also we use branch and bound algo
	public static void nQueenUsingBnB(boolean board[][], int row, boolean cols[], boolean[] ndiag, boolean[] rdiag,
			String asf) {

		if (row == board.length) {// means we placed all queens so simply print answer

			System.out.println(asf + ".");
			return;
		}

		for (int col = 0; col < board[0].length; col++) {

			if (cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] == false) {// checking
																													// if
																													// theres
																													// any
																													// queen
																													// blocking
																													// current
																													// cell
																													// ,
																													// if
																													// not
																													// then
																													// put
																													// new
																													// queen
																													// in
																													// it
																													// ,
																													// if
																													// yes
																													// then
																													// move
																													// on
																													// to
																													// next
																													// cell

				board[row][col] = true;// putting queen in current cell

				// blocking all columns and diagonals where this current queen can kill
				cols[col] = true;
				ndiag[row + col] = true;
				rdiag[row - col + board.length - 1] = true;

				nQueenUsingBnB(board, row + 1, cols, ndiag, rdiag, asf + "[" + row + "," + col + "],");// row+1 cause
																										// after
				// placing 1
				// queen no other can be
				// placed in that row , here in answer i.e. asf we are putting the cell's row
				// and
				// column
				// where we can put the queen safely

				// Backtracking , since we are removing
				// queen so all the columns, rows, diagonals it blocked will also be freed there
				// undo all that too while backtracking

				board[row][col] = true;// removing queen

				// unblocking all columns, diagonals that it blockeds
				cols[col] = false;
				ndiag[row + col] = false;
				rdiag[row - col + board.length - 1] = false;

			}
		}
	}
}
