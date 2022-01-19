
public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dummy ob = new Dummy();
		
		int arr[] = new int[] { 1, 2, 3, 4 };
		ob.changeEle(arr);
		System.out.println(arr[0]);

	}

	public void changeEle(int[] ar) {
		ar[0] = 100;
	}

}
