package Tree;

public class BST_Implementation {
	private BstNode root;

	public BST_Implementation() {
		root = null;
	}

	class BstNode {
		BstNode left, right;
		int data;// in bst data is generally called as 'key' , but i'm using 'data'

		BstNode(BstNode left, int data, BstNode right) {
			this.left = left;
			this.data = data;
			this.right = right;
		}

	}

	public BstNode getRoot() {
		return root;
	}

	public void insertNodeRecursively(int data) {// just a layer of abstraction , so that user doesn't
		// have to deal with root

		root = insertNodeRecursivelyImplementation(root, data); // setting root

	}

	private BstNode insertNodeRecursivelyImplementation(BstNode root, int data) {
		// If u having confusion then just run it for root node it's left child and it's
		// right child and have leap of faith

		if (root == null) {// base case i.e. tree with no node then simply insert one and make root point
							// to it , or u can think it this way that while traversing u reached the end of
							// the branch where the new node is suppose to be
			root = new BstNode(null, data, null);
			return root;
		}

		if (data <= root.data)
			root.left = insertNodeRecursivelyImplementation(root.left, data);// have leap of faith that this function
																				// will return the
		// root node of left subtree and then u can point
		// current node's left pointer to it
		else if (data > root.data)
			root.right = insertNodeRecursivelyImplementation(root.right, data);// have leap of faith that this function
																				// will return
		// the
		// root node of right subtree and then u can point
		// current node's right pointer to it

		return root; // simply return the root node

	}

	public void insertNodeIteratively(int data) {

		BstNode newNode = new BstNode(null, data, null);

		if (root == null) { // this means this node is the first node of the tree
			root = newNode;
			return;
		}

		BstNode prev = null;// prev is pointing to parent of 'temp' node therefore it is initialized with
							// null
							// cause parent of root node is null
		BstNode temp = root;

		while (temp != null) {// 'temp != null' cause end tk pohochna hai uss branch ke where current node is
								// suppose to be placed

			if (temp.data >= data) {
				prev = temp;// current node ko parent bnao
				temp = temp.left;
			} else if (temp.data < data) {
				prev = temp;
				temp = temp.right;
			}
		}

		if (prev.data > data)
			prev.left = newNode;
		else
			prev.right = newNode;
	}

	public BstNode searchNodeRec(BstNode root, int key) {

		if (root == null) {// if we reached end of any branch means we havent found the element
			System.out.println("Node Not found");
			return null;
		} else if (root.data == key) {
			System.out.println("Node found");
			return root;
		} else if (root.data >= key) {
			return searchNodeRec(root.left, key);// have faith that recursion will find whether it is present in left
													// subtree or not
		} else {
			return searchNodeRec(root.right, key);
		}
	}

	public void deleteNode(int data) {// this just calls deleteNodeRec
		// see this https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
		// when deleting there are 3 cases:
		// 1) Node to be deleted is the leaf then Simply remove from the tree.
		// 2) Node to be deleted has only one child: Copy the child to the node and
		// delete the child
		// 3) Node to be deleted has two children: Find inorder successor of the node.
		// Copy contents of the inorder successor to the node and delete the inorder
		// successor. Note that inorder predecessor can also be used.

		root = deleteRec(root, data);// simply reset the root cause its possible that user wanted to delete the root
										// element in which case we will have new root

	}

	private BstNode deleteRec(BstNode node, int data) {// initially node will be the root element

		// it might look scary but just dry run it for a small tree

		if (node == null)/* Base Case: If the tree is empty */
			return node;

		/* Otherwise, recur down the tree */

		// first we will find the node which needs to be deleted
		if (data < node.data)
			node.left = deleteRec(node.left, data); // root of the left subtree might change after deletion , so have
													// faith that recursion will give u the root of the new left subtree
													// so simply again join it to left of current node
		else if (data > node.data)
			node.right = deleteRec(node.right, data);

		else {
			// this means we FOUND the element i.e. current node is the one that is to
			// be deleted

			// case 3 : node with 2 children
			if (node.left != null && root.right != null) {

				int lmax = maxNode(node.left);// this will return the max element in left subtree of current node

				node.data = lmax;// instead of deleting current node and again making new one and making all the
									// connection simply replace
									// the data which is to be deleted with lmax

				node.left = deleteRec(node.left, lmax);// since we gave max value from right sub tree to current node so
														// now we simply have to delete it from the left subtree and
														// assign
														// the new root of left subtree to left of current node

				return node;

				// case 2 : node with only 1 children
			} else if (node.left == null) {// when current node only have right node

				return node.right;// simply return the right node so that it can be attached to the parent of the
									// current node which is the node to be deleted

			} else if (node.right == null) {// when current node only have left node
				return node.left;

				// case 1 : no child i.e. element to be deleted is the leaf node
			} else {
				return null;// returning null works perfectly just give it a dry run
			}
		}

		return node;
	}

	private int maxNode(BstNode node) {// we just have to travel to the right most element
		if (node.right == null) {// means current element is the right most element
			return node.data;
		} else {
			return maxNode(root.right);// simply have leap of faith that recursion will go in right subtree and return
										// the max element
		}
	}

	public void displayInOrder(BstNode root) { // In bst inorder always results in sorted array
		if (root == null) {
			return;
		}
		displayInOrder(root.left);
		System.out.print(root.data + " ");
		displayInOrder(root.right);
	}

}
