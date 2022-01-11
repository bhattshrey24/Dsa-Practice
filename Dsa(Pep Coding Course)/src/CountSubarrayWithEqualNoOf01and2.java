import java.util.HashMap;
import java.util.Map.Entry;

public class CountSubarrayWithEqualNoOf01and2 {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 0, 2, 0, 1, 2, 0, 0 };
		// and answer is 5 =>(1, 0, 2) (2, 0, 1) (0, 1, 2) (1, 2, 0) (1, 0, 2, 0, 1, 2)
		// and answer is 5 indexes wise =>(0,2) (2, 4) (3,5) (4,6) (0,5)
		System.out.println(countSubarrWithEqualZeroOneAndTwo(num, num.length));
	}

	static int countSubarrWithEqualZeroOneAndTwo(int arr[], int n) {
		int prefixSum0 = 0;// stores presfix sum of occurance of 0 from 0 to jth position
		int prefixSum1 = 0;// stores presfix sum of occurance of 1 from 0 to jth position
		int prefixSum2 = 0;// stores presfix sum of occurance of 2 from 0 to jth position
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("0#0", 1);// since initially both prefix sum 0 , 1 and 2 are 0 so therefore 0#0
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			// here we need equal no of 0s,no of 1s and 2 same in a group i.e sum(i,j)
			// so equation is bascially p0[j]-p0[i-1]=p1[j]-p1[i-1]=p2[j]-p2[i-1] which is
			// bascially p0[j]-p1[j]=p0[i-1]-p1[i-1]&&p0[j]-p2[j]=p0[i-1]-p2[i-1] cause if
			// a=b=c then it means a=b and a=c
			// since here we have 2 values to find so we can create a hashcode , we can also
			// create a custom class having 2 integer variables as properties and store it
			// in hashmap but then we have to configure "equals" function in Hashmap so that
			// it
			// can work with our class , this is lot of work

			if (arr[j] == 0) {
				prefixSum0 += 1;
			} else if (arr[j] == 1) {
				prefixSum1 += 1;
			} else {
				prefixSum2 += 1;
			}

			int a = prefixSum0 - prefixSum1;// p0[j]-p1[j]
			int b = prefixSum0 - prefixSum2;// p0[j]-p2[j]
			String hashCodetoFind = a + "#" + b;
			if (hm.containsKey(hashCodetoFind)) {
				count += hm.get(hashCodetoFind);
			}
			if (hm.containsKey(hashCodetoFind)) {
				int val = hm.get(hashCodetoFind);
				hm.put(hashCodetoFind, val + 1);// we simply increase the occurance if its already present
			} else {
				hm.put(hashCodetoFind, 1);// if its not added we add it so that it may be used to solve later equations
				// ,
				// i.e it might satisfy other equation

			}

		}

		for (Entry<String, Integer> ele : hm.entrySet()) {
			System.out.println(ele.getKey() + " " + ele.getValue());
		}

		return count;
	}

}
