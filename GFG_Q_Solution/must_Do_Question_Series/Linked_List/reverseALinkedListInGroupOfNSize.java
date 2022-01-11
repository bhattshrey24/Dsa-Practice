package Linked_List;

import Linked_List.Rotate_a_linked_list_by_K.Node;

public class reverseALinkedListInGroupOfNSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Node reverse(Node head, int k) {
		Node temp = head;
		int size = 0;
		while (temp != null) { // finding length of LL
			size++;
			temp = temp.next;

		}
		Node prevTail = null;
		Node newTail = null;
		Node newHead = head;

		int i = 0;
		while (i < (size / k)) {// looping over no of group times

			Node p1 = newHead;
			Node p2 = p1.next;
			Node p3 = p2.next;

			int count = 1;// used so that i reverse only members of the group

			newTail = newHead;// cause newTail will be the head of current group after reversing the group

			while (count < k - 1) {
				if (p1 == newHead) {// cause otherwise head will keep pointing to its next node but in reality head
									// is tail now so it should point to null
					p1.next = null;
				}
				p2.next = p1;
				p1 = p2;// move every pointer to its next position
				p2 = p3;
				p3 = p3.next;
				count++;
			}
			p2.next = p1;// cause last 2 nodes will be left without linking
			newHead = p2;

			if (i == 0) {// since in first group the prevTail is at null therefore prevTail.next=newHead
							// will give error
				prevTail = newTail;
			} else {
				prevTail.next = newHead;// linking the groups
				prevTail = newTail;
			}
			i++;
		}

		// incase left when last group has element != K i.e when size is odd

		if (size % 2 != 0) {// simply reverse the last group normally
			Node p1 = head;// 3 pointers are required
			Node p2 = p1.next;
			Node p3 = p2.next;
			while (p3 != null) {
				if (p1 == head) {// cause otherwise head will keep pointing to its next node but in reality head
									// is tail now so it should point to null
					p1.next = null;
				}
				p2.next = p1;
				p1 = p2;// move every pointer to its next position
				p2 = p3;
				p3 = p3.next;
			}
			p2.next = p1;// cause last 2 nodes will be left without linking
			head = p2;// p2 is the new head
			newTail.next = head;// simply joining the last group with other reversed chain
		}
		head = newTail;
		return head;
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
