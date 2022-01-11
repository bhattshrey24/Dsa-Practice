package Tree;

import java.util.ArrayDeque;

import java.util.Queue;


public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

// In this question you just have to connect each node at every level with a node on its immediate right on the same level.

	public void connect(Node root) {
// The idea behind the algo is that simply do level order traversal , and just keep reference of previous node executed on same level cause you just need  to connect previous node's "rightNode" pointer with current node .  
	
		Queue<Node> q = new ArrayDeque<Node>();

		q.add(root);
		Node prevNode = null;
		
		while (!q.isEmpty()) {
			int size = q.size();

			while (size != 0) {
				Node rem = q.remove();// Remove

				// WORK
				if (prevNode == null) {// null means that this is the first node we are executing on the current level
					prevNode = rem;
				} else {
					prevNode.nextRight = rem;
					prevNode = rem;// dont forget to update prevNode
				}

				// ADD Children
				if (rem.left != null) {
					q.add(rem.left);
				}
				if (rem.right != null) {
					q.add(rem.right);
				}

				size--;
			}
			prevNode = null;// do this so that we can start fresh for the new level
		}

	}

	class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
			nextRight = null;
		}
	}
}
