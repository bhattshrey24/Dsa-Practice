package Stack_And_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParanthesisChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean ispar(String x) {
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < x.length(); i++) {
			char ch = x.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				// Push the element in the stack
				stack.push(ch);
				continue;
			}

			// If current character is not opening
			// bracket, then it must be closing. So stack
			// cannot be empty at this point.
			if (stack.isEmpty())
				return false;
			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check != '(')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check != '{')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check != '[')
					return false;
				break;
			}
		}

		// Check Empty Stack
		return (stack.isEmpty());

	}
}
