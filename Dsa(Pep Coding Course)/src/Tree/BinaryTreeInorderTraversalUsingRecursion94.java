package Tree;

import java.util.*;

import Tree.BinaryTreePostOrderTraversalUsingRecursion145.TreeNode;

public class BinaryTreeInorderTraversalUsingRecursion94 {

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
		System.out.println(inorderTraversal(root));
	}
	
	// In inorder we process :- LNR(i.e Left , Node , Right)

	// RECURSIVE WAY

	static List<Integer> ans = new ArrayList<>();

	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return ans;
		}
		inorderTraversal(root.left);
		ans.add(root.val);
		inorderTraversal(root.right);
		return ans;
	}

	public static class TreeNode {
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
