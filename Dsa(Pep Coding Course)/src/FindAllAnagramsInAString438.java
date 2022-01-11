import java.util.*;

public class FindAllAnagramsInAString438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findAnagrams("baa", "aa"));
	}

	public static List<Integer> findAnagrams(String s, String p) {
	// THIS QUESTION USES ACQUIRE AND RELEASE CONCEPT IN SLIDING WINDOW
		
		List<Integer> ans = new ArrayList<>();
		int matchCharactersLen = 0;

		HashSet<Character> hs = new HashSet<>();
		HashMap<Character, Integer> hmForP = new HashMap<>();
		HashMap<Character, Integer> hmForS = new HashMap<>();

		for (int i = 0; i < p.length(); i++) {// adding elements of P so that we can match them while traversing in S
			if (hmForP.containsKey(p.charAt(i))) {
				hmForP.put(p.charAt(i), hmForP.get(p.charAt(i)) + 1);
			} else {
				hmForP.put(p.charAt(i), 1);
			}
		}

		int start = 0;// keeps track of start of the window

		for (int end = 0; end < s.length(); end++) {

			if (end < p.length()) {// since rightnow we havent crossed length of p number of character so we only
									// acquire right now

				if (hmForP.containsKey(s.charAt(end))) {// we only do something if current character is in P

					if (hmForS.containsKey(s.charAt(end))) {// simply increase frequency in hashMap Of S , this shows
															// how many times s.charAt(i) occured in current window

						hmForS.put(s.charAt(end), hmForS.get(s.charAt(end)) + 1);
					} else {
						hmForS.put(s.charAt(end), 1);
					}

					if (hmForS.get(s.charAt(end)) <= hmForP.get(s.charAt(end))) {
						matchCharactersLen++;// we only increase matchCharacter if above condition is met , the above
												// condition means that what we added was of some use , now
												// ifhmForS.get(s.charAt(end))> hmForP.get(s.charAt(end)) means we added
												// an extra s.charAt(end) therefore dont do matched++; and this extra
												// will be taken care when we releease character
					}
					if (matchCharactersLen == p.length()) {// now this means we found an anagram
						ans.add(end - p.length() + 1);// simply adding start index of anagram
					}
				}

			} else {
				if (hmForP.containsKey(s.charAt(end))) {// again we only in hmForS if s.charAt(i) is also present in
														// hmForP

					// ACQUIRING

					if (hmForS.containsKey(s.charAt(end))) {
						hmForS.put(s.charAt(end), hmForS.get(s.charAt(end)) + 1);
					} else {
						hmForS.put(s.charAt(end), 1);
					}

					if (hmForS.get(s.charAt(end)) <= hmForP.get(s.charAt(end))) {// same condition as above mentioned
						matchCharactersLen++;
					}
				}

				// RELEASE
				char releasedEle = s.charAt(start);// that is the character we want to release
				if (hmForS.containsKey(releasedEle)) {

					if (hmForS.get(releasedEle) == 1) {
						hmForS.remove(releasedEle);
						matchCharactersLen--;// we do this here cause it wont happen in below if having
												// hmForS.containsKey(releasedEle) cause we already removed releasedEle
												// from map but we are to reduce matchcount , therefor we do it here only

						// and we directly reduced matchedCharacterLen without checking
						// hmForS.get(releasedEle) < hmForP.get(releasedEle) because since we only add
						// those character in hmForS which are in hmForP therefore removing any element
						// from map of hmForS means we lost a useful character
					} else {

						hmForS.put(releasedEle, hmForS.get(releasedEle) - 1);
					}
				}

				if (hmForP.containsKey(releasedEle) && hmForS.containsKey(releasedEle)) {
					if (hmForS.get(releasedEle) < hmForP.get(releasedEle)) {
						matchCharactersLen--;
					}
				}

				start++;// start moves irrespective of we found useful acquire element or release
						// element cause
						// size of window remains same

				if (matchCharactersLen == p.length()) {
					ans.add(end - p.length() + 1);
				}
			}
		}
		return ans;
	}

}
