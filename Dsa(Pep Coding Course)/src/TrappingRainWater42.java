
public class TrappingRainWater42 {

	public static void main(String[] args) {
		int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(heights));
		System.out.println(trapBetterTCAndSC(heights));

	}

	public static int trap(int[] height) {
		int trappedWater = 0;
		if (height.length == 0) {// this is to handle stupid testcase when heights array is empty
			return 0;
		}
		int Larr[] = new int[height.length];// stores highest building to the left of i
		int Rarr[] = new int[height.length];// stores highest building to the right of i

		Larr[0] = height[0];// initializing first value so that we can use it to make full Larr since we
							// using Dp to make it i.e using previous result to make current one

		Rarr[height.length - 1] = height[height.length - 1];// initializing first value of Rarr

		for (int i = 1; i < Larr.length; i++) {
			Larr[i] = Math.max(Larr[i - 1], height[i]);
		}

		for (int i = height.length - 2; i > 0; i--) {// we fill Rarr from right to left cause it stores heighest
														// building to the right of i
			Rarr[i] = Math.max(Rarr[i + 1], height[i]);
		}

		for (int i = 1; i < height.length - 1; i++) {

			int min = Math.min(Larr[i], Rarr[i]);// simply find minimum of highest buildings on left and right of
													// current index since we can only store water upto that height at
													// current index

			trappedWater += min - height[i];// we subtract the height of building at current i cause we havent
											// considered the height of the current building

		}
		return trappedWater;
	}

	public static int trapBetterTCAndSC(int[] height) {
		int trappedWater = 0;
		int i = 0;
		int j = height.length - 1;
		int lMax = 0; // keeps track of height building appeared on left of i till now
		int rMax = 0;// keeps track of height building appeared on right of j till now
		
		while (i <= j) {
			lMax = Math.max(lMax, height[i]);
			rMax = Math.max(rMax, height[j]);
			
			if(lMax<rMax) {
				trappedWater+=lMax-height[i];// since we only care about the minmum one will finding water therefore we directly used Lmax 
				i++;// since we calculated water storage at current index therefore move on
			}else {
				trappedWater+=rMax-height[j];
				j--;
			}

		}
		return trappedWater;
	}

}
