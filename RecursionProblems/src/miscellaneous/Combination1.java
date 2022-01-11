package miscellaneous;

public class Combination1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printComb1(1, 4, 2, 0, "");
	}

	// Finding combinations using subsequence
	
	public static void printComb1(int cb, int tb, int ts, int bssf, String ans) {// cb= current box , tb= total boxes
																					// i.e "n" , ts = total selections
																					// i.e. "r" , bssf = boxes selected
																					// so far

		if (ts < bssf) { // adding this base case will stop us from doing unnecessary work and improve
							// our time complexity a lot , i.e. agar
							// hum required selection se zyada select kr chuke in current branch toh aage
							// jaane ka no use cause iss branch se we wont get an answer
			return;
		}

		if (cb > tb) {// base case , i.e. reached end of the current branch in recursive tree

			if (bssf == ts) {// i.e. if the boxes we selected in current branch of recursive tree is equal to
								// the boxes we have to
								// select then only print otherwise if its more or less then simply return
								// without printing

				System.out.println(ans);
			}
			return;
		}

		printComb1(cb + 1, tb, ts, bssf, ans + "_ ");// current box not selected , here for showing "not selected" we are
													// using "_"

		printComb1(cb + 1, tb, ts, bssf + 1, ans + "i ");// current box selected

	}
}
