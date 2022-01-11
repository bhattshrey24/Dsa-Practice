package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Tree.BottomViewOfBinaryTree.Node;

public class LevelOrderTraversalInSpiralForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//Must watch https://www.youtube.com/watch?v=eDdPZ05y4Os

	ArrayList<Integer> findSpiral(Node root) {// Pep coding sir solution
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}

		Stack<Node> mainSt = new Stack<>();// observe its stack not queue
		Stack<Node> childStack = new Stack<>();
		Stack<Node> temp;// just to swap main stack with child stack
		boolean flip = false;
		mainSt.add(root);
		while (!mainSt.isEmpty()) {
			int size = mainSt.size();
			while (size != 0) {
				if (flip) {// add left child first then right
					Node rem = mainSt.pop();// Remove
					ans.add(rem.data);
					if (rem.left != null) {// ADD Children
						childStack.add(rem.left);
					}
					if (rem.right != null) {
						childStack.add(rem.right);
					}

				} else {// add right child first then left
					Node rem = mainSt.pop();// Remove
					ans.add(rem.data);
					if (rem.right != null) {
						childStack.add(rem.right);

					}
					if (rem.left != null) {// ADD Children
						childStack.add(rem.left);

					}

				}

				size--;

			}
			flip = flip == true ? false : true;
			//swapping stacks
			temp = mainSt;
			mainSt = childStack;
			childStack = temp;
		}

		return ans;

	}

}
