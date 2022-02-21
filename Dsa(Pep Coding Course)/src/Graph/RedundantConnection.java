package Graph;
// q 684 of leetcode
public class RedundantConnection {

	public static void main(String[] args) {

	}

	public int[] findRedundantConnection(int[][] edges) {
		int sol[] = new int[2];
		int parent[] = new int[edges.length * 2]; // cause its a NX2 matrix
		int rank[] = new int[edges.length * 2];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;// initially everyone is pointing itself i.e. they are in their own set
		}
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;// initially everyone is pointing itself i.e. they are in their own set
		}

		for (int i = 0; i < edges.length; i++) {
			if (findLeaderWithPathCompression(edges[i][0], parent) == findLeaderWithPathCompression(edges[i][1],
					parent)) {
				sol[0] = edges[i][0];
				sol[1] = edges[i][1];
				break;
			} else {
				UnionByRank(edges[i][0], edges[i][1], parent, rank);
			}
		}
		return sol;

	}

	public static int findLeaderWithPathCompression(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		int temp = findLeaderWithPathCompression(parent[x], parent);
		parent[x] = temp;// this is sort of backtracking cause this will be executed when stack falls
		// so what we are doing is that we have faith that recursion will give us the
		// leader of the group so the leader is stored in 'temp' so in above line we are
		// just pointing current
		// element directly to leader
		return temp;
	}

	public static void UnionByRank(int u, int v, int[] parent, int[] rank) {// rank simply means height of tree
		int a = findLeaderWithPathCompression(u, parent);
		int b = findLeaderWithPathCompression(v, parent);
		if (a != b) {
			if (rank[a] > rank[b]) { // we always connect small height tree with bigger height tree so that resultant
										// height doesn't increase more than bigger trees height
				parent[b] = a;
			} else if (rank[a] < rank[b]) {
				parent[a] = b;
			} else { // this is the condition for rank[a]=rank[b] and only in this case the
						// height/rank of tree will increase
				parent[b] = a;// here we could also use parent[a]=b
				rank[a]++;
			}
		}
	}

}
