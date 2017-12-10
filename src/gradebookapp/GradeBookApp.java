package gradebookapp;
import java.util.ArrayList;

/**
 * The class that will keep the list of Students
 * @author Ayrton Flores
 */
public class GradeBookApp 
{
	private ArrayList<Student> students;
	
	/**
	 * get all of the students
	 * 
	 * @param none
	 * @return array list of the students
	 */
	public ArrayList<Student> getAllStudents()
	{
		return students;
	}
	
	/**
	 * get a specific student
	 * 
	 * @param index number of the specific student
	 * @return The student at the specific index number
	 */
	public Student getStudent(int index)
	{
		return students.get(index);
	}
	
	/**
	 * Add another student to the list
	 * 
	 * @param student object with desired parameters(2/4)
	 * @return nothing
	 */
	public void addStudent(Student student)
	{
		students.add(student);
	}
}