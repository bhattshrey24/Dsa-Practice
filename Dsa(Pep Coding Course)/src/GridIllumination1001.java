import java.util.HashMap;
import java.util.HashSet;

public class GridIllumination1001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] lamps = {};
		int[][] queries = {};
		int n = 0;
		System.out.println(gridIllumination(n, lamps, queries));
	}

	// this code has bugs FIX IT
	
	public static int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
		int ans[] = new int[queries.length];
		HashMap<Integer, Integer> Illuminatedlamps = new HashMap<>();// cause there can be more than 1 lamp at a cell
		HashMap<Integer, Integer> row = new HashMap<>();
		HashMap<Integer, Integer> col = new HashMap<>();
		HashMap<Integer, Integer> LD = new HashMap<>();
		HashMap<Integer, Integer> RD = new HashMap<>();

		for (int i = 0; i < lamps.length; i++) {
			int r = lamps[i][0];
			int c = lamps[i][1];
			int CellNumber = r * n + c;

			if (Illuminatedlamps.containsKey(CellNumber)) {
				int prevFreq = Illuminatedlamps.get(CellNumber);
				Illuminatedlamps.put(CellNumber, prevFreq + 1);
			} else {
				Illuminatedlamps.put(CellNumber, 1);
			}

			if (row.containsKey(r)) {
				int dummy = row.get(r);
				row.put(r, dummy + 1);
			} else {
				row.put(r, 1);
			}

			if (col.containsKey(c)) {
				int dummy = col.get(c);
				col.put(c, dummy + 1);
			} else {
				col.put(c, 1);
			}

			if (LD.containsKey(r - c)) {
				int dummy = LD.get(r - c);
				LD.put(r - c, dummy + 1);
			} else {
				LD.put(r - c, 1);
			}
			if (RD.containsKey(r + c)) {
				int dummy = RD.get(r + c);
				RD.put(r + c, dummy + 1);
			} else {
				RD.put(r + c, 1);
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int r = queries[i][0];
			int c = queries[i][1];
			int CellNumber = r * n + c;
			if (row.containsKey(r)) {
				ans[i] = 1;
			} else if (col.containsKey(c)) {
				ans[i] = 1;

			} else if (LD.containsKey(r - c)) {
				ans[i] = 1;

			} else if (RD.containsKey(r + c)) {
				ans[i] = 1;

			} else {
				ans[i] = 0;
			}

			int up = (r -1)* n + c;
			int down = (r+1) * n + c;
			int left = r * n + (c-1);
			int right = r * n + c+1;
			int upperLeft = (r-1) * n + (c-1);

			int upperRight = (r-1) * n + (c+1);

			int lowerLeft = (r+1) * n + (c-1);
			int lowerRight = (r+1) * n + (c+1);

			if (Illuminatedlamps.containsKey(up)) {

				int prevFreq = Illuminatedlamps.get(up);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(up);
				} else {
					Illuminatedlamps.put(up, prevFreq - 1);
				}

				int rN = up / n;
				int cN = up % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}

			}
			if (Illuminatedlamps.containsKey(down)) {
				int prevFreq = Illuminatedlamps.get(down);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(up);
				} else {
					Illuminatedlamps.put(down, prevFreq - 1);
				}

				int rN = down / n;
				int cN = down % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}

			}
			if (Illuminatedlamps.containsKey(left)) {
				int prevFreq = Illuminatedlamps.get(left);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(left);
				} else {
					Illuminatedlamps.put(left, prevFreq - 1);
				}

				int rN = left / n;
				int cN = left % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}

			}
			if (Illuminatedlamps.containsKey(right)) {
				int prevFreq = Illuminatedlamps.get(right);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(right);
				} else {
					Illuminatedlamps.put(right, prevFreq - 1);
				}

				int rN = right / n;
				int cN = right % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}
			}
			if (Illuminatedlamps.containsKey(upperLeft)) {
				int prevFreq = Illuminatedlamps.get(upperLeft);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(upperLeft);
				} else {
					Illuminatedlamps.put(upperLeft, prevFreq - 1);
				}

				int rN = upperLeft / n;
				int cN = upperLeft % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}
			}
			if (Illuminatedlamps.containsKey(upperRight)) {
				int prevFreq = Illuminatedlamps.get(upperRight);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(upperRight);
				} else {
					Illuminatedlamps.put(upperRight, prevFreq - 1);
				}

				int rN = upperRight / n;
				int cN = upperRight % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}
			}
			if (Illuminatedlamps.containsKey(lowerLeft)) {
				int prevFreq = Illuminatedlamps.get(lowerLeft);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(lowerLeft);
				} else {
					Illuminatedlamps.put(lowerLeft, prevFreq - 1);
				}

				int rN = lowerLeft / n;
				int cN = lowerLeft % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}
			}
			if (Illuminatedlamps.containsKey(lowerRight)) {
				int prevFreq = Illuminatedlamps.get(lowerRight);

				if (prevFreq == 1) {
					Illuminatedlamps.remove(lowerRight);
				} else {
					Illuminatedlamps.put(lowerRight, prevFreq - 1);
				}

				int rN = lowerRight / n;
				int cN = lowerRight % n;
				int ldN = rN - cN;
				int rdN = rN + cN;

				if (row.get(rN) == 1) {
					row.remove(rN);
				} else {
					int prev = row.get(rN);
					row.put(rN, prev - 1);
				}

				if (col.get(cN) == 1) {
					col.remove(cN);
				} else {
					int prev = col.get(cN);
					col.put(cN, prev - 1);
				}

				if (LD.get(ldN) == 1) {
					LD.remove(ldN);
				} else {
					int prev = LD.get(ldN);
					LD.put(ldN, prev - 1);
				}

				if (RD.get(rdN) == 1) {
					RD.remove(rdN);
				} else {
					int prev = RD.get(rdN);
					RD.put(rdN, prev - 1);
				}
			}

		}

		return ans;
	}

}
