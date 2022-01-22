
public class Chocholate_Distribution_LC_135 {
// URL to question = https://leetcode.com/problems/candy/
	public static void main(String[] args) {
		Chocholate_Distribution_LC_135 ob = new Chocholate_Distribution_LC_135();
		System.out.println(ob.candy(new int[] { 1, 2, 2 }));

	}

// Its my Solution and Its working

	public int candy(int[] ratings) {
		// Its quite simple -
		// Step 1 ) So in order to meet 1st condition , simply give 1
		// chocolate
		// to everyone before starting

		// Step 2) Now first go from left to right and check if condition 2 is met or
		// not by
		// checking with just the previous element with current one , if met then dont
		// do anything if not then give one more chocolate than previous child to
		// current child

		// Step 3 ) Now do the same from right to left
		// This way it is ensured that for every child condition 2 is met on both its
		// right and left side that too with as minimum chocolates as possible

		// Step 4 )Now simply add every childs number of chocolates in min variable and
		// return it

		int min = ratings.length;
		int[] CPAES = new int[min]; // CPAES = chocolates Present At Each Student

		for (int i = 1; i < ratings.length; i++) {// going left to right
			if (ratings[i] > ratings[i - 1] && CPAES[i] <= CPAES[i - 1]) {
				CPAES[i] = CPAES[i - 1] + 1; // adding 1 to previous child's chocolate and giving it to current child

			}
		}

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && CPAES[i] <= CPAES[i + 1]) {
				CPAES[i] = CPAES[i + 1] + 1;
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			min += CPAES[i];// adding every childs number of chocolate to the answer
		}

		return min;
	}

}
