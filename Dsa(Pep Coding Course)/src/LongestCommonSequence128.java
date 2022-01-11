import java.util.HashMap;

public class LongestCommonSequence128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(arr));
	}

	public static int longestConsecutive(int[] nums) {
		int max = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int sP = 0;// pointer for startPoint of sequence
		int eP = 0;// pointer for endPoint of sequence
		int lengthOfGroup = 0;// length of sequence
		for (int i = 0; i < nums.length; i++) {

			if (hm.containsKey(nums[i])) {// this is to handle duplicacy that is if im already present means i have
											// already been solved then why to do it again
				continue;
			}
			if (!hm.containsKey(nums[i] - 1) && !hm.containsKey(nums[i] + 1)) {// 0 0 case when both num-1 and num+1 are
																				// not present
				hm.put(nums[i], 1);// simply add current number with length of group 1 , which is the number itself

				max = Math.max(max, 1);// this is to handle the case if the nums array is = [0,0]

			}
			if (hm.containsKey(nums[i] - 1) && !hm.containsKey(nums[i] + 1)) {// 0 1 case
				eP = nums[i];// since num-1 is present means current element is the end point of the sequence
				sP = nums[i] - hm.get(nums[i] - 1);// we simply jump from current element i.e endpoint to startpoint of
													// the group
													// using "length of group" of num-1 element since numbers in a group
													// are
													// consecutive , suppost num=5 and num-1 =4 is present and its
													// length of group is 5 means we have found already 0,1,2,3,4 so we
													// can jump to 0 simply by by subtracting endpoint with size of
													// num-1 element , its very logical just try out for 1,2 example if
													// you face confusion

				lengthOfGroup = eP - sP + 1;
				max = Math.max(lengthOfGroup, max);
				hm.put(sP, lengthOfGroup);// we only care about ep and sp therefore we only change them
				hm.put(eP, lengthOfGroup);

			}
			if (!hm.containsKey(nums[i] - 1) && hm.containsKey(nums[i] + 1)) { // 1 0 case
				sP = nums[i];// now since num+1 is present this means current num is startpoint of sequence
				eP = nums[i] + hm.get(nums[i] + 1); // simply jump ahead to the size of num+1 element
				lengthOfGroup = eP - sP + 1;
				max = Math.max(lengthOfGroup, max);

				hm.put(sP, lengthOfGroup);
				hm.put(eP, lengthOfGroup);
			}
			if (hm.containsKey(nums[i] - 1) && hm.containsKey(nums[i] + 1)) {// 1 1 case
				sP = nums[i] - hm.get(nums[i] - 1);// here since both num+1 and num-1 are present means current num is
													// inside sequence so we will find both startpoint and endpoint by
													// jumping
				eP = nums[i] + hm.get(nums[i] + 1);
				lengthOfGroup = eP - sP + 1;
				max = Math.max(lengthOfGroup, max);

				hm.put(sP, lengthOfGroup);
				hm.put(eP, lengthOfGroup);

				hm.put(nums[i], 1);// to handle duplicacy , sinze in this case current num is neither sp not ep so
									// we wont add it to hm but this will create problem of duplicacy cause then the
									// first check i.e. hm.containsKey(nums[i]) wont work since we never added
									// nums[i] , therefore to handle this we simply add it
			}
		}

		return max;
	}

}
