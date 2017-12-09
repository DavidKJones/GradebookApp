import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private String idNumber;
	private String firstName;
	private String lastName;
	private String grade;
	private double percentage;
	private ArrayList<Assignment> studentAssignments;
	
	//default constructor
	/**
	 * Student default constructor
	 */
	public Student() {
		this.idNumber = "";
		this.firstName = "";
		this.lastName = "";
		this.grade = "";
		this.percentage = 0;
		this.studentAssignments = Assignments.getAssignments();
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
		this.grade = "A";
		this.percentage = 100;
		this.studentAssignments = Assignments.getAssignments();
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
		this.grade = grade;
		this.percentage = percentage;
		this.studentAssignments = Assignments.getAssignments();
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
	public String getFLastName() {
		return firstName;
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
	/*Grabs percentage and sets letter grade depending on percentage
	 *
	 * @param none
	 * @returns String letter grade
	 */
	public String getGrade() 
	{
		if(percentage <= 100 && percentage >= 97)
			grade = "A+";
		else if(percentage <= 96 && percentage >= 93)
			grade = "A";
		else if(percentage <= 93 && percentage >= 90)
			grade = "A-";
		else if(percentage <= 89 && percentage >= 87)
			grade = "B+";
		else if(percentage <= 86 && percentage >= 83)
			grade = "B";
		else if(percentage <= 82 && percentage >= 80)
			grade = "B-";
		else if(percentage <= 79 && percentage >= 77)
			grade = "C+";
		else if(percentage <= 76 && percentage >= 73)
			grade = "C";
		else if(percentage <= 72 && percentage >= 70)
			grade = "C-";
		else if(percentage <= 69 && percentage >= 67)
			grade = "D+";
		else if(percentage <= 66 && percentage >= 63)
			grade = "D";
		else if(percentage <= 62 && percentage >= 60)
			grade = "D-";
		else
			grade = "F";
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Calculates the total percentage grade of the student
	 * And turns it into a percentage from decimal
	 * 
	 * @param none
	 * @return The student's percentage grade
	 */
	public double getPercentage() {
		return percentage;
	}
	//Adding all the points from their assignments
	//and dividing it by their total points times 100 to get the percentage.
	//needs studentScore in Assignment class
	public void calculatePercentage() {
		double totalpoints = 0;
		double studentTotal = 0;
		for(int i = 0; i < studentAssignments.size(); i++)
		{
		totalpoints += studentAssignments.get(i).getTotalScore();
		studentTotal += studentAssignments.get(i).getStudentScore();
		}
		percentage = (studentTotal / totalpoints) * 100;
	}
	
	public Assignment getAssignment(int index) {
		return studentAssignments.get(index);
	}

	/**
	/*
	 * Adds an assignment to the specific student
	 * 
	 * @param Assignment
	 * @return nothing
	 */
	public void addAssignment(Assignment assignment) {
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
	
	@Override
    public String toString()
    {
    	return "Student ID: " + idNumber + ", First: " + firstName + ", Last: " + lastName + ", Grade: " + grade + ", percentage: " + percentage + "%";
    }
}
