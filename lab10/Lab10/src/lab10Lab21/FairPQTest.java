package lab10Lab21;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.Result;

import static org.junit.runner.JUnitCore.runClasses;

import java.util.*;
import java.io.*;

public class FairPQTest {
	public static void main(String[ ] args)
    {  
        Result result = runClasses(FairPQTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                "\nTests failed = " + result.getFailures());
    }
	
	protected FairPQ<Student> fpq1,
	                          fpq2;
	
	@Before
	public void RunBeforeEachTest()
    {
        fpq1 = new FairPQ<Student> ();  
        fpq2 = new FairPQ<Student> (11, new ByName());
    }
	
	@Test
	public void testAdd()
	{
		Student s1 = new Student("Soumaya 3.4");
		boolean expected = true;
		assertEquals(fpq1.add(s1), expected);
		assertEquals(fpq2.add(s1), expected);
	}
	
	@Test
	public void testElement()
	{
		Student s1 = new Student("Soumaya 3.4");
		Student s2 = new Student("Navdeep 3.5");
		Student s3 = new Student("Viet 3.3");
		fpq1.add(s1);
		fpq1.add(s2);
		fpq1.add(s3);
		fpq2.add(s1);
		fpq2.add(s2);
		fpq2.add(s3);
		assertEquals(fpq1.element(), s3);
		assertEquals(fpq2.element(), s2);
	}
	
	@Test
	public void testRemove()
	{
		Student s1 = new Student("Soumaya 3.4");
		Student s2 = new Student("Navdeep 3.5");
		Student s3 = new Student("Viet 3.3");
		fpq1.add(s1);
		fpq1.add(s2);
		fpq1.add(s3);
		fpq2.add(s1);
		fpq2.add(s2);
		fpq2.add(s3);
		assertEquals(fpq1.remove(), s3);
		assertEquals(fpq1.remove(), s1);
		assertEquals(fpq1.remove(), s2);
		assertEquals(fpq2.remove(), s2);
		assertEquals(fpq2.remove(), s1);
		assertEquals(fpq2.remove(), s3);
	}
}
