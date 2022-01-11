package miscellaneous;

public class NQueenCombinations {

	public static void main(String[] args) {
		int n = 4;
		nQueenComb(0, n, new boolean[n][n], -1);
	}

//given NXN board and N similar queens print all the ways you can arrange N Queens without any queens killing any other
// Here we just have to manage that killing part , rest i.e. for combination you can use any method u want , we are using the one we used in QueenCombination3

	public static void nQueenComb(int qpsf, int tq, boolean[][] chess, int lcno) {
		
		if (qpsf == tq) {// base case
			for (int i = 0; i < chess.length; i++) {// simply print the board
				for (int j = 0; j < chess.length; j++) {
					if (chess[i][j]) {
						System.out.print("q ");
					} else {
						System.out.print("_ ");
					}
				}
				System.out.println();
			}
			System.out.println();

			return;
		}

		for (int cell = lcno + 1; cell < chess.length * chess.length; cell++) {
			int row = cell / chess.length;
			int col = cell % chess.length;

			if (isSafe(chess, row, col)) {// just this if call is new rest is same as QueenComb3 , its simple i.e. if
											// its safe to place queen in current cell
											// then place it else don't

				chess[row][col] = true;
				
				nQueenComb(qpsf + 1, tq, chess, cell);
				
				chess[row][col] = false;

			}
		}
	}

	public static boolean isSafe(boolean[][] chess, int currRow, int currCol) {

		for (int i = currRow; i >= 0; i--) {// checking Up in same col
			if (chess[i][currCol]) {
				return false;
			}
		}
		for (int j = currCol; j >= 0; j--) {// checking left in same row
			if (chess[currRow][j]) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i >= 0 && j >= 0; i--, j--) {// checking upper diag 1
			if (chess[i][j]) {
				return false;
			}
		}
		for (int i = currRow, j = currCol; i >= 0 && j < chess.length; i--, j++) {// checking upper diag 2
			if (chess[i][j]) {
				return false;
			}
		}
		return true;// if reached till here means its safe
	}
}
