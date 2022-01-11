package DP;

public class Coin_Change_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coinChangeNumOfWays(new int[] { 1, 2, 3 }, 5);

		coinChangeMinNumOfCoins(new int[] { 1, 2, 3 }, 7);
	}

	public static void coinChangeNumOfWays(int coins[], int sum) {
		int dp[] = new int[sum + 1];// +1 for base case
		dp[0] = 1;// i.e. base case
		for (int i = 0; i < coins.length; i++) {// using sumit sir method of 1d array , we can do it using 2d array too
												// , approach is same we are just doing each row answer in one array
												// only

			for (int j = coins[i]; j < dp.length; j++) {// here simply run loop from coin value i.e. if coin is of 3Rs
														// toh uss se pehle koi bhi sum nhi bna skte 3Rs ke coins i.e.
														// 3rs coins can not
														// make sum=0 or 1 or 2 so why to run loop for these simply coin
														// ki value se chlao loop

				dp[j] = dp[j] + dp[j - coins[i]];// dp[j] is previous value i.e. previous coins se sum=jRs bnane ke
													// combinations and dp[j - coins[i]] this tells ki current coin se
													// kitne ways se hum sum = jRs bna skte hai

			}

		}

		System.out.println("Numer of ways are " + dp[sum]);// dp[sum] is nothing but the last index of dp
	}

	public static void coinChangeMinNumOfCoins(int coins[], int sum) {
		int dp[][] = new int[coins.length + 1][sum + 1];

		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < dp[0].length; i++) {// special case of preprocessing , cause here the formula wont work for
												// 1st row cause of Integer.MAX_VALUE i.e. if we add something to
												// infinity
												// then it Fuks up java
			if (i % coins[0] == 0) {
				dp[1][i] = i / coins[0];// cause we need i/coins[0] coins to make sum i with coin[0]
			} else {
				dp[1][i] = Integer.MAX_VALUE;
			}
		}

		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - coins[i - 1]] + 1);// + 1 means we chose
																						// current coin and dp[i - 1][j
																						// - coins[i - 1]] tells
																						// number of min coins required
																						// to make
																						// remaining sum using remaining
																						// coins
				} else {
					dp[i][j] = dp[i - 1][j];// means we cant make current sum using current coin so simply pehle jitne
											// bhi coins the unka jo answer tha wahi mera bhi hai
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			System.out.println();
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
		}
		System.out.println();
		System.out.println("Min coins required are " + dp[coins.length][sum]);
	}
}


