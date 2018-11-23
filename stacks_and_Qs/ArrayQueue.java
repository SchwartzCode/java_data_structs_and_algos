package stack_stuff;

public class ArrayQueue<E> implements Queue<E>{
	
	private E[] data;
	private int MAXSIZE = 512;
	private int front = 0;
	private int rear = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		data = (E[]) new Object[MAXSIZE];
	}
		 
	 
	 /**
	 * Returns the number of elements in the queue.
	 * @return number of elements in the queue
	 */
	 public int size() {
		 return (rear-front) % MAXSIZE;
	 } 
	 /**
	 * Tests whether the queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	 public boolean isEmpty() {
		 return front == rear;
	 }
	 /**
	 * Inserts an element at the rear of the queue.
	 * @param e the element to be inserted
	 */
	 public void enqueue(E e) {
		 data[rear] = e;
		 rear = (rear + 1) % MAXSIZE;
	 }
	 /**
	 * Returns, but does not remove, the first element of the queue.
	 * @return the first element of the queue (or null if empty)
	 */
	 public E first() {
		 return data[front];
	 }
	 /**
	 * Removes and returns the first element of the queue.
	 * @return element removed (or null if empty)
	 */
	 public E dequeue() {
		 front++;
		 return data[front-1];
	 }
	 
	 public String toString() {
		 String out = "";
		 int i = front;
		 while (i < front + size()) {
			 out += data[i] + " ";
			 i++;
		 }
		 
		 return out;
	 }
	 
	 public static void main(String [] args) {

		 ArrayQueue<Integer> q = new ArrayQueue<Integer>();
		 
		 for(int i = 0; i < 10; ++i) {
			 q.enqueue(i);
		 }
		 
		 System.out.println("aa");
		 
		 System.out.println(q.toString());
		 
		 System.out.println(q.size());
		 
		 System.out.println("q:" + q); // q:(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

		 q.dequeue();
		 System.out.println("q:" + q); // q:(1, 2, 3, 4, 5, 6, 7, 8, 9)
		 q.dequeue();
		 System.out.println("q:" + q); // q:(2, 3, 4, 5, 6, 7, 8, 9)
		 q.enqueue(-1);
		 System.out.println("q:" + q); // q:(2, 3, 4, 5, 6, 7, 8, 9, -1)
		 
	 }
}