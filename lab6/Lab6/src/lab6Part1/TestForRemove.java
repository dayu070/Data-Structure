package lab6Part1;

import java.util.*;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

public class TestForRemove extends TestCase {
	         private CS401LinkedListImpl <String> lli;
	         
	         @Before
	         public void setUp() throws Exception
	         {
	        	 lli = new CS401LinkedListImpl <String> ();
	         }
             
	         @After
	         public void tearDown() throws Exception
	         {}
	        	
	         public void test()                            
	         {
	        	 lli.add("hello");                             // Test: 1st step
	        	 Iterator <String> itr = lli.iterator();
	        	 while (itr.hasNext())
	        	 {
	        		 itr.next();
	        		 itr.remove();
	        	 }	        		        	 
	        	 assertEquals(lli.is_empty(),true);
	        	 
	        	 lli.add("hello");                             // Test: 2nd step
	        	 lli.add("fine");
	        	 Iterator <String> itr1 = lli.iterator();
	        	 itr1.next();
	        	 itr1.remove();
	        	 String result = itr1.next();
	        	 String expected = "fine";
	        	 assertEquals(result,expected);
	        	 System.out.println(result);
	        	 itr1.remove();
	        	 System.out.println(lli.is_empty());
	        	 
	        	 lli.add("hello");                             //Test: 3rd step
	        	 lli.add("fine");
	        	 Iterator <String> itr2 = lli.iterator();
	        	 itr2.next();
	        	 itr2.next();
	        	 itr2.remove();
	        	 Iterator <String> itr3 = lli.iterator();
	        	 result = itr3.next();
	        	 expected = "hello";
	        	 assertEquals(result,expected);
	        	 System.out.println(result);
	        	 itr3.remove();
	        	 System.out.println(lli.is_empty());
	        	 
	        	 lli.add("hello");                               //Test: 4th step
	        	 lli.add("fine");
	        	 lli.add("good");
	        	 Iterator <String> itr4 = lli.iterator();
	        	 itr4.next();
	        	 itr4.next();
	        	 itr4.remove();
	        	 Iterator <String> itr5 = lli.iterator();
	        	 result = itr5.next();
	        	 expected = "hello";
	        	 assertEquals(result,expected);
	        	 System.out.println(result);
	        	 result = itr5.next();
	        	 expected = "good";
	        	 assertEquals(result,expected);
	        	 System.out.println(result);
	         }
	         
	         
}
