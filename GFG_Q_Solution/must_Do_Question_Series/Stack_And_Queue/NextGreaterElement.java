package Stack_And_Queue;

import java.util.*;

public class NextGreaterElement {
//https://www.youtube.com/watch?v=sDKpIO2HGq0 see this video for theory its just 6 min
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = new long[] { 1, 3, 2, 4 };
		arr = nextLargerElement(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	// Quiet nice and conceptual and famous question

	public static long[] nextLargerElement(long[] arr, int n)

	{

		// here the funda is
		// 1) we are using the fac that we can access any index in array with O(1) Tc
		// 2) whenever we encounter a bigger element , we try to put it in as many
		// positions as possible that we put it as answer to all positions where it can
		// fit

		Deque<Integer> st = new ArrayDeque<Integer>();// because array Deque is faseter than normal stack

		long[] ans = new long[n];

		st.push(0);// adding first ele in stack
		for (int i = 1; i < arr.length; i++) {
			if (st.isEmpty()) {// means nothing to compare with i.e. all previous index already found there
								// next greater ele so simply add current index to stack
				st.push(i);
			}

			if (arr[i] <= arr[st.peek()]) {
				st.push(i);// observe we are pushing index and not the element so that we can put its
							// answer whenever we find a greater ele
			} else {
				long ele = arr[i];
				while (!st.isEmpty() && ele > arr[st.peek()]) {// that keep putting the current element in all possible
																// places where it satisfies the condition of it being
																// next
																// greater , and stop if u encounter a bigger ele in
																// stack or stack is empty
					int remIdx = st.pop();
					ans[remIdx] = ele;
				}

				st.push(i);// add current ele index so that we can find solution of current ele too
			}
		}

		while (!st.isEmpty()) {// this means that all these elements do not have a greater ele on right of them so simply put -1 on there places
			int remIdx = st.pop();
			ans[remIdx] = -1;
		}

		return ans;

	}
}
