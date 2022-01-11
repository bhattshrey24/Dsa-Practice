import java.util.*;

public class RearrangeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rearrangeCharacters("aaaabbbc "));
	}

	public static String rearrangeCharacters(String str) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {// simply adding all the characters with their frequency
			if (hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
			} else {
				hm.put(str.charAt(i), 1);
			}
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());// its max pq

		for (char key : hm.keySet()) {// converting hm to pq
			int freq = hm.get(key);
			Pair newPair = new Pair(key, freq);
			pq.add(newPair);
		}

		String solStr = "";
		Pair remPair = pq.remove();// this is so that we can start execution
		Pair blackListed = new Pair(remPair.ch, remPair.freq - 1);// we add pair in blacklist with 1 less frequency
																	// cause we used i in solution string
		// blacklist means we just used that character and therefore we need some other
		// character to put in sol string

		solStr += remPair.ch;// adding the character to solution string
		while (!pq.isEmpty()) {

			Pair rem = pq.remove();// remove the max freq pair

			if (blackListed.freq > 0) {// this blacklist has blacklist pair from previous iteration , since we removed
										// a pair (which is not the one we blacklisted) so its safe to put it back the
										// prevoious blacklisted pair back in pq
										// so that we can use it again in future , but we
										// only add it if its frequency is more than 0
				pq.add(blackListed);
			}
			solStr = solStr + rem.ch;// add the "ch" of removed character to answer

			blackListed = new Pair(rem.ch, rem.freq - 1);// now mark the removed pair as blacklisted since we added it
															// in answer and since we used 1 frequency of it therefore
															// we add it with 1 less frequency
		}

		if (solStr.length() != str.length()) {// this means we weren't able to rearrange such that no 2 same characters
												// are together in this case we have to return "-1"
			return "-1";
		}

		return solStr;
	}

	public static class Pair implements Comparable<Pair> {
		char ch;
		int freq = 0;

		Pair(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(RearrangeCharacters.Pair o) {
			// TODO Auto-generated method stub
			return this.freq - o.freq;
		}
	}

}
