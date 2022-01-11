import java.util.HashMap;
import java.util.Scanner;

public class ModeOfFrequencies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- != 0) {
			
			int n = sc.nextInt();
			int arr[] = new int[n] ;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			HashMap<Integer, Integer> hm = new HashMap<>();
			
			for (int i = 0; i < arr.length; i++) {
				if (hm.containsKey(arr[i])) {
					hm.put(arr[i], hm.get(arr[i]) + 1);
				} else {
					hm.put(arr[i], 1);
				}
			}

			int maxFreq = 0;
			HashMap<Integer, Integer> hmOfFreq = new HashMap<>();
			for (int key : hm.keySet()) {// we make hashmap of frequency of number
				int freq = hm.get(key);
				if (hmOfFreq.containsKey(freq)) {
					maxFreq = Math.max(maxFreq, hmOfFreq.get(freq) + 1);
					hmOfFreq.put(freq, hmOfFreq.get(freq) + 1);
				} else {
					hmOfFreq.put(freq, 1);
					maxFreq = Math.max(maxFreq, 1);
				}
			}

			int mode = Integer.MAX_VALUE;
			for (int key : hmOfFreq.keySet()) {
				if (hmOfFreq.get(key) == maxFreq) {// if there are more than 1 freuqncy with same frequency thn we choose the one which has smaller value
					if (key < mode) {
						mode = key;
					}
				}
			}

			System.out.println(mode);
		}

	}

}
