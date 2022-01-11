import java.util.HashMap;
import java.util.Map.Entry;

public class CountAllSubArraysHavingSumDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] arr = new long[] { 4, 5, 0, -2, -3, 1 };
		System.out.println(subCount(arr, arr.length, 5));
	}

	static long subCount(long arr[], int n, int k) {
		long prefixSum = 0;
		HashMap<Long, Integer> hm = new HashMap<>();
		hm.put((long) 0, 1);// prefix is key i.e. 0 and occurance is value i.e. 1
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			// sum(i,j)=k=p[j]-p[i-1] ,sum(i,j) means sum from i to j
			// here we need rem1=rem2 i.e find i such that pSum[i-1]%k==pSum[j]%k
			prefixSum += arr[j];// this is actually pSum[j]

			long prefSumMod = prefixSum % k;

			if (prefSumMod < 0) {// this is to handle -ve mod , which is not possible in maths but happens in
									// computer due to java
				prefSumMod = prefSumMod + k;
			}
			if (hm.containsKey(prefSumMod)) {
				count += hm.get(prefSumMod);// in hashmap we basically add the prefSumMod and number of times they occur
											// now
											// if it appears x times means there are x contiguous subarray that
											// satisfies the equation
				int val = hm.get(prefSumMod);
				hm.put(prefSumMod, val + 1);
			} else {
				hm.put(prefSumMod, 1);// if its not added we add it so that it may be used to solve later equations ,
										// i.e it might satisfy other equation

			}

		}

		for (Entry<Long, Integer> ele : hm.entrySet()) {
			System.out.println(ele.getKey() + " " + ele.getValue());
		}

		return count;

	}
}
