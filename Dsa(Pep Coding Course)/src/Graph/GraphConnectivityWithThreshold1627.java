package Graph;
import java.util.ArrayList;
import java.util.List;

public class GraphConnectivityWithThreshold1627 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphConnectivityWithThreshold1627 ob = new GraphConnectivityWithThreshold1627();
		
				
System.out.println(ob.gcd1(16, 36));
	}

	public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
		List<Boolean> sol = new ArrayList<>();
		// step 1 setup DSU
		int[] Rank = new int[n + 1];
		for (int i = 1; i < Rank.length; i++) {
			Rank[i] = 1;
		}

		// step 2 create individual groups from 1 to n pointing to themselves
		int parent[] = new int[n + 1];// cause nodes starts from 1 and not 0
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		// step 1 start from thershold + 1 and group those which have same gcd
		// eg we are 3 then we go from 3 to end and group all those which are not in
		// same group then do same for 4 and so on
		for (int i = threshold + 1; i < parent.length; i++) {
			if (parent[i] == i) { // we only group those which are still pointing themselves
				for (int j = i; j < parent.length; j++) {

					if (j % i == 0) {// since we starting from threshold so gcd(greatest common diviser) should be i
										// , we are actually finding multiple of i , if you put find gcd using eucledian
										// algo , answer would be right but it will give TLE error , you simply have to
										// find multiple of i
						UnionByRank(i, j, parent, Rank);
					}
				}
			}

		}

		// step 4 process queries one by one
		for (int i = 0; i < queries.length; i++) {
			if (findLeaderWithPathCompression(queries[i][0], parent) == findLeaderWithPathCompression(queries[i][1],
					parent)) {
				sol.add(true);
			} else {
				sol.add(false);

			}
		}

		return sol;
	}

	public static int findLeaderWithPathCompression(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		int temp = findLeaderWithPathCompression(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

	public static void UnionByRank(int u, int v, int[] parent, int[] rank) {// rank simply means height of tree
		int a = findLeaderWithPathCompression(u, parent);
		int b = findLeaderWithPathCompression(v, parent);
		if (a != b) {
			if (rank[a] > rank[b]) {
				parent[b] = a;
			} else if (rank[a] < rank[b]) {
				parent[a] = b;
			} else {
				parent[b] = a;
				rank[a]++;
			}
		}
	}
	
	// GCD IS NOT DIRECTLY USED IN ABOVE QUESTION but here is the code for finding GCD using euclid theorem
	 public static int gcd1(int a, int b)// just dry run for 36 and 16
	    {
	        if (a == 0)
	            return b;
	         
	        return gcd1(b%a, a);
	    }
	
	
	public int gcd2(int a, int b) {// this is also gcd but using khan academy logic
		if (a == 0)
			return b;
		if (b == 0)
			return a;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd2(a - b, b);
		
		return gcd2(a, b - a);
	}
}
