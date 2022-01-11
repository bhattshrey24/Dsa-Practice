import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {

	public static void main(String[] args) {
	
		String[] arr = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
	 System.out.println(groupAnagrams(arr));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> ans = new ArrayList<>();

		HashMap<String, ArrayList<String>> hm = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			// Make hash code of current string
			int sum = 0;
			int prod = 1;
			for (int j = 0; j < strs[i].length(); j++) {
				int dig = strs[i].charAt(j); // this will fail if we use strs[i].charAt(j)-97; i.e now a becomes 0
												// instead of 97 , this will fail for case { old , her }
				sum += dig;// summing the asci value of each character
				prod *= dig;// finding product of asci value of each character
			}

			String HashCode = sum + "#" + prod + "#" + strs[i].length();// making a hashcode which will act as a "key"
																		// that will group anagrams together

			if (hm.containsKey(HashCode)) {// we use hashcode to group together anagrams if hashcode is same means they
											// are anagrams
				ArrayList<String> dum = hm.get(HashCode);
				dum.add(strs[i]);
				hm.put(HashCode, dum);
			} else {
				ArrayList<String> dum = new ArrayList<String>();
				dum.add(strs[i]);
				hm.put(HashCode, dum);
			}
		}

		for (String key : hm.keySet()) {// simply adding solution to ans list
			ans.add(hm.get(key));
		}
		return ans;
	}
}
