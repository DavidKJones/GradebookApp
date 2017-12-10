package testapp;

import static org.junit.Assert.*;

import gradebookapp.TotalPointsGradeBook;
import gradebookapp.Student;
import gradebookapp.Assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTestCase 
{

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testTotalPointsGradeBook() 
	{
		//Instantiate grade book
		TotalPointsGradeBook gb = new TotalPointsGradeBook("gradebook");
		
		//Instantiate students
		Student student1 = new Student("S001", "Mason", "Johnson");
		Student student2 = new Student("S001", "Jason", "Bourne");
		
		//Instantiate assignments
		Assignment assignment1 = new Assignment("Quiz", 20);
		Assignment assignment2 = new Assignment("Homework", 50);
		Assignment assignment3 = new Assignment("Participation", 15);
		
		//test students list
		gb.addStudent(student1);
		assertEquals(gb.getStudent(0).getFirstName(), "Mason");
		gb.removeStudent(student1);
		assertEquals(gb.getStudents().size(), 0);
		
		//test assignments list
		gb.addAssignment(assignment1);
		gb.addAssignment(assignment2);
		assertEquals(gb.getAssignmentAt(0).getTotalScore(), 20);
		gb.removeAssignmentAt(0);
		assertEquals(gb.getAssignmentAt(0).getName(), "Homework");
		
		gb.addStudent(student2);
		assertEquals(gb.getStudent(0).getAssignments().size(), 1);
		assertEquals(gb.getStudent(0).getAssignment(0).getName(), "Homework");
		gb.addAssignment(assignment3);
		assertEquals(gb.getStudent(0).getAssignment(1).getStudentScore(), 15);
		gb.getStudent(0).getAssignment(1).setStudentScore(0);
		gb.getStudent(0).getAssignment(0).setStudentScore(50);
		assertEquals(100.0, gb.getStudent(0).getAssignment(0).calculatePercentage(), 2.0);
		assertEquals(76.0, gb.calculateStudentPercentage(gb.getStudent(0)), 2.0);
		assertEquals(gb.getGrade(gb.getStudent(0)), "C");
	}
}
