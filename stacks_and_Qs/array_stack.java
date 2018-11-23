package stack_stuff;

public class array_stack<E> implements stack<E> {
	
	private int t = -1;
	private E[] data;
	private int MAXSIZE = 512;
	
	@SuppressWarnings("unchecked")
	public array_stack() {
		data = (E[]) new Object[MAXSIZE];
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
		data[t] = e;
	}
	
	public E peek() {
		return data[t];
	}
	
	public E pop() {
		if(isEmpty()) {
			return null;
		}
		E topElement = data[t];
		t--;
		return topElement;
	}
	
	public String toString() {
		String out = "";
		for (int i=0; i<size(); i++) {
			//System.out.println("data at " + i + ": " + data[i]);
			out += data[i] + " ";
		}
		return out;
	}
	
	public static void testJavaStack() {
		array_stack<Integer> S = new array_stack<Integer>();

		S.push(5); // contents: (5)

		S.push(3); // contents: (5, 3)
		 System.out.println(
		S.size() + " = 2"); // contents: (5, 3) outputs 2
		 System.out.println(
		S.pop() + " = 3"); // contents: (5) outputs 3
		 System.out.println(
		S.isEmpty() + " = false"); // contents: (5) outputs false
		 System.out.println(
		S.pop() + " = 5"); // contents: () outputs 5
		 System.out.println(
		S.isEmpty() + " = true"); // contents: () outputs true
		 try {
		 System.out.println(
		S.pop() + " = null"); // contents: () outputs null
		 } catch(java.util.EmptyStackException
		e) {
		 System.out.println("# Empty Stack");
		 }

		S.push(7); // contents: (7)

		S.push(9); // contents: (7, 9)

		 // NOTE: we need S.peek() instead of S.top()
		 System.out.println(
		S.peek() + " = 9"); // contents: (7, 9) outputs 9

		S.push(4); // contents: (7, 9, 4)
		 System.out.println(
		S.size() + " = 3"); // contents: (7, 9, 4) outputs 3
		 System.out.println(
		S.pop() + " = 4"); // contents: (7, 9) outputs 4

		S.push(6); // contents: (7, 9, 6)

		S.push(8); // contents: (7, 9, 6, 8)
		 System.out.println(
		S.pop() + " = 8"); // contents: (7, 9, 6) outputs 8
		 } 
	
	public static void main(String[] args) {
		
		testJavaStack();
		/*
		array_stack<Integer> s = new array_stack<Integer>();
		System.out.println(s.isEmpty()); 
		
		 for(int i = 0; i < 10; ++i) {
			 s.push(i);
		 }
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.toString());
		System.out.println(s.isEmpty());
		*/
		
	}

}
