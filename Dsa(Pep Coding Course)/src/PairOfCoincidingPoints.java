import java.util.HashMap;
import java.util.HashSet;

public class PairOfCoincidingPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X[] = new int[] { 1, 2, 1 };
		int Y[] = new int[] { 2, 3, 3 };

		System.out.println(numOfPairs(X, Y, 3));
	}

	static int numOfPairs(int[] X, int[] Y, int N) {
		// just solve the equation x1-x2+y1-y2=((x1-x2)^2+(y1-y2)^1)^0.5 , you will get
		// (x1-x2)(y1-y2)=0 this means either x1=x2 or y1=y2 (its "or" and not "and"
		// because its given that
		// points should not be coinciding i.e. same) then we can pair points x1,y1 with
		// x2,y2

		int ans = 0;
		HashMap<Integer, Integer> pointsX = new HashMap<>();// this stores occurance of X coordinate
		HashMap<Integer, Integer> pointsY = new HashMap<>();// this stores occurance of Y coordinate
		HashMap<String, Integer> visitedPoints = new HashMap<>();// this helps us to not pair the same points together
		for (int i = 0; i < N; i++) {
			if (pointsX.containsKey(X[i])) {
				int prevFreq = pointsX.get(X[i]);
				ans += prevFreq;// we simply add the frequency of point x , we will handle duplicate points in
								// the
								// end by using visitedPoints hashmap
				pointsX.put(X[i], prevFreq + 1);

			} else {
				pointsX.put(X[i], 1);// simply add so that it can be used by later points to pair up
			}

			if (pointsY.containsKey(Y[i])) {
				int prevFreq = pointsY.get(Y[i]);
				ans += prevFreq;
				pointsY.put(Y[i], prevFreq + 1);
			} else {
				pointsY.put(Y[i], 1);

			}

			if (visitedPoints.containsKey(X[i] + "#" + Y[i])) {
				int prevFreq = visitedPoints.get(X[i] + "#" + Y[i]);
				ans -= prevFreq * 2;// we remove 2 times cause we must have added once for x and once for y
				visitedPoints.put(X[i] + "#" + Y[i], prevFreq + 1);// we increase the frequency cause if there are 2
																	// points then we have to reduce 4 because we would
																	// have added 2 for x and 2 for y to ans
			} else {
				visitedPoints.put(X[i] + "#" + Y[i], 1);// simply put it in visited
			}
		}

		return ans;
	}

	// MY solution but not working for a big test case
//	static int numOfPairs(int[] X, int[] Y, int N) { 
//		int ans = 0;
//		HashMap<Integer, HashSet<String>> pointsXY = new HashMap<>();
//		HashMap<Integer, HashSet<String>> pointsYX = new HashMap<>();
////
////		for (int i = 0; i < X.length; i++) {
////
////			if (pointsXY.containsKey(X[i])) {
////				HashSet<String> prevDumXY = new HashSet<>();
////				prevDumXY.add(X[i] + "#" + Y[i]);
////				pointsXY.put(X[i], prevDumXY);
////			} else {
////				HashSet<String> dumXY = new HashSet<>();
////				dumXY.add(X[i] + "#" + Y[i]);
////				pointsXY.put(X[i], dumXY);
////			}
////
////			if (pointsYX.containsKey(Y[i])) {
////				HashSet<String> prevDumYX = new HashSet<>();
////				prevDumYX.add(X[i] + "#" + Y[i]);
////				pointsYX.put(Y[i], prevDumYX);
////			} else {
////				HashSet<String> dumYX = new HashSet<>();
////				dumYX.add(X[i] + "#" + Y[i]);
////				pointsYX.put(Y[i], dumYX);
////			}
////		}
//
//		for (int i = 0; i < X.length; i++) {
//			if (pointsXY.containsKey(X[i])) {
//				if (pointsXY.get(X[i]).size() == 1) {
//					if (!pointsXY.get(X[i]).contains(X[i] + "#" + Y[i])) {
//						ans++;
//						HashSet<String> prevDumXY = pointsXY.get(X[i]);
//						prevDumXY.add(X[i] + "#" + Y[i]);
//						pointsXY.put(X[i], prevDumXY);
//					}
//				} else {
//					ans++;
//					HashSet<String> prevDumXY = pointsXY.get(X[i]);
//					prevDumXY.add(X[i] + "#" + Y[i]);
//					pointsXY.put(X[i], prevDumXY);
//				}
//			} else {
//				HashSet<String> dumXY = new HashSet<>();
//				dumXY.add(X[i] + "#" + Y[i]);
//				pointsXY.put(X[i], dumXY);
//			}
//
//			if (pointsYX.containsKey(Y[i])) {
//				if (pointsYX.get(Y[i]).size() == 1) {
//					if (!pointsYX.get(Y[i]).contains(X[i] + "#" + Y[i])) {
//						ans++;
//						HashSet<String> prevDumYX = pointsYX.get(Y[i]);
//						prevDumYX.add(X[i] + "#" + Y[i]);
//						pointsYX.put(Y[i], prevDumYX);
//					}
//				} else {
//					ans++;
//					HashSet<String> prevDumYX = pointsYX.get(Y[i]);
//					prevDumYX.add(X[i] + "#" + Y[i]);
//					pointsYX.put(Y[i], prevDumYX);
//				}
//			} else {
//				HashSet<String> dumYX = new HashSet<>();
//				dumYX.add(X[i] + "#" + Y[i]);
//				pointsYX.put(Y[i], dumYX);
//			}
//		}
//
//		return ans;
//
//	}
}
