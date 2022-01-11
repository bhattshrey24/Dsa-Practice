package OneDArray;

public class printArrayEle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 5, 2, 3, 2, 4, 5, 1 };
		printArr(arr, 0);
		System.out.println("Now in reverse");
		printArrInRev(arr, 0);
	}

	public static void printArr(int arr[], int idx) {
		if (idx == arr.length) {// means end reached so return , nothing left to print
			return;
		}
		System.out.println(arr[idx]);// print current element
		printArr(arr, idx + 1);// let recursion print remaining ele
	}

	public static void printArrInRev(int arr[], int idx) {
		if (idx == arr.length) {// means end reached so return , nothing left to print
			return;
		}
		printArrInRev(arr, idx + 1);// let recursion print remaining ele
		System.out.println(arr[idx]);// print current element
	}
}
