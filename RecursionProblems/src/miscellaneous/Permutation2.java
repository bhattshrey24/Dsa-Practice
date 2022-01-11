package miscellaneous;

public class Permutation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int r = 2;
		perm2(1, n, new boolean[r], 0, r, "");
	}

// Permutation using combination
	public static void perm2(int cb, int n, boolean items[], int issf, int r, String ans) {// cb=current box
		// issf = items selected so far ,items = tells us ki konsa konsa item use ho gya
		// eg suppose r = 3 then [T , F , T] means 1st and 3rd items are used in current
		// branch of recursive tree so we are only left with item 2 , don't confuse this
		// items array with boxes array

		if (cb > n) {// base case , i.e. we traversed all boxes

			if (issf == r) {
				System.out.println(ans);
			}
			return;
		}

		for (int i = 0; i < r; i++) {// at each level at max we only have choices equal to total number of items ,
										// i.e if r = 3 then for level 1 when no item is selected then either choose 1
										// ,2 or
										// 3 to put in 1st box i.e. current box , not choosing anything wala case is
										// handled outside
										// this for loop

			if (items[i] == false) {// false means unused , eg if r=4 and items = [T,F,T,F] , it means
								// we can use only 2nd item and 4th item at current level of current branch

				items[i] = true;// true means using it 

				perm2(cb + 1, n, items, issf + 1, r, ans + (i + 1)); // (i+1) cause loop starts with 0 but 1st item is
																		// named as '1'

				items[i] = false;// again marking it unused so that other branches can use it
			}
		}

		perm2(cb + 1, n, items, issf, r, ans + 0);// i.e. the case when we did not select any item for current box
	}
}
