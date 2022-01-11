package Tree;

import Tree.BottomViewOfBinaryTree.Node;

public class LowestCommonAncestorInABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

// its quite easy 
	
// since its bst therefore we dont have to search whole tree just the height of tree at max
// we will simply solve it using recursion

// Now there are just 3 possibilities 
//1) n1 and n2 both lie in the left side of current root , in this case go left of current root

//2) n1 and n2 both lie in the right side of current root , in this case go right of current root

//3) n1 and n2 both lie on opposite sides of current root , in this case the current root is your answer (i.e. Lowest common ancestor)cause n1 and n2 lies on left and right subtree of the current root and since its tree and not graph therefore both left and right subtree will not intersect after this point i.e. current root 

// it is promised that all values are unique
	Node LCA(Node root, int n1, int n2) {
		if (root.data == n1 || root.data == n2) {// this is the base case , and its not necessary that you will always
													// reach it (i.e. when "else" case written below is executed).This
													// base case is just to stop the recursive call of "if" and "else
													// if" statement below

			// this means both were on same side and we found one of them which means its
			// the LCA of n1 and n2
			// just see example 1 of gfg
			return root;
		}
		if (n1 <= root.data && n2 <= root.data) {
			return LCA(root.left, n1, n2);
		} else if (n1 >= root.data && n2 >= root.data) {
			return LCA(root.right, n1, n2);
		} else {// when n1 <= root.data && n2 >= root.data or vice versa
			return root;// current root is the answer i.e. LCA
		}
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
