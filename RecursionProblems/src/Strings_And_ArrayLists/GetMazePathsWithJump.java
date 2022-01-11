package Strings_And_ArrayLists;

import java.util.ArrayList;

public class GetMazePathsWithJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMazePathwithJumps(1, 1, 3, 3));
		System.out.println();
		printMazePathWithJump(1, 1, 3, 3, "");
	}

	public static ArrayList<String> getMazePathwithJumps(int r, int c, int n, int m) {
		if (r == n && c == m) {// base case , when u reach destination
			ArrayList<String> baseAns = new ArrayList<>();
			baseAns.add("");
			return baseAns;
		}

		// here we dont have out of board check cause we are doing it while jumping
		// itself , just do a dry run you'll understand

		ArrayList<String> myAns = new ArrayList<>();

		for (int hj = 1; hj <= m - c; hj++) {// "m-c" cause suppose 4X4 matrice given and u are at 1X1 then valid
												// horizontal moves
												// are 1,1 to 1,2 , 1,1 to 1,3 and 1,1 to 1,4 which is simply (m-c)

			ArrayList<String> recAnsH = getMazePathwithJumps(r, c + hj, n, m);
			for (String str : recAnsH) {
				myAns.add("H" + str);
			}

		}
		for (int vj = 1; vj <= n - r; vj++) {// "n-c" cause suppose 4X4 matrice given and u are at 1X1 then valid
			// vertical moves
			// are 1,1 to 2,1 , 1,1 to 3,1 and 1,1 to 4,1 which is simply (n-c)
			ArrayList<String> recAnsV = getMazePathwithJumps(r + vj, c, n, m);
			for (String str : recAnsV) {
				myAns.add("V" + str);
			}

		}
		for (int dj = 1; dj <= n - r && dj <= m - c; dj++) {// here dj <= n - r && dj <= m - c cause while travelling
															// diagonally we
															// have to check that we don't cross the board from right
															// side or bottom side , eg you are at 2,1 so valid diagonal
															// moves from here are from 2,1 to 3,2 from 2,1 to 4,3,
															// now next jump i.e. 2,1 to 5,4 is out of bottom wall of
															// grid/maze , same way
															// suppose u r at 1,2 then diagonal moves are from 1,2 to
															// 2,3 ,from 1,2 to 3,4 , now next jump i.e. 2,1 to 4,5 is
															// out of right
															// wall of grid/maze.

			ArrayList<String> recAnsD = getMazePathwithJumps(r + dj, c + dj, n, m);// have faith that recrusion will
																					// return paths from these diagonal
																					// jumps
			for (String str : recAnsD) {
				myAns.add("D" + str);
			}

		}
		return myAns;

	}

	
	public static void printMazePathWithJump(int r, int c, int n, int m, String path) {
		if (r == n && c == m) {// base case , when u reach destination
			System.out.print(path + ", ");
			return;
		}

		for (int hj = 1; hj <= m - c; hj++) {
			printMazePathWithJump(r, c + hj, n, m, path + "H");

		}

		for (int vj = 1; vj <= n - r; vj++) {
			printMazePathWithJump(r + vj, c, n, m, path + "V");

		}
		for (int dj = 1; dj <= n - r && dj <= m - c; dj++) {
			printMazePathWithJump(r + dj, c + dj, n, m, path + "D");
		}

	}

}
