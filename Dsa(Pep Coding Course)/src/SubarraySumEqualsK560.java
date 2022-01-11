import java.util.HashMap;
import java.util.Map.Entry;

public class SubarraySumEqualsK560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 1, 1, 1 };
		System.out.println(subarraySum(arr, 2));

	}

	public static int subarraySum(int[] nums, int k) {
		int prefixSum = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);// prefix is key i.e. 0 and occurance is value i.e. 1
		int count = 0;
		
		for (int j = 0; j < nums.length; j++) {
			// sum(i,j)=k=p[j]-p[i-1] ,sum(i,j) means sum from i to j
			// p[i-1]=p[j]-k
			prefixSum += nums[j];// this is actually pSum[j]

			int startBound = prefixSum - k;// startbound is basically required p[i-1] that we want to find
			// remember this equation is valid only if i<=j ,thats why we are finding 1
			// before j
			if (hm.containsKey(startBound)) {
				count += hm.get(startBound);// in hashmap we basically add the p[j]'s and number of times they occur now
											// if it appears x times means there are x contiguous subarray that
											// satisfies the equation
			}
			if (hm.containsKey(prefixSum)) {// this is wrong i guess , we have to put start bound and not prefix sum
				int val = hm.get(prefixSum);
				hm.put(prefixSum, val + 1);// we simply increase the occurance if its already present
			} else {
				hm.put(prefixSum, 1);// if its not added we add it so that it may be used to solve later equations ,
										// i.e it might satisfy other equation

			}

		}

		for (Entry<Integer, Integer> ele : hm.entrySet()) {
			System.out.println(ele.getKey() + " " + ele.getValue());
		}

		return count;
	}

}
