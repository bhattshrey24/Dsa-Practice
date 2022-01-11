import java.util.HashMap;
import java.util.Map.Entry;

public class CountSubarrayWithEqualNoOf0And1 {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 0, 0, 1, 0, 1, 1 };
		System.out.println(countSubarrWithEqualZeroAndOne(num, num.length));

	}

	static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
		int prefixSum0 = 0;// stores presfix sum of occurance of 0 from 0 to jth position
		int prefixSum1 = 0;// stores presfix sum of occurance of 1 from 0 to jth position
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);// since initially both prefix sum 0 and 1 are 0 so 0-0=0
		int count = 0;
		// we can use same answer for "Count Subarray With Equal No Of 0,1 and 2" or
		// "Count Subarray With Equal No Of 0,1 ,2and 3" and so on

		// I Have Coded it seperately for Count Subarray With Equal No Of 0,1 and 2 ,
		// see question
		// "CountSubarrayWithEqualNoOf01and2" in eclipse
		for (int j = 0; j < arr.length; j++) {
			
			// here we need equal no of 0s and no of ones same in a group i.e sum(i,j)
			// so equation is bascially p0[j]-p0[i-1]=p1[j]-p1[i-1]=>
			// p0[j]-p1[j]=p0[i-1]-p1[i-1]

			if (arr[j] == 0) {
				prefixSum0 += 1;
			} else {
				prefixSum1 += 1;
			}
			int toFind = prefixSum0 - prefixSum1; // we need to find p0[i-1]-p1[i-1] i.e p0[j]-p1[j] that previously
													// occurred
			if (hm.containsKey(toFind)) {
				count += hm.get(toFind);
			}
			if (hm.containsKey(toFind)) {
				int val = hm.get(toFind);
				hm.put(toFind, val + 1);// we simply increase the occurance if its already present
			} else {
				hm.put(toFind, 1);// if its not added we add it so that it may be used to solve later equations
									// ,
									// i.e it might satisfy other equation

			}

		}
//		for (Entry<Integer, Integer> ele : hm.entrySet()) {
//			System.out.println(ele.getKey() + " " + ele.getValue());
//		}

		return count;
	}

}
