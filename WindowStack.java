import java.util.Iterator;
import java.util.NoSuchElementException;

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
 */

public class WindowStack {
	/**
	 * windowstack is an object of threetenlinkedlist.
	 */
	private ThreeTenLinkedList<Window> windowstack;
	// You'll need some instance variables probably...
	// < YOUR_CODE_HERE >

	/**
	 * this is a constructor.
	 */
	public WindowStack() {
		windowstack = new ThreeTenLinkedList<>();
		// Any initialization code you need.

		// O(1)

		// < YOUR_CODE_HERE >
	}

	/**
	 * getter method for head.
	 * 
	 * @return the head.
	 */

	public Node<Window> getHead() {
		// Returns the head (top) of the stack of windows.

		// O(1)

		// We will use this method to test your
		// linked list implementaiton of this
		// class, so whether or not you are using
		// the generic linked list class or bare
		// nodes, you must still be able to return
		// the appropriate head of the list.

		// < YOUR_CODE_HERE >

		return windowstack.getHead(); // dummy return, replace this!
	}

	/**
	 * getter method for tail.
	 * 
	 * @return the tail.
	 */

	public Node<Window> getTail() {
		// Returns the tail (bottom) of the stack of windows.

		// O(1)

		// We will use this method to test your
		// linked list implementaiton of this
		// class, so whether or not you are using
		// the generic linked list class or bare
		// nodes, you must still be able to return
		// the appropriate tail of the list.

		// < YOUR_CODE_HERE >

		return windowstack.getTail(); // dummy return, replace this!
	}

	/**
	 * getter method for the number of windows.
	 * 
	 * @return the size.
	 */

	public int numWindows() {
		// Gets the number of windows in the stack.

		// O(1)

		return windowstack.getSize();
	}

	/**
	 * adds the window to the stack.
	 * 
	 * @param r is the window parameter being added.
	 */
	public void add(Window r) {
		// if r is null, throw an illegal argument exception
		if (r == null) {
			throw new IllegalArgumentException();
		}

		this.windowstack.addHead(r);
		// if the size is one, still deletes the window
		if (windowstack.getSize() != 1) {
			windowstack.getHead().next.data.setSelected(false);
			windowstack.getHead().data.setSelected(true);
			// windowstack.getHead().data.setSelected(true);
		} else {
			// if the size is greater than one, will remove the windows as well
			// windowstack.getHead().next.data.setSelected(false);
			// windowstack.getHead().data.setSelected(true);
			windowstack.getHead().data.setSelected(true);
		}

		// Add a window at the top of the stack.

		// O(1)

		// throw IllegalArgumentException for invalid windows

		// Note: the "top" of the stack should
		// be the head of your linked list.

		// < YOUR_CODE_HERE >
	}

	/**
	 * handleclick will see what to do based on the left or right handleclick of the
	 * user.
	 * If it is a left click, will add a window.
	 * If it is a right click, will delete a window.
	 * 
	 * @param x         is the x coordinate of the click.
	 * @param y         is the y coordinate of the click.
	 * @param leftClick is the click happening.
	 * @return boolean true if the handleclick was properly added or removed.
	 */
	public boolean handleClick(int x, int y, boolean leftClick) {
		Node<Window> currentNode = windowstack.getHead();
		int count = windowstack.getSize();
		boolean result = false;
		// seeing if a leftclick was selected;
		if (leftClick == true) {
			// if there is no windows or squares, will return false
			if (count == 0) {
				return result;

			}
			// if the head contains the point, use the handleClick in Windows to click on
			// the window
			// result will return true because we are able to click it
			if (getHead().data.contains(x, y)) {
				getHead().data.handleClick(x, y);
				result = true;
				return true;
			}
			// as long as the head is not null we can remove the windows for a left click
			while (currentNode != null) {
				// if the data matches the point x,y, we can select the window and remove it
				if (currentNode.data.contains(x, y)) {
					getHead().data.setSelected(false);
					windowstack.remove(currentNode);
					// after removal, we add the data of the head and change the selected to be true
					// to indicate that we were able to click it
					add(currentNode.data);
					currentNode.data.setSelected(true);
					result = true;
					return true;
				}
				// set the node to the next nodes value
				currentNode = currentNode.next;
			}
			result = false;
			return false;

		}
		// if a right click happens the following will occur
		if (leftClick != true) {
			// if there are no windows, return false;
			if (count == 0) {
				return result;

			}
			// if the head contains the point x,t we can remove the selected window
			if (getHead().data.contains(x, y)) {
				// setSelected is false since we can not select any window
				windowstack.getHead().data.setSelected(false);
				windowstack.remove(currentNode);
				// if th size is >= 1 window, we can select and change set Selected to true
				if (windowstack.getSize() >= 1) {
					windowstack.getHead().data.setSelected(true);
				}
				result = true;
				return result;
			}

			windowstack.getHead().data.setSelected(true);
			// while the head is not null we can do the following
			while (currentNode != null) {
				// checking to see if the node contains the point x,y
				if (currentNode.data.contains(x, y)) {
					// if it does, we can sucessfully remove the selected node.
					windowstack.remove(currentNode);
					windowstack.getHead().data.setSelected(true);
					result = true;
					return true;
				}
				// current node is set to the next node.
				currentNode = currentNode.next;

			}

		}

		result = true;
		return true;

		// if the leftclick is equal to true or false

		// The mouse has been clicked at position (x,y).
		// Left clicks move windows to the top of the
		// stack or pass the click on to the window at the
		// top. Right clicks remove windows.

		// Returns true if the click was handled, false
		// if no window was found.

		// O(n) where n is the number of windows in the stack

		// Details:

		// Find the top-most window on the stack (if any)
		// that contains the given coordinate.

		// For a left click:

		// If the window is not at the top of the stack,
		// move it to the top of the stack without
		// disturbing the order of the other windows.
		// Mark this window as the "selected" window (and
		// ensure the previous selected window is no longer
		// selected).

		// If the window is at the top of the stack already,
		// ask the window to handle a click-event (using the
		// Window's handleClick() method).

		// If none of the windows on the stack were clicked
		// on, just return.

		// For a right click:

		// Remove the window from the stack completely. The
		// window at the top of the stack should be the
		// selected window.

		// Hint #1: This would be a great time to use helper
		// methods! If you just write one giant method...
		// it'll be much harder to debug...

		// Hint #2: Make sure to use the methods you wrote
		// in the Window class. Don't write those again!

		// < YOUR_CODE_HERE >

		// dummy return, replace this!
	}

	/**
	 * Gets an iterator for the stack of windows.
	 * Windows are returned from bottom to top.
	 * 
	 * @return the iterator requested.
	 */
	public Iterator<Window> windows() {
		// Note that this method uses your linked list!
		// so if the iterator doesn't work, that's on you...

		return new Iterator<>() {
			/**
			 * The current node pointed to by the
			 * iterator (containing the next value
			 * to be returned).
			 */
			private Node<Window> current = getTail();

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Window next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				Window ret = current.data;
				current = current.prev;
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
	 * sort that sorts the size of the windows.
	 */
	public void sortSize() {
		// Sorts the windows in the stack by their area (length x width).
		// MOST of this is done for you, but you still need to assign
		// the returned head and tail back.

		// unselect the top window
		this.getHead().data.setSelected(false);

		// create a way to compare windows by area
		Comparator<Window> comp = new Comparator<>() {
			public int compare(Window w1, Window w2) {
				return (w1.getWidth() * w1.getHeight()) - (w2.getWidth() * w2.getHeight());
			}
		};

		// create a pair of nodes to pass into the sort function
		ThreeTenLinkedList.NodePair<Window> pair = new ThreeTenLinkedList.NodePair<>(getHead(), getTail());

		// call the sort function with the comparator
		ThreeTenLinkedList.NodePair<Window> ret = ThreeTenLinkedList.sort(pair, comp);

		// make the returned list the head and tail of this list
		// this is for PART 5 of the project... don't try to do this
		// before you complete ThreeTenLinkedList.sort()!
		// < YOUR_CODE_HERE >
		windowstack.setHead(ret.head);
		windowstack.setTail(ret.tail);

		// re-select the top of the stack
		this.getHead().data.setSelected(true);

	}

	/**
	 * sorts by the location of the windows.
	 */
	public void sortLoc() {
		this.getHead().data.setSelected(false);

		// create a way to compare windows by area
		Comparator<Window> comp = new Comparator<>() {
			public int compare(Window w1, Window w2) {
				// if is is the same x coordinate, we will check the y values of the points.
				if (w1.getUpperLeftX() == w2.getUpperLeftX()) {
					// if the w1 y value is greater than the w2 y value, we return 1 for already in
					// order
					if (w1.getUpperLeftY() < w2.getUpperLeftY()) {
						return 1;
					} else {
						return -1;
					}
				}
				// if the x does not match we compare them to see if they are in order
				if (w1.getUpperLeftX() < w2.getUpperLeftX()) {
					return 1;
				} else {
					return -1;
				}

			}
		};

		ThreeTenLinkedList.NodePair<Window> pair = new ThreeTenLinkedList.NodePair<>(getHead(), getTail());

		// call the sort function with the comparator
		ThreeTenLinkedList.NodePair<Window> ret = ThreeTenLinkedList.sort(pair, comp);

		// make the returned list the head and tail of this list
		// this is for PART 5 of the project... don't try to do this
		// before you complete ThreeTenLinkedList.sort()!
		// < YOUR_CODE_HERE >
		windowstack.setHead(ret.head);
		windowstack.setTail(ret.tail);

		// re-select the top of the stack
		this.getHead().data.setSelected(true);

		// call the sort function with the comparator

		// Sorts the windows in the stack by their upper left
		// corner loction. Left things (bigger-X) are on top
		// of right things (smaller-X). Tie-breaker: lower
		// things (bigger-Y) top of higher things (smaller-Y).

		// This should use your ThreeTenLinkedList.sort() method you
		// write in Part 5, so don't do this until you have (a) read
		// part 5, (b) looked at the example in sortSize() above, and
		// (c) are sure you understand comparators.

		// O(n^2)

		// < YOUR_CODE_HERE >
	}
}
