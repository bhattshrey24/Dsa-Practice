package DP;

import java.util.Scanner;

public class LCS_Recursive {
//LCS means Longest common subsequence
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String 1");
		String s1 = sc.next();
		System.out.println("Enter String 2");
		String s2 = sc.next();

		System.out.println("LCS is len is " + lcs(s1, s2, s1.length() - 1, s2.length() - 1));
	}

	public static int lcs(String s1, String s2, int i, int j) {// pointer "i" is for s1 and "j" is for traversing s2 ,
																// and we are traversing from n-1(i.e. string length -1)
																// to 0

		if (i == -1 || j == -1) {// base case ,i==-1 means string 1 finished and j==-1 means s2 finished while
									// traversing, mtlb koi bhi ek khtm ho gyi ya dono hi khtm ho gyi
									// traverse krte
									// krte toh compare
									// krne ko kuch bcha hi nhi toh lcs length for this case will be 0 ,
									// eg s1="abc" and s2="" so len of lcs is 0 cause 2nd string is
									// empty
			return 0;
		}

		if (s1.charAt(i) == s2.charAt(j)) {// means current elements(i.e. characters on which i and j are pointing to in
											// s1 and s2 respectively)
											// match means we can add them in answer

			return lcs(s1, s2, i - 1, j - 1) + 1;// "+1" cause current characters match means lcs length increased by 1
													// ,
													// and lcs(s1, s2, i - 1, j - 1) means we are putting leap of faith
													// in recursion ki jaa and baaki bachi s1 and s2 strings mei se lcs
													// nikal kr de
													// and here we decrease pointer of both string i.e. i=>i-1 and
													// j=>j-1 cause we found match so decrease length of both strings
		} else {// means current elements doesnt match

			return Math.max(lcs(s1, s2, i - 1, j), lcs(s1, s2, i, j - 1));// since mismatched current elements so
																			// lcs(s1, s2, i - 1, j) means kya pta s1
																			// mei se current ele htade and s2 mei se na
																			// htae toh lcs mil jae ya lcs(s1, s2, i, j
																			// - 1) mtlb s2 mei se current ele htade aur
																			// s1 se na htae toh lcs mil jae , see notes
																			// its better to understand with example
		}

	}

}
