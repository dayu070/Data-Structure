package lab3Lab6;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;

public class ArrayCollectionUserTest extends TestCase {
           private ArrayCollectionUser user;
           
           @Before
           public void setUp() throws Exception
           {
        	   user = new ArrayCollectionUser();
           }
           
           @After
           public  void tearDown() throws Exception
           {}
           
           public void test()
           {
        	   user.processMethodCall ("a1 ArrayCollection");
        	   user.processMethodCall ("a1 add yes");
        	   user.processMethodCall ("a1 add no");
        	   user.processMethodCall ("a1 add maybe");
        	   user.processMethodCall ("a1 remove no");
        	   String result = user.a1.toString();
        	   String expected = new StringBuffer("yes").append("\n").append("maybe").append("\n").toString();
        	   String expected1 = "yes" + "\n" + "maybe" + "\n";
        	   assertEquals(result, expected);
           }
           
           
}
