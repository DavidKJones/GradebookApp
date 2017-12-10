package gradebookapp;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * <h1>Student</h1>
 * Student object class that contains id number, 
 * first name, last name, and list of assignments.
 * @author david
 *
 */
@SuppressWarnings("serial")
public class Student implements Serializable
{
	private String idNumber;
	private String firstName;
	private String lastName;
	private ArrayList<Assignment> studentAssignments;
	
	//default constructor
	/**
	 * Student default constructor
	 */
	public Student() {
		this.idNumber = "";
		this.firstName = "";
		this.lastName = "";
		this.studentAssignments = new ArrayList<Assignment>();
	}
	//parameterized constructors
	/**Student constructor with three arguments
	 * 
	 * @param id String of the Student ID
	 * @param first String of the student's first Name
	 * @param last String of the student's last name
	 */
	public Student(String id, String first, String last) {
		this.idNumber = id;
		this.firstName = first;
		this.lastName = last;
		this.studentAssignments = new ArrayList<Assignment>();
	}
	/**Student constructor with five arguments
	 * 
	 * @param id String of the Student ID
	 * @param firstName String of the Student's first name
	 * @param lastName String of the Student's last name
	 * @param grade String of the Student's grade
	 * @param percentage double of the grade percentage
	 */
	public Student (String id, String firstName, String lastName, String grade, double percentage)
	{
		this.idNumber = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentAssignments = new ArrayList<Assignment>();
	}
	//methods

	/**Gets the Student's ID number
	 * 
	 * @return String of the Student's ID number
	 */
	
	public String getIdNumber() {
		return idNumber;
	}
	
	/**Manually set the Student's ID number
	 * 
	 * @param idNumber String of the student ID number
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	
	/**Gets the Student's first name
	 * 
	 * @return String of the Student's name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**Manually set the Student's first Name
	 * 
	 * @param first String of the student's first name
	 */
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	/**Gets the Student's first name
	 * 
	 * @return String of the Student's name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**Manually set the Student's Last Name
	 * 
	 * @param last String of the student's last name
	 */
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	/**
	 * Get a student assignment at an index.
	 * @param index index of desired assignment
	 * @return assignment at specified index
	 */
	public Assignment getAssignment(int index)
	{
		Assignment assignment = null;
		try
		{
			assignment = studentAssignments.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
		
		return assignment;
	}
	
	/**
	 * Get the assignments for the student.
	 * @return ArrayList of all of the student's assignment
	 */
	public ArrayList<Assignment> getAssignments()
	{
		return studentAssignments;
	}

	/** 
	 * Adds an assignment to the specific student
	 * @param assignment Assignment to be added
	 */
	public void addAssignment(Assignment assignment) 
	{
		studentAssignments.add(assignment);
	}
	/**
	 * removes an undesired assignment to the specific student
	 * @param assignment Assignment to be removed
	 */
	public void removeAssignment(Assignment assignment)
	{
		studentAssignments.remove(assignment);
	}
}
