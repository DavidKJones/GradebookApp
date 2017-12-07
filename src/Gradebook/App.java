package Gradebook;

public class App {

	public static void main(String[] args) 
	{
		Gradebook[] gradebooks = new Gradebook[2];
		gradebooks[0] = new CategoryGradebook();
		gradebooks[1] = new TotalPointsGradebook();
		
		gradebooks[0].addStudent(new Student());
		CategoryGradebook gradeBook = (CategoryGradebook)gradebooks[0];
		gradeBook.addCategory(new GradebookCategory("Quiz"));
		gradeBook.addAssignment();
		gradeBook.addAssignment();
		System.out.print(gradeBook.getAssignments().size());
	}

}
