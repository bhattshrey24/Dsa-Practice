import java.util.*;

public class FindAnagramMappings813LintCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> as = new ArrayList<Integer>();
		as.add(0);
		as.add(10);
		int ele = as.remove(1);
		System.out.println(ele);
		// System.out.println(as.get(0));
		int a[] = new int[] { 12, 28, 12, 32, 50 };
		int b[] = new int[] { 50, 12, 32, 12, 28 };
		int ans[] = anagramMappings(a, b);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] anagramMappings(int[] A, int[] B) {
		int ans[] = new int[A.length];
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();// we made hashmap of arraylist and not just
																	// integer,integer cause duplicates are allowed

// eg if a[]={ 12, 28, 12, 32, 50} and b[]{50, 12, 32, 12, 28}  so as you can see there are two 12 so answer can be {1,4,3,2,0} or {3,4,1,2,0} both are correct

		for (int i = 0; i < B.length; i++) {
			if (hm.containsKey(B[i])) {
				ArrayList<Integer> dummy = hm.get(B[i]);
				dummy.add(i);
				hm.put(B[i], dummy);
			} else {
				ArrayList<Integer> dummy = new ArrayList<>();
				dummy.add(i);
				hm.put(B[i], dummy);
			}

		}
		for (int i = 0; i < A.length; i++) {
			ArrayList<Integer> dummy = hm.get(A[i]);
			int index = dummy.remove(0);// we simply remove the 1st val in array list like eg B[i] is 4 and in map key
										// value of 4 is 4-{2,5,6} means we found 4 in 3 places i.e 2,5 and 6 so simply
										// remove the 1st one and assign it too current ans[i] , so now it becoms
										// 4-{5,6} because we used 2 of current ans[i]
			ans[i] = index;
			hm.put(A[i], dummy);
		}
		return ans;
	}

}
