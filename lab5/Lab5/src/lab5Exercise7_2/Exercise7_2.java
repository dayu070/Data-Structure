package lab5Exercise7_2;

import java.util.*;

public class Exercise7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                    LinkedList<Character> letters = new LinkedList<Character>();
                    
                    ListIterator<Character> itr = letters.listIterator();
                    
                    itr.add('f');
                    itr.add('t');
                    itr.previous();
                    itr.previous();
                    
                    itr.add('e');
                    itr.add('r');
                    itr.next();
                    itr.add('e');
                    itr.add('c');
                    itr = letters.listIterator();
                    itr.add('p');
                    System.out.println(letters);
	}

}
