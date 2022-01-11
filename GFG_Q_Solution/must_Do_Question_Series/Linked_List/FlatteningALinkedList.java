package Linked_List;

import java.util.Scanner;

import Linked_List.Reverse_A_linked_list.Node;

public class FlatteningALinkedList {
	public static void main(String[] args) {
		System.out.println(4 / 2);
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter size of LL");
		int size = sc.nextInt();
		int n = size;
		System.out.println("please enter head");
		int val = sc.nextInt();
		Node head = new Node(val);
		Node temp = head;
		Node bucketTop = temp;
		// Node dum;
		while (n-- != 1) {
			System.out.println("want to enter bottom of " + temp.data + " :?(y/n)");
			String ans = sc.next();

			if (ans.equals("y")) {
				System.out.println("Enter bottom ele : ");
				val = sc.nextInt();
				temp.bottom = new Node(val);
				temp = temp.bottom;
			} else {
				System.out.println("Enter Next row ele : ");
				val = sc.nextInt();
				bucketTop.next = new Node(val);
				bucketTop = bucketTop.next;
				temp = bucketTop;
			}
		}

		System.out.println("Printing before flattening");
		temp = head;
		Node bucHead = temp;
		for (int i = 0; i < size; i++) {
			if (temp != null) {
				// System.out.println("inside if");
				System.out.println(temp.data);
				temp = temp.bottom;
			} else {
				// System.out.println("inside else");
				bucHead = bucHead.next;
				temp = bucHead;
				System.out.println("Next Row");
				System.out.println(temp.data);
				temp = temp.bottom;
			}
		}

		System.out.println("Printing after flattening");
		temp = dummy(head);
		bucHead = temp;
		System.out.println("head is :"+temp.data);
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.bottom;
		}


	
	}
	// Try This Method https://www.youtube.com/watch?v=ysytSSXpAI0&t=711s
	
	// FIx this
	
	public static Node dummy(Node head) {
		Node dummy= new Node(0);
		Node dummyHead=dummy;
		Node temp=head;
		Node bucHead=temp;
		while(bucHead!=null) {
			if(temp!=null) {
				dummy.bottom=temp;
				dummy=dummy.bottom;
				temp=temp.bottom;
			}else {
				bucHead=bucHead.next;
				temp=bucHead;
			}
		}
		return dummy.bottom;
	}

	public static Node flatten(Node root) {
		
		Node tempNext = root.next;
		Node tempAns = new Node(0);// dummy node
		Node ansHeadPointer = tempAns;
		Node p1 = root;
		Node p2 = root.next;

		while (tempNext != null) {
			while (p1 != null && p2 != null) {
				if (p1.data <= p2.data) {
					tempAns.bottom = p1;// change to next if there's a problem
					tempAns = tempAns.bottom;
					p1 = p1.next;
				} else {
					tempAns.bottom = p2;
					tempAns = tempAns.bottom;

					p2 = p2.next;
				}
			}
			if (p1 == null) {
				while (p2 != null) {
					tempAns.bottom = p2;
					tempAns = tempAns.bottom;
					p2 = p2.next;
				}
			} else {
				while (p1 != null) {
					tempAns.bottom = p1;
					tempAns = tempAns.bottom;
					p1 = p1.next;
				}
			}
			p1 = tempAns;// that is previous temp Next
			tempNext = tempNext.next;
			p2 = tempNext;
		}

		ansHeadPointer = ansHeadPointer.bottom;
		return ansHeadPointer;
	}

	static class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}
}
