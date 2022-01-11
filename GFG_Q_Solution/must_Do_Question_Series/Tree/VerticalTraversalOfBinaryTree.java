package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class VerticalTraversalOfBinaryTree {

	public static void main(String[] args) {

	}
	// for understanding the problem see this
	// https://www.youtube.com/watch?v=kqHNP6NTzME (this shows solution for
	// leetcode)
	// for code see this https://www.youtube.com/watch?v=LscPXvD1N1A (this shows
	// solution for gfg)

	// both geeks and leetcode want some changes like in leet code if coordinates
	// are same we need elements in sorted order and in gfg input is weird but the
	// algo below is correct

	static ArrayList<Integer> verticalOrder(Node root) {

		ArrayList<Integer> ans = new ArrayList<>();
		if(root==null){
		    return ans;
		}
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();// cause we dont know home much wide this tree is and
																	// since we taking root as 0 there vertical line on
																	// left become -ve there fore we cant use arraylist
																	// directly either

		int minHor = 0, maxHor = 0;// this so that i can know how wide the tree is so that later i can convert the
									// answer
									// to arraylist, and they are initialized with 0 cause i assumed root as 0th
									// vertical line , on left of it is negative and on right of it is positive

		Queue<Pair> q = new ArrayDeque<Pair>();

		q.add(new Pair(root, 0));
// Basically we gave root as vertical line 0 and we put parent in arrayList corresponding to its vLine  in map and we call left child with parent.vLine-1 and right child with parent.vLine+1 and then in start  ,we do this while doing level order traversal cause we want that if elements have same coordinate that is same vLine and height then they should be added in answer in order of their occurance from left to right 

		while (!q.isEmpty()) {// WE do BFS traversal

			int size = q.size();

			while (size != 0) {
				Pair rem = q.remove();// Remove

				minHor = Math.min(minHor, rem.vLine);// so that later we can calculate the width of the tree
				maxHor = Math.max(maxHor, rem.vLine);

//				hm.putIfAbsent(rem.vLine, new ArrayList<>());
//				hm.get(rem.vLine).add(rem.node.data);
				if (!hm.containsKey(rem.vLine)) {// WORK
					ArrayList<Integer> newList = new ArrayList<Integer>();
					newList.add(rem.node.data);
					hm.put(rem.vLine, newList);
				} else {
					ArrayList<Integer> list = hm.get(rem.vLine);
					list.add(rem.node.data);
					hm.put(rem.vLine, list);
				}

				if (rem.node.left != null) {// ADD Children
					q.add(new Pair(rem.node.left, rem.vLine - 1));
				}
				if (rem.node.right != null) {
					q.add(new Pair(rem.node.right, rem.vLine + 1));
				}

				size--;
			}
		}

		for (int i = minHor; i <= maxHor; i++) {// simply add vertical lines from left most side to right most side
			ArrayList<Integer> list = hm.get(i);
			int j = list.size();
			while (j != 0) {// converting our hm value to arrayList
				ans.add(list.get(j));
				j--;
			}
		}
		return ans;
	}

	public static class Pair {
		Node node;
		int vLine;// i.e. vertical line

		public Pair(Node node, int vLine) {
			this.node = node;
			this.vLine = vLine;
		}
	}

	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
}
