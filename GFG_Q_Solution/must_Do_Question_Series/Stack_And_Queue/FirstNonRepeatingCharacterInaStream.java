package Stack_And_Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInaStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Queue<Integer> q = new LinkedList<>();
//		q.add(1);
//		q.add(2);
//		q.add(4);
//		System.out.println(q.peek());
//		q.remove();
//		System.out.println(q.peek());
		String str = "bhreu";
		char a = 'z';
		char x = 'z';
		int b = a - 97;
		System.out.println(a == x);
		System.out.println();
	}
// see this vid for understanding question , i have used a different approach though https://www.youtube.com/watch?v=KnWqCfIfHX0
//https://www.youtube.com/watch?v=Jkx1vP3ZkK0 using same concept as mine

// GIVING CORRECT ANSWER but somehow TLE in gfg but i guess its not more than 26*n

	public String FirstNonRepeating(String str) {
		String ans = "";
		int[] arr = new int[26];// at every index i will store the occurance of each character (0 will store
								// occurance of 'a', 1 will stroe of 'b' and so on)
		Queue<Character> q = new ArrayDeque<>();
// my logic is i used a queue that store only the unique characters than already occured while traversing the str
// now if occurance is 0 simply add ele in the queue and to the answer , if its 1 or more means current ele is duplicate so this time dont add to queue but increase the occurance count and now for answer loop through the queue from start and keep dequing till either queue ends or you find pooped character different from current character , if you found pooped character dont add straightaway first check if its a duplicate or not if not then only add if yes then keep looking for the answer in queue
// here im not adding more than 26 ele in queu and once dequed im not adding it again cause theres no sense since its duplicate so tc is i guess O(26*n)
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int chIndex = ch - 97;// so that it starts from 0 instead of 97

			if (arr[chIndex] == 0) {
				arr[chIndex] += 1;
				q.add(ch);
				ans += q.peek();
			} else {
				arr[chIndex] += 1;
				boolean found = false;
				while (!q.isEmpty()) {
					char popped = q.peek();
					if (popped != ch) {
						int poppedIdx = popped - 97;
						if (arr[poppedIdx] <= 1) {
							ans += q.peek();
							found = true;
							break;
						} else {
							q.remove();
						}

					} else {
						q.remove();
					}
					if (found) {
						break;
					}
				}
				if (!found) {
					ans += '#';
				}
			}
		}

		return ans;
	}

}
