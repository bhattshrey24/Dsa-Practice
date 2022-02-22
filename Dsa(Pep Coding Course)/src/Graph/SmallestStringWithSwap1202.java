package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;


//OPTIMIZE TC IS VERY BAD , Maybe use DSU instead 
public class SmallestStringWithSwap1202 {

	public static void main(String[] args) {
		String s = "dcab";
		List<List<Integer>> pair = new ArrayList<>();
		List<Integer> dum = new ArrayList<>();
		dum.add(0);
		dum.add(3);
		pair.add(dum);
		List<Integer> dum2 = new ArrayList<>();
		dum2.add(1);
		dum2.add(2);
		pair.add(dum2);
		List<Integer> dum3 = new ArrayList<>();
		dum3.add(0);
		dum3.add(2);
		pair.add(dum3);
		System.out.println(smallestStringWithSwaps(s, pair));
	}

	 public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
  if (s.length() == 0 || pairs.isEmpty()) return s;
		String solStr = s;

		WeightedUndirectedGraphHM ob = new WeightedUndirectedGraphHM(); // you can use normal adjecency list graph too ie. array f linkedList
		// Step 1 make graph out of "pairs"
		for (int i = 0; i < pairs.size(); i++) {
			int u = pairs.get(i).get(0);
			int v = pairs.get(i).get(1);
			ob.addEdge(u, v);
		}

		// step 2 do dfs on graph
		boolean[] visited = new boolean[s.length()];

		for (int i = 0; i < s.length(); i++) {
			if (!visited[i] && ob.grf.containsKey(i)) {// the 2nd one i.e. ob.grf.containsKey(i) is for those which
														// cannot be swapped with anyone ie. this checks whether current index is
														// actually present in given 'pairs' list so
														// basically they are not in
														// graph that we created if we remove this then it will create
														// null pointer exeption
				
				List<Character> characters = new ArrayList<>();// list so that we could do collections.sort instead of arrays.sort
				List<Integer> indx = new ArrayList<>();

				dfsRecursion(ob.grf, visited, i, characters, indx, s);

				// we sort characters and indx cause we want lexiographically smallest possible
				// word and since all these indexes are in same component so bascially we can
				// swap anyone with anyone and so simply we are finding the best possible
				// combination of these whch give us lexiographically smallest arrangement
				// directly we
				// dont care what or how many swaps it takes , if it's possible simply do it
				Collections.sort(characters);
				Collections.sort(indx);
				
				for (int j = 0; j < indx.size(); j++) {
					char ch = characters.get(j);
					int idx = indx.get(j);
					solStr = solStr.substring(0, idx) + ch + solStr.substring(idx + 1);
				}
			}
		}
		return solStr;
	}

	public static void dfsRecursion(HashMap<Integer, List<Integer>> grf, boolean[] visited, int vertx,
			List<Character> characters, List<Integer> indx, String givenStr) {
		if (visited[vertx]) { // base case
			return;
		}
		visited[vertx] = true; // marking visited

		indx.add(vertx);// Work
		characters.add(givenStr.charAt(vertx));// Work

		for (int nbr : grf.get(vertx)) {
			if (!visited[nbr]) {// if neighbor not visited then do dfs
				dfsRecursion(grf, visited, nbr, characters, indx, givenStr); // adding neighbors
			}
		}
	}

	public static class WeightedUndirectedGraphHM {
		public HashMap<Integer, List<Integer>> grf = new HashMap<>();

		public void addEdge(int source, int destination) {

			if (grf.containsKey(source)) {
				grf.get(source).add(destination);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(destination);
				grf.put(source, list);
			}
			if (grf.containsKey(destination)) {
				grf.get(destination).add(source);

			} else {
				List<Integer> list = new ArrayList<>();
				list.add(source);
				grf.put(destination, list);

			}

		}
	}

}
