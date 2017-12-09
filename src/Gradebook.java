
import java.util.ArrayList;

/**
 * <h1>Gradebook</h1>
 * Grade book abstract class.
 * @author david
 */
public abstract class Gradebook 
{
	private ArrayList<Student> students;
	private ArrayList<Assignment> assignments;
	private String name;
	
	/**
	 * 
	 */
	public Gradebook()
	{
		students = new ArrayList<Student>();
		assignments = new ArrayList<Assignment>();
	}
	
	/**
	 * 
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
	public abstract void addAssignment ();
	
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
	 */
	public abstract double calculateStudentGrade();
}
