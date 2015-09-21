package lab9ProgrammingProject10_1;

public class BinarySearchTreeArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               BinarySearchTreeArray <String> bsta1 = new BinarySearchTreeArray <String>();
               BinarySearchTreeArray <Integer> bsta2 = new BinarySearchTreeArray <Integer>();
               bsta1.add("dog");
               bsta1.add("turtle");
               bsta1.add("cat");
               bsta1.add("ferret");
               bsta1.add("shark");
               bsta1.add("whale");
               bsta1.add("porpoise");
               
               System.out.println("   " + "Element" + " " + "parent" + " " + "left" + " " + "right");
               for(int i=0;i<bsta1.size();i++)
                   bsta1.arrayRepresentation(i);
               bsta1.remove("ferret");
               System.out.println("   " + "Element" + " " + "parent" + " " + "left" + " " + "right");
               for(int i=0;i<bsta1.size();i++)
                   bsta1.arrayRepresentation(i);
               
               bsta2.add(3);
               bsta2.add(18);
               bsta2.add(4);
               bsta2.add(99);
               bsta2.add(50);
               bsta2.add(23);
               bsta2.add(5);
               bsta2.add(101);
               bsta2.add(77);
               bsta2.add(87);
               System.out.println("   " + "Element" + " " + "parent" + " " + "left" + " " + "right");
               for(int i=0;i<bsta2.size();i++)
                   bsta2.arrayRepresentation(i);
               bsta2.remove(50);
               System.out.println("   " + "Element" + " " + "parent" + " " + "left" + " " + "right");
               for(int i=0;i<bsta2.size();i++)
                   bsta2.arrayRepresentation(i);
	}

}
