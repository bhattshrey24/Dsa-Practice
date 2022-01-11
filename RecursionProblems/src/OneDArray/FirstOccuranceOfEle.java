package OneDArray;

public class FirstOccuranceOfEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 4, 2, 5, 2, 3, 2, 1, 5, 2, 3 };
		System.out.println(firstOccurance(arr, 0, 5));
	}

	public static int firstOccurance(int arr[], int idx, int eleToBeFound) {// returns index of 1st occurance of ele to
																			// be found

		if (idx == arr.length - 1) {// base case , i.e. if we have array having only 1 element and that element is
									// equal
									// to the
									// "eleToBeFound" then this element is the first occurance of "eleToBeFound"
									// cause there's just 1
									// element in the array

			if (arr[idx] == eleToBeFound) {// if the element is equal to "eleToBeFound" return idx
				return idx;
			} else {// if not then it means there's no occurance of "eleToBeFound" so return -1
				return -1;
			}
		}

		if (arr[idx] == eleToBeFound) {// if current element is the ele to be found return idx cause we are starting
										// from 0 so it means if curr element is equal to "eleToBeFound" then its the
										// 1st occurance of it
			return idx;
		} else {
			return firstOccurance(arr, idx + 1, eleToBeFound);// if current ele was not equal to "eleToBeFound" , so
																// now
																// let recursion give you the first occurance of
																// "eleToBeFound" in the remaining array
		}

	}

}
