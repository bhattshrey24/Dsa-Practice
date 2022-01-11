package miscellaneous;

import java.util.HashSet;

public class WordsKSelection2 {

	public static void main(String[] args) {
		String str = "aabbbccccddddd";
		int k = 2;
		HashSet<Character> unique = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			unique.add(str.charAt(i));
		}
		String ustr = "";// ustr= unique string i.e. string that has only unique character from string
							// 'str'
		for (char ch : unique) {
			ustr += ch;
		}
		wordSelection2(ustr, 1, k, -1, "");// lc =-1 cause abhi tk koi character select hi nhi kiya
	}

	// first see WordsKSelection1 to understand the problem

	// here we use different approach i.e. we will use Backtracking , i.e. wahi ki
	// next level pr item ko previously jis box mei daala tha uske aage wale box mei
	// hi daal skte ho cause we
	// need to print combinations and not permutations . actually mei since we are
	// using string therefore there wont be actual backtracking done by us it will
	// be managed by recursion only

	// here also boxes are unqiue characters and when we say that we selected 1st
	// box it means we added 1st character of unique string in answer

	public static void wordSelection2(String ustr, int cs, int ts, int lc, String asf) {// cs= current selection , lc=
																						// last konsa character select
																						// kiya tha

		if (cs > ts) {// base case
			System.out.println(asf);
			return;

		}

		for (int i = lc + 1; i < ustr.length(); i++) {// previous selection se aage loop chlega , and number of boxes
														// jitne hai utni baar chlega
			char ch = ustr.charAt(i);
			wordSelection2(ustr, cs + 1, ts, i, asf + ch);
			// observe no need of backtracking cause we are not operating on array , also do
			// a dry run you'll understand
		}

	}

}
