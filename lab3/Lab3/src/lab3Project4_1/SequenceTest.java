package lab3Project4_1;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class SequenceTest extends TestCase {
             private Sequence<Integer> seq;
             
             @Before
             public void setUp() throws Exception
             {
            	 seq = new Sequence<Integer>(2); 
             }
	
	         @After
	         public void tearDown() throws Exception
	         {
	        	 
	         }
	         
	         public void test()
	         {
	        	 seq.append(new Integer(1));
	        	 seq.append(new Integer(2));
	        	 seq.append(new Integer(3));
	        	 int result1 = seq.size;
	        	 int expected1 = 3;
	        	 assertEquals(result1,expected1);
	        	 
	        	 Integer result2 = seq.get(0);
	        	 Integer expected2 = 1;
	        	 assertEquals(result2,expected2);
	        	 
	        	 seq.set(0, 2);
	        	 result2 = seq.get(0);
	        	 expected2 = 2;
	        	 assertEquals(result2,expected2);
	         }
	
}
