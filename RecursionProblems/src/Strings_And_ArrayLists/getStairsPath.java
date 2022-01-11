package Strings_And_ArrayLists;

import java.util.ArrayList;

public class getStairsPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Get Stair paths");
		System.out.println(getStairCasePaths(6));
		System.out.println();
		System.out.println("Print Stair paths");
		printStairCase(6, "");
	}

	public static ArrayList<String> getStairCasePaths(int n) {// same logic used for coin denomination question of DP

		if (n == 0) {// base case i.e. if no stairs is given then you are already at destination or
						// you can think it this way too that if while jumping u are at ground then you
						// are already at
						// destination ,
						// therefore number of ways for base case arrayList of SIZE 1 having empty
						// string
			ArrayList<String> baseAns = new ArrayList<>();
			baseAns.add("");
			return baseAns;
		}
		if (n < 0) {// if while jumping you reach at a stair below ground means you took wrong steps
					// so now you can't
					// reach ground cause you can't go up you can only go down , so 0 ways to reach
					// ground therefore
					// return
					// arraylist of SIZE 0
			return new ArrayList<>();
		}
		ArrayList<String> myAns = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {// from 1 to 3 cause allowed jumps are only 3 i.e. 1 2 and 3

			ArrayList<String> recAns = getStairCasePaths(n - i);// have faith that recursion will give all valid jumps from
															// n-i to 0
			for (String str : recAns) {
				myAns.add(i + str);// just add current jump to valid paths from n-i to 0 returned to you by
									// recursion
			}
		}
		return myAns;
	}

	public static void printStairCase(int n, String path) {
		if (n == 0) {// base case ,if no stair then already at destination so number of jumps u can
						// take is empty string and remember that is what we passed to the main function
						// where we called printStairCase , or u can think it this way that while
						// jumping u reached ground so have faith that recursion stores the path u took
						// too reach here
						// so simply print it , its basically end of this branch of recursive tree ,
						// just do one dry run and make the recursive tree , you'll get it
			System.out.print(path + ", ");
			return;
		}
		if (n < 0) {// i.e. we reached below the ground so no need to print the path cause we can
					// never reach destination from here
			return;
		}

		for (int i = 1; i <= 3; i++) {
			printStairCase(n - i, path + i);// have faith that recursion will print answer for n-i , and also assume
											// that "path" here sort of stores all paths for n-i to ground so you just
											// have to add current jump to it i.e. "i" using which you reached (n-i)th
											// stair
		}

	}

}
