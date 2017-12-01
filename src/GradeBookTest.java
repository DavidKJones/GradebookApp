import java.util.ArrayList;

public class GradeBookTest {

	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<Student>();
		student.add("S0001","John Doe");
		for(int i = 0;i<student.size();i++) {
			System.out.println(student.get(i).toString());
		}
	}

}
