package DP;

import java.util.Scanner;

public class LCS_DP_Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String 1");
		String s1 = sc.next();
		System.out.println("Enter String 2");
		String s2 = sc.next();

		int solDp[][] = lcs(s1, s2);
		System.out.println("LCS is " + solDp[s1.length()][s2.length()]);
	}

	public static int[][] lcs(String s1, String s2) {
		int dp[][] = new int[s1.length() + 1][s2.length() + 1];// +1 , in both cause 1st row and 1st column is for base
																// case i.e. when s1 is empty and when s2 is empty

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {// i - 1 and j - 1 and not i and j cause dp array has 1 extra
															// col and row for base case and we are looping on dp array
															// therefore we have to do this

					dp[i][j] = dp[i - 1][j - 1] + 1;// upper diagonal(since in upper diagonal both s1 and s2 length is 1
													// less than current cell) + 1
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);// max of s1 1 length less s2 as it is(i.e.dp[i][j -
																	// 1] ) and s1
																	// as it is and s2 with 1 less length (i.e.dp[i -
																	// 1][j] )

				}
			}
		}

		return dp;

	}
}
