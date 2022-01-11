//q 685 leetcode
public class RedundantConnection2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]edges= {{1,2},{2,3},{3,4},{4,5},{5,6}};
int [] sol=findRedundantDirectedConnection(edges);
		System.out.println(sol[0]);
		System.out.println(sol[1]);

	}

	public static int[] findRedundantDirectedConnection(int[][] edges) {
		int v = 0;
		int[] sol = new int[2];
		for (int i = 0; i < edges.length; i++) {
			v = Math.max(v, edges[i][0]);
			v = Math.max(v, edges[i][1]);
		}
		int[] indegree = new int[v+1];// cause vertices starts from 1
		for (int i = 0; i < indegree.length; i++) {
			indegree[i] = -1;// cause -1 means not processed yet
		}
		boolean isCase2 = true;
		int probableAns1 = 0, probableAns2 = 0;

		for (int i = 0; i < edges.length; i++) {
			if (indegree[edges[i][1]] != -1) {
				isCase2 = false;
				probableAns1 = indegree[edges[i][1]];
				probableAns2 = i;
			} else {
				indegree[edges[i][1]] = i;
			}
		}
		// Cycle case
		if (isCase2) {
			int parent[] = new int[v+1];
			int rank[] = new int[v+1];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < rank.length; i++) {
				rank[i] = 1;
			}

			for (int i = 0; i < edges.length; i++) {
				if (findLeaderWithPathCompression(edges[i][0], parent) == findLeaderWithPathCompression(edges[i][1],
						parent)) {
					sol[0] = edges[i][0];
					sol[1] = edges[i][1];
					return sol;
				} else {
					UnionByRank(edges[i][0], edges[i][1], parent, rank);
				}
			}
		}
		// Case 1 and 3 combined
		int blacklist = probableAns2;

		int parent[] = new int[v+1];
		int rank[] = new int[v+1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		boolean isCyclepresent = false;
		for (int i = 0; i < edges.length; i++) {
			if (i == blacklist) {
				continue;
			}
			if (findLeaderWithPathCompression(edges[i][0], parent) == findLeaderWithPathCompression(edges[i][1],
					parent)) {
//				sol[0] = edges[i][0];
//				sol[1] = edges[i][1];
				isCyclepresent=true;
			} else {
				UnionByRank(edges[i][0], edges[i][1], parent, rank);
			}
		}

		if(isCyclepresent) {
			sol[0] = edges[probableAns1][0];
			sol[1] = edges[probableAns1][1];
			return sol;
		}else {
			sol[0] = edges[probableAns2][0];
			sol[1] = edges[probableAns2][1];
			return sol;

		}
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
				parent[b] = a;// here we could also use parent[a]=b
				rank[a]++;
			}
		}
	}

}
