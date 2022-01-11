import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTimeLintcode850 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sch[][] = { { 1, 2, 5, 6 }, { 1, 3 }, { 4, 10 } };
		List<Interval> dum = employeeFreeTime(sch);
		for (Interval in : dum) {
			System.out.println(in.start + " " + in.end);
		}
	}

	public static List<Interval> employeeFreeTime(int[][] schedule) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < schedule.length; i++) {// adding 1st interval of each emplyoee since intervals of each
													// employee is sorted

			for (int j = 0; j < schedule[i].length; j += 2) {// taking jump of 2 because we are given an array where is
																// its {1,2,3,4} means employee has 2 intervals that is
																// (1,2) and (3,4)

				Pair pair = new Pair(schedule[i][j], schedule[i][j + 1], i, j / 2);// since we are given array and to
																					// make pair of 2 simply divide by 2
																					// cause if there are 4 then it
																					// means there are 2 intervals(i.e
																					// 4/2=2) which are 0 and 1
				pq.add(pair);
			}
		}

		List<Interval> ans = new ArrayList<>();

		int prevEndTime = pq.remove().end;// preprocessing ,since 1st element has the smallest starting time so in this
											// time duration there can be no free time

		while (!pq.isEmpty()) {
			Pair rem = pq.remove();
			int dum = schedule[rem.employeeNumb].length / 2;

			if (rem.intervalNumb + 1 < dum) {// this is just to check that is there next interval present in current
												// employee
				int i = rem.employeeNumb;
				int j = rem.intervalNumb;
				Pair pair = new Pair(schedule[i][2 * j + 2], schedule[i][2 * j + 3], i, j + 1);
				pq.add(pair);
			}

			if (rem.start > prevEndTime) {// means we found free time
				Interval interval = new Interval(prevEndTime, rem.start);
				ans.add(interval);
				prevEndTime = rem.end;
			} else {// simply update end time , if we are here means we have found overlapping
					// interval so simply update endtime
				prevEndTime = Math.max(prevEndTime, rem.end);
			}
		}
		return ans;
	}

	public static class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;

		}
	}

	public static class Pair implements Comparable<Pair> {
		int start;
		int end;
		int employeeNumb;
		int intervalNumb;

		Pair(int start, int end, int employeeNumb, int intervalNumb) {
			this.start = start;
			this.end = end;
			this.employeeNumb = employeeNumb;
			this.intervalNumb = intervalNumb;
		}

		@Override
		public int compareTo(EmployeeFreeTimeLintcode850.Pair o) {
			return this.start - o.start == 0 ? this.end - o.end : this.start - o.start;// this means if start is same
																						// then compare the end and give
																						// preference to the one with
																						// smaller "end"
		}
	}

}
