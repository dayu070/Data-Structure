package lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RunTimeTest {

	final static DecimalFormat threeDigits = new DecimalFormat ("0.000");
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
           new RunTimeTest().run();
	}
	
	public void run() throws FileNotFoundException
	{
		File file;
		Scanner scFile;
		final String MESSAGE_1 = "The elapsed time was ";

		final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

		final String MESSAGE_2 = " seconds.";

		long startTime,
		     finishTime,
		     elapsedTime;
		
		Student [] s1 = new Student[3380];
		Student [] s2 = new Student[3380];
		Student [] s3 = new Student[3380];
		
		int index=0;
		
		new ComparableSorts();
		
		file = new File("students.dat");
		scFile = new Scanner(file);
		while (scFile.hasNextLine())
		{
			String temp = scFile.nextLine();
			s1[index] = new Student(temp);
			s2[index] = new Student(temp);
			s3[index++] = new Student(temp);
		}
		scFile.close();

		startTime = System.nanoTime();
		ComparableSorts.insertionSort(s1);
        finishTime = System.nanoTime();
        elapsedTime = finishTime - startTime;
        System.out.println ("The insert sort: " + MESSAGE_1 + threeDigits.format((elapsedTime / NANO_FACTOR)) + MESSAGE_2);
        
        startTime = System.nanoTime();
        ComparableSorts.selectionSort(s2);
        finishTime = System.nanoTime();
        elapsedTime = finishTime - startTime;
        System.out.println ("The selection sort: " + MESSAGE_1 + threeDigits.format((elapsedTime / NANO_FACTOR)) + MESSAGE_2);
        
        startTime = System.nanoTime();
        ComparableSorts.bubbleSort(s3);
        finishTime = System.nanoTime();
        elapsedTime = finishTime - startTime;
        System.out.println ("The bubble sort: " + MESSAGE_1 + threeDigits.format((elapsedTime / NANO_FACTOR)) + MESSAGE_2);
	}

}
