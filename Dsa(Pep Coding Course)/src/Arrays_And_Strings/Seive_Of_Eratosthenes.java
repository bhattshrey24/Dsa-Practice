package Arrays_And_Strings;

public class Seive_Of_Eratosthenes {

	public static void main(String[] args) {
		soe(55);
	}

	public static void soe(int n) {
		//false means prime and true means not prime
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

		// displaying the solution
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == false) {
				System.out.println(i);
			}
		}

	}
}
