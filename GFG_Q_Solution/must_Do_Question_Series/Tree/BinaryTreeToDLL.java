package Tree;

import java.util.List;

public class BinaryTreeToDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//REMEBER - Inorder traversal of a BST results in sorted list

// https://www.youtube.com/watch?v=cgsGrbRPH6I this guy also explained my solution	

// the idea behind is quite simple , since we want DLL in inorder fashion so we will traverse tree in inorder way , and while traversing just dosome simple steps , i.e. keep a "prevNode" and "head" pointer if prevNode is null and you are in the "Work" area of inorder traversal means current node is the first node of the DLL so simply make prevNode and head point to it , then for every next node simply point next of "PrevNode" to "current" node and prev of current node to prevNode  

// you dont have to worry about "will I be able to traverse in inorder way since i'm changing the left and right pointer of each node" cause you are changing it after traversing that branch and you will come back because of stack fall of recursion and not because of any pointer so no problem	

	Node bToDLL(Node root) {
		inorderTraversal(root);
		prevNode = null;// do this so that it can pass all multiple test case otherwise since prevNode
						// is
						// static therefore the gfg compiler
						// will take previous testcase value of "prevNode" for current testCase "prevNode"
		return head;
	}

	static Node prevNode = null;
	static Node head = null;

	public static void inorderTraversal(Node root) {// this same code will work for "converting bst to sorted DLL"
		if (root == null) {
			return;
		}
		
		inorderTraversal(root.left);
		// Work area
		if (prevNode == null) {// means current node is the left most node of the tree
			prevNode = root;
			head = root;
		} else {
			root.left = prevNode;
			prevNode.right = root;
			prevNode = root;// dont forget to change the prevNode
		}

		inorderTraversal(root.right);

	}

	class Node {
		Node left, right;
		int data;

		Node(int d) {
			data = d;
			left = right = null;
		}

	}
}
