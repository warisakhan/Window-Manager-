
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

/**
 * {@summary} Each window is going to need a list of squares.
 * An outline of this class has been provided for you (along with some big-O
 * requirements), and you are going to complete this provided code using linked
 * lists!
 * 
 * @author Warisa Khan.
 */
public class SquareList {
	// You'll need some instance variables probably...
	// < YOUR_CODE_HERE >

	/**
	 * Initialize an empty list of squares.
	 */
	private ThreeTenLinkedList<Square> squarelist;

	/**
	 * this is a constructor.
	 * creating the object of ThreeTenLinkedList to utilize in this class.
	 */
	public SquareList() {
		squarelist = new ThreeTenLinkedList<>();

		// Any initialization code you need.

		// O(1)

		// < YOUR_CODE_HERE >
	}

	/**
	 * getter for the head.
	 * 
	 * @return Node head.
	 */
	public Node<Square> getHead() {

		// Returns the head of the list of squares.
		return squarelist.getHead();
		// O(1)

		// We will use this method to test your
		// linked list implementaiton of this
		// class, so whether or not you are using
		// the generic linked list class or bare
		// nodes, you must still be able to return
		// the appropriate head of the list.

		// < YOUR_CODE_HERE >

		// dummy return, replace this!
	}

	/**
	 * this is a getter method for the tail.
	 * 
	 * @return Node tail.
	 */
	public Node<Square> getTail() {

		return squarelist.getTail();
		// Returns the tail of the list of squares.
		// O(1)

		// We will use this method to test your
		// linked list implementaiton of this
		// class, so whether or not you are using
		// the generic linked list class or bare
		// nodes, you must still be able to return
		// the appropriate tail of the list.

		// < YOUR_CODE_HERE >

		// dummy return, replace this!
	}

	/**
	 * gets the number of squares in the list.
	 * 
	 * @return int gets the size of the squarelist.
	 */
	public int numSquares() {
		// Gets the number of squares in the list.

		// O(1)

		// < YOUR_CODE_HERE >

		// do we do the counter or do the getSize

		return squarelist.getSize();
	}

	/**
	 * adds a square to the list.
	 * 
	 * @param sq is the square being added to the list.
	 */
	public void add(Square sq) {
		// throw IllegalArgumentException for invalid sqares
		if (sq == null) {
			throw new IllegalArgumentException();
		}
		// Add a square to the list. Newly added squares
		// should be at the back end of the list.
		else {
			squarelist.addTail(sq);
		}

		// O(1)
	}

	/**
	 * removes a square if it is clicked on.
	 * 
	 * @param x is the x coordinate of the node.
	 * @param y is the y coordinate of the Node.
	 * @return boolean to see if the node was sucessfully removed.
	 */

	public boolean handleClick(int x, int y) {
		// setting a new node to utilize during comparison
		Node<Square> currentNode = getHead();
		boolean result = false;
		// if there is only one square and it contains the point x,y remove it - edge
		// case
		if (squarelist.getSize() == 1 && getHead().data.contains(x, y)) {
			squarelist.remove(getHead());
			result = true;
			return result;

		}
		// making sure the next node is not null
		while (currentNode != null) {
			// checking to see if the data point matches the x,y parameter given
			if (currentNode.data.contains(x, y)) {
				// if it contains the data point given, remove the node
				result = true;
				squarelist.remove(currentNode);

			}
			if (currentNode.next == null) {
				break;
			}
			// since the node was removed, we need to se the new value of the node to the
			// value of the next node
			currentNode = currentNode.next;
		}

		// Deletes all squares from the list that contain the
		// position (x,y). Returns true if any squares get
		// deleted and returns false otherwise.

		// Returns true if any squares were deleted.

		// O(n) where n is the size of the list of squares
		return result;
	}

	/**
	 * Gets an iterator for the list of squares.
	 * Squares are returned in the order added.
	 * 
	 * @return the iterator requested
	 */
	public Iterator<Square> elements() {
		// Note that this method uses your linked list!
		// so if the iterator doesn't work, that's on you...

		return new Iterator<>() {
			/**
			 * The current node pointed to by the
			 * iterator (containing the next value
			 * to be returned).
			 */
			private Node<Square> current = getHead();

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Square next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				Square ret = current.data;
				current = current.next;
				return ret;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean hasNext() {
				return (current != null);
			}
		};
	}

	/**
	 * sorts the quares in the window based on creation time.
	 * void return since this is just sorting.
	 */

	public void sortCreation() {
		Comparator<Square> comp = new Comparator<>() {
			public int compare(Square s1, Square s2) {
				if (s2.id() > s1.id()) {
					return -1;
				}

				return 1;

			}
		};

		ThreeTenLinkedList.NodePair<Square> pair = new ThreeTenLinkedList.NodePair<>(getHead(), getTail());

		// call the sort function with the comparator
		ThreeTenLinkedList.NodePair<Square> ret = ThreeTenLinkedList.sort(pair, comp);

		// make the returned list the head and tail of this list
		// this is for PART 5 of the project... don't try to do this
		// before you complete ThreeTenLinkedList.sort()!
		// < YOUR_CODE_HERE >
		squarelist.setHead(ret.head);
		squarelist.setTail(ret.tail);
		// Sorts the squares in the window by their creation time
		// (lower ids were created first). This should use your
		// ThreeTenLinkedList.sort() method you write in Part 5,
		// so don't do this until you have (a) read part 5,
		// (b) looked at the example in WindowStack, and (c) are
		// sure you understand comparators.

		// O(n^2)

		// < YOUR_CODE_HERE >
	}

	/**
	 * sorts the sqyares based on their location.
	 * void return since this is just sorting.
	 */

	public void sortLoc() {
		// create a way to compare windows by area
		Comparator<Square> comp = new Comparator<>() {
			public int compare(Square s1, Square s2) {
				// if the x cooridnate is the same, we compare the y values to see which is
				// greater
				if (s1.getUpperLeftX() == s2.getUpperLeftX()) {
					if (s1.getUpperLeftY() < s2.getUpperLeftY()) {
						return -1;
					} else {
						return 1;
					}
				}
				// if the x values are not equal, we compare them to see which is greater
				if (s1.getUpperLeftX() < s2.getUpperLeftX()) {
					return -1;
				} else {
					return 1;
				}
			}
		};

		ThreeTenLinkedList.NodePair<Square> pair = new ThreeTenLinkedList.NodePair<>(getHead(), getTail());

		// call the sort function with the comparator
		ThreeTenLinkedList.NodePair<Square> ret = ThreeTenLinkedList.sort(pair, comp);

		// make the returned list the head and tail of this list
		// this is for PART 5 of the project... don't try to do this
		// before you complete ThreeTenLinkedList.sort()!
		// < YOUR_CODE_HERE >
		squarelist.setHead(ret.head);
		squarelist.setTail(ret.tail);

		// re-select the top of the stack

		// Sorts the squares in the window by their location
		// in the window. Same rules as sorting the windows
		// in WindowStack. This should use your
		// ThreeTenLinkedList.sort() method you write in Part 5,
		// so don't do this until you have (a) read part 5,
		// (b) looked at the example in WindowStack, and (c) are
		// sure you understand comparators

		// O(n^2)

		// < YOUR_CODE_HERE >
	}
}
