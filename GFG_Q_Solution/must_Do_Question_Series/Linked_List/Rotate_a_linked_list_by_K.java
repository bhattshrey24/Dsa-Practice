package Linked_List;

import java.util.Scanner;

import Linked_List.Reverse_A_linked_list.Node;

public class Rotate_a_linked_list_by_K {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter size of LL");
		int size = sc.nextInt();
		int n = size;
		System.out.println("please enter head");
		int val = sc.nextInt();
		Node head = new Node(val);
		Node temp = head;
		while (n-- != 1) {
			System.out.println("please enter next ele");
			int value = sc.nextInt();
			Node node = new Node(value);
			temp.next = node;
			temp = node;
		}
		temp = head;
		temp = reverse(head, 3);
		System.out.println("after reverse");
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}

//complete this LAter
	
	public static Node reverse(Node head, int k) {
		// Step 1
		Node temp = head;
		int size = 0;
		while (temp != null) { // finding length of LL
			size++;
			temp = temp.next;
		}
		System.out.println("leng: " + size);

		// step 2
		int i = 0;
		
		Node prevTail = null;
		Node newTail = null;
		Node newHead = head;
		Node p1 = head;
		Node p2 = p1.next;
		Node p3 = p2.next;
		while (i < (size / k)) {// looping over no of group times
			newTail = newHead;// since this newtail will always be head of the group before reversing
			
			int count = 1;
			p1 = head;
			p2 = p1.next;
			p3 = p2.next;
			System.out.println("before");
			System.out.println("p1 " + p1.data);
			System.out.println("p2 " + p2.data);
			System.out.println("p3 " + p3.data);
			
			while (count < k && p3 != null) {
				if (p1 == newHead) {
					p1.next = null;
				}
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				p3 = p3.next;
				count++;
			}
			p2.next = p1;//only when p3 is null means p3 reached end
			
			System.out.println("after");
			System.out.println("p1 " + p1.data);
			System.out.println("p2 " + p2.data);
			System.out.println("p3 " + p3.data);
			if (i == 0) {
//			System.out.println("inside");
				head = p2;
				newHead = p3;
			} else {
				newHead = p3;
			}
			i++;
		}

		System.out.println("before step 3");
		System.out.println("Head " + head.data);

		// Step 3
		// incase left when last group has element != K i.e when size is odd
		if (size % 2 != 0) {// simply reverse the last group normally
			Node tp1 = p2;// 3 pointers are required
			Node tp2 = p3;
			Node tp3 = p3.next;
			System.out.println("before");
			System.out.println("tp1 " + tp1.data);
			System.out.println("tp2 " + tp2.data);
			System.out.println("tp3 " + tp3.data);

			while (tp3 != null) {
//			if (tp1 == head) {// cause otherwise head will keep pointing to its next node but in reality head
//								// is tail now so it should point to null
//				tp1.next = null;
//			}
				tp2.next = tp1;
				tp1 = tp2;// move every pointer to its next position
				tp2 = tp3;
				tp3 = tp3.next;
			}
			System.out.println("tp2.next data " + tp2.next.data);
			tp2.next = tp1;// cause last 2 nodes will be left without linking
			System.out.println("before");
			System.out.println("tp1 " + tp1.data);
			System.out.println("tp2 " + tp2.data);
			// System.out.println("tp3 "+tp3.data);
			// head = tp2;// p2 is the new head
			// newTail.next = head;// simply joining the last group with other reversed
			// chain
		}

		Node temp2 = head;
		while (temp2 != null) {
			System.out.print(temp2.data + "->");
			temp2 = temp2.next;
		}
		return head;
	}

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

}

//Node p1 = newHead;
//Node p2 = p1.next;
//Node p3 = p2.next;
//
//int count = 1;// used so that I only reverse members of the group
//
//newTail = newHead;// cause newTail will be the head of current group after reversing the group
//
//while (count < k - 1) {
//	if (p1 == newHead) {// cause otherwise head will keep pointing to its next node but in reality head
//						// is tail now so it should point to null
//		p1.next = null;
//	}
//	p2.next = p1;
//	p1 = p2;// move every pointer to its next position
//	p2 = p3;
//	p3 = p3.next;
//	count++;
//}
//p2.next = p1;// cause last 2 nodes will be left without linking
//
//if (i == 0) {// since in first group the prevTail is at null therefore prevTail.next=newHead
//				// will give error
//	prevTail = newTail;
//	head=newHead;// since newHead of the 1st group is actually head of the whole list
//newHead=p3;
//} else {
//	prevTail.next = newHead;// linking the groups
//	prevTail = newTail;
//	newHead = p3;
//}
//
//i++;

//public static Node reverse(Node head, int k) {
//	// Step 1
//	Node temp = head;
//	int size = 0;
//	while (temp != null) { // finding length of LL
//		size++;
//		temp = temp.next;
//	}
//	System.out.println("leng: " + size);
//
//	// step 2
//	int i = 0;
//	Node prevTail = null;
//	Node newTail = null;
//	Node newHead = head;
//	Node p1 = head;
//	Node p2 = p1.next;
//	Node p3 = p2.next;
//	while (i < (size / k)) {// looping over no of group times
//		newTail = newHead;// since this newtail will always be head of the group before reversing
//		int count = 1;
//		 p1 = head;
//		 p2 = p1.next;
//		 p3 = p2.next;
//		System.out.println("before");
//		System.out.println("p1 "+p1.data);
//		System.out.println("p2 "+p2.data);
//		System.out.println("p3 "+p3.data);
//		while (count < k-1 && p3 != null) {
//			if (p1 == newHead) {
//				p1.next = null;
//			}
//			p2.next = p1;
//			p1 = p2;
//			p2 = p3;
//			p3 = p3.next;
//			count++;
//		}
//		p2.next = p1;
//		System.out.println("after");
//		System.out.println("p1 "+p1.data);
//		System.out.println("p2 "+p2.data);
//		System.out.println("p3 "+p3.data);
//		if (i == 0) {
////			System.out.println("inside");
//			head = p2;
//			newHead = p3;
//		} else {
//			newHead = p3;
//		}
//		i++;
//	}
//
//	System.out.println("before step 3");
//	System.out.println("Head " + head.data);
//
//
//	// Step 3
//	// incase left when last group has element != K i.e when size is odd
//	if (size % 2 != 0) {// simply reverse the last group normally
//		Node tp1 = p2;// 3 pointers are required
//		Node tp2 = p3;
//		Node tp3 = p3.next;
//		System.out.println("before");
//		System.out.println("tp1 "+tp1.data);
//		System.out.println("tp2 "+tp2.data);
//		System.out.println("tp3 "+tp3.data);
//		
//		while (tp3 != null) {
////			if (tp1 == head) {// cause otherwise head will keep pointing to its next node but in reality head
////								// is tail now so it should point to null
////				tp1.next = null;
////			}
//			tp2.next = tp1;
//			tp1 = tp2;// move every pointer to its next position
//			tp2 = tp3;
//			tp3 = tp3.next;
//		}
//		System.out.println("tp2.next data "+tp2.next.data);
//		tp2.next = tp1;// cause last 2 nodes will be left without linking
//		System.out.println("before");
//		System.out.println("tp1 "+tp1.data);
//		System.out.println("tp2 "+tp2.data);
//		//System.out.println("tp3 "+tp3.data);
//		//head = tp2;// p2 is the new head
//		//newTail.next = head;// simply joining the last group with other reversed chain
//	}
//	
//	Node temp2 = head;
//	while (temp2 != null) {
//		System.out.print(temp2.data + "->");
//		temp2 = temp2.next;
//	}
//	return head;
//}
