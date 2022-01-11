import java.util.*;

public class LengthOfTheLongestSubstring {

	public static void main(String[] args) {
		System.out.println(longestUniqueSubsttr("abdefgabef"));
	}

	static int longestUniqueSubsttr(String S) {
		HashMap<Character, Integer> hm = new HashMap<>();
		hm.put(S.charAt(0), 0);// adding the first character directly cause 1st character is always unique
								// because we havent processed any other element
		int start = 0;
		int maxLength = 1;// since 1st character is always unique because we havent processed any other
							// element

		for (int i = 1; i < S.length(); i++) {

			if (!hm.containsKey(S.charAt(i))) {// ACQUIRE
				// since hm do not contain current character means its not occured before so
				// simply add it

				hm.put(S.charAt(i), i);// putting index with character so that while releasing we know konse index tk
										// release krna hai
				maxLength = Math.max(maxLength, hm.size());// hm size is simply length of non duplicate characters in
															// current sub string

			} else {// RELEASE
				int idx = hm.get(S.charAt(i));// get the index till which we will release the elements
				// we do so cause since current element has already occured so we have to delete
				// all the elements till the last occurance of current element and then start
				// acquiring again

				while (start <= idx) {
					hm.remove(S.charAt(start));// keep removing till you reach duplicate character , and remove
												// duplicate character too
					start++;
				}

				hm.put(S.charAt(i), i);// since we removed last occurance of S.charAt(i) , so now we add the
										// current S.charAt(i) in hm because there is no duplicate left 
			}
		}
		return maxLength;
	}
}
