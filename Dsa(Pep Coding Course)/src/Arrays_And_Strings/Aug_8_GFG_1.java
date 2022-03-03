package Arrays_And_Strings;

import java.util.LinkedList;

public class Aug_8_GFG_1 {
// The actual name of the question is "Find the smallest number whose digits multiply to a given number n"
//We have already done it using hashmap I guess
	public static void main(String[] args) {
		String ans = getSmallest(26L);
		System.out.println(ans);
//		long a = 25 / 5;
//		System.out.println(a);
	}

	static String getSmallest(Long N) {
		// its useless to take 2 or greater digit factor because in question it's given
		// that we want to create 'p' such that if we multiply all digits we get 'n' ie.
		// suppose you have n=100 so if you think (20)*5 is better then you are wrong
		// cause
		// according to problem statement it
		// will read it as 2*0*5 ie. 0 and not 100 , therefore it's better to take one
		// digit
		// factors only

		// Since we need to create the smallest number so it's better to start dividing
		// by 9 and go till 2 cause see eg '12' can also be created like 2*2*2*3 which
		// is 4 digits number(ie. 2223) and also like 6*2 which is just 2 digits

		LinkedList<Integer> ll = new LinkedList<>();// LL so that we can do addFirst
		int i = 9;
		Long originalNumber = N;

		while (N > 1 && i > 1) {// ie. keep looping till either the given number finishes or the factors

			if (N % i == 0) {// this means i is a factor of N
				ll.addFirst(i);
				N = N / i;
				continue;// continue; cause its possible that 'i' may divide new 'N' again eg 100/5 =20 ,
							// now 5 can also divide 20(ie. the new N) again therefore dont reduce 'i'
							// instead continue so that in next loop it can divide 20 again
			} else {
				i--;
			}
		}

		if (ll.size() == 0) {// ie. it means the number was a prime number bigger than 10 therefore no digit
								// was able to divide the number even once
			return "-1";
		}

		long product = 1;
		for (int dig : ll) {// making the actual number created by doing products of elements of LL because
							// see below:-
			product *= dig;
		}

		if (product != originalNumber) {// This is for cases like '26' , so here it will divide with 2 to give 13 so ll
										// won't be empty , now 13
										// cannot be converted into a number whoe's digits when multiplied gives 13
										// cause
										// it's 2 digit prime number see 1*3 is 3 and not 13 if you think answer is 131
										// then also wrong it won't take it as 13*1 but according to question it will
										// compile as 1*3*1 ie. 3
			return "-1";
		}

		String ans = "";
		for (int dig : ll) {
			ans += dig;
		}
		return ans;
	}
}
