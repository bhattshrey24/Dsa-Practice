package miscellaneous;

import java.util.HashMap;

public class PermutationWithDuplicate2 {

	public static void main(String[] args) {
		String str = "aabb";
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			hm.put(str.charAt(i), -1);
		}
		Character[] boxes = new Character[str.length()];// empty boxes initially

		printPermWithDup2(0, str, boxes, hm);

	}
	// frist see 'PermutationWithDuplicate' then come here cause this is simply
	// another approach for same question

	// here we will put items on level and generate premutations

	// so here to handle duplicacy we will sort of use similar concept as
	// combination i.e. duplicate ko we will put previous occurence of duplicate ke
	// baad wale boxes mei hi so that duplicate premutations generate na ho

	public static void printPermWithDup2(int cc, String str, Character[] boxes,
			HashMap<Character, Integer> lastOccurance) {// we are keeping the last occurance of every unique character
														// of the string in a hashmap , boxes are the boxes where we are
														// putting the characters i.e. 'gaps'

		if (cc == str.length()) {// i.e. we traversed all the characters and placed them
			for (int i = 0; i < boxes.length; i++) {
				System.out.print(boxes[i]);
			}
			System.out.println();
			return;
		}

		char ch = str.charAt(cc);
		int prevOcc = lastOccurance.get(ch);// agar pehle occurance nhi hogi toh this will give -1 cause initialy we put
											// every unique character with -1 frequence

		for (int i = prevOcc + 1; i < boxes.length; i++) {// now see here , we started from pevOcc+1 means if prevOcc
															// was -1 then it starts from 0 which we wanted and if its 1
															// ,2 or any other number then the loop will start from next
															// position which is what we want

			if (boxes[i] == null) {// i.e. we only put character in current box if current box is empty , remember
									// java
									// initializes character array with null

				boxes[i] = ch;// put character in box
				lastOccurance.put(ch, i);// update the last occurance of the character

				printPermWithDup2(cc + 1, str, boxes, lastOccurance);// let recursion do for the remaining boxes

				// backtracking
				lastOccurance.put(ch, prevOcc);// here we are putting the previous 'lastOccurance' of the character. we
												// are simply undoing what we did so that other
												// branches can do their work

				boxes[i] = null;// again putting null i.e. emptying the current box
			}
		}

	}

}
