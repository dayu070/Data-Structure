package lab13;

public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;
   
   public CS401QueueLinkedListImpl()
   {
	   head = tail =null;
	   num_elements = 0;
   }
   

   public void add(E element) {
	       LinkEntry<E> le = new LinkEntry();
	       le.element = element;
           if((head == null)&&(tail == null))
               head = tail = le;
           tail.next = le;
           tail = le;
   }

   public E remove()  {
           E temp;
           try
           {
        	   if (is_empty())
        		   throw new Exception();
        	   else
               {
        		   temp = head.element;
        		   if (head == tail)
        	          head = tail = null;
                   else
                      head = head.next;
               }
           }catch(Exception e)
           {
        	   System.out.println("The queue is empty");
        	   return (E)new Integer(0);
           }
		return (E)temp;
           
   }
   public E peek()  {
           return head.element;
          

   }

   public boolean is_empty()  {

         return (head == null);

   }

   public boolean is_full()  {

        throw new UnsupportedOperationException();

   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
}
