package miscellaneous;

import java.util.HashMap;

public class PermutationWithDuplicates {

	public static void main(String[] args) {

		String str = "aabb";
		
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {// converting string to frequency map
			char ch = str.charAt(i);
			if (hm.containsKey(ch)) {
				hm.put(ch, hm.get(ch) + 1);
			} else {
				hm.put(ch, 1);
			}
		}
		
		printPermWithDup1(1, str.length(), hm, "");// cs is one cause we are starting from box 1 

	}
	// Problem Crux
	// Here number of items are same as number of items , basically a string is
	// given and we have to print al its permutations
	// now string can have duplicate characters eg:- aabb ,abb etc.
	// for 'abb' distinct permutations are [bba, bab, abb]

	// Solution
	// here we will put boxes on level , sort of generating susquence wala method

	// basically we will convert given string to Hashmap (remember that hashmap an
	// have only unique keys)
	// here i'm passing the string as hashmap to function itself

	// we are tackling the duplicate part using HashMap , just see the recursive
	// tree that i made in notes and you'll understand
	public static void printPermWithDup1(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {// cs= current selected
																								// box , ts = total
																								// selection i.e. total
																								// boxes
		
		if(cs>ts) {// base case i.e. all boxes are traversed so simply print the answer of current branch
			System.out.println(asf);
			return;
		}
		
		for (char ch : fmap.keySet()) {
			if (fmap.get(ch) > 0) {// i.e. only consider if frequency is bigger than 0

				fmap.put(ch, fmap.get(ch) - 1);// since we used character therefore remove one frequence of it from map

				printPermWithDup1(cs + 1, ts, fmap, asf + ch);// now let recursion print answer for remaining selections i.e. cs
														// +1

				fmap.put(ch, fmap.get(ch) + 1);// backtrack i.e. wapis aate hue wapis add krdo so that other branches can use it 
			}
		}
	}

}
