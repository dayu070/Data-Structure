package lab7Part1;
/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl (int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {
	      if (back == capacity)
	      {
	    	  E[] temp = (E[]) new Object[2*capacity];
	    	  System.arraycopy(data, 0, temp, 0, capacity);
	    	  data = temp;
	      }
          data[back] = element;
          back++;
   }

   public E remove()  {
          E temp = data[front];
          try
          {   
        	  if (is_empty())
        		  throw new Exception();
              System.arraycopy(data, 1, data, 0, back-1);
              data[back-1] = null;
              back--;
              
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

          return (back == 0);

   }

   public boolean is_full()  {

          return (back == capacity);

   }
}
