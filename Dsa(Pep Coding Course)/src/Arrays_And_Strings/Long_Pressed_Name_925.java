package Arrays_And_Strings;

public class Long_Pressed_Name_925 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isLongPressedName(String name, String typed) {
// its an easy question , just have to take care of some base cases

		boolean isSame = true;

		int i = 0;
		int j = 0;

		if (name.charAt(i) != typed.charAt(j)) {
			return false;
		} else if (name.length() > typed.length()) {// cause typed has either same number of characters or more
													// characters because of long press , but never less ,if its less
													// means they are not sames
			return false;
		} else {
			i++;
			j++;
		}

		while (i < name.length()) {

			if (j == typed.length()) {// this is to handle the case when while moving j forward in previous iteration
										// we ended up traversing whole 'typed' string which means we don't have any
										// character left in 'typed' string to match with 'name' String's current
										// character which
										// means typed and name are not same
				return false;
			}

			char namech = name.charAt(i);
			char typech = typed.charAt(j);
			if (namech == typech) {
				i++;
				j++;
				continue;
			} else {// when namech != typech

				if (typech == typed.charAt(j - 1)) {// means its the repetion i.e. long pressed character

					while (j < typed.length() && typech == typed.charAt(j)) {// move till u reach a new character
						j++;
					}
					if (j == typed.length()) {// means we haven't found new character
						return false;
					}

					if (typed.charAt(j) == namech) {// checking if the newcharacter is same as namech
						i++;
						j++;
						continue;
					} else {
						return false;
					}
				} else {// it means current char is not a repetion of previous character , it's a new
						// character
					return false;
				}

			}

		}

		char lastCh = name.charAt(name.length() - 1);
		while (j != typed.length()) { // this is to handle the case when we completely traversed the 'name' string and
										// yet some characters are left in typed . It can mean that either the remaining
										// characters are same as the last character in 'name' string or they are
										// different in which case we return false

			if (typed.charAt(j) != lastCh) {
				return false;
			}
			j++;
		}

		return isSame;
	}
}
