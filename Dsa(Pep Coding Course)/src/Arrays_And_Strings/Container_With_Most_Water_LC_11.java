package Arrays_And_Strings;

public class Container_With_Most_Water_LC_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		// O(N) time complexity
		int max = 0;

		int i = 0, j = height.length - 1;// putting i and j on left most and right most index respectively of given
											// array

		while (i < j) {// simply moving them till they cross each other

			if (height[i] < height[j]) {
				// means wall on that 'i' is is smaller so it will decide the amount of water
				// that can be stored between ith and jth wall . So now simply calculate the
				// water and move only ith pointer ahead cause its smaller

				int currVol = height[i] * (j - i);// this is the formula of how much water will be stored between them
													// i.e. simply the height of the smaller wall and the distance
													// between the walls
				max = Math.max(max, currVol);
				i++;
			} else {// means wall that j is pointing is smaller or equal to the wall that 'i' is
					// pointing so simply calculate and move j

				int currVol = height[j] * (j - i);
				max = Math.max(max, currVol);
				j--;
			}
		}
		return max;
	}
}
