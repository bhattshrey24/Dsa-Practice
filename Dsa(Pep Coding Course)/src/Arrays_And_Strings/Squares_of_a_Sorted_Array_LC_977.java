package Arrays_And_Strings;

public class Squares_of_a_Sorted_Array_LC_977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] sortedSquares(int[] nums) {
		// Time complexity = O(N) and not O(nLog(n))

		int i = 0, j = nums.length - 1;
		int k = nums.length - 1;

		int ans[] = new int[nums.length];
		// the concept is that since given array is sorted so that last place of answer
		// array will be filled by either the first element i.e. the most negative
		// number yet the biggest maginutde wise in all negative number or the right
		// most number which is the biggest in all positive number.Then whichever it was
		// simply put it in answer array and move that pointer cause now we will be
		// competing for second last place and so on

		// basically look it this way that the given array is sorted mangitude wise in
		// both
		// directions i.e. eg arr[-20,-16,-2,-1, 5,6,10,16,18]
		// just see
		// that from -1 till left most element the magnitude is increasing and from 5
		// till
		// right most element also the magnitude is increasing. Since we will be
		// squaring
		// therefore sign doesn't matter only magnitude does

		// its very simple just do a dry run
		while (i <= j) {// move both pointers till they cross each other

			int val_i = nums[i] * nums[i];
			int val_j = nums[j] * nums[j];

			if (val_i > val_j) {
				ans[k] = val_i;// we are fillinf this from right to left
				i++;
				k--;
			} else {
				ans[k] = val_j;
				j--;
				k--;
			}
		}
		return ans;
	}
}
