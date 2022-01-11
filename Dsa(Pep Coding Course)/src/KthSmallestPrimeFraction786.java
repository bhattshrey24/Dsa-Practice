import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction786 {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 5 };
		int ans[] = kthSmallestPrimeFraction(arr, 3);
		for (int i = 0; i < 2; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Collections.reverseOrder());// max Pq
		for (int i = 0; i < arr.length; i++) {// since its givent that array is sorted so and only proper fraction are
												// allowed in question therefore simply 2 loops will give us all the
												// possible combination of fraction
			for (int j = i + 1; j < arr.length; j++) {
				if (pq.size() < k) {
					Pair pair = new Pair(arr[i], arr[j]);
					pq.add(pair);
				} else {
					Pair pair = new Pair(arr[i], arr[j]);
					pq.add(pair);
					Pair dum = pq.remove();
				}
			}
		}

		
		Pair ansPair = pq.remove();
		
		int ans[] = new int[2];
		ans[0] = ansPair.num;
		ans[1] = ansPair.den;
		return ans;
	}

	public static class Pair implements Comparable<Pair> {

		int num;
		int den;

		public Pair(int num, int den) {
			this.num = num;
			this.den = den;
		}

		@Override
		public int compareTo(Pair o) {
			return this.num * o.den - o.num * this.den;// since compare to can't take double value so what we did is we
														// just crossed multiplied so that we can neglect denominator
		}
	}
}

//for (Pair ele : pq) {
//
//	System.out.println(ele.num + "/" + ele.den);
//}
//System.out.println(arr[i] + "/" + arr[j]);
//double va = (double) arr[i] / arr[j];
//System.out.println("val " + va);
