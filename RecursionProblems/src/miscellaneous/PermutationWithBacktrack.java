package miscellaneous;

public class PermutationWithBacktrack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int r = 2;
		permWithBackTrack(new int[n], r, 1);

	}

	public static void permWithBackTrack(int boxes[], int r, int ci) {// boxes are bascially "n" i.e. number of gaps ,
																		// and boxes in the end stores the answer , ci=
																		// current gap

		if (ci > r) {// base case , simply print
			System.out.println();
			for (int i = 0; i < boxes.length; i++) {
				if (boxes[i] == 0) {
					System.out.print("_ ");
				} else {
					System.out.print(boxes[i] + " ");
				}
			}
			return;
		}

		for (int i = 0; i < boxes.length; i++) {

			if (boxes[i] == 0) {// checking if we visited it or not , i.e checking wether we already placed a
								// number on this
								// boxes in current branch of recursive tree or not , 0 means not visited , any
								// other
								// number
								// means visited

				boxes[i] = ci;// putting the gap number , this also marks its visited

				permWithBackTrack(boxes, r, ci + 1);// have faith that this will print answer for remaining gap i.e. ci
													// se aage wale gap

				boxes[i] = 0;// backtracking , this is because we are sort of marking visited in start, so if
								// we
								// don't
								// mark them unvisited while backtracking then we can't use it for some other
								// path , so we do this so that we can explore all paths i.e. print all
								// permutations
			}
		}
	}

}
