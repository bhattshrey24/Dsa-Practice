import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInaSortedMatrix378 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(arr, 8));

	}

	public static int kthSmallest(int[][] matrix, int k) {
		int smallestElement = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());// we use max pq

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (pq.size() < k) {
					pq.add(matrix[i][j]);
				} else {
					pq.add(matrix[i][j]);// add so that pq can compare current element with all others and give us the
											// maximum of them all
					pq.remove();
				}
			}
		}

		while (k < pq.size()) {// its when k is smaller than no of rows in matrix , cause we add all the 1st
								// element of every row before hand , therefore simply reduce pq size equal to k
			pq.remove();
		}
		smallestElement = pq.remove();
		return smallestElement;
	}

}
