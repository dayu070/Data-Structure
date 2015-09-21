package lab3Lab7;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;



public class FibonacciTest extends TestCase {
           private Fibonacci Fibo;
           
           @Before
           public void setUp() throws Exception
           {
        	   Fibo = new Fibonacci();
           }
           
           @After
           public void tearDown() throws Exception
           {}
           
           public void test()
           {
        	   long result = Fibo.f(7, 1, 1);
        	   long expected = 13;
        	   assertEquals(result, expected);
           }
}
