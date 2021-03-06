package jonathan_schwartz_code_repository;
import java.util.Iterator;


/**
 * A basic doubly linked list implementation.
 * 
 */
public class DoublyLinkedList<E> implements List<E> {

	private static class Node<E> {

		/** The element stored at this node */
		private E data; // reference to the element stored at this node

		/** A reference to the preceding node in the list */
		private Node<E> prev; // reference to the previous node in the list

		/** A reference to the subsequent node in the list */
		private Node<E> next; // reference to the subsequent node in the list

		/**
		 * Creates a node with the given element and next node.
		 *
		 * @param e the element to be stored
		 * @param p reference to a node that should precede the new node
		 * @param n reference to a node that should follow the new node
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			data = e;
			prev = p;
			next = n;
		}

		// public accessor methods
		/**
		 * Returns the element stored at the node.
		 * 
		 * @return the element stored at the node
		 */
		public E getData() {
			return data;
		}

		/**
		 * Returns the node that precedes this one (or null if no such node).
		 * 
		 * @return the preceding node
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Returns the node that follows this one (or null if no such node).
		 * 
		 * @return the following node
		 */
		public Node<E> getNext() {
			return next;
		}

		// Update methods
		/**
		 * Sets the node's previous reference to point to Node n.
		 * 
		 * @param p the node that should precede this one
		 */
		public void setPrev(Node<E> p) {
			prev = p;
		}

		/**
		 * Sets the node's next reference to point to Node n.
		 * 
		 * @param n the node that should follow this one
		 */
		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	/** Sentinel node at the beginning of the list */
	private Node<E> header; // header sentinel

	/** Sentinel node at the end of the list */
	private Node<E> trailer; // trailer sentinel

	/** Number of elements in the list (not including sentinels) */
	private int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyLinkedList() {
		header = new Node<>(null, null, null); // create header
		trailer = new Node<>(null, header, null); // trailer is preceded by header
		header.setNext(trailer); // header is followed by trailer
	}

	// public accessor methods
	/**
	 * Returns the number of elements in the linked list.
	 * 
	 * @return number of elements in the linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the first element of the list.
	 * 
	 * @return element at the front of the list (or null if empty)
	 */
	public E first() {
		return header.getNext().getData();
	}

	/**
	 * Returns (but does not remove) the last element of the list.
	 * 
	 * @return element at the end of the list (or null if empty)
	 */
	public E last() {
		return trailer.getPrev().getData();
	}

	// public update methods
	/**
	 * Adds an element to the front of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addFirst(E e) {
		addBetween(e, header, header.getNext()); // place just after the header
	}

	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param e the new element to add
	 */
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public Node<E> removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return this.remove(header.getNext());
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the removed element (or null if empty)
	 */
	public Node<E> removeLast() {
		if (header.getNext() == trailer) {
			return null;
		}
		return this.remove(trailer.getPrev());
	}

	// private update methods
	/**
	 * Adds an element to the linked list in between the given nodes. The given
	 * predecessor and successor should be neighboring each other prior to the call.
	 *
	 * @param predecessor node just before the location where the new element is
	 *                    inserted
	 * @param successor   node just after the location where the new element is
	 *                    inserted
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newNode = new Node<E>(e, predecessor, successor);
		predecessor.setNext(newNode);
		successor.setPrev(newNode);
		size++;
		return;
	}

	/**
	 * Removes the given node from the list and returns its element.
	 * 
	 * @param node the node to be removed (must not be a sentinel)
	 */
	private Node<E> remove(Node<E> node) {
		Node<E> prev = node.getPrev();
		Node<E> succ = node.getNext();
		prev.setNext(succ);
		succ.setPrev(prev);
		size--;
		return node;
	}

	@Override
	public Iterator<E> iterator() {
		
		return new ListIterator<E>();
	}
	
	private class ListIterator<T> implements Iterator<T> {
		// TODO 
		public boolean hasNext() {return false;}
		
		public T next() {return null;}
	}

	@Override
	public E get(int i) {
		E data;
		if (i > size) {
			return null;
		}
		else {
			Node<E> tmp = header;
			for (int j=0; j<=i; j++) {
				tmp = tmp.getNext();
			}
			data = tmp.getData();
		}
		return data;
	}

	@Override
	public void set(int i, E e) {
		if (i > size || i<0) {
			return;
		}
		
		Node<E> before = header;
		for (int j=0; j<i; j++) {
			before = before.getNext();
		}
		
		Node<E> after = before.getNext().getNext();
		Node<E> insert = new Node<E>(e, before, after);
		before.setNext(insert);
		after.setPrev(insert);
		
		return;
	}

	//inserts element E before location i, with i=0 being the first element in the list
	public void add(int i, E e) {
		if (i>=size || i<0) {
			return;
		}
		
		Node<E> before = header;
		for (int j=0; j<i; j++) {
			before = before.getNext();
		}
		
		Node<E> after = before.getNext();
		Node<E> insert = new Node<E>(e, before, after);
		before.setNext(insert);
		after.setPrev(insert);
		size++;
		
		return;
	}

	//removes element i in the list, with i=0 being the first element
	public E remove(int i) {
		if (i>=size || i<0) {
		return null;
		}
		
		Node<E> before = header;
		for (int j=0; j<i; j++) {
			before = before.getNext();
		}
		
		Node<E> removed = before.getNext();
		Node<E> after = removed.getNext();
		
		before.setNext(after);
		after.setPrev(before);
		size--;
		
		return removed.getData();
	}

	/**
	 * Produces a string representation of the contents of the list. This exists for
	 * debugging purposes only.
	 */
	public String toString() {
		String output = "";
		output += "@size=" + size() + "\n";
		Node<E> curr = header.getNext();
		while (curr != trailer) {
			output += "> " + curr.getData() + "\n";
			curr = curr.getNext();
		}
		
		return output;
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		System.out.println(ll); //@size=0
		ll.addFirst(5); 	
		System.out.println(ll);	//(5)
		ll.addFirst(15);	
		System.out.println(ll);	//(15, 5)
		ll.addLast(55);		
		System.out.println(ll);	//(15, 5, 55)
		ll.add(1, 444);		
		System.out.println(ll);	//(15, 444, 5, 55)
		
		
		
		System.out.println("Removing value at pos=3: " + ll.remove(3));
		System.out.println(ll);
		System.out.println("Value at pos=1 is: " + ll.get(1));	//444
		System.out.println("Removing first: " + ll.removeFirst().getData());
		System.out.println(ll);
		System.out.println("Removing last: " + ll.removeLast().getData());
		System.out.println(ll);
	
		System.out.println("Adding -1 at pos=0...");
		ll.add(0, -1);
		System.out.println("Adding last: 10... 210... 30... 500");
		ll.addLast(10);
		ll.addLast(210);
		ll.addLast(30);
		ll.addLast(500);
		
		
		System.out.println(ll);
	}
}
