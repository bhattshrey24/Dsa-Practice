package Linked_List;

public class CheckIfLinkedListIsPalindrome {

	public static void main(String[] args) {
		System.out.println();
	}

// We can do this by many methods like converting the LL to number and finding if number is pallindrom , or using stack i.e filling stack then comparing top with head of LL 
//but here we have to use SC=O(1)
	
	boolean isPalindrome(Node head) {
		// thought process is that we find mid of LL , then reverse the second half , then compare 2nd half with first half , if both are equal then pallindrome else not , now here we have to handle LL of even len and odd len seperately cause in odd we have to ignore middle element and the 2 half will be before and after mid
		
		boolean isPallin = true;// assuming its palindrome
		// Step 1 finding size of LL
		Node t = head;
		int size = 0;
		while (t != null) {
			size++;
			t = t.next;
		}

		if (size == 1) {// handling base case when len of LL is 1
			return true;
		}

		if (size == 2) {
			if (head.next.data == head.data) {// handling base case when len of LL is 2
				return true;
			} else {
				return false;
			}
		}

		if (size % 2 == 0) {// That is len of LL is Even
			// reach mid of list
			int i = 1;
			int end = size / 2;
			Node mid = head;
			while (i < end) {
				mid = mid.next;
				i++;
			}
			// mid is at 1st mid of LL(there are 2 mid cause len of LL is odd )
			Node nH = mid.next;
			mid.next = null;// breaking the connection

			// reversing this new List
			nH = reverseLL(nH);

			Node t1 = head;
			Node t2 = nH;

			while (t1 != null) {// comparing both halves
				if (t1.data != t2.data) {
					return false;
				}
				t1 = t1.next;
				t2 = t2.next;

			}

		}

		else {// when len of LL is odd

			// reach mid of list
			int i = 1;
			int end = size / 2;
			Node mid = head;
			while (i < end) {
				mid = mid.next;
				i++;
			}
			// mid is at mid of LL

			Node nH = mid.next.next;
			Node rem = mid.next;// holds the middle element
			mid.next = null;// breaking the connection
			rem.next = null;// isolation middle element 

			// reversing this new List
			
			if (nH.next == null) {// this is when len of LL is 3 , then Node p3 = p2.next will give null pointer
									// error therefore handle this case before hand

				if (nH.data == head.data) {
					return true;
				} else {
					return false;
				}
			}

			nH = reverseLL(nH);
			Node t1 = head;
			Node t2 = nH;

			while (t1 != null) {// comparing both halves
				if (t1.data != t2.data) {
					return false;
				}
				t1 = t1.next;
				t2 = t2.next;
			}
		}

		return isPallin;

	}

	public Node reverseLL(Node head) {// (IMP) always make seperate function if u have to reverse a LL for better
										// understanding
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
