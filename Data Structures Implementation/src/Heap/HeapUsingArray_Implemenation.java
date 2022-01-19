package Heap;

//A Min heap is typically represented as an array. 

//The root element will be at Arr[0]. For any ith node, i.e., Arr[i] 
//Arr[(i -1) / 2] returns its parent node.
//Arr[(2 * i) + 1] returns its left child node.
//Arr[(2 * i) + 2] returns its right child node.

// Creating Min heap
public class HeapUsingArray_Implemenation {
	private int maxSize;
	private int heapArr[];// u can use arraylist too and have dynamic size heap but im using array
	private int currentSize;

	public HeapUsingArray_Implemenation(int maxSize) {
		this.maxSize = maxSize;
		heapArr = new int[maxSize];
		currentSize = 0;
		heapArr[0] = Integer.MIN_VALUE;
	}

	private int getParent(int i) {
		return (i - 1) / 2;
	}

	private int leftChildIdx(int i) {
		return ((2 * i) + 1);
	}

	private int rightChildIdx(int i) {
		return ((2 * i) + 2);
	}

	public void insertEle(int ele) {
		// simply add element in the last
		heapArr[currentSize] = ele;

		// now simply swap with parent till parent < child
		int currPos = currentSize;
		while (heapArr[getParent(currPos)] > heapArr[currPos]) {

			// simple swapping
			int temp = heapArr[getParent(currPos)];
			heapArr[getParent(currPos)] = heapArr[currPos];
			heapArr[currPos] = temp;
			currPos = getParent(currPos);

		}
		currentSize++;// increase size cause we successfully added an element
	}

	public int getMin() {// simply returns the top element of the heap but does not delete it from heap
		return heapArr[0];
	}

	private boolean isLeaf(int i, int lastEleIdx) {
		return (leftChildIdx(i) >= lastEleIdx && rightChildIdx(i) >= lastEleIdx);
	}

	private boolean hasOnlyOneChild(int i, int lastEleIdx) {
		return (leftChildIdx(i) >= lastEleIdx || rightChildIdx(i) >= lastEleIdx);
	}

	public void swapEle(int i, int j) {
		int temp = heapArr[i];
		heapArr[i] = heapArr[j];
		heapArr[j] = temp;
	}

	public int deleteEle() {// deletes the root element and returns it (not using heapify method here)
		// Step 1
		int rootEle = heapArr[0];// saving root element i.e. the element to be deleted so that we can return it
									// in last

		int lastEleIdx = currentSize - 1;// currentSize is always pointing to the next empty space in heap i.e. last
											// element will be at currentSize-1

		// Step 2 => Putting last element in the place of root element

		heapArr[0] = heapArr[lastEleIdx];// simply put last element in the place of root element
		heapArr[lastEleIdx] = -1;// deleting last element, -1 shows element is deleted

		// Step 3 => putting topmost element to it's correct position by swapping
		// i.e. simply compare with children and swap values with the child having
		// smaller value and then move pointer to that child and do the same
		// till all parents
		// are smaller than their children

		int currPos = 0;

		while (true) {
			// 3 cases are here i.e.
			// case 1 : current Element has 2 children
			// case 2 : current Element has 1 child
			// case 3 : current Element is leaf element

			if (isLeaf(currPos, lastEleIdx)) {// CASE 3 I.E. LEAF
				break;// simply break cause no more swap is left to do cause no more child is there

			} else if (hasOnlyOneChild(currPos, lastEleIdx)) { // CASE 2 I.E. HAS
																// ONLY ONE
																// CHILD

				if (leftChildIdx(currPos) >= lastEleIdx) {// i.e. has only right child
					int rc = rightChildIdx(currPos);
					if (heapArr[rc] < heapArr[currPos]) {// swap only if value of child is smaller than parent
						swapEle(currPos, rc);
						currPos = rc;
					} else {
						break;
					}

				} else {// i.e. has only left child

					int lc = leftChildIdx(currPos);

					if (heapArr[lc] < heapArr[currPos]) {
						swapEle(currPos, lc);
						currPos = lc;
					} else {
						break;
					}
				}

			} else {// CASE 1 : HAS BOTH CHILDREN

				if ((heapArr[currPos] > heapArr[leftChildIdx(currPos)])
						|| (heapArr[currPos] > heapArr[rightChildIdx(currPos)])) { // checking if both or any of the
																					// children has smaller value than
																					// current element

					int lc = leftChildIdx(currPos);
					int rc = rightChildIdx(currPos);

					if (heapArr[rc] >= heapArr[lc]) {// if left is smaller swipe with left child
						swapEle(currPos, lc);// simple swap current element with it's left child
						currPos = lc;// now move current element pointer to left child

					} else {// if right is smaller then swap with right
						swapEle(currPos, rc);
						currPos = rc;// now move current pointer element to right child
					}

				} else { // means no need to swap therefore break out of loop
					break;
				}

			}
		}

		currentSize = currentSize - 1;

		return rootEle;
	}

	public void heapify() {

	}

	public void HeapSort() {
	}

	public void displayHeap() {// this is not in actual heap API , I just created it to see that wehter heap is
								// rightly created or not

		for (int i = 0; i < maxSize; i++) {
			System.out.print(heapArr[i] + "| ");
		}
		System.out.println();
	}
}


