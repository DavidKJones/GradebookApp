import java.io.Serializable;

public class Student implements Serializable{
	private String idNumber;
	private String name;
	private String grade;
	private double gpa;
	private Assignments assignments;
	
	public Student(String id, String name) {
		this.idNumber = id;
		this.name = name;		
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public Assignments getAssignments() {
		return assignments;
	}

	public void setAssignments(Assignments assignments) {
		this.assignments = assignments;
	}
	
	@Override
    public String toString()
    {
    	return "Student ID: " + idNumber + ", Name: " + name + ", Grade: " + grade + ", GPA: " + gpa;
    }
}
