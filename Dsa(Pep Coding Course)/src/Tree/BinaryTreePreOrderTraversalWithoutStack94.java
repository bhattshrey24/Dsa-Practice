package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.BinaryTreePreorderTraversalUsingRecursion144.TreeNode;

public class BinaryTreePreOrderTraversalWithoutStack94 {

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
		
	// ITERATIVE METHOD WITHOUT STACK

	// again using morris algo , I have explained morris algo in
	// "BinaryTreeInorderTraversal94"

	// here there's just 1 difference, i.e if while finding right most element of
	// the left element of root , if we escape "while" due to temp.right == null
	// then
	// just add an extra print/ans.add() statement here and if we exit due to
	// condition
	// temp.right == root dont add print/ans.add() , rest is same
	public List<Integer> preorderTraversalIterativeWithoutStack(TreeNode root) {
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
					ans.add(root.val);
					temp.right = root;
					root = root.left;
				} else {
					// means temp.right was not null , which mean temp.right == root means we
					// escaped the above while loop due to 2nd condition
					temp.right = null;
					if (root.right != null) {
						root = root.right;
					} else {
						break;
						// only case when right of the root is null is when the root is at the last
						// element to be
						// executed in which case simply move out of loop
					}
				}
			}
		}
		return ans;
	}

}
