package jonathan_schwartz_code_repository;

public class LinkedListQueue<E> implements Queue<E> {
	private SinglyLinkedList<E> data;
	
	public LinkedListQueue() {
		data = new SinglyLinkedList<E>();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public void enqueue(E e) {
		data.addLast(e);
	}
	
	public E first() {
		return data.first();
	}
	
	public E dequeue() {
		return data.removeFirst();
	}
	
	public String toString() {
		return data.toString();
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>();
		
		System.out.println(q.isEmpty() + " = true");
		System.out.println(q.size() + " = 0\n");
		 
		 for(int i = 0; i < 10; ++i) {
			 q.enqueue(i);
		 }
		 
		 
		 System.out.println("Size:\t\t" + q.size()); //10
		 
		 System.out.println("Initial:\t" + q); // (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

		 q.dequeue();
		 System.out.println("Dequeue:\t" + q); // (1, 2, 3, 4, 5, 6, 7, 8, 9)
		 q.dequeue();
		 System.out.println("Dequeue:\t" + q); // (2, 3, 4, 5, 6, 7, 8, 9)
		 q.enqueue(-1);
		 System.out.println("Enqueue(-1):\t" + q); // (2, 3, 4, 5, 6, 7, 8, 9, -1)
		 System.out.println("First element:\t" + q.first() + "\n"); // 2
		 
		 System.out.println(q.isEmpty() + " = false");
		 System.out.println(q.size() + " = 9");
	}
}
