package OneDArray;

public class AllOccuranceOfAnElement {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 4, 2, 5, 2, 3, 2, 1, 5, 2, 3 };

		// answer For My Approach

		int res[] = allOccurance(arr, 0, 2);
		if (res[0] == 0) {// means element not found cause in base case if we are not getting element we
							// are returning a 1 length empty array
			System.out.print("Ele not found");
		}
		for (int i = 0; i < res.length - 1; i++) {// res.length - 1 cause in base case if element is not the one we want
													// we then we are returning
													// a 1 length empty array and empty array has 0 in it
			int occ = i + 1;
			System.out.println(occ + " occurance :" + res[i]);
		}

		System.out.println();
		System.out.println("Sumit sirs approach ");
		System.out.println();

		// Sumit sirs approach
		int res2[] = allOccurrence2(arr, 0, 2, 0);
		if(res2.length==0) {
			System.out.println("No Occurance found");
		}
		for (int i = 0; i < res2.length; i++) {
			int occ = i + 1;
			System.out.println(occ + " occurance :" + res2[i]);
		}
	}

	// My Approach

	public static int[] allOccurance(int arr[], int idx, int eleToBeFound) {// prints index of all occurance of
																			// eleToBeFound , implementing this function
																			// would have been much easier if we used
																			// arrayList cause then didnot have to copy
																			// elements mannually

		if (idx == arr.length - 1) {// base case , i.e. if we are given array having just 1 element

			int baseAns[] = new int[1];// since we only have element of one size given to us therefore number of
										// occurance of "eleToBeFound" can at max be 1 , therefore we made 1 length
										// array

			if (arr[idx] == eleToBeFound) {// if the element is equal to eleToBeFound we add the elements index to
											// answer array else we send and empty array of length 1 which means we
											// found 0 occurance of "eleToBeFound"
				baseAns[0] = idx;// add elements index to answer array
			}
			return baseAns;
		}
		int ansTillNow[] = allOccurance(arr, idx + 1, eleToBeFound);// we have faith that this will give us an array
																	// having all occurance of "eleToBeFound" in
																	// remaining array

		if (arr[idx] == eleToBeFound) {
			int newAns[] = new int[ansTillNow.length + 1];// +1 cause we current element is also an occurance of
															// eleToBeFound so we add it in answer

			newAns[0] = idx;// adding current element to answer

			for (int i = 0; i < ansTillNow.length; i++) {// copying the other occurances of "eleToBeFound" given to us
															// by recursion in remaining
															// array

				newAns[i + 1] = ansTillNow[i];// i+1 cause at 0th we are current occurance i.e. newAns[0] = idx
			}
			return newAns;
		} else {
			return ansTillNow;// if current element is not equal to eleToBeFound then return whatever
								// occurances
								// recursion gave us
		}
	}

	// sumit sirs Approach (the crux of this problem is that we dont know ki kitne
	// size ka array bnanana hai , so agar arraylist hota toh problem nhi hoti yeh
	// but
	// array se krna hai and not arraylist, so we are going to solve this by keeping
	// an extra parameter
	// "found so far" which will store the number of occurance of eleToBeFound while
	// stack buildup fir utne size ka hi array bnaenege while falling we will add
	// the actual inde of the occurances

	public static int[] allOccurrence2(int arr[], int idx, int eleToBeFound, int fsf) {// fsf aka found so far

		if (idx == arr.length) {// base case , observe here we are going till arr.length and not arr.length-1
								// cause here meaning of base case is different , here we are going till last
								// and finding number of occurance of eleToBeFound and then simply returning
								// array of size equal to number of occruances found

			int baseAns[] = new int[fsf];
			return baseAns;
		}

		if (arr[idx] == eleToBeFound) {
			int ans[] = allOccurrence2(arr, idx + 1, eleToBeFound, fsf + 1);// since arr[idx] == eleToBeFound , means we
																			// found an occruance of eleToBeFound so
																			// tell recursion that
																			// current element is one of the
																			// occurances(by doing fsf+1)
																			// and now tell recursion to go and find
																			// other occurances in
																			// remaninig array by (doing idx+1)

			ans[fsf] = idx;// fsf stores the number of occurances found so far so we add current occurance
							// after previous occurances found so far
			return ans;
		} else {
			return allOccurrence2(arr, idx + 1, eleToBeFound, fsf);// simply tell recursion to go check and give us the
																	// occurances in remaining array
		}
	};
}
