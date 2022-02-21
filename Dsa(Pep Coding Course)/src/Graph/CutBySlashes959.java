package Graph;
// 959 q of leetcode
public class CutBySlashes959 {

	public static void main(String[] args) {

		String[] grid = new String[] { "/\\", "\\/" };
		System.out.println(regionsBySlashes(grid));
	}

	public static int regionsBySlashes(String[] grid) {
		int r = grid.length + 1;
		int c = grid[0].length() + 1;
		int numberOfRegions = 1;// started from 1 cause initially 1 region is made because boundaries are connected		
		int[] parent = new int[r * c];
		int[] rank = new int[r * c];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}
		for (int i = 0; i < r; i++) { // connecting boundaries of matrix 
			for (int j = 0; j < c; j++) {
				if (i == 0) {
					if (j != c - 1) {
						int cell1 = i * c + j + 1;
						int cell2 = i * c + j;
						UnionByRank(cell1, cell2, parent, rank); // since we in union function we only union if they are
																	// not in same set therefore no need to check it
																	// seperately simply do union
					}
				}
				if (i == r - 1) {
					if (j != c - 1) {
						int cell1 = i * c + j + 1;
						int cell2 = i * c + j;
						UnionByRank(cell1, cell2, parent, rank);

					}
				}
				if (j == 0) {
					if (i != r - 1) {
						int cell1 = ((i + 1) * c) + j;
						int cell2 = i * c + j;
						UnionByRank(cell1, cell2, parent, rank);
					}
				}
				if (j == c - 1) {
					if (i != r - 1) {
						int cell1 = ((i + 1) * c) + j;
						int cell2 = i * c + j;

						UnionByRank(cell1, cell2, parent, rank);
					}
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				if (grid[i].charAt(j) == '/') { // if grid[i][j] is '/' then it connects i+1,j with i,j+1 in solGrid
					int cell1 = (i + 1) * c + j;
					int cell2 = (i * c) + (j + 1);
					if (findLeaderWithPathCompression(cell1, parent) == findLeaderWithPathCompression(cell2, parent)) {
						numberOfRegions++;// this means cycle is found therefore no need to do union just add 1 to answer
					} else {
						UnionByRank(cell1, cell2, parent, rank);
					}
				} else if (grid[i].charAt(j) == '\\') { // if grid[i][j] is '\' then it connects i,j with i+1,j+1 in solGrid
					int cell1 = i * c + j;
					int cell2 = (i + 1) * c + j + 1;
					if (findLeaderWithPathCompression(cell1, parent) == findLeaderWithPathCompression(cell2, parent)) {
						numberOfRegions++;
					} else {
						UnionByRank(cell1, cell2, parent, rank);
					}
				}
			}
		}

		return numberOfRegions;
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
