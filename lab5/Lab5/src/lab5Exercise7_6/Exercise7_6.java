package lab5Exercise7_6;

import java.util.*;

public class Exercise7_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                LinkedList<Double> weights = new LinkedList<Double>();
                
                ListIterator<Double> itr;
                                     
                
                weights.add(5.3);
                weights.add(2.8);
                weights.add(5.3);
                weights.add(2.8);
                weights.add(5.3);
                weights.add(2.8);
                itr = weights.listIterator();
              
                
                int i=0;
                
                while(i<7)
                {
                	
                    i++;
                    try
                    {
                       switch(i)
                       {
                       case 1: itr.add(8.8); itr.next(); itr.remove(); System.out.println("a"); break;
                       case 2: itr.add(8.8); itr.remove(); itr.next(); System.out.println("b"); break;
                       case 3: itr.next(); itr.add(8.8); itr.remove(); System.out.println("c"); break;
                       case 4: itr.next(); itr.remove(); itr.add(8.8); System.out.println("d"); break;
                       case 5: itr.remove(); itr.add(8.8); itr.next(); System.out.println("e"); break;
                       case 6: itr.remove(); itr.next(); itr.add(8.8); System.out.println("f"); break;
                       default: break;
                       }
	                }catch(Exception e)
	                {System.out.println(e + "\n");}

                 }
   }
}
