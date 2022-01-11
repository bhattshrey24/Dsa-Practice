import java.util.HashMap;
import java.util.Map.Entry;

// its a code forces question
public class SameDifferenceCF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] { 3, 5, 1, 4, 6, 6 };
		System.out.println(subarraySum(num));
	}

	public static int subarraySum(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		for (int j = 0; j < nums.length; j++) {
			// aj-ai=j-i => aj-j=ai-i so at every step we need to find i that satisfies this
			// equation
			int toFind = nums[j] - j;// tofind is basically aj-j , we need to find wether aj-j occured before cause
										// equation is aj-j=ai-i , here ai-i is basicall aj-j for some previous j value
			if (hm.containsKey(toFind)) {
				count += hm.get(toFind);
			}
			if (hm.containsKey(toFind)) {
				int val = hm.get(toFind);
				hm.put(toFind, val + 1);// we simply increase the occurance if its already present
			} else {
				hm.put(toFind, 1);// if its not added we add it so that it may be used to solve later equations ,
									// i.e it might satisfy other equation

			}

		}

		for (Entry<Integer, Integer> ele : hm.entrySet()) {
			System.out.println(ele.getKey() + " " + ele.getValue());
		}

		return count;
	}

}
