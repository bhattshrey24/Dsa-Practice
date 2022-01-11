package Linked_List;

public class IntersectionPointInYShapedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

// basically you are given 2 heads of the SAME Y shaped linkedList(basically these 2 heads are the heads of the 2 branches of the same Y shaped LinkedList) , you have to find the intersection point
	int intersectPoint(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;
		int ans = -1;// assuming we didnt found the intersection
		int len1 = 0;// length of 1st branch
		int len2 = 0;// length of 2nd branch

		// since 2 branches are of the same linkedList so the idea is that since
		// branches are of same linked list so branches before the intersection can be
		// of different size so what we need is to skip extra elements and start
		// comparison from same point i.e. (same length from intersection)
		
		while (temp1 != null) {// simply calculating the length of the 1st branch
			len1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {// simply calculating the length of the 2nd branch
			len2++;
			temp2 = temp2.next;
		}

		if (len1 >= len2) {// i.e len1 is bigger
			int eleToLeave = len1 - len2;// i.e number of elements to skip , i.e theoretically we are making the end point same 
			temp1 = head1;
			temp2 = head2;
			int i = 0;
			while (i < eleToLeave) {// skipping the elements
				temp1 = temp1.next;
				i++;
			}

			while (temp1 != null || temp2 != null) {// i.e either go till end or we will break if we found the intersection point
				if (temp1 == temp2) {// i.e node is same i.e the intersection point
					ans = temp1.data;
					break;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}

		} else {// len2 is bigger
			int eleToLeave = len2 - len1;
			temp1 = head2;
			temp2 = head1;
			int i = 0;
			while (i < eleToLeave) {
				temp1 = temp1.next;
				i++;
			}

			while (temp1 != null || temp2 != null) {
				if (temp1 == temp2) {
					ans = temp1.data;
					break;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return ans;

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
