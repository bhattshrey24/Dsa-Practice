package Linked_List;

import java.util.Scanner;

import Linked_List.Rotate_a_linked_list_by_K.Node;

public class Merge2SortedLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter size of 1st LL");
		int size = sc.nextInt();
		int n = size;
		System.out.println("please enter head of 1st");
		int val = sc.nextInt();
		Node head1 = new Node(val);
		Node temp = head1;
		while (n-- != 1) {
			System.out.println("please enter next ele");
			int value = sc.nextInt();
			Node node = new Node(value);
			temp.next = node;
			temp = node;
		}
		
		System.out.println("please enter size of 2nd LL");
		int size2 = sc.nextInt();
		int n2 = size2;
		System.out.println("please enter head of 2nd");
		int val2 = sc.nextInt();
		Node head2 = new Node(val2);
		Node temp2 = head2;
		while (n2-- != 1) {
			System.out.println("please enter next ele");
			int value = sc.nextInt();
			Node node = new Node(value);
			temp2.next = node;
			temp2 = node;
		}
		
		Node ans= sortedMerge(head1, head2);
		while(ans!=null) {
		System.out.println(ans.data);	
		ans=ans.next;
		}
	}
	//https://www.youtube.com/watch?v=Xb4slcp1U38
	
// fix this , breaking in { 1,2 } {1,4}(Some silly mistake)
	public static Node sortedMerge(Node head1, Node head2) {
// merging is done same as merge sort
		Node temp1 = head1;
		Node temp2 = head2;
		Node dummNode = new Node(0);// dummy node used to create new linked list
		Node dumNodeHead = dummNode;
		while (temp1 != null && temp2 != null) {// same merging as merge sort
			if (temp1.data <= temp2.data) {
				dummNode.next = temp1;
				dummNode = dummNode.next;
				temp1 = temp1.next;
			} else {
				dummNode.next = temp2;
				dummNode = dummNode.next;
				temp2 = temp2.next;
			}
		}

		if (temp1 == null) {
			while (temp2 != null) {
				dummNode.next = temp2;
				temp2 = temp2.next;
			}
		} else {
			while (temp1 != null) {
				dummNode.next = temp1;
				temp1 = temp1.next;
			}
		}
		return dumNodeHead.next;

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
