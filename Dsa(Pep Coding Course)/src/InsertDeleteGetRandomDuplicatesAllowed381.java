import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class InsertDeleteGetRandomDuplicatesAllowed381 {

	public static void main(String[] args) {
	}

	// Duplicates are allowed here

	// see InsertDeleteGetRandom part 1 too , i have explained things there too
	HashMap<Integer, HashSet<Integer>> hm;
	Random rand;
	ArrayList<Integer> arrList;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandomDuplicatesAllowed381() {
		hm = new HashMap<>();
		rand = new Random();
		arrList = new ArrayList<>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean flag;
		if (hm.containsKey(val)) { // Cause now duplicates are allowed

			HashSet<Integer> dummy = hm.get(val);
			dummy.add(arrList.size());
			arrList.add(val);
			flag = false;
		} else {
			flag = true;
			HashSet<Integer> dummy = new HashSet<>();
			dummy.add(arrList.size());
			hm.put(val, dummy);
			arrList.add(val);
		}
		return flag;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained
	 * the specified element.
	 */
	public boolean remove(int val) {
		boolean isPresent = false;// assuming its not present

		if (hm.containsKey(val)) {
			isPresent = true;

			HashSet<Integer> dummy1 = hm.get(val);// get the hashmap corresponding to val , which contains all the
													// indexes in which val is present in arraylist

			int index = 0;// initializing evii cause otherwise it was giving error that u havent
							// initialized

			for (int ele : dummy1) {// since theres no get function in hashset therefore we used this jugad
				index = ele;
				break;
			}

			// getting the last element with which we will swap in arraylist
			int lastEle = arrList.get(arrList.size() - 1);

			if (lastEle == val) {// it is possible that last element is same as val then in this case why to swap
									// simply remove
				dummy1.remove(arrList.size() - 1);// since we can remove any occurance of val therefore simply remove
													// the last one

				arrList.remove(arrList.size() - 1);// remove last element from array list too

				if (dummy1.size() == 0) {// if size of dumm1 becomes 0 then simly remove the val from hm cause now this
											// means no occurance of val is there in arraylist
					hm.remove(val);
				}else{
					hm.put(val, dummy1);// else reflect changes in val's hashSwt of indexes
				}
				
			} else {// this is the normal case when last ele is not same as val which we have to remove
				
				dummy1.remove(index);// simply remove 1 occurance of val from its hashset
				if (dummy1.size() == 0) {// if size of dumm1 becomes 0 then simly remove the val from hm cause now this
					// means no occurance of val is there in arraylist
					hm.remove(val);
				}
				if (dummy1.size() != 0) {
					hm.put(val, dummy1);// else reflect changes in val's hashSwt of indexes
				}
				
				// now swap last element with value at "index" , basically we are not swapping but overwriting
				arrList.set(index, lastEle);
				
				
				// reflect changes in Hm for last element
				if (hm.containsKey(lastEle)) {
					
					HashSet<Integer> dummy2 = hm.get(lastEle);
					dummy2.remove(arrList.size() - 1);
					dummy2.add(index);
					arrList.remove(arrList.size() - 1);
					hm.put(lastEle, dummy2);
				} else {
					HashSet<Integer> dummy2 = new HashSet<Integer>();
					dummy2.add(index);
					hm.put(lastEle, dummy2);
					arrList.remove(arrList.size() - 1);
				}
			}
		}

		return isPresent;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return arrList.get(rand.nextInt(arrList.size()));
	}
}
