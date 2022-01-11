import java.util.*;

public class SmallestSubarrayWithAllOccurrencesOfMostFrequentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[] { 11, 7, 6, 3, 13 };
		System.out.println(smallestSubsegment(arr, arr.length));
	}

	static ArrayList<Integer> smallestSubsegment(int a[], int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Pair> hm = new HashMap<>();
		int maxFreq = 0;

		for (int i = 0; i < a.length; i++) {
			if (hm.containsKey(a[i])) {

				Pair pair = hm.get(a[i]);
				pair.freq += 1;
				pair.end = i;// simply change end , start remains the same cause since we already found a[i]
								// before and this is its next occurance so simply change end and start remains
								// the same
				maxFreq = Math.max(maxFreq, pair.freq);// change max frequency if current elements frequency is bigger
														// that maxFreq till now
				hm.put(a[i], pair);
			} else {
				Pair pair = new Pair(i, i, 1);// we marking "end" same as "start" since its the 1st frequency of a[i]
				hm.put(a[i], pair);
				maxFreq = Math.max(maxFreq, pair.freq);// again compare max cause its possible that maxFreq is just 1
														// i.e. all elements are different in array
			}
		}

		int minLengSubArray = Integer.MAX_VALUE;// we can initialize it with a.length also

		Pair ansPair = new Pair(a.length, a.length, a.length);// this is our answer pair initialize it with a.length

		for (int key : hm.keySet()) {
			Pair pair = hm.get(key);
			if (pair.freq == maxFreq && pair.end - pair.start <= minLengSubArray) {// equal too also cause if suppose
																					// there are 2 max frequency i.e. eg
																					// a={1,2,3,3,5,5} then answer
																					// should be the 1st one i.e. 3,3
																					// and not 5,5
				if (pair.end - pair.start == minLengSubArray && pair.start < ansPair.start) {// since pair.end -
																								// pair.start ==
																								// minLengSubArray
																								// therefore we only
																								// execute current pair
																								// if its "start" is
																								// strictly
																								// before ansPair's
																								// start
					ansPair = pair;
				} else if (pair.end - pair.start < minLengSubArray) {
					ansPair = pair;
					minLengSubArray = pair.end - pair.start;// updating min length
				}

			}
		}
		for (int i = ansPair.start; i <= ansPair.end; i++) {
			ans.add(a[i]);// putting answer in the arrayList
		}
		return ans;
	}

	public static class Pair {
		int start;
		int end;
		int freq;

		Pair(int start, int end, int freq) {
			this.start = start;
			this.end = end;
			this.freq = freq;
		}
	}

}
