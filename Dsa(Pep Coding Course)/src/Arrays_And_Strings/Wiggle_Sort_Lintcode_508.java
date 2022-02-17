package Arrays_And_Strings;

public class Wiggle_Sort_Lintcode_508 {

	public static void main(String[] args) {
		new Wiggle_Sort_Lintcode_508().wiggleSort(new int[] { 3, 5, 2, 1, 6, 4 });// directly making object and calling
																					// function on it instead of simply
																					// saving it in a variable and then
																					// calling function on that variable
	}

	// its quite simple actually
	// what we have to do is that even index elements should be smaller or = than
	// element
	// just ahead of it and element just before it and element at odd index should
	// be bigger or = than element just ahead of it or before it.

	// So simply keep checking if the above property is valid or not for current
	// element and the element just next to it and if not then
	// simply swap cause see swapping will basically swap the equality and that is
	// what we want , just do a dry run and you'll understand

	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {

			if (i % 2 == 0) {// ie. current index is even
				if (nums[i + 1] < nums[i]) {// ie. current ele and element next to it is violating the condition so
											// simply swap them
					swap(nums, i, i + 1);
				}
			} else {
				if (nums[i + 1] > nums[i]) {
					swap(nums, i, i + 1);
				}
			}
		}
		for (int ele : nums) {// just displaying
			System.out.println(ele);
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
