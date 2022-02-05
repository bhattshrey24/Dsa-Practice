package Arrays_And_Strings;

public class Max_Chunks_To_Make_Sorted_LC_769 {

	public static void main(String[] args) {
		Max_Chunks_To_Make_Sorted_LC_769 ob = new Max_Chunks_To_Make_Sorted_LC_769();
	}

	public int maxChunksToSorted(int[] arr) {
	 // dry run the code for [2,4,0,3,1,5,8,7,6]
		int chunk = 0; // basically this will keep track of number of chunks
		int max = 0;// this will store the max element till now
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);// competing current element with the max

			// The logic is that in a chunk , the max element of the chunk after sorting will be at the
			// end of the chunk
			if (max == i) { // this means we reached the correct position of the max element ie. where it
							// should be in sorted array which means sort previous elements which means we
							// found a valid chunk
				chunk++;
			}
		}
		return chunk;
	}
}
