package Arrays_And_Strings;

public class Maximum_Swap_LC_670 {

	public static void main(String[] args) {
		Maximum_Swap_LC_670 ob = new Maximum_Swap_LC_670();
		int ans = ob.maximumSwap(9973);
		System.out.println(ans);
	}

	// concept wise it's easy but implementation is quite confusing , Just see video
	// first then the code

	// we can also do it using suffix max concept but then we will take space , this
	// method solves in TC=O(n) and SC=O(1)// because digitArray is always of length
	// 10 ie constant

	// this method can easily be modified to solve for number having digit more than
	// 10^5 (which will be given as string because no data type can hold such a
	// large
	// number)

	public int maximumSwap(int num) {
		int temp = num;
		String strNum = "";

		while (temp != 0) {// just m=converting given number to string
			int dig = temp % 10;
			strNum = dig + strNum;// see here I put 'dig' before 'StrNum' so that I don't have to reverse the
									// 'StrNum' afterwards
									// to create the given number 'num'
			temp = temp / 10;
		}

		int digitArr[] = new int[10]; // here each index represents the digit(0-9) and value stored at each index
										// represents
										// the index at which we found the number in StrNum like example at the number
										// stored at index 4 in digitArr will be the INDEX at which we found '4' in
										// StrNum

		for (int i = 0; i < digitArr.length; i++) {
			digitArr[i] = -1;// initializing with -1 because it will tell us that we haven't found number 'i'
								// yet in StrNum , just keep reading you'll understand
		}

		for (int i = strNum.length() - 1; i >= 0; i--) {// starting from left to right cause we we want to put the last
														// occurance ie. if 8 occurs at index 4 and 7 then we will store
														// index 7 and not 4 cause then number from index 0-6 have
														// chance that
														// they can swap with number at index 7

			if (digitArr[Character.getNumericValue(strNum.charAt(i))] == -1) { // Character.getNumericValue(strNum.charAt(i))
																				// this basically converts character to
																				// integer
				digitArr[Character.getNumericValue(strNum.charAt(i))] = i;
			}
		}

		String ans = "0";
		boolean didWeSwap = false;

		int idx1 = -1;
		int idx2 = -1;

		for (int i = 0; i < strNum.length(); i++) {
			int currDig = Character.getNumericValue(strNum.charAt(i));// 4

			// TC is not n^2 because digitArr length is constant ie. 10
			for (int j = digitArr.length - 1; j > currDig; j--) {// starting from last till the number because we want
																	// to create the biggest possible number

				if (digitArr[j] > i) {// no need to check wether number is greater or not because we are moving from
										// right to left so autimatically we will start from highest till min , we just
										// have to check that is it's occurance after currDigit's occurance cause we
										// want to put bigger value at bigger place value

					didWeSwap = true;
					idx1 = Math.min(digitArr[j], i);
					idx2 = Math.max(digitArr[j], i);

					break;
				}
			}

			if (didWeSwap) {
				break;
			}
		}

		if (didWeSwap) {
			ans = strNum.substring(0, idx1) + strNum.charAt(idx2) + strNum.substring(idx1 + 1, idx2)
					+ strNum.charAt(idx1) + strNum.substring(idx2 + 1); // simply swapping the numbers

			return Integer.parseInt(ans);
		} else {// means there's no way we can create a bigger number by just ine swap so simply
				// return the same number
			return num;
		}

	}
}
