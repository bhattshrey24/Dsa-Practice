import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingGFG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Job[] job = new Job[] { new Job(7, 5, 10), new Job(6, 3, 20), new Job(5, 5, 30), new Job(4, 5, 40),
				new Job(3, 2, 50), new Job(2, 1, 60), new Job(1, 3, 70) };
		int[] sol = JobScheduling(job, 4);
		System.out.println(sol[0] + " " + sol[1]);
	}

	public static int[] JobScheduling(Job arr[], int n) {
		int maxProfit = 0;
		int numOfJobs = 0;
		int[] sol = new int[2];
		int maxDeadLine = 0;
		ArrayList<Job> jobs = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			jobs.add(arr[i]);
			maxDeadLine = Math.max(maxDeadLine, arr[i].deadline);
		}
		Collections.sort(jobs, Comparator.reverseOrder());// reverse order cause we want in descending order
		int parent[] = new int[maxDeadLine + 1];// cause 0 represents no day prior to deadline is left
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (Job ele : jobs) {
			if (parent[ele.deadline] == ele.deadline) {// this is executed if i am pointing
				// to myself i.e no job is assigned to current deadline date
				maxProfit += ele.profit;
				numOfJobs++;
				union(ele.deadline - 1, ele.deadline, parent);// mujhe bhi mere se just pehle wale leader pr point krdo
			} else if (findLeaderWithPathCompression(ele.deadline, parent) != 0) {// not 0 cause equal 0 means no day is
																					// left to assign before
																					// ele.deadline
				int leader = parent[ele.deadline];// now since im not pointing myself so find my leader i.e last
													// unoccupied space
				maxProfit += ele.profit;
				numOfJobs++;
				union(leader - 1, leader, parent);// now point both my leader and me to last unoccupied space
			}
		}
		sol[0] = numOfJobs;
		sol[1] = maxProfit;
		return sol;
	}

	public static void union(int u, int v, int[] parent) {
		int a = findLeaderWithPathCompression(u, parent);
		int b = findLeaderWithPathCompression(v, parent);
		if (a != b) {
			parent[b] = a;
		}

	}

	public static int findLeaderWithPathCompression(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		int temp = findLeaderWithPathCompression(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

	static class Job implements Comparable<Job> {
		int id, profit, deadline;

		public Job(int x, int y, int z) {
			id = x;
			deadline = y;
			profit = z;
		}

		@Override
		public int compareTo(JobSequencingGFG.Job o) {
			// TODO Auto-generated method stub
			return this.profit - o.profit;
		}

	}

}
