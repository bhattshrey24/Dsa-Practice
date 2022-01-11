package Linked_List;

public class Add2NumRepresentedByLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(11 / 10);
	}

	// code for compilation of this question in gfg is broken , the below is my
	// solution and im 99% sure that its correct

	static Node addTwoLists(Node first, Node second) {

		// Approach is first reverse both linked list , then simply end of both will
		// align , now perform addition , and keep track of carry digit

				
		// step 1 reverse LL1
		Node h1 = first;
		int s1 = 0;// s1 is size of LL1

		Node p1 = first;
		Node p2 = first.next;
		Node p3 = first.next.next;

		while (p3 != null) {
			if (p1 == h1) {
				p1.next = null;
			}
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			s1++;
		}
		p2.next = p1;
		h1 = p2;
		s1 = s1 + 2;// since p3 is 2 places ahead of p1 and therefore last 2 elements will not be
					// counted by while loop cause p3 will cause while loop to terminate therefore
					// add 2 outside

		// step 2 reverse LL2
		Node h2 = second;
		int s2 = 0;

		p1 = second;
		p2 = second.next;
		p3 = second.next.next;

		while (p3 != null) {
			if (p1 == h2) {
				p1.next = null;
			}

			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3 = p3.next;
			s2++;

		}
		p2.next = p1;
		h2 = p2;
		s2 = s2 + 2;

		int max = Math.max(s1, s2);// finding max length cause resultant list will have nodes equal to max or 1
									// more than max(due to carry)

		int carry = 0;// keeps track of carry digit

		Node newHead = null;// head of new LL
		Node t;// temp node
		int dig = 0;// stores digit that we put in each node

		while (max > 0) {
			if (h1 != null && h2 != null) {
				dig = h1.data + h2.data + carry;// since carry is 0 so no harm in simply addign it , also we will
												// reinitialize it to 0 after use eveytime , just keep reading
				h1 = h1.next;
				h2 = h2.next;
			} else if (h1 == null) {
				dig = h2.data + carry;// adding carry since there can be carry due to previous h1.data + h2.data
				h2 = h2.next;
			} else if (h2 == null) {
				dig = h1.data + carry;
				h1 = h1.next;

			}
			if (carry != 0) {// since above we already added carry to dig so if it was not 0 means it was already added , so now make it 0 which means that we already used the carry and added it to dig
				carry = 0;
			}

			if (dig >= 10) {// means we need to generate carry and change dig 
				// eg is dig= 14 then carry =1 and dig =4
				carry = dig / 10;
				dig = dig % 10;
			}

			if (newHead == null) {// means its the first node
				Node node = new Node(dig);
				newHead = node;
			} else {
				Node node = new Node(dig);
				t = newHead;// simply adding every node in start instead of end so that hume end me list reverse na krni pade fir se
				newHead = node;
				node.next = t;
			}

			max--;
		}

		// handling the last carry outside
		if (carry != 0) {
			Node node = new Node(carry);
			t = newHead;
			newHead = node;
			node.next = t;
		}

		return newHead;

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
