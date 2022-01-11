package Linked_List;

import java.util.Scanner;

import Linked_List.Reverse_A_linked_list.Node;

public class RemoveLoopFromLL {

	public static void main(String[] args) {

	}

	public static void removeLoop(Node head) {
		// its exactly rabbit and maze one
		
		
		Node temp = head;
		boolean isFound = false;
		Node slowP = head;
		Node fastP = head;
		
		// step 1 finding that whether loop exists or not 
		while (fastP.next != null && fastP.next.next != null) {
			slowP = slowP.next;
			fastP = fastP.next.next;
			if (slowP == fastP) {
				isFound = true;// loop found
				break;
			}
		}
		if (!isFound) {// if theres no loop then nothing to break so simply return
			return;
		}
		
		// step 2 finding the starting point of the cycle

		slowP = head;
		// observe fast is still at the node of intersection only we havent touched it	
		while (slowP != fastP) {
			slowP = slowP.next;
			fastP = fastP.next;// observe fast is also moving same as slow
		}
		
		// step 3 breaking the loop
		// now slow is at the start point of cycle you just have to move "fast" and stop 1 node before the starting point of cycle and then break the link
		while (fastP.next != slowP) {
			fastP = fastP.next;
		}
		fastP.next = null;// broken the link
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}
}
