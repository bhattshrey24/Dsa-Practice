package Arrays_And_Strings;

public class Product_of_Array_Except_Self_238 {

	public static void main(String[] args) {

	}

	// Simply using the concept of prefix product and suffix product , just dry run
	// for [1,2,3,4,5]

	public int[] productExceptSelf(int[] nums) {
		int answer[] = new int[nums.length];
		int prefixProd[] = new int[nums.length];
		int suffixProd[] = new int[nums.length];
		prefixProd[0] = nums[0];
		suffixProd[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {// calculating both prefix and suffix in one
																			// loop
			prefixProd[i] = nums[i] * prefixProd[i - 1];
			suffixProd[j] = nums[j] * suffixProd[j + 1];
		}

		for (int i = 0; i < answer.length; i++) {
			if (i == 0) {// case 1 ie. 1st element so its answer will be simply product of all elements
							// after it ie. suffixProd[i + 1]
				answer[i] = suffixProd[i + 1];
			} else if (i == answer.length - 1) { // case 2 ie. last element so its answer will be simply product of all
													// the element before it ie. prefixProd[i - 1]
				answer[i] = prefixProd[i - 1];
			} else {// case 3 ie. calculating for middle elements , so answer will be product of all
					// the
					// elements before it ie. prefixProd[i - 1] into product of all the elements
					// after it
					// ie. suffixProd[i + 1]
				answer[i] = prefixProd[i - 1] * suffixProd[i + 1];
			}

		}

		return answer;
	}
}
