package Strings_And_ArrayLists;

import java.util.ArrayList;

public class getSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = getSubseq("ABC");
		System.out.println(arr);
		printSS("abc", "");
	}

	public static ArrayList<String> getSubseq(String str) {// returns arrayList having all subsequences
		if (str == "") {// base case
			ArrayList<String> baseAns = new ArrayList<>();
			baseAns.add("");// adding empty string to arrayList , its size is not 0 now its 1 , i.e it has
							// empty string at index 0
			return baseAns;
		}

		char ch = str.charAt(0);// getting the 1st character

		String ros = str.substring(1);// ros = remaining of string

		ArrayList<String> recAns = getSubseq(ros);// have faith that recursion will give us the subsequences of "ros"
													// stored in arrayList i.e. [""]

		ArrayList<String> totAns = new ArrayList<>();

		for (int i = 0; i < recAns.size(); i++) {
			String st = recAns.get(i);

			totAns.add("" + st);// adding empty string in front of st
			totAns.add(ch + st);// adding ch in front of st
		}
		return totAns;
	}

	static void printSS(String str, String ans) {// here we are not storing subsequences , we are printing them as soon
													// as they are generated

		if (str == "") {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);

		printSS(ros, ans + "");// adding nothing in answer of "ros", have faith that recursion
								// will print subsequences of this
		printSS(ros, ans + ch);// adding "ch" in answer of "ros" ,have faith that recursion will
								// print subsequences of this
	}
}
