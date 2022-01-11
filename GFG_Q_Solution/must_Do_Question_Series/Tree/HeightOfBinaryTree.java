package Tree;

public class HeightOfBinaryTree {

	public static void main(String[] args) {

	}

	// we just have to find the height of given tree
	// its simple , the height is basically Math.max(height of left sub tree ,
	// height of right sub tree)

	int height(Node node) {
		int max = 0;// least value height can take is 0

		if (node == null) {// means theres no tree so height is null
			return 0;
		}
		max = rec(node, 0, max);// return the max height
		return max;
	}

	public static int rec(Node node, int height, int max) {
		if (node == null) {// means you reached the last node of current branch so return the height of the
							// branch
			return height;
		}
		int lsb = rec(node.left, height + 1, max);// lsb stands for height of left sub tree
		int rsb = rec(node.right, height + 1, max);// rsb stands for height of right sub tree

		return Math.max(lsb, rsb);// return whichever is max of lsb and rsb , here we dont have to do +1 cause we
									// return height when null is reached basically we added height of null too
									// therefore no need to add +1 for root
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
