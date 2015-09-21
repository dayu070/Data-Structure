package lab6Part2;

public class RunningMyMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CS401DblLinkedListImpl <String> dbl = new CS401DblLinkedListImpl <String> ();
		
		                       dbl.add("Bill");
		                       dbl.add("Rohan");
		                       dbl.add("James");
		                       dbl.add("Krishna");
		                       dbl.add("Javier");
		                       dbl.add("Lisa");
		                       
		                       dbl.print_from_beginning();           // 1st step
		                       
		                       dbl.print_from_end();                 // 2nd step
		                       
		                       dbl.remove(1);                        // 3rd step
		                       dbl.print_from_beginning(); 
		                       
		                       dbl.remove(5);                        // 4th step
		                       dbl.print_from_end();
		                       
		                       dbl.remove(3);                        // 5th step
		                       dbl.print_from_beginning();
	}

}
