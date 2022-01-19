package Heap;

public class HeapUsingArray_Client {
	// A Min heap is typically represented as an array.
	// The root element will be at Arr[0]. For any ith node, i.e., Arr[i]
	// Arr[(i -1) / 2] returns its parent node.
	// Arr[(2 * i) + 1] returns its left child node.
	// Arr[(2 * i) + 2] returns its right child node.
	public static void main(String[] args) {

		HeapUsingArray_Implemenation minHeap = new HeapUsingArray_Implemenation(7);
		minHeap.insertEle(20);
		minHeap.insertEle(15);
		minHeap.insertEle(30);
		minHeap.insertEle(8);
		minHeap.insertEle(10);
		minHeap.insertEle(50);
		minHeap.insertEle(12);

		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		minHeap.displayHeap();
		System.out.println("ele removed : "+minHeap.deleteEle());
		

	}

}
