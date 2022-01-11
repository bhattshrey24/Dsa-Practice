package Tree;

public class DetermineIfTwoTreesAreIdentical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

// its quite simple
	boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {// base case 1

			return true;// means height of this branch is same in both trees so return true cause it may
						// mean that
						// they both are same (but this is not completely correct answer cause we just
						// checked the structural aspect of the trees , so we are assuming that they are
						// same based on structural aspect and if it is not same based on value
						// aspect(i.e. value of node at same level is not same) then the return
						// statement in the end of this function will handle that part)
		}
		if (root1 == null && root2 != null) {// base case 2
			return false;// means height of this branch is not same in both trees , therefore simply
							// return false
		}
		if (root1 != null && root2 == null) {// base case 3
			return false;// means height of this branch is not same in both trees , therefore simply
							// return false
		}

		return ((isIdentical(root1.left, root2.left)) && ((isIdentical(root1.right, root2.right)))
				&& (root1.data == root2.data));
		// now here the
		// concept is that
		// 2 trees are same
		// if the left sub
		// tree of both the trees
		// are same , the
		// right sub tree of
		// both trees are
		// same and the
		// value of root Node is
		// same in both
		// trees

		// leap of faith is that (isIdentical(root1.left, root2.left)) this will return
		// whether the left subtree of current node is same in both trees or not
		// similarly for right side current node will be handled by
		// ((isIdentical(root1.right, root2.right)) and this (root1.data == root2.data)
		// will check whether current node is same

	}

	class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}
}
