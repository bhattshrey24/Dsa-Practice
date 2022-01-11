import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		// int[][] sol = { { 1, 3 }, { -2, 2 } };
		int[][] sol = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int[][] solu = kClosest(sol, 2);
		for (int i = 0; i < solu.length; i++) {
			System.out.println(solu[i][0] + " " + solu[i][1]);
		}

	}

	public static int[][] kClosest(int[][] points, int k) {
		// ArrayList<ArrayList<Integer>> ele = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();// max heap cause we need to
															// find closest ones .i.e we
															// dont need farthest or max
															// distance ones , and we didnt used
															// Collections.reverseOrder() cause we managed it in Pairs
															// class

		for (int i = 0; i < points.length; i++) {
			int distanceFromOrigin = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);// (x1-0)^2 +
																									// (y1-0)^2 =>
																									// (x1)^2 + (y1)^2
			if (i < k) {
				pq.add(new Pair(distanceFromOrigin, i));
			} else {
				Pair topEle = pq.peek();
				if (topEle.val > distanceFromOrigin) {// since top element is always max element therefore we only
														// compare with it
					pq.remove();
					pq.add(new Pair(distanceFromOrigin, i));
				}
			}
		}
		int[][] sol = new int[pq.size()][2];
		int j = 0;
		for (Pair p : pq) {
			sol[j][0] = points[p.index][0];
			sol[j][1] = points[p.index][1];
			j++;
		}
		return sol;
	}

	public static class Pair implements Comparable<Pair> {
		int val, index;

		Pair(int val, int index) {
			this.val = val;
			this.index = index;
		}

		@Override
		public int compareTo(KClosestPointsToOrigin.Pair o) {
			return o.val - this.val; // we changed this that is putted o.val first in order to make max pq if we used
										// "this.val-o.val" then it would have been min Pq
			// using this hack we didnt have to use Collections.reverseOrder() to make max
			// pq and hence improved TC i guess
		}

	}

}
