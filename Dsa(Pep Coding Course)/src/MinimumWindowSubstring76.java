import java.util.HashMap;

public class MinimumWindowSubstring76 {

	public static void main(String[] args) {

		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		

	}

	public static String minWindow(String s, String t) {
		String ans = "";
		HashMap<Character, Integer> hmForT = new HashMap<>();
		HashMap<Character, Integer> hmForS = new HashMap<>();
       // THE GENERAL FLOW IN ACQUIRE AND RELEASE IS THAT WE FIRST ACQUIRE OR RELEASE AND THEN MOVE THE POINTR AHEAD

		for (int i = 0; i < t.length(); i++) {// simply add all the characters of t in hashmap with their frequency so
												// that we can search and match them with characters of "s" in on
			if (hmForT.containsKey(t.charAt(i))) {
				hmForT.put(t.charAt(i), hmForT.get(t.charAt(i)) + 1);
			} else {
				hmForT.put(t.charAt(i), 1);
			}
		}

		if (s.length() < t.length()) {// in this case solution is not possible hence return empty string
			return "";
		}

		int end = 0;// end of substring
		int matchedLength = 0;// keeps track of number of character we matched with that of t in current
								// substring of s
		int start = 0;// start pointer , pointing start of substring
		int minLength = Integer.MAX_VALUE;

		Pair minPair = new Pair(0, 0, 0);// we use pair cause we not only want length but also start and end index of
											// min substring

		boolean found = false;// this tells us wether we were able to find a solution or not if not then we
								// return empty string

		while (end < s.length()) {// we keep processing till "end" reached end of string "s"

			if (matchedLength != t.length()) {// ACQUIRING
				// we only acquire when matchedLength != t.length() , because first we make
				// matchedLength == t.length() then reduce the length of current substring by
				// moving start

				if (hmForT.containsKey(s.charAt(end))) {// we only add those which are already in T i.e the required
														// characters , why to add those which will be of no use

					if (hmForS.containsKey(s.charAt(end))) {
						hmForS.put(s.charAt(end), hmForS.get(s.charAt(end)) + 1);
					} else {
						hmForS.put(s.charAt(end), 1);
					}

					if (hmForS.get(s.charAt(end)) <= hmForT.get(s.charAt(end))) {// this means what we acquired wa
																					// useful hence increase
																					// matchedLength , if its
																					// hmForS.get(s.charAt(end)) >
																					// hmForT.get(s.charAt(end)) means
																					// we added extra character hence we
																					// dont increase matched length in
																					// this case
						matchedLength++;
					}
				}
				if (matchedLength == t.length()) {// if after acquiring we get a substring which can be our answer so
													// simply check if its length is smaller than current min then
													// update answer

					Pair pair = new Pair(start, end, end - start + 1);

					if (minLength > pair.length) {
						found = true;// means we found the answer , but we wont stop cause we not only want answer
										// but the smallest answer
						minLength = pair.length;
						minPair = pair;

					}

				}

				if (matchedLength != t.length()) {// we only increase "end" if we havent found all characters of t cause
													// if we have foun then "end" is actualy showing the end of answer
													// substring which will be useful while releasing character , if
													// matchedLength == t.length() then now in next iteration we will go
													// in the "if" where we will be releasing character ,and end stays
													// at correct position cause we havent moved it
					end++;
				}

			} else {

				while (matchedLength == t.length() && start <= end) {// RELEASE
					if (hmForS.containsKey(s.charAt(start))) {// we are checking in s and not in t cause its the same
																// thing since we only added those characters in hmForS
																// which were in t string
						if (hmForS.get(s.charAt(start)) == 1) {
							hmForS.remove(s.charAt(start));
							matchedLength--;// this is important cause we wont be able to do it below since we removed
											// the character from s , and we can directly decrease matchLength because
											// the current character was in S and we only add those characters in hm of
											// s which are in t string and frequency of the character was also 1 means
											// if we remove it we loose something important
						} else {
							hmForS.put(s.charAt(start), hmForS.get(s.charAt(start)) - 1);
						}
					}

					if (hmForS.containsKey(s.charAt(start)) && hmForT.containsKey(s.charAt(start))) {
						if (hmForS.get(s.charAt(start)) < hmForT.get(s.charAt(start))) {// means we lost something
																						// useful
							matchedLength--;
						}
					}
					start++;// now move start since we are done with releasing

					if (matchedLength == t.length()) {// now if still matchedLength == t.length() means we removed a
														// useless character hence update the answer
						Pair pair = new Pair(start, end, end - start + 1);
						if (minLength > pair.length) {
							found = true;
							minLength = pair.length;
							minPair = pair;

						}

					} else {
						end++;// if we dont do this then next time when we start acquring it will start from
								// previous element which we already acquired hence will create problem
					}
				}
			}
		}

		if (!found) {
			return "";
		}
		return s.substring(minPair.st, minPair.ed + 1);
	}

	public static class Pair {
		int st;
		int ed;
		int length;

		Pair(int st, int ed, int length) {
			this.st = st;
			this.ed = ed;
			this.length = length;
		}
	}
}
