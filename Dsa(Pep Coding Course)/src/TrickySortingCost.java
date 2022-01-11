import java.util.HashMap;

public class TrickySortingCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 5, 8, 7, 3, 4 };
		System.out.println(sortingCost(arr.length, arr));
	}

	static int sortingCost(int N, int arr[]) {
		int max = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			if (hm.containsKey(arr[i] - 1)) {
				temp = hm.get(arr[i] - 1);// simply find if previous number i.e arr[i]-1 in hm ,
											// if its present then it surely has stored the sequence before in it
											// example
											// like arr[i]=4 so we find 3 in hm and suppose till now we processed
											// 1,5,2,3 elements or array
											// so since we processed 3 before , it will have 3 as its value cause it
											// already found 1,2 before it , so simply get its value and add one to it
											// and now length of current sequence of which 4 is a part of becomes 4 so
											// put 4(key) with 4(value) in hm , its sort of like dp , we using previous
											// val (arr[i]-1) to
											// calulate current answer arr[i]
			}

			max = Math.max(max, temp + 1);// we are basically finding max length consecutive sequence in left to right
											// direction only

			hm.put(arr[i], temp + 1);// since its given in question that we have 1st N positive integer and length of
										// array is N means there are no duplicates so simply add the element

		}
		int ans = arr.length - max;
		return ans;
	}

}
