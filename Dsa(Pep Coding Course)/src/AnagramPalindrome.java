import java.util.HashMap;

public class AnagramPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int isPossible(String S) {
		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < S.length(); i++) {
			if (hm.containsKey(S.charAt(i))) {
				hm.put(S.charAt(i), hm.get(S.charAt(i)) + 1);
			} else {
				hm.put(S.charAt(i), 1);

			}
		}
		int numOfOddFre = 0;
		for (char key : hm.keySet()) {

			if (hm.get(key) % 2 != 0) {// simply count no of characters with odd frequency
				numOfOddFre++;
			}
		}
		if (numOfOddFre <= 1) {// palindrome is only possible if no or exactly 1 element have odd frequency ex
								// abcdcba or abcdddcba here d has odd frequency , abceecba this is also
								// palindrome here every character has even frequency
			return 1;

		} else {
			return 0;

		}
	}

}
