import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem218 {

	public static void main(String[] args) {
		 int arr[][] = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, {
		 19, 24, 8 } };
		//int ar[][] = { { 0, 2, 3 }, { 2, 5, 3 } };
		System.out.println(getSkyline(arr));
	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < buildings.length; i++) {
			list.add(new Pair(buildings[i][0], buildings[i][2]));
			list.add(new Pair(buildings[i][1], -buildings[i][2]));// adding the end point with -ve heiht so that we can know which is end point and which is start
		}
		
		Collections.sort(list);

		int prev = 0;
		
		pq.add(prev);
		
		for (Pair ele : list) {
			
			if (ele.height < 0) {
				int eleToRemove = Math.abs(ele.height);
				pq.remove(eleToRemove);

				if (pq.peek() != prev) {// we only process if theres a mismatch in prev and peek cause this means that
										// either thers a dip or rise

					prev = pq.peek();// since from skyline we can only see top most element therefore we are using
										// max pq
					List<Integer> ansCoordinate = new ArrayList<>();
					
					ansCoordinate.add(ele.coordinate);//coordinate
					ansCoordinate.add(pq.peek());// height
					
					ans.add(ansCoordinate);
				}
				continue;// continue cause we dont want to add -ve height
			}
			
			pq.add(ele.height);

			if (pq.peek() != prev) {
				
				prev = pq.peek();
				List<Integer> ansCoordinate = new ArrayList<>();
				ansCoordinate.add(ele.coordinate);
				ansCoordinate.add(pq.peek());
				ans.add(ansCoordinate);
			}
		}
		return ans;
	}

	public static class Pair implements java.lang.Comparable<Pair> {// for collections.sort() , we use
																	// java.lang.Comparable<Pair> instead of
																	// just Comparable<Pair>
		int coordinate;
		int height;

		public Pair(int coordinate, int height) {
			this.height = height;
			this.coordinate = coordinate;
		}

		@Override
		public int compareTo(SkylineProblem218.Pair o) {
			// TODO Auto-generated method stub
			if (this.coordinate == o.coordinate) {
				return o.height - this.height; // if coordinates are same then we want the element with bigger height
												// first
			}
			return this.coordinate - o.coordinate;
		}

	}

}
