
public class Next_Greater_Element_III_LC_556 {

	public static void main(String[] args) {
		Next_Greater_Element_III_LC_556 ob = new Next_Greater_Element_III_LC_556();
		long i = 22222222L;
		System.out.println(2154 % 10);
		System.err.println(ob.nextGreaterElement(12543221));
		
		int a=-10;
		int b=Math.abs(a);

	}

	public int nextGreaterElement(int n) {
		// To understand better just dry run for 12543221 , ans for this is 1312245

		int temp = n;
		int k = 0;

		while (temp != 0) { // simply calculating number of digits in the given number
			temp = temp / 10;
			k++;
		}

		if (k == 1) {// when number is 1 digit only means no swapping possible
			return -1;
		}

		int[] num = new int[k];

		temp = n;// reinitializing temp so that we can use it again

		int i = num.length - 1; // we will fill the num array from right to left cause we will extract digit in
								// below 'while' loop we do it from last i.e. right to left eg if number is
								// 22456
								// so first we will take out 6 then 5 then 4 then 2 then 2

		while (temp != 0) {
			int dig = temp % 10;
			num[i] = dig;
			i--;
			temp = temp / 10;
		}

		double ans = 0;// double cause in the end we will check if new number exceeds the limit of int
						// then we return -1

		boolean isDecreasing = true;// if whole number is decreasing then its not possible to make a bigger number y
									// swappig eg 8654321 , now u can try all possible swaps yet u wont be able to
									// make a bigger number

		for (int j = num.length - 1; j > 0; j--) {// we will go from right to left i.e. first 'ones' place then 'tens'
													// place then 'hundreds' and so on

			if (num[j] > num[j - 1]) {// means we found the number that needs to be swapped

				int idxOfNoToBeSwapped = num[j - 1];// number that we need to swap is (j-1)th and not jth

				int z = num.length - 1;// we are starting from last cause if we reached till j means all previous
										// numbers were
										// in descending order which means last element is the smallest so since we need
										// just bigger number from the one that is to be swapped therefore we start from
										// last

				int justBiggerNumIndex = z;

				while (z >= j) {// just smaller wala dhoond rhe hai
					if (num[z] > idxOfNoToBeSwapped) {
						justBiggerNumIndex = z;
						break;
					}
					z--;
				}
				swap(num, j - 1, justBiggerNumIndex);// swap them
				// still our work is not done , now we will make the elements before j-1
				// arranged in
				// ascending order cause then only we will get smallest number which just bigger
				// then the one given , now to do this we just have to reverse (i.e jth element
				// becomes the last , j+1th becomes 2nd last and so on ) them cause they
				// were in descending order cause if they weren't then we wouldn't have reached
				// till jth index

				int len = num.length - 1 - (j - 1);// length of the array that we are reversing

				for (int x = j, y = num.length - 1; x < (len / 2) + j; x++, y--) {// simply swapping jth element with
																					// the last , j+1th with 2nd last
																					// and so on
					swap(num, x, y);
				}

				isDecreasing = false;
				break;
			} else {// num[j] > num[j - 1] i.e. means they are descending so continue
				continue;
			}
		}

		if (isDecreasing) {
			return -1;
		}

		k = k - 1;

		for (int j = 0; j < num.length; j++) {// converting the array into actual number
			ans = num[j] * Math.pow(10, k) + ans;
			k--;
		}

		if (ans > Integer.MAX_VALUE) {// means new number overflowed the range of int
			return -1;
		} else {
			return (int) ans;
		}

	}

	public void swap(int arr[], int i, int j) { // simple swapping function
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
