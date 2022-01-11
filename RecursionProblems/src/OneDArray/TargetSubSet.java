package OneDArray;

public class TargetSubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 3, 4, 5 };
		printTargetSubset(arr, 0, 6, "", 0);
	}

	public static void printTargetSubset(int arr[], int i, int target, String ans, int ssf) {// ssf means sum so far

// Base cases if we want to RETURN SMARTLY

//		if (i <= arr.length && ssf == target) {// base case 1 , if we are still inside array and sum becomes equal to target then current branch is ans , here we have to do "<=" and not just "<" cause its possible that last element contributes in answer
//			System.out.println(ans);
//			return;
//		}
//		if (ssf > target||i>=arr.length) {// if we go out of bound or if ssf becomes more than target then simply return cause current branch of recursive tree will never give us an ans
//			return;
//		}

// Base case if we want to GO TILL END

		if (i == arr.length) {// base case , reached end
			if (ssf == target) {// just check if ssf is equal to target or not if not then simply return else
								// print and return
				System.out.println(ans);
			}
			return;
		}

		printTargetSubset(arr, i + 1, target, ans + arr[i] + ", ", ssf + arr[i]);
		printTargetSubset(arr, i + 1, target, ans, ssf);

	}
}
