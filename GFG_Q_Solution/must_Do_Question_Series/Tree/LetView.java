package Tree;

import java.util.ArrayList;

public class LetView {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<Integer> ans = new ArrayList<>();
	int maxHeight = -1;// -1 so that root can also be printed

	ArrayList<Integer> leftView(Node root) {
		recTraversal(root, 0);// calling with current height =0
		return ans;
	}

	public void recTraversal(Node root, int currHeight) {
		if (root == null) {
			return;
		}

		if (currHeight > maxHeight) {// I putted if statement here cause if there are 2 node one on left and one or
										// right at
										// same
										// height then we have to print the left one i.e. we have to do work while
										// building stack, and only print if it's at a height
										// more than max height which means we haven't reached this deep before , and
										// since i putted if statement first and we know recursion goes on left
										// first therefore it will print the left node rather than the right node on
										// same height
			ans.add(root.data);
			maxHeight = currHeight;// upgrade the height
		}
		recTraversal(root.left, currHeight + 1);
		recTraversal(root.right, currHeight + 1);

	}
}
