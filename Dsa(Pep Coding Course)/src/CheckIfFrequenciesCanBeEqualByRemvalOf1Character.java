import java.util.HashMap;

public class CheckIfFrequenciesCanBeEqualByRemvalOf1Character {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sameFreq("xyyz"));
	}

	static boolean sameFreq(String s) {
		boolean isPossible = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {// simple add characters and their frequency
			if (hm.containsKey(s.charAt(i))) {
				int prevFreq = hm.get(s.charAt(i));
				hm.put(s.charAt(i), prevFreq + 1);
			} else {
				hm.put(s.charAt(i), 1);
			}

		}

		HashMap<Integer, Integer> hmOfFreq = new HashMap<Integer, Integer>();// this is hashmap of frequency of
																				// characters
		for (char key : hm.keySet()) {
			int freq = hm.get(key);
			if (hmOfFreq.containsKey(freq)) {
				hmOfFreq.put(freq, hmOfFreq.get(freq) + 1);
			} else {
				hmOfFreq.put(freq, 1);
			}
		}

		if (hmOfFreq.size() != 2) {// if
			return false;
		}

		for (int key : hmOfFreq.keySet()) {
			max = Math.max(max, key);// finding max and min frequency like 3-2 and 4-1 then this means 3 frequency
										// occured 2 times and 4 occured 1 time , but we compare key that is 3 and 4 so
										// max frequenncy is 4 and min is 3
			min = Math.min(min, key);
		}
		
		int maxFrequencyOfFrequency = Math.max(hmOfFreq.get(max), hmOfFreq.get(min));
		
		int minFrequencyOfFrequency = Math.min(hmOfFreq.get(max), hmOfFreq.get(min));

		if (hmOfFreq.get(max) != 1 || max - min != 1 || maxFrequencyOfFrequency - minFrequencyOfFrequency != 1) {
			isPossible = false;
		} else {
			isPossible = true;
		}
		return isPossible;
	}
}
