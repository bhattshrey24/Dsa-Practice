import java.util.ArrayDeque;
import java.util.Scanner;

import javax.management.Query;

//Q (leetcode 542)

//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//The distance between two adjacent cells is 1.
 

// FIND A BETTER SOLUTION THIS ONE IS SLOW
public class NearestZeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[3][3];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < grid.length; i++) {
			System.out.println("enter elements for row "+i);
			for (int j = 0; j < grid[i].length; j++) {
				System.out.println("enter ele "+j);
			    int val=sc.nextInt(); 
				grid[i][j]=val;
			}
			//System.out.println();
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					System.out.println("calling");
					grid[i][j] = nearestZero(grid, i, j);
				}
			}
		}
		

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static int nearestZero(int[][] grid, int i, int j) {
		ArrayDeque<Pair> que = new ArrayDeque<>();
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		int count = 0;
		
		que.add(new Pair(i, j, 0));
   
		while (!que.isEmpty()) {
			
			Pair currEle = que.remove();
			int r=currEle.i;
			int c=currEle.j;		
			int d=currEle.d;
			if (visited[r][c]) {
				continue;
			}

			
			
			visited[r][c] = true;
			
			//System.out.println("current ele "+grid[currEle.i][currEle.j]);
			
			if (grid[r][c] == 0) {
				count = d;
				break;
			}
			
			if (r - 1 >= 0) {
				if (!visited[r - 1][c]) {
					que.add(new Pair(r - 1,c,d + 1));
				}
			}
			if (r + 1 <= grid.length - 1) {
				if (!visited[r + 1][c]) {
					que.add(new Pair(r + 1,c,d + 1));

				}
			}
			if (c - 1 >= 0) {
				if (!visited[r][c-1]) {
					que.add(new Pair(r,c- 1,d + 1));

				}
			}
			if (c + 1 <= grid[i].length - 1) {
				if (!visited[r][c+1]) {
					que.add(new Pair(r,c + 1,d + 1));

				}
			}
			System.out.println("que size" + que.size());
		}
		return count;
	}

	public static class Pair {
		int i;
		int j;
		int d;// distance from previous 1 basically to keep track of on the current length of
				// radius in bfs

		Pair(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
	}

}
