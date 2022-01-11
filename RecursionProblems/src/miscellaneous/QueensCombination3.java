package miscellaneous;

public class QueensCombination3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;

		queenComb3(0, n, new boolean[n][n], -1); // lcno means "last cell number" jispr queen baithai thi and initially
													// its -1 cause koi queen baithai hi nhi starting mei kisi bhi cell

	}

	public static void queenComb3(int qpsf, int tq, boolean[][] chess, int lcno) {//

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

		for (int cell = lcno + 1; cell < chess.length * chess.length; cell++) {// chess.length * chess.length cause
																				// 'chess' is 2d
			// eg if its 4X4 then 'chess.length' is number
			// of
			// Rows i.e. 4 but total number of cells are 4*4
			// i.e. 16

			int row = cell / chess.length;
			int col = cell % chess.length;

			// if (chess[row][col] == false) {// no need to put this check since at each
			// call we are
			// placing the queen in remaining cells

			chess[row][col] = true;

			queenComb3(qpsf + 1, tq, chess, cell);// now 'lcno' becomes current 'cell'

			chess[row][col] = false;

			// }

		}

	}
}
