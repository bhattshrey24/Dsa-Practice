package miscellaneous;

public class QueenCombinations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		queensComb2(0, n, new boolean[n][n], 0, -1);// starting "j" i.e. col with -1 cause starting mei no queen is
													// placed so if I passed 0,0 then its a valid 2d index but 0,-1 is
													// not
	}

	// here we use "combination using permutation" wala concept

	public static void queensComb2(int qpsf, int tq, boolean[][] chess, int row, int col) {// i and j used to travel in
																							// array

		if (qpsf == tq) {// base case

			for (int i = 0; i < chess.length; i++) {// simply print the solution
				for (int j = 0; j < chess.length; j++) {
					if (chess[i][j]) {// true means we placed a queen at that cell
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

		// here we are managing 2d using 2 loops , yes we can merge these 2 loops in one
		// and we did that in QueenCombination 3 , but learn this approach too.

		// to understand why we used 2 loops just try yourself merging these 2 loops in one ,
		// remember the concept that if current queen is placed in (i,j) cell then next
		// queen can only be placed in remaining cells after i,j
		
		for (int j = col + 1; j < chess.length; j++) {// placing queens in remaining boxes of current row
			chess[row][j] = true;// see row remains same
			queensComb2(qpsf + 1, tq, chess, row, j);
			chess[row][j] = false;
		}
		for (int i = row + 1; i < chess.length; i++) {// placing queens in next row and all remaining rows beneath it
			for (int j = 0; j < chess.length; j++) {
				chess[i][j] = true;// see both row and col changes
				queensComb2(qpsf + 1, tq, chess, i, j);
				chess[i][j] = false;
			}
		}
	}
}
