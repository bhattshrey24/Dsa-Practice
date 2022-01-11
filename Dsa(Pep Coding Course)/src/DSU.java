
public class DSU {

	public static void main(String[] args) {
	}

	public static void NormalDSUwithArray(int numOfVertx, Pair[] Edges) {
		int[] parent = new int[numOfVertx];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;// initially everyone is pointing itself i.e. they are in their own set
		}

		for (Pair edge : Edges) {
			union(edge.u, edge.v, parent); // calling rank for every edge
		}
	}

	public static void BestTimeComplexityDSUwithArray(int numOfVertx, Pair[] Edges) {
		int[] parent = new int[numOfVertx];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;// initially everyone is pointing itself i.e. they are in their own set
		}
		int[] Rank = new int[numOfVertx];
		for (int i = 0; i < Rank.length; i++) {// we do same for initializing size matrix
			Rank[i] = 1; // giving every vertex(i.e. set) size = 1 initially cause they all have pointing
							// to them selves therefore height/rank of tree of every set is 1
		}
		for (Pair edge : Edges) {
			UnionByRank(edge.u, edge.v, parent, Rank); // calling rank for every edge
		}
	}

	public static int findLeader(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		return findLeader(parent[x], parent); // this simply means that i am not the leader so the answer is what my
												// parent returns
	}

	public static void union(int u, int v, int[] parent) {
		int a = findLeader(u, parent);
		int b = findLeader(v, parent);
		if (a != b) {
			parent[b] = a;
		}

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

	public static void UnionBySize(int u, int v, int[] parent, int[] size) {
		int a = findLeaderWithPathCompression(u, parent);
		int b = findLeaderWithPathCompression(v, parent);
		if (a != b) {
			if (size[a] >= size[b]) { // we always connect smaller size tree with bigger bigger size tree
				// here we also merged the case of equal size cause it doesnt matter who is
				// parent of whom if sizes are equal
				parent[b] = a;
				size[a] += size[b];// since whole tree with leader 'a' is added to 'b'
			} else {// this is executed if size [a]<size[b]
				parent[a] = b;
				size[b] += size[a];
			}
		}

	}

	public static class Pair {
		int u, v;

		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
	}

}
