package miscellaneous;

import java.util.HashSet;

public class kLengthWords1 {

	public static void main(String[] args) {
		String str = "abcabc";
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
		Character[] spots = new Character[k];// these are boxes where we will put characters
		kLengthWord1(0, ustr, 0, k, spots);
	}

	public static void kLengthWord1(int cc, String ustr, int ssf, int ts, Character[] spots) {

		if (cc == ustr.length()) {// base case i.e. all unique charactersare considered

			if (ssf == ts) {// only print current branch answer if selection so far == total selection that
							// we needed to do i.e. 'k'
				for (int i = 0; i < spots.length; i++) {
					System.out.print(spots[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		char ch = ustr.charAt(cc);

		for (int i = 0; i < spots.length; i++) {
			if (spots[i] == null) {
				spots[i] = ch;
				kLengthWord1(cc + 1, ustr, ssf + 1, ts, spots);
				spots[i] = null;
			}
		}
		kLengthWord1(cc + 1, ustr, ssf + 0, ts, spots);// when current character is not selected
	}

}
