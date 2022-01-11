package Linked_List;

import java.util.*;

public class Reverse_A_linked_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(4/2);
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

		System.out.println("before reverse");
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		//temp = recHelper(head);
		temp = ReverseLL(head);
		System.out.println("after reverse");
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
// Recursive solution 
	public static Node recHelper(Node head) {// from pep coding sir
		Node tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		recSolution(head, tail);
		head.next = null;//  we have to make it null cause it head is still pointing to its neighbor , we have to make it null cause its the end of the list now
		head = tail;// simply make the tail as head
		return head;
	}

	public static void recSolution(Node head, Node tail) {// using recursion we have the power to go to previous node while stack is falling which is not the case while iterative solution
		if (head == null) {
			return;
		}
		recSolution(head.next, tail);// reaching the end of the list first
		// doing work while stack fall
		if (head.next != null) {// because head.next is null only when head is at the end on the list in which
								// case there's no next
			head.next.next = head;// that making our neighbor point to us , we are at head and head.next is our neighbor and head.next.next makes our neighbor point to us
		}
	}
	
	// iterative solution
	
	public static Node ReverseLL(Node head) {
		Node p1=head;// 3 pointers are required
		Node p2=p1.next;
		Node p3=p2.next;
		
		while(p3!=null) {
			if(p1==head) {// cause otherwise head will keep pointing to its next node but in reality head is tail now so it should point to null
				p1.next=null;
			}
			p2.next=p1;
			p1=p2;// move every pointer to its next position
			p2=p3;
			p3=p3.next;
		}
		p2.next=p1;// cause last 2 nodes will be left without linking
		head=p2;// p2 is the new head
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
