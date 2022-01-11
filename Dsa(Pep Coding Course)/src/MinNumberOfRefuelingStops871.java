import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops871 {

	public static void main(String[] args) {
		int[][] stations = { { 47, 220 }, { 65, 1 }, { 98, 113 }, { 126, 196 }, { 186, 218 }, { 320, 205 },
				{ 686, 317 }, { 707, 325 }, { 754, 104 }, { 781, 105 } };
		System.out.println(minRefuelStops(1000, 83, stations));
	}

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {

		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		int steps = 0;
		boolean reachedTarget = false;

		if (stations.length == 0) { // for simple testcase when there is no station
			if (startFuel >= target) {
				return 0;
			} else {
				return -1;
			}
		}

		if (startFuel >= target) {// this is for the case when stations are there but of no use cause we already
									// have enough petrol in the start itself to reach till target
			return 0;
		}

		if (startFuel < stations[0][0]) {// when start fuel is not even enough to reach the first station , so no need
											// to check further in this case cause there's no possible solution for this
											// case
			return -1;
		}

		boolean noSolutionPossible = false;// flag that tells  is it even possible to reach till target or not

		int currentFuel = startFuel;

		int i = 0;

		while (!reachedTarget && !noSolutionPossible) {// we loop through till we reach target or we find out that its
														// not possible to reach target

			if (i < stations.length && currentFuel >= stations[i][0]) { // we basically travel as far as possible with
																		// current fuel and also we keep adding stations
																		// in between so that we can use them later if
																		// we get stuck
				pq.add(new Pair(stations[i][1]));
				i++;
				continue;
			}
			if (i < stations.length && currentFuel < stations[i][0]) {// this is the case when stations some stations
																		// are still left to traverse and we get stuck
																		// in between

				while (currentFuel < stations[i][0]) {// we keep adding fuel from previous stations till we get enough
														// to pass the current station

					if (pq.isEmpty()) {// if pq gets empty means we used all station still we cant reach end means its
										// not possible to reach end
						return -1;
					}

					Pair requiredFuel = pq.remove();
					steps++;
					currentFuel += requiredFuel.fuel;
				}
				if (currentFuel >= target) {// this is for the case when while trying to cross current station
											// "stations[i][0]" we got enough fuel to even cross the target so why to
											// move further just break out of loop cause you got your answer in "steps"
											// variable
					reachedTarget = true;
					break;
				}

				pq.add(new Pair(stations[i][1]));// if we reached till here means we have enough fuel now to cross
													// curent station but not enough to reach end , so simle add current
													// station in pq so that we can use it later if we get stuck
				i++;
				continue;
			}

			if (currentFuel < target && !pq.isEmpty()) {// this is when we traversed all stations but couldnt reach the
														// end and also pq is not empty meaning there are still stations
														// left that we traversed in past which we can use

				while (!pq.isEmpty()) {
					Pair requiredFuel = pq.remove();
					steps++;
					currentFuel += requiredFuel.fuel;
					if (currentFuel >= target) {
						reachedTarget = true;
						break;
					}
				}
				if (pq.isEmpty() && !reachedTarget) {// if pq is empty that is no more station to use and we havent
														// reached target means its not posible to reach end
					noSolutionPossible = true;
				}

			} else {// this is if we traversed all stations and pq is also empty meaning no stations
					// to use so this means its impossible to reach end
				noSolutionPossible = true;
			}
		}
		
		
		if (reachedTarget) {
			return steps;
		} else {
			return -1;
		}
	}

	public static class Pair implements Comparable<Pair> {
		int fuel;

		Pair(int fuel) {
			this.fuel = fuel;
		}

		@Override
		public int compareTo(Pair o) {
			return this.fuel - o.fuel;
		}
	}

}
