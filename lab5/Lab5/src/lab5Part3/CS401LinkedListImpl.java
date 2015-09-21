package lab5Part3;

import java.util.Iterator;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>,
                                               Iterable<E>
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int s = 1;

   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size()
   {
      return size_r(head) - 1;
      /*
       * Note that an iterative solution would be as follows:
       * 
       * LinkEntry<E> temp;
       * int i = 0;
       *
       * for (temp = head; temp != null; temp = temp.next)
       *      i++;
       * return i;
       */
   }

   public boolean add(int index, E e)
   {
      throw new UnsupportedOperationException();
   }

   public boolean add(E e)
   {
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          ne.next = ne;
      }
      else
      {  
    	 
         tail.next = ne;
         ne.next = head;
         tail = ne;
      }
      
      return true;
   }

   public boolean add_sorted(E e)
   {
      LinkEntry<E> ne = new LinkEntry<E>();
      ne.element = e;

      if (head == null && tail == null)
      {
          head = tail = ne;
          ne.next = ne;
      }
      else
      {
         LinkEntry<E> prev = null; 
         LinkEntry<E> temp;

         for (temp = head; temp != null; temp = temp.next)
         {
            int comp = ((Comparable)e).compareTo(temp.element);
            if (comp < 0) /* Element added is less than one on list. */
            {
                break;
            }
            prev = temp;
         }

         if (prev == null)  /* Adding as new head */
         {
             ne.next = head;
             head = ne;
             tail.next = head;
         }
         else if (temp == null)  /* Adding as new tail */
         {
             tail.next = ne;
             ne.next = head;
             tail = ne;
         }
         else  /* Adding in the middle */
         {
             ne.next = prev.next;   /* HAS TO BE IN THIS ORDER */
             prev.next = ne;        /* HAS TO BE IN THIS ORDER */
         }
      }

      return true;
   }

   public E remove(int index)
   {
       throw new IndexOutOfBoundsException();
   }

   public E remove()
   {
      throw new UnsupportedOperationException();
   }

   public E get(int index)
   {
      throw new UnsupportedOperationException();
   }

   public boolean contains(E e)
   {
      throw new UnsupportedOperationException();
   }

   public Iterator<E> iterator()  /* From Interface Iterable */
   {
      return new CS401LinkedListIterator(); 
   }

   private int size_r(LinkEntry<E> head)  /* Think about this recursive call! */
   {
      if (head != null)
         s = s + size_r(head.next);
      return s;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */
   protected class CS401LinkedListIterator implements Iterator<E>
   {
      protected LinkEntry<E> next;

      protected CS401LinkedListIterator() { next = head; }
      
      protected boolean flag = true;

      public E next()
      {
    	 if(next == head)
    		 flag = false;
         E e = next.element;
         next = next.next;
         return e;
      }

      public boolean hasNext() { return ((next!=head)||flag); }

      public void remove()  /* Remove the element under the iterator. */
      { 
         /*
          * To be filled in by students ... */
         return;
      }
   }

} /* CS401LinkedListImpl<E> */

