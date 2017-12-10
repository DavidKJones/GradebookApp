package gradebookapp;
import java.util.ArrayList;

public class GradeBookTest{

	public static void main(String[] args) {
		createStuff();
	}
	
	public static ArrayList<GradeBook> createStuff() {
		ArrayList<GradeBook> gradebook = new ArrayList<GradeBook>();
		gradebook.add(new TotalPointsGradeBook());
		gradebook.get(0).addStudent(new Student(null, "Mason", "Parry"));
		gradebook.get(0).addStudent(new Student(null, "Bob", "Joe"));
		gradebook.get(0).addStudent(new Student(null, "John", "Doe"));
		gradebook.get(0).addAssignment(new Assignment("Homework 1",25));
		gradebook.get(0).addAssignment(new Assignment("Homework 2",20));
		gradebook.get(0).addAssignment(new Assignment("Test 1",100));
		
		gradebook.add(new CategoryGradebook());
		gradebook.get(1).addStudent(new Student(null, "David", "Jones"));
		gradebook.get(1).addStudent(new Student(null, "Carl", "Jr"));
		gradebook.get(1).addAssignment(new Assignment("Group Project",50));
		gradebook.get(1).addAssignment(new Assignment("Quiz",15));
		return gradebook;
	}
}
