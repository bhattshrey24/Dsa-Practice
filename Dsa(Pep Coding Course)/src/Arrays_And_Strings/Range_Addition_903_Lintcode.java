package Arrays_And_Strings;

public class Range_Addition_903_Lintcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Range_Addition_903_Lintcode ob = new Range_Addition_903_Lintcode();
		int arr[] = ob.getModifiedArray(5, new int[][] { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	// It's Quite Tricky but very beautiful, See the Video

	// It's best solution

	public int[] getModifiedArray(int length, int[][] updates) {
		int[] ans = new int[length];

		for (int i = 0; i < updates.length; i++) {

			int startIdx = updates[i][0];
			int endIdx = updates[i][1];
			int val = updates[i][2];

			ans[startIdx] += val;
			if ((endIdx + 1) < length) {// this condition is just checking whether 'endIdx+1' is out of bound or not if
											// it is out
											// of bound then no need to do 'ans[endIdx + 1] -= val'

				ans[endIdx + 1] -= val;// It's like adding the counter part of what we added in above statement ie."ans[startIdx] += val" inorder
										// to nullify it's effect in indexes ahead of endIndex while doing prefix sum
			}

		}

		for (int i = 1; i < length; i++) {// finding prefix sum on same array
			ans[i] = ans[i] + ans[i - 1];
		}

		return ans;
	}
}
