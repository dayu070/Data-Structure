package lab7Part1;

public class TestForQueueLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CS401QueueLinkedListImpl<Integer> qafi = new CS401QueueLinkedListImpl<Integer> ();
		qafi.remove();
		System.out.println("At the beginning, the queue is empty? " + qafi.is_empty());
		
		qafi.add(1);
		System.out.println("After one insertion, the queue is empty? " + qafi.is_empty());
		
		qafi.add(2);
		System.out.println("The element in the front of the queue is " + qafi.peek());
		System.out.println("Element " + qafi.remove() + " has been removed");
		System.out.println("Element " + qafi.remove() + " has been removed");
		System.out.println("After two insertions and two deletions, the queue is empty? " + qafi.is_empty());
	
	}

}
