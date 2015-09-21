package lab7Part1;

public class TestForQueueArrayFixed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CS401QueueArrayFixedImpl<Integer> qafi = new CS401QueueArrayFixedImpl<Integer> (1);
		qafi.remove();
		System.out.println("At the beginning, the queue is empty? " + qafi.is_empty());
		System.out.println("At the beginning, the queue is full? " + qafi.is_full());
		qafi.add(1);
		System.out.println("After one insertion, the queue is empty? " + qafi.is_empty());
		System.out.println("After one insertion, the queue is full? " + qafi.is_full());
		qafi.add(2);
		System.out.println("The element in the front of the queue is " + qafi.peek());
		System.out.println("Element " + qafi.remove() + " has been removed");
		System.out.println("Element " + qafi.remove() + " has been removed");
		System.out.println("After two insertions and two deletions, the queue is empty? " + qafi.is_empty());
		System.out.println("After two insertions and two deletions, the queue is empty? " + qafi.is_full());
	}
	

}
