import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckForAp {
// CHECK FOR ARTHEMATIC PROGRESSION (GFG)
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean checkIsAP(int arr[], int n) {
		if (arr.length == 1) {
			return true;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
		Collections.sort(list);// we can use hm too
		
		if (arr.length <= 2) {
			return true;
		}

		int a = list.get(0);// "a" means first element of ap since we sorted list therefore 1st element is
							// "a"
							// , no other element besides the 1st element can be "a"

		int a2 = list.get(1);// a2 is 2nd element of Ap i.e a+d

		int d = a2 - a;// d means commons difference

		int prevElementOfAp = a2;

		boolean isAp = true;// we assuming that given arr is Ap

		for (int i = 2; i < list.size(); i++) {
			int currentEle = list.get(i);

			if (currentEle == prevElementOfAp + d) {// simple next element of ap is simply previous element +d i.e
													// a2=a+d so a3 will be a+d+d i.e a+2d

				prevElementOfAp = currentEle;// making the current element as previous element so that we can check the
												// next element
				continue;
			} else {
				isAp = false;
			}
		}
		if (isAp) {
			return true;
		} else {
			return false;
		}
	}

	// the above solution is nlogn we can do it in o(n) using hashmap , its simple
	// just traverse through array 2 times and find smallest and 2nd smallest
	// element , now difference of them is d , now simply add all the elements in
	// hashmap first and then start looking , like start from a2 and add d to it and
	// check in hm that wether a2+d value is present or not if not stop return false
	// if yes then remove it (sort of marking it visited) and move on , keep doing
	// this till hm finishes

}
