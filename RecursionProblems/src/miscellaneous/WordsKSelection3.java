package miscellaneous;

import java.util.HashMap;
import java.util.HashSet;

public class WordsKSelection3 {
	public static void main(String[] args) {
		String str = "aabbac";
		int k = 3;
		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) + 1);
			} else {
				hm.put(ch, 1);
			}
		}

		HashSet<Character> unique = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			unique.add(str.charAt(i));
		}
		String ustr = "";// ustr= unique string i.e. string that has only unique character from strings
							// // 'str'
		for (char ch : unique) {
			ustr += ch;
		}

		wordKSelect3(ustr, hm, 0, k, "");
	}
 
	
	
	
	
	public static void wordKSelect3(String ustr, HashMap<Character, Integer> fmap, int idx, int k, String asf) {// idx
																												// is
																												// used
																												// to
																												// traverse
																												// ustr

		if (k < 0) {// this is just to speed up by not doing unnecessary work i.e. if k<0 means we
					// have already
					// selected and printed jitne bhi krne the(i.e. equal to k ) in current branch
					// so why to carry on
					// further on in
					// current recursive
					// branch simply return
			return;
		}

		if (idx == ustr.length()) {// base case i.e. we traversed all characters so print the answer
			if (k == 0) {
				System.out.println(asf);
			}
			return;
		}

		char ch = ustr.charAt(idx);

		for (int i = fmap.get(ch); i >= 0; i--) {
			String s = "";

			for (int j = 0; j < i; j++) {// creating the option like if current char is 'a' and its frequency is 3 then
											// this will create 'aaa' and call recursion with it then same with 'aa'
											// then with 'a' and last with ""

				s += ch;
			}

			wordKSelect3(ustr, fmap, idx + 1, k - i, asf + s);// let recursion print answer for remianing branch
		}

	}

}
