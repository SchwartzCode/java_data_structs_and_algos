package stack_stuff;

public interface stack<E> {
		/**
		 * Returns the number of elements in the
		stack.
		 */
		int size();
		/**
		 * Tests whether the stack is empty.
		 */
		boolean isEmpty();
		 /*
		 * Inserts element at the top of the stack.
		 */
		void push(E e); 
		/**
		 * Returns, but does not remove, the element
		at the top of the stack.
		 */
		E peek();
		/**
		 * Removes and returns the top element from
		the stack.
		 */
		E pop();
} 
