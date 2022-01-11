import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class InsertDeleteGetRandom380 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand2 = new Random();
		ArrayList<Integer> arrList2 = new ArrayList<Integer>();
		arrList2.add(1);
		arrList2.add(4);
		arrList2.add(5);
		arrList2.add(7);
		arrList2.add(10);

	}

// Duplicates are not allowed in this question 

	HashMap<Integer, Integer> hm;
	
	Random rand;
	
	ArrayList<Integer> arrList;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom380() {
		hm = new HashMap<>();
		rand = new Random();
		arrList = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		boolean flag;
		if (hm.containsKey(val)) {
			flag = false;
		} else {
			flag = true;
			hm.put(val, arrList.size());// since index in arrayList starts from 0 therefore we first use the size then
			arrList.add(val); // add , like if there's no element in arraylist then arrlist.size() will return
								// 0
								// which is the actual index of element when you add it in arrayList

			// or you could have used :-
			// arrList.add(val);
			// hm.put(val, arrList.size()-1);
			// arrList.size()-1 cause now if there are 2 elements arrList.size() size will
			// give 2 but the actual index of element that you added is 1

		}
		return flag;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {

		boolean isPresent = false;// assuming its not present

		if (hm.containsKey(val)) {
			isPresent = true;
			int index = hm.get(val);// getting the index of the element we want to remove , now we know where is the
									// val in arraylist so now we can directly get to it
			int lastEle = arrList.get(arrList.size() - 1);// getting the last value of arrayList cause we will swal it
															// with val in arraylist

			// swapping
			arrList.set(index, lastEle); // if you use add then it will insert element at the index and not set value at
											// that index like if arraylist is 1,2,3,5 and you do arrlist.add(1,10) then
											// arraylist will become 1,10,2,3,5 , observe 2 got shifted and not removed
											// therefore we use .set , if we use .set() then it would have resulted in
											// 1,10,3,5

			arrList.remove(arrList.size() - 1);// lastEle is now present at 2 place i.e at index and at arrList.size()-1
												// so remove it from arrList.size()-1

			// reflect changes in hashmap
			hm.put(lastEle, index);
			hm.remove(val);
		}

		return isPresent;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		// rand.nextInt(N) gives a random number in from 0 to N-1
		return arrList.get(rand.nextInt(arrList.size()));// its gauranteed that atleast 1 element will be present when
															// this method is called so its okay to use it directly
															// without checking size of arrayList Before
	}

}
