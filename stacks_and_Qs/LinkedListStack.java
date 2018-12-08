package jonathan_schwartz_code_repository;

public class LinkedListStack<E> implements Stack<E> {
	private int t=-1;
	private SinglyLinkedList<E> data;
	
	
	public LinkedListStack() {
		data = new SinglyLinkedList<E>();
	}
	public int size() {
		return t+1;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void push(E e) {
		t++;
		//System.out.println("adding " + e + " at " + t);
		data.addFirst(e);
	}
	
	public E peek() {
		return data.first();
	}
	
	public E pop() {
		if(isEmpty()) {
			return null;
		}
		E topElement = data.removeFirst();
		t--;
		return topElement;
	}
	
	public String toString() {
		String out = "";
		out += data.toString();
		return out;
	}
	
	public static void main(String[] args) {
		LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
		lls.push(4);
		lls.push(2);
		lls.push(1);
		System.out.println(lls);
		System.out.println(lls.isEmpty() + " = false");
		System.out.println(lls.size() + " = 3\n");
		
		System.out.println("Top element: " + lls.peek());
		System.out.println("Popping... " + lls.pop());
		System.out.println("Popping... " + lls.pop());
		System.out.println("Popping... " + lls.pop() + "\n");
		
		System.out.println(lls.isEmpty() + " = true");
		System.out.println(lls.size() + " = 0");
	}
}
