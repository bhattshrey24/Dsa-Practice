package Arrays_And_Strings;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_2_LC_229 {
	public static void main(String[] args) {
		Majority_Element_2_LC_229 ob = new Majority_Element_2_LC_229();
		System.out.println(ob.majorityElement(new int[] { 3, 2, 3 }));
	}
	
	// Using Boyer More Voting Algo only with a little tweak , since now there can
	// be more than 1 element having occurance more than n/3 therefore we will make
	// triplet now cause there can not be more than 2 majority elements
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;

		int val1 = nums[0];
		int count1 = 1;
		int val2 = Integer.MIN_VALUE; // this shows that val2 is unintialized
		int count2 = 0;

		for (int i = 1; i < nums.length; i++) {

			if (nums[i] != val1 && nums[i] != val2) {

				if (count1 != 0 && count2 != 0) {// make triplet
					count1--;
					count2--;
					continue;
				} else if (count1 == 0) { // simply means it's occurance is finished i.e. all of them were paired so
											// replace it
					val1 = nums[i];
					count1 = 1;
				} else {
					val2 = nums[i];
					count2 = 1;
				}

			} else if (nums[i] == val1) {
				count1++;// making it available for matching for future
			} else {// i.e. nums[i] == val2
				count2++;
			}

		}

		// simply verifying if they are actually majority elements or not
		count1 = 0;// reinitializing
		count2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == val1) {
				count1++;
			}
			if (nums[i] == val2) {
				count2++;
			}
		}

		if ((count1) > (n / 3)) {
			ans.add(val1);
		}
		if ((count2) > (n / 3)) {
			ans.add(val2);
		}

		return ans;
	}
}
