package Arrays_And_Strings;

import java.util.Iterator;

public class Max_Chunks_To_Make_Sorted_2_LC_768 {

	public static void main(String[] args) {
		Max_Chunks_To_Make_Sorted_2_LC_768 ob = new Max_Chunks_To_Make_Sorted_2_LC_768();
		System.err.println(ob.maxChunksToSorted(new int[] { 14, 18, 10, 16, 12, 20, 26, 22, 24 }));
	}

	public int maxChunksToSorted(int[] arr) {

		int prefixMax[] = new int[arr.length];
		int suffixMin[] = new int[arr.length];// suffixMin means going from right to left and doing same as prefix but
												// for minimum and not maximum

		prefixMax[0] = arr[0];// initializing
		suffixMin[arr.length - 1] = arr[arr.length - 1];// see since we will fill it from right to left therefore it is
														// initialized with last element of array

		for (int i = 1, j = arr.length - 2; i < arr.length; i++, j--) {// making prefix and suffix in one loop only
			prefixMax[i] = Math.max(arr[i], prefixMax[i - 1]);
			suffixMin[j] = Math.min(suffixMin[j + 1], arr[j]);
		}

		int chunk = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			if (prefixMax[i] <= suffixMin[i + 1]) {// this means that current max element reached it correct position
													// i.e. where
													// it should be in sorted array , because see current position se
													// aage sb
													// element current max se bade hai ie. prefixMax[i] <= suffixMin[i +
													// 1]
				chunk++;
			}
		}
		chunk++;// because last chunk check nhi ho paega upr wale for loop mei cause we are
				// comparing ith with i+1 so eg. if we try to check for last ele ie.
				// i=arr.length-1 then it
				// will
				// give out of bound exception therefore last wala chunk we have to add manually
		return chunk;
	}
}
