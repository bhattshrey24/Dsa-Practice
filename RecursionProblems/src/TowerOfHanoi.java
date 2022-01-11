
public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3, 1, 3, 2);
	}
	
// i have explained it nicely in register
	
	public static void hanoi(int n, int a, int b, int c) {
		if (n == 0) {
			return;
		}
		
		hanoi(n - 1, a, c, b);
		System.out.println(n + " : " + a + "->" + b);
		hanoi(n - 1, c, b, a);
	}
}
