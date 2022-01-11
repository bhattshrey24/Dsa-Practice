import java.util.ArrayList;
import java.util.List;

// its question number 434
public class NumberOfIsland2LintCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] op = new Point[] { new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 2) };
		System.out.println(numIslands2(3, 3, op));
	}

	public static List<Integer> numIslands2(int n, int m, Point[] operators) {
		List<Integer> sol = new ArrayList<>();

		if (operators == null) { // this to pass a stuid test case of lintcode
			return sol;
		}
		int parent[] = new int[m * n];// cause we are converting it in cell numbers
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int numOfGrps = 0;
		int rank[] = new int[m * n];
		int grid[][] = new int[n][m];

		for (int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}

		for (Point p : operators) {
			if (grid[p.x][p.y] == 1) { // i.e if already processed this point then just add previous number of island
										// to answer and continue
				sol.add(numOfGrps);
				continue;
			}
			int curCell = p.x * m + p.y;

			numOfGrps += 1; // we assume that by adding current point a new land/group/component is formed

			grid[p.x][p.y] = 1;
			if (isValid(n, m, p.x + 1, p.y)) {
				if (grid[p.x + 1][p.y] == 1) {
					int cellNum = (p.x + 1) * m + p.y;
					if (findLeaderWithPathCompression(cellNum, parent) != findLeaderWithPathCompression(curCell,
							parent)) {
						numOfGrps--;
						UnionByRank(curCell, cellNum, parent, rank);
					}

				}
			}
			if (isValid(n, m, p.x - 1, p.y)) {
				int cellNum = (p.x - 1) * m + p.y;
				if (grid[p.x - 1][p.y] == 1) {
					if (findLeaderWithPathCompression(cellNum, parent) != findLeaderWithPathCompression(curCell,
							parent)) {
						numOfGrps--;

						UnionByRank(curCell, cellNum, parent, rank);
					}
				}

			}
			if (isValid(n, m, p.x, p.y + 1)) {
				int cellNum = p.x * m + p.y + 1;
				if (grid[p.x][p.y + 1] == 1) {
					if (findLeaderWithPathCompression(cellNum, parent) != findLeaderWithPathCompression(curCell,
							parent)) {
						numOfGrps--;

						UnionByRank(curCell, cellNum, parent, rank);
					}
				}

			}
			if (isValid(n, m, p.x, p.y - 1)) {
				int cellNum = p.x * m + p.y - 1;
				if (grid[p.x][p.y - 1] == 1) {
					if (findLeaderWithPathCompression(cellNum, parent) != findLeaderWithPathCompression(curCell,
							parent)) {
						numOfGrps--;

						UnionByRank(curCell, cellNum, parent, rank);

					}
				}

			}

			sol.add(numOfGrps);
		}

		return sol;
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

	public static int findLeaderWithPathCompression(int x, int[] parent) {
		if (parent[x] == x) {
			return x;
		}
		int temp = findLeaderWithPathCompression(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

	public static boolean isValid(int r, int c, int i, int j) {
		return !(i < 0 || i >= r || j < 0 || j >= c);
	}

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

}
