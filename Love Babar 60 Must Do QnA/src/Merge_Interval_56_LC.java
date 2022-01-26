import java.util.PriorityQueue;
import java.util.Stack;



public class Merge_Interval_56_LC {
	public static void main(String[] args) {
		Merge_Interval_56_LC ob = new Merge_Interval_56_LC();

		int dum[][] = ob.merge(new int[][] { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 15, 18 } });
		for (int i = 0; i < dum.length; i++) {
			System.out.println(dum[i][0] + "," + dum[i][1]);
		}
	}

	// It's my Method , I guess not the best complexity wise but its easy

	public int[][] merge(int[][] intervals) {
		// Step 1 is to sort given matrix based on 'start' of each interval

		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < intervals.length; i++) {
			pq.add(new Pair(intervals[i][0], intervals[i][1]));
		}
		int q = 0;
		while (!pq.isEmpty()) {
			Pair pair = pq.remove();
			intervals[q][0] = pair.x;
			intervals[q][1] = pair.y;
			q++;
		}

		// Step 2 simply make 2 seperate stacks , one for X coordinate (i.e. start) and
		// one for Y (i.e. end) of an
		// interval and simply add 1st interval
		Stack<Integer> st_X = new Stack<>();
		Stack<Integer> st_Y = new Stack<>();
		st_X.add(intervals[0][0]);
		st_Y.add(intervals[0][1]);

		// Step 3 now if st_Y.lastElement() < intervals[i][0] means there's no overlap
		// in
		// current and previous points so simply add current point to answer i.e. on top
		// of X and Y stacks If we end up in 'else' block means we have to merge current
		// and previous intervals so since we sorted the matrix so X axis will remain
		// the
		// same but we will simply take the Y axis of the larger interval and add it to
		// stack
		for (int i = 1; i < intervals.length; i++) {
			if (st_Y.lastElement() < intervals[i][0]) {
				st_X.add(intervals[i][0]);
				st_Y.add(intervals[i][1]);
			} else {

				int oldY = st_Y.pop();
				int newY = intervals[i][1];
				if (oldY > newY) {
					st_Y.add(oldY);
				} else {
					st_Y.add(newY);
				}
			}
		}

		// step 4 now simply add it to answer , we add it opposite direction cause in
		// the top we have the biggest interval cause we used stack

		int ans[][] = new int[st_X.size()][2];
		int z = st_X.size() - 1;
		while (!st_X.isEmpty()) {
			ans[z][0] = st_X.pop();
			ans[z][1] = st_Y.pop();
			z--;
		}

		return ans;
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Merge_Interval_56_LC.Pair o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}

	}

}
