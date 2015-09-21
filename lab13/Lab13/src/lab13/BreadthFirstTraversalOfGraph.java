package lab13;

import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Scanner;

public class BreadthFirstTraversalOfGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String origin = "";
		String breadthFirstTraversal = "";
		
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
	    
	    CS401QueueLinkedListImpl<Vertex> queue = new CS401QueueLinkedListImpl<Vertex>();
		for (Vertex ver : v)
		{
			if(ver.get_label().equals(origin))
			{
				ver.set_visited();
				ver.set_once_in_queue();
				breadthFirstTraversal = ver.get_label() + " ";
				while (ver.hasNeighbour())
				{
					Neighbour n = ver.remove_neighbour();
					queue.add(v[fromNeighbourGetVertex(n)]);
					v[fromNeighbourGetVertex(n)].set_once_in_queue();
				}
				break;
			}				
		}
		
		while (!queue.is_empty())
		{
			Vertex ver = queue.remove();
			ver.set_visited();
			breadthFirstTraversal += ver.get_label() + " ";
			while (ver.hasNeighbour())
			{
				Neighbour n =ver.remove_neighbour();
				if (!v[fromNeighbourGetVertex(n)].is_visited() && !v[fromNeighbourGetVertex(n)].has_been_in_queue())
				{
					queue.add(v[fromNeighbourGetVertex(n)]);
					v[fromNeighbourGetVertex(n)].set_once_in_queue();
				}
			}
		}
		
		System.out.println("The sequence of the breadth first travel starting from " + origin + " is: " + breadthFirstTraversal);
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

class Vertex  
{
   private String label;
   private PriorityQueue<Neighbour> neighbours;
   private boolean visited;
   private boolean once_in_queue;

   public Vertex(String l) 
   { 
      label = l;
      neighbours = null;
      visited = false;
      once_in_queue = false;
   }

   public void add_neighbour(Neighbour n) 
   {
      if (neighbours == null)
          neighbours = new PriorityQueue<Neighbour>();
      neighbours.add(n);
   }

   public Neighbour remove_neighbour() 
   {
      Neighbour n = null;

      if (neighbours.size() > 0)  {
          n = neighbours.peek();
          neighbours.remove(n);
      }
    
      return n;
   }
   
   public boolean hasNeighbour()
   {
	   return !neighbours.isEmpty();
   }
   
   public void set_once_in_queue()
   {
	   once_in_queue = true;
   }
   
   public boolean has_been_in_queue()
   {
	   return once_in_queue;
   }
   
   public void set_visited()
   {
	   visited = true;
   }
   
   public boolean is_visited()
   {
	   return visited;
   }

   public String get_label() { return label; }

   public String toString()
   {
      String s = "Vertex: " + label + "\n";
      
      s += " Neighbours: \n";

      Iterator<Neighbour> itr = neighbours.iterator();
      while (itr.hasNext())  {
         Neighbour n = itr.next();
         s += n;
      }

      return s;
   }
}

class Neighbour implements Comparable<Neighbour>
{
   private String source;
   private String destination;
   private Integer weight;

   public Neighbour(String s, String d, int w)
   {
      source = s; destination = d; weight = w;
   }

   public int compareTo(Neighbour o)
   {
      if (this.weight < o.weight) return -1;
      else if (this.weight > o.weight) return 1;
      else return 0;
   }

   public String toString()
   {
      return "  " + destination + ", weight: " + weight + "\n";
   }
   
   public String getDestination()
   {
	   return destination;
   }
}
