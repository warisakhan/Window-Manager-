import java.util.Comparator;

/**
 * {@summary} Each window is going to need a list of squares.
 * A linked list class of your own design (no copying from anywhere!).
 * If you decide to go this route, you linked list class should be implemented
 * as ThreeTenLinkedList (in the provided ThreeTenLinkedList.java file).
 * Your linked list must be made out of the nodes we defined in the provided
 * Node class.
 * 
 * @author Warisa Khan.
 * @param <T> generic T.
 */

class ThreeTenLinkedList<T> {

	/**
	 * size is an int used to check the size of the list.
	 */
	private int size;
	/**
	 * Node head initializes the head that is created in Node.java.
	 */
	private Node<T> head;
	/**
	 * Node tail initializes the tail created in Node.java.
	 */
	private Node<T> tail;

	/**
	 * this is a constructor.
	 */
	public ThreeTenLinkedList() {

		this.size = 0;
		this.head = null;
		this.tail = null;

	}

	/**
	 * second constructor that sets the head and tail values.
	 * 
	 * @param head is the head found in Node.java.
	 * @param tail is the tail found in Node.java.
	 */
	public ThreeTenLinkedList(Node<T> head, Node<T> tail) {
		this.head = head;
		this.tail = tail;

	}

	/**
	 * this is a setter for head.
	 * 
	 * @param head is set.
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}

	/**
	 * this is getter for head.
	 * 
	 * @return head.
	 */
	public Node<T> getHead() {
		return this.head;
	}

	/**
	 * this is a setter for tail.
	 * 
	 * @param tail is the tail.
	 */

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	/**
	 * this is a getter for tail.
	 * 
	 * @return tail.
	 */
	public Node<T> getTail() {
		return this.tail;
	}

	/**
	 * sets the size of the list.
	 * 
	 * @param size is the size.
	 */

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * gets the size of the list.
	 * 
	 * @return size.
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * adds a head to the list.
	 * 
	 * @param data is the data being used to put the value in the node.
	 */
	public void addHead(T data) {
		// initializing a new node.
		Node<T> newNode = new Node<T>(data);

		if (getSize() == 0) {

			this.head = newNode;
			this.tail = newNode;
			size++;
		}
		// checking to see if there is already a node present in the linked list, if so
		// will add the new node as the head

		else {

			newNode.next = this.head;
			this.head.prev = newNode;
			head = newNode;
			size++;
			// if no node present, will add it and it will be both the head and tail
		}

		// depending on whether the linked list was empty or not, head node needs to be
		// new node

		// increase the size to accomodate for the new node.

	}

	/**
	 * this adds a new tail to the data.
	 * 
	 * @param data is the new data being added to the tail.
	 */
	public void addTail(T data) {
		Node<T> newNode = new Node<T>(data);

		if (getSize() == 0) {
			this.tail = newNode;
			this.head = this.tail;
			size++;
		}

		// if the linked list is not null, then will replace the node at the current
		// position with the New node

		// if the linked list is empty, adding the newNode as the head and will be both
		// the head and tail
		else {

			this.tail.next = newNode;
			newNode.prev = tail;
			this.tail = newNode;
			size++;
		}

	}

	/**
	 * removes the node from the list.
	 * 
	 * @param newNode is being used to check the node and remove sucessfully.
	 * @return boolean which is true if the node is removed sucessfully.
	 */
	public boolean remove(Node<T> newNode) {
		Node<T> currentNode = this.head;

		if (getSize() == 1) {
			this.head = null;
			this.tail = null;
			size--;
			return true;
		}
		// if the new node is equal to the beginning of the list, we set the head to the
		// next value to remove the inital value.
		if (newNode == this.head) {
			this.head = this.head.next;
			// sets the original value to null to remove it.
			this.head.prev = null;
			// decreasing size to accomodate for the remove.
			size--;
			return true;

		}
		// if the node is equal to the tail, set the new value to the previous.
		if (newNode == this.tail) {
			this.tail = this.tail.prev;
			// sets the initial tail to null to remove.
			this.tail.next = null;
			// decreasing size to accomodate for the removal.
			size--;
			return true;

		}

		// while the current node is not null we traverse the list.
		while (currentNode.next != null) {

			// if the new node is equal to the current node we adjust the data values to
			// remove the newnode sucessfully.
			if (currentNode == newNode) {
				Node<T> wnode = currentNode.prev;
				currentNode.prev.next = currentNode.next;
				currentNode.next.prev = wnode;
				// decreasing size to accomodate for the removal.
				size--;
				// was sucessfully able to remove it.
				return true;

			}
			// if it is not equal, we set the current node to the next nodes value.
			currentNode = currentNode.next;

		}

		return false;
	}

	// size, head and tail for node, and double linked list

	// while its not null go into the linked list, move the next and previous, cut
	// the connection off
	// two if statements, if == head, or if it == tail- gethead or gettail method or
	// make class variables equal to that, delink it and return true
	// then go into the while loop

	// one add method for head, one add method for tail, one remove method (is two
	// fine?), constructors, setters, and getters

	// You may, but are not required to, implement some or
	// all of this generic linked list class to help you with
	// this project. If you do, you MUST use the provided
	// Node class for this linked list class. This means
	// that it must be a doubly linked list (and links in
	// both directions MUST work).

	// Alternatively, you may implement this project using
	// only the Node class itself (i.e. use "bare nodes"
	// in the classes that require linked lists).

	// Either way, you MUST do all your own work. Any other
	// implementations you have done in the past, anything
	// from the book, etc. should not be in front of you,
	// and you certainly shouldn't copy and paste anything
	// from any other source.

	// This is the only class where you are allowed to
	// implement public methods.

	// In "Part 5" of the project, you will also be implementing
	// the following static methods:

	/**
	 * sorting the data accordingly based on insertion sort.
	 * 
	 * @param <X>   is a generic X.
	 * @param pairs is the node head and node tail being provided.
	 * @param comp  Comparator being used to sort.
	 * @return boolean which returns true if the list is sorted.
	 */
	static <X> boolean isSorted(NodePair<X> pairs, Comparator<X> comp) {
		// creating a node to use for comparison and setting it to the head
		Node<X> currentNode = pairs.head;
		// creating a variable for the boolean
		boolean result = true;
		// if either pairs or the comp is null, illegal argument exception
		if (pairs == null || comp == null) {
			throw new IllegalArgumentException();
		}
		// if the head and tail are null the list is still technically sorted, so return
		// true
		if (pairs.head == null && pairs.tail == null) {
			result = true;
			return result;
		}
		// as long as the next node is not null we can compare the two nodes to sort
		// them.
		while (currentNode.next != null) {
			// if the data is not sorted properly, will return false
			if (comp.compare(currentNode.data, currentNode.next.data) > 0) {

				result = false;
				return result;
			}
			// sets the current node to the next nodes value
			currentNode = currentNode.next;
		}

		// Determine if the provided list is sorted based on the comparator.

		// For an empty linked list (e.g. the head-tail pair contains two nulls)
		// return true (an empty list is sorted).

		// For a null comparator or null pairs, throw an IllegalArgumentException.

		// O(n)

		// < YOUR_CODE_HERE >

		return result; // replace this!
	}

	/**
	 * this is a method that sorts the nodes in the list.
	 * 
	 * @param <X> is the generic class.
	 * @param pairs is the linked list being passed in.
	 * @param comp  is the comparator being used.
	 * @return X is the return for the pairs.
	 */
	static <X> NodePair<X> sort(NodePair<X> pairs, Comparator<X> comp) {

		// temp variable to store the data of the node thats being swapped
		X tempNode;
		// outer while loop checking if its sorted or not
		// othewise goes into the second while loop and sorts it

		// are we comparing the X and Y pairs (head, tail)? how do u access the nested
		// class to compare

		// pairs is a pair of nodes that goes into the list
		// comp is the comparator
		if (pairs == null || comp == null) {
			throw new IllegalArgumentException();
		}

		// if the head and tail are null will just return the pairs.
		if (pairs.head == null && pairs.tail == null) {
			return pairs;
		}
		// while the selected is false
		while (isSorted(pairs, comp) == false) {
			// creating a node to use for comparison
			Node<X> currentNode = pairs.head;
			// and while the next node is not null
			while (currentNode.next != null) {
				// <= 0 means the first object is smaller than the second object so it is
				// already in correct order
				if (comp.compare(currentNode.data, currentNode.next.data) > 0) {
					// storing the data of the node we are changing and swapping them
					tempNode = currentNode.data;
					currentNode.data = currentNode.next.data;
					currentNode.next.data = tempNode;

				}
				// setting the current node is the next node
				currentNode = currentNode.next;

			}
		}

		return pairs;

		// return 0 if they are equal
		// return 1 if first value is greater than the second value
		// return -1 if the first value is less than the second value

		// Using the comparator, sort the linked list. It is recommended that
		// you sort by moving *values* around rather than moving nodes.
		// Two simple sorting algorithms which will work well here (and
		// meet the big-O requirements if implemented correctly) are the
		// insertion sort (see textbook Ch8.3) and the selection sort.

		// Insertion sort quick summary: Go to each element in the linked list,
		// shift it "left" into the correct position.
		// Example: 1,3,0,2
		// 1 is at the start of the list, leave it alone
		// 3 is bigger than 1, leave it alone
		// 0 is smaller than 3, move it left: 1,0,3,2
		// 0 is smaller than 1, move it to the left: 0,1,3,2
		// 0 is at the start of the list, stop moving it left
		// 2 is smaller than 3, move it to the left: 0,1,2,3
		// 2 is bigger than 1, stop moving it to the left

		// Selection sort quick summary: Go to each index in the linked list,
		// find the smallest thing from that index and to the "right",
		// and swap it into that index.
		// Example: 1,3,0,2
		// index 0: the smallest thing from index 0 to the end is 0, swap it into the
		// right place: 0,3,1,2
		// index 1: the smallest thing from index 1 to the end is 1, swap it into the
		// right place: 0,1,3,2
		// index 2: the smallest thing from index 2 to the end is 2, swap it into the
		// right place: 0,1,2,3
		// index 3: there is only one item from index 3 to the end, so this is in the
		// right places

		// Regardless of the method you choose, your sort should be a stable sort.
		// This means that if there are two equal values, they do not change their
		// order relative to each other.
		// Example: 1, 2, 1
		// The first "1" (which I'll call "1a") should be sorted before
		// the second "1" (1b), so that the output is "1a, 1b, 2" and
		// never "1b, 1a, 2". The easiest way to test this is to put two
		// equal items in the list, sort, and confirm using == that the
		// correct object is in the correct place.

		// For an empty linked list (e.g. the head-tail pair contains two nulls)
		// return the original pairs back to the user.

		// For a null comparator or null pairs, throw an IllegalArgumentException.

		// O(n^2)

		// < YOUR_CODE_HERE >

		// replace this!
	}

	// Which uses the following nested class:
	/**
	 * this is a nested class that is utilized in the sorting method.
	 * 
	 * @param <Y> is the nested class.
	 */
	public static class NodePair<Y> {
		/**
		 * this is the head.
		 */
		public Node<Y> head;
		/**
		 * this is the tail.
		 */
		public Node<Y> tail;

		/**
		 * this is a constructor.
		 * 
		 * @param head is the head of the list.
		 * @param tail is the tail of the list.
		 */

		public NodePair(Node<Y> head, Node<Y> tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	// You may also use the above nested class elsewhere in your
	// project if you'd find that helpful.
}