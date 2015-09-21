package lab11;
import java.util.*;

public class Student implements Comparable<Student> 
{
    protected String lastName,
                     middleName,
                     firstName;

    protected long id;


    /**
     *  Initializes this Student object from a specified String object.
     *
     *  @param s - the String object used to initialize this Student object.
     *
     */     
    public Student (String s) 
    {
    	String temp = "";
        Scanner sc = new Scanner (s);
        lastName = "";
        
        temp = sc.next();
        for (int i=0; i<temp.length(); i++)
        	if (Character.isLetter(temp.charAt(i)))
        		lastName += temp.charAt(i);
        firstName = sc.next();
        middleName = sc.next();
        id = sc.nextLong();
    } // constructor
    
    public String getLastName()
    {
    	return lastName;
    }
    
    public String getMiddleName()
    {
    	return middleName;
    }
    
    public String getFirstName()
    {
    	return firstName;
    }
    
    public long getID()
    {
    	return id;
    }
    
    /**
     *  Compares this Student object to a specified object by grade point 
     *  average.
     *
     *  @param obj - the specified object.
     *
     *  @return a negative integer, 0, or a positive integer, depending
     *  on whether this Student object�s grade point average is less than,
     *  equal to, or greater than obj�s grade point average.
     * 
     *  @throws ClassCastException - if the run-time type of obj is not Student.
     *
      */                         
    public int compareTo (Student otherStudent) 
    {
    	
        if (lastName.compareTo(otherStudent.lastName) != 0)        
        	return lastName.compareTo(otherStudent.lastName);        
        else if (firstName.compareTo(otherStudent.firstName) != 0)
        	return firstName.compareTo(otherStudent.firstName);
        else if (middleName.compareTo(otherStudent.middleName) != 0)
        	return middleName.compareTo(otherStudent.middleName);
        else
        {
        	return (int) (this.id-otherStudent.getID());
        }
    } // method compareTo

    
    /**
     *  Returns a String representation of this Student object.
     *
     *  @return  a String representation of this Student object: name � � gpa
     *
     */
    public String toString() 
    {
        return lastName + "  " + middleName + " " + firstName + " " + id;
    } // method toString

} // class Student
