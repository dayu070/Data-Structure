package lab7Part2;

import java.util.*;

public class CarWashUser
{
    public static void main (String[] args)
    {
        new CarWashUser().run();
    } // method main
    
    
    /**
     *  Reads in all of the arrival times, runs the simulation, and calculates the average 
     *  waiting time.
     *
     */ 
    public void run()
    {        
        final int SENTINEL = 999;

        final String INPUT_PROMPT = "\nPlease enter the next arrival time (or " + 
                     SENTINEL + " to quit): ";           

        final String OUT_OF_RANGE = "The input must consist of a non-" +
                                    "negative integer less than the sentinel.";

        
     
        Scanner sc = new Scanner (System.in);
          
        int nextArrivalTime = 0;
        int meanArrivalTime,
            maxArrivalTime,
            meanServiceTime;
        
        Random r = new Random(100);
        
        System.out.println("Please enter the mean arrival time: ");
        meanArrivalTime = sc.nextInt();
        
        System.out.println("Please enter the max arrival time: ");
        maxArrivalTime = sc.nextInt();
        
        System.out.println("Please enter the mean service time: ");
        meanServiceTime = sc.nextInt();
        
        CarWash carWash = new CarWash(meanServiceTime);
        
        while(true)
        {
        	try
        	{
        		nextArrivalTime = nextArrivalTime + (int)Math.round ((-meanArrivalTime) * Math.log(1-(r.nextDouble())));
        		if (nextArrivalTime>maxArrivalTime)
        			break;
        		else
        		    carWash.process (nextArrivalTime,r);
        	}
        	catch (Exception e)
            {
                System.out.println(e);
                
            } // catch 
        	
        }
        
        carWash.finishUp(r);
        printResults (carWash);

 /*       while (true)
        {
            System.out.print (INPUT_PROMPT);
            try
            {                   
                nextArrivalTime = sc.nextInt();
                if (nextArrivalTime == SENTINEL)
                    break;
                if (nextArrivalTime < 0 || nextArrivalTime > SENTINEL)
                    throw new NumberFormatException (OUT_OF_RANGE);
                carWash.process (nextArrivalTime);
            } // try
            catch (Exception e)
            {
                System.out.println(e);
                sc.nextLine();
            } // catch                               
        } // while
        carWash.finishUp();
        printResults (carWash);      */
        
        
        
    } // method run                        


    /**
     *  Prints the results of the simulation.
     *
     */
    public void printResults (CarWash carWash)
    {
        final String RESULTS_HEADING =
            "\nHere are the results of the simulation:\n";

        LinkedList<String> results = carWash.getResults();
        System.out.println (RESULTS_HEADING);
        for (String s : results)
            System.out.print (s);
    } // method printResults

} // class CarWashUser
