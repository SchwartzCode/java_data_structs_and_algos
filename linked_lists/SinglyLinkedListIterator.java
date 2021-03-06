package comp20010;

/*
This is the generic version of the SinglyLinkedList

You need to change the signature from:

public class SinglyLinkedList {

to:

public class SinglyLinkedList<E> {

and update all the other cases where 'String' should be replaced with 'E'.

 */

import java.util.Iterator;


/*
 * Implementing this interface allows an object to be the target of
 * the "for-each loop" statement. See
 */
public class SinglyLinkedListIterator<E> implements Iterable<E>, List<E> {

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

		public String toString() {
			return this.data.toString();
		}
	}

	private Node<E> head = null;
	private int size = 0;

	public SinglyLinkedListIterator() {

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		if (head == null) {
			return null;
		}
		return (E) head.getData();
	}

	public E last() {
		Node<E> tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		return tmp.getData();
	}

	public void addFirst(E data) {
		Node<E> tmp = new Node<E>(data, this.head);
		this.head = tmp;
		size++;
	}

	public void addLast(E data) {
		if (size == 0) {
			Node<E> newTail = new Node<E>(data, null);
			head = newTail;
			size += 1;
			return;
		}
		Node<E> tmp = head;
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
		}
		Node<E> newTail = new Node<E>(data, null);
		tmp.setNext(newTail);
		size += 1;
		return;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null; // nothing to remove
		}
		E res = head.getData();
		head = head.getNext(); // will become null if list had only one node
		size--;
		return res;
	}

	public E removeLast() {
		if(isEmpty()) {
			return null;
		}	
		if(size() == 1) {
			E res = head.getData();
			head = null;
			return res;
		}
		Node<E> prev = head;
		Node<E> curr = prev.getNext();
		while (curr.getNext() != null) {
			prev = curr;
			curr = curr.getNext();
		}
		E res = curr.getData();
		prev.setNext(null);
		size--;
		return res;
	}

	public void add(int pos, E data) {
		if(size() == 0) {
			head = new Node<E>(data, null);
			size++;
			return;
		}
		if(size() <= pos) {
			System.out.println("size: " + size() + " " + pos);
			return;
		}
		int k = 1;
		Node<E> tmp = head;
		Node<E> next = tmp.getNext();
		while(tmp.getNext() != null && k++ < pos) {
			tmp = tmp.getNext();
			next=next.getNext();
		}
		System.out.println("pos: " + pos + ", data: " + data);
		if (pos == 0) {
			head = new Node<E>(data, head);
			size++;
			return;
		}
		tmp.setNext(new Node<E>(data, tmp.getNext()));
		size++;
	}

	//starts at 0th for first element (element that head points to)
	public E get(int i) {
		E data;
		if (i > size) {
			return null;
		}
		else {
			Node<E> tmp = head;
			for (int j=0; j<i; j++) {
				tmp = tmp.getNext();
			}
			data = tmp.getData();
		}
		return data;
	}

	
	public void set(int i, E e) {
		if (i > size) {
			return;
		}
		else {
			Node<E> tmp = head;
			for (int j=1; j<i; j++) {
				tmp = tmp.getNext();
			}
			
			Node<E> new_node = new Node<E>(e, tmp.getNext());
			
			if (i==1)		
			{head = new_node;}
			else {
				Node<E> tmp2 = head;
				for (int a=1; a<i-1; a++) {
					tmp2=tmp2.getNext();
				}
				tmp2.setNext(new_node);
			}
		}
		size++;
		return;
		
	}

	//starts at i=1 for first element
	public E remove(int i) {
		
		if (i > size) {
			return null;
		}
		
		Node<E> before = head;
		Node<E> removed = head.getNext();
		for (int j=0; j<i-1; j++) {
			removed = removed.getNext();
			before = before.getNext();
		}
		
		Node<E> after_node = removed.getNext();
		
		if (i == 0) {
			head = head.getNext();
		}
		else {
			before.setNext(after_node);
		}
		
		size--;
		return removed.getData();

	}
	
	public String toString() {
		String output = new String();
		output += "@size=" + size() + "\n";
		for (E tmp : this) {
			output += "> " + tmp + "\n";
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
		Node<T> curr = (Node<T>) head;

		@Override
		public boolean hasNext() {
			return curr != null;
		}

		@Override
		public T next() {
			T val = curr.getData();
			curr = curr.getNext();
			return val;
		}
	}
	
	public void reverse() {
		Node<E> prev = null;
		Node<E> curr = head;		
		Node<E> next = curr.getNext();
		
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
		
	}
	
	public static void testList() {
		SinglyLinkedListIterator<Integer> ll = new SinglyLinkedListIterator<Integer>();
		
		ll.add(0, 10);
		ll.addFirst(210);
		ll.addLast(30);
		ll.add(0, 500);
		System.out.println(ll);

		ll.reverse();
		
		System.out.println(ll);
		
		/*
		for (Integer i : ll) {
			System.out.println("i: " + i);
		}
		
		System.out.println(ll);

		
		System.out.println("last node: " + ll.last() + " " + ll.removeLast());
		System.out.println(ll);
		
		System.out.println("remove first: " + ll.removeFirst());
		System.out.println(ll);		

		System.out.println("remove first: " + ll.removeFirst());
		System.out.println(ll);	
		
		System.out.println("remove first: " + ll.removeFirst());
		System.out.println(ll);	
		
		System.out.println("remove first: " + ll.removeFirst());
		System.out.println(ll);	
		*/
	}
	
	public static void testAddRemove() {
		SinglyLinkedListIterator<Integer> ll = new SinglyLinkedListIterator<Integer>();
		/*
		ll.add(0, -1);
		ll.addLast(10);
		ll.addLast(210);
		ll.addLast(30);
		ll.addLast(500);
		*/
		
		for (int i=0; i<10; i++) {
			ll.addLast(i);
		}
		System.out.println(ll);
		
		System.out.println(ll.remove(6));

		
		
		
		System.out.println(ll);
	}
	public static void main(String[] args) {
		testAddRemove();
	}


}