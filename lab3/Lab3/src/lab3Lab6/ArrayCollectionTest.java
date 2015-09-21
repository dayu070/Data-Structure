package lab3Lab6;

public class ArrayCollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		             new ArrayCollectionTest().run();

	}
	
	public void run()
	{
		ArrayCollection<String> ac1 = new ArrayCollection <String>();
		ArrayCollection<String> ac2 = new ArrayCollection <String>();
		ac1.add("a");
		ac1.add("b");
		ac1.add("c");
		System.out.print(ac1);
		System.out.println(ac1.remove("b"));
		System.out.println(ac1.remove("d"));
		System.out.print(ac1);
		
		
		ac2.add("a");
		System.out.println(ac1.equals(ac2));
		ac2.add("c");
		ac2.add("b");
		System.out.println(ac1.equals(ac2));
		System.out.println(ac2.remove("b"));
		System.out.println(ac1.equals(ac2));
		
	}

}
