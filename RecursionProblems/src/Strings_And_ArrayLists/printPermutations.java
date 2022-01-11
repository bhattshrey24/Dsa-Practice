package Strings_And_ArrayLists;

public class printPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermu("ABCD", "");
	}

	public static void printPermu(String str, String ans) {

		if (str == "") {// base case , again permutations of empty string is empty string only
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String strBeforeCh = str.substring(0, i); // string before ch
			String strAfterCh = str.substring(i + 1);// string after ch

			String ros = strBeforeCh + strAfterCh;// simply the remaining string i.e. without character "ch"

			printPermu(ros, ans + ch);// here recursive thinking is easy see with eg for "ABC" , A +(BC ke
										// premutation) ,
										// B+(AC ke premutation), C+(AB ke premutation) , bascially har character ko ek
										// ek krke nikal rhe and telling recursion ki baaki bachi hui string ke
										// permutation le aoo , and then simply unke aage woh character lgado
		}
	}
}
