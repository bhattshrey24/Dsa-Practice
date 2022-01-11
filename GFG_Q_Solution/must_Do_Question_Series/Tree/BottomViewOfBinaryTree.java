package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//First see VerticalTraversalOfBinaryTree cause for this question you just have to change one thing

// Must watch https://www.youtube.com/watch?v=kCQJTAqbExg&t=3s
// If you observe vertical traversal you will see that the bottom view is nothing but the last element of each arraylist of each verticalLine , so instead of putting arraylist simply put a single integer and keep over writing it cause we just need the last value

	public ArrayList<Integer> bottomView(Node root) {

		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();// see instead of keeping arraylist as value i just putted
														// Integer

		int minHor = 0, maxHor = 0;
		Queue<Pair> q = new ArrayDeque<Pair>();

		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {

			int size = q.size();

			while (size != 0) {
				Pair rem = q.remove();// Remove

				minHor = Math.min(minHor, rem.vLine);// so that later we can calculate the width of the tree
				maxHor = Math.max(maxHor, rem.vLine);

				hm.put(rem.vLine, rem.node.data);// since here we dont have to care about initializing arraylist
													// therefore simply this one statement works , if its present it
													// will update otherwise it will put new value

				if (rem.node.left != null) {// ADD Children
					q.add(new Pair(rem.node.left, rem.vLine - 1));
				}
				if (rem.node.right != null) {
					q.add(new Pair(rem.node.right, rem.vLine + 1));
				}

				size--;
			}
		}

		for (int i = minHor; i <= maxHor; i++) {
			ans.add(hm.get(i));
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
