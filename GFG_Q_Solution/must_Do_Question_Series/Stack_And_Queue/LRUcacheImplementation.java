package Stack_And_Queue;

import java.util.HashMap;
import java.util.LinkedList;

import Stack_And_Queue.LRUcacheImplementation.Node;

public class LRUcacheImplementation {
//VERY IMPORTANT QUESTION , THOUGH IT DOESNT USES STACK OR QUEUE BUT USES HASHMAP AND LL
	public static void main(String[] args) {

	}

//Node need to handle duplicates cause since if we get key with different value in set then we have to modify the value of key and not add another
	// https://www.youtube.com/watch?v=S6IfqDXWa10 must watch
	
	// used dummy head and tail node instead of just head nad tail pointer cause its
	// easier to code and understand this way just see above video
	public static class Node {
		int key;
		int value;
		Node next;// next is pointer to right
		Node prev;// prev is pointer to left

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
	}

// here LL is the actual cache and hm is for mapping purpose and to optimize search operation

	private HashMap<Integer, Node> map;
	private int capacity, size;// size is size of cache
	private Node dummyHead, dummyTail;

	public LRUcacheImplementation(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		dummyHead = new Node(0, 0);// making dummy head and tail
		dummyTail = new Node(0, 0);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		dummyHead.prev = null;
		dummyTail.next = null;
		size = 0;
	}

	public void deleteNode(Node node) {// this handles deleting of node
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public void addToHead(Node node) {// this handles adding node to head
		node.next = dummyHead.next;
		node.next.prev = node;
		node.prev = dummyHead;
		dummyHead.next = node;
	}

	public int get(int key) {// works in O(1)
		if (map.containsKey(key)) {
			// IMPORTANT : when we get and item you don't just have to return the value but
			// also have to put the item in the first place(i.e most recently used) cause
			// you just accessed the page
			Node node = map.get(key);
			int result = node.value;
			deleteNode(node);// delete the node
			addToHead(node);// add it to the head
			return result;
		}
		return -1;
	}

	public void set(int key, int value) {// works in O(1)
		if (map.containsKey(key)) {
			Node nodeFound = map.get(key);
			nodeFound.value = value;
			deleteNode(nodeFound);// here also we have to put the nodeFound with changed value at first place cause set is also an
									// operation means cpu wanted this page and it was present in memory
									// so we did what cpu wanted to do that is modify its value and this makes the current node as most
									// recently used node by cpu so put it in front
			addToHead(nodeFound);
			
		} else {//means page fault that is page not in cache
			
			Node node = new Node(key, value);
			map.put(key, node);
			if (size < capacity) {// means we havent reached full capacity yet so simply add the node in the start , means its the MRU
				size++;// dont forget to increase the size of cache
				addToHead(node);
			} else {
				// remove last ele of LL cause its the LRU 
				map.remove(dummyTail.prev.key);
				deleteNode(dummyTail.prev);
				// add new ele to head of list
				addToHead(node);
			}
		}
	}

}

//code below is my code without dummy that gave null pointer exception and looks quite difficult to understand , therefore it's better to use dummy head and tail node instead of just a pointer
//static Node head; // head points to most recently used ele (MRU)
//static Node rear;// rear points to least recently used(LRU)
//
//static int size = 0;// keeps track of size of LL
//
//static HashMap<Integer, Node> hm;// for mapping
//
//static int capacity = 0;// capacity of cache
//
//LRUcacheImplementation(int cap) {
//	capacity = cap;
//	hm = new HashMap<>();
//	head = null;
//	rear = null;
//}
//
//public static int get(int key) {// IMPORTANT : when we get and item you don't just have to return the value but
//								// also have to put the item in the first place(i.e most recently used) cause
//								// you just accessed the page
//
//	if (hm.containsKey(key)) {
//
//		Node nodeFound = hm.get(key);
//
//		// when capacity is 2 or more
//		if (nodeFound == head) {
//			// do nothing cause current character is MRU so no need to put it in front
//		} else if (nodeFound == rear) {
//			// 1st delete node
//
//			rear = nodeFound.prev;
//			rear.next = null;
//			nodeFound.prev = null;
//
//			// add to first
//
//			nodeFound.next = head;
//			head.prev = nodeFound;
//			head = nodeFound;
//
//		} else {// middle ele
//
//			// 1st delete node
//
//			nodeFound.prev.next = nodeFound.next;
//			nodeFound.next.prev = nodeFound.prev;// means somewhere prev of rear is null
//			nodeFound.prev = null;
//			nodeFound.next = null;
//
//			// add to first
//			nodeFound.next = head;
//			head.prev = nodeFound;
//			head = nodeFound;
//		}
//
//		return nodeFound.val;// no need to update hm since we only repositioned the cache and haven't
//		// modified
//		// any value
//	} else {
//		return -1;
//	}
//}
//
//public static void set(int key, int value) {
//	if (hm.containsKey(key)) {
//		Node nodeFound = hm.get(key);
//		nodeFound.val = value;// this changes the node value in LL too
//		if(size>1) {
//			Node dum= rear;
//			rear=rear.prev;
//			rear.next=null;
//			dum.prev=null;
//			
//			nodeFound.next=head;
//			head.prev=nodeFound;
//		head=nodeFound;
//		}
//		hm.put(key, nodeFound);
//	} else {
//		Node newNode = new Node(key, value);
//
//		if (size >= capacity) {// take out the LRU item
//
//			if (capacity == 1) {// every new node is lru as well as mru cause theres just 1 ele capacity
//				Node dum = head;
//				hm.remove(dum.key);
//				head = newNode;
//				rear = newNode;
//				hm.put(key, newNode);
//			} else if (capacity >= 2) {// when capacity is 2 or more
//				Node dum = rear;// in order to delete it from hm
//				hm.remove(dum.key);
//
//				// 1st delete rear node
//				rear = rear.prev;
//				rear.next = null;
//				dum.prev = null;
//
//				// add to first
//
//				hm.put(key, newNode);
//
//				newNode.next = head;
//				head.prev = newNode;
//				head = newNode;
//			}
//
//		} else {// adding new node from head and deleting from rear
//
//			if (head == null && rear == null) {// means first node
//				head = newNode;
//				rear = newNode;
//			} else if (head == rear && head != null) {// means its the second node
//				head = newNode;
//				rear.prev = head;
//				head.next = rear;
//
//			} else {// 2 or more node in list , adding using head
//				newNode.next = head;
//				head.prev = newNode;
//				head = newNode;
//			}
//
//			hm.put(key, newNode);
//			size++;
//		}
//	}
//}
