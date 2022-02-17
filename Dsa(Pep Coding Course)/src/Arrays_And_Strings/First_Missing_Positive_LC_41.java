package Arrays_And_Strings;

public class First_Missing_Positive_LC_41 {

	public static void main(String[] args) {
		First_Missing_Positive_LC_41 ob = new First_Missing_Positive_LC_41();
		System.out.println(ob.firstMissingPositive(new int[] { -1, 1, 2, 5, 3, 2, 4, 12 }));

	}

	public int firstMissingPositive(int[] nums) { // its not correct , sir showed the real answer code at 2:01:00 , so
													// see that and fix your code

		// NOTE : 0 is not considered as positive number , only considering natural
		// numbers as positive

		int n = nums.length;

		// Its quite simple we will put elements in their correct position ie. if number
		// is 3 then it should be at i-1 index ie. 3-1 ie. index 2 , if its 1 then it
		// should be at
		// index i-1 ie. 1-1 ie. index 0 then after
		// this loop we run another loop and check if any number is there which is out
		// of range , if yes suppose at index 3 and 6 numbers are out of range then
		// answer will be the first
		// index+ 1 ie. 3+1 ie 4 if all are in range then answer will be nums.length+1
		// cause we need smallest positive number which is not in array

		// it's easy just do a dry run for { -1, 1, 2, 5, 3, 2, 4, 12 }
		for (int i = 0; i < n; i++) {
			if (nums[i] == i + 1) {// ie. element already in its correct position so simply move on ,no need to
									// check whether it's in range or not cause if it satisfies nums[i]==i+1 it
									// means
									// it's in range cause see i+1 can never be more than nums.length
				continue;
			}

			if (nums[i] < 1 || nums[i] > n) {// checking if it's out of range or not , if yes then simply move ahead
												// cause we can't put it in its right position cause its correct
												// position will not be in range of array's length , remember 0 is not
												// considered as positive
				continue;
			}

			int idx1 = i;
			int idx2 = nums[i] - 1;

			if (nums[idx1] == nums[idx2]) {// this is to handle duplicacy like if element at idx1 is same as element at
											// idx2 then we will get stuck in infinite loop
				continue;
			}
			swap(nums, idx1, idx2);// swapping them , they won't keep swapping infinitely between themselves cause
									// remember idx2 is nums[i]-1 so this will change every time we swap

			i--;// doing i-- so that we keep doing swap till either element at ith index is i+1
				// or it's out of range this is basically checked by first two 'if' conditions
				// that we
				// wrote
		}

		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != j + 1) {
				return j + 1;
			}
		}
		return nums.length + 1;
	}

	public void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

//int i = 0;
//while (i < nums.length) {
//	if (nums[i] == i + 1) {// no need to check for 'in range' cause if its nums[i] == i + 1 means its in
//							// range
//		i++;
//		continue;
//	} else if (nums[i] < 1 || nums[i] > nums.length) {
//		i++;
//		continue;
//	} else {// not in range so simply move forward
//		while (true) {
//			swap(nums, i, nums[i] - 1);
//			if ((nums[i] < 1 || nums[i] > nums.length) || nums[i] == i + 1) {
//				break;
//			}
//		}
//		i++;
//	}
//}