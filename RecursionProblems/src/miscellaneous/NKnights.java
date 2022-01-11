package miscellaneous;

public class NKnights {

	public static void main(String[] args) {
		int n = 4;
		nKnights(0, n, new boolean[n][n], -1);
	}

	// place N knights in NXN board such that no knight kill other knight , each
	// knight is considered as similar i.e. combination

	public static void nKnights(int kpsf, int tk, boolean[][] chess, int lcno) {// kpsf = knights placed so far , tk=
																				// total knights , lcno= 'last cell
																				// number' where we placed knight

		if (kpsf == tk) {// base case i.e. placed all N knights

			for (int i = 0; i < chess.length; i++) {// simply print the answer board
				for (int j = 0; j < chess.length; j++) {

					System.out.print(chess[i][j] ? "k  " : "_  ");// used ternary operator instead of 2 'if'
																	// conditions
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = lcno + 1; i < chess.length * chess.length; i++) {// since knights are considered similar that means
																		// combination therefore loop starts from 'lcno'
																		// and not 0 cause next knight can only be
																		// placed in remaining cells

			int row = i / chess.length;
			int col = i % chess.length;
			if (chess[row][col] == false && isKnightSafe(chess, row, col)) {

				chess[row][col] = true;

				nKnights(kpsf + 1, tk, chess, i);// now current cell becomes the 'lcno' , have faith that recursion will
													// place remaining knights correctly

				chess[row][col] = false;
			}
		}
	}

	public static boolean isKnightSafe(boolean[][] chess, int row, int col) {
		// we just check upr wale cells

		if (isValid(chess, row - 1, col - 2) && chess[row - 1][col - 2]) {
			return false;
		}
		if (isValid(chess, row - 2, col - 1) && chess[row - 2][col - 1]) {
			return false;

		}
		if (isValid(chess, row - 2, col + 1) && chess[row - 2][col + 1]) {
			return false;

		}
		if (isValid(chess, row - 1, col + 2) && chess[row - 1][col + 2]) {
			return false;
		}

		return true;
	}

	static boolean isValid(boolean[][] chess, int row, int col) {
		return !(row < 0 || col < 0 || row >= chess.length || col >= chess[row].length);
	}

}
