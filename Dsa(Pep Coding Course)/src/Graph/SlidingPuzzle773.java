package Graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

// leet code 773 question
public class SlidingPuzzle773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = { { 4, 1, 2 }, { 5, 0, 3 } };
		int ans = slidingPuzzle(board);

		System.out.println("sol is : " + ans);
	}

	public static int slidingPuzzle(int[][] board) {
		// Step 1 make arraylist of possible positions where 0 can go without going out
		// of bound if it is currently at position i
		ArrayList<Integer>[] ar = new ArrayList[6];
		// possible places 0 can move if its at position ar[i]
		for (int i = 0; i < ar.length; i++) {
			ar[i] = new ArrayList<>(); // just initializing array list basically putting an empty arraylist at every
										// index
		}
		ar[0].add(1);
		ar[0].add(3);
		ar[1].add(0);
		ar[1].add(2);
		ar[1].add(4);
		ar[2].add(1);
		ar[2].add(5);
		ar[3].add(0);
		ar[3].add(4);
		ar[4].add(1);
		ar[4].add(3);
		ar[4].add(5);
		ar[5].add(2);
		ar[5].add(4);

		// Step 2 converting given board into linear string using concept of converting
		// 2d matrix to linear matrix using cell number
		String givenBoard = "";
		int initialPosOf0 = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// System.out.println(str);
				if (board[i][j] == 0) {
					initialPosOf0 = i * board[i].length + j;
				}
				givenBoard = givenBoard + String.valueOf(board[i][j]);

			}
		}
		String requiredBoard = "123450"; // that is the required pattern to be found

		// Step 3 simple bfs
		HashSet<String> vis = new HashSet<>();
		int min = 0;
		ArrayDeque<Pair> que = new ArrayDeque<>();
		que.add(new Pair(givenBoard, 0, initialPosOf0));

		boolean permutaionPossible = false;
		while (!que.isEmpty()) {
			Pair currEle = que.remove();

			if (vis.contains(currEle.permu)) { // check visited
				continue;
			}

			vis.add(currEle.permu); // mark visited

			if (currEle.permu.equals(requiredBoard)) { // work
				min = currEle.cost;
				permutaionPossible = true;
				break;
			}

			for (int pponz : ar[currEle.posOfZero]) { // pponz=possible position of next 0
				String st = "";
				char a, b;
				if (pponz < currEle.posOfZero) { // this is the case when current position of 0 > next position of 0
					a = currEle.permu.charAt(pponz);
					b = currEle.permu.charAt(currEle.posOfZero);// i.e current position of 0
					st = currEle.permu.substring(0, pponz) + b + currEle.permu.substring(pponz + 1, currEle.posOfZero)
							+ a + currEle.permu.substring(currEle.posOfZero + 1); // basically swapping current zeros
																					// position with pponz so that 0
																					// goes to pponz and element at pponz
																					// goes to current position of 0
				} else {// this is the case when current position of 0 < next position of 0
					b = currEle.permu.charAt(pponz);
					a = currEle.permu.charAt(currEle.posOfZero);
					st = currEle.permu.substring(0, currEle.posOfZero) + b
							+ currEle.permu.substring(currEle.posOfZero + 1, pponz) + a
							+ currEle.permu.substring(pponz + 1);
				}

				if (!vis.contains(st)) { // simply checking if it is visited or not and adding it to que if not visited
					que.add(new Pair(st, currEle.cost + 1, pponz));
				}

			}
		}
		if (permutaionPossible) {
			return min;

		} else {
			return -1;

		}
	}

	public static class Pair {
		String permu;
		int cost, posOfZero;

		public Pair(String permu, int cost, int posOfZero) {
			this.permu = permu;
			this.cost = cost;
			this.posOfZero = posOfZero;
		}
	}
	// public class

}
