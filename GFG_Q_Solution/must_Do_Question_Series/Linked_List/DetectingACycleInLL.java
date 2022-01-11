package Linked_List;

public class DetectingACycleInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// one brute force is approach is simply using hashset and while travelling check if we already travelled the node but this apporach take O(N) space time 
	
// this is best solution TC=O(N) and SC=O(1)
	public static boolean detectLoop(Node head) {
		if (head == null || head.next == null) {// that is case when LL is null or has just 1 node
			return false;
		}

		// the idea behind is same as that rabbit and hare question , if we start 2
		// pointers fast and slow and fast moves twice as fast as slow then if theres a
		// cycle then its bound to happen that they will meet at some point
		Node temp = head;
		boolean isFound = false;
		Node slowP = head;
		Node fastP = head;
		while (fastP.next != null && fastP.next.next != null) {// that if linked list doesnt has a cycle then since
																// both slow and fast are starting from same point
																// therefore fast will always finish first that reach
																// the null first therefore only check for it and we
																// check fast.next first and then fast.next.next cause
																// if fast.next is null then no need to check
																// fast.next.next
			slowP = slowP.next;
			fastP = fastP.next.next;

			if (slowP == fastP) {
				return true;
			}
		}
		return isFound;

	}
	class Node
	{
	    int data;
	    Node next;
	    Node(int d) {data = d; next = null; }
	}

}
