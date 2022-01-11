package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.BinaryTreeInorderTraversalUsingRecursion94.TreeNode;

public class BinaryTreeInOrderTraversalUsingStack94 {

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

	// ITERATIVE METHOD WITH STACK

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) {
			return ans;
		}
		TreeNode currentNode = root;
		stack.add(currentNode);// adding root so that we can go inside while loop and start execution
		while (!stack.isEmpty()) {
			while (currentNode != null) {
				currentNode = currentNode.left;// we keep moving left of current node till we reach null , reaching null
												// means we added the left most child of current node in stack

				if (currentNode != null) {// this is to save us from adding null object i.e left child of left most
											// child of current node , i.e. when current node becomes null while
											// travelling
					stack.add(currentNode);
				}
			}

			if (!stack.isEmpty()) {// we only perform when stack is not empty cause we first add element to be
									// processed in stack and then process it , if stack is empty means no element
									// left to process

				TreeNode popped = stack.pop();// popped element will be the node in LNR cause thats how inorder works
												// first go to end in left then come back to node , add it and then go
												// to right

				ans.add(popped.val);// add it to answer , since its in order to after travelling left we come back
									// to node add it to answer and then go to right

				currentNode = popped.right;// go to right of Node

				if (currentNode != null) {// if right is not null then add it in stack so that we can process it in next
											// iteration
					stack.add(currentNode);
				}
			}

		}

		return ans;

	}

}
