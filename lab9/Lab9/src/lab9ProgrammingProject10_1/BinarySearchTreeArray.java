package lab9ProgrammingProject10_1;

import java.io.Serializable;
import java.util.*;

public class BinarySearchTreeArray<E> extends AbstractSet<E> implements Serializable 
{
	protected Entry<E> [] tree;
	
	int root,
	    size;
	
	public BinarySearchTreeArray() 
    {
        root = 0;
        size = 0;  
        tree = new Entry [100];
    }
	
	public void arrayRepresentation(int index)
	{
		System.out.println(index + " " + tree[index].element + " " + tree[index].parent + " " + tree[index].left + " " + tree[index].right);
	}
	
	public int size( )
    {
        return size;
    }
	
	public Iterator<E> iterator()
	{
	    return new TreeIterator();
	}
	
	public boolean contains (Object obj) 
	{
	    return (getEntry (obj) != null);
	}
	
	protected Entry<E> getEntry (Object obj)
	{
	    int temp = root,
	    	comp;
	    
	    while (temp != -1)
	    {
	    	comp = ((Comparable)obj).compareTo(tree[temp].element);
	    	if ( comp == 0 )
	    		return tree [temp];
	    	else if (comp < 0)
	    		temp = tree[temp].left;
	    	else
	    		temp = tree [temp].right;
	    }
	    return null;
	}
	
	public boolean add (E element)  
    {
        if (size == 0) 
        {
        	tree[root] = new Entry<E> (element, -1);
        	tree[root].index = 0;
            size++;   
            return true;
        } // empty tree
        else 
        {
            Entry<E> temp = tree[root];

            int comp;
            
            int index = 0;

            while (true) 
            {
                comp =  ((Comparable)element).compareTo (temp.element);
                if (comp == 0)
                    return false;
                if (comp < 0)
                {
                    if (temp.left != -1)
                    {
                    	index = temp.left;
                        temp = tree[temp.left];
                    }
                    else 
                    {
                    	tree[size] = new Entry<E> (element, index);
                    	temp.left = size;
                    	tree[size].index = size;
                        size++;      
                        return true;
                    } // temp.left == null
                 }
                 else if (temp.right != -1)
                 {
                	 index = temp.right;
                	 temp = tree[temp.right];
                 }
                 else 
                 {
                     tree[size] = new Entry<E> (element, index);
                     temp.right = size;
                     tree[size].index = size;
                     size++;     
                     return true;
                 } // temp.right == null
            } // while
        } // root not null
    } // method add
	
    public boolean remove (Object obj)
    {
        Entry<E> e = getEntry (obj);
        if (e == null)
            return false;
        deleteEntry (e);
        return true;
    } // method remove	
	
	protected Entry<E> deleteEntry (Entry<E> p) 
    {
        

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != -1 && p.right != -1) 
        {
            Entry<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children


        // At this point, p has either no children or one child.

        Entry<E> replacement;
         
        if (p.left != -1)
            replacement = tree[p.left];
        else
            replacement = tree[p.right];

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) 
        {
            replacement.parent = p.parent;
            if (p.parent == -1)
                tree[root] = replacement;
            else if (p == tree[tree[p.parent].left])
                tree[p.parent].left = replacement.index;
            else
                tree[p.parent].right = replacement.index;
        } // p has at least one child  
        else if (p.parent == -1)
            tree[root] = null;
        else 
        {
            if (p == tree[tree[p.parent].left])
            	tree[p.parent].left = -1;
            else
            	tree[p.parent].right = -1;        
        } // p has a parent but no children
        p.left = p.right = p.parent = -1;
        if (p.index < size-1)
        {
        	System.arraycopy(tree, p.index+1, tree, p.index, size-p.index-1);
            size--;
            for (int i=0; i<size; i++)
            {
        	    if(tree[i].parent>p.index)
        	    	tree[i].parent--;
        	    if(tree[i].left>p.index)
        	    	tree[i].left--;
        	    if(tree[i].right>p.index)
        	    	tree[i].right--;
            }	
        }
        else
        size--;
        return p;
    } // method deleteEntry
	
	protected Entry<E> successor (Entry<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != -1) 
        {
            // successor is leftmost Entry in right subtree of e
            Entry<E> p = tree[e.right];
            while (p.left != -1)
                p = tree[p.left];
            return p;

        } // e has a right child
        else 
        {

            // go up the tree to the left as far as possible, then go up
            // to the right.
            Entry<E> p = tree[e.parent];
            Entry<E> ch = e;
            while (p != null && ch == tree[p.right]) 
            {
                ch = p;
                p = tree[p.parent];
            } // while
            return p;
        } // e has no right child
    } // method successor
	
    protected class TreeIterator implements Iterator<E>
    {

        protected Entry<E> lastReturned = null,
                           next;
       
        protected TreeIterator() 
        {  
            next = tree[root];
            if (next != null)
                while (next.left != -1)
                    next = tree[next.left];
        } // default constructor


        /**
         *  Determines if there are still some elements, in the BinarySearchTree object this
         *  TreeIterator object is iterating over, that have not been accessed by this
         *  TreeIterator object.
         *
         *  @return true - if there are still some elements that have not been accessed by
         *                this TreeIterator object; otherwise, return false.
         *
         */ 
        public boolean hasNext() 
        {
            return next != null;
        } // method hasNext


        /**
         *  Returns the element in the Entry this TreeIterator object was positioned at 
         *  before this call, and advances this TreeIterator object.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @return the element this TreeIterator object was positioned at before this call.
         *
         *  @throws NoSuchElementException - if this TreeIterator object was not 
         *                 positioned at an Entry before this call.
         *
         */
        public E next() 
        {
            if (next == null)
                throw new NoSuchElementException();
            lastReturned = next;
            next = successor (next); 
            return lastReturned.element;
        } // method next

        /**
         *  Removes the element returned by the most recent call to this TreeIterator
         *  object�s next() method.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @throws IllegalStateException - if this TreeIterator�s next() method was not
         *                called before this call, or if this TreeIterator�s remove() method was
         *                called between the call to the next() method and this call.
         *
         */ 
        public void remove() 
        {
            if (lastReturned == null)
                throw new IllegalStateException();
 
            if (lastReturned.left != -1 && lastReturned.right != -1)
                next = lastReturned;
            deleteEntry(lastReturned);
            lastReturned = null; 
        } // method remove     

    } 	
	
	protected static class Entry<E> implements java.io.Serializable
    {
        protected E element;

        protected int left = -1,
                      right = -1,
                      parent,
                      index;
 
        public Entry() { }

         public Entry (E element, int parent) 
         {
             this.element = element;
             this.parent = parent;
         } // constructor

    } // class Entry
}
