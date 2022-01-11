import java.util.HashMap;
import java.util.HashSet;

public class IsomorficStrings205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new HashSet<>();
		System.out.println(isIsomorphic("paper", "title"));
	}

	public static boolean isIsomorphic(String s, String t) {
		boolean isIsomorphic = true;// we assume that given s and t are isomorphic

		if (s.length() != t.length()) { // if length is different then no need to check further cause length is not same
										// then we cant convert s to t with any mapping
			return false;
		}

		HashMap<Character, Character> lhm = new HashMap<>();// left hashmap mean , key is (s.charAt(i)) and value is
															// (t.charAt(i))
		HashMap<Character, Character> rhm = new HashMap<>();// right hashmap mean , key is (t.charAt(i)) and value is
															// (s.charAt(i))

		for (int i = 0; i < s.length(); i++) {

			if (lhm.containsKey(s.charAt(i))) {

				char mappedCharacter = lhm.get(s.charAt(i));// character to which s.charAt is mapped to , now we check
															// wehter same mapping is done on rhm or not if not return
															// false
				if (!rhm.containsKey(t.charAt(i)) || (rhm.get(t.charAt(i)) != s.charAt(i))) {
					isIsomorphic = false;
					break;
				}
			} else if (!lhm.containsKey(s.charAt(i)) && rhm.containsKey(t.charAt(i))) {// this is for the case when t.charAt(i) got
																						// mapped already but
																						// s.charAt(i) didnt , it means we
																						// mapped t.charAt(i) with some
																						// different character hence
																						// answer became false
				isIsomorphic = false;
				break;
			} else {
				lhm.put(s.charAt(i), t.charAt(i));
				rhm.put(t.charAt(i), s.charAt(i));
			}
		}

		return isIsomorphic;
	}

}
