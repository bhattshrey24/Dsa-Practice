package miscellaneous;

public class QueenPermutations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 2;// 2 means 2X2 board , i.e. row=2 and col=2

		queensPerm2(0, n, 0, 0, "", new boolean[n]);// here we passed 1d array that to of length n and not n*n cause
													// this array shows how many choices/queens we have suppose n=2
													// then number of queens we can place is 2 and board is 2X2 i.e.
													// totals gaps are 4
	}
	// first go see queen pemutation 1

	// here we are using "permutation 2" wala logic i.e. permutation from
	// combination
	// wala concept
	public static void queensPerm2(int qpsf, int tq, int row, int col, String asf, boolean[] queensBoard) {// here we
																											// are given
																											// a 1d
																											// array

		if (row == tq) {// we reached end of boxes/gaps means no gap left to place queen now in current
						// branch of recursive tree
			if (qpsf == tq) {// check if the end result of current branch has same amount of items that we
								// need to
								// place
				System.out.println(asf);
			}
			return;
		}

		int nr = 0;// new row
		int nc = 0;// new col

		char sep = '\0';// seperator, i.e. this will store \n or \t based on row change hori hai ya nhi

		if (col == tq - 1) {// we are in the end col of board so it means now we go to next row and start
							// from 1st
							// col, "tq" act as "board[c].length" too cause its a square board with side
							// length
							// equal to total number of queens we are trying to place

			nr = row + 1;
			nc = 0;

			sep = '\n';// here row is changing

		} else {// mean we haven't reached end col yet so simply increase col
			nr = row;
			nc = col + 1;
			sep = ' ';// row is not changing
		}

		for (int i = 0; i < queensBoard.length; i++) {
			if (queensBoard[i] == false) {
				
				queensBoard[i] = true;
				
				queensPerm2(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queensBoard);// have faith that it will
																							// print all permutations of
																							// current branch
				queensBoard[i] = false;
			}
		}

		queensPerm2(qpsf + 0, tq, nr, nc, asf + '_' + sep, queensBoard);// when we don't put anything in current box/gap

	}
}
