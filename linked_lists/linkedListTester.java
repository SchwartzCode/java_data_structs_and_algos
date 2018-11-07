package comp20010;
import java.util.Random;

import comp20010.SinglyLinkedListIterator;

public class linkedListTester {
	private static Random random = new Random(20010);

	public static void test1() {
		SinglyLinkedListIterator<String> ll = new SinglyLinkedListIterator<String>();
		String[] data = {"one", "two", "three", "four", "five", "six", "seven", "eight"};
		
		for (int i=0; i<15; i++) {
			ll.addLast(data[random.nextInt(data.length)]);
		}
		System.out.println(ll); 
		
		int N=10;
		
		String[] procs = {"addFirst", "addLast", "removeFirst", "removeLast", "addBefore", "remove"};
		
		System.out.println("BOOP BOOP");
		
		for (int i=0; i<N; i++) {
			System.out.print(i + " -- ");
			
			String s = data[random.nextInt(data.length)];
			
			switch (procs[random.nextInt(procs.length)]) {
			case "addFirst":
				System.out.println("adding first: " + s);
				ll.addFirst(s);
				break;
			case "addLast":
				System.out.println("adding last: " + s);
				ll.addLast(s);
				break;
			case "removeFirst":
				System.out.println("removing first...");
				if (!ll.isEmpty()) {
					ll.removeFirst();
				}
				break;
			case "removeLast":
				System.out.println("removing last:...");
				if (!ll.isEmpty()) {
					ll.removeLast();
				}
				break;
			case "addBefore":
				System.out.print("adding_bef...");
				ll.add(random.nextInt(ll.size()), s);
				break;
			case "remove":
				int pos = random.nextInt(ll.size());
				System.out.println("removing.." + pos + "list size=" + ll.size());
				
				ll.remove(pos);
				break;
			default: 
				System.out.println("unknown");
				break;
			}
		}
		
		System.out.println("BEEP BEEP");
		
		System.out.println("size(ll): " + ll.size());
		for (String s : ll) {
			System.out.println("ll -> " + s);
		}
		
		
	}
	
	public static void main(String[] args) {
		test1();
	}
}
