package gradebook;

import java.util.ArrayList;

public class GradeBookTest {

	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student("S0001", "Johnny Doe", "A+", 4.0));
		student.add(new Student("S0123", "Jane Doe", "C-", 2.4));
		for(int i = 0;i<student.size();i++) {
			System.out.println(student.get(i).toString());
		}
	}

}
