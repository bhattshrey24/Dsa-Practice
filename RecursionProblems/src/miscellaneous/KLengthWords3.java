package miscellaneous;

import java.util.HashMap;

public class KLengthWords3 {

	public static void main(String[] args) {
		String str = "aabba";
		int k = 3;
		HashMap<Character, Integer> lo = new HashMap<>();// lo= last occurance
		for (int i = 0; i < str.length(); i++) {
			lo.put(str.charAt(i), -1);// initiallizing every character with -1
		}
		kLengthWord3(str, lo, 0, new Character[k], 0, k);
	}

	public static void kLengthWord3(String str, HashMap<Character, Integer> map, int idx, Character[] spots, int ssf,
			int ts) {

		if (idx == str.length()) {// base case
			if (ssf == ts) {
				for (int i = 0; i < spots.length; i++) {
					System.out.print(spots[i]);
				}
				System.out.println();
			}
			return;
		}

		char ch = str.charAt(idx);// observe here we are not using ustr but the original str

		int lo = map.get(ch);// last occurance of current character

		for (int i = lo + 1; i < spots.length; i++) {// observe 'lo' ke baad se hi loop chlra hai so condition one is
														// satisfied
			if (spots[i] == null) {// mean spot was empty
				spots[i] = ch;
				map.put(ch, i);

				kLengthWord3(str, map, idx + 1, spots, ssf + 1, ts);

				spots[i] = null;// backtracking
				map.put(ch, lo);
			}
		}

		if (lo == -1) {// this is to fullfill condition 2 , i.e. not including anything wala option is
						// only provided if previously also we didnt picked it either

			kLengthWord3(str, map, idx + 1, spots, ssf, ts);// dont add anything to answer just increase the pointer
															// i.e. idx
		}
	}
}
