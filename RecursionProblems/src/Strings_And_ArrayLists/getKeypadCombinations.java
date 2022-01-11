package Strings_And_ArrayLists;

import java.util.ArrayList;

public class getKeypadCombinations {// ITS "Combination"

	public static void main(String[] args) {
		System.out.println("solution of getKC");
		System.out.println();
		System.out.println(getKC("179"));
		System.out.println();
		System.out.println("solution of PrintKC");
		System.out.println();
		printKC("179", "");
		// int num=Character.getNumericValue(ch);;
		// System.out.println(num);
	}

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };// global array for
																									// codes , its given
																									// in question

	public static ArrayList<String> getKC(String str) {// very similar to get subsequence question
		if (str == "") {// base case, if no key is pressed then empty string will be generated
			ArrayList<String> recAns = new ArrayList<>();
			recAns.add("");// empty string acts like "identity" for strings so if any string adds with ""
							// the
							// generated result is string itself eg "shr"+""="shr"
			return recAns;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);// ros means "rest of the string"
		ArrayList<String> recRes = getKC(ros);// have faith that recursion will give you all combinations of ros

		int num = Character.getNumericValue(ch);// converts character to number , either use this or subtract ascii
												// value of dig 0 i.e ch-'0', choice is yours

		String code = codes[num];

		ArrayList<String> myAns = new ArrayList<>();

		for (int i = 0; i < code.length(); i++) {// simply adding each char of string "code" to answer given by
													// recursion
													// to generate final answer
			char currChar = code.charAt(i);

			for (String rec : recRes) {
				String res = currChar + rec;
				myAns.add(res);
			}
		}
		return myAns;
	}

	public static void printKC(String str, String ans) {
		if (str.equals("")) {// base case, i.e. when str is "" means for current branch of recursion tree the
								// answer is stored
								// in "ans"
			System.out.print(ans + ", ");
			return;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		int num = Character.getNumericValue(ch);
		String code = codes[num];

		for (int i = 0; i < code.length(); i++) {
			char currChar = code.charAt(i);
			printKC(ros, ans + currChar);// have faith that it prints all the subsequences of ros , also have faith that
											// ans is nothing but answer of ros i.e. all combinations of ros so we are
											// adding current character to the answer of ros
		}
	}

}
