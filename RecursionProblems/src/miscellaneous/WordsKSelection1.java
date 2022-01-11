package miscellaneous;

import java.util.HashSet;

public class WordsKSelection1 {

	public static void main(String[] args) {
		String str = "aabbac";
		int k = 2;
		HashSet<Character> unique = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			unique.add(str.charAt(i));
		}
		String ustr = "";// ustr= unique string i.e. string that has only unique character from string
							// 'str'
		for (char ch : unique) {
			ustr += ch;
		}

		wordKSelection1(0, ustr, 0, k, "");// instead of passing hashset we have converted hashset into string 'sustr'
	}

	// Problem statement

	// given a string(which can have duplicates) , we have to print all the ways in
	// which we can select k distinct/unique characters from it
	// here k<= unique characters in string

	// Solution

	// basically we have to select 'k' items from total 'n' items and here n =
	// unique elements present in given
	// string and , 'k' is given in question
	// Here its same as boxes on level and we decide whether to include item or not
	// so K act as number of items and unique characters in given string act as
	// boxes like if suppose str='aabbcc' so unique characters are a,b and c so now
	// 1st level pr 1st box ka decision now here instead of 1st box we put 'a' so it
	// means whether to add 'a' in answer or not now in next level we decide for 'b'
	// i.e. whether to include 'b' in 'asf' or not and so on , here duplicacy is
	// handled by
	// using
	// HashMap like suppose string was "aabbbcc" now unqiue characters are a,b,c so
	// question becomes print ways to arrange a,b,c in K gaps

	// here we sort of instead of 'i' use the unique characters one by one like if
	// previously we used 'a' then next 'i' will be 'b'

	public static void wordKSelection1(int i, String ustr, int ssf, int ts, String asf) {// ustr=unique string i.e.
																							// string that has only
																							// unique characters from
																							// given string , ts= total
																							// selection , ssf=
																							// selection so far i.e.
																							// number of items selected
																							// so far , i is simply the
																							// pointer used to traverse
																							// 'ustr'

		if (i == ustr.length()) {// i.e. base case i.e. we have considered all unique characters of given string
									// and no unique
									// character remains

			if (ssf == ts) {// only print if number of selected items is equal 'k'
				System.out.println(asf);
			}
			return;
		}

		char ch = ustr.charAt(i);// remember 'ustr' is string having only unique characters

		wordKSelection1(i + 1, ustr, ssf + 1, ts, asf + ch);// take item
		wordKSelection1(i + 1, ustr, ssf + 0, ts, asf + "");// leave item

	}
}
