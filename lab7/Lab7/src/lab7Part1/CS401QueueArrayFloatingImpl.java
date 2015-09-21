package lab7Part1;
/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) 
   {
	    try
	    {
	      if (is_full())
	    	  throw new Exception();
          data[back] = element;
          back = (back + 1) % capacity;
	    }catch (Exception e)
	    {
	    	System.out.println("The queue is full!");
	    }
   }

   public E remove()  {
	      E temp = data[front];
	      try
	      {
	    	  if (is_empty())
	    		  throw new Exception();
              data[front] = null;
              front = (front + 1) % capacity;
              if (front == back)
        	  front = back = 0;
	      }catch (Exception e)
	      {
	    	  System.out.println("The queue is empty!");
	      }
          return temp;
   }
   public E peek()  {

      return data[front];

   }

   public boolean is_empty()  {

      return (front==0)&&(back==0)&&(data[0]==null);

   }

   public boolean is_full()  {

      return (front==back)&&(data[0]!=null);

   }

}
