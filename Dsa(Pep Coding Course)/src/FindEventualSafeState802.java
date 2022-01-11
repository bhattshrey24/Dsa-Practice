import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeState802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grf[][] = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		System.out.println(eventualSafeNodes(grf));
	}

	public static List<Integer> eventualSafeNodes(int[][] graph) {

		List<Integer> sol = new ArrayList<>();
		int[] visited = new int[graph.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}
		for (int i = 0; i < graph.length; i++) {
			boolean isSafe = false;
			isSafe = dfsRecursion(visited, i, graph);
			if (isSafe) {
				sol.add(i);
			}
		}
		return sol;
	}

	public static boolean dfsRecursion(int[] visited, int vertx, int[][] graph) {

		if (visited[vertx] != -1) { // base case
			if (visited[vertx] == 1) {// we visit a visited again and its unafe means its a cycle
				return false;
			} else {// we visited again and its not unsafe means it not a cycle its a parent i guess
				return true;
			}
		}

		visited[vertx] = 1; // marking visited and unsafe

		boolean safe = true;// assuming neighbor is safe // its work

		for (int i = 0; i < graph[vertx].length; i++) {
			safe = dfsRecursion(visited, graph[vertx][i], graph); // here the leap of faith is that it tells if the
																	// neighbor is safe or not
			if (!safe) {// if it unsafe simple break out and return false
				break; // jasie hi unsafe mile dont explore any other children
			}
		}
		if (safe) {
			visited[vertx] = 0;// marking it safe i.e changig our initial assumption , now other nodes can also
								// see it as safe
			return true;
		} else {
			return false;// here since safe is false therefore we dont mark it 0 we let it remain 1 i.e
							// unsafe
		}

	}

}
