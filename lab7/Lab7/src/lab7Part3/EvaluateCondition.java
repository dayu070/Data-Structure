package lab7Part3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;



public class EvaluateCondition {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    /*new EvaluateCondition().run();*/
		   new EvaluateCondition().run();
		
	}
	
	public void run()
	{
		String s,
		       s1;
		String result = "";
		ArrayList<String> al1 = new ArrayList<String>(),
		                  al2 = new ArrayList<String>();
		Scanner sc1 = new Scanner(System.in);
		int count = 0;
		
		System.out.println("Please enter a condition, or $ to quit: ");
		s = sc1.nextLine();
		
		
		if (s!="$")
		{
		   Scanner sc2 = new Scanner(s);
		   while(sc2.hasNext())
		   {
			   s1 = sc2.next();
			   al2.add(s1);
			   if("+-*/%><>=<===!=&&||()".indexOf(s1)<0 && !(al1.contains(s1)))
			      al1.add(s1);				   			   				   
		   }
		}
		
		for(int i=0; i<al1.size();i++)
		{
			
			System.out.println("Please enter a value: ");
			s1 = sc1.next();
			while (al2.contains(al1.get(i)))
				al2.set(al2.indexOf(al1.get(i)), s1);
		}
		
		for (String str: al2)
		    result = result + str + " ";
		
		System.out.println(result);
		
		Scanner sc3 = new Scanner (result);
		
		result = infixToPostfix1(sc3, "");
		System.out.println(result);
		
		System.out.println(getResult(result));
	}
	
	public static String infixToPostfix1(Scanner sc, String str)
	{
		String temp = "";
		String operator = "";
		Stack<String> stack = new Stack<String>();
		stack.push(str);
		while (sc.hasNext())
		{
			if (sc.hasNextInt())
				temp = temp + sc.nextInt() + " ";
			else
			{
				operator = sc.next();
				if ("+-*/%><>=<===!=&&||".indexOf(operator)>=0)
				{
					if (stack.isEmpty()||stack.peek().equals("("))
						stack.push(operator);
					else if (priority(operator)<=priority(stack.peek()))
					{
						while(!stack.isEmpty()&&priority(operator)<=priority(stack.peek()))
						{
						    temp = temp + stack.pop() + " ";
						}
						stack.push(operator);
					}
					else
						stack.push(operator);
				}
				else
				{
					if (operator.equals("("))
					{
						
						temp = temp + infixToPostfix1(sc, "(") + " ";
					}
					else
					{
						while(!stack.peek().equals("("))
						{
							temp = temp + stack.pop() + " ";
						}
						return temp;
					}
				}
			}
		}
		
		while (!stack.isEmpty())
			temp = temp + " " + stack.pop();
		
		return temp;
	}
	
	public static int priority (String str)
	{
		if (str.equals("*")||str.equals("/")||str.equals("%"))
			return 6;
		else if (str.equals("+")||str.equals("-"))
			return 5;
		else if (str.equals(">=")||str.equals("<=")||str.equals(">")||str.equals("<"))
			return 4;
		else if (str.equals("==")||str.equals("!="))
			return 3;
		else if (str.equals("&&"))
			return 2;
		else if (str.equals("||"))
			return 1;
		else
			return 0;
	}
	
	public static String infixToPostfix (String str)
	{
		String temp = "";
		Stack<String> stack = new Stack<String>();
		Scanner sc = new Scanner(str);
		while (sc.hasNext())
		{
			if (sc.hasNextInt())
				temp = temp + sc.nextInt() + " ";
			else
			{
				String str1 = sc.next();
				if ("+-*/%><".indexOf(str1)>=0)
				   stack.push(str1);
				else if(str1.equals("=="))
				   stack.push(str1);
				else if(str1.equals(">="))
				   stack.push(str1);
				else if(str1.equals("<="))
				   stack.push(str1);
				else if(str1.equals("!="))
				   stack.push(str1);
				else if(str1.equals("&&"))
		           stack.push(str1);
				else if(str1.equals("||"))
				   stack.push(str1);
				else if (str1.equals(")"))
				   temp = temp + stack.pop() + " ";
			}
		}
		
		while (!stack.isEmpty())
			temp = temp + " " + stack.pop();
		
		return temp;
	}
	
	public static boolean getResult(String str)
	{
		Stack <Integer> stack1 = new Stack <Integer> ();
		Stack <Boolean> stack2 = new Stack <Boolean> ();
		
	    
	    String s = "";
	    
	    Integer temp1,temp2;
	    Boolean temp3, temp4;
	    Scanner sc = new Scanner(str);
	    while(sc.hasNext())
	    {
	    	s = sc.next();
	    	
	    		if(s.equals(new String("+")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp1 = temp1 + temp2;
	    			stack1.push(temp1);
	    		}
	    		else if(s.equals(new String("-")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp1 = temp2 - temp1;
	    			stack1.push(temp1);
	    		}
	    		else if(s.equals(new String("*")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp1 = temp2 * temp1;
	    			stack1.push(temp1);
	    		}
	    		else if(s.equals(new String("/")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp1 = temp2 / temp1;
	    			stack1.push(temp1);
	    		}
	    		else if(s.equals(new String("%")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp1 = temp2 % temp1;
	    			stack1.push(temp1);
	    		}
	    		else if(s.equals(new String(">")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() > temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("<")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() < temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String(">=")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() >= temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("<=")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() <= temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("==")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() == temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("!=")))
	    		{
	    			temp1 = stack1.pop();
	    			temp2 = stack1.pop();
	    			temp3 = (temp2.intValue() != temp1.intValue());
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("&&")))
	    		{
	    			temp3 = stack2.pop();
	    			temp4 = stack2.pop();
	    			temp3 = (temp3 && temp4);
	    			stack2.push(temp3);
	    		}
	    		else if(s.equals(new String("||")))
	    		{
	    			temp3 = stack2.pop();
	    			temp4 = stack2.pop();
	    			temp3 = (temp3 || temp4);
	    			stack2.push(temp3);
	    		}
	    		else
	    		{
	    			stack1.push(Integer.parseInt(s));
	    		}
	    	}
	        
	        return stack2.pop();
	    }
	    
	
}
