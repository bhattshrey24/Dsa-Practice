
public class LenOfLargestSubarrayWithContiguousElements1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		System.out.println(LenOfLrgestContiElement1(arr));
	}

	// IN THIS QUESTION DUPLICATES IS NOT ALLOWED , But in 2nd part of this its
	// allowed
	// Its in o(n2) , no better TC is possible
	public static int LenOfLrgestContiElement1(int arr[]) {
		int ans = 0;
		int length = 0;
		// now a sub array is contiguous only if the max value in it - min value in
		// that subarray + 1 i.e (max-min+1) is equal to the length of the subarray
		// (remember this works
		// cause theres no duplicates)
		// length is simply j-i+1 because j and i are starting from 0
		for (int i = 0; i < arr.length; i++) {// we are basically traversing through all possible contiguous subarray
			int max = arr[i];// since new subarray started therefore just assume 1st element to be max and
								// min as well
			int min = arr[i];
			for (int j = i; j < arr.length; j++) {
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
