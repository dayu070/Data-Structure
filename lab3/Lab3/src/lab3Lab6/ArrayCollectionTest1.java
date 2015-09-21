package lab3Lab6;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class ArrayCollectionTest1 extends TestCase {
	     private ArrayCollection<String> ac1,
	                                      ac2; 
	     
	     @Before
	     public void setUp() throws Exception
	     {
	    	 ac1 = new ArrayCollection<String>();
	    	 ac2 = new ArrayCollection<String>();
	     }
	     
	     @After
	     public void tearDown() throws Exception
	     {
	    	 
	     }

	     public void testArrayCollection()
	     {
	    	 boolean result;
	    	        
	    	 
	    	 ac1.add("a");
	 		 ac1.add("b");
	 		 ac1.add("c");
	 		 result = ac1.remove("b");
	 		 assertEquals(result , true);
	 		 result = ac1.remove("d");
	 		 assertEquals(result , false);
	 		 
	 		 ac2.add("a");
	 		 ac2.add("c");
	 		 result = ac1.equals(ac2);
	 		 assertEquals(result , true);
	 		 ac2.add("b");
	 		 result = ac1.equals(ac2);
	 		 assertEquals(result , false);
	 		 
	 		 String result1 = ac1.toString();
	 		 String expected1 = "a" + "\n" + "c" +"\n";
	 		assertEquals(result1 , expected1);
	     } 

}
