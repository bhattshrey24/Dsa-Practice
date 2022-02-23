package Graph;
import java.util.HashSet;

public class CrackingTheSafe_753 {
// This is direct implementation of "DE BRUJIN SEQUENCE" algorithm
	
	// this is 0-1 question i.e in interview you can only answer if you already know
	// de brujin sequence , such 0-1 question are asked very less in interviews
	// though cause in these type of questions its not possible to judge persons
	// skills
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(crackSafe(3, 2));
	}

	public static String crackSafe(int n, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		HashSet<String> visSequences = new HashSet<>();
		int noOfCombinations = (int) Math.pow(k, n);
		
		return crackSafeRec(visSequences, noOfCombinations, k, sb, sb.toString(), "");

	}

	public static String crackSafeRec(HashSet<String> visSequences, int noOfCombinations, int k, StringBuilder sb,
			String curPermu, String sol) {

		if (visSequences.size() == noOfCombinations - 1) {
			return sb.toString();
		}

		visSequences.add(curPermu);
		String Str = curPermu.substring(1);

		for (int i = 0; i < k; i++) {

			String newPerm = Str + String.valueOf(i);

			if (!visSequences.contains(newPerm)) {// we only call if the new permuation string is not already visited
													// i.e not already present in current path

				sb.append(String.valueOf(i));
				sol = crackSafeRec(visSequences, noOfCombinations, k, sb, newPerm, sol);// here leap of fath is tha that
																						// newPermutation find out
																						// whether you are the required
																						// path or not if yes return me
																						// the string if not then return
																						// me empty string

				if (sol.length() != 0) {// the path that did not lead to answer will return empty string while falling
										// and length of empty string is 0
					break;// length of sol will only be more than 0 when we hit base case and stack is
							// falling that
							// means we got the answer so why to continue just break out and return answer
							// i.e sol
				}
			}

		}

		// backtracking , removing cause current path didnt gave the answer so undo
		visSequences.remove(curPermu);
		sb.deleteCharAt(sb.length() - 1);

		return sol;
	}

}
