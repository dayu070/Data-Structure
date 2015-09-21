package lab13;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstTraversalOfGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String origin = "";
		String depthFirstTraversal = "";
		
		while (true)
		{
			System.out.print("Please enter an uppercase character from A to I: ");
			Scanner sc = new Scanner(System.in);
			origin = sc.next();
			if ("ABCDEFGHI".indexOf(origin)>=0)
				break;
		}
		
		int graph[][] = {
		        /* A   B   C   D   E   F   G   H   I        */
		         {-1,  8, -1, 10, -1, -1, 12, -1, -1}, /* A */
		         { 8, -1, -1, -1, 12, 18, -1, -1, -1}, /* B */
		         {-1, -1, -1, -1, -1,  2, -1, 10, -1}, /* C */
		         {10, -1, -1, -1, -1,  8, -1, -1, -1}, /* D */
		         {-1, 12, -1, -1, -1, -1, 24, -1, -1}, /* E */
		         {-1, 18,  2,  8, -1, -1, -1, -1, -1}, /* F */
		         {12, -1, -1, -1, 24, -1, -1, -1, -1}, /* G */
		         {-1, -1, 10, -1, -1, -1, -1, -1, -1}, /* H */
		         {-1, -1, -1, -1, -1, -1, -1,  3, -1}, /* i */
		      };
		
		Vertex v[] = new Vertex[9];
		
		v[0] = new Vertex("A");
	    add_neighbour(v[0], graph[0]);
	      
	    v[1] = new Vertex("B"); 
	    add_neighbour(v[1], graph[1]);

	    v[2] = new Vertex("C"); 
	    add_neighbour(v[2], graph[2]);

	    v[3] = new Vertex("D"); 
	    add_neighbour(v[3], graph[3]);

	    v[4] = new Vertex("E"); 
	    add_neighbour(v[4], graph[4]);
	    
	    v[5] = new Vertex("F"); 
	    add_neighbour(v[5], graph[5]);
	    
	    v[6] = new Vertex("G"); 
	    add_neighbour(v[6], graph[6]);
	    
	    v[7] = new Vertex("H"); 
	    add_neighbour(v[7], graph[7]);
	    
	    v[8] = new Vertex("I"); 
	    add_neighbour(v[8], graph[8]);
	    
	    Stack <Vertex> stack = new Stack<Vertex>();
		for (Vertex ver : v)
		{
			if(ver.get_label().equals(origin))
			{
				depthFirstTraversal = ver.get_label() + " ";
				ver.set_visited();
				stack.add(ver);
			}				
		}
		
		while (!stack.isEmpty())
		{
			if (stack.peek().hasNeighbour())
			{
				Neighbour n = stack.peek().remove_neighbour();
				if (!v[fromNeighbourGetVertex(n)].is_visited())
				{
					v[fromNeighbourGetVertex(n)].set_visited();
					depthFirstTraversal += v[fromNeighbourGetVertex(n)].get_label() + " ";
					stack.add(v[fromNeighbourGetVertex(n)]);
				}
			}
			else
				stack.pop();
		}
		
		System.out.println("The sequence of the depth first travel starting from " + origin + " is: " + depthFirstTraversal);
	}
	
	static void add_neighbour(Vertex v, int graph[])
	   {
	      for (int i = 0; i < graph.length; i++) {
	         String n = "";

	         switch(i)  {
	            case 0: n = "A"; break;
	            case 1: n = "B"; break;
	            case 2: n = "C"; break;
	            case 3: n = "D"; break;
	            case 4: n = "E"; break;
	            case 5: n = "F"; break;
	            case 6: n = "G"; break;
	            case 7: n = "H"; break;
	            case 8: n = "I"; break;
	         }

	         if (graph[i] != -1)  {
	             v.add_neighbour(new Neighbour(v.get_label(), n, graph[i]));
	         }
	      }
	      return;
	   }
	
	static int fromNeighbourGetVertex(Neighbour n)
	{
		return "ABCDEFGHI".indexOf(n.getDestination());
	}

}


