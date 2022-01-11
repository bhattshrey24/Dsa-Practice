package miscellaneous;

public class Combination2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int r = 2;
		 printComb2(new boolean[n], 1, r, -1);// passing lb= -1 so that we can
		// consider 1st box too which will be at
		// index 0 in
		// "boxes" array

	}

// Finding combinations using permutation
	public static void printComb2(boolean[] boxes, int ci, int ti, int lb) {// boxes = is simply total boxes we have
																			// i.e. total gaps i.e. "n" , its boolean
																			// cause items
																			// are identical so i daalo ya T doesnt
																			// matter ,eg _ T T _ can easily convert
																			// into _ i i _
																			// ,ci = current boxes , ti = total items to
																			// be selected i.e
																			// "r" , lb = last box i.e pichle level mei
																			// pichla item konse
																			// box mei daala tha

		if (ci > ti) {// base case, i.e. if we exceeded the number of items we needed to arrange then
						// stop
			System.out.println();

			for (int i = 0; i < boxes.length; i++) {// simply convert from eg : - T _ T _ to i _ i _
				if (boxes[i] == true) {
					System.out.print("i ");
				} else {
					System.out.print("_ ");
				}
			}
			return;
		}
		for (int i = lb + 1; i < boxes.length; i++) {// lb+1 cause har level pr hum pichle level se aage daalna chahte
														// hai items so that ascending order mei rahe cheeze
			if (boxes[i] == false) {
				boxes[i] = true;

				printComb2(boxes, ci + 1, ti, i);// have faith that this will print answer for remaining boxes , observe
													// we are passing "i" in "lb"

				
				boxes[i] = false;// backtracking , i.e. marking them false so that we can explore all branches
									// otherwise we wont be able to use the boxes which are marked true in other
									// branches , if still confused just do a dry run you'll understand
			}
		}
	}

}
