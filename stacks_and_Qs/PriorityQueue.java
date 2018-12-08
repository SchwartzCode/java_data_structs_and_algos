package jonathan_schwartz_code_repository;


public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	private E[] data;
	private int MAXSIZE = 512;
	private int front = 0;
	private int rear = 0;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		data = (E[]) new Comparable[MAXSIZE];
	}
		 
	 
	 /**
	 * Returns the number of elements in the queue.
	 * @return number of elements in the queue
	 */
	 public int size() {
		 if (rear > front)
			 return (rear-front) % MAXSIZE;
		 else if (front > rear)
			 return (MAXSIZE - front) + rear;
		 else
			 return 0;
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
		 if (isEmpty()) {
			 data[rear] = e;
			 rear = (rear + 1) % MAXSIZE;
		 } else if (e.compareTo(data[front]) >= 0) {
			//adds value to front of queue if it is of higher priority than the first value
			 front = (front + MAXSIZE - 1)%MAXSIZE;
			 data[front] = e;
		 }
		 else {
			 for (int i=0; i<size(); i++) {
				 E temp = data[(front + i) % MAXSIZE];
				 
				 if(i+1 == size()) {
					 //adds value to end of queue if it is lower in priority than all current values
					 data[rear] = e;
					 rear = (rear + 1) % MAXSIZE;
					 break;
				 } else if (e.compareTo(temp) != -1) {
					 //adds value to queue behind the last value that is of higher priority than it
					 rear = (rear + 1) % MAXSIZE;
					 for (int j=size(); j>=i; j--) {
						 data[(front+j+1)%MAXSIZE] = data[(front+j)%MAXSIZE];
					 }
					 data[(front + i)%MAXSIZE] = e;
					 break;
				 }
				
			 }
			 
		 }
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
		 int storage = front;
		 front = (front +1)%MAXSIZE;
		 return data[storage];
	 }
	 
	 public String toString() {
		 String out = "";
		 int i = 0;
		 while (i < size()) {
			 out += data[(front + i) % MAXSIZE] + "\n";
			 i++;
		 }
		 
		 return out;
	 }
	 
	 public static void main(String [] args) {

		 PriorityQueue<Student> pq = new PriorityQueue<Student>();
		 
		
		 pq.enqueue(new Student("Nataly Ware", 21, 4.0));
		 pq.enqueue(new Student("Mira Weiss", 19, 3.5));
		 pq.enqueue(new Student("Emilie Gibbs", 20, 3.2));
		 pq.enqueue(new Student("Lisa Boone", 22, 4.7));
		 pq.enqueue(new Student("Karsyn Terry", 20, 4.8));
		 pq.enqueue(new Student("Jeremy Schwartz", 18, 4.6));
		 pq.enqueue(new Student("Aleah Gaines", 19, 4.1));
		 pq.enqueue(new Student("Arianna Reeves", 20, 3.9));
		 pq.enqueue(new Student("Walker Holloway", 22, 3.8));
		 pq.enqueue(new Student("Adelyn Walter", 24, 4.95));
		 pq.enqueue(new Student("Damion Sanders", 25, 3.2));
		 pq.enqueue(new Student("Aimee Quinn", 21, 2.7));
		 //System.out.println(pq);
		 
		 while (!pq.isEmpty()) {
			 System.out.println(pq.dequeue());
		 }
	 }
}
