package Tree;

public class MaximumPathSumBetween2LeafNodes {

	public static void main(String[] args) {
	}

// NOT WORKING FIX

//for logic https://www.youtube.com/watch?v=ArNyupe-XH0 
// for code https://www.youtube.com/watch?v=28QR-eRFE4I	
	int maxPathSum(Node root) {
		Res res = new Res();
		res.val = Integer.MIN_VALUE;
		if (root == null) {// cause null means theres no branch further so sum is 0 from here cause 0 is
							// identity for addition so since this branch reached end so what else can youu
							// return wchich will not affect the answer?
			return 0;
		}
		rec(root, res);
		return res.val;
	}

	public int rec(Node node, Res res) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.data;
		}
		int lsb = rec(node.left, res);
		int rsb = rec(node.right, res);

		if (node.left != null && node.right != null) {
			res.val = Math.max(res.val, lsb + rsb + node.data);
			return Math.max(lsb, rsb) + node.data;
		}
		return (node.left == null) ? rsb + node.data : lsb + node.data;

	}

	class Res {// this is much better than keeping a static "max" variable
		int val;
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
