package OneDArray;

public class MaxOfAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 2, 4, 2, 5, 7, 3, 5, 2, 9, 2, 3, 1 };
		// findMax(arr, 0);
		System.out.println(findMax(arr, 0));
	}

	public static int findMax(int arr[], int idx) {
		if (idx == arr.length - 1) {// base case , if only 1 element is there then that element is the max element
			return arr[idx];
		}
		int max = Math.max(arr[idx], findMax(arr, idx + 1));// we have faith that findMax(arr, idx + 1) returns us the
															// max element in remaining array so we are just comparing
															// that max element with current ele if current ele is
															// bigger than
															// max ele of remaining array than curr ele is max otherwise
															// the max returned by recursion is max element

		return max;
	}
}
