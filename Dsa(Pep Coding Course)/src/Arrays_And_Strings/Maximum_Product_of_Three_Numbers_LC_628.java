package Arrays_And_Strings;

public class Maximum_Product_of_Three_Numbers_LC_628 {

	public static void main(String[] args) {
		Maximum_Product_of_Three_Numbers_LC_628 ob = new Maximum_Product_of_Three_Numbers_LC_628();
		System.out.println(ob.maximumProduct(new int[] { 1, 2, 4, 2, 4 }));

	}

	public int maximumProduct(int[] nums) {
		// Its quite simple , see if there was only positive numbers given to us then
		// simply u would
		// have used 3 variables and then taken out top 3 max products while traversing
		// , but since there are -ve numbers too so they will only be usefull in pair
		// and not triplet i.e. all cause then product will become -ve , so we keep 2
		// more
		// variables to track top 2 maximum numbers magnitude wise for negative numbers
		// and then in the end we compete prodOfNeg*Max of +ve number and product of all
		// 3 Max

		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;
		int negA = Integer.MIN_VALUE;
		int negB = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > a) {
				c = b;// before giving new value to Max1 we first transfer Max2 value to Max3 and then
						// Max1 to Max2
				b = a;
				a = nums[i];
			} else if (nums[i] > b) {
				c = b;
				b = nums[i];
			} else if (nums[i] > c) {
				c = nums[i];
			}

			if (nums[i] < 0) {// means number is negative
				int absNum = Math.abs(nums[i]);
				if (absNum > negA) {
					negB = negA;
					negA = absNum;
				} else if (absNum > negB) {
					negB = absNum;
				}
			}

		}

		int prodNeg = 1;// not doing negA*negB directly so that we don't get unnecessary error of
						// exceeded Int limit or something

		if (negA != Integer.MAX_VALUE && negB != Integer.MAX_VALUE) {
			prodNeg = negA * negB;
		}

		int sol = Math.max(prodNeg * a, a * b * c);

		return sol;
	}
}
