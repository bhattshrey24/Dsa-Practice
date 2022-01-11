package DP;

public class Coin_Change_Recursion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinChaangeMinNumberOfCoins(new int[] { 1, 2, 3 }, 11));

		System.out.println(Integer.MIN_VALUE + 1);// observe this break java , infinity + 1 is giving -ve inifinity
	}

	public static int coinChaangeMinNumberOfCoins(int arr[], int sum) {
		if (sum == 0) {
			return 0;
		}
		if (sum < 0) {// this means its impossible to make -ve sum with any number or denomination of
						// coin therefore return + Infinity cause in the end we dont wont to add this
						// path and we are finding min so +infinity will never be picked

			return 10000000;// theoretically this should be + infinity i.e. Integer.MAX_VALUE but java
							// breaks when you add something to infinity i.e. we took very big possible
							// integer number manually
		}
		return Math.min(
				Math.min(1 + coinChaangeMinNumberOfCoins(arr, sum - arr[0]),
						1 + coinChaangeMinNumberOfCoins(arr, sum - arr[1])),
				1 + coinChaangeMinNumberOfCoins(arr, sum - arr[2]));// we basically telling recursion to go find whether
																	// we can make the
		// remaining of the required sum if yes then give me minimum coins ,
		// we choose 1st coin add it to solution and tell recursion to see
		// can u make the sum and do same for all denomination , 1 +
		// coinChaange(arr, sum - arr[0]) means we chose the first coin
		// (thats why +1 ) and
		// telling recursion to give us minimum number of coins required to
		// make remaining sum

	}

}
