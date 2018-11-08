package comp20010_practical2;
//package lists;



import java.util.Iterator;

public class SinglyLinkedList {
	/**
	 * Node of a singly linked list, which stores a reference to its element and to
	 * the subsequent node in the list (or null if this is the last node).
	 */
	private static class Node {

		/** The element stored at this node */
		private String element; // reference to the element stored at this node

		/** A reference to the subsequent node in the list */
		private Node next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e: the element to be stored
		 * @param n: reference to a node that should follow the new node
		 */
		public Node(String e, Node n) {
			element = e;
			next = n;
		}

		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		private String getElement() {
			return this.element;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node getNext() {
			return this.next;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n
		 *            the node that should follow this one
		 */
		public void setNext(Node n) {
			next = n;
		}
		
		public String toString() {
			return element;
		}
	} 

	// instance variables of the SinglyLinkedList
	/** The head node of the list */
	private Node head = null; // head node of the list (or null if empty)

	/** The last node of the list */
	private Node tail = null; // last node of the list (or null if empty)

	/** Number of nodes in the list */
	private int size = 0; // number of nodes in the list

	/** Constructs an initially empty list. */
	public SinglyLinkedList() {
	} 

	// access methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {return false;}
	}

	/**
	 * Returns (but does not remove) the first element of the list
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public String first() { // returns (but does not remove) the first element
		if (head == null) {
			return null;
		}
		return head.getElement();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public String last() { // returns (but does not remove) the last element
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		return tmp.getElement();
	}

	// update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addFirst(String e) { // adds element e to the front of the list
		Node tmp = new Node(e, this.head);
		this.head = tmp;
	}


	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e
	 *            the new element to add
	 */
	public void addLast(String e) { // adds element e to the end of the list
		Node tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		Node netTail = new Node(e, tmp);
		tmp.setNext(netTail);
		size += 1;
	}
	
	public void insertBefore(String key, String s) {
		// TODO
	}

	public void remove(String key) {
		// TODO
	}
	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public Node removeFirst() { // removes and returns the first element
		// TODO
	}

	public Object copy() {
		// TODO
	}
	@SuppressWarnings({ "unchecked" })
	public boolean equals(Object o) {
		// TODO
	}


	public Iterator<String> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<String> {
		// TODO
	}
	/**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
  public String toString() {
	  String output = new String();
	  Node tmp = this.head;
	  output += head;
	  while (tmp.getNext() != null) {
		  tmp = tmp.getNext();
		  output += tmp;
	  }
	  
	  return output;
  }
  
  public static void main(String[] args) {
	  System.out.println("aa");
  }
}
