package Linked_List;

public class DeleteWithoutHeadPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// its a simple but little tricky to guess at first question
	// you are given the node to be deleted , you have to delete the node from LL
	// without HEAD POINTER , in TC and SC = O(1)
	void deleteNode(Node del) {
		// The concept is Copy the data of node next to del node to the current node. Then, link the del
		// node with node next to next of del node
		
		Node t = del;
		t = t.next;
		del.data = t.data;
		del.next = t.next;
	}

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}
}
