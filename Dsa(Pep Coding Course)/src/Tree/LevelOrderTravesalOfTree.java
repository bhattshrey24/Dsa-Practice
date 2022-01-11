package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravesalOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {// case when root is null i.e. tree is null
			return ans;
		}

		// ALGO Here is nor RM*WA* but algo is Remove , Print/Work , Add Next .Since
		// here we dont keep track of visited nodes cause we cant come up because tree
		// is
		// unidirectional i.e. goes from top to bottom unlike graph

		Queue<Pair> q = new ArrayDeque<Pair>();
		q.add(new Pair(root, 0));

		while (!q.isEmpty()) {
			int size = q.size();// at any point of time q.size is equal to the number of elements/nodes in
								// current
								// level , therefore we only run the loop till size becomes 0 and in this
								// process if there is one more level then current level nodes will add them and
								// next time loop will run for that level nodes

			while (size != 0) {
				Pair rem = q.remove();// Remove

				if (ans.size() < (rem.height + 1)) { // Print or work . In "ans" list , index stores the List having
														// answer
														// for that level(level=index+1 and index=height) , there
														// fore rem.height is the
														// index to which
														// "rem" belongs to,
														// (rem.height + 1) is level correspoinding to
														// rem.height

					List<Integer> list = new ArrayList<>();// here since we have to initialze list there fore i putted
															// this if else to check if we already initialized list for
															// current answer index or not
					list.add(rem.node.val);
					ans.add(list);
				} else {
					List<Integer> prevList = ans.get(rem.height);// means we already putted one or more node of this
																	// level in ans list so no need to reinitialize the
																	// list
					prevList.add(rem.node.val);
					ans.set(rem.height, prevList);
				}

				if (rem.node.left != null) {// Add children
					q.add(new Pair(rem.node.left, rem.height + 1));// rem.height+1 cause we going deeper
				}
				if (rem.node.right != null) {
					q.add(new Pair(rem.node.right, rem.height + 1));
				}
				size--;
			}
		}

		return ans;
	}

	public class Pair {
		TreeNode node;
		int height;

		public Pair(TreeNode node, int height) {
			this.node = node;
			this.height = height;
		}
	}

	public class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
