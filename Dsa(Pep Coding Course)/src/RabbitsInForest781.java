import java.util.HashMap;

public class RabbitsInForest781 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans[] = new int[] { 1, 1, 2 };

		System.out.println(numRabbits(ans));

	}

	public static int numRabbits(int[] answers) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < answers.length; i++) {
			if (hm.containsKey(answers[i])) {
				int prevFrequency = hm.get(answers[i]);
				hm.put(answers[i], prevFrequency + 1);
			} else {
				hm.put(answers[i], 1);
			}
		}

		int ans = 0;
		for (int key : hm.keySet()) {
			double num = hm.get(key);// math .ceil only works for double therefore we first converted numbers to
										// double
			double den = key + 1;// group size is nothing but key+1

			int ceil = (int) Math.ceil(num / den);

			if (ceil > 1) {
				ans += (ceil) * (key + 1); // number of groups * size of a group
			} else {
				ans += (key + 1);// this means no need to add groups of same number of rabbits in answer just 1
									// is enough
			}
		}
		return ans;
	}
}
