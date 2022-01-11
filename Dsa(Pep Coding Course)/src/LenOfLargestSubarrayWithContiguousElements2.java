import java.util.HashSet;

public class LenOfLargestSubarrayWithContiguousElements2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 10, 12, 12, 10, 10, 11, 10 };
		System.out.println(LenOfLrgestContiElement2(arr));
	}

	// IN THIS QUESTION DUPLICATES ARE ALLOWED
	// Its in o(n2) , no better TC is possible
	public static int LenOfLrgestContiElement2(int arr[]) {
		// here we just have to keep a visited hashset in order to tackle duplicates
		HashSet<Integer> visited = new HashSet<Integer>();
		int ans = 0;
		int length = 0;
		// now a sub array is contiguous only if the max value in it - min value in
		// that subarray + 1 i.e (max-min+1) is equal to the length of the subarray
		// , and to handle duplicate we keep hashset so whenever we find a visited
		// number again we simply stop processing and move i to i+1
		// length is simply j-i+1 because j and i are starting from 0
		for (int i = 0; i < arr.length; i++) {// we are basically traversing through all possible contiguous subarray

			int max = arr[i];// since new subarray started therefore just assume 1st element to be max and
								// min as well
			int min = arr[i];
			visited = new HashSet<Integer>();// reinitializing array for next time subarray , so that we can start from
												// fresh
			for (int j = i; j < arr.length; j++) {
				if (visited.contains(arr[j])) {
					break;// this puts us out of this inner for loop
				}
				visited.add(arr[j]);// simply mark visited
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				length = j - i + 1;
				if (length == max - min + 1) {
					ans = Math.max(ans, length);
				}
			}
		}

		return ans;
	}
}
