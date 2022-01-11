package OneDArray;

public class LastOccruanceOfEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 4, 2, 5, 2, 3, 2, 1, 5, 2, 3 };

		System.out.println(lastOccurance1(arr, 0, 2));

		System.out.println(lastOccurance2(arr, arr.length - 1, 2));
	}

// See firstOccurance problem first

	// Approach 1 (going from left to right in array and doing work while stak is
	// falling)

	public static int lastOccurance1(int arr[], int idx, int eleToBeFound) {
		if (idx == arr.length - 1) {// base case , i.e. if we have array having only 1 element and its equal to the
									// "eleToBeFound" then it
									// is the lastOccurace of "eleToBeFound" cause there just 1 element in the array

			if (arr[idx] == eleToBeFound) {// if the element is equal to "eleToBeFound" return idx
				return idx;
			} else {// if not then it means there's no occurance of "eleToBeFound" so return -1
				return -1;
			}
		}

		int rem = lastOccurance1(arr, idx + 1, eleToBeFound);// have faith that this function returns the last occurance
																// of "eleToBeFound" if there is any

		if (rem != -1) {// means recursion found last occurance of eleToBeFound in the remaining array
			return rem;
		} else {// means recursion did not find last occurance of eleToBeFound in the remaning
				// array in which case if current element is equal to "eleToBeFound" then
				// current element
				// is the lastOccurance of "eleToBeFound"
			if (arr[idx] == eleToBeFound) {
				return idx;
			} else {
				return -1;
			}
		}
	}

	// Approach 2 (going from right to left and doing work when stack is building)
	public static int lastOccurance2(int arr[], int idx, int eleToBeFound) {// returns index of last occurance of
																			// eleToBeFound

		// same as FirstOccuranceOfEle , just here we start from last , i.e we are
		// moving from right to left

		if (idx == 0) {// since we are strating from end of array therefore base case will be n==0
			if (arr[idx] == eleToBeFound) {
				return idx;
			} else {
				return -1;
			}
		}

		if (arr[idx] == eleToBeFound) {
			return idx;
		} else {
			return lastOccurance2(arr, idx - 1, eleToBeFound);// idx-1 cause we are moving from right to left
		}

	}
}
