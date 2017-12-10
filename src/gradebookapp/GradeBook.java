package gradebookapp;

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
	 * default constructor
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
		System.out.println("Assignments: " + assignments.size()+ "\nStudents: " + students.size());
		
		for( Assignment a : assignments)
		{
			Assignment temp = new Assignment(a.getName(), a.getTotalScore());
			temp.setStudentScore(a.getTotalScore());
			student.addAssignment(temp);
		}
		
		students.add(student);
	}
	
	/**
	 * Removes a student from the grade book.
	 * @param student
	 */
	public void removeStudent( Student student )
	{
		students.remove(student);
	}
	
	/**
	 * Removes a student from the grade book at an index.
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
	 * Get a student from the grade book at an index.
	 * @return student object
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
	 * Get all the students in the grade book.
	 * @return array list of students
	 */
	public ArrayList<Student> getStudents()
	{
		return students;
	}
	
	/**
	 * Add assignment to the grade book.
	 */
	public void addAssignment ( Assignment assignment )
	{
		assignments.add(assignment);
		assignment.setStudentScore(assignment.getTotalScore());
		for( Student s : students )
		{
			s.addAssignment(assignment);
		}	
	}
	
	/**
	 * Remove an assignment from the gradebook.
	 */
	public void removeAssignment ( Assignment assignment )
	{
		assignments.remove(assignment);
	}
	
	/**
	 * Remove an assignment from the grade book at an index.
	 * @param index
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
	 * Get an assignment from the gradebook at an index.
	 * @return assignment object
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
	 * Get all assignments from the grade book.
	 * @return
	 */
	public ArrayList<Assignment> getAssignments()
	{
		return assignments;
	}
	
	/**
	 * Get the name of the grade book
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name of the grade book.
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
	
	@Override
	public String toString()
	{
		return getName();
	}
	
}
