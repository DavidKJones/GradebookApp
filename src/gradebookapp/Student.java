package gradebookapp;
import java.io.Serializable;
import java.util.ArrayList;

public class Student
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
	/**Student constructor with only two arguments
	 * 
	 * @return nothing
	 * @param id the Student ID
	 * @param name the Student Name
	 */
	public Student(String id, String first, String last) {
		this.idNumber = id;
		this.firstName = first;
		this.lastName = last;
		this.studentAssignments = new ArrayList<Assignment>();
	}
	/**Student constructor with four arguments
	 * 
	 * @return nothing
	 * @param id the Student ID
	 * @param name the Student's name
	 * @param grade
	 * @param percentage grade percentage
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
	 * @param idNumber student ID number
	 * @return nothing
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
	 * @param name the student's name
	 * @return nothing
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
	
	/**Manually set the Student's first Name
	 * 
	 * @param name the student's name
	 * @return nothing
	 */
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Assignment getAssignment(int index)
	{
		Assignment assignment = null;
		try
		{
			studentAssignments.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			System.out.println(ex);
		}
		
		return assignment;
	}
	
	/**
	 * Get the assignments for the student.
	 * @return
	 */
	public ArrayList<Assignment> getAssignments()
	{
		return studentAssignments;
	}

	/**
	/*
	 * Adds an assignment to the specific student
	 * 
	 * @param Assignment
	 * @return nothing
	 */
	public void addAssignment(Assignment assignment) 
	{
		studentAssignments.add(assignment);
	}
	/**
	/*
	 * removes an undesired assignment to the specific student
	 * 
	 * @param Assignment
	 * @return nothing
	 */
	public void removeAssignment(Assignment assignment)
	{
		studentAssignments.remove(assignment);
	}
}
