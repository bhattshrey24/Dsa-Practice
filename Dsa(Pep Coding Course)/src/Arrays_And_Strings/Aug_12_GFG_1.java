package Arrays_And_Strings;

public class Aug_12_GFG_1 {
//Q) Segregate 0s and 1s 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Aug_12_GFG_1().segregate0and1(new int[] { 0, 0, 1, 1, 0 }, 5);
		
	}

// The concept is simple just dry run the code you'll understand
// This is similar to a famous Question called "Dutch National Flag"
	void segregate0and1(int[] arr, int n) {// We have to do this question in just a single Iteration
		
		int i = 0, j = n - 1; // pointer i will make sure that 0's are at their correct position and j will
								// make sure that 1's are at there correct position

// basically we are using 2 pointer method to segregate 0 and 1

// since i is starting from left and going to right so if it's pointing to 0 means that 0 is at it's correct position so move on and if not ie. if it's pointing to 1 means we need to swap this 1 with a 0 that j found so wait till j finds a 0 so that we can swap both i and j 	

		while (i < j) {

			if (arr[i] == 1 && arr[j] == 0) {// means both are pointing to the opposite number that they are suppose to
												// point to so swap them
				swap(arr, n, i, j);
				i++;
				j--;
			}
			if (arr[i] == 0) {// means 0 is at it's correct position because i is pointing it so move 'i'
								// ahead
				i++;
			}
			if (arr[j] == 1) {// means 1 is at it's correct position because j is pointing it so move 'j'
								// ahead
				j--;
			}

		}

	}

	void swap(int[] arr, int n, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
