package Arrays_And_Strings;

public class Number_of_Subarrays_with_Bounded_Maximum_795 {

	public static void main(String[] args) {
		Number_of_Subarrays_with_Bounded_Maximum_795 ob = new Number_of_Subarrays_with_Bounded_Maximum_795();
		System.out.println(ob.numSubarrayBoundedMax(new int[] { 3, 6, 8, 7, 5, 4, 1, 10, 6, 8 }, 6, 8));
	}

// Here only the max of subarray should be in range , others dont matter
// eg:- [3,6,7,5,4,1] , L=6 , R=8
// in above example (7,5,4,1) is a valid contiguous subarray because the max of this subarray is 7 and
// it is in range ie. left<=7<=right even though 4,5 and 1 are not in range  	

	public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		int i = 0, j = 0, ans = 0, previousValidCount = 0;// previousValidCount acts like a Dp actually cause we are
															// basically storing previous answer and using it to answer
															// current one

		// We only have three cases
		// 1) current number is lower than left
		// 2)current number is lower than left
		// 3)current number is in range ie. left<=nums[i]<=right
		while (j < nums.length) {

			if (nums[j] < left) {// case 1
				ans += previousValidCount;
				j++;
			} else if (nums[j] > right) {// case 2
				i = j + 1;// jumping ahead of it , it acts like a wall
				j = i;
				previousValidCount = 0;// reinitializing previous count cause now previous elements does not matter
										// cause we want contiguous subarray and if we include previous elements then
										// automatically
										// previous ele i.e. the one which is bigger than right will also be included

			} else {// case 3 ie. in range
				ans += (j - i + 1); // adding alll valid contiguous subarrays
				previousValidCount = j - i + 1;// updating cause it will be usefull in case 1
				j++;
			}
		}
		return ans;
	}
}
