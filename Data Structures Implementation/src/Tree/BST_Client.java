package Tree;

public class BST_Client {

	public static void main(String[] args) {
		BST_Implementation bst = new BST_Implementation();

		bst.insertNodeRecursively(20);
		bst.insertNodeRecursively(30);
		bst.insertNodeRecursively(50);
		bst.insertNodeRecursively(70);
		bst.insertNodeRecursively(40);
		bst.insertNodeRecursively(90);
		bst.insertNodeRecursively(80);
		bst.insertNodeRecursively(60);

		bst.displayInOrder(bst.getRoot());
		System.out.println();
		bst.searchNodeRec(bst.getRoot(), 70);
		bst.searchNodeRec(bst.getRoot(), 71);
		bst.deleteNode(50);
		bst.displayInOrder(bst.getRoot());

	}

}
