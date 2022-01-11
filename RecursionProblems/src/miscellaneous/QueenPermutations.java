package miscellaneous;

public class QueenPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stubquee

		int n = 3;
		queenPerm(0, n, new int[n][n]);
	}

	// first go see queen combination , I explained question there
	// Here queens are treated as different hence we have to do permutation
	// here we are given the chess board , but again chess board is sqaure with side
	// length = number of queens we are trying to place

	// here since we are passing the actual 2d board therefore no need to manage 2d
	// board like we did in QueensCombination wala question , so its simply
	// print permutation question

	// here we used "permutation with backtracking" wala concept
	public static void queenPerm(int qpsf, int tq, int[][] chess) {// here board in "int" because since queens are
																	// different so we are treating them as number i.e.
																	// 1 means q1 , 2 means q2 and so on , also 0 means
																	// no queen that means the cell is empty

		if (qpsf == tq) {// base case , that is we placed jitni queens place krni thi in current branch
							// of recursive tree so
							// simply print the current chess board

			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess[i].length; j++) {
					if (chess[i][j] == 0) {
						System.out.print("- ");// sir used "\t" and it means tab i.e. 4 spaces but I used simply space
												// cause it looks good
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

				if (chess[i][j] == 0) {// means current cell is not visited i.e. its empty so we can place queen here
					
					chess[i][j] = (qpsf + 1);// so we simply place next queen in the current cell , now if suppose we
												// already
												// placed 2 queens so now we will place the third queen i.e. qpsf+1

					queenPerm(qpsf + 1, tq, chess);// i.e. have faith that recursion will place the remaining queens

					chess[i][j] = 0;// backtrack , i.e. remove the queen from the cell
				}
			}
		}

	}
}
