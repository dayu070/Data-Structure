package lab3Project4_1;

public class Sequence<E> {
	
	protected E [] data;
	
    protected int size;
        
	public Sequence()
	{
		data = (E[]) new Object[10];
		size = 0;
	}
	
	public Sequence (int n)
	{
		data = (E[]) new Object[n];
		size = 0;
	}
	
    public int size()
    {
    	return size;
    }
    
    public void append (E element)
    {
    	if ( size == data.length )
    	{
    		E [] temp = (E[]) new Object[2*size];
    		System.arraycopy(data, 0, temp, 0, size);
    		data = temp;
    	}
    	
    	data [size] = element;
    	size++;
    }
    
    public E get (int k) throws IndexOutOfBoundsException
    {
    	return data [k];
    }
    
    public void set (int k, E newElement) throws IndexOutOfBoundsException
    {
    	data [k] = newElement;
    }
}
