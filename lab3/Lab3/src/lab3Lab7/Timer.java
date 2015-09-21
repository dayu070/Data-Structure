package lab3Lab7;

public class Timer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                      new Timer().run();
	}
    
	public void run()
	{
		final String MESSAGE_1 = "The elapsed time was ";

		final double NANO_FACTOR = 1000000000.0;  // nanoseconds per second

		final String MESSAGE_2 = " seconds.";

		long startTime,
		     finishTime,
		     elapsedTime,
		     execute;

		

		// Perform the task:
        FibonacciUser fu = new FibonacciUser();
        
        startTime = System.nanoTime();
        
        execute = fu.fibOriginal(40);      // Test by changing the method's name and the number
        System.out.println(execute);

		// Calculate the elapsed time:
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		
        startTime = System.nanoTime();
        
        execute = fu.fibFormula(40);      // Test by changing the method's name and the number
        System.out.println(execute);

		// Calculate the elapsed time:
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		
        startTime = System.nanoTime();
        
        execute = fu.fib(40);      // Test by changing the method's name and the number
        System.out.println(execute);

		// Calculate the elapsed time:
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		
        startTime = System.nanoTime();
        
        execute = fu.f(40, 1, 1);      // Test by changing the method's name and the number
        System.out.println(execute);

		// Calculate the elapsed time:
		finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println (MESSAGE_1 + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
		
		
	}
}
