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

	public void deleteNode(int data) {

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
