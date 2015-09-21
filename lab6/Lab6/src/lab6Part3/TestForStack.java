package lab6Part3;

import java.util.*;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

public class TestForStack extends TestCase {
    private CS401StackLinkedListImpl <String> slli;
    
    @Before
    public void setUp() throws Exception
    {
   	 slli = new CS401StackLinkedListImpl <String> ();
    }
    
    @After
    public void tearDown() throws Exception
    {}
    
    public void test()
    {
    	slli.push("hello");
    	slli.push("hi");
    	slli.push("good");
    	slli.push("great");
    	slli.push("fine");
    	
    	String [] expected = {"fine", "great", "good", "hi", "hello"};
    	for (String e : expected)
    		assertEquals(e, slli.pop());
    }

}
