package lab3Lab7;

public class Fibonacci {
	public static long f (int n, long previous, long current)
	{
	     if(n==1)
	     {
	         return 1;
	     }
	     if(n>2)
	     {
	          long temp = current;
	          current = current + previous;
	          previous = temp;
	          n--;
	          return f(n, previous, current);
	      }

	      return current;
	}
}
