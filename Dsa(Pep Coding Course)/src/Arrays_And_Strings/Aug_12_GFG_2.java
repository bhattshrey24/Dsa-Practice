package Arrays_And_Strings;
import java.util.Arrays;

//Q)Given an array A[] and a number x, check for pair in A[] with sum as x (aka Two Sum)

public class Aug_12_GFG_2 {

	public static void main(String[] args) {

	}

	// Here we dont have a constraint that we dont have to use extra space otherwise
	// its quite easy using Hashmap

	// Still its easy , just have to sort it and use 2 pointer approach
	// TC=O(nLog(n))
	boolean hasArrayTwoCandidates(int arr[], int n, int x) {
		boolean hasPair = false;
		Arrays.sort(arr); // Ik Arrays.sort(arr) might sort arr in 0(N^2) , we can use collections.sort() which is guaranteed
							// to sort in nLogn , but in GFG it is giving TLE when I used Collections.sort
							// therefore I used Arrays.sort to sort the array
		int i = 0, j = arr.length - 1;
		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum < x) {
				i++; // since sum of i anf jth element is smaller than x so we need to increase the sum therefore move i cause array is sorted 
			
			} else if (sum > x) {
				j--;// since sum of i anf jth element is bigger than x so we need to decrease the sum therefore move j cause array is sorted 
			} else {
				hasPair = true; // no need to print the pair , we just have to find whether there exist such pair or not
				break;
			}
		}
		return hasPair;
	}
}
