package lab6Part4;

import java.util.*;

import lab6Part3.CS401StackLinkedListImpl;

public class InfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		              System.out.println("1 3 8 * + =" + getResult("1 3 8 * +"));
		              System.out.println("8 2 - 8 4 / + 6 + 1 - 6 2 / - =" + getResult("8 2 - 8 4 / + 6 + 1 - 6 2 / -"));
		              System.out.println("8 3 - 4 6 * - 3 + =" + getResult("8 3 - 4 6 * - 3 +"));
		              System.out.println("1 9 2 * + 2 - 3 4 / + 3 + 4 3 * - 4 + =" + getResult("1 9 2 * + 2 - 3 4 / + 3 + 4 3 * - 4 +"));
	}
	
	public static Double getResult(String str)
	{
		CS401StackLinkedListImpl <Double> slli = new CS401StackLinkedListImpl <Double> ();
	    
	    String s = "";
	    Double num = new Double(0);
	    Double temp1,temp2;
	    Scanner sc = new Scanner(str);
	    while(sc.hasNext())
	    {
	    	s = sc.next();
	    	try
	    	{
	    		num = Double.parseDouble(s);
	    		slli.push(num);
	    	}catch (NumberFormatException e)
	    	{
	    		if(s.equals(new String("+")))
	    		{
	    			temp1 = slli.pop();
	    			temp2 = slli.pop();
	    			temp1 = temp1 + temp2;
	    			slli.push(temp1);
	    		}
	    		if(s.equals(new String("-")))
	    		{
	    			temp1 = slli.pop();
	    			temp2 = slli.pop();
	    			temp1 = temp2 - temp1;
	    			slli.push(temp1);
	    		}
	    		if(s.equals(new String("*")))
	    		{
	    			temp1 = slli.pop();
	    			temp2 = slli.pop();
	    			temp1 = temp2 * temp1;
	    			slli.push(temp1);
	    		}
	    		if(s.equals(new String("/")))
	    		{
	    			temp1 = slli.pop();
	    			temp2 = slli.pop();
	    			temp1 = temp2 / temp1;
	    			slli.push(temp1);
	    		}
	    	}
	    }
	    return slli.pop();
	}
	
	

}
