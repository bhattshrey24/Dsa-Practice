import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

// q 332 of leetcode , itenary means path taken
public class ReconstructItenary332 {

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		List<String> innerList = new ArrayList<>();
		innerList.add("JFK");
		innerList.add("KUL");
		tickets.add(innerList);
		innerList = new ArrayList<>();
		innerList.add("JFK");
		innerList.add("NRT");
		tickets.add(innerList);
		innerList = new ArrayList<>();
		innerList.add("NRT");
		innerList.add("JFK");
		tickets.add(innerList);

		System.out.println(findItinerary(tickets));
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, PriorityQueue<String>> grf = new HashMap<>();
		LinkedList<String> sol = new LinkedList<String>();
		for (List<String> li : tickets) {
			if (!grf.containsKey(li.get(0))) {
				PriorityQueue<String> nbr = new PriorityQueue<>();
				nbr.add(li.get(1));
				grf.put(li.get(0), nbr);
			} else {
				PriorityQueue<String> nbr = grf.get(li.get(0));
				nbr.add(li.get(1));
				grf.put(li.get(0), nbr);
			}
		}
		for (List<String> li : tickets) { // we are adding those in grapf that do not have any outgoing edge that is
											// those which are father of none , if we dont do this then program will
											// give null pointer error
			if (!grf.containsKey(li.get(0))) {
				PriorityQueue<String> nbr = new PriorityQueue<>();
				grf.put(li.get(0), nbr);
			}
			if (!grf.containsKey(li.get(1))) {
				PriorityQueue<String> nbr = new PriorityQueue<>();
				grf.put(li.get(1), nbr);
			}
		}

		Dfs(grf, "JFK", sol);
		return sol;
	}

	public static void Dfs(HashMap<String, PriorityQueue<String>> grf, String currVrtx, LinkedList<String> sol) {
		if (grf.get(currVrtx).size() == 0) { // i.e no neighbor i.e. the base case
			sol.addFirst(currVrtx);// simply add cause now we do backtracking
			return;
		}
		while (!grf.get(currVrtx).isEmpty()) { // adding neighbors
			String currNbr = grf.get(currVrtx).remove(); // remove and marked visited
			Dfs(grf, currNbr, sol);
		}
		// backtracking
		sol.addFirst(currVrtx);// adding while backtracking
	}

}
