package gradebook;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Student implements Serializable{
	private String idNumber;
	private String name;
	private String grade;
	private double gpa;
	
	public Student(String id, String name, String grade, double gpa) {
		this.idNumber = id;
		this.name = name;
		this.grade = grade;
		this.gpa = gpa;
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
	
	@Override
    public String toString()
    {
    	return "Student ID: " + idNumber + ", Name: " + name + ", Grade: " + grade + ", GPA: " + gpa;
    }
}
