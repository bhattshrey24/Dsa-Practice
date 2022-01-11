import java.util.HashMap;

public class CheckIfTwoStringsAreKAnagramsOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(areKAnagrams("uovwhqfaemqodyksjj", "swwhzsiowocjfyadvj", 18));
	}

	static boolean areKAnagrams(String s1, String s2, int k) {
		boolean isPossible = false;
		if (s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character, Integer> hmofS1 = new HashMap<>();// character is key ans its frequency is value in hm
		HashMap<Character, Integer> hmofS2 = new HashMap<>();// character is key ans its frequency is value in hm

		for (int i = 0; i < s1.length(); i++) {// simply fill hmofs1 and hmofs2
			if (hmofS1.containsKey(s1.charAt(i))) {

				hmofS1.put(s1.charAt(i), hmofS1.get(s1.charAt(i)) + 1);
			} else {

				hmofS1.put(s1.charAt(i), 1);
			}

			if (hmofS2.containsKey(s2.charAt(i))) {
				hmofS2.put(s2.charAt(i), hmofS2.get(s2.charAt(i)) + 1);

			} else {
				hmofS2.put(s2.charAt(i), 1);

			}

		}

		int s1FreqLeftover = 0;// this keeps track of the leftover characters in s1 after mapping
		int s2FreqLeftover = 0;// this keeps track of the leftover characters in s2 after mapping

		for (char key : hmofS1.keySet()) {// we are trying to map character of hmofs1 which are also in hmofs2 ,actually
											// we are not actually mapping we are just thinking that they mapped and
											// simply calculating leftover characters after mapping

			if (hmofS2.containsKey(key)) {

				if (hmofS2.get(key) > hmofS1.get(key)) {
					int freq1 = hmofS1.get(key);
					int freq2 = hmofS2.get(key);
					s2FreqLeftover += freq2 - freq1;// since hmofS2.get(key) > hmofS1.get(key) means after mapping some
													// frequency of current characters will be left in hmofs2 so simply
													// update s2FreqLeftover
				} else if (hmofS2.get(key) < hmofS1.get(key)) {
					int freq1 = hmofS2.get(key);
					int freq2 = hmofS1.get(key);
					s1FreqLeftover += freq2 - freq1;// since hmofS2.get(key) < hmofS1.get(key) means after mapping some
					// frequency of current characters will be left in hmofs1 so simply
					// update s1FreqLeftover
				} // we dont do anything if frequency is same since its of no use ,assume that
					// they are mapped

			} else {// if key is not in s2 then it simply means that all its frequency will be left
					// over therefore update s1FreqLeftover
				s1FreqLeftover += hmofS1.get(key);
			}
		}

		for (char key : hmofS2.keySet()) {
			if (!hmofS1.containsKey(key)) {
				s2FreqLeftover += hmofS2.get(key);
			}
		}
		if (s1FreqLeftover != s2FreqLeftover) {
			isPossible = false;
		} else if (s1FreqLeftover <= k) {
			isPossible = true;
		}
		return isPossible;
	}
}
