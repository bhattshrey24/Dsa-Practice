import java.util.HashMap;

public class CountNumberOfPairDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(7 % 4);
		int arr[] = new int[] { 5, 9, 36, 74, 52, 31, 42 };
		System.out.println(count4Divisibiles(arr, arr.length, 4));
	}

	public static int count4Divisibiles(int arr[], int n, int K) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int pairs = 0;
		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % K;// since if we want c1+c2 be divided by K then , c1=b1K+r1 and c2=b2K+r2 ,now
									// (c1+c2)%k==0 means we should be able to take out k out of (c1+c2) so for this
									// observer c1+c2=b1K+r1 + b2K+r2 , rearranging we get c1+c2=(b1+b2)K+r1+r2 ,
									// now if we want to take out K then we have to make r1+r2 divisible by K for
									// that r2=k-r1 put this in equation we get
			// c1+c2=(b1+b2)K+r1+k-r1 => c1+c2=(b1+b2)K+ K ,now we can take out K

			int toFind = K - rem;// we need to find r2 such that r2= K-r1

			if (rem == 0) {// special case , if rem is 0 we dont have to find k-0 , but 0
				if (hm.containsKey(rem)) {
					int prevFre = hm.get(rem);
					pairs += prevFre;
					hm.put(rem, prevFre + 1);
				} else {
					hm.put(rem, 1);
				}
				continue;
			}

			if (hm.containsKey(toFind)) {
				int prevFre = hm.get(toFind);
				pairs += prevFre;

			}

			if (hm.containsKey(rem)) {// regardless of wether we find ToFind or not we have to save current rem so
										// that others can use it , we dont save ToFind
				hm.put(rem, hm.get(rem) + 1);// we put remainder and not toFind cause Tofind is what we want i.e K-r1
				// but other might want us i.e. r2
			} else {
				hm.put(rem, 1);
			}

		}

		return pairs;
	}
}
