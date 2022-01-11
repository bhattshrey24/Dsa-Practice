package miscellaneous;

public class NQueenPermutation {

	public static void main(String[] args) {

		int n = 4;
		nQueenPerm1(0, n, new int[n][n]);
		// nQueenPerm2(0, n, new int[n][n]);

	}

	// given NXN board and N distinct queens , print all the ways you can arrange N
	// Queens without any queens killing any other

	// Here we just have to manage that killing part , rest i.e. for combination you
	// can use any method u want , we are using the one we used in QueenCombination3

// 2 methods discussed below

	// Sumit Sir's method :-

	// the only difference between permutation and combination is that in
	// combination we
	// have only remaining cells as options to put items but in permutation we can
	// put
	// items in any cell

	// this method uses cell number concept
	public static void nQueenPerm1(int qpsf, int tq, int[][] chess) {

		if (qpsf == tq) {// base case
			for (int i = 0; i < chess.length; i++) {// simply print the board
				for (int j = 0; j < chess.length; j++) {
					if (chess[i][j] != 0) {
						System.out.print("q" + chess[i][j] + " ");
					} else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int cell = 0; cell < chess.length * chess.length; cell++) {// see here since its permutation therefore we
																		// started from 0 unlike in combination where we
																		// started from last cell number (lcno)
			int row = cell / chess.length;
			int col = cell % chess.length;

			if (chess[row][col] == 0 && isSafe(chess, row, col)) {

				chess[row][col] = qpsf + 1;
				nQueenPerm1(qpsf + 1, tq, chess);
				chess[row][col] = 0;

			}
		}
	}

	
	// My solution using "Permutation with backtracking" concept , jut handling the
	// killing part
	public static void nQueenPerm2(int qpsf, int tq, int[][] chess) {

		if (qpsf == tq) {
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess[i].length; j++) {
					if (chess[i][j] == 0) {
						System.out.print("_ ");
					} else {
						System.out.print("q" + chess[i][j] + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[i].length; j++) {

				if (chess[i][j] == 0 && isSafe(chess, i, j)) {
					chess[i][j] = (qpsf + 1);
					nQueenPerm2(qpsf + 1, tq, chess);
					chess[i][j] = 0;
				}
			}
		}
	}

	public static boolean isSafe(int[][] chess, int currRow, int currCol) {
		// here we have to check all 8 Directions cause we can place queen in any box
		// unlike in combination where we could only put in remaining box

		for (int i = currRow; i >= 0; i--) {// checking Up in same col
			if (chess[i][currCol] != 0) {
				return false;
			}
		}
		for (int i = currRow; i < chess.length; i++) {// checking Down in same col
			if (chess[i][currCol] != 0) {
				return false;
			}
		}
		for (int j = currCol; j >= 0; j--) {// checking left in same row
			if (chess[currRow][j] != 0) {
				return false;
			}
		}
		for (int j = currCol; j < chess.length; j++) {// checking right in same row
			if (chess[currRow][j] != 0) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i >= 0 && j >= 0; i--, j--) {// checking upper diag 1
			if (chess[i][j] != 0) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i < chess.length && j < chess.length; i++, j++) {// checking lower diag 1
			if (chess[i][j] != 0) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i >= 0 && j < chess.length; i--, j++) {// checking upper diag 2
			if (chess[i][j] != 0) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i < chess.length && j >= 0; i++, j--) {// checking lower diag 2
			if (chess[i][j] != 0) {
				return false;
			}
		}

		return true;// if reached till here means its safe
	}

}
