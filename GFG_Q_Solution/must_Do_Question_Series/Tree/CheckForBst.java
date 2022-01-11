package Tree;

import java.util.List;

import Tree.CheckForBst.BSTPair;
import Tree.LetView.Node;

public class CheckForBst {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static void main(String[] args) {

	}

	int max;
	int min;

// Must watch video https://www.youtube.com/watch?v=kMrbTnd5W9U

//for a node to be bst All elements on its left should be smaller than it (observe its All and not immediate left ) and All elements on its right should be bigger than it	

// i guess this code can work for duplicates too

	// Function to check whether a Binary Tree is BST or not.
	
	boolean isBST(Node root) {
		return BSTPairCheck(root).isBst;// since in the last node we will have wether the whole tree is bst or not
	}

	public static BSTPair BSTPairCheck(Node node) {// we do work in post order since in post order node is accessed
													// after accessing both children and thats what we want in BST

		if (node == null) {
			BSTPair bp = new BSTPair();
			bp.max = Integer.MIN_VALUE;
			bp.min = Integer.MAX_VALUE;
			bp.isBst = true;// null node is always a BST since theres nothing to compare so it can be a bst
							// or not so why not assume that it is a bst
			return bp;
		}

		BSTPair lsb = BSTPairCheck(node.left); // lsb = left sub tree of current tree
		BSTPair rsb = BSTPairCheck(node.right);

		BSTPair ct = new BSTPair();// ct= current tree

		// NOTE , somehow in geek for geek node.data >= lsb.max and node.data <= rsb.min
		// is giving error but in theory bst can have equal values too , without "=" the
		// code is passing in gfg
		ct.isBst = lsb.isBst && rsb.isBst && (node.data >= lsb.max && node.data <= rsb.min);

		// lsb.isBst means your left
		// subtree is a bst ,
		// node.data > lsb.max means
		// you are bigger than all
		// elements on your left sub
		// tree

		ct.min = Math.min(node.data, Math.min(lsb.min, rsb.min));// this is for my parent ,"rsb.min" is for my parent
																	// cause I can be left child of my parent or right
																	// we dont know that , that is smallest value till
																	// now ,i.e. am I smallest or is there a smaller
																	// value
																	// in my left subtree or in my right subtree

		ct.max = Math.max(node.data, Math.max(lsb.max, rsb.max));// "lsb.max" is for my parent i.e. if i'm right child
																	// of
																	// parent so my parent need the max value from its
																	// right , so max
																	// can be me or in my left sub tree or in my right
																	// sub tree therefore i need lsb.max
		return ct;
	}

	public static class BSTPair {
		boolean isBst;
		int min;
		int max;

	}
}
