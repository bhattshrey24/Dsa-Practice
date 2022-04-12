package Arrays_And_Strings;

import java.util.ArrayList;

public class Prime_Generator_Spoj {

	public static void main(String[] args) {
		primeGenerator(22, 52);
	}

	// basically we have to generate prime number in a given range ie. between a and
	// b
	// here we have a restriction of space ie. n can exceed the limit of max array
	// length that we can make so we cant simply apply Seive of eratosthenes
	// but "m-n" is in range

	public static void primeGenerator(int m, int n) {
		// simply using normal seive of eratosthenes to get all prime numbers from 2 to
		// sqrt(n)
		ArrayList<Integer> listOfPrimeNumFrom2toRootN = soe((int) Math.ceil(Math.sqrt(n)));

		boolean ans[] = new boolean[n - m + 1];

		for (int i = 0; i < listOfPrimeNumFrom2toRootN.size(); i++) {

			int currPrime = listOfPrimeNumFrom2toRootN.get(i); // simply we will take each prime and mark there multiple
																// true

			int startNum = (((int) Math.ceil(m * 1.0 / currPrime)) * currPrime) - m; // simple maths we are finding the
																						// next multiple of given prime
																						// in given range like if range
																						// is 22 to 50 and current prime
																						// number is 3 so it's 1st
																						// multiple in given range is
																						// 24 ie. Ceil(m/3)*3 =
																						// 8*3 = 24 , and in index
																						// 24 is simply 24-m= 24-22 ie 2
																						// ie. index 2 represents number
																						// 24
																						// so start from index 2 and
																						// take
																						// jumps of 3 and mark them true
																						// ie. not prime

			for (int j = startNum; j < ans.length; j += currPrime) {
				ans[j] = true;
			}

		}

		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == false) {
				System.out.println(m + i);
			}
		}

	}

	public static ArrayList<Integer> soe(int n) {

		// false means prime and true means not prime
		boolean arr[] = new boolean[n + 1]; // we did n+1 cause we need prime numbers till 'n' so if we dont do n+1 then
											// it wont include nth number even if its prime

		for (int i = 2; i * i < n; i++) {
			int currNum = i;
			if (arr[i] == false) {// this is we are checking whether current number is prime or not because we
									// only check/loop for Prime Numbers that lie in range 2 to sqrt(n)

				for (int j = currNum * 2; j <= n; j += currNum) { // here we start from next multiple like if we are
																	// doing for 2 then don't mark 2 as 'not prime'
																	// instead start from its next multiple ie. 4 and
																	// take a jump of 2 from there like 4,6,8,... , and
																	// we did i*i<n cause we can convert i<sqrt(n) to
																	// i*i<n by squaring both sides

					arr[j] = true;// simply uske multiples pr jaakr non prime mark krdo

				}

			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		// displaying the solution
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == false) {
				ans.add(i);
			}
		}
		return ans;

	}
}
