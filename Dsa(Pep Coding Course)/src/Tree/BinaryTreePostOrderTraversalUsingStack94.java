package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Tree.BinaryTreePostOrderTraversalUsingRecursion145.TreeNode;

public class BinaryTreePostOrderTraversalUsingStack94 {

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
	
//  In postorder we process :- LRN(i.e Left , Right ,Node )

	// ITERATIVE METHOD WITH STACK (MY WAY)

	public static List<Integer> postorderTraversalWithStack(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null) {
			return ans;
		}

		// prev keeps track of previous element we processed , and currentNode keeps
		// track of current element we are processing
		TreeNode prev = root;// initially let prev point to root and not null cause if you make it point to
								// null then it
								// might create problem in the innner while loop since its possible that right
								// of root is null in that case it will think that its currentNode.right == prev
								// (which is null)
								// and dont go in loop

		TreeNode currentNode = root;

		stack.add(currentNode);

		while (!stack.isEmpty()) {

			while (currentNode != null && ((currentNode.right != prev) && (currentNode.left != prev))) {// ((currentNode.right
																										// != prev) &&
																										// (currentNode.left
																										// != prev)) if
																										// any of the
																										// previous 2
																										// condition is
																										// true , it
																										// means we are
																										// backtracking
																										// , in which
																										// case we dont
																										// want to go
																										// again to left
																										// side

				currentNode = currentNode.left;

				if (currentNode != null) {
					stack.add(currentNode);
				}
			}

			if (!stack.empty()) {// if we are inside this , we can safely assume that left side of current node
									// is either already
									// travelled or is null

				if (stack.peek().right == null || stack.peek().right == prev) {// if we are in this loop means either we
																				// have travelled right or its null,
																				// this time we wont pop directly ,
																				// first well check if right is there
																				// or if yes is it vsited or not and
																				// if conditions met then we pop it

					TreeNode popped = stack.pop();

					ans.add(popped.val);

					prev = popped;// now the popped element becomes the previous one , this helps us to not go
									// back in above while loop

					if (!stack.isEmpty()) {
						currentNode = stack.peek();// now the top element of the stack is basically the one we want to
													// process next

					} else {
						currentNode = null;// if stack is empty then stack.peek() will give error
					}
				} else {// case when right is not empty , in this case we dont pop , instead we go to
						// right
					prev = stack.peek();// current top element will become prev
					stack.add(stack.peek().right);// now on top there is the right child of prev
					currentNode = stack.peek();// top most element of stack is now you currentNode ,i.e. next node to be
												// processed
				}
			}
		}
		return ans;
	}
}
