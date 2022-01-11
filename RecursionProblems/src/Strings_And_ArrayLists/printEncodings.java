package Strings_And_ArrayLists;

public class printEncodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printEncod("103"
				+ "", "");
	}

	public static void printEncod(String str, String ans) {

		if (str.length() == 0) {// base case , i.e. if empty string is given then encoded solution is also empty
								// string , or u can think it this way that we reached the end of the current
								// branch of recursive tree means "ans" has the answer i.e. the path we took
								// i.e. the code

			System.out.println(ans);
			return;
		} else if (str.length() == 1) {// another base case , this is to ensure that if
			char chNum = str.charAt(0);
			if (chNum == '0') {
				return;
			} else {
				int idx = chNum - '0';// this will give the actual value like if chNum is 9 then idx will have 9 , if
										// we don't do this then idx will have ascii value of 9 instead of real value

				char ch = (char) ('a' + idx - 1); // this is simple way to convert '1' to 'a' ,'2' to 'b' ,'3' to 'c'
													// and so on without making a
													// static code array
				System.out.println(ans + ch);
			}
		} else {// when length 2 or more , here we give work to recursion

			char chNum = str.charAt(0);// Separating 1st letter
			String ros1 = str.substring(1);

			if (chNum == '0') {
				return;// directly "return" cause its given in question that if number starts with 0
						// its invalid so
						// simply return i.e. don't print anything , now in recursive way u can think it
						// like suppose you reached a sub case of suppose 103 now subcases of 103 are
						// 1 +("03" se generate hone wale codes)
						// and 10+(3 se generate hone wale codes) so here suppose this call is for "03"
						// i.e. first case now "03" is invalid so simply return , no need to print or
						// divide further cause current branch is wrong i.e. will not generate a valid
						// output if carried on further

			} else {
				int idx = chNum - '0';
				char ch = (char) ('a' + idx - 1);
				printEncod(ros1, ans + ch);// simply have faith that recursion will print for rest
			}

			String chNum2 = str.substring(0, 2);
			String ros2 = str.substring(2);

			int idx2 = Integer.parseInt(chNum2);
			if (idx2 <= 26) {// this means dont go in "if" if first 2 are out of bound eg suppose 99345 , so
								// here "99" ke liye
								// we
								// don't have code cause we only so simply don't divide for it i.e. dont divide
								// it in 99 ka code + (345 se
								// banne wale code ) cause 99 ka code hai hi nhi
				char ch2 = (char) ('a' + idx2 - 1);
				printEncod(ros2, ans + ch2);
			}
		}

	}
}
