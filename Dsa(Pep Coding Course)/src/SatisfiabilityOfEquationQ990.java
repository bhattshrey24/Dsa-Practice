import java.util.HashMap;

public class SatisfiabilityOfEquationQ990 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean equationsPossible(String[] equations) {
		boolean flag = true;
		HashMap<Character, Character> hm = new HashMap<>();

		for (String str : equations) {
			if (str.charAt(1) == '=') {
				union(str.charAt(0), str.charAt(str.length() - 1), hm);
			}
		}
		for (String str : equations) {
			if (str.charAt(1) == '!') {
				if (findLeaderUtil(str.charAt(0), hm) == findLeaderUtil(str.charAt(str.length() - 1), hm)) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	public static char findLeaderUtil(char x, HashMap<Character, Character> parent) {
		if (!parent.containsKey(x)) {// since initially we only make graph of equations which has "==" so this make sure that input can be aything like suppose after processing "==" equations graph has only a and b and then user gives third input as x!=y so there's neither x nor y in hashmap so this will give null poiter exception but now after this hack it wont
			parent.put(x, x);// khudko khudka baap bnare
		}
		
		return findLeader(x, parent);
	}

	public static char findLeader(char x, HashMap<Character, Character> parent) {
		if (parent.get(x) == x) {
			return x;
		}
		return findLeader(parent.get(x), parent);
	}

	public static void union(char u, char v, HashMap<Character, Character> parent) {
		if (!parent.containsKey(u)) {
			parent.put(u, u);
		}
		if (!parent.containsKey(v)) {
			parent.put(v, v);
		}
		char a = findLeaderUtil(u, parent);
		char b = findLeaderUtil(v, parent);
		if (a != b) {
			parent.put(b, a);
		}

	}

}
