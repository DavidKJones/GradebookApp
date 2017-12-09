
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>Gradebook</h1>
 * Grade book abstract class.
 * @author david
 */
@SuppressWarnings("serial")
public abstract class GradeBook implements Serializable
{
	private ArrayList<Student> students;
	private ArrayList<Assignment> assignments;
	private String name;
	
	/**
	 * 
	 */
	public GradeBook()
	{
		students = new ArrayList<Student>();
		assignments = new ArrayList<Assignment>();
	}
	
	/**
	 * Add student to the grade book.
	 * @param student
	 */
	public void addStudent( Student student )
	{
		students.add(student);
	}
	
	/**
	 * 
	 * @param student
	 */
	public void removeStudent( Student student )
	{
		students.remove(student);
	}
	
	/**
	 * 
	 * @param student
	 */
	public void removeStudentAt( int index )
	{
		try
		{
			students.remove(index);
		}
		catch( IndexOutOfBoundsException ex )
		{
			System.out.println(ex);
		}
	}
	
	/**
	 * 
	 */
	public Student getStudent ( int index )
	{
		Student student = null;
		try
		{
			student = students.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.print(ex);
		}
		
		return student;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Student> getStudents()
	{
		return students;
	}
	
	/**
	 * 
	 */
	public abstract void addAssignment ( Assignment assignment );
	
	/**
	 * 
	 */
	public void removeAssignment ( Assignment assignment )
	{
		assignments.remove(assignment);
	}
	
	/**
	 * 
	 * @param assignment
	 */
	public void removeAssignmentAt (int index)
	{
		try
		{
			assignments.remove(index);
		}
		catch( IndexOutOfBoundsException ex )
		{
			System.out.println(ex);
		}
	}
	
	/**
	 * 
	 */
	public Assignment getAssignmentAt( int index )
	{
		Assignment assignment = null;
		try
		{
			assignment = assignments.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.print(ex);
		}
		
		return assignment;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Assignment> getAssignments()
	{
		return assignments;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName( String name )
	{
		this.name = name;
	}
	
	/**
	 * 
	 * Calculates the student percentage.
	 * @return percentage value 0-100
	 */
	public abstract double calculateStudentPercentage( Student student );
	
	/**
	/*Grabs percentage and sets letter grade depending on percentage
	 *
	 * @param none
	 * @returns String letter grade
	 */
	public abstract String getGrade( Student student );
	
}
