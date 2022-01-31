package Arrays_And_Strings;

import java.util.ArrayList;
import java.util.List;

public class Aug_7_GFG_1 {
// Q) Given an array of size n and a number k, find all elements that appear more than n/k times

	public static void main(String[] args) {
		Aug_7_GFG_1 ob = new Aug_7_GFG_1();
		int arr[] = new int[] { 3, 1, 3, 3, 3, 2 };
		ArrayList<Integer> ans = ob.funMajEle(arr, arr.length, 4);
		for (int ele : ans) {
			System.out.println(ele);
		}
	}

	// I'm 99% sure that this works
	public ArrayList<Integer> funMajEle(int nums[], int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();

		int val[] = new int[k];
		int count[] = new int[k];

		for (int i = 1; i < val.length; i++) {
			val[i] = Integer.MIN_VALUE;// it means they are uninitialized
		}

		val[0] = nums[0];
		count[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			int currEle = nums[i];

			for (int j = 0; j < val.length; j++) {

				if (currEle != val[j]) {
					if (count[j] == 0) {// this means we can't pair
						val[j] = nums[i];
						break;
					}
					if (j == val.length - 1) { // pairing them all , i.e. in last iteration if we reached till this 'if'
												// condition means all K elements are different and have count>0 which
												// means we can pair them all
						for (int z = 0; z < count.length; z++) {
							count[z]--;
						}
					}
				} else {
					count[j]++;
					break;
				}
			}

		}

		// simply verifying if they are actually majority elements or not , its better
		// to use HashMap , or keep another Count variable array in which u dont do any
		// changes

		for (int i = 0; i < count.length; i++) {
			if (count[i] >= (n / k)) {
				ans.add(val[i]);
			}
		}

		return ans;

	}

}
