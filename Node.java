/**
 * {@Summary} This class initializes the node data to be used in the rest of the code. 
 * @author Warisa Khan.
 * @param <T> is the generic T.
 */

class Node<T> {
	/**
	 * data is the data being provided.
	 */
	public T data;
	/**
	 * next will allow you to access the next node.
	 */
	public Node<T> next;
	/**
	 * prev will allow you to access the previous node.
	 */
	public Node<T> prev;
	/**
	 * constructor to initalize nodes.
	 */
	public Node() {
		
	}
	/**
	 * the data being put into the nodes that are being created in the other classes.
	 * @param data is the data being put into the node. 
	 */
	public Node(T data) {
		this.data = data;
	}
}