import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrayOfDoublePair954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 1, -8, 8, -4, 4, -4, 2, -2 };
		System.out.println(canReorderDoubled(arr));
	}

	public static boolean canReorderDoubled(int[] arr) {
		List<Integer> list = new ArrayList<>();

		if (arr.length % 2 != 0) {// if length is odd means we cant make pairs of 2
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		Collections.sort(list);

		HashMap<Integer, Integer> hm = new HashMap<>();// cant use hashset cause array can have duplicates

		for (int ele : list) {// simply making hm so that we can search wnd element of pair in 0(1)
			if (hm.containsKey(ele)) {
				int preFrequency = hm.get(ele);
				hm.put(ele, preFrequency + 1);
			} else {
				hm.put(ele, 1);
			}
		}

		boolean canReorder = true;// assuming we can reorder given array

		for (int ele : list) {
			if (!hm.containsKey(ele)) {// not present in hashmap means it got paired up so simply continue
				continue;
			}

			if (ele < 0) {// if element is negative , in this case twice doesnt mean magnitude wise twice
							// but value wise twice , twice of -8 magnitude wise is -16 but value wise its
							// -4 , and in question we want to find value wise

				if (ele % 2 != 0) {// if odd then dividing by 2 will give fraction (given array only has integers)
					canReorder = false;
					break;
				}
				if (!hm.containsKey(ele / 2)) {// if twice value wise is not present means we cant pair current element
					canReorder = false;
					break;
				} else {// this means twice of ele is present
					int CurrfreqOfele = hm.get(ele);
					int CurrfreqOfeleBy2 = hm.get(ele / 2);
					if (CurrfreqOfele == 1 || CurrfreqOfeleBy2 == 1) {// we did all this if checks and all cause
																		// duplicate are allowed and we cant just remove
																		// element from hm if its frequency is bigger
																		// than 1
						if (CurrfreqOfele == 1) {
							hm.remove(ele);// we could have decreased frequency and then find out if its 0 so delete but
											// why do all this just check if its 1 if yes so dont reduce it and remove simply
											// remove it
						} else {
							hm.put(ele, CurrfreqOfele - 1);
						}
						if (CurrfreqOfeleBy2 == 1) {
							hm.remove(ele / 2);
						} else {
							hm.put(ele / 2, CurrfreqOfeleBy2 - 1);
						}
					} else {
						hm.put(ele, CurrfreqOfele - 1);// if frequency is not 1 then we wont remove instead we reduce it by 1
						hm.put(ele / 2, CurrfreqOfeleBy2 - 1);
					}
				}
			} else {
				if (!hm.containsKey(ele * 2)) {
					canReorder = false;
					break;
				} else {
					int CurrfreqOfele = hm.get(ele);
					int CurrfreqOfeleInto2 = hm.get(ele * 2);
					if (CurrfreqOfele == 1 || CurrfreqOfeleInto2 == 1) {
						if (CurrfreqOfele == 1) {
							hm.remove(ele);
						} else {
							hm.put(ele, CurrfreqOfele - 1);

						}
						if (CurrfreqOfeleInto2 == 1) {
							hm.remove(ele * 2);
						} else {
							hm.put(ele * 2, CurrfreqOfeleInto2 - 1);

						}

					} else {
						hm.put(ele, CurrfreqOfele - 1);
						hm.put(ele * 2, CurrfreqOfeleInto2 - 1);
					}

				}
			}
		}

		if (!canReorder) {
			return false;
		} else {
			return true;
		}

	}

}
