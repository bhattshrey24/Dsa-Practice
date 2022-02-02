package Arrays_And_Strings;

public class Max_Chunks_To_Make_Sorted_LC_769 {

	public static void main(String[] args) {
		Max_Chunks_To_Make_Sorted_LC_769 ob = new Max_Chunks_To_Make_Sorted_LC_769();
	}

	public int maxChunksToSorted(int[] arr) {
		int indv = 0;
		int grouped = 0;
// Try for [2,1,0,3,4,6,5] ,ans is 4 i.e. [2,1,0] , [3],[4], [6,5]
		for (int i = 0; i < arr.length; i++) {

		}

		if (indv >= arr.length - 1) {// case when all are in descending order
			return 1;
		} else {
			return indv + grouped;
		}
	}
}
