package miscellaneous;

public class QueensCombination {

	public static void main(String[] args) {
		int n = 3;
		queenComb(0, n, 0, 0, "");
	}

// Its not even remotely related to N queens question , 
//its simply a combination question , 
//all queens are treated as same items i.e "i" , queens are items and not queens in chess board, 
//infact just forget about queens and question is simply "print all ways of putting r similar items in 2d matrix. now 2d matrix is also nothing but simple 1d array eg 
//3X3  can simply be seen as 1d array of size 3*3 i.e.  [0,1,2,3,4,5,6,7,8]

// also here in question its given that the board will be square board with side = total number of queen 
//, like if number of queens are 3 then board will be 3X3

	// here we used "combination using subsequence" wala concept

	public static void queenComb(int qpsf, int tq, int row, int col, String asf) {// qpsf = queen placed so far , tq=
																					// total queen i.e. r, asf= answer
																					// so far , we are traversing using
																					// "row" and "col"

		if (row == tq) {// "tq" act as "board.length" too cause its a square board with side length
						// equal to total number of queens we are trying to place
			if (qpsf == tq) {
				System.out.println(asf);
			}
			return;
		}

		int nr = 0;// new row
		int nc = 0;// new col

		String yasf = "";// yasf= Yes answer so far i.e. answer when we put queen in current cell , we
							// are doing it separately outside recursive call because of \n i.e. answer
							// depends whether we are on same row or row changed

		String nasf = "";// nasf= No answer so far
		if (col == tq - 1) {// we are in the end col of board so it means now we go to next row and start
							// from 1st
							// col, "tq" act as "board[c].length" too cause its a square board with side
							// length
							// equal to total number of queens we are trying to place

			nr = row + 1;
			nc = 0;

			yasf = asf + "q\n";// see "\n" works like system.out.println()
			nasf = asf + "-\n";

		} else {// mean we haven't reached end col yet so simply increase col
			nr = row;
			nc = col + 1;
			yasf = asf + "q";
			nasf = asf + "-";
		}

		queenComb(qpsf + 1, tq, nr, nc, yasf);// queens placed in current cell
		queenComb(qpsf + 0, tq, nr, nc, nasf);// queen not placed in current cell

	}
}
