package Linked_List;

public class PairwiseSwapElementsOfALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node pairwiseSwap(Node head) {
		// 4 pointers are required 1 to keep track of previous swapped group of 2 , 3 to
		// swap current group of 2

		if (head.next == null) {// when theres just 1 node
			return head;
		}
		if (head.next.next == null) {// when there are just 2 node in LL
			Node t = head;
			head = head.next;
			;
			head.next = t;
			t.next = null;
			return head;

		}

		Node p1 = head;
		Node p2 = p1.next;
		Node p3 = p2.next;
		Node prev = null;
		while (p3 != null) {
			p2.next = p1;
			p1.next = p3;
			if (p1 == head) {// this is when we swapping the first group , then simply the second element
								// becomes the first so make it the head of the whole LL
				head = p2;
			}

			if (prev != null) {// this is also when we swapping 1st group prev is null so prev.next will give
								// error

				prev.next = p2;
			}

			prev = p1;
			p1 = p3;
			p2 = p1.next;
			// there are 2 cases that is when list has odd size and when it has even
			if (p2 != null) {
				p3 = p2.next;
			} else {// this means that p2 was null which means there are odd number of elements in
					// LL
				break;
			}
		}
		if (p2 != null) { // if we are out of loop and p2 is not null means size is even so we have to
							// join this last group outside the while loop
			p2.next = p1;
			p1.next = null;
			prev.next = p2;

		}

		return head;
	}

	static class Node {
		int data;
		Node next;

		Node(int key) {
			data = key;
			next = null;
		}
	}
}
