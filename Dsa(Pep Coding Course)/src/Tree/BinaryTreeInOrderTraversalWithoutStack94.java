package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.BinaryTreeInorderTraversalUsingRecursion94.TreeNode;

public class BinaryTreeInOrderTraversalWithoutStack94 {

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
	// In inorder we process :- LNR(i.e Left , Node , Right)

	// ITERATIVE METHOD WITHOUT STACK

	// this is not the normal binary tree traversal its using "Morris algorithm" it
	// has better Space complexity
	// the concept of this algo is that the last element to be executed in a tree or
	// subtree is the right most element of that tree , so problem in using
	// iterative method is that we can't go back to our parent and if we keep parent
	// array then Space complex. increases , therefore what if we use this right
	// most element of the subtree and make a backedge from it so that when we
	// process it and since its the last element to be processed in a subtree we can
	// reach to our root so now we can go to other subtree
	// Tc=O(N) , Sc=O(N)

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {// for test case where tree is empty , i.e no node
			return ans;
		}

		while (true) {// simply an iterative method and not a recursive one
			if (root.left == null) {

				ans.add(root.val);

				if (root.right != null) {
					root = root.right;
				} else {
					break;// only case when right of the root is null is when the root is at the last
					// element to be
					// executed in which case simply move out of loop
				}
			} else {
				TreeNode temp = root.left;

				while (temp.right != null && temp.right != root) {
					temp = temp.right;
				}

				if (temp.right == null) {// this is to identify that due to which of the 2 condition we escaped the
											// while loop above
					temp.right = root;
					root = root.left;
				} else {// means temp.right was not null , which mean temp.right == root means we
						// escaped the above while loop due to 2nd condition
					ans.add(root.val);
					temp.right = null;
					if (root.right != null) {
						root = root.right;
					} else {
						break;// only case when right of the root is null is when the root is at the last
						// element to be
						// executed in which case simply move out of loop
					}
				}
			}
		}
		return ans;
	}
}
