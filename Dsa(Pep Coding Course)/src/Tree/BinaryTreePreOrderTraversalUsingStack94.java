package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.BinaryTreePreorderTraversalUsingRecursion144.TreeNode;

public class BinaryTreePreOrderTraversalUsingStack94 {

	public static void main(String[] args) {
		TreeNode child1 = new TreeNode(3, null, null);
		TreeNode child2 = new TreeNode(2, child1, null);
		TreeNode root = new TreeNode(1, null, child2);
		
//		TreeNode child1 = new TreeNode(8, null, null);
//		TreeNode child2 = new TreeNode(7, child1, null);
//		TreeNode child3 = new TreeNode(6, null, null);
//		TreeNode child4 = new TreeNode(5, child3, null);
//		TreeNode child5 = new TreeNode(4, child4, child2);
//		TreeNode child6 = new TreeNode(11, null, null);
//		TreeNode child7 = new TreeNode(3, child6, null);
//		TreeNode child8 = new TreeNode(2, child7, child5);
//		TreeNode root = new TreeNode(1, child8, null);
	}
	
    //  In preorder we process :- NLR(i.e Node ,Left , Right )
	
	// ITERATIVE METHOD WITH STACK

	public static List<Integer> PreorderTraversalWithStack(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return ans;
		}
		// most of the explanaton i have done in inorder , here i only explain the
		// difference
		TreeNode currentNode = root;
		stack.add(currentNode);

		while (!stack.isEmpty()) {
			while (currentNode != null) {
				if (currentNode != null) {// here since its NLR so we add first then move to left
					ans.add(currentNode.val);
				}

				currentNode = currentNode.left;

				if (currentNode != null) {
					stack.add(currentNode);// add it in stack so that we can process its right
				}
			}

			if (!stack.isEmpty()) {
				TreeNode popped = stack.pop();
				currentNode = popped.right;// here we simply move to right and add it to stack so that we can process
											// its
											// left children in next iteration
				if (currentNode != null) {
					stack.add(currentNode);
				}
			}

		}

		return ans;

	}

}
