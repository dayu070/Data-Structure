package lab5Part3;



import java.util.*;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class CS401LinkedListImplTest extends TestCase {
	         private  CS401LinkedListImpl<Integer> linkedList;
	         
	         @Before
	         public void setUp() throws Exception
	         {
	        	 linkedList = new CS401LinkedListImpl<Integer>();
	         }
	         
	         @After
	         public void tearDown() throws Exception
	         {}
	         
	         public void test()
	         {
	        	 linkedList.add(10);
	        	 linkedList.add(5);
	        	 linkedList.add(7);
	        	 linkedList.add(10);
	        	 linkedList.add(5);
	        	 linkedList.add(7);
	        	 linkedList.add(8);
	        	 linkedList.add(6);
	        	 Integer result;
	        	 Integer expected [] = {10, 5, 7, 10, 5, 7, 8, 6};
	        	 int i=0;
	        	 
	        	 Iterator<Integer> itr = linkedList.iterator();
	        	 while(itr.hasNext())
	        	 {
	        		 result = itr.next();
	        		 System.out.print(result + " ");
	        		 assertEquals(result, expected[i++]);
	        	 }
	         }
	         

}
