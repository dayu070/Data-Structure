package lab12;

import java.util.PriorityQueue;

public class ComparableSorts {
	
	public static void heapSort(Student[] x)
	{
		int size = x.length,
			length = size;
		
		for (int i=(length>>1)-1; i>=0; i--)
			siftDown(i, x[i], size, x);
		
		Student a;
		for (int i=0; i<length; i++)
		{
			a = x[--size];
			x[size] = x[0];
			siftDown(0, a, size, x);
         }
		 
		 for (int i=0; i<length/2; i++)
		 {
			 a = x[i];
			 x[i] = x[length-i-1];
			 x[length-i-1] = a;
		 }
	}
	
	private static void siftDown(int k, Student student, int size, Student[] x)
	{
		int half = size>>1;
		while(k<half)
		{
			int child = (k<<1) + 1;
			Student c = x[child];
			int right = child + 1;
			if (right < size && c.compareTo(x[right])>0)
				c = x[child=right];
			if (student.compareTo(c)<=0)
				break;
			x[k] = c;
			k = child;
		}
		x[k] = student;
	}
	
	
	public static void mergeSort(Student[] x)
	{
		Student aux[] = x.clone();
		merge(aux, x, 0, x.length);
	}
	
	private static void merge(Student src[], Student dest[], int low, int high)
	{
		final int INSERTIONSORT_THRESHOLD = 7;
		int length = high - low;
		
		if (length < INSERTIONSORT_THRESHOLD)
		{
			for (int i=low; i<high; i++)
				for (int j=i; j>low && dest[j-1].compareTo(dest[j])>0; j--)
					swap (dest, j, j-1);
			return;
		}
		
		int mid = (low + high) >> 1;
		merge (dest, src, low, mid);
		merge (dest, src, mid, high);
		
		if (src[mid-1].compareTo(src[mid]) <=0)
		{
			System.arraycopy(src, low, dest, low, length);
			return;
		}
		
		for (int i=low, p=low, q=mid; i<high; i++)
		{	if (q>=high || (p<mid && src[p].compareTo(src[q])<=0))
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
	}
	
	public static void quickSort(Student[] x)
	{
		quick(x, 0, x.length);
	}
	
	private static void quick(Student[] x, int off, int len)
	{
		int m = off + (len >> 1),
			l = off,
			n = off + len - 1;
		
		m = med3 (x, l, m, n);
		Student v = x[m];
		
		int b = off,
			c = off + len - 1;
		while(true)
		{
			while (b<=c && x[b].compareTo(v)<0)
				b++;
			while (c>=b && x[c].compareTo(v)>0)
				c--;
			if (b>c)
				break;
			swap (x, b++, c--);
		}
		
		if (c+1-off>1)
			quick(x, off, c+1-off);
		if (off+len-b>1)
			quick(x, b, off+len-b);
	}
	
	private static int med3 (Student[] x, int a, int b, int c)
	{
		if (x[a].compareTo(x[b])<0)
		{
			if (x[b].compareTo(x[c])<0)
				return b;
			else if (x[a].compareTo(x[c])<0)
				return c;
			else
				return a;
		}
		else
		{
			if (x[b].compareTo(x[c])>0)
				return b;
			else if (x[a].compareTo(x[c])>0)
				return c;
			else
				return a;
		}
	}
	
	public static void swap(Student [] x, int a, int b) 
	   {
	      Student t = x[a];
	      x[a] = x[b];
	      x[b] = t;
	   }
}
