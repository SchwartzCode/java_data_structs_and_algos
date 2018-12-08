package jonathan_schwartz_code_repository;

import java.util.Iterator;


public class CircularlyLinkedList<E> implements List<E> {

	public static class Node<E> {
		private E data;
		private Node<E> next;

		public Node(E e, Node<E> n) {
			this.data = e;
			this.next = n;
		}

		public E getData() {
			return this.data;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> n) {
			this.next = n;
		}
		
		public void setData(E e) {
			this.data = e;
		}

		public String toString() {
			return this.data.toString();
		}
	}

	private Node<E> tail = null;
	private int size = 0;

	public CircularlyLinkedList() {

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		if (isEmpty())
			return null;
		else
			return tail.getNext().getData();
	}

	public E last() {
		if (isEmpty())
			return null;
		else
			return tail.getData();
	}
	
	public void rotate() {
		
		if(isEmpty())
			System.out.println("ERROR: Cannot rotate when list is empty");
		else {
			tail = tail.getNext();
		}
	}

	public void addFirst(E data) {
		if (isEmpty()) {
			tail = new Node<E>(data, null);
			tail.setNext(tail);
		} else {
			Node<E> tmp = new Node<E>(data, tail.getNext());
			tail.setNext(tmp);
		}
		size++;
		return;
	}

	public void addLast(E data) {
		addFirst(data);
		tail = tail.getNext();
	}

	public E removeFirst() {
		if (isEmpty())
			return null;
		Node<E> head = tail.getNext();
		if (head == tail)
			tail = null;
		else
			tail.setNext(head.getNext());
		
		return head.getData();
	}


	public void add(int pos, E data) {
		if (pos > size)
			System.out.println("ERROR: Cannot add to array of size: " + size + " at index: " + pos);
		else if (isEmpty()) 
			addFirst(data);
		else if (pos == size)
			addLast(data);
		else {
			Node<E> tmp = tail;
			for(int i=0; i<pos; i++) {
				tmp = tmp.getNext();
			}
			Node<E> after = tmp.getNext();
			tmp.setNext(new Node<E>(data, after));
			size++;
		}
	}

	//starts at 0th for first element (element that head points to)
	public E get(int i) {
		if (isEmpty())
			return null;
		else if (i >= size) {
			System.out.println("ERROR: Cannot return element " + i + " of a " + size + " element array (indexes begin at 0)");
			return null;
		}
		else {
			Node<E> tmp = tail.getNext();
			for (int a=0; a<i; a++) {
				tmp = tmp.getNext();
			}
			return tmp.getData();
		}
	}

	
	public void set(int i, E e) {
		if (isEmpty()) {
			System.out.println("ERROR: List is empty. Cannot set value.");
			return;
		}
		else if (i >= size) {
			System.out.println("ERROR: Cannot set element " + i + " of a " + size + " element array (indexes begin at 0)");
			return;
		}
		else {
			Node<E> tmp = tail.getNext();
			for (int a=0; a<i; a++) {
				tmp = tmp.getNext();
			}
			tmp.setData(e);
		}
		
	}

	//starts at i=0 for first element
	public E remove(int i) {
		if (isEmpty()) {
			System.out.println("ERROR: List is empty. Cannot perform removal.");
			return null;
		}
		else if (i >= size) {
			System.out.println("ERROR: Cannot remove element " + i + " of a " + size + " element array (indexes begin at 0)");
			return null;
		}
		else {
			Node<E> tmp = tail;
			for (int a=0; a<i; a++) {
				tmp = tmp.getNext();
			}
			Node<E> removed = tmp.getNext();
			Node<E> after = removed.getNext();
			tmp.setNext(after);
			
			return removed.getData();
		}
	}
	
	public String toString() {
		String output = new String();
		output += "@size=" + size() + "\n";
		if (size > 0) {
			Node<E> tmp = tail.getNext();
			while(tmp != tail) {
				output += "> " + tmp.getData() + "\n";
				tmp = tmp.getNext();
			}
			output += "> " + tail.getData() + "\n";
		}
		return output;
	}

	// this method implements the Iterable interface, but we
	// need a new object to keep
	
	public Iterator<E> iterator() {
		return new ListIterator<E>();
	}

	public class ListIterator<T> implements Iterator<T> {

		@SuppressWarnings("unchecked")
		Node<T> curr = (Node<T>) tail;
		int pos = 0;

		@Override
		public boolean hasNext() {
			return pos != size;
		}

		@Override
		public T next() {
			T val = curr.getData();
			curr = curr.getNext();
			pos++;
			return val;
		}
	}
	
	
	public static void testList() {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		System.out.println(ll); // should be [1, 2, 3, 4]

		ll.addFirst(1);
		ll.addFirst(2);
		ll.addFirst(3);
		ll.addFirst(4);
		System.out.println(ll); // should be [4, 3, 2, 1, 1, 2, 3, 4]
		
		ll.rotate();
		System.out.println(ll); // should be [3, 2, 1, 1, 2, 3, 4, 4]
		
		System.out.println(ll.get(2)); // should be 1
		System.out.println(ll.removeFirst()); //should be 3
		System.out.println(ll.remove(3)); //should be 2
		ll.set(5, 99); 
		System.out.println(ll); //should be [2, 1, 1, 3, 4, 99]
		System.out.println(ll.first()); //should be 2
		System.out.println(ll.last()); //should be 99
	}
	
	public static void main(String[] args) {

		testList();
	}
}