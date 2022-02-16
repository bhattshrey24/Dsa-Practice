package Arrays_And_Strings;

public class Largest_Number_At_Least_Twice_of_Others_747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Its quite simple , just dry run for [0,0,3,2] and [1,0,2,3,6] they cover all
	// cases

	public int dominantIndex(int[] nums) {
		int ansIndex = 0;// stores index of the answer element
		int max = nums[0];// initially we are assuming that 1st element is max and satifies the contition
							// that it is bigger than or equal to twice of every other element

		for (int i = 1; i < nums.length; i++) {// starting loop from 2nd element of array

			if (nums[i] > max) {// this means we found an element which is bigger than the max

				if ((max * 2) <= nums[i]) {// checking if it satisfies the condition given in the problem statement
					max = nums[i];
					ansIndex = i;
				} else {// this means it doesn't satisfies
					max = nums[i];// in this case max will change cause current element is bigger than previous
									// max but answer index will be initialized to -1 because it means if current
									// element is the biggest till now and still it can't satisfy the given
									// condition then
									// obviously elements before it could not do it either
					ansIndex = -1;
				}
			} else {// case when current element are smaller than or equal to max
				if (nums[i] * 2 > max) {// checking if they satisfies the given condition or not , if not then max won't
										// change since current element is smaller than or equal to max element but we
										// initialize the answer to -1 which means there's no answer found
										// till now cause current element violates the given condition in problem
										// statement
					ansIndex = -1;
				}
			}
		}
		return ansIndex;
	}
}
