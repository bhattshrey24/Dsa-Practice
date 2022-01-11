import java.util.LinkedList;

public class DigitMultiplier {

	public static void main(String[] args) {
		System.out.println(getSmallest((long) 26));
	}

	static String getSmallest(Long N) {

		if (N == 1) { // its sort of special case
			return Integer.toString(1);
		}

		LinkedList<String> ans = new LinkedList<>();

		long OriginalNumber = N;

		int j = 9;// we start from ulta cause we doing add first in linkedList

		while (N != 1 && j > 1) {// j>1 for the case when answer is not possible like 26 then here we first get
									// j=2 which can divide N i.e 26
									// so N becomes 13 and we add 2 to answer , now 13 can not be divided by anyone
									// else so in this case it
									// will become infinite loop if we dont put j>1 , aslo we need to stop j too
									// other wise it will go to - infinty

			if (N % j == 0) {
				ans.addFirst(Integer.toString(j));
				N = N / j;// updating N , since now we want factors of this updated N
			} else {
				// System.out.println(j);
				j--;

			}
		}

		long product = 1;
		for (int i = 0; i < ans.size(); i++) {
			product *= Integer.parseInt(ans.get(i));
		}

		if (product != OriginalNumber) {// this is for the case when you get some answer in likedList but its not
										// correct

			return Integer.toString(-1);
		} else {
			String sol = "";
			for (int i = 0; i < ans.size(); i++) {
				sol += ans.get(i);// simply converting our answer to String
			}
			return sol;

		}

	}

}
