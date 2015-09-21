package lab6Part3;

import java.util.Iterator;

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public CS401StackLinkedListImpl()
   {
      head = null;
      num_elements = 0;
   }

   public void push(E e)
   {
	   LinkEntry<E> le = new LinkEntry<E> ();
	   le.element = e;
	   le.next = head;
	   head = le;
	   num_elements++;
       
   }

   public E pop()
   {  
	  LinkEntry<E> le = new LinkEntry<E> ();
      if (num_elements == 1)
      {   
    	  le = head;
    	  head = null;
      }
      else
      {
    	  le = head;
    	  head = head.next;
      }
      num_elements--;
      return le.element;
   }

   public int size()
   {
      return num_elements;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
} /* CS401StackLinkedListImpl<E> */
