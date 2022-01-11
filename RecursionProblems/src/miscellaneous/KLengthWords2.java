package miscellaneous;

import java.util.HashSet;

public class KLengthWords2 {

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
		kLengthWords2(1, k, ustr, new HashSet<>(), "");
	}

	public static void kLengthWords2(int cs, int ts, String ustr, HashSet<Character> used, String asf) {// 'used'
																										// contains the
																										// characters
																										// that we
																										// already used
																										// , cs= current
																										// selection
		if (cs > ts) {// base case
			System.out.println(asf);
			return;
		}
		for (int i = 0; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			if (used.contains(ch) == false) {// we only use the character if it's not used before
				used.add(ch);
				kLengthWords2(cs + 1, ts, ustr, used, asf + ch);
				used.remove(ch);
			}
		}

	}
}
