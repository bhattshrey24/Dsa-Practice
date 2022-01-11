package Stack_And_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class MaximumOfAllSubarraysOfSizeK {
	public static void main(String[] args) {

	}

//https://www.youtube.com/watch?v=xFJXtB5vSmM
	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<>();
		int i = 0;
		int j = 0;

		while (j < arr.length) {
			if (j < k) {
				int ele = arr[j];
				while (!q.isEmpty()) {
					if (arr[q.getLast()] > ele) {
						break;
					}
					q.removeLast();
				}
				if (q.isEmpty()) {
					q.add(j);
				} else {
					q.addLast(j);
				}

				j++;

				if (j == k) {
					ans.add(arr[q.getFirst()]);
				}
			} else {
				// ACQUIRING
				int acqEle = arr[j];

				while (!q.isEmpty()) {
					if (arr[q.getLast()] > acqEle) {
						break;
					}
					q.removeLast();
				}
				if (q.isEmpty()) {
					q.add(j);
				} else {
					q.addLast(j);
				}

				// Releasing last ele
				// int releaseEle = arr[i];
				if (q.getFirst() == i) {
					q.removeFirst();
				}

				ans.add(arr[q.getFirst()]);
				i++;
				j++;

			}
		}

		return ans;
	}
}
