package Backtracking;

import java.util.Queue;
import java.util.Scanner;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Rows of board ");
		int n = sc.nextInt();
		int arr[][] = new int[n][n];

		boolean isPossible = nQueen(arr, 0, n);
		if (isPossible) {
			System.out.println("yes its possible to arrange N queens");
		} else {
			System.out.println("No its not possible to arrange N queens");
		}

		System.out.println();
		System.out.println("All possible solutions are");
		int arr2[][] = new int[n][n];

		printAllSolutionofNQueen(arr2, 0);

	}

	// normal N queen code which tells whether is there a possible way of putting N
	// queens or not , This doesnt give exact places where we can put queens , woh
	// wala code is neeche

	public static boolean nQueen(int board[][], int currRow, int N) {// we don't need to reduce count of queens if we
																		// placed
		// one
		// cause we can only place one queen in one row (cause
		// queen kills the same row queens) and number of queens
		// are same as number of rows so if we reached last row
		// means we placed all queens
		if (currRow == N) {// N is length of board
			System.out.println("One of the correct solutions");

			for (int i = 0; i < board.length; i++) {// this just prints one of the correct solutions , cause after
													// finding
													// one we move return true , cause motive of this function is to
													// tell whether its possible to put n queens or not
				System.out.println();
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
			return true;
		}

		for (int col = 0; col < board[currRow].length; col++) {

			if (isSafe(board, currRow, col)) {
				board[currRow][col] = 1;// placing the queen

				if (nQueen(board, currRow + 1, N)) {// check for remaining row
					return true;
				}

				// the statement below is the backtracking statement , its mostly just 1 line
				// statement
				board[currRow][col] = 0;// if in above statement the recursion returned false then it means putting
										// queen
										// in current cell wont give us the answer i.e. we wont be able to put other
										// remaining queens so simply dont put a queen in current cell and let recursion
										// do its job and check for other remaining places

			} // observe theres no "else" , cause if it was not safe to put at current cell
				// then nothing to do , simply
				// try other solutions i.e. run remaining "for" loop and if all columns are
				// traversed
				// yet no safe place means we need to backtrack so simply return false i.e. last
				// wali return false statement takes care of it
		}

		return false;
	}

	public static boolean isSafe(int board[][], int r, int c) {// This is the conventional way but we can do it using
		// Grid
// Illumination(Q 1001 of LeetCode) wala way too i.e.
// using HashMap , i think it will be faster

		for (int i = r; i >= 0; i--)// means we found a queen so return false cause it means current cell is unsafe
			// , if we went all the way up and didnt find any queen it means current cell
			// may or may
			// not be safe , other "for" loops will make sure of it
			if (board[i][c] == 1)
				return false;

//		for (int i = r; i < board.length; i++)// checking down , no Need to check down cause we are going from top to
//												// bottom to queen hogi toh upper half mei hi hogi neeche nhi ho skti
//			if (board[i][c] == 1)
//				return false;

//		for (int i = c; i < board[r].length; i++)// checking right , no Need to check right cause we are going from top to
//		// bottom and right to left to queen hogi toh left side mei hi hogi right side nhi ho skti
//			if (board[r][i] == 1)
//				return false;

		for (int i = c; i >= 0; i--)// checking left
			if (board[r][i] == 1)
				return false;

		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)// checking upper part of diagonal1
			if (board[i][j] == 1)
				return false;

//		for (int i = r, j = c; i < board.length && j < board[r].length; i++, j++)// checking lower part of diagonal1 , no Need to check lower cause we are going from top to
//		// bottom to queen hogi toh upper half mei hi hogi neeche nhi ho skti
//			if (board[i][j] == 1)
//				return false;

		for (int i = r, j = c; i >= 0 && j < board[r].length; i--, j++)// checking upper part of diagonal2
			if (board[i][j] == 1)
				return false;

//		for (int i = r, j = c; i < board.length && j >= 0; i++, j--)// checking lower part of diagonal1 ,  no Need to check  cause we are going from top to
//		// bottom to queen hogi toh upper half mei hi hogi neeche nhi ho skti
//			if (board[i][j] == 1)
//				return false;

		return true;// if we reached till here means current cell was safe , so simply return true
	}

	public static void printAllSolutionofNQueen(int board[][], int currRow) {// this function prints all possible
																				// solutions

		if (currRow == board.length) {// base case, means we reached crossed last row and we only cross last row when
										// we get the answer
										// that is we
										// are able to arrange all N queens

			for (int i = 0; i < board.length; i++) {// or instead of printing you can add this board in arraylist or
													// something and make that arraylist global
				System.out.println();
				for (int j = 0; j < board[i].length; j++) {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
			System.out.println("Next Combination");

			return;// return means we printed this solution so go back and print other possible
					// solutions
		}
		for (int col = 0; col < board[currRow].length; col++) {// here we are trying to put 1st queen at every column of
																// 1st row
																// and see can we
																// arrange rest of the queens correctly? , recursion
																// will arrange
																// rest of the queens in rest of the rows if its
																// possible and print it else it will simply come out
																// and check for other columns and if recursion is not
																// able to
																// put it in any column then it will simply return
																// without printing anything

			if (isSafe(board, currRow, col)) {
				board[currRow][col] = 1;// if we are inside means current cell is safe so place queen in it

				printAllSolutionofNQueen(board, currRow + 1);// now have faith in recursion that it will place the
																// remaining queens correctly if its possible and print
																// it , if not then it wont print anything

				board[currRow][col] = 0;// now remove the queen from current cell cause if we are here means above
										// recursive call
										// has already printed all possible solution (if its possible) which we can get
										// if we put 1st
										// queen at current row and col(i.e. current cell) , so now we check for other
										// remaining columns of 1t row and try to place 1st queen there ,
										// therefore htade current cell se queen and now for loop will check for next
										// position i.e. next column
			}
		}
	}

	public static boolean isSafe2(int board[][], int r, int c) {// this is recursive way , i guess its correct but its
		// giving stackoverflow cause there are many ways

		if (isValid(board, r, c)) {
			boolean diagonal1Upper = isSafe2(board, r - 1, c - 1);// go in upper diagonal and tell me is it safe
			boolean diagonal1Lower = isSafe2(board, r + 1, c + 1);
			boolean diagonal2Upper = isSafe2(board, r - 1, c + 1);
			boolean diagonal2Lower = isSafe2(board, r + 1, c - 1);
			boolean rowDown = isSafe2(board, r + 1, c);
			boolean rowUp = isSafe2(board, r - 1, c);
			boolean colLeft = isSafe2(board, r, c - 1);
			boolean colright = isSafe2(board, r, c + 1);
			if (diagonal1Upper && diagonal1Lower && diagonal2Upper && diagonal2Lower && rowUp && rowDown && colLeft
					&& colright && board[r][c] != 1) {// board[r][c] == 1 means queen at current cell
				return true;
			} else {
				return false;
			}

		} else {// i.e. current cell is not valid , so it means we reached here while traversing
// and if we reached till end means we havent found any queen in current path so
// it means current path doesnt have queen so true
			return true;
		}

	}

	public static boolean isValid(int board[][], int r, int c) {
		return !(r >= board.length || r < 0 || c >= board[r].length || c < 0);
	}
}
