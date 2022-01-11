package Tree;

import Tree.CheckForBst.Node;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// its similar to "Detemine if two trees are identical" , see that question i
	// have explained some extra things there
	// https://www.youtube.com/watch?v=XV7Sg2hJO3Q

	// the question is pretty much same , here simply divide the current tree to 2
	// subtrees and check if these 2 are mirror image of each other or not

	// for being mirror image the left side of left subtree should be same as right
	// side of right subtree && right side of left subtree should be same as left
	// side of right subtree
	public static boolean isSymmetric(Node root) {
		if (root == null) {
			return true;
		}
		return rec(root.left, root.right);
	}

	public static boolean rec(Node n1, Node n2) { // n1 is left subtree and n2 is right subtree
		if (n1 == null && n2 == null) {
			return true;// this assures that structure is same
		}
		if (n1 != null && n2 == null) {
			return false;
		}
		if (n1 == null && n2 != null) {
			return false;
		}

		return ((rec(n1.left, n2.right)) && ((rec(n1.right, n2.left))) && (n1.data == n2.data));
		// (rec(n1.left, n2.right)) checks whether left side of left subtree is same as
		// right side of right sub tree
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
