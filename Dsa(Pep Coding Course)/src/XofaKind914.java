import java.util.HashMap;

public class XofaKind914 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(4, 6));
		int dec[] = new int[] { 1, 2, 3, 4, 4, 3, 2, 1 };
		System.out.println(hasGroupsSizeX(dec));
	}

	public static boolean hasGroupsSizeX(int[] deck) {
		if (deck.length == 1) {// for passing test cases , if deck has only 1 member then theres no way of
								// partitioning it
			return false;
		}
		if (deck.length == 2) {// if deck has 2 member , the only way we can partition is if both numbers are
								// same cause then we can put them in a single group of 2 members
			if (deck[0] == deck[1]) {
				return true;
			} else {
				return false;
			}
		}

		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < deck.length; i++) {
			if (hm.containsKey(deck[i])) {
				int prevFrequency = hm.get(deck[i]);
				hm.put(deck[i], prevFrequency + 1);
			} else {
				hm.put(deck[i], 1);
			}
		}

		int combinedGcd = 0;
		
		for (int key : hm.keySet()) {
			combinedGcd = gcd(hm.get(key), combinedGcd);// gcd with 0 is the number itself , rest we are just finding
														// gcd of all numbers frequency , we are finding gcd of 2
														// frequencies then using the ans to find gcd of 3rd then using
														// its ans to find gcd of 4th and so on
			
			// basically suppose there are 3 numbers 4,6,8 , gcd(4,6) is 2 , now since we dont
			// want bigger gcd then 2 cause then 4,6 will be left and we wont be able to group them therefore we find gcd of 2
			// and 8 cause either we want gcd equal to 2 or smaller than it 

		}
		if (combinedGcd == 1) {
			return false;
		} else {
			return true;
		}

	}

	public static int gcd(int a, int b) {//Eucledian theorem for finding gcd (greatest common divisor aka hcf)
		if (a == 0)// base case
			return b;

		return gcd(b % a, a);// recursive call
	}
}
