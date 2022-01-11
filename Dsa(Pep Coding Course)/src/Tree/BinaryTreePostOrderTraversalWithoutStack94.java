package Tree;

import java.util.ArrayList;
import java.util.List;

import Tree.BinaryTreeInorderTraversalUsingRecursion94.TreeNode;

public class BinaryTreePostOrderTraversalWithoutStack94 {

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
		System.out.println(postorderTraversal(root));
	}
//  In postorder we process :- LRN(i.e Left , Right ,Node )

	// ITERATIVE METHOD WITHOUT USING STACK

		// its. not possible using morris algo , but theres jugad if you are asked just
		// to print post order traversal , sir explained in video but its not that
		// usefull since its only used for printing and its a jugad
	
	//Fix it , its wrong
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {// for test case where tree is empty , i.e no node
			return ans;
		}

		while (true) {// simply an iterative method and not a recursive one
			if (root.right == null) {

				ans.add(root.val);

				if (root.left != null) {
					root = root.left;
				} else {
					break;// only case when right of the root is null is when the root is at the last
					// element to be
					// executed in which case simply move out of loop
				}
			} else {
				TreeNode temp = root.right;

				while (temp.left != null && temp.left != root) {
					temp = temp.left;
				}

				if (temp.left == null) {// this is to identify that due to which of the 2 condition we escaped the
										// while loop above
					temp.left = root;
					root = root.right;
				} else {// means temp.right was not null , which mean temp.right == root means we
						// escaped the above while loop due to 2nd condition
					ans.add(root.val);
					temp.left = null;
					if (root.left != null) {
						root = root.left;
					} else {
						break;// only case when right of the root is null is when the root is at the last
						// element to be
						// executed in which case simply move out of loop
					}
				}
			}
		}
		
		List<Integer> ReverseAns = new ArrayList<>();
		for(int i=ans.size()-1;i>0;i--) {
			ReverseAns.add(ans.get(i));
		}
		return ReverseAns;
	}
}
