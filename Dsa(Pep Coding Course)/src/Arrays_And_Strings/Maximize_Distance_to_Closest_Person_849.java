package Arrays_And_Strings;

public class Maximize_Distance_to_Closest_Person_849 {

	public static void main(String[] args) {
		Maximize_Distance_to_Closest_Person_849 ob = new Maximize_Distance_to_Closest_Person_849();
		int ans = ob.maxDistToClosest(new int[] { 0, 1 });
		System.out.println("ans : " + ans);
	}

// this is my approach sir's approach is different but same TC but sir's approach has better SC but it's quite cumbersome to implement
	public int maxDistToClosest(int[] seats) {

		int prefixClose[] = new int[seats.length];// stores index of nearest 1
		int suffixfixClose[] = new int[seats.length];

		if (seats[0] == 1) {
			prefixClose[0] = 0;
		} else {
			prefixClose[0] = -1;// this tells that there's no 1 in start
		}
		if (seats[seats.length - 1] == 1) {
			suffixfixClose[seats.length - 1] = seats.length - 1;
		} else {
			suffixfixClose[seats.length - 1] = seats.length;// this tells that there's no 1 in the end
		}

		for (int i = 1, j = seats.length - 2; i < seats.length; i++, j--) {// simply filling both prefix and suffix
			if (seats[i] == 1) {
				prefixClose[i] = i;
			} else {
				prefixClose[i] = prefixClose[i - 1];
			}
			if (seats[j] == 1) {
				suffixfixClose[j] = j;
			} else {
				suffixfixClose[j] = suffixfixClose[j + 1];
			}
		}

		int sol = 1;// sol is initialized with 1 because it's given that there's atleast 1 seat
					// empty and atleast 1 guest is already seated so answer can never be 0 cause
					// the smallest possible answer will be for case [1,0] ie. 1

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {// no need to check because guy is already seated here
				continue;
			}

			if (prefixClose[i] == -1) {// this is the case when there was no one seated at i=-1 means no need to check
										// in left direction cause no one is seated on left of you therefore only check
										// in
										// right
										// direction ie. 'suffixfixClose[i] - i' ie. distance of closest person sitting
										// on right of you if you are seated at 'i'
				sol = Math.max(sol, suffixfixClose[i] - i);
				continue;
			}
			if (suffixfixClose[i] == seats.length) {// this is the case when there was no one seated at i=0 means no
													// need to check
				// in right direction cause no one is seated right of you therefore only check
				// in left
				// direction ie. 'i - prefixClose[i]' ie. distance of closest person sitting
				// on left of you if you are seated at 'i'
				sol = Math.max(sol, i - prefixClose[i]);
				continue;
			}
			sol = Math.max(sol, Math.min(suffixfixClose[i] - i, i - prefixClose[i]));// now this means there are people
																						// seated on left of you and
																						// right so check on both sides
																						// now
		}

		return sol;
	}

}
