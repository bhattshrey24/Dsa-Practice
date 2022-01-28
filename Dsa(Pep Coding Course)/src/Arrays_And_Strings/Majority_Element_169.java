package Arrays_And_Strings;

public class Majority_Element_169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// We can solve it using hashmap too but that will take space
	
	// We are using Boyer Moore Voting Algo
	// TC=O(n) and SC= O(1)
	public int majorityElement(int[] nums) {
		int val = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == val) {

				count++; // so that it might pair up with someone else in future , remember we only pair
							// distinct elements

			} else {// means we can pair it with previous element

				if (count == 0) {
					val = nums[i];
					count = 1;
				} else {// pair it
					count--;
				}

			}
		}
		return val; // here we are simply returning it without verifying it that wether it is even
					// majority or not cause its given that there is one majority element always .If
					// this was not given then simply u would have checked 'val' is majority or not
					// by looing through the array and counting it occurance if its more than n/2
					// then yes else theres no majority element in array
	}
}
