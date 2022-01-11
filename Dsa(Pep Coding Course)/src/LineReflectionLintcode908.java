import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import Tree.LevelOrderTravesalOfTree.Pair;

public class LineReflectionLintcode908 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//int arr[][] = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
		//System.out.println(isReflected(arr));
		Scanner sc= new Scanner(System.in);
		short a2= sc.nextShort();
Random rand= new Random();
System.out.println(rand.nextInt(2)+1);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		System.out.println(Math.pow(2,3));
		BufferedReader br= new BufferedReader(new java.io.InputStreamReader(System.in));
         
		try {
			String sr = br.readLine();
			System.out.println("ypou entered"+ sr);
			int a= Integer.valueOf(br.readLine());
			System.out.println(a);
		} catch (NumberFormatException | IOException e) {

			
			e.printStackTrace();
		}

		String s= String.valueOf(2.0);
		int a='A';
		System.out.println(a);
		//		
//		Scanner sc= new Scanner(System.in);
//		String s= sc.next();
//		System.out.println("asa ss"+s);
	}

	public static boolean isReflected(int[][] points) {
		boolean isPossible = true;// assuming that every point has its reflection

		double minX = Integer.MAX_VALUE;// this will hold x coordinate of point with max value of x
		double maxX = Integer.MIN_VALUE;// this will hold x coordinate of point with min value of x

		double mirror;// double cause mirror can be fraction value too , like 0.5 or 3.6 etc

		HashMap<String, Integer> hm = new HashMap<>();// here we store every point's hash code (key) with its frequency
														// (value) , since there can be more than 1 point at same point
														// i.e coinciding points

		for (int i = 0; i < points.length; i++) {// simply filling the hm
			double x = points[i][0];
			double y = points[i][1];
			maxX = Math.max(maxX, x);
			minX = Math.min(minX, x);
			String hashCode = x + "#" + y;
			if (hm.containsKey(hashCode)) {
				int freq = hm.get(hashCode);
				hm.put(hashCode, freq + 1);
			} else {
				hm.put(hashCode, 1);
			}

		}

		mirror = (double) (maxX + minX) / 2;// mirror can only be mid point of maxX and minX , no other mirror is
											// possible cause then these 2 will not be able to reflect each other ,
											// since distance from mirror is same on both side then only its
											// reflection therefore we choose max value and min cause they will be
											// farthest from mirror and can only be match for each other no other point
											// with different x value
											// can be there match

		for (int i = 0; i < points.length; i++) {

			double x1 = points[i][0];
			double y1 = points[i][1];

			String hashCode = x1 + "#" + y1;

			if (!hm.containsKey(hashCode)) {// means we paired it with someone so simply move on
				continue;
			}

			if (x1 == mirror) {// this is the special case when point is on mirror in this case point is its
								// own reflection
				if (hm.containsKey(hashCode)) {
					hm.remove(hashCode);
				}
				continue;
			}

			double x2 = (double) 2 * mirror - x1;// derived from (x1+x2)/2=mirror

			String hashCodeToFind = x2 + "#" + y1;// hash code of the reflection of current point , height is same

			if (hm.containsKey(hashCodeToFind)) {

				int freq = hm.get(hashCodeToFind);
				if (freq == 1) {
					hm.remove(hashCodeToFind);
				} else {
					hm.put(hashCodeToFind, freq - 1);
				}
			} else {
				isPossible = false;
				break;
			}

			int freq = hm.get(hashCode);// if we reached here means we either paired current point or there's no
										// reflection in which case
										// we would have broken out of loop , since we are still in the loops means we
										// found
										// the reflection point so simply remove the current point too

			if (freq == 1) {
				hm.remove(hashCode);
			} else {
				hm.put(hashCode, freq - 1);
			}

		}

		return isPossible;
	}
	
	

}
